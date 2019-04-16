package com.jingguan.project.controller;

import com.jingguan.project.service.UploadFileService;
import com.jingguan.uploadImage.controller.UploadImages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhouliang on 2017/12/13 0013.
 */
@Controller
@RequestMapping("teacher/project")
public class UploadFileController extends UploadImages {
    @Resource(name = "uploadFileService")
    private UploadFileService uploadFileService;

    @RequestMapping(value = "uploadCreate")
    @ResponseBody
    String uploadCreateEvidence(@RequestParam("file") MultipartFile file, @RequestParam("id") String id, HttpServletRequest request){
        String  path=upload(file,request);
        uploadFileService.uploadCreatePath(id,path);
        return path;
    }

    @RequestMapping(value = "uploadEnd")
    @ResponseBody
    String uploadEndEvidence(@RequestParam("file") MultipartFile file, @RequestParam("id") String id, HttpServletRequest request){
        String  path=upload(file,request);
        uploadFileService.uploadEndPath(id,path);
        return path;
    }

    @RequestMapping(value="downloadEnd")
    @ResponseBody
    String downloadEndEvidence( String id, HttpServletRequest request){
        String  path=uploadFileService.getEndPath(id);
        return path;
    }

    @RequestMapping(value="downloadCreate")
    @ResponseBody
    String downloadCreateEvidence( String id, HttpServletRequest request){
        String  path=uploadFileService.getCreatePath(id);
        return path;
    }

}
