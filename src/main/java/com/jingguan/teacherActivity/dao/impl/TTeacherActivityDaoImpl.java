package com.jingguan.teacherActivity.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherActivity.po.TTeacherActivityEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/11/13 0013.
 */
@Repository("tTeacherActivityDao")
public class TTeacherActivityDaoImpl extends BaseDao implements com.jingguan.teacherActivity.dao.TTeacherActivityDao {
    @Override
    public Page<TTeacherActivityEntity> listRecordsByCondition(Page page) {

        return listRecordsByCon(page,TTeacherActivityEntity.class);

    }

    @Override
    public List<TTeacherActivityEntity> getLists(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TTeacherActivityEntity.class);
    }

    @Override
    public void saveRecords(TTeacherActivityEntity tTeacherActivityEntity) {

        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.save(tTeacherActivityEntity);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }

    }

    @Override
    public void updateRecords(TTeacherActivityEntity tTeacherActivityEntity) {

        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(tTeacherActivityEntity);
        transaction.commit();
    }

    @Override
    public void deleteRecords(TTeacherActivityEntity tTeacherActivityEntity) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.delete(tTeacherActivityEntity);
        transaction.commit();
    }

    @Override
    public TTeacherActivityEntity getRecords(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<TTeacherActivityEntity> list;
        list=session.createCriteria(TTeacherActivityEntity.class).add(Restrictions.eq("id",id)).list();
        TTeacherActivityEntity tTeacherActivityEntity=null;
        if(list.size()>=1){
            tTeacherActivityEntity=list.get(0);
        }
        transaction.commit();
        return tTeacherActivityEntity;
    }
}
