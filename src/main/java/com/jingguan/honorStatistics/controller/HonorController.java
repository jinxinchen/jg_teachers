package com.jingguan.honorStatistics.controller;

/**
 * Created by 陈 on 2017/10/22.
 */

import com.jingguan.common.vo.Page;
import com.jingguan.honorStatistics.po.THonorStatisticsEntity;
import com.jingguan.honorStatistics.service.HonorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.print.attribute.standard.MediaSize;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("honor")
public class HonorController {
    @Resource(name = "honorService")
    private HonorService honorService;

    @RequestMapping("loadHonor")
    @ResponseBody
    Page<THonorStatisticsEntity> loadHonor(HttpServletRequest request,Page<THonorStatisticsEntity> page){

        return honorService.find(page);
    }
}
