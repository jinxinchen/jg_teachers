package com.jingguan.teacherActivityCheck.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherActivityCheck.dao.VTeacherActivityCheckDao;
import com.jingguan.teacherActivityCheck.po.TTeacherActivityEntity;
import com.jingguan.teacherActivityCheck.po.VTeachersActivityCheckEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/11/13 0013.
 */
@Repository("vTeacherActivityCheckDao")
public class VTeacherActivityCheckDaoImpl extends BaseDao implements VTeacherActivityCheckDao {

    @Override
    public Page<VTeachersActivityCheckEntity> listRecordsByCondition(Page page) {

        return listRecordsByCon(page,VTeachersActivityCheckEntity.class);

    }

    @Override
    public void update(int id, String status) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        TTeacherActivityEntity tTeacherActivityEntity=new TTeacherActivityEntity();
        tTeacherActivityEntity.setId(id);
        tTeacherActivityEntity.setStatus(status);
        session.update(tTeacherActivityEntity);
        transaction.commit();
    }

    @Override
    public List<VTeachersActivityCheckEntity> getLists(Page.FilterModel condition) {
        List<VTeachersActivityCheckEntity> records=null;
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(VTeachersActivityCheckEntity.class);
        criteria.add(complicateSearchOptionAdd( condition,VTeachersActivityCheckEntity.class));
        records=criteria.list();
        transaction.commit();
        return  records;
    }

    @Override
    public void inActivity(TTeacherActivityEntity tTeacherActivityEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        tTeacherActivityEntity.setStatus("审核通过");
        try{
            session.save(tTeacherActivityEntity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }
}
