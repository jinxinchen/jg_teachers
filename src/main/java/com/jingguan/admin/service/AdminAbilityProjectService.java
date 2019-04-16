package com.jingguan.admin.service;

import com.jingguan.admin.po.VAdminAbilityprojectEntity;
import com.jingguan.common.vo.Page;
import jxl.write.WriteException;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by 陈 on 2017/11/20.
 */
public interface AdminAbilityProjectService {
    Page loadAbilityProject(Page page);
    int passAbilityProject(int id);
    void inAbilityProject(List<String[]> lists);
    void getOutAbilityProjectStream(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;
    public List<VAdminAbilityprojectEntity> getAbilityProjectLists(Page.FilterModel condition);
}
