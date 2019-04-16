package com.jingguan.teacherMaterialsCheck.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterialsCheck.po.VTeacherMaterialsEntity;
import com.jingguan.teacherMaterialsCheck.service.MaterialService;
import com.jingguan.uploadImage.controller.uploadImage;
import jxl.write.WriteException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by 陈 on 2017/12/23.
 */
@Controller
@RequestMapping("admin/teachingMaterials")
public class AdminTechingMaterialsController extends uploadImage {


    @Resource(name = "materialAdminService")
    private MaterialService materialService;
    @RequestMapping(value = "downloadExcel")
    @ResponseBody
    public void requestExcelData(HttpServletRequest request,HttpServletResponse response) throws IOException,WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="Materials.xls";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("materialsAdminCondition");
        materialService.getOutStream(os,condition);
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

    @RequestMapping("loadMaterial")
    @ResponseBody
    Page<VTeacherMaterialsEntity> loadMaterial(HttpServletRequest request, Page<VTeacherMaterialsEntity> page){
        request.getSession().setAttribute("materialsAdminCondition",page.getFilterModel());//为了下载做准备
        page = materialService.loadMaterial(page);
        return page;
    }
/*
    @RequestMapping("uploadMaterial")
    @ResponseBody
    void uploadMaterial(@RequestParam("file") MultipartFile file, HttpServletRequest request, int id){
        String path = "adminTeachingMaterials";

        String fileName = upload(file,path,request);
        String filename = file.getOriginalFilename();//不带路径
        materialService.uploadFile(fileName,filename,id);
    }
*/


    @RequestMapping("getMaterialSrcById")
    @ResponseBody
    String getMaterialSrcById(int id){
        return materialService.getMaterialSrcById(id);
    }


}
