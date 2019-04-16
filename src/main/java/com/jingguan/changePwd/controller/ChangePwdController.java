package com.jingguan.changePwd.controller;

import com.jingguan.changePwd.service.ChangePwdService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 陈 on 2017/12/24.
 */
@Controller
@RequestMapping("changePwd")
public class ChangePwdController {

    @Resource(name = "changePwdService")
    private ChangePwdService changePwdService;

    @RequestMapping("updatePwd")
    @ResponseBody
    int updatePwd(HttpServletRequest request,String oldPassword,String newPassword){
        int user_id = (int) request.getSession().getAttribute("user_id");
        return changePwdService.updatePwd(user_id,oldPassword,newPassword);
    }
}
