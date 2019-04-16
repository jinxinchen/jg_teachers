package com.jingguan.admin.dao.impl;

import com.jingguan.admin.dao.AdminArticleDao;
import com.jingguan.admin.po.TArticleEntity;
import com.jingguan.admin.po.VAdminArticleEntity;
import com.jingguan.admin.po.VAdminCopyrightEntity;
import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 陈 on 2017/11/14.
 */
@Repository("adminArticleDao")
public class AdminArticleDaoImpl extends BaseDao implements AdminArticleDao {

    @Override
    public Page loadAdminArticle(Page page) {
        return listRecordsByCon(page, VAdminArticleEntity.class);
    }

    @Override
    public int passArticle(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TArticleEntity tArticleEntity = session.load(TArticleEntity.class,id);
        String res = "审核通过";
        tArticleEntity.setStatus(res);
        try{
            session.update(tArticleEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public List<VAdminArticleEntity> getLists(Page.FilterModel condition) {
        List<VAdminArticleEntity> records=null;
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(VAdminArticleEntity.class);
        criteria.add(complicateSearchOptionAdd( condition,VAdminArticleEntity.class));
        records=criteria.list();
        transaction.commit();
        return  records;
    }

    @Override
    public List<VAdminCopyrightEntity> getCopyRightLists(Page.FilterModel condition) {
        List<VAdminCopyrightEntity> records=null;
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(VAdminCopyrightEntity.class);
        criteria.add(complicateSearchOptionAdd( condition,VAdminCopyrightEntity.class));
        records=criteria.list();
        transaction.commit();
        return  records;
    }

    @Override
    public void inArticle(TArticleEntity tArticleEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        tArticleEntity.setStatus("审核通过");
        try{
            session.save(tArticleEntity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }
}
