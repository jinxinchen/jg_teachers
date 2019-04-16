package com.jingguan.baseInfo.dao;

import com.jingguan.baseInfo.po.TTeacherBaseinfoEntity;

/**
 * Created by 陈 on 2017/10/28.
 */
public interface SaveBaseInfoDao {
    int SaveBaseInfo(TTeacherBaseinfoEntity tTeacherBaseinfoEntity, int user_id);
}
