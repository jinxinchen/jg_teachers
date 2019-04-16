package com.jingguan.common.tool;

import com.jingguan.common.vo.Page;
import jxl.write.WriteException;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

/**
 * Created by zhouliang on 2018/5/17 0017.
 */
public interface ExportExcelImpl {
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;

    public void getOutStreamPostGraduateArticle(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;

    public void getOutStreamPostGraduateKeyan(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;

    public void getOutStreamPostGraduateJingsai(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;

    public void getOutStreamStuAbroad(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;

    public void getOutStreamStuInfo(ServletOutputStream os, Page.FilterModel condition)throws IOException,WriteException;
}


