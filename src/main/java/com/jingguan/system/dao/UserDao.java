package com.jingguan.system.dao;

import com.jingguan.system.po.TUsersEntity;
import com.jingguan.system.po.TUsersRoleEntity;

import java.util.List;

/**
 * Created by 陈 on 2017/10/8.
 */
public interface UserDao {
    TUsersEntity findUserByAccount(String account);
    List<TUsersRoleEntity> selectRoleByUser(TUsersEntity tUsersEntity);

}
