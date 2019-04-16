package com.jingguan.technology.service.impl;

import com.jingguan.common.vo.Page;
import com.jingguan.technology.dao.LoadTechnologyDao;
import com.jingguan.technology.service.LoadTechService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 陈 on 2017/11/16.
 */
@Service("techService")
public class LoadTechServiceImpl implements LoadTechService{

    @Resource(name = "techDao")
    private LoadTechnologyDao loadTechnologyDao;
    @Override
    public Page loadTech(Page page,int user_id) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
//        filterModel.getRules().add(new Page.FilterModel.Rule("user_id", user_id, "eq"));
        page.addFilter(filterModel);
        return loadTechnologyDao.loadTech(page);
    }
}
