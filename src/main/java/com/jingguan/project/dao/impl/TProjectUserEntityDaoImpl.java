package com.jingguan.project.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.project.po.TProjectUserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
@Repository("tProjectUserEntityDao")
public class TProjectUserEntityDaoImpl extends BaseDao implements com.jingguan.project.dao.TProjectUserEntityDao {
    @Override
    public void saveRecords(TProjectUserEntity record) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.save(record);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        }
    }

    @Override
    public void updateRecords(TProjectUserEntity record) {

        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(record);
        transaction.commit();
    }

    @Override
    public void deleteRecords(TProjectUserEntity record) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.delete(record);
        transaction.commit();
    }

    @Override
    public TProjectUserEntity getRecords(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<TProjectUserEntity> list;
        list=session.createCriteria(TProjectUserEntity.class).add(Restrictions.eq("id",id)).list();
        TProjectUserEntity tProjectUserEntity=null;
        if(list.size()>=1){
            tProjectUserEntity=list.get(0);
        }
        transaction.commit();
        return tProjectUserEntity;
    }

    @Override
    public List<TProjectUserEntity> findRecords(Integer userid) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<TProjectUserEntity> list=null;
        list=session.createCriteria(TProjectUserEntity.class).add(Restrictions.eq("userId",userid)).list();
        transaction.commit();
        return  list;
    }
}
