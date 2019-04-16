package com.jingguan.sciencePrize.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.sciencePrize.dao.UploadFilePoDao;
import com.jingguan.sciencePrize.po.UploadFilePo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/10 0010.
 */
@Repository("tUploadFilePoDao")
public class UploadFilePoDaoImpl extends BaseDao implements UploadFilePoDao {
    @Override
    public void updatePath(UploadFilePo uploadFilePo) {

        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(uploadFilePo);
        transaction.commit();
    }

    @Override
    public String getPath(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<UploadFilePo> list;
        list=session.createCriteria(UploadFilePo.class).add(Restrictions.eq("id",id)).list();
        UploadFilePo uploadFilePo=null;
        if(list.size()>=1){
            uploadFilePo=list.get(0);
        }
        transaction.commit();
        return uploadFilePo.getEvidencePath();
    }
}
