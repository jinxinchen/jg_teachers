package com.jingguan.teacherMaterialsCheck.service;

import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterialsCheck.po.VTeacherMaterialsEntity;

/**
 * Created by 陈 on 2017/12/10.
 */
public interface MaterialService extends ExportExcelImpl {
    Page<VTeacherMaterialsEntity> loadMaterial(Page page);
    String getMaterialSrcById(int id);
}
