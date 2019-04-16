package com.jingguan.teacherActivityCheck.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.teacherActivityCheck.po.TTeacherActivityEntity;
import com.jingguan.teacherActivityCheck.po.VTeachersActivityCheckEntity;

import java.util.List;

/**
 * Created by zhouliang on 2017/11/13 0013.
 */
public interface VTeacherActivityCheckDao {

    public Page<VTeachersActivityCheckEntity> listRecordsByCondition(Page page);

    //由于只改改变一个所以可以直接使用sql语句不用po
    public  void update(int id, String status);

    public List<VTeachersActivityCheckEntity> getLists(Page.FilterModel condition);

    void inActivity(TTeacherActivityEntity tTeacherActivityEntity);

}
