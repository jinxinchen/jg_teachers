package com.jingguan.teacherMaterials.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterials.po.TTeachingMaterialEntity;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/17 0017.
 */
public interface TTeachingMaterialEntityDao {

    public List<TTeachingMaterialEntity> getLists(Page.FilterModel condition);
    public Page<TTeachingMaterialEntity> listRecordsByCondition(Page page);
    public  void saveRecords(TTeachingMaterialEntity tTeachingMaterialEntity);

    public  void updateRecords(TTeachingMaterialEntity tTeachingMaterialEntity);

    public  void deleteRecords(TTeachingMaterialEntity tTeachingMaterialEntity);

    public TTeachingMaterialEntity getRecords(Integer id);
}
