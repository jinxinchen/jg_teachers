package com.jingguan.article.controller;

import com.jingguan.article.po.TArticleEntity;
import com.jingguan.article.service.ArticleService;
import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.uploadExcel.controller.test2;
import com.jingguan.uploadImage.controller.uploadImage;
import com.jingguan.download.downLoadController;
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

/**
 * Created by 陈 on 2017/11/11.
 */
@Controller
@RequestMapping("article")
public class ArticleController extends uploadImage {

    @Resource(name = "articleService")
    private ArticleService articleService;



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
        String strFileName="article.xls";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("articleTeacherCondition");
        articleService.getOutStream(os,condition);
        os.close();
        os.flush();


    }





    @RequestMapping("loadArticle")
    @ResponseBody
    Page<TArticleEntity> loadArticle(HttpServletRequest request, Page<TArticleEntity> page){

        request.getSession().setAttribute("articleTeacherCondition",page.getFilterModel());
        int user_id = (int) request.getSession().getAttribute("user_id");

        page = articleService.loadArticle(page,user_id);
        return page;
    }

    @RequestMapping("addArticle")
    @ResponseBody
    int addArticle(HttpServletRequest request, TArticleEntity tArticleEntity){
        int user_id = (int) request.getSession().getAttribute("user_id");
        int status = articleService.addArticle(user_id,tArticleEntity);

        if(status == 200){
            return 200;
        }else{
            return 0;
        }
    }

    @RequestMapping("editArticle")
    @ResponseBody
    int editArticle(HttpServletRequest request, TArticleEntity tArticleEntity){
        int user_id = (int) request.getSession().getAttribute("user_id");

        int res = articleService.editArticle(user_id,tArticleEntity);
        if(res == 200){
            return 200;
        }else{
            return 0;
        }
    }

    @RequestMapping("deleteArticle")
    @ResponseBody
    ResponseWrapper deleteWorkExp(HttpServletRequest request, String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                int status = articleService.deleteArticle(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }


    //上传文件
    @RequestMapping("uploadArticle")
    @ResponseBody
    void uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request,int id){
        int user_id = (int) request.getSession().getAttribute("user_id");
        String path = "article";

        String fileName = upload(file,path,request);
        String filename = file.getOriginalFilename();//不带路径
        articleService.uploadFile(fileName,filename,id,user_id);

    }


    //下载文件
    @RequestMapping("downLoadArticle")
    @ResponseBody
    void downLoadArticle(@RequestParam("fileName")String fileName, HttpServletRequest request, HttpServletResponse response){
        String path = "imageUploadFile";
        downLoadController downLoadController = new downLoadController();
        downLoadController.downLoad(fileName,path,request,response);

    }


    //获取该记录文件路径
    @RequestMapping("getArticleSrcById")
    @ResponseBody
    String getArticleSrcById(int id,HttpServletRequest request){
        return articleService.getArticleSrcById(id);
    }

    //导入模板
    @RequestMapping("inArticle")
    void in(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = test2.uploadExcelTest(request,file);
            int user_id = (int)request.getSession().getAttribute("user_id");
            articleService.InArticle(list,user_id);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获取user_id
    @RequestMapping("getUserIdInArticle")
    @ResponseBody
    Map getUserId(HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        Map map = new HashMap();
        map.put("user_id",user_id);
        return map;
    }

}
