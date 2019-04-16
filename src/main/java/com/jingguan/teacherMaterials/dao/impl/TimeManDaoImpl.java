package com.jingguan.teacherMaterials.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterials.dao.TimeManDao;
import com.jingguan.teacherMaterials.po.TimeMan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/17 0017.
 */

@Repository("timeManDao")
public class TimeManDaoImpl extends BaseDao implements TimeManDao {
    @Override
    public void updateRecords(TimeMan tTeachingMaterialEntity) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(tTeachingMaterialEntity);
        transaction.commit();
    }

    @Override
    public Page<TimeMan> listRecordsByCondition(Page page) {
        return listRecordsByCon(page,TimeMan.class);
    }

    @Override
    public TimeMan getRecords(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<TimeMan> list;
        list=session.createCriteria(TimeMan.class).add(Restrictions.eq("id",id)).list();
        TimeMan timeMan=null;
        if(list.size()>=1){
            timeMan=list.get(0);
        }
        transaction.commit();
        return timeMan;
    }
}
