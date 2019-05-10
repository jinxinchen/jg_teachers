package com.jingguan.system.dao;

/**
 * Created by 陈 on 2017/10/8.
 */
public interface UserDao {
    int findUserByAccount(String account, String password);
    int findXgByAccount(String account, String password);
}
