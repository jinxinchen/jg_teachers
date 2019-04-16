package com.jingguan.manageTeachers.service;

import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;
import com.jingguan.manageTeachers.po.TEducateDegreeEntity;
import com.jingguan.manageTeachers.po.TTeacherBaseinfoUpdate;
import com.jingguan.manageTeachers.po.VManageteachersBaseinfoEntity;
import jxl.write.WriteException;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by 陈 on 2017/12/12.
 */
public interface ManageService extends ExportExcelImpl {

    public void getOutAccountStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException;
    Page loadTeachers(Page page);
    Page loadRecord(Page page);
    void saveUserAccounts(List<String> accounts);
    void saveUserAccountByExcel(List<String[]> list);
    int editAccount(int id, String account, String password);
    void deleteAccount(int id);

    void  updateDegree(TEducateDegreeEntity tEducateDegreeEntity, TTeacherBaseinfoUpdate tTeacherBaseinfoUpdate);

    VManageteachersBaseinfoEntity getBaseinfoById(Integer id);
    void deleteBaseInfo(Integer userId);
}
