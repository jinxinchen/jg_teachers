package com.jingguan.project.controller;

import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.project.dao.UserIdDao;
import com.jingguan.project.po.TScientificEntity;
import com.jingguan.project.service.ProjectService;
import com.jingguan.uploadExcel.controller.test2;
import jxl.write.WriteException;
import org.springframework.stereotype.Controller;
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
import java.util.List;

/**
 * Created by zhouliang on 2017/11/21 0021.
 */
@Controller
@RequestMapping("teacher/project")
public class ProjectController {

    @Resource(name = "projectService")
    private ProjectService projectService;
    @Resource(name = "userIdDao")
    private UserIdDao userIdDao;


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
        String strFileName="project.xls";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("projectTeacherCondition");
        projectService.getOutStream(os,condition);
        os.close();
        os.flush();


    }




    //有异常
    @RequestMapping(value = "listProjectRecord",method = RequestMethod.GET)
    @ResponseBody
    Page listRecords(HttpServletRequest request, Page page){
        try {
            //带着条件过来，返回时将条件清空了
            request.getSession().setAttribute("projectTeacherCondition",page.getFilterModel());//为了下载做准备
            String user_id = request.getSession().getAttribute("user_id").toString();
                page=projectService.listRecordsByCondition(user_id,page);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return  page;
    }

    //审核的
    @RequestMapping(value = "listCheckProjectRecord",method = RequestMethod.GET)
    @ResponseBody
    Page listCheckRecords(HttpServletRequest request, Page page){
        try {
            //String user_id = request.getSession().getAttribute("user_id").toString();
            page=projectService.listRecordsByCondition(page);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return  page;
    }

    @RequestMapping(value="deleteProjectRecord",method =RequestMethod.POST)
    @ResponseBody
    public ResponseWrapper deleteRecord(HttpServletRequest request, String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        try {
            projectService.deleteRecord(id,request.getSession().getServletContext().getRealPath("/"));
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }



    @RequestMapping(value="updateProjectRecord")
    @ResponseBody
    public ResponseWrapper updateRecord(HttpServletRequest request,
                                        String id,
                                        String headName,
                                        String projectId,
                                        String userId,
                                        String scientificName,
                                        String scientificSource,
                                        String level,
                                        String createTime,
                                        String endTime,
                                        String isMarch,
                                        String type,
                                        String memberList,
                                        String grants,
                                        String createScientificEvidenceSrc,
                                        String createUpdateTime,
                                        String endScientificEvidenceSrc,
                                        String endUpdateTime,
                                        String others,
                                        String status){

        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(false);

        //封装成class
        TScientificEntity record=new TScientificEntity();
        record.setUserId(Integer.valueOf(userId));
        record.setHeadName(headName);
        record.setProjectId(projectId);
        record.setStatus(status);
        record.setId(Integer.valueOf(id.trim()));
        record.setScientificName(scientificName);
        record.setScientificSource(scientificSource);
        record.setLevel(level);
        record.setCreateTime(createTime);
        record.setEndTime(endTime);
        record.setIsMarch(isMarch);
        record.setType(type);
        record.setMemberList(memberList);
        record.setGrants(grants.trim());
        record.setCreateScientificEvidenceSrc(createScientificEvidenceSrc);
        record.setCreateUpdateTime(createUpdateTime);
        record.setCreateScientificEvidenceSrc(endScientificEvidenceSrc);
        record.setEndUpdateTime(endUpdateTime);
        record.setOthers(others);


        try{
            projectService.updateRecord(record);
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return wrapper;
    }


    @RequestMapping(value="saveProjectRecord",method = RequestMethod.POST)
    @ResponseBody
    public ResponseWrapper saveRecord(HttpServletRequest request,
                                      String id,
                                      String headName,
                                      String projectId,
                                      String scientificName,
                                      String scientificSource,
                                      String level,
                                      String createTime,
                                      String endTime,
                                      String isMarch,
                                      String type,
                                      String memberList,
                                      String grants,
                                      String createScientificEvidenceSrc,
                                      String createUpdateTime,
                                      String endScientificEvidenceSrc,
                                      String endUpdateTime,
                                      String others
                                     ){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(false);

        //封装成class
        TScientificEntity record=new TScientificEntity();
        record.setScientificName(scientificName);
        record.setScientificSource(scientificSource);
        record.setProjectId(projectId);
        record.setLevel(level);
        record.setCreateTime(createTime);
        record.setEndTime(endTime);
        record.setIsMarch(isMarch);
        record.setType(type);
        record.setMemberList(memberList);
        record.setGrants(grants.trim());
        record.setCreateScientificEvidenceSrc(createScientificEvidenceSrc);
        record.setCreateUpdateTime(createUpdateTime);
        record.setCreateScientificEvidenceSrc(endScientificEvidenceSrc);
        record.setEndUpdateTime(endUpdateTime);
        record.setOthers(others);

        try{
            String user_id="";
            if(headName==null||"".equals(headName)){
                user_id =  request.getSession().getAttribute("user_id").toString();;
                headName = userIdDao.getNameByUserId(user_id.trim());
            }else {
                UserDao userDao=new UserDao();
                user_id+=userDao.findUserIdByTname(headName);
            }

            record.setUserId(Integer.valueOf(user_id.trim()));
            record.setHeadName(headName);
            projectService.saveRecord(user_id,record);
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }
    @RequestMapping(value = "inProject",method = RequestMethod.POST)
    @ResponseBody
    public void in(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            int user_id = (int)request.getSession().getAttribute("user_id");
            List<String[]> list = test2.uploadExcelTest(request,file);
            String headName=userIdDao.getNameByUserId(user_id+"");
            projectService.inSciencePrizeTemp(list,user_id,headName);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
