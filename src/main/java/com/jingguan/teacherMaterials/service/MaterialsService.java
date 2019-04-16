package com.jingguan.teacherMaterials.service;

import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterials.po.TTeachingMaterialEntity;
import com.jingguan.teacherMaterials.po.TimeMan;

/**
 * Created by zhouliang on 2017/12/17 0017.
 */
public interface MaterialsService extends ExportExcelImpl {
    public Page<TTeachingMaterialEntity> listRecordsByCondition(String userid, Page page);
    public Page<TimeMan> listDateRecordsByCondition(String userid, Page page);

    public void updatePath(String id, String path);

    public boolean saveRecord(String userId, TTeachingMaterialEntity record);

    public void updateRecord(TTeachingMaterialEntity records);
    public void updateTimeRecord(TimeMan records);

    public void deleteRecord(String id, String realp);

    public TTeachingMaterialEntity getRecord(Integer id);
    public TimeMan getTimeRecord(Integer id);

    public String getPath(String id);
}
