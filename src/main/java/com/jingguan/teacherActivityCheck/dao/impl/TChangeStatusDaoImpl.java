package com.jingguan.teacherActivityCheck.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.teacherActivityCheck.dao.TChangeStatusDao;
import com.jingguan.teacherActivityCheck.po.TChangeStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/17 0017.
 */

@Repository("tAChangeStatusDaoImpl")
public class TChangeStatusDaoImpl extends BaseDao implements TChangeStatusDao {
    @Override
    public void update(TChangeStatus record) {

        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(record);
        transaction.commit();
    }

    @Override
    public TChangeStatus getRecords(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<TChangeStatus> list;
        list=session.createCriteria(TChangeStatus.class).add(Restrictions.eq("id",id)).list();
        TChangeStatus tChangeStatus=null;
        if(list.size()>=1){
            tChangeStatus=list.get(0);
        }
        transaction.commit();
        return tChangeStatus;
    }
}
