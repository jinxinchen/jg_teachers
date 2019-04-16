package com.jingguan.copyRight.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.copyRight.po.TCopyrightEntity;

import java.util.List;

/**
 * Created by 陈 on 2017/11/12.
 */
public interface CopyRightDao {

    List<TCopyrightEntity> getList(Page.FilterModel condition);
    Page loadCopyRight(Page page);
    int addCopyRight(int user_id, TCopyrightEntity tCopyrightEntity);
    int editCopyRight(int user_id, TCopyrightEntity tCopyrightEntity);
    int deleteCopyRight(int id);
    void inCopyRight(TCopyrightEntity tCopyrightEntity);
    String getCopyRightSrcById(int id);
}
