package com.jingguan.technology.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.technology.dao.InTechnologyDao;
import com.jingguan.technology.po.TTechnologyEntity;
import com.jingguan.uploadExcel.controller.test2;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 陈 on 2017/10/25.
 */
@Repository("inTechnologyDao")
public class InTechnologyDaoImpl extends BaseDao implements InTechnologyDao{


    @Override
    public void InTechnology(TTechnologyEntity tTechnologyEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tTechnologyEntity);
        transaction.commit();
    }
}
