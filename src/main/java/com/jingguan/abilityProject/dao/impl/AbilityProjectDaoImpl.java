package com.jingguan.abilityProject.dao.impl;

import com.jingguan.abilityProject.dao.AbilityProjectDao;
import com.jingguan.abilityProject.po.TAbilityProjectEntity;

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
 * Created by 陈 on 2017/11/30.
 */
@Repository("abilityProjectDao")
public class AbilityProjectDaoImpl extends BaseDao implements AbilityProjectDao {
    @Override
    public Page loadAbilityProject(Page page) {
        return listRecordsByCon(page, TAbilityProjectEntity.class);
    }

    @Override
    public List<TAbilityProjectEntity> getList(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition, TAbilityProjectEntity.class);
    }

    @Override
    public int editAbilityProject(int user_id, TAbilityProjectEntity tAbilityProjectEntity) {
        Session session=null;
        session= getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //获取status
        TAbilityProjectEntity tAbilityProjectEntity1 = session.load(TAbilityProjectEntity.class,tAbilityProjectEntity.getId());
        MergeTool.mergeObject(tAbilityProjectEntity,tAbilityProjectEntity1);
        session.update(tAbilityProjectEntity1);
        transaction.commit();
        return 200;
    }

    @Override
    public int addAbilityProject(int user_id, TAbilityProjectEntity tAbilityProjectEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        tAbilityProjectEntity.setUserId(user_id);
        tAbilityProjectEntity.setStatus("未审核");

        try {
            session.save(tAbilityProjectEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int deleteAbilityProject(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TAbilityProjectEntity tAbilityProjectEntity = session.load(TAbilityProjectEntity.class,id);
        try{
            session.delete(tAbilityProjectEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }

        return 0;
    }

    @Override
    public String getAbilityProjectSrcById(int id) {
        System.out.println(id);
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

//        TAbilityProjectEntity tAbilityProjectEntity = session.load(TAbilityProjectEntity.class,id);
        List<TAbilityProjectEntity> tAbilityProjectEntity = session.createCriteria(TAbilityProjectEntity.class).add(Restrictions.eq("id",id)).list();

        transaction.commit();
//        session.close();

        return tAbilityProjectEntity.get(0).getPrizeEvidenceSrc();
    }

    @Override
    public void uploadFile(String fileName, String filename, int id, int user_id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TAbilityProjectEntity tArticleEntity = session.load(TAbilityProjectEntity.class,id);
        tArticleEntity.setPrizeEvidenceSrc(fileName);
        tArticleEntity.setFileName(filename);

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tArticleEntity.setUploadTime(ft.format(dNow).toString());

        session.update(tArticleEntity);
        transaction.commit();
    }

    @Override
    public void inAbilityProject(TAbilityProjectEntity tAbilityProjectEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(tAbilityProjectEntity);
        transaction.commit();
    }
}
