package com.jingguan.scientificResearchMaterials.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.scientificResearchMaterials.po.TScientificresearchmaterialsEntity;
import com.jingguan.scientificResearchMaterials.service.MaterialService;
import com.jingguan.uploadImage.controller.uploadImage;
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
import java.util.List;

/**
 * Created by 陈 on 2017/12/10.
 */
@Controller
@RequestMapping("scientificResearchMaterials")
public class MaterialController extends uploadImage {

    @Resource(name = "materialService")
    private MaterialService materialService;
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
        String strFileName="scientificResearchMaterials.xls";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("scienceResearchAdminCondition");
        materialService.getOutStream(os,condition);
        os.close();
        os.flush();

    }
    @RequestMapping("loadMaterial")
    @ResponseBody
    Page<TScientificresearchmaterialsEntity> loadMaterial(HttpServletRequest request,Page<TScientificresearchmaterialsEntity> page){
        request.getSession().setAttribute("scienceResearchAdminCondition",page.getFilterModel());//为了下载做准备
        page = materialService.loadMaterial(page);
        return page;
    }

    @RequestMapping("uploadMaterial")
    @ResponseBody
    void uploadMaterial(@RequestParam("file") MultipartFile file, HttpServletRequest request, int id){
        String path = "scientificResearchMaterials";

        String fileName = upload(file,path,request);
        String filename = file.getOriginalFilename();//不带路径
        materialService.uploadFile(fileName,filename,id);
    }

    @RequestMapping("getMaterialSrcById")
    @ResponseBody
    String getMaterialSrcById(int id){
        return materialService.getMaterialSrcById(id);
    }

    @RequestMapping("addMaterial")
    @ResponseBody
    int addMaterial(HttpServletRequest request,String name){
        return materialService.addMaterial(name);
    }

    @RequestMapping("editMaterial")
    @ResponseBody
    int editMaterial(HttpServletRequest request,int id,String name){
        return materialService.editMaterial(id,name);
    }

    @RequestMapping("deleteMaterial")
    @ResponseBody
    ResponseWrapper deleteMaterial(HttpServletRequest request, String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        List list = new ArrayList();
        int user_id = (int)request.getSession().getAttribute("user_id");
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                int status = materialService.deleteMaterial(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;

    }


}
