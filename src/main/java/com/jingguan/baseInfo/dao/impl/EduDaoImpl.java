package com.jingguan.baseInfo.dao.impl;

import com.jingguan.baseInfo.dao.EduDao;
import com.jingguan.baseInfo.po.TEducationExperienceEntity;
import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 陈 on 2017/10/17.
 */
@Repository("EduDao")
public class EduDaoImpl extends BaseDao implements EduDao {

    @Override
    public List<TEducationExperienceEntity> getLists(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TEducationExperienceEntity.class);
    }

    @Override
    public List<TEducationExperienceEntity> loadEducationExp(int user_id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<TEducationExperienceEntity> eduExp = session.createCriteria(TEducationExperienceEntity.class).add(Restrictions.eq("userId",user_id)).list();
        transaction.commit();
        return eduExp;
    }

    @Override
    public Page findEduExp(Page page) {
        return listRecordsByCon(page, TEducationExperienceEntity.class);
    }

    @Override
    public void inEdu(TEducationExperienceEntity tEducationExperienceEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tEducationExperienceEntity);
        transaction.commit();
    }
}
