package com.jingguan.admin.dao;

import com.jingguan.admin.po.TCopyrightEntity;
import com.jingguan.common.vo.Page;

/**
 * Created by 陈 on 2017/11/15.
 */
public interface AdminCopyRightDao {
    Page loadAdminCopyRight(Page page);
    int passCopyRight(int id);
    void inCopyRight(TCopyrightEntity tCopyrightEntity);
}
