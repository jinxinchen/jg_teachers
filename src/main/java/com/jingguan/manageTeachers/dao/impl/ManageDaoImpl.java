package com.jingguan.manageTeachers.dao.impl;

import com.jingguan.baseInfo.po.*;
import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.vo.Page;
import com.jingguan.manageTeachers.dao.ManageDao;
import com.jingguan.manageTeachers.po.*;
import com.jingguan.manageTeachers.po.TEducateDegreeEntity;
import com.jingguan.manageTeachers.po.TTeacherBaseinfoEntity;
import com.jingguan.manageTeachers.po.TUsersEntity;
import com.jingguan.manageTeachers.po.TUsersRoleEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈 on 2017/12/12.
 */
@Repository("manageDao")
public class ManageDaoImpl extends BaseDao implements ManageDao {

    @Override
    public List<VTeachersAccountsEntity> getAcoountLists(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,VTeachersAccountsEntity.class);
    }

    @Override
    public List<VManageteachersBaseinfoEntity> getLists(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,VManageteachersBaseinfoEntity.class);
    }

    @Override
    public Page loadTeachers(Page page) {
        return listRecordsByCon(page, VManageteachersBaseinfoEntity.class);
    }

    @Override
    public Page loadRecord(Page page) {
        return listRecordsByCon(page, VTeachersAccountsEntity.class);
    }

    @Override
    public void saveRecord(TUsersEntity user) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);
        transaction.commit();
    }

    @Override
    public void saveTeacherRole(TUsersRoleEntity userRole) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(userRole);
        transaction.commit();
    }

    @Override
    public int editAccount(int id, String account,String password) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TUsersEntity user = session.load(TUsersEntity.class,id);
        //如果account已经存在
        UserDao userDao = new UserDao();
        if(!user.getAccount().equals(account)) {
            Integer user_id = userDao.findUserIdByUserAccount(account);
            if(user_id != null){
                return 201;
            }
        }
        try{
            user.setAccount(account);
            user.setPassword(password);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
            return 0;
        }


    }

    @Override
    public void deleteAccount(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try{
            TUsersEntity user = session.load(TUsersEntity.class,id);
            session.delete(user);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }

    }

    @Override
    public void updateDegree(TEducateDegreeEntity tEducateDegreeEntity,TTeacherBaseinfoUpdate tTeacherBaseinfoUpdate) {
        Session session = getCurrentSession();
        session.beginTransaction();
        session.update(tTeacherBaseinfoUpdate);
        session.saveOrUpdate(tEducateDegreeEntity);
        session.getTransaction().commit();
    }

    @Override
    public VManageteachersBaseinfoEntity getBaseinfoById(Integer id) {
        Session session=getCurrentSession();
        session.beginTransaction();
        List<VManageteachersBaseinfoEntity> baseInfo = session.
                createCriteria(VManageteachersBaseinfoEntity.class).
                add(Restrictions.eq("id",id)).list();
        session.getTransaction().commit();
        return baseInfo.get(0);
    }

    @Override
    public void deleteBaseInfo(Integer userId) {

        Session session=getCurrentSession();
        session.beginTransaction();
        TTeacherBaseinfoUpdate tTeacherBaseinfoUpdate=new TTeacherBaseinfoUpdate();
        tTeacherBaseinfoUpdate.setUserId(userId);
        TEducateDegreeEntity tEducateDegreeEntity=new TEducateDegreeEntity();
        tEducateDegreeEntity.setUserId(userId);

        session.delete(tTeacherBaseinfoUpdate);
        session.delete(tEducateDegreeEntity);

        session.getTransaction().commit();

    }
}
