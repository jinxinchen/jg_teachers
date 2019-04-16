package com.jingguan.teachingArchives.service;

import com.jingguan.common.vo.Page;
import com.jingguan.teachingArchives.po.TAdminTeachingMaterialsEntity;

/**
 * Created by 陈 on 2018/6/16.
 */
public interface TeachingArchivesService {
    Page<TAdminTeachingMaterialsEntity> loadMaterial(Page page,String status);
    int addMaterial(String name,String type,String status);
    int editMaterial(int id, String name,String type);
    int  deleteMaterial(int id);
    void uploadFile(String fileName, String filename, int id);
    String getMaterialSrcById(int id);
}
