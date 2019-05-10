package com.jingguan.changePwd.dao.impl;

import com.jingguan.changePwd.dao.ChangePwdDao;
import com.jingguan.changePwd.po.TUsersEntity;
import com.jingguan.common.dao.impl.BaseDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 陈 on 2017/12/24.
 */
@Repository("changePwdDao")
public class ChangePwdDaoImpl extends BaseDao implements ChangePwdDao {
    @Override
    public int updatePwd(int user_id, String oldPassword, String newPassword) {

        Session session = getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //旧密码比较
        List<TUsersEntity> user = session.createCriteria(TUsersEntity.class).add(Restrictions.eq("id",user_id)).list();
        if(user.size()>0){
            String pwd = user.get(0).getPassword().toString();
            if(oldPassword.equals(pwd)){
                TUsersEntity tUsersEntity = session.load(TUsersEntity.class,user_id);
                tUsersEntity.setPassword(newPassword);

                session.update(tUsersEntity);
                transaction.commit();
                return 200;
            }else{
                //与旧密码不符合
                return 0;
            }
        }else{
            //修改密码失败
            return 2001;
        }
    }
}
