package com.jingguan.degree.controller;

import com.jingguan.degree.po.TEducateDegreeEntity;
import com.jingguan.degree.po.VDegreeInfoEntity;
import com.jingguan.degree.service.DegreeInfoService;
import com.jingguan.uploadImage.controller.uploadImage;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 陈 on 2017/11/5.
 */
@Controller
@RequestMapping("degree")
public class DegreeController extends uploadImage {

    @Resource(name = "degreeInfoService")
    private DegreeInfoService degreeInfoService;

    @RequestMapping(value = "loadDegreeInfo",method = RequestMethod.GET)
    @ResponseBody
    List<TEducateDegreeEntity> loadInfo(HttpServletRequest request,String id){
        int user_id;
        if(StringUtils.isEmpty(id)){
            user_id = (int) request.getSession().getAttribute("user_id");
        }else{
            user_id = Integer.parseInt(id);
        }
       List<TEducateDegreeEntity> info = degreeInfoService.loadDegreeInfo(user_id);
       if(info.size() > 0){
           request.getSession().setAttribute("degree_id",info.get(0).getId());
       }
       return info;
    }

    @RequestMapping("saveDegreeInfo")
    @ResponseBody
    int saveDegreeInfo(HttpServletRequest request, TEducateDegreeEntity tEducateDegreeEntity, MultipartFile educate_degree_src){
//        String ressrc = upload(educate_degree_src,request);
        String ressrc = "test";
        int user_id = (int) request.getSession().getAttribute("user_id");
        int degree_id = degreeInfoService.saveDegreeInfo(tEducateDegreeEntity,user_id);
        if(degree_id != 0){
            request.getSession().setAttribute("degree_id",degree_id);
        }
        return degree_id;
    }

    @RequestMapping(value = "updateDegreeInfo")
    @ResponseBody
    int updateDegreeInfo(HttpServletRequest request,TEducateDegreeEntity tEducateDegreeEntity){

        int user_id;
        if(tEducateDegreeEntity.getUserId()==null){
            user_id = (int) request.getSession().getAttribute("user_id");
        }else{
            user_id =tEducateDegreeEntity.getUserId();
        }
        //int degree_id = (int) request.getSession().getAttribute("degree_id");
        int res = degreeInfoService.updateDegreeInfo(user_id,tEducateDegreeEntity);
        if(res == 200){
            return 200;
        }else{
            return 0;
        }

    }

    //上传文件
    @RequestMapping("uploadDegree")
    @ResponseBody
    void uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        int id = (int) request.getSession().getAttribute("degree_id");
        String path = "degree";

        String fileName = upload(file,path,request);
        String filename = file.getOriginalFilename();//不带路径
        degreeInfoService.uploadFile(fileName,filename,id,user_id);

    }

    @RequestMapping("getDegreeSrcById")
    @ResponseBody
    String getDegreeSrcById(HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        int id = (int) request.getSession().getAttribute("degree_id");
        return degreeInfoService.getDegreeSrcById(id);
    }

    //导师文件上传
    @RequestMapping("uploadDegreeMentor")
    @ResponseBody
    void uploadDegreeMentor(@RequestParam("file") MultipartFile file, HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        int id = (int) request.getSession().getAttribute("degree_id");
        String path = "degreeMentor";

        String fileName = upload(file,path,request);
        String filename = file.getOriginalFilename();//不带路径
        degreeInfoService.uploadMentorFile(fileName,filename,id,user_id);
    }

    @RequestMapping("getDegreeMentorSrcById")
    @ResponseBody
    String getDegreeMentorSrcById(HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        int id = (int) request.getSession().getAttribute("degree_id");
        return degreeInfoService.getDegreeMentorSrcById(id);
    }

    @RequestMapping("getUserIdAndDegreeId")
    @ResponseBody
    Map getUserIdAndId(HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        int id = (int) request.getSession().getAttribute("degree_id");
        Map map = new HashMap();
        map.put("user_id",user_id);
        map.put("id",id);
        return map;
    }
}
