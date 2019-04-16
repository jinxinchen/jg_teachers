package com.jingguan.admin.dao;

import com.jingguan.admin.po.TArticleEntity;
import com.jingguan.admin.po.VAdminArticleEntity;
import com.jingguan.admin.po.VAdminCopyrightEntity;
import com.jingguan.common.vo.Page;

import java.util.List;

/**
 * Created by 陈 on 2017/11/14.
 */
public interface AdminArticleDao {
    Page loadAdminArticle(Page page);
    int passArticle(int id);
    List<VAdminArticleEntity> getLists(Page.FilterModel condition);

    List<VAdminCopyrightEntity> getCopyRightLists(Page.FilterModel condition);
    void inArticle(TArticleEntity tArticleEntity);
}
