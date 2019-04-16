package com.jingguan.teacherMaterialsCheck.service.impl;


import com.jingguan.common.tool.ExportExcel;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterialsCheck.dao.MaterialDao;
import com.jingguan.teacherMaterialsCheck.po.VTeacherMaterialsEntity;
import com.jingguan.teacherMaterialsCheck.service.MaterialService;
import jxl.write.WriteException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhouliang on 2018/2/9 0009.
 */
@Service("materialAdminService")
public class MaterialServiceImpl implements MaterialService {

    @Resource(name="materialAdminDao")
    private MaterialDao materialDao;


    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<VTeacherMaterialsEntity> data=materialDao.getList(condition);
        String[] heads={
                "姓名",
                "课程名称",
                "上课学期",
                "类型",
                "上传时间"};
        String[] fields={"name","courseName","semester","type","fileTime"};
        ExportExcel.getOS(os,data,fields,heads);
    }

    @Override
    public void getOutStreamPostGraduateArticle(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamPostGraduateKeyan(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamPostGraduateJingsai(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamStuAbroad(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamStuInfo(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public Page<VTeacherMaterialsEntity> loadMaterial(Page page) {
        return materialDao.loadMaterial(page);
    }



    @Override
    public String getMaterialSrcById(int id) {
        return materialDao.getMaterialSrcById(id);
    }
}
