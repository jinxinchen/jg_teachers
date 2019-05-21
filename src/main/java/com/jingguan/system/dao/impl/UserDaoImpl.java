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
        Transaction trans =null;
        try {
            Session session = getCurrentSession();
            trans = session.beginTransaction();
            List<TUsersEntity> user = session.createCriteria(TUsersEntity.class).add(Restrictions.eq("account",account)).list();
            if(user.size() > 0){
                return user.get(0);
            }else{
                return null;
            }
        }finally {
            if(trans !=null){
                trans.commit();
            }
        }

    }

    @Override
    public List<TUsersRoleEntity> selectRoleByUser(TUsersEntity tUsersEntity) {
        //开启会话
        Transaction trans =null;
        try {
            Session session = getCurrentSession();
            trans = session.beginTransaction();
            return   session.createCriteria(TUsersRoleEntity.class).add(Restrictions.eq("userId",tUsersEntity.getId())).list();
        }finally {
            if(trans !=null){
                trans.commit();
            }
        }

    }
}
