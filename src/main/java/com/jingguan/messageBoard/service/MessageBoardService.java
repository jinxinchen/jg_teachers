package com.jingguan.messageBoard.service;

import com.jingguan.common.vo.Page;
import com.jingguan.messageBoard.po.TMessageAboardEntity;
import com.jingguan.messageBoard.po.VMessageboardEntity;

/**
 * Created by 陈 on 2018/5/17.
 */
public interface MessageBoardService {
    Page<TMessageAboardEntity> loadMessageBoard(Page page, int user_id);
    int addMessageBoard(int user_id, TMessageAboardEntity tMessageAboardEntity);
    int editMessageBoard(int user_id, TMessageAboardEntity tMessageAboardEntity);
    int deleteMessageBoard(int id);
    Page<VMessageboardEntity> loadMessageBoardAdmin(Page page, int user_id);
}
