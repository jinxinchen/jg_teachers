package com.jingguan.teachingArchives.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.teachingArchives.po.TAdminTeachingMaterialsEntity;
import com.jingguan.teachingArchives.service.TeachingArchivesService;
import com.jingguan.uploadImage.controller.uploadImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈 on 2018/6/16.
 */
@Controller
@RequestMapping("teachingArchives")
public class TeachingArchives extends uploadImage {

    @Resource(name = "adminTeachingArchivesService")
    private TeachingArchivesService teachingArchivesService;

    @RequestMapping("loadMaterial")
    @ResponseBody
    Page<TAdminTeachingMaterialsEntity> loadMaterial(HttpServletRequest request, Page<TAdminTeachingMaterialsEntity> page,String status){
        page = teachingArchivesService.loadMaterial(page,status);
        return page;
    }

    @RequestMapping("addMaterial")
    @ResponseBody
    int addMaterial(HttpServletRequest request,String name,String type,String status){
        return teachingArchivesService.addMaterial(name,type,status);
    }

    @RequestMapping("editMaterial")
    @ResponseBody
    int editMaterial(HttpServletRequest request,int id,String name,String type){
        return teachingArchivesService.editMaterial(id,name,type);
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
                teachingArchivesService.deleteMaterial(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;

    }

    @RequestMapping("uploadMaterial")
    @ResponseBody
    void uploadMaterial(@RequestParam("file") MultipartFile file, HttpServletRequest request, int id){
        String path = "adminTeachingMaterials";

        String fileName = upload(file,path,request);
        String filename = file.getOriginalFilename();//不带路径
        teachingArchivesService.uploadFile(fileName,filename,id);
    }

    @RequestMapping("getMaterialSrcById")
    @ResponseBody
    String getMaterialSrcById(int id){
        return teachingArchivesService.getMaterialSrcById(id);
    }
}
