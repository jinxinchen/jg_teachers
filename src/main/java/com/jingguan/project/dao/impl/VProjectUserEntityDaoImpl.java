package com.jingguan.project.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.project.dao.VProjectUserEntityDao;
import com.jingguan.project.po.VProjectUserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by zhouliang on 2017/12/13 0013.
 */
@Repository("vProjectUserEntityDao")
public class VProjectUserEntityDaoImpl extends BaseDao implements VProjectUserEntityDao {
    @Override
    public Page<VProjectUserEntity> listRecordsByCondition(Page page) {
        return listRecordsByCon(page,VProjectUserEntity.class);
    }
}
