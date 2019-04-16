package com.jingguan.teacherActivityCheck.dao;

import com.jingguan.teacherActivityCheck.po.TChangeStatus;

/**
 * Created by zhouliang on 2017/12/17 0017.
 */
public interface TChangeStatusDao {

    public  void update(TChangeStatus record);
    public TChangeStatus getRecords(Integer id);

}
