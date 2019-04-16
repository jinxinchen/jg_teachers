package com.jingguan.project.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.project.po.VProjectUserEntity;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
public interface VProjectUserEntityDao {

    public Page<VProjectUserEntity> listRecordsByCondition(Page page);

}
