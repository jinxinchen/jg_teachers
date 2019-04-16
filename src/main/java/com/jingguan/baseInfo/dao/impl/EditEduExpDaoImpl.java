package com.jingguan.baseInfo.dao.impl;

import com.jingguan.baseInfo.dao.EditEduExpDao;
import com.jingguan.baseInfo.po.TEducationExperienceEntity;
import com.jingguan.common.dao.impl.BaseDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Created by 陈 on 2017/10/18.
 */
@Repository("editEduExpDao")
public class EditEduExpDaoImpl extends BaseDao implements EditEduExpDao {

    @Override
    public int editEduExp(int id, Integer user_id, String school, String major, String education,String entrance ,String graduationYear,String abroad) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TEducationExperienceEntity tEducationExperienceEntity =  new TEducationExperienceEntity();
        tEducationExperienceEntity.setId(id);
        tEducationExperienceEntity.setSchool(school);
        tEducationExperienceEntity.setMajor(major);
        tEducationExperienceEntity.setEducation(education);
        tEducationExperienceEntity.setEntrance(entrance);
        tEducationExperienceEntity.setGraduationYear(graduationYear);
        tEducationExperienceEntity.setUserId(user_id);
        tEducationExperienceEntity.setAbroad(abroad);
        tEducationExperienceEntity.setStatus(1);
        try{
            session.update(tEducationExperienceEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 199;
    }
}
