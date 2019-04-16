package com.jingguan.teacherActivity.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.teacherActivity.dao.CertificateUploadDao;
import com.jingguan.teacherActivity.po.CertificateUpload;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/10 0010.
 */
@Repository("certificateUploadDao")
public class CertificateUploadDaoImpl  extends BaseDao implements CertificateUploadDao {
    @Override
    public void updatePath(CertificateUpload record) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(record);
        transaction.commit();
    }

    @Override
    public String getPath(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<CertificateUpload> list;
        list=session.createCriteria(CertificateUpload.class).add(Restrictions.eq("id",id)).list();
        CertificateUpload certificateUpload=null;
        if(list.size()>=1){
            certificateUpload=list.get(0);
        }
        transaction.commit();
        return certificateUpload.getCertificate();
    }
}
