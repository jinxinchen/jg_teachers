package com.jingguan.teacherActivityCheck.service;

import com.jingguan.common.vo.Page;
import com.jingguan.teacherActivityCheck.po.VTeachersActivityCheckEntity;
import jxl.write.WriteException;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhouliang on 2017/11/13 0013.
 */
public interface ActivityCheckService {

    public Page<VTeachersActivityCheckEntity> listRecordsByConditions(Page page);

    public void updateRecord(String id, String status);

    public void getOutStream(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;

    public List<VTeachersActivityCheckEntity> getLists(Page.FilterModel condition);

    public void check(String id);

    void inActivity(List<String[]> list);
}
