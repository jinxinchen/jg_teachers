package com.jingguan.project.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.project.dao.SrcFileManDao;
import com.jingguan.project.po.SrcFileMan;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/13 0013.
 */
@Repository("srcFileManDao")
public class SrcFileManDaoImpl extends BaseDao implements SrcFileManDao {

    @Override
    public void updateRecords(SrcFileMan record) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(record);
        transaction.commit();
    }


    @Override
    public SrcFileMan getRecords(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<SrcFileMan> list;
        list=session.createCriteria(SrcFileMan.class).add(Restrictions.eq("id",id)).list();
        SrcFileMan srcFileMan=null;
        if(list.size()>=1){
            srcFileMan=list.get(0);
        }
        transaction.commit();
        return srcFileMan;
    }

    @Override
    public String getEndPath(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<SrcFileMan> list;
        list=session.createCriteria(SrcFileMan.class).add(Restrictions.eq("id",id)).list();
        SrcFileMan srcFileMan=null;
        if(list.size()>=1){
            srcFileMan=list.get(0);
        }
        transaction.commit();
        return srcFileMan.getEndScientificEvidenceSrc();
    }

    @Override
    public String getCreatePath(Integer id) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<SrcFileMan> list;
        list=session.createCriteria(SrcFileMan.class).add(Restrictions.eq("id",id)).list();
        SrcFileMan srcFileMan=null;
        if(list.size()>=1){
            srcFileMan=list.get(0);
        }
        transaction.commit();
        return srcFileMan.getCreateScientificEvidenceSrc();
    }
}
