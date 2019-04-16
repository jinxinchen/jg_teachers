package com.jingguan.sciencePrize.service;

import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;
import com.jingguan.sciencePrize.po.TEducateScientificEntity;

import java.util.List;

/**
 * Created by zhouliang on 2017/11/18 0018.
 */
public interface SciencePrizeService extends ExportExcelImpl{

    public Page<TEducateScientificEntity> listRecordsByCondition(String userid, Page page);

    public boolean saveRecord(int userId, TEducateScientificEntity record);

    public void updateRecord(TEducateScientificEntity records);

    public void deleteRecord(String id);

    public void updatePath(String id, String path, String filename);

    public TEducateScientificEntity getRecord(Integer id);

    public String getPath(String id);

    void inSciencePrizeTemp(List<String[]> list, int user_id);
    void inSciencePrizeAdminTemp(String[] list, int user_id);

}
