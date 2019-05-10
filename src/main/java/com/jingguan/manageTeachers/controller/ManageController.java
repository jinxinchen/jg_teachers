package com.jingguan.manageTeachers.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.manageTeachers.po.*;
import com.jingguan.manageTeachers.service.ManageService;
import com.jingguan.uploadExcel.controller.test2;
import com.jingguan.uploadImage.controller.uploadImage;
import jxl.write.WriteException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈 on 2017/12/11.
 */
@Controller
@RequestMapping("manageTeachers")
public class ManageController extends uploadImage {

    @Resource(name = "manageService")
    private ManageService manageService;




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
        String strFileName="teacherBaseInfo.xls";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("teachersBaseinfoCondition");
        manageService.getOutStream(os,condition);
        os.close();
        os.flush();


    }

    @RequestMapping(value = "downloadAcountExcel")
    @ResponseBody
    public void requestAccountExcelData(HttpServletRequest request,HttpServletResponse response) throws IOException,WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="teacherBaseInfo.xls";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("teachersAccountCondition");
        manageService.getOutAccountStream(os,condition);
        os.close();
        os.flush();


    }



    @RequestMapping("loadTeachers")
    @ResponseBody
    Page<VManageteachersBaseinfoEntity> loadTeachers(HttpServletRequest request,Page<VManageteachersBaseinfoEntity
            > page){
        request.getSession().setAttribute("teachersBaseinfoCondition",page.getFilterModel());//为了下载做准备

        return manageService.loadTeachers(page);
    }

    @RequestMapping("updateTeachers")
    @ResponseBody
    int updateTeacher(VManageteachersBaseinfoEntity vManageteachersBaseinfoEntity){
        TTeacherBaseinfoUpdate tTeacherBaseinfoUpdate = new TTeacherBaseinfoUpdate();
        TEducateDegreeEntity tEducateDegreeEntity = new TEducateDegreeEntity();

        //基础信息
        tTeacherBaseinfoUpdate.setUserId(vManageteachersBaseinfoEntity.getUserId());
        tTeacherBaseinfoUpdate.setName(vManageteachersBaseinfoEntity.getName());
        tTeacherBaseinfoUpdate.setGender(vManageteachersBaseinfoEntity.getGender());
        tTeacherBaseinfoUpdate.setBirthday(vManageteachersBaseinfoEntity.getBirthday());
        tTeacherBaseinfoUpdate.setPhoneNum(vManageteachersBaseinfoEntity.getPhoneNum());
        tTeacherBaseinfoUpdate.setDegree(vManageteachersBaseinfoEntity.getDegree());
        tTeacherBaseinfoUpdate.setDegreeType(vManageteachersBaseinfoEntity.getDegreeType());
        tTeacherBaseinfoUpdate.setOfficeStatus(vManageteachersBaseinfoEntity.getOfficeStatus());

        //职位信息
        tEducateDegreeEntity.setUserId(vManageteachersBaseinfoEntity.getUserId());
        tEducateDegreeEntity.setEducateDegreeName(vManageteachersBaseinfoEntity.getEducateDegreeName());
        tEducateDegreeEntity.setIsMentor(vManageteachersBaseinfoEntity.getIsMentor());
        tEducateDegreeEntity.setEducateDegreeLevel(vManageteachersBaseinfoEntity.getEducateDegreeLevel());
        tEducateDegreeEntity.setMajor(vManageteachersBaseinfoEntity.getMajor());
        tEducateDegreeEntity.setTutorClass(vManageteachersBaseinfoEntity.getTutorClass());
        tEducateDegreeEntity.setForClass(vManageteachersBaseinfoEntity.getForClass());
        tEducateDegreeEntity.setMentorType(vManageteachersBaseinfoEntity.getMentorType());
        tEducateDegreeEntity.setReportTime(vManageteachersBaseinfoEntity.getReportTime());
        tEducateDegreeEntity.setPositionType(vManageteachersBaseinfoEntity.getPositionType());
        manageService.updateDegree(tEducateDegreeEntity,tTeacherBaseinfoUpdate);

       /* TEducateDegreeEntity tEducateDegreeEntity=new TEducateDegreeEntity();
        tEducateDegreeEntity.setUserId(vManageteachersBaseinfoEntity.getUserId());
        tEducateDegreeEntity.setEducateDegreeLevel(vManageteachersBaseinfoEntity.getEducateDegreeLevel());
        tEducateDegreeEntity.setEducateDegreeName(vManageteachersBaseinfoEntity.);*/

        return  200;
    }

    @RequestMapping("deleteTeachers")
    @ResponseBody
    ResponseWrapper deleteTeacher(String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){

                VManageteachersBaseinfoEntity temp=manageService.getBaseinfoById(Integer.valueOf(ids[i].trim()));

                manageService.deleteBaseInfo(temp.getUserId());
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }


    @RequestMapping("loadRecord")
    @ResponseBody

    Page<TUsersEntity> loadRecord(HttpServletRequest request,Page<TUsersEntity> page){
        request.getSession().setAttribute("teachersAccountCondition",page.getFilterModel());//为了下载做准备
        manageService.loadRecord(page);
        System.out.println(page);
        return page;
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public int uploadUserAccount(HttpServletRequest request, @RequestParam(required = false) MultipartFile file) {


        try {
            List<String[]> list = test2.uploadExcelTest(request,file);
            manageService.saveUserAccountByExcel(list);

            return 200;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    @RequestMapping("editAccount")
    @ResponseBody
    public int editAccount(HttpServletRequest request,int id,String account,String password){
        int status = manageService.editAccount(id,account,password);
        return status;
    }

    @RequestMapping("deleteAccount")
    @ResponseBody
    public ResponseWrapper deleteAccount(HttpServletRequest request,String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        List list = new ArrayList();
        int user_id = (int)request.getSession().getAttribute("user_id");
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                manageService.deleteAccount(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;

    }

    @RequestMapping("addRecord")
    @ResponseBody

    public int addAccount(String account,HttpServletRequest request){
        List<String> accounts = new ArrayList<>();
        accounts.add(account);
        manageService.saveUserAccounts(accounts);
        return 200;
    }



}

