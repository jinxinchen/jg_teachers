package com.jingguan.teacherActivity.service;

import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherActivity.po.TTeacherActivityEntity;

import java.util.List;

/**
 * Created by zhouliang on 2017/11/11 0011.
 */
public interface TeacherActivityService extends ExportExcelImpl {
    public Page<TTeacherActivityEntity> listRecordsByCondition(String userid, Page page);

    public void updatePath(String id, String path);

    public boolean saveRecord(int userId, TTeacherActivityEntity record);

    public void updateRecord(TTeacherActivityEntity records);

    public void deleteRecord(String id, String realyp);

    public TTeacherActivityEntity getRecord(Integer id);

    public String getPath(String id);

    public void inSciencePrizeTemp(List<String[]> list, int user_id);

    public void inSciencePrizeAdminTemp(String[] list, int user_id);
}
