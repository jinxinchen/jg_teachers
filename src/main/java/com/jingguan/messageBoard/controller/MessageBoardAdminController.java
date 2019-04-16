package com.jingguan.messageBoard.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.messageBoard.po.TMessageAboardEntity;
import com.jingguan.messageBoard.po.VMessageboardEntity;
import com.jingguan.messageBoard.service.MessageBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 陈 on 2018/5/17.
 */
@Controller
@RequestMapping("messageBoardAdmin")
public class MessageBoardAdminController {

    @Resource(name = "messageBoardService")
    private MessageBoardService messageBoardService;

    @RequestMapping("loadMessageBoard")
    @ResponseBody
    Page<VMessageboardEntity> loadMessageBoard(HttpServletRequest request, Page<VMessageboardEntity> page){
        int user_id = (int) request.getSession().getAttribute("user_id");
        page = messageBoardService.loadMessageBoardAdmin(page,user_id);
        return page;
    }
}
