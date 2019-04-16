package com.jingguan.project.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.project.dao.UserIdDao;
import com.jingguan.project.po.UserId;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/18 0018.
 */
@Repository("userIdDao")
public class UserIdDaoImpl extends BaseDao implements UserIdDao {
    @Override
    public int getUserIdByName(String name) {
            Session session=getCurrentSession();
            Transaction transaction=session.beginTransaction();
            List<UserId> list;
            list=session.createCriteria(UserId.class).add(Restrictions.eq("name",name)).list();
            UserId userId=null;
            transaction.commit();
            if(list.size()>=1){
                userId=list.get(0);
            }else {
                return -1;
            }
            return userId.getUser_id();

    }

    @Override
    public String getNameByUserId(String userId) {
        Session session=getCurrentSession();
        Transaction transaction=session.beginTransaction();
        List<UserId> list;
        list=session.createCriteria(UserId.class).add(Restrictions.eq("user_id",Integer.valueOf(userId.trim()))).list();
        UserId user=null;
        transaction.commit();
        if(list.size()>=1){
            user=list.get(0);
        }else {
            return null;
        }
        return user.getName();
    }
}
