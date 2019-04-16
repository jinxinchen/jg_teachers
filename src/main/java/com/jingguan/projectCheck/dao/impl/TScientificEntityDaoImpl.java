package com.jingguan.projectCheck.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.project.po.VProjectUserEntity;
import com.jingguan.projectCheck.dao.TScientificEntityDao;
import com.jingguan.projectCheck.po.TScientificEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/18 0018.
 */

@Repository("tCheckScientificEntityDao")
public class TScientificEntityDaoImpl extends BaseDao implements TScientificEntityDao {
    @Override
    public Page<TScientificEntity> listRecordsByCondition(Page page) {
        return listRecordsByCon(page,TScientificEntity.class);
    }

    @Override
    public String getNumber(int projectId) {
        String name="";
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();

        List<VProjectUserEntity> list=session.createCriteria(VProjectUserEntity.class).add(Restrictions.eq("projectId",projectId)).add(Restrictions.eq("isPrincipal","是")).list();
        if(list.size()!=0){
            name=list.get(0).getName();
        }
        transaction.commit();
        return name;
    }

    @Override
    public List<TScientificEntity> getLists(Page.FilterModel condition) {
        List<TScientificEntity> records=null;
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(TScientificEntity.class);
        criteria.add(complicateSearchOptionAdd( condition,TScientificEntity.class));
        records=criteria.list();
        transaction.commit();
        return  records;
    }
}
