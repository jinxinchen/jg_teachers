package com.jingguan.abilityProject.controller;

import com.jingguan.abilityProject.po.TAbilityProjectEntity;
import com.jingguan.abilityProject.service.AbilityProjectService;
import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.download.downLoadController;
import com.jingguan.uploadExcel.controller.test2;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 陈 on 2017/11/18.
 */
@Controller
@RequestMapping("abilityProject")
public class AbilityProjectController extends uploadImage {

    @Resource(name = "abilityProjectService")
    private AbilityProjectService abilityProjectService;


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
        String strFileName="abilityProject.xls";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("abilityTeacherCondition");
        abilityProjectService.getOutStream(os,condition);
        os.close();
        os.flush();


    }


    @RequestMapping("loadAbilityProject")
    @ResponseBody
    Page<TAbilityProjectEntity> loadAbilityProject(HttpServletRequest request,Page<TAbilityProjectEntity> page){
        int user_id = (int) request.getSession().getAttribute("user_id");
        request.getSession().setAttribute("abilityTeacherCondition",page.getFilterModel());
        return abilityProjectService.loadAbilityProject(user_id,page);
    }

    @RequestMapping("editAbilityProject")
    @ResponseBody
    int editAbilityProject(HttpServletRequest request,TAbilityProjectEntity tAbilityProjectEntity){
        int user_id = (int) request.getSession().getAttribute("user_id");

        return abilityProjectService.editAbilityProject(user_id,tAbilityProjectEntity);
    }

    @RequestMapping("addAbilityProject")
    @ResponseBody
    int addAbilityProject(HttpServletRequest request,TAbilityProjectEntity tAbilityProjectEntity){
        int user_id = (int) request.getSession().getAttribute("user_id");
        return abilityProjectService.addAbilityProject(user_id,tAbilityProjectEntity);
    }

    @RequestMapping("deleteAbilityProject")
    @ResponseBody
    ResponseWrapper deleteAbilityProject(HttpServletRequest request,String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                int status = abilityProjectService.deleteAbilityProject(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    @RequestMapping("getAbilityProjectSrcById")
    @ResponseBody
    String getAbilityProjectSrcById(int id,HttpServletRequest request){
        return abilityProjectService.getAbilityProjectSrcById(id);
    }

    @RequestMapping("uploadAbility")
    @ResponseBody
    void uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, int id){
        int user_id = (int) request.getSession().getAttribute("user_id");
        String path = "abilityProject";

        String fileName = upload(file,path,request);
        String filename = file.getOriginalFilename();//不带路径
        abilityProjectService.uploadFile(fileName,filename,id,user_id);

    }

    //下载文件
    @RequestMapping("downLoadAbility")
    @ResponseBody
    void downLoadArticle(@RequestParam("fileName")String fileName, HttpServletRequest request, HttpServletResponse response){
        String path = "abilityProject";
        downLoadController downLoadController = new downLoadController();
        downLoadController.downLoad(fileName,path,request,response);

    }


    //导入模板
    @RequestMapping("inAbilityProject")
    void in(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = test2.uploadExcelTest(request,file);
            int user_id = (int)request.getSession().getAttribute("user_id");
            abilityProjectService.inAbilityProject(list,user_id);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取user_id
    @RequestMapping("getUserIdInAbility")
    @ResponseBody
    Map getUserId(HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        Map map = new HashMap();
        map.put("user_id",user_id);
        return map;
    }
}
