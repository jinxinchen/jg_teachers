package com.jingguan.projectCheck.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.projectCheck.dao.TChangeStatusDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/18 0018.
 */

@Repository("tPChangeStatusDao")
public class TChangeStatusDaoImpl extends BaseDao implements TChangeStatusDao {
    @Override
    public void update(com.jingguan.projectCheck.po.TChangeStatus record) {

        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(record);
        transaction.commit();
    }

    @Override
    public com.jingguan.projectCheck.po.TChangeStatus getRecords(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<com.jingguan.projectCheck.po.TChangeStatus> list;
        list=session.createCriteria(com.jingguan.projectCheck.po.TChangeStatus.class).add(Restrictions.eq("id",id)).list();
        com.jingguan.projectCheck.po.TChangeStatus tChangeStatus=null;
        if(list.size()>=1){
            tChangeStatus=list.get(0);
        }
        transaction.commit();
        return tChangeStatus;
    }
}
