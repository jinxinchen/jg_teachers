package com.jingguan.changePwd.service;

/**
 * Created by 陈 on 2017/12/24.
 */
public interface ChangePwdService {
    int updatePwd(int user_id, String oldPassword, String newPassword);
}
