package com.jingguan.admin.service;

import com.jingguan.admin.po.VAdminArticleEntity;
import com.jingguan.admin.po.VAdminCopyrightEntity;
import com.jingguan.common.vo.Page;
import jxl.write.WriteException;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by 陈 on 2017/11/14.
 */
public interface AdminArticleService {
    Page loadAdminArticle(Page page);
    int passArticle(int id);
    void getOutStream(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;
    public List<VAdminArticleEntity> getLists(Page.FilterModel condition);
    void getOutCopyRightStream(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;
    public List<VAdminCopyrightEntity> getCopyRightLists(Page.FilterModel condition);
    void inArticle(List<String[]> lists);
}
