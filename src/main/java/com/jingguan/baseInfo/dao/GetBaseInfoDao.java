package com.jingguan.baseInfo.dao;

import com.jingguan.baseInfo.po.TTeacherBaseinfoEntity;

import java.util.List;

/**
 * Created by 陈 on 2017/10/13.
 */
public interface GetBaseInfoDao {
    List<TTeacherBaseinfoEntity> getBaseInfo(int user_id);
    int getUserIdByIdentifyNum(int idNum);
}
