package com.jingguan.changePwd.dao;

/**
 * Created by 陈 on 2017/12/24.
 */
public interface ChangePwdDao {
    int updatePwd(int user_id, String oldPassword, String newPassword);
}
