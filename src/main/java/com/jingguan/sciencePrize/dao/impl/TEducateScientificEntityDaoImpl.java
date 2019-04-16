package com.jingguan.sciencePrize.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.sciencePrize.dao.TEducateScientificEntityDao;
import com.jingguan.sciencePrize.po.TEducateScientificEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/11/18 0018.
 */
@Repository("tEducateScientificEntityDao")
public class TEducateScientificEntityDaoImpl extends BaseDao implements TEducateScientificEntityDao {

    @Override
    public Page<TEducateScientificEntity> listRecordsByCondition(Page page) {
        return listRecordsByCon(page,TEducateScientificEntity.class);
    }

    @Override
    public List<TEducateScientificEntity> list(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TEducateScientificEntity.class);
    }

    @Override
    public void saveRecords(TEducateScientificEntity record) {
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
    public void updateRecords(TEducateScientificEntity record) {

        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(record);
        transaction.commit();
    }

    @Override
    public void deleteRecords(TEducateScientificEntity record) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.delete(record);
        transaction.commit();
    }

    @Override
    public TEducateScientificEntity getRecords(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<TEducateScientificEntity> list;
        list=session.createCriteria(TEducateScientificEntity.class).add(Restrictions.eq("id",id)).list();
        TEducateScientificEntity tTeacherActivityEntity=null;
        if(list.size()>=1){
            tTeacherActivityEntity=list.get(0);
        }
        transaction.commit();
        return tTeacherActivityEntity;
    }

    @Override
    public void inSciencePrizeTemp(TEducateScientificEntity tEducateScientificEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tEducateScientificEntity);
        transaction.commit();
    }
}
