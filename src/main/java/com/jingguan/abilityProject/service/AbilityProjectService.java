package com.jingguan.abilityProject.service;

import com.jingguan.abilityProject.po.TAbilityProjectEntity;
import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;

import java.util.List;

/**
 * Created by 陈 on 2017/11/18.
 */
public interface AbilityProjectService extends ExportExcelImpl{
    Page loadAbilityProject(int user_id, Page page);
    int editAbilityProject(int user_id, TAbilityProjectEntity tAbilityProjectEntity);
    int addAbilityProject(int user_id, TAbilityProjectEntity tAbilityProjectEntity);
    int deleteAbilityProject(int id);
    String getAbilityProjectSrcById(int id);
    void uploadFile(String fileName, String filename, int id, int user_id);
    void inAbilityProject(List<String[]> list, int user_id);
}
