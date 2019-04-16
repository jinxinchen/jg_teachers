package com.jingguan.scientificResearchMaterials.service;

import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;
import com.jingguan.scientificResearchMaterials.po.TScientificresearchmaterialsEntity;

/**
 * Created by 陈 on 2017/12/10.
 */
public interface MaterialService extends ExportExcelImpl {
    Page<TScientificresearchmaterialsEntity> loadMaterial(Page page);
    void uploadFile(String fileName, String filename, int id);
    String getMaterialSrcById(int id);
    int addMaterial(String name);
    int editMaterial(int id, String name);
    int  deleteMaterial(int id);
}
