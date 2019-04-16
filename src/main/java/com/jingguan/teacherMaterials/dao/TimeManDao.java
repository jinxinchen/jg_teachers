package com.jingguan.teacherMaterials.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.teacherMaterials.po.TimeMan;

/**
 * Created by zhouliang on 2017/12/17 0017.
 */
public interface TimeManDao {

    public  void updateRecords(TimeMan tTeachingMaterialEntity);

    public Page<TimeMan> listRecordsByCondition(Page page);
    public TimeMan getRecords(Integer id);
}
