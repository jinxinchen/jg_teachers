package com.jingguan.honorStatistics.service;

import com.jingguan.common.vo.Page;
import com.jingguan.honorStatistics.po.THonorStatisticsEntity;

/**
 * Created by 陈 on 2017/10/22.
 */
public interface HonorService {
    Page<THonorStatisticsEntity> find(Page page);
}
