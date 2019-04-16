package com.jingguan.teacherMaterials.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterials.dao.TTeachingMaterialEntityDao;
import com.jingguan.teacherMaterials.po.TTeachingMaterialEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/17 0017.
 */

@Repository("tTeachingMaterialEntityDao")
public class TTeachingMaterialEntityDaoImpl extends BaseDao implements TTeachingMaterialEntityDao {


    @Override
    public List<TTeachingMaterialEntity> getLists(Page.FilterModel condition) {
        return getListRecordsByCondtions(condition,TTeachingMaterialEntity.class);
    }

    @Override
    public Page<TTeachingMaterialEntity> listRecordsByCondition(Page page) {
        return listRecordsByCon(page,TTeachingMaterialEntity.class);
    }

    @Override
    public void saveRecords(TTeachingMaterialEntity tTeachingMaterialEntity) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.save(tTeachingMaterialEntity);
        transaction.commit();
    }

    @Override
    public void updateRecords(TTeachingMaterialEntity tTeachingMaterialEntity) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(tTeachingMaterialEntity);
        transaction.commit();
    }

    @Override
    public void deleteRecords(TTeachingMaterialEntity tTeachingMaterialEntity) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.delete(tTeachingMaterialEntity);
        transaction.commit();
    }

    @Override
    public TTeachingMaterialEntity getRecords(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<TTeachingMaterialEntity> list;
        list=session.createCriteria(TTeachingMaterialEntity.class).add(Restrictions.eq("id",id)).list();
        TTeachingMaterialEntity tTeachingMaterialEntity=null;
        if(list.size()>=1){
            tTeachingMaterialEntity=list.get(0);
        }
        transaction.commit();
        return tTeachingMaterialEntity;
    }
}
