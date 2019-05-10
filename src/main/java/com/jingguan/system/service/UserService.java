package com.jingguan.system.service;

import org.springframework.stereotype.Service;

/**
 * Created by 陈 on 2017/10/8.
 */
public interface UserService {
    int login(String account, String password);
    int XgLogin(String account, String password);
}
