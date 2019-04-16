package com.jingguan.scientificResearchMaterials.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.scientificResearchMaterials.po.TScientificresearchmaterialsEntity;

import java.util.List;

/**
 * Created by 陈 on 2017/12/10.
 */
public interface MaterialDao {

    public List<TScientificresearchmaterialsEntity> getlist(Page.FilterModel condition);

    Page loadMaterial(Page page);
    void uploadFile(String fileName, String filename, int id);
    String getMaterialSrcById(int id);
    int addMaterial(String name);
    int editMaterial(int id, String name);
    int deleteMaterial(int id);
}
