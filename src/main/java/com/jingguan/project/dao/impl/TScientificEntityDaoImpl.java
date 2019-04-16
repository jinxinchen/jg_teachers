package com.jingguan.project.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.project.dao.TScientificEntityDao;
import com.jingguan.project.po.TScientificEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
@Repository("tScientificEntityDao")
public class TScientificEntityDaoImpl extends BaseDao implements TScientificEntityDao {


    @Override
    public Page<TScientificEntity> listRecordsByCondition(Page page) {
        return listRecordsByCon(page,TScientificEntity.class);
    }

    @Override
    public List<TScientificEntity> getLists(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TScientificEntity.class);
    }

    @Override
    public int saveRecords(TScientificEntity record) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        int id=0;
        try {
           session.save(record);
           id = record.getId();
           transaction.commit();
       }
       catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

       return id;

    }

    @Override
    public void updateRecords(TScientificEntity record) {

        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(record);
        transaction.commit();
    }

    @Override
    public void deleteRecords(TScientificEntity record) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.delete(record);
        transaction.commit();
    }

    @Override
    public TScientificEntity getRecords(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<TScientificEntity> list;
        list=session.createCriteria(TScientificEntity.class).add(Restrictions.eq("id",id)).list();
        TScientificEntity tScientificEntity=null;
        if(list.size()>=1){
            tScientificEntity=list.get(0);
        }
        transaction.commit();
        return tScientificEntity;
    }
}
