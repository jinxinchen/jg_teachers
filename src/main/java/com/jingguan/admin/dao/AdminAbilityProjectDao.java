package com.jingguan.admin.dao;

import com.jingguan.admin.po.TAbilityProjectEntity;
import com.jingguan.admin.po.VAdminAbilityprojectEntity;
import com.jingguan.common.vo.Page;

import java.util.List;

/**
 * Created by 陈 on 2017/11/20.
 */
public interface AdminAbilityProjectDao {
    Page loadAbilityProject(Page page);
    int passAbilityProject(int id);
    void inAbilityProject(TAbilityProjectEntity tAbilityProjectEntity);
    List<VAdminAbilityprojectEntity> getAbilityProjectLists(Page.FilterModel condition);
}
