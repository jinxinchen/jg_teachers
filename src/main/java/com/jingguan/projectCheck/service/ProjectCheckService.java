package com.jingguan.projectCheck.service;

import com.jingguan.common.vo.Page;
import com.jingguan.projectCheck.po.TScientificEntity;
import jxl.write.WriteException;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhouliang on 2017/11/22 0022.
 */
public interface ProjectCheckService {
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;

    public List<TScientificEntity> getLists(Page.FilterModel condition);

    public Page<TScientificEntity> listRecordsByConditions(Page page);

    public void check(String id);

    void inScienceProject(List<String[]> lists);
}
