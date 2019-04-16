package com.jingguan.copyRight.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.copyRight.po.TCopyrightEntity;
import com.jingguan.copyRight.service.CopyRightService;
import com.jingguan.uploadExcel.controller.test2;
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
import java.util.List;

/**
 * Created by 陈 on 2017/11/12.
 */
@Controller
@RequestMapping("copyRight")
public class CopyRightController {

    @Resource(name = "copyRightService")
    private CopyRightService copyRightService;


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
        String strFileName="copyRight.xls";// 默认Excel名称
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
        Page.FilterModel condition=(Page.FilterModel)request.getSession().getAttribute("copyRightTeacherCondition");
        copyRightService.getOutStream(os,condition);
        os.close();
        os.flush();


    }






    @RequestMapping("loadCopyRight")
    @ResponseBody
    Page<TCopyrightEntity> loadCopyRight(HttpServletRequest request,Page<TCopyrightEntity> page){

        request.getSession().setAttribute("copyRightTeacherCondition",page.getFilterModel());
        int user_id = (int) request.getSession().getAttribute("user_id");
        page = copyRightService.loadCopyRight(user_id,page);
        return page;
    }

    @RequestMapping("addCopyRight")
    @ResponseBody
    int addCopyRight(HttpServletRequest request,TCopyrightEntity tCopyrightEntity){
        int user_id = (int) request.getSession().getAttribute("user_id");
        return copyRightService.addCopyRight(user_id,tCopyrightEntity);
    }

    @RequestMapping("editCopyRight")
    @ResponseBody
    int editCopyRight(HttpServletRequest request,TCopyrightEntity tCopyrightEntity){
        int user_id = (int) request.getSession().getAttribute("user_id");
        return copyRightService.editCopyRight(user_id,tCopyrightEntity);
    }


    @RequestMapping("deleteCopyRight")
    @ResponseBody
    ResponseWrapper deleteCopyRight(HttpServletRequest request,String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                int status = copyRightService.deleteCopyRight(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    //导入模板
    @RequestMapping("inCopyRight")
    void in(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = test2.uploadExcelTest(request,file);
            int user_id = (int)request.getSession().getAttribute("user_id");
            copyRightService.inCopyRight(list,user_id);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取该记录文件路径
    @RequestMapping("getCopyRightSrcById")
    @ResponseBody
    String getCopyRightSrcById(int id,HttpServletRequest request){
        return copyRightService.getCopyRightSrcById(id);
    }
}
