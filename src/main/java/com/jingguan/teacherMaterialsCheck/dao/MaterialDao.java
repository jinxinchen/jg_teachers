package com.jingguan.teacherMaterialsCheck.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterialsCheck.po.VTeacherMaterialsEntity;

import java.util.List;

/**
 * Created by 陈 on 2017/12/10.
 */
public interface MaterialDao {

    List<VTeacherMaterialsEntity> getList(Page.FilterModel condition);
    Page loadMaterial(Page page);
    void uploadFile(String fileName, String filename, int id);
    String getMaterialSrcById(int id);

}
