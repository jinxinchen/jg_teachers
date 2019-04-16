package com.jingguan.project.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.project.dao.VProjectEntityDao;
import com.jingguan.project.po.VProjectEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
@Repository("vProjectEntityDao")
public class VProjectEntityDaoImpl extends BaseDao implements VProjectEntityDao {
    @Override
    public Page<VProjectEntity> listRecordsByCondition(Page page) {
        return listRecordsByCon(page,VProjectEntity.class);
    }
}
