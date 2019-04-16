package com.jingguan.teachingMaterialsInAdmin.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.teachingMaterialsInAdmin.dao.MaterialDao;
import com.jingguan.teachingMaterialsInAdmin.po.TAdminTeachingMaterialsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈 on 2017/12/23.
 */
@Repository("adminTeachingMaterialDao")
public class MaterialDaoImpl extends BaseDao implements MaterialDao {
    @Override
    public Page loadMaterial(Page page) {
        return listRecordsByCon(page, TAdminTeachingMaterialsEntity.class);
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

        TAdminTeachingMaterialsEntity tAdminTeachingMaterialsEntity = session.load(TAdminTeachingMaterialsEntity.class,id);
        transaction.commit();
        return tAdminTeachingMaterialsEntity.getFileSrc();
    }

    @Override
    public int addMaterial(String name) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TAdminTeachingMaterialsEntity tAdminTeachingMaterialsEntity = new TAdminTeachingMaterialsEntity();
        tAdminTeachingMaterialsEntity.setName(name);
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
    public int editMaterial(int id, String name) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //获取status
        TAdminTeachingMaterialsEntity tAdminTeachingMaterialsEntity1 = session.load(TAdminTeachingMaterialsEntity.class,id);

        TAdminTeachingMaterialsEntity tAdminTeachingMaterialsEntity = session.load(TAdminTeachingMaterialsEntity.class,id);
        tAdminTeachingMaterialsEntity.setName(name);
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
}
