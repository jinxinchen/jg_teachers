package com.jingguan.baseInfo.dao;

import com.jingguan.baseInfo.po.TWorkExperienceEntity;
import com.jingguan.common.vo.Page;

import java.util.List;

/**
 * Created by 陈 on 2017/10/29.
 */
public interface WorkExpDao {

    public List<TWorkExperienceEntity> getLists(Page.FilterModel condition);

    Page loadWorkExp(Page page);
    void addWorkExp(TWorkExperienceEntity tWorkExperienceEntity, int user_id);
    void editWorkExp(TWorkExperienceEntity tWorkExperienceEntity, int user_id);
    void deleteWorkExp(int id);
    void inWork(TWorkExperienceEntity tWorkExperienceEntity);
}
