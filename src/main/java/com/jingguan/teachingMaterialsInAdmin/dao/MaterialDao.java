package com.jingguan.teachingMaterialsInAdmin.dao;

import com.jingguan.common.vo.Page;

/**
 * Created by 陈 on 2017/12/10.
 */
public interface MaterialDao {
    Page loadMaterial(Page page);
    void uploadFile(String fileName, String filename, int id);
    String getMaterialSrcById(int id);
    int addMaterial(String name);
    int editMaterial(int id, String name);
    int deleteMaterial(int id);
}
