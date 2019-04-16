package com.jingguan.messageBoard.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.messageBoard.po.TMessageAboardEntity;

/**
 * Created by 陈 on 2018/5/17.
 */
public interface MessageBoardDao {
    Page loadMessageBoard(Page page);
    int addMessageBoard(int user_id, TMessageAboardEntity tMessageAboardEntity);
    int editMessageBoard(int user_id, TMessageAboardEntity tMessageAboardEntity);
    int deleteMessageBoard(int id);
    Page loadMessageBoardAdmin(Page page);
}
