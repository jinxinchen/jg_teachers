package com.jingguan.system.service;

import com.jingguan.system.po.TUsersEntity;
import org.springframework.stereotype.Service;

/**
 * Created by 陈 on 2017/10/8.
 */
public interface UserService {
    TUsersEntity login(String account);
    int XgLogin(String account, String password);

}
