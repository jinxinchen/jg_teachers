package com.jingguan.system.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.system.dao.UserDao;
import com.jingguan.system.po.TUsersEntity;
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
    public int findUserByAccount(String account,String password) {
       //开启会话
        Session session = this.getCurrentSession();
        Transaction trans = session.beginTransaction();

        List<TUsersEntity> user = session.createCriteria(TUsersEntity.class).add(Restrictions.eq("account",account)).add(Restrictions.eq("password",password)).list();
        trans.commit();
        if(user.size() > 0){
            return user.get(0).getId();
        }else{
            return 0;
        }
    }
}
