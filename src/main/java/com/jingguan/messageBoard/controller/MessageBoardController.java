package com.jingguan.messageBoard.controller;

import com.jingguan.common.vo.Page;
import com.jingguan.common.vo.ResponseWrapper;
import com.jingguan.messageBoard.po.TMessageAboardEntity;
import com.jingguan.messageBoard.po.VMessageboardEntity;
import com.jingguan.messageBoard.service.MessageBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈 on 2018/5/17.
 */
@Controller
@RequestMapping("messageBoard")
public class MessageBoardController {

    @Resource(name = "messageBoardService")
    private MessageBoardService messageBoardService;

    @RequestMapping("loadMessageBoard")
    @ResponseBody
    Page<TMessageAboardEntity> loadMessageBoard(HttpServletRequest request, Page<TMessageAboardEntity> page){
        int user_id = (int) request.getSession().getAttribute("user_id");
        page = messageBoardService.loadMessageBoard(page,user_id);
        return page;
    }

    @RequestMapping("addMessageBoard")
    @ResponseBody
    int addMessageBoard(HttpServletRequest request, TMessageAboardEntity tMessageAboardEntity){
        int user_id = (int) request.getSession().getAttribute("user_id");
        int status = messageBoardService.addMessageBoard(user_id,tMessageAboardEntity);

        if(status == 200){
            return 200;
        }else{
            return 0;
        }
    }

    @RequestMapping("editMessageBoard")
    @ResponseBody
    int editArticle(HttpServletRequest request, TMessageAboardEntity tMessageAboardEntity){
        int user_id = (int) request.getSession().getAttribute("user_id");
        int res = messageBoardService.editMessageBoard(user_id,tMessageAboardEntity);
        if(res == 200){
            return 200;
        }else{
            return 0;
        }
    }

    @RequestMapping("deleteMessageBoard")
    @ResponseBody
    ResponseWrapper deleteWorkExp(HttpServletRequest request, String id){
        ResponseWrapper wrapper=new ResponseWrapper();
        wrapper.setSuccess(true);
        List list = new ArrayList();
        int user_id = (int)request.getSession().getAttribute("user_id");
        String[] ids=id.split(",");     try {
            for (int i=0;i<ids.length;i++){
                int status = messageBoardService.deleteMessageBoard(Integer.valueOf(ids[i].trim()));
            }
            wrapper.setSuccess(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return wrapper;
    }

    @RequestMapping("loadMessageBoardAdmin")
    @ResponseBody
    Page<VMessageboardEntity> loadMessageBoardAdmin(HttpServletRequest request, Page<VMessageboardEntity> page){
        int user_id = (int) request.getSession().getAttribute("user_id");
        page = messageBoardService.loadMessageBoardAdmin(page,user_id);
        return page;
    }
}
