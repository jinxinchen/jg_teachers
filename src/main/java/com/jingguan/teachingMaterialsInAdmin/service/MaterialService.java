package com.jingguan.teachingMaterialsInAdmin.service;

import com.jingguan.common.vo.Page;
import com.jingguan.teachingMaterialsInAdmin.po.TAdminTeachingMaterialsEntity;

/**
 * Created by 陈 on 2017/12/10.
 */
public interface MaterialService {
    Page<TAdminTeachingMaterialsEntity> loadMaterial(Page page);
    void uploadFile(String fileName, String filename, int id);
    String getMaterialSrcById(int id);
    int addMaterial(String name);
    int editMaterial(int id, String name);
    int  deleteMaterial(int id);
}
