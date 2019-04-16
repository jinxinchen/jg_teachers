package com.jingguan.project.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.project.po.TProjectUserEntity;
import com.jingguan.project.service.MembersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
@Controller
@RequestMapping("teacher/project")
public class MembersController {

    @Resource(name="membersService")
    private MembersService membersService;

    @RequestMapping(value = "listProjectUser",method = RequestMethod.GET)
    @ResponseBody
    Page listRecords(HttpServletRequest request, String projectid, Page page){
        try {
            //String user_id = request.getSession().getAttribute("user_id").toString();
            page=membersService.listRecordsByCondition(projectid,page);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return  page;
    }


    @RequestMapping(value="deleteProjectUser",method =RequestMethod.POST)
    @ResponseBody
    public ResponseWrapper deleteRecord(HttpServletRequest request, String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        try {
            membersService.deleteRecord(id);
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }


    @RequestMapping(value="updateProjectUser")
    @ResponseBody
    public ResponseWrapper updateRecord(HttpServletRequest request,
                                        String userId,
                                        String projectId,
                                        String name,
                                        String scientificName,
                                        String level,
                                        String isPrincipal, String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(false);

        //封装成class
        TProjectUserEntity record=new TProjectUserEntity();

        record.setId(Integer.valueOf(id));
        record.setUserId(Integer.valueOf(userId.trim()));
        record.setProjectId(Integer.valueOf(projectId.trim()));
        record.setLevel(Integer.valueOf(level));
        record.setIsPrincipal(isPrincipal);

        try{
            membersService.updateRecord(record);
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return wrapper;
    }
    @RequestMapping(value="saveProjectUser")
    @ResponseBody
    public ResponseWrapper saveRecord(HttpServletRequest request,
                                      String userId,
                                      String projectId,
                                      String name,
                                      String scientificName,
                                      String level,
                                      String isPrincipal){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(false);

        //封装成class
        TProjectUserEntity record=new TProjectUserEntity();
        if(membersService.getUserId(name)!=-1){
            record.setUserId(membersService.getUserId(name));
        }else {
            wrapper.setData("该姓名用户不存在");
            return wrapper;
        }
        record.setProjectId(Integer.valueOf(projectId.trim()));
        record.setLevel(Integer.valueOf(level));
        record.setIsPrincipal(isPrincipal);

        try{
            String user_id = request.getSession().getAttribute("user_id").toString();
            membersService.saveRecord(user_id,record);
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return wrapper;
    }

}
