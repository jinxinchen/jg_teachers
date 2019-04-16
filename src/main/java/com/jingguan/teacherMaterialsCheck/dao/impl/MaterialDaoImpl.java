package com.jingguan.teacherMaterialsCheck.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterialsCheck.dao.MaterialDao;
import com.jingguan.teacherMaterialsCheck.po.VTeacherMaterialsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2018/2/9 0009.
 */
@Repository("materialAdminDao")
public class MaterialDaoImpl extends BaseDao implements MaterialDao {


    @Override
    public List<VTeacherMaterialsEntity> getList(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,VTeacherMaterialsEntity.class);
    }

    @Override
    public Page<VTeacherMaterialsEntity> loadMaterial(Page page) {
        return listRecordsByCon(page, VTeacherMaterialsEntity.class);
    }

    @Override
    public void uploadFile(String fileName, String filename, int id) {

    }

    @Override
    public String getMaterialSrcById(int id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<VTeacherMaterialsEntity> list;
        list=session.createCriteria(VTeacherMaterialsEntity.class).add(Restrictions.eq("id",id)).list();
        VTeacherMaterialsEntity vTeacherMaterialsEntity=null;
        if(list.size()>=1){
            vTeacherMaterialsEntity=list.get(0);
        }else{
            return null;
        }
        transaction.commit();
        return vTeacherMaterialsEntity.getFile();
    }
}
