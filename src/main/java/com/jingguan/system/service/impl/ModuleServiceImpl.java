package com.jingguan.system.service.impl;

import com.jingguan.system.dao.ModuleDao;
import com.jingguan.system.po.VUserModulesEntity;
import com.jingguan.system.service.ModuleService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 陈 on 2017/10/14.
 */
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService{

    @Resource(name="moduleDao")
    private ModuleDao moduleDao;

    @Override
    public List<VUserModulesEntity> listModuleByUserAccount(int user_id) {

        return  moduleDao.listModuleByUserAccount(user_id);
    }
}
