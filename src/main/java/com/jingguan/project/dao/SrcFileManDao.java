package com.jingguan.project.dao;

import com.jingguan.project.po.SrcFileMan;

/**
 * Created by zhouliang on 2017/12/13 0013.
 */
public interface SrcFileManDao {

    public  void updateRecords(SrcFileMan record);

    public SrcFileMan getRecords(Integer id);

    public String getEndPath(Integer id);
    public String getCreatePath(Integer id);

}
