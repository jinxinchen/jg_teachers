package com.jingguan.student.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.student.po.*;
import com.jingguan.student.service.StudentService;
import com.jingguan.uploadExcel.controller.test2;
import jxl.write.WriteException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("student")
public class StudentController extends test2 {

    @Resource(name = "studentService")
    private StudentService studentService;
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
    public void requestExcelData(HttpServletRequest request, HttpServletResponse response) throws IOException, WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="student.xlsx";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("studentCondition");
        studentService.getOutStream(os,condition);
        os.close();
        os.flush();


    }

    @RequestMapping("load")
    @ResponseBody
    Page<TStudentEntity> load(HttpServletRequest request, Page<TStudentEntity> page){
        request.getSession().setAttribute("studentCondition",page.getFilterModel());
        page = studentService.load(page);
        return page;
    }

    @RequestMapping("add")
    @ResponseBody
    int add(HttpServletRequest request,TStudentEntity tStudentEntity){
        return studentService.add(tStudentEntity);
    }

    @RequestMapping("edit")
    @ResponseBody
    int edit(HttpServletRequest request,TStudentEntity tStudentEntity){
        return studentService.edit(tStudentEntity);
    }


    @RequestMapping("delete")
    @ResponseBody
    ResponseWrapper delete(HttpServletRequest request,String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        List list = new ArrayList();
        int user_id = (int)request.getSession().getAttribute("user_id");
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                int status = studentService.delete(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    //导入模板
    @RequestMapping("inStudent")
    void in(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = uploadExcelTest(request,file);
            studentService.inStudent(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("getUserId")
    @ResponseBody
    Map getUserId(HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        Map map = new HashMap();
        map.put("user_id",user_id);
        return map;

    }

    @RequestMapping("getAwardSrcById")
    @ResponseBody
    String getAwardSrcById(int id,HttpServletRequest request){
        return studentService.getAwardSrcById(id);
    }

    @RequestMapping("getIssbnSrcById")
    @ResponseBody
    String getIssbnSrcById(int id,HttpServletRequest request){
        return studentService.getIssbnSrcById(id);
    }

    //==========研究生论文==========
    @RequestMapping(value="requestUploadPostGraduateArticle")
    @ResponseBody
    public String requestExcelDataPostGraduateArticle(HttpServletRequest request) {
        // if(list==null||list.size()==0){
        //     return "false";
        // }
        return "success";

    }
    @RequestMapping(value = "downloadExcelPostGraduateArticle")
    @ResponseBody
    public void requestExcelDataPostGraduateArticle(HttpServletRequest request, HttpServletResponse response) throws IOException, WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="postGraduateArticle.xlsx";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("postGraduateArticleCondition");
        studentService.getOutStreamPostGraduateArticle(os,condition);
        os.close();
        os.flush();


    }
    @RequestMapping("loadPostGraduateArticle")
    @ResponseBody
    Page<TPostgraduateArticleEntity> loadPostGraduateArticle(HttpServletRequest request, Page<TPostgraduateArticleEntity> page){
        request.getSession().setAttribute("postGraduateArticleCondition",page.getFilterModel());
        page = studentService.loadPostGraduateArticle(page);
        return page;
    }

    @RequestMapping("addPostGraduateArticle")
    @ResponseBody
    int addPostGraduateArticle(HttpServletRequest request,TPostgraduateArticleEntity tPostgraduateArticleEntity){
        return studentService.addPostGraduateArticle(tPostgraduateArticleEntity);
    }

    @RequestMapping("editPostGraduateArticle")
    @ResponseBody
    int editPostGraduateArticle(HttpServletRequest request,TPostgraduateArticleEntity tPostgraduateArticleEntity){
        return studentService.editPostGraduateArticle(tPostgraduateArticleEntity);
    }


    @RequestMapping("deletePostGraduateArticle")
    @ResponseBody
    ResponseWrapper deletePostGraduateArticle(HttpServletRequest request,String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        List list = new ArrayList();
        int user_id = (int)request.getSession().getAttribute("user_id");
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                int status = studentService.deletePostGraduateArticle(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    //导入模板
    @RequestMapping("inPostGraduateArticle")
    void inPostGraduateArticle(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = uploadExcelTest(request,file);
            studentService.inPostGraduateArticle(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //==========研究生科研==========
    @RequestMapping(value="requestUploadPostGraduateKeyan")
    @ResponseBody
    public String requestExcelDataPostGraduateKeyan(HttpServletRequest request) {
        // if(list==null||list.size()==0){
        //     return "false";
        // }
        return "success";

    }
    @RequestMapping(value = "downloadExcelPostGraduateKeyan")
    @ResponseBody
    public void requestExcelDataPostGraduateKeyan(HttpServletRequest request, HttpServletResponse response) throws IOException, WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="postGraduateKeyan.xlsx";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("postGraduateKeyanCondition");
        studentService.getOutStreamPostGraduateKeyan(os,condition);
        os.close();
        os.flush();


    }
    @RequestMapping("loadPostGraduateKeyan")
    @ResponseBody
    Page<TPostgraduateKeyanEntity> loadPostGraduateKeyan(HttpServletRequest request, Page<TPostgraduateKeyanEntity> page){
        request.getSession().setAttribute("postGraduateKeyanCondition",page.getFilterModel());
        page = studentService.loadPostGraduateKeyan(page);
        return page;
    }

    @RequestMapping("addPostGraduateKeyan")
    @ResponseBody
    int addPostGraduateKeyan(HttpServletRequest request,TPostgraduateKeyanEntity tPostgraduateKeyanEntity){
        return studentService.addPostGraduateKeyan(tPostgraduateKeyanEntity);
    }

    @RequestMapping("editPostGraduateKeyan")
    @ResponseBody
    int editPostGraduateKeyan(HttpServletRequest request,TPostgraduateKeyanEntity tPostgraduateKeyanEntity){
        return studentService.editPostGraduateKeyan(tPostgraduateKeyanEntity);
    }


    @RequestMapping("deletePostGraduateKeyan")
    @ResponseBody
    ResponseWrapper deletePostGraduateKeyan(HttpServletRequest request,String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        List list = new ArrayList();
        int user_id = (int)request.getSession().getAttribute("user_id");
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                int status = studentService.deletePostGraduateKeyan(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    //导入模板
    @RequestMapping("inPostGraduateKeyan")
    void inPostGraduateKeyan(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = uploadExcelTest(request,file);
            studentService.inPostGraduateKeyan(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //==========研究生竞赛==========
    @RequestMapping(value="requestUploadPostGraduateJingsai")
    @ResponseBody
    public String requestExcelDataPostGraduateJingsai(HttpServletRequest request) {
        // if(list==null||list.size()==0){
        //     return "false";
        // }
        return "success";

    }
    @RequestMapping(value = "downloadExcelPostGraduateJingsai")
    @ResponseBody
    public void requestExcelDataPostGraduateJingsai(HttpServletRequest request, HttpServletResponse response) throws IOException, WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="postGraduateJingsai.xlsx";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("postGraduateJingsaiCondition");
        studentService.getOutStreamPostGraduateJingsai(os,condition);
        os.close();
        os.flush();


    }
    @RequestMapping("loadPostGraduateJingsai")
    @ResponseBody
    Page<TPostgraduateJingsaiEntity> loadPostGraduateJingsai(HttpServletRequest request, Page<TPostgraduateJingsaiEntity> page){
        request.getSession().setAttribute("postGraduateJingsaiCondition",page.getFilterModel());
        page = studentService.loadPostGraduateJingsai(page);
        return page;
    }

    @RequestMapping("addPostGraduateJingsai")
    @ResponseBody
    int addPostGraduateJingsai(HttpServletRequest request,TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity){
        return studentService.addPostGraduateJingsai(tPostgraduateJingsaiEntity);
    }

    @RequestMapping("editPostGraduateJingsai")
    @ResponseBody
    int editPostGraduateJingsai(HttpServletRequest request,TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity){
        return studentService.editPostGraduateJingsai(tPostgraduateJingsaiEntity);
    }


    @RequestMapping("deletePostGraduateJingsai")
    @ResponseBody
    ResponseWrapper deletePostGraduateJingsai(HttpServletRequest request,String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        List list = new ArrayList();
        int user_id = (int)request.getSession().getAttribute("user_id");
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                int status = studentService.deletePostGraduateJingsai(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    //导入模板
    @RequestMapping("inPostGraduateJingsai")
    void inPostGraduateJingsai(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = uploadExcelTest(request,file);
            studentService.inPostGraduateJingsai(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("getJingsaiSrcById")
    @ResponseBody
    String getJingsaiSrcById(int id,HttpServletRequest request){
        return studentService.getJingsaiSrcById(id);
    }

    //研究生出国情况addStuAbroad
    @RequestMapping(value="requestUploadStuAbroad")
    @ResponseBody
    public String requestExcelDataStuAbroad(HttpServletRequest request) {
        // if(list==null||list.size()==0){
        //     return "false";
        // }
        return "success";

    }
    @RequestMapping(value = "downloadExcelStuAbroad")
    @ResponseBody
    public void requestExcelDataStuAbroad(HttpServletRequest request, HttpServletResponse response) throws IOException, WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="StuAbroad.xlsx";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("StuAbroadCondition");
        studentService.getOutStreamStuAbroad(os,condition);
        os.close();
        os.flush();


    }
    @RequestMapping("loadStuAbroad")
    @ResponseBody
    Page<TStuAbroadEntity> loadStuAbroad(HttpServletRequest request, Page<TStuAbroadEntity> page){
        request.getSession().setAttribute("StuAbroadCondition",page.getFilterModel());
        page = studentService.loadStuAbroad(page);
        return page;
    }

    @RequestMapping("addStuAbroad")
    @ResponseBody
    int addStuAbroad(HttpServletRequest request,TStuAbroadEntity tStuAbroadEntity){
        return studentService.addStuAbroad(tStuAbroadEntity);
    }

    @RequestMapping("editStuAbroad")
    @ResponseBody
    int editStuAbroad(HttpServletRequest request,TStuAbroadEntity tStuAbroadEntity){
        return studentService.editStuAbroad(tStuAbroadEntity);
    }


    @RequestMapping("deleteStuAbroad")
    @ResponseBody
    ResponseWrapper deleteStuAbroad(HttpServletRequest request,String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        List list = new ArrayList();
        int user_id = (int)request.getSession().getAttribute("user_id");
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                studentService.deleteStuAbroad(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    //导入模板
    @RequestMapping("inStuAbroad")
    void inStuAbroad(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = uploadExcelTest(request,file);
            studentService.inStuAbroad(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //===========学生基本信息=========

    @RequestMapping(value="requestUploadInfo")
    @ResponseBody
    public String requestExcelDataInfo(HttpServletRequest request) {
        // if(list==null||list.size()==0){
        //     return "false";
        // }
        return "success";

    }
    @RequestMapping(value = "downloadExcelInfo")
    @ResponseBody
    public void requestExcelDataInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="studentInfo.xlsx";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("studentInfoCondition");
        studentService.getOutStreamStuInfo(os,condition);
        os.close();
        os.flush();


    }

    @RequestMapping("loadInfo")
    @ResponseBody
    Page<TStuInfoEntity> loadInfo(HttpServletRequest request, Page<TStuInfoEntity> page){
        request.getSession().setAttribute("studentInfoCondition",page.getFilterModel());
        page = studentService.loadInfo(page);
        return page;
    }

    @RequestMapping("addInfo")
    @ResponseBody
    int addInfo(HttpServletRequest request,TStuInfoEntity tStuInfoEntity){
        return studentService.addInfo(tStuInfoEntity);
    }

    @RequestMapping("editInfo")
    @ResponseBody
    int editInfo(HttpServletRequest request,TStuInfoEntity tStuInfoEntity){
        return studentService.editInfo(tStuInfoEntity);
    }


    @RequestMapping("deleteInfo")
    @ResponseBody
    ResponseWrapper deleteInfo(HttpServletRequest request,String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        List list = new ArrayList();
        int user_id = (int)request.getSession().getAttribute("user_id");
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                studentService.deleteInfo(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    //导入模板
    @RequestMapping("inStudentInfo")
    void inStudentInfo(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = uploadExcelTest(request,file);
            studentService.inStudentInfo(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
