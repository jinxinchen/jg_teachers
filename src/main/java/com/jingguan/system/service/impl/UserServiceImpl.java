package com.jingguan.system.service.impl;

import com.jingguan.system.dao.UserDao;
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
    public int login(String account, String password) {
        int res = userDao.findUserByAccount(account,password);
        if(res != 0){
            return res;
        }else{
            return 0;
        }
    }
}
