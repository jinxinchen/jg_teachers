package com.jingguan.technology.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.technology.po.TTechnologyEntity;
import com.jingguan.technology.service.LoadTechService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 陈 on 2017/11/16.
 */
@Controller
@RequestMapping("tech")
public class LoadTechnologyController {

    @Resource(name = "techService")
    private LoadTechService loadTechService;

    static Page.FilterModel Techcondition;
    static List<TTechnologyEntity> Techlist;


    @RequestMapping("loadTech")
    @ResponseBody
    Page<TTechnologyEntity> loadTech(Page<TTechnologyEntity> page, HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        return loadTechService.loadTech(page,user_id);
    }

    @RequestMapping("requestTechUpload")
    @ResponseBody
    public String requestCopyRightExcelData(HttpServletRequest request) {

        if(Techlist==null||Techlist.size()==0){
            return "false";
        }
        return "success";

    }
}
