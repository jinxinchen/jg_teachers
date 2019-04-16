package com.jingguan.admin.service;

import com.jingguan.common.vo.Page;

import java.util.List;

/**
 * Created by 陈 on 2017/11/15.
 */
public interface AdminCopyRightService {
    Page loadAdminCopyRight(Page page);
    int passCopyRight(int id);
    void inCopyRight(List<String[]> lists);
}
