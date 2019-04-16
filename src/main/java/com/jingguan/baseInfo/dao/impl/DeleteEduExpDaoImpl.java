package com.jingguan.baseInfo.dao.impl;

import com.jingguan.baseInfo.dao.DeleteEduExpDao;
import com.jingguan.baseInfo.po.TEducationExperienceEntity;
import com.jingguan.common.dao.impl.BaseDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Created by 陈 on 2017/10/18.
 */
@Repository("deleteEduExpDao")
public class DeleteEduExpDaoImpl extends BaseDao implements DeleteEduExpDao{

    @Override
    public int deleteEduExp(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try{
            TEducationExperienceEntity tEducationExperienceEntity =session.load(TEducationExperienceEntity.class,id);
            session.delete(tEducationExperienceEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 199;

    }
}
