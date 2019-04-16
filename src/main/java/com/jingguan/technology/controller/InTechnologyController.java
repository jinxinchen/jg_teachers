package com.jingguan.technology.controller;

import com.jingguan.technology.service.InTechnologyService;
import com.jingguan.uploadExcel.controller.test2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈 on 2017/10/25.
 */
@Controller
@RequestMapping("technology")
public class InTechnologyController extends test2 {
    @Resource(name = "inTechnologyService")
    private InTechnologyService inTechnologyService;

    @RequestMapping("inTechnology")
    void in(HttpServletRequest request, @RequestParam(required = false) MultipartFile file){
        try {
            List<String[]> list = uploadExcelTest(request,file);
            inTechnologyService.InTechnologies(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
