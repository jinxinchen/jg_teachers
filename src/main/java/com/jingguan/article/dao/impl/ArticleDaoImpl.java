package com.jingguan.article.dao.impl;

import com.jingguan.article.dao.ArticleDao;
import com.jingguan.article.po.TArticleEntity;
import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.tool.MergeTool;
import com.jingguan.common.vo.Page;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 陈 on 2017/11/11.
 */
@Repository("articleDao")
public class ArticleDaoImpl extends BaseDao implements ArticleDao {
    @Override
    public Page loadArticle(Page page) {
        return listRecordsByCon(page, TArticleEntity.class);
    }

    @Override
    public List<TArticleEntity> getList(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TArticleEntity.class);
    }

    @Override
    public int addArticle(int user_id, TArticleEntity tArticleEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        tArticleEntity.setUserId(user_id);
        tArticleEntity.setStatus("未审核");
        try{
            session.save(tArticleEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int editArticle(int user_id, TArticleEntity tArticleEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //获取status
        TArticleEntity tArticleEntity1 = session.load(TArticleEntity.class,tArticleEntity.getId());

        try {
            tArticleEntity.setUserId(user_id);
            MergeTool.mergeObject(tArticleEntity,tArticleEntity1);
            session.update(tArticleEntity1);
            transaction.commit();
            return 200;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int deleteArticle(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try{
            TArticleEntity tArticleEntity = session.load(TArticleEntity.class,id);
            session.delete(tArticleEntity);
            transaction.commit();
            return 200;
        }catch (Exception E){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public void uploadFile(String fileName, String filename, int id, int user_id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TArticleEntity tArticleEntity = session.load(TArticleEntity.class,id);
        tArticleEntity.setArticleSrc(fileName);
        tArticleEntity.setFileName(filename);

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tArticleEntity.setUploadTime(ft.format(dNow).toString());

        session.update(tArticleEntity);
        transaction.commit();

    }

    @Override
    public String getArticleSrcById(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
//        TArticleEntity tArticleEntity = session.load(TArticleEntity.class,id);
        List<TArticleEntity> tArticleEntity = session.createCriteria(TArticleEntity.class).add(Restrictions.eq("id",id)).list();

        transaction.commit();
        return tArticleEntity.get(0).getArticleSrc();
    }

    @Override
    public void inArticle(TArticleEntity tArticleEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(tArticleEntity);
        transaction.commit();
    }
}
