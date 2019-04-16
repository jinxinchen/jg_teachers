package com.jingguan.uploadImage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by 陈 on 2017/10/28.
 */
public class UploadImages {

/*    public ModelAndView upload(@RequestParam("file") MultipartFile file, HttpServletRequest request){
//        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "imageUploadFile/";
//        String filename = file.getOriginalFilename();
//
//        //判断相应路径是否存在，不存在则创建
//        File dir = new File(uploadUrl);
//        if(!dir.exists()){
//            dir.mkdir();
//        }
//
//        File targetFile = new File(uploadUrl + filename);
//        if(!targetFile.exists()){
//            try {
//                targetFile.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        //移动上传文件
//        try {
//            file.transferTo(targetFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String imageSrc = "http://127.0.0.1:8080/teachers/imageUploadFile/" + filename;
//        ModelAndView mv = new ModelAndView("redirect:/res.html","src",imageSrc);
//        return mv;
//    }
*/

    public String upload(MultipartFile file, HttpServletRequest request){
        String uploadUrl = request.getSession().getServletContext().getRealPath("/") + "imageUploadFile/";
        String filename = file.getOriginalFilename();

        //判断相应路径是否存在，不存在则创建
        File dir = new File(uploadUrl);
        if(!dir.exists()){
            dir.mkdir();
        }

        File targetFile = new File(uploadUrl + filename);
        if(!targetFile.exists()){
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //移动上传文件
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String imageSrc = "http://192.168.213.253:8080/teachers/imageUploadFile/" + filename;
        return imageSrc;
    }


}
