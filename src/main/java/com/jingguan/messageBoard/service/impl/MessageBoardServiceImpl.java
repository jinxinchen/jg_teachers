package com.jingguan.messageBoard.service.impl;

import com.jingguan.common.vo.Page;
import com.jingguan.messageBoard.dao.MessageBoardDao;
import com.jingguan.messageBoard.po.TMessageAboardEntity;
import com.jingguan.messageBoard.po.VMessageboardEntity;
import com.jingguan.messageBoard.service.MessageBoardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 陈 on 2018/5/17.
 */
@Service("messageBoardService")
public class MessageBoardServiceImpl implements MessageBoardService {

    @Resource(name = "messageBoardDao")
    private MessageBoardDao messageBoardDao;

    @Override
    public Page<TMessageAboardEntity> loadMessageBoard(Page page, int user_id) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        filterModel.getRules().add(new Page.FilterModel.Rule("userId", user_id, "eq"));
        page.addFilter(filterModel);
        return messageBoardDao.loadMessageBoard(page);
    }

    @Override
    public int addMessageBoard(int user_id, TMessageAboardEntity tMessageAboardEntity) {
        return messageBoardDao.addMessageBoard(user_id,tMessageAboardEntity);
    }

    @Override
    public int editMessageBoard(int user_id, TMessageAboardEntity tMessageAboardEntity) {
        return messageBoardDao.editMessageBoard(user_id,tMessageAboardEntity);
    }

    @Override
    public int deleteMessageBoard(int id) {
        return messageBoardDao.deleteMessageBoard(id);
    }

    @Override
    public Page<VMessageboardEntity> loadMessageBoardAdmin(Page page, int user_id) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        page.addFilter(filterModel);
        return messageBoardDao.loadMessageBoardAdmin(page);
    }
}
