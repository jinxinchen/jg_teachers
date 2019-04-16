package com.jingguan.system.controller;

import com.jingguan.system.po.TModulesEntity;
import com.jingguan.system.po.VUserModulesEntity;
import com.jingguan.system.service.ModuleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 陈 on 2017/10/14.
 */
@Controller
@RequestMapping("module")
public class ModuleController {

    @Resource(name = "moduleService")
    private ModuleService moduleService;

    @RequestMapping("listByUserAccount")
    @ResponseBody
    List<VUserModulesEntity> listModuleByUserAccount(HttpServletRequest request, HttpServletResponse response){
        int user_id = (int) request.getSession().getAttribute("user_id");
        List<VUserModulesEntity> modules = moduleService.listModuleByUserAccount(user_id);
        return modules;
    }

}
