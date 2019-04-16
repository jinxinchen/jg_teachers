package com.jingguan.degree.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.degree.dao.SaveDegreeInfoDao;
import com.jingguan.degree.po.TEducateDegreeEntity;
import com.jingguan.degree.po.VDegreeInfoEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * Created by 陈 on 2017/11/7.
 */
@Repository("saveDegreeInfoDao")
public class SaveDegreeInfoDaoImpl extends BaseDao implements SaveDegreeInfoDao{

    @Override
    public int saveDegreeInfo(TEducateDegreeEntity tEducateDegreeEntity, int user_id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();


        tEducateDegreeEntity.setUserId(user_id);
        int id = (int) session.save(tEducateDegreeEntity);
        transaction.commit();
        return id;
    }
}
