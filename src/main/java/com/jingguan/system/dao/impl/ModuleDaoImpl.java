package com.jingguan.system.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.system.dao.ModuleDao;
import com.jingguan.system.po.TModulesEntity;
import com.jingguan.system.po.TUsersRoleEntity;
import com.jingguan.system.po.VUserModulesEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 陈 on 2017/10/14.
 */
@Repository("moduleDao")
public class ModuleDaoImpl extends BaseDao implements ModuleDao{
    @Override
    public List<VUserModulesEntity> listModuleByUserAccount(int user_id) {
        Session session = getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<VUserModulesEntity> modules = session.createCriteria(VUserModulesEntity.class).add(Restrictions.eq("user_id",user_id)).list();
        transaction.commit();
        return modules;
    }
}
