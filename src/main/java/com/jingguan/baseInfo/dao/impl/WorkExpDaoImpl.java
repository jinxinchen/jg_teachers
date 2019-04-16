package com.jingguan.baseInfo.dao.impl;

import com.jingguan.baseInfo.dao.WorkExpDao;
import com.jingguan.baseInfo.po.TEducationExperienceEntity;
import com.jingguan.baseInfo.po.TWorkExperienceEntity;
import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 陈 on 2017/10/29.
 */
@Repository("workExpDao")
public class WorkExpDaoImpl extends BaseDao implements WorkExpDao{
    @Override
    public Page loadWorkExp(Page page) {
        return listRecordsByCon(page, TWorkExperienceEntity.class);
    }

    @Override
    public List<TWorkExperienceEntity> getLists(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TWorkExperienceEntity.class);
    }

    @Override
    public void addWorkExp(TWorkExperienceEntity tWorkExperienceEntity,int user_id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        tWorkExperienceEntity.setUserId(user_id);
        tWorkExperienceEntity.setStatus(1);

        session.save(tWorkExperienceEntity);
        transaction.commit();
    }

    @Override
    public void editWorkExp(TWorkExperienceEntity tWorkExperienceEntity,int user_id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        tWorkExperienceEntity.setUserId(user_id);
        session.update(tWorkExperienceEntity);
        transaction.commit();
    }

    @Override
    public void deleteWorkExp(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            TWorkExperienceEntity tWorkExperienceEntity = session.load(TWorkExperienceEntity.class,id);
            session.delete(tWorkExperienceEntity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    @Override
    public void inWork(TWorkExperienceEntity tWorkExperienceEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tWorkExperienceEntity);
        transaction.commit();
    }
}
