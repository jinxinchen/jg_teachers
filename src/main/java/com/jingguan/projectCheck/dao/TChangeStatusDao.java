package com.jingguan.projectCheck.dao;

import com.jingguan.projectCheck.po.TChangeStatus;

/**
 * Created by zhouliang on 2017/12/18 0018.
 */
public interface TChangeStatusDao {

    public  void update(TChangeStatus record);
    public TChangeStatus getRecords(Integer id);
}
