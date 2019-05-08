package com.jingguan.sciencePrizeCheck.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.sciencePrize.po.TEducateScientificEntity;
import com.jingguan.sciencePrizeCheck.dao.VTeachersPrizeCheckEntityDao;
import com.jingguan.sciencePrizeCheck.po.TChangeStatus;
import com.jingguan.sciencePrizeCheck.po.VTeachersPrizeCheckEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/11/19 0019.
 */
@Repository("vTeachersPrizeCheckEntityDao")
public class VTeacherPrizeCheckEntityDaoImpl extends BaseDao implements VTeachersPrizeCheckEntityDao {

    @Override
    public Page<VTeachersPrizeCheckEntity> listRecordsByCondition(Page page) {
        return listRecordsByCon(page,VTeachersPrizeCheckEntity.class);

    }

    @Override
    public void update(TEducateScientificEntity tEducateScientificEntity) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        session.update(tEducateScientificEntity);
        transaction.commit();
    }

    @Override
    public List<VTeachersPrizeCheckEntity> getLists(Page.FilterModel condition) {
        List<VTeachersPrizeCheckEntity> records=null;
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Criteria criteria=session.createCriteria(VTeachersPrizeCheckEntity.class);
        criteria.add(complicateSearchOptionAdd( condition,VTeachersPrizeCheckEntity.class));
        records=criteria.list();
        transaction.commit();
        return  records;
    }
}
