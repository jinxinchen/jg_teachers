package com.jingguan.sciencePrizeCheck.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.sciencePrizeCheck.po.VTeachersPrizeCheckEntity;

import java.util.List;

/**
 * Created by zhouliang on 2017/11/19 0019.
 */
public interface VTeachersPrizeCheckEntityDao {

    public Page<VTeachersPrizeCheckEntity> listRecordsByCondition(Page page);

    //由于只改改变一个所以可以直接使用sql语句不用po
    public  void update(int id, String status);

    public List<VTeachersPrizeCheckEntity> getLists(Page.FilterModel condition);

}
