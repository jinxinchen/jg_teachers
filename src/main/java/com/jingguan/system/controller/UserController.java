package com.jingguan.system.controller;

import com.jingguan.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 陈 on 2017/10/8.
 */
@Controller("userController")
@RequestMapping("system/user")
public class UserController {

    @Resource(name="userService")
    private UserService userService;


    /**
     *  检查用户是不已经登陆了
     * @param request 单独的request
     * @return 结果
     */
    @RequestMapping("checkLogin")
    @ResponseBody
    public String checkLogin(HttpServletRequest request){
        Object userId = request.getSession().getAttribute("user_id");
        if(userId == null){
            return "reject";
        }else {
            return "success";
        }

    }
    /**
     *  检查用户是不已经登陆了
     * @param request 单独的request
     */
    @RequestMapping("loginOut")
    @ResponseBody
    public void loginOut(HttpServletRequest request){
        request.getSession().setAttribute("user_id",null);
    }


    @RequestMapping("login")
    @ResponseBody
    public String getUserAccount(HttpServletRequest request, String account, String password){
        int res = userService.login(account,password);
        if(res != 0){
            request.getSession().setAttribute("user_id",res);
            return "success";
        }else{
            return "wrong";
        }

    }

    @RequestMapping(value = "account")
    @ResponseBody
    public String getUserAccount(HttpServletRequest request){
        String account = null;
        try {
            account = (String) request.getSession().getAttribute("account");
      }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }

    @RequestMapping("studentLogin")
    @ResponseBody
    public String getXgAccount(HttpServletRequest request, String account, String password){
        int res = userService.XgLogin(account,password);
        if(res != 0){
            request.getSession().setAttribute("user_id",res);
            return "success";
        }else{
            return "wrong";
        }

    }
}
