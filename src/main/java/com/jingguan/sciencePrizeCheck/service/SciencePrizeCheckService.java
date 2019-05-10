package com.jingguan.sciencePrizeCheck.service;

import com.jingguan.common.vo.Page;
import com.jingguan.sciencePrize.po.TEducateScientificEntity;
import com.jingguan.sciencePrizeCheck.po.VTeachersPrizeCheckEntity;
import jxl.write.WriteException;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhouliang on 2017/11/19 0019.
 */
public interface SciencePrizeCheckService {


    public Page<VTeachersPrizeCheckEntity> listRecordsByConditions(Page page);

    public void updateRecord(TEducateScientificEntity tEducateScientificEntity);

    public void getOutStream(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;

    public List<VTeachersPrizeCheckEntity> getLists(Page.FilterModel condition);

    public void check(String id);

    void inSciencePrize(List<String[]> list);
    int getUserIdByTname(String name);
}
