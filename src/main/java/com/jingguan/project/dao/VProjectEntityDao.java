package com.jingguan.project.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.project.po.VProjectEntity;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
public interface VProjectEntityDao {

    public Page<VProjectEntity> listRecordsByCondition(Page page);

}
