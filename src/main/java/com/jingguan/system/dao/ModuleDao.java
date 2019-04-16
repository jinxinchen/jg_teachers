package com.jingguan.system.dao;

import com.jingguan.system.po.TModulesEntity;
import com.jingguan.system.po.VUserModulesEntity;

import java.util.List;

/**
 * Created by 陈 on 2017/10/14.
 */
public interface ModuleDao {
    List<VUserModulesEntity> listModuleByUserAccount(int user_id);
}
