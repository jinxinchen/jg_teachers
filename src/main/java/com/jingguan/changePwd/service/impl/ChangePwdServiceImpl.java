package com.jingguan.changePwd.service.impl;


import com.jingguan.changePwd.dao.ChangePwdDao;
import com.jingguan.changePwd.service.ChangePwdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 陈 on 2017/12/24.
 */
@Service("changePwdService")
public class ChangePwdServiceImpl implements ChangePwdService {
    @Resource(name = "changePwdDao")
    private ChangePwdDao changePwdDao;

    @Override
    public int updatePwd(int user_id, String oldPassword, String newPassword) {
        return changePwdDao.updatePwd(user_id,oldPassword,newPassword);
    }
}
