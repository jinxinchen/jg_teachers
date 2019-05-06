package com.jingguan.system.dao;

import com.jingguan.system.po.TUsersEntity;

/**
 * Created by 陈 on 2017/10/8.
 */
public interface UserDao {
    TUsersEntity findUserByAccount(String account);
    int findXgByAccount(String account, String password);

}
