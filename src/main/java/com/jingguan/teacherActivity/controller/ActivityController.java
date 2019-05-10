package com.jingguan.teacherActivity.controller;

import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.teacherActivity.po.TTeacherActivityEntity;
import com.jingguan.teacherActivity.service.TeacherActivityService;
import com.jingguan.uploadExcel.controller.test2;
import com.jingguan.uploadImage.controller.UploadImages;
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
 * Created by zhouliang on 2017/11/11 0011.
 */
@Controller
@RequestMapping("teacher/teacherActivity")
public class ActivityController extends UploadImages {

    @Resource(name="teacherActivityService")
    private TeacherActivityService teacherActivityService;


    @RequestMapping(value = "uploadEvidence",method = RequestMethod.POST)
    @ResponseBody
    String uploadEvidence(@RequestParam("file") MultipartFile file, @RequestParam("id") String id, HttpServletRequest request){
        String  path=upload(file,request);
        teacherActivityService.updatePath(id,path);
        return path;
    }

    @RequestMapping(value = "downloadEvidence",method = RequestMethod.POST)
    @ResponseBody
    String downloadEvidence(String id, HttpServletRequest request){
        String  path= teacherActivityService.getPath(id);
        return path;
    }


    @RequestMapping(value = "listActivity",method = RequestMethod.GET)
    @ResponseBody
    Page listRecords(HttpServletRequest request, Page page){
        try {

            request.getSession().setAttribute("activityTeacherCondition",page.getFilterModel());
            String user_id = request.getSession().getAttribute("user_id").toString();
            page=teacherActivityService.listRecordsByCondition(user_id,page);

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return  page;
    }


    @RequestMapping(value="deleteActivity",method =RequestMethod.POST)
    @ResponseBody
    public ResponseWrapper deleteRecord(HttpServletRequest request, String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        try {
            teacherActivityService.deleteRecord(id,request.getSession().getServletContext().getRealPath("/"));
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }



    @RequestMapping(value="updateActivity")
    @ResponseBody
    public ResponseWrapper updateRecord(HttpServletRequest request, String activityName,
                                        String activityLocation, String activityTime,
                                        String activityOrganizers, String others, String id,
                                        String status){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(false);

        //封装一下
        TTeacherActivityEntity record=new TTeacherActivityEntity();
        record.setId(Integer.valueOf(id.trim()));
        record.setActivityName(activityName);
        record.setActivityLocation(activityLocation);
        record.setActivityTime(activityTime);
        record.setActivityOrganizers(activityOrganizers);
        record.setStatus(status);
        record.setOthers(others);

        try{
            //int userid=(int)request.getSession().getAttribute("user_id");
            teacherActivityService.updateRecord(record);
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return wrapper;
    }


    @RequestMapping(value="saveActivity",method = RequestMethod.POST)
    @ResponseBody
    public ResponseWrapper saveRecord(HttpServletRequest request,
                                      String teacherName,
                                      String activityName,
                                      String activityLocation, String activityTime,
                                      String activityOrganizers, String others){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(false);
        System.out.println(teacherName);
        //封装一下
        TTeacherActivityEntity record=new TTeacherActivityEntity();
        record.setActivityName(activityName);
        record.setActivityLocation(activityLocation);
        record.setActivityTime(activityTime);
        record.setActivityOrganizers(activityOrganizers);
        record.setOthers(others);

        try{
            Integer userid;
            if(teacherName!=null||"".equals(teacherName)){
                UserDao userDao=new UserDao();
                userid=userDao.findUserIdByTname(teacherName);
            }else {
                userid = (Integer) request.getSession().getAttribute("user_id");
            }
            if(userid == null){
                wrapper.setData("用户不存在");
            }else {
                teacherActivityService.saveRecord(userid,record);
                wrapper.setSuccess(true);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    @RequestMapping("inActivity")
    void in(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = test2.uploadExcelTest(request,file);
            int user_id = (int)request.getSession().getAttribute("user_id");
            teacherActivityService.inSciencePrizeTemp(list,user_id);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @RequestMapping(value = "downloadExcel")
    @ResponseBody
    public void requestExcelData(HttpServletRequest request,HttpServletResponse response) throws IOException,WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="activity.xls";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("activityTeacherCondition");
        teacherActivityService.getOutStream(os,condition);
        os.close();
        os.flush();


    }


    @RequestMapping(value = "requestUpload")
    @ResponseBody
    public String requestExcelData(HttpServletRequest request) {

        //if(list==null||list.size()==0){
        //    return "false";
        //}
        return "success";

    }


    }
