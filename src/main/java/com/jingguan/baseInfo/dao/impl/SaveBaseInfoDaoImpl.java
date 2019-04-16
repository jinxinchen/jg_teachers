package com.jingguan.baseInfo.dao.impl;

import com.jingguan.baseInfo.dao.SaveBaseInfoDao;
import com.jingguan.baseInfo.po.TTeacherBaseinfoEntity;
import com.jingguan.common.dao.impl.BaseDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈 on 2017/10/28.
 */
@Repository("saveBaseInfoDao")
public class SaveBaseInfoDaoImpl extends BaseDao implements SaveBaseInfoDao {
    @Override
    public int SaveBaseInfo(TTeacherBaseinfoEntity tTeacherBaseinfoEntity, int user_id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        tTeacherBaseinfoEntity.setUserId(user_id);
        tTeacherBaseinfoEntity.setName(tTeacherBaseinfoEntity.getName());
        tTeacherBaseinfoEntity.setGender(tTeacherBaseinfoEntity.getGender());
        tTeacherBaseinfoEntity.setBirthday(tTeacherBaseinfoEntity.getBirthday());
        tTeacherBaseinfoEntity.setEmail(tTeacherBaseinfoEntity.getEmail());
        tTeacherBaseinfoEntity.setIdentityNum(tTeacherBaseinfoEntity.getIdentityNum());
        tTeacherBaseinfoEntity.setAddress(tTeacherBaseinfoEntity.getAddress());
        tTeacherBaseinfoEntity.setPhoneNum(tTeacherBaseinfoEntity.getPhoneNum());
        tTeacherBaseinfoEntity.setIsMoreLangue(tTeacherBaseinfoEntity.getIsMoreLangue());
        //获取当前时间
        tTeacherBaseinfoEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        tTeacherBaseinfoEntity.setStatus(1);


        try{
            session.save(tTeacherBaseinfoEntity);
            transaction.commit();
            return tTeacherBaseinfoEntity.getId();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return 0;
    }
}
