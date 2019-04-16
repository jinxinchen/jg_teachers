package com.jingguan.teachingMaterialsInAdmin.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.teachingMaterialsInAdmin.po.TAdminTeachingMaterialsEntity;
import com.jingguan.teachingMaterialsInAdmin.service.MaterialService;
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
 * Created by 陈 on 2017/12/23.杂乱的资料
 */
@Controller
@RequestMapping("admin/teachingUnknowMaterials")
public class AdminTechingUnknowMaterialsController extends uploadImage {


    @Resource(name = "adminTeachingMaterialService")
    private MaterialService materialService;
    @RequestMapping("loadMaterial")
    @ResponseBody
    Page<TAdminTeachingMaterialsEntity> loadMaterial(HttpServletRequest request, Page<TAdminTeachingMaterialsEntity> page){
        page = materialService.loadMaterial(page);
        return page;
    }

    @RequestMapping("uploadMaterial")
    @ResponseBody
    void uploadMaterial(@RequestParam("file") MultipartFile file, HttpServletRequest request, int id){
        String path = "adminTeachingMaterials";

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
    List deleteMaterial(HttpServletRequest request, int id){
        List list = new ArrayList();
        int status = materialService.deleteMaterial(id);
        if(status == 200){
            list.add(1);
            return list;
        }else{
            return null;
        }
    }
}
