package com.jingguan.honorStatistics.service.impl;

import com.jingguan.common.vo.Page;
import com.jingguan.honorStatistics.dao.LoadHonorDao;
import com.jingguan.honorStatistics.po.THonorStatisticsEntity;
import com.jingguan.honorStatistics.service.HonorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 陈 on 2017/10/22.
 */
@Service("honorService")
public class HonorServiceImpl implements HonorService {
    @Resource(name = "loadHonorDao")
    private LoadHonorDao loadHonorDao;

    @Override
    public Page<THonorStatisticsEntity> find(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        filterModel.getRules().add(new Page.FilterModel.Rule("id", 1, "eq"));
        page.addFilter(filterModel);
        return loadHonorDao.findHonor(page);
    }
}
