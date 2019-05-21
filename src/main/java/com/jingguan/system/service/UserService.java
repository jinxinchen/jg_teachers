package com.jingguan.system.service;

import com.jingguan.system.po.TUsersEntity;
import com.jingguan.system.po.TUsersRoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 陈 on 2017/10/8.
 */
public interface UserService {
    TUsersEntity login(String account);
    List<TUsersRoleEntity> selectRoleByUser(TUsersEntity tUsersEntity);

}
