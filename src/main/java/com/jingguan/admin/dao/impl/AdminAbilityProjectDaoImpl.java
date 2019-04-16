package com.jingguan.admin.dao.impl;

import com.jingguan.admin.dao.AdminAbilityProjectDao;
import com.jingguan.admin.po.TAbilityProjectEntity;
import com.jingguan.admin.po.VAdminAbilityprojectEntity;
import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 陈 on 2017/11/20.
 */
@Repository("adminabilityProjectDao")
public class AdminAbilityProjectDaoImpl extends BaseDao implements AdminAbilityProjectDao{
    @Override
    public Page loadAbilityProject(Page page) {
        try {
            return listRecordsByCon(page, VAdminAbilityprojectEntity.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return page;
    }

    @Override
    public int passAbilityProject(int id) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        TAbilityProjectEntity tAbilityProjectEntity = session.load(TAbilityProjectEntity.class,id);
        tAbilityProjectEntity.setStatus("审核通过");
        try{
            session.update(tAbilityProjectEntity);
            transaction.commit();
            return 200;
        }catch (Exception e){
            transaction.rollback();
        }
        return 0;
    }

    @Override
    public void inAbilityProject(TAbilityProjectEntity tAbilityProjectEntity) {
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        tAbilityProjectEntity.setStatus("审核通过");
        try{
            session.save(tAbilityProjectEntity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    @Override
    public List<VAdminAbilityprojectEntity> getAbilityProjectLists(Page.FilterModel condition) {
        List<VAdminAbilityprojectEntity> records=null;
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(VAdminAbilityprojectEntity.class);
        criteria.add(complicateSearchOptionAdd( condition,VAdminAbilityprojectEntity.class));
        records=criteria.list();
        transaction.commit();
        return  records;
    }

}
