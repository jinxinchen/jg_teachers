package com.jingguan.system.service;

import com.jingguan.system.po.VUserModulesEntity;

import java.util.List;

/**
 * Created by 陈 on 2017/10/14.
 */
public interface ModuleService {
    List<VUserModulesEntity> listModuleByUserAccount(int user_id);
}
