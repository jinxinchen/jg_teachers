package com.jingguan.system.service.impl;

import com.jingguan.system.dao.UserDao;
import com.jingguan.system.po.TUsersEntity;
import com.jingguan.system.po.TUsersRoleEntity;
import com.jingguan.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<TUsersRoleEntity> selectRoleByUser(TUsersEntity tUsersEntity) {
        if(tUsersEntity == null){return  null;}
        else {
            return userDao.selectRoleByUser(tUsersEntity);
        }
    }
}
