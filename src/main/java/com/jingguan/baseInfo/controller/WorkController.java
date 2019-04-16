package com.jingguan.baseInfo.controller;

import com.jingguan.baseInfo.po.TWorkExperienceEntity;
import com.jingguan.baseInfo.service.WorkExpService;
import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.uploadExcel.controller.test2;
import jxl.write.WriteException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈 on 2017/10/29.
 */
@Controller
@RequestMapping("work")
public class WorkController extends test2 {

    @Resource(name = "workExpService")
    private WorkExpService workExpService;

    @RequestMapping(value="requestUpload")
    @ResponseBody
    public String requestExcelData(HttpServletRequest request) {
        // if(list==null||list.size()==0){
        //     return "false";
        // }
        return "success";

    }
    @RequestMapping(value = "downloadExcel")
    @ResponseBody
    public void requestExcelData(HttpServletRequest request,HttpServletResponse response) throws IOException,WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="wordExp.xls";// 默认Excel名称
        response.setContentType("application/octet-stream; charset=utf-8");

        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0){

            // firefox浏览器
            response.setHeader("Content-Disposition", "attachment; filename=" +  new String(strFileName.getBytes("UTF-8"), "ISO8859-1"));

        } else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0){

            // IE浏览器
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(strFileName, "UTF-8"));

        }else{

            //其他浏览器
            response.setHeader("Content-disposition", "attachment;filename="+strFileName);
        }

        //设置返回的参数
        ServletOutputStream os=response.getOutputStream();
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("educationTeacherCondition");
        workExpService.getOutStream(os,condition);
        os.close();
        os.flush();


    }

    @RequestMapping(value = "loadWorkExp")
    @ResponseBody
    Page<TWorkExperienceEntity> loadWorkExp(HttpServletRequest request,Page<TWorkExperienceEntity> page,String userId){
        int user_id;
        if(StringUtils.isEmpty(userId)){
            request.getSession().setAttribute("workTeacherCondition",page.getFilterModel());//为了下载做准备
            user_id = (int) request.getSession().getAttribute("user_id");
        }else{
            user_id = Integer.parseInt(userId);
        }
        page = workExpService.loadWorkExp(user_id,page);
        if(page != null){
            return page;
        }else{
            return null;
        }
    }

    @RequestMapping("addWorkExp")
    @ResponseBody
    int addWorkExp(HttpServletRequest request, TWorkExperienceEntity tWorkExperienceEntity,String userId){
        int user_id;
        if(StringUtils.isEmpty(userId)){
            user_id = (int) request.getSession().getAttribute("user_id");
        }else{
            user_id = Integer.parseInt(userId);
        }
        workExpService.addWorkExp(tWorkExperienceEntity,user_id);
        return 0;
    }

    @RequestMapping("editWorkExp")
    @ResponseBody
    int editWorkExp(HttpServletRequest request,TWorkExperienceEntity tWorkExperienceEntity,String userId){
        int user_id;
        if(StringUtils.isEmpty(userId)){
            user_id = (int) request.getSession().getAttribute("user_id");
        }else{
            user_id = Integer.parseInt(userId);
        }
        workExpService.editWorkExp(tWorkExperienceEntity,user_id);
        return 0;
    }

    @RequestMapping("deleteWorkExp")
    @ResponseBody
    ResponseWrapper deleteWorkExp(HttpServletRequest request,String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        List list = new ArrayList();
        int user_id = (int)request.getSession().getAttribute("user_id");
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                workExpService.deleteWorkExp(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    //导入模板
    @RequestMapping("inWork")
    void in(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = uploadExcelTest(request,file);
            int user_id = (int)request.getSession().getAttribute("user_id");
            workExpService.InWork(list,user_id);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
