package com.jingguan.system.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.system.dao.UserDao;
import com.jingguan.system.po.TUsersEntity;
import com.jingguan.system.po.TUsersRoleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 陈 on 2017/10/8.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public TUsersEntity findUserByAccount(String account) {
       //开启会话
        Session session = getCurrentSession();
        Transaction trans = session.beginTransaction();
        List<TUsersEntity> user = session.createCriteria(TUsersEntity.class).add(Restrictions.eq("account",account)).list();
        trans.commit();
        if(user.size() > 0){
            return user.get(0);
        }else{
            return null;
        }
    }

    @Override
    public int findXgByAccount(String account, String password) {
        //开启会话
        Session session = getCurrentSession();
        Transaction trans = session.beginTransaction();

        List<TUsersEntity> user = session.createCriteria(TUsersEntity.class).add(Restrictions.eq("account",account)).add(Restrictions.eq("password",password)).list();
        trans.commit();
        if(user.size() > 0){
            Session session1 = getCurrentSession();
            Transaction trans1 = session1.beginTransaction();
            List<TUsersRoleEntity> userRole = session1.createCriteria(TUsersRoleEntity.class).add(Restrictions.eq("userId",user.get(0).getId())).list();
            trans1.commit();
            if (userRole.size() > 0 && userRole.get(0).getRoleId() == 5){
                return user.get(0).getId();
            }else {
                return 0;
            }
        }else{
            return 0;
        }
    }
}
