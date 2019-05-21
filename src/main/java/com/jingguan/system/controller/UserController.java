package com.jingguan.system.controller;

import com.google.code.kaptcha.Constants;
import com.jingguan.system.po.TUsersEntity;
import com.jingguan.system.po.TUsersRoleEntity;
import com.jingguan.system.po.VUserModulesEntity;
import com.jingguan.system.service.ModuleService;
import com.jingguan.system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 陈 on 2017/10/8.
 */
@Controller("userController")
@RequestMapping("system/user")
public class UserController {

    @Resource(name="userService")
    private UserService userService;
    @Resource(name = "moduleService")
    private ModuleService moduleService;


    /**
     *  检查用户是不已经登陆了
     * @param request 单独的request
     * @return 结果
     */
    @RequestMapping("checkLogin")
    @ResponseBody
    public String checkLogin(HttpServletRequest request, VUserModulesEntity vUserModulesEntity){
        Object userId = request.getSession().getAttribute("user_id");
        String result = "success";
        if(userId == null){
            result = "noLogin";
        }else if(vUserModulesEntity.getModuleName() != null){
            //不是null的话就是可以去需要分块的页面
            result = "reject";
            List<VUserModulesEntity> list = moduleService.listModuleByUserAccount(Integer.valueOf(userId.toString()));
            for(VUserModulesEntity item:list){
                if(item.getModuleName().equals(vUserModulesEntity.getModuleName())){
                    result = "success";
                    break;
                }
            }

        }
        return  result;
    }
    /**
     *  用户退出
     * @param request 单独的request
     */
    @RequestMapping("loginOut")
    @ResponseBody
    public void loginOut(HttpServletRequest request){
        request.getSession().setAttribute("user_id",null);
    }



    @RequestMapping("login")
    @ResponseBody
    public String getUserAccount(HttpServletRequest request, String account, String password,String code){
        HttpSession httpSession = request.getSession();
        //登陆次数
        if(httpSession.getAttribute("loginTimes") == null){
           httpSession.setAttribute("loginTimes",1);
        }
        Integer times = Integer.valueOf(httpSession.getAttribute("loginTimes").toString());
        if(times>3){
           //第四次没有成功登陆的情况需要堆其进行限制一分钟
           if(httpSession.getAttribute("nextTime")==null){
               httpSession.setAttribute("nextTime",System.currentTimeMillis()+60000);
           }
           long nextTime = Long.valueOf(httpSession.getAttribute("nextTime").toString());
           if(nextTime > System.currentTimeMillis()){
               return "timesLimit";
           }else {
               httpSession.setAttribute("nextTime",System.currentTimeMillis()+60000);
           }
       }
        String meassage = "success";
        String generateCode =(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(code == null || "".equals(code) || !code.equals(generateCode)){
            meassage = "codeErro";
        }else {
            TUsersEntity res = userService.login(account);
            if(res == null){
                meassage = "noAccount";
            } else if(!password.equals(res.getPassword())){
                meassage = "passwordWorry";
                httpSession.setAttribute("loginTimes",++times);
            }
            if("success".equals(meassage)){
                request.getSession().setAttribute("user_id",res.getId());
                httpSession.setAttribute("loginTimes",1);
            }
        }
        return meassage;
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
    public String getXgAccount(HttpServletRequest request, String account, String password,String code){
        HttpSession httpSession = request.getSession();
        //登陆次数
        if(httpSession.getAttribute("loginTimes") == null){
            httpSession.setAttribute("loginTimes",1);
        }
        Integer times = Integer.valueOf(httpSession.getAttribute("loginTimes").toString());
        if(times>3){
            //第四次没有成功登陆的情况需要堆其进行限制一分钟
            if(httpSession.getAttribute("nextTime")==null){
                httpSession.setAttribute("nextTime",System.currentTimeMillis()+60000);
            }
            long nextTime = Long.valueOf(httpSession.getAttribute("nextTime").toString());
            if(nextTime > System.currentTimeMillis()){
                return "timesLimit";
            }else {
                httpSession.setAttribute("nextTime",System.currentTimeMillis()+60000);
            }
        }
        String meassage = "success";
        String generateCode =(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(code == null || "".equals(code) || !code.equals(generateCode)){
            meassage = "codeErro";
        }else {
            TUsersEntity res = userService.login(account);
            if(res == null){
                meassage = "noAccount";
            } else{
                //账号不是null 查角色
                if(!password.equals(res.getPassword())){
                    meassage = "passwordWorry";
                    httpSession.setAttribute("loginTimes",++times);
                }else {
                    //表明密码是正确的,看看角色是不是有学工角色
                    List<TUsersRoleEntity> tUsersRoleEntity = userService.selectRoleByUser(res);
                    meassage = "isnotxuegong";
                    System.out.println(tUsersRoleEntity);
                    for (TUsersRoleEntity item:tUsersRoleEntity){
                        if(item.getRoleId() == 6){
                            //表示没有权限
                            meassage = "success";
                            break;
                        }
                    }
                }


            }
            if("success".equals(meassage)){
                request.getSession().setAttribute("user_id",res.getId());
                httpSession.setAttribute("loginTimes",1);
            }
        }
        return meassage;


    }
}
