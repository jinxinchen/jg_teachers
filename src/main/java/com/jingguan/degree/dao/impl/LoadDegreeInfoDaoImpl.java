package com.jingguan.degree.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.degree.dao.LoadDegreeInfoDao;
import com.jingguan.degree.po.TEducateDegreeEntity;
import com.jingguan.degree.po.VDegreeInfoEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 陈 on 2017/11/7.
 */
@Repository("loadDegreeInfoDao")
public class LoadDegreeInfoDaoImpl extends BaseDao implements LoadDegreeInfoDao {
    @Override
    public List<TEducateDegreeEntity> loadInfo(int user_id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<TEducateDegreeEntity> info = session.createCriteria(TEducateDegreeEntity.class).add(Restrictions.eq("userId",user_id)).list();
        transaction.commit();
        return info;
    }
}
