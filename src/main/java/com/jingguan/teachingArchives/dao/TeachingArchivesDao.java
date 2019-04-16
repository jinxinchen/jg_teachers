package com.jingguan.teachingArchives.dao;

import com.jingguan.common.vo.Page;

/**
 * Created by 陈 on 2018/6/16.
 */
public interface TeachingArchivesDao {

    Page loadMaterial(Page page);
    int addMaterial(String name,String type,String status);
    int editMaterial(int id, String name,String type);
    int deleteMaterial(int id);
    void uploadFile(String fileName, String filename, int id);
    String getMaterialSrcById(int id);
}
