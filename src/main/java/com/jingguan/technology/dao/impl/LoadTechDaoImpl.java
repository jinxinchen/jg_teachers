package com.jingguan.technology.dao.impl;

import com.jingguan.admin.po.VAdminArticleEntity;
import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.technology.dao.LoadTechnologyDao;
import com.jingguan.technology.po.TTechnologyEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by 陈 on 2017/11/16.
 */
@Repository("techDao")
public class LoadTechDaoImpl extends BaseDao implements LoadTechnologyDao {
    @Override
    public Page loadTech(Page page) {
        return listRecordsByCon(page, TTechnologyEntity.class);
    }
}
