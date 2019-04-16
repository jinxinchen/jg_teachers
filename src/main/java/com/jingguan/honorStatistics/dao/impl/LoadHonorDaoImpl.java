package com.jingguan.honorStatistics.dao.impl;

import com.jingguan.common.dao.impl.BaseDao;
import com.jingguan.common.vo.Page;
import com.jingguan.honorStatistics.dao.LoadHonorDao;
import com.jingguan.honorStatistics.po.THonorStatisticsEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by 陈 on 2017/10/22.
 */
@Repository("loadHonorDao")
public class LoadHonorDaoImpl extends BaseDao implements LoadHonorDao {


    @Override
    public Page findHonor(Page page) {
        return listRecordsByCon(page,THonorStatisticsEntity.class);
    }
}
