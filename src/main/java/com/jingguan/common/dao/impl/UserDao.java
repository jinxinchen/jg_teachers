package com.jingguan.common.dao.impl;

import com.jingguan.admin.po.TArticleEntity;
import com.jingguan.common.po.TTeacherBaseinfoEntity;
import com.jingguan.manageTeachers.po.TUsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by 陈 on 2017/12/13.
 */
public class UserDao extends BaseDao{

    public Integer findUserIdByUserAccount(String account){
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<TUsersEntity> user =  session.createCriteria(TUsersEntity.class).add(Restrictions.eq("account",account)).list();
        transaction.commit();
        if(user.size() == 0){
            return null;
        }else{
            return user.get(0).getId();
        }

    }

    //根据教师姓名查找user_id
    public  Integer findUserIdByTname(String teacherName){
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<TTeacherBaseinfoEntity> res = session.createCriteria(TTeacherBaseinfoEntity.class).add(Restrictions.eq("name",teacherName)).list();
        transaction.commit();
        if(res.size() == 0){
            return  null;
        }else{
            return res.get(0).getUserId();
        }
    }

    //根据userid找教师姓名
    public String findTnameByUserId(Integer userId){
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<TTeacherBaseinfoEntity> res = session.createCriteria(TTeacherBaseinfoEntity.class).add(Restrictions.eq("userId",userId)).list();
        transaction.commit();
        if(res.size() == 0){
            return  null;
        }else{

            return res.get(0).getName();
        }
    }


    //论文查重
    public  Integer findArticleByTname(String articleName){
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<TArticleEntity> res = session.createCriteria(TArticleEntity.class).add(Restrictions.eq("articleName",articleName)).list();
        transaction.commit();
        if(res.size() == 0){
            return  null;
        }else{
            return res.get(0).getUserId();
        }
    }

    //根据userId查找该条记录Id

    public  Integer findIdByUserId(int user_id){
        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<TTeacherBaseinfoEntity> res = session.createCriteria(TTeacherBaseinfoEntity.class).add(Restrictions.eq("userId",user_id)).list();
        transaction.commit();
        if(res.size() == 0){

            return  null;
        }else{

            return res.get(0).getId();
        }
    }
}
