package com.jingguan.admin.dao.impl;

import com.jingguan.admin.dao.AdminCopyRightDao;
import com.jingguan.admin.po.TCopyrightEntity;
import com.jingguan.admin.po.VAdminCopyrightEntity;
import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Created by 陈 on 2017/11/15.
 */
@Repository("adminCopyRightDao")
public class AdminCopyRightDaoImpl extends BaseDao implements AdminCopyRightDao{
    @Override
    public Page loadAdminCopyRight(Page page) {
        return listRecordsByCon(page, VAdminCopyrightEntity.class);
//        return null;
    }

    @Override
    public int passCopyRight(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TCopyrightEntity tCopyrightEntity = session.load(TCopyrightEntity.class,id);
        String res = "审核通过";
        tCopyrightEntity.setStatus(res);
        try{
            session.update(tCopyrightEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public void inCopyRight(TCopyrightEntity tCopyrightEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        tCopyrightEntity.setStatus("审核通过");
        try{
            session.save(tCopyrightEntity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }
}
