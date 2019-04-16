package com.jingguan.teachingArchives.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.teachingArchives.dao.TeachingArchivesDao;
import com.jingguan.teachingArchives.po.TAdminTeachingMaterialsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 陈 on 2018/6/16.
 */
@Repository("adminTeachingArchivesDaoInpl")
public class TeachingArchivesDaoInpl  extends BaseDao implements TeachingArchivesDao{
    @Override
    public Page loadMaterial(Page page) {
        return listRecordsByCon(page, TAdminTeachingMaterialsEntity.class);
    }

    @Override
    public int addMaterial(String name,String type,String status) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TAdminTeachingMaterialsEntity tAdminTeachingMaterialsEntity = new TAdminTeachingMaterialsEntity();
        tAdminTeachingMaterialsEntity.setName(name);
        tAdminTeachingMaterialsEntity.setType(type);
        tAdminTeachingMaterialsEntity.setStatus(status);
        try{
            session.save(tAdminTeachingMaterialsEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int editMaterial(int id, String name,String type) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //获取status
        //Session session1 = getCurrentSession();
        //Transaction transaction1 = session1.beginTransaction();
        TAdminTeachingMaterialsEntity tAdminTeachingMaterialsEntity1 = session.load(TAdminTeachingMaterialsEntity.class,id);
        //transaction1.commit();
        TAdminTeachingMaterialsEntity tAdminTeachingMaterialsEntity = session.load(TAdminTeachingMaterialsEntity.class,id);
        tAdminTeachingMaterialsEntity.setName(name);
        tAdminTeachingMaterialsEntity.setType(type);
        tAdminTeachingMaterialsEntity.setStatus(tAdminTeachingMaterialsEntity1.getStatus());
        tAdminTeachingMaterialsEntity.setFileSrc(tAdminTeachingMaterialsEntity1.getFileSrc());
        tAdminTeachingMaterialsEntity.setTime(tAdminTeachingMaterialsEntity1.getTime());
        tAdminTeachingMaterialsEntity.setFileName(tAdminTeachingMaterialsEntity1.getFileName());

        try{
            session.update(tAdminTeachingMaterialsEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public int deleteMaterial(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try{
            TAdminTeachingMaterialsEntity tAdminTeachingMaterialsEntity = session.load(TAdminTeachingMaterialsEntity.class,id);
            session.delete(tAdminTeachingMaterialsEntity);
            transaction.commit();
            return 200;
        }catch (Exception E){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public void uploadFile(String fileName, String filename, int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TAdminTeachingMaterialsEntity tAdminTeachingMaterialsEntity = session.load(TAdminTeachingMaterialsEntity.class,id);
        tAdminTeachingMaterialsEntity.setFileSrc(fileName);
        tAdminTeachingMaterialsEntity.setFileName(filename);

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tAdminTeachingMaterialsEntity.setTime(ft.format(dNow).toString());

        session.update(tAdminTeachingMaterialsEntity);
        transaction.commit();
    }

    @Override
    public String getMaterialSrcById(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

//        TAdminTeachingMaterialsEntity tAdminTeachingMaterialsEntity = session.load(TAdminTeachingMaterialsEntity.class,id);
        List<TAdminTeachingMaterialsEntity> tAdminTeachingMaterialsEntity = session.createCriteria(TAdminTeachingMaterialsEntity.class).add(Restrictions.eq("id",id)).list();

        transaction.commit();
        return tAdminTeachingMaterialsEntity.get(0).getFileSrc();
    }
}
