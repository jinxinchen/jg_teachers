package com.jingguan.project.service;

import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;
import com.jingguan.project.po.TScientificEntity;
import com.jingguan.project.po.VProjectEntity;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
public interface ProjectService extends ExportExcelImpl{

    public Page<VProjectEntity> listRecordsByCondition(String userid, Page page);
    public Page<VProjectEntity> listRecordsByCondition(Page page);
    public boolean saveRecord(String userId, TScientificEntity record);

    public void updateRecord(TScientificEntity records);

    public void deleteRecord(String id, String realp);

    public TScientificEntity getRecord(Integer id);
    void inSciencePrizeTemp(List<String[]> list, int user_id,String headName);
    void inSciencePrizeAdminTemp(String[] list, int user_id);
}
