package com.jingguan.system.service.impl;

import com.jingguan.system.dao.UserDao;
import com.jingguan.system.po.TUsersEntity;
import com.jingguan.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 陈 on 2017/10/8.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource(name="userDao")
    private UserDao userDao;

    @Override
    public TUsersEntity login(String account) {
        return userDao.findUserByAccount(account);

    }

    @Override
    public int XgLogin(String account, String password) {
        int res = userDao.findXgByAccount(account,password);
        if(res != 0){
            return res;
        }else{
            return 0;
        }
    }
}
