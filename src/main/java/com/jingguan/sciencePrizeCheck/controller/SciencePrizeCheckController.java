package com.jingguan.sciencePrizeCheck.controller;

import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.tool.MergeTool;
import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.sciencePrize.po.TEducateScientificEntity;
import com.jingguan.sciencePrizeCheck.po.VTeachersPrizeCheckEntity;
import com.jingguan.sciencePrizeCheck.service.SciencePrizeCheckService;

import com.jingguan.uploadExcel.controller.test2;
import jxl.write.WriteException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
 * Created by zhouliang on 2017/11/19 0019.
 */
@Controller
@RequestMapping("admin/sciencePrize")
public class SciencePrizeCheckController extends test2 {

    @Resource(name="sciencePrizeCheckService")
    private SciencePrizeCheckService sciencePrizeCheckService;


    //static Page.FilterModel condition;
    static List<VTeachersPrizeCheckEntity> list;

    @RequestMapping(value = "listPrizeRecord",method = RequestMethod.GET)
    @ResponseBody
    Page listRecords(HttpServletRequest request, Page page){

        //带着条件过来，返回时将条件清空了
        //condition=page.getFilterModel();//为了下载做准备
        request.getSession().setAttribute("sciencePrizeAdminCondition",page.getFilterModel());
        try {
            sciencePrizeCheckService.listRecordsByConditions(page);
           // list=page.getResult();          //判断有没有数据可以下载

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  page;
    }

    @RequestMapping(value="updatePrizeRecord")
    @ResponseBody
    public ResponseWrapper updateRecord(HttpServletRequest request, VTeachersPrizeCheckEntity vTeachersPrizeCheckEntity){
        ResponseWrapper<String> wrapper=new ResponseWrapper<>();
        wrapper.setSuccess(false);
        //检查教师是不是存在
        UserDao userDao = new UserDao();
        Integer userId = userDao.findUserIdByTname(vTeachersPrizeCheckEntity.getName());
        if(userId == null){
            wrapper.setData("教师"+vTeachersPrizeCheckEntity.getName()+"不存在");
            return wrapper;
        }
        TEducateScientificEntity tEducateScientificEntity = new TEducateScientificEntity();
        MergeTool.mergeObject(vTeachersPrizeCheckEntity,tEducateScientificEntity);
        try {
            sciencePrizeCheckService.updateRecord(tEducateScientificEntity);
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
            wrapper.setData("服务器内部错误更新失败");
        }

        return wrapper;
    }

    @RequestMapping("inSciencePrize")
    @ResponseBody
    public int inSciencePrize(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = uploadExcelTest(request,file);
            sciencePrizeCheckService.inSciencePrize(list);
            return 200;

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }





    @RequestMapping(value = "downloadExcel")
    @ResponseBody
    public void requestExcelData(HttpServletRequest request,HttpServletResponse response) throws IOException,WriteException {

        request.setCharacterEncoding("UTF-8");
        //region 设置返回头文件,对于各个浏览器的兼容性
        String strFileName="prize.xls";// 默认Excel名称
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
        Page.FilterModel cond=(Page.FilterModel)request.getSession().getAttribute("sciencePrizeAdminCondition");
        sciencePrizeCheckService.getOutStream(os,cond);
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


    @RequestMapping(value = "check")
    @ResponseBody
    public String check(HttpServletRequest request,String id) {
        sciencePrizeCheckService.check(id);
        return "success";

    }

    @RequestMapping(value = "savePrizeRecord")
    @ResponseBody
    public String save(VTeachersPrizeCheckEntity vTeachersPrizeCheckEntity) {
        return "success";

    }


}
