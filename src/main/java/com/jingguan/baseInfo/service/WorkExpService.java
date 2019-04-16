package com.jingguan.baseInfo.service;

import com.jingguan.baseInfo.po.TWorkExperienceEntity;
import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;

import java.util.List;

/**
 * Created by 陈 on 2017/10/29.
 */
public interface WorkExpService extends ExportExcelImpl {
    Page loadWorkExp(int user_id, Page page);
    void addWorkExp(TWorkExperienceEntity tWorkExperienceEntity, int user_id);
    void editWorkExp(TWorkExperienceEntity tWorkExperienceEntity, int user_id);
    void deleteWorkExp(int id);
    void InWork(List<String[]> list, int user_id);
}
