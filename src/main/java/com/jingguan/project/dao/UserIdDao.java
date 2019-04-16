package com.jingguan.project.dao;

/**
 * Created by zhouliang on 2017/12/18 0018.
 */
public interface UserIdDao {

    int getUserIdByName(String name);
    String getNameByUserId(String userId);
}
