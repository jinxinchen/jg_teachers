package com.jingguan.degree.dao;

import com.jingguan.degree.po.TEducateDegreeEntity;
import com.jingguan.degree.po.VDegreeInfoEntity;

/**
 * Created by 陈 on 2017/11/7.
 */
public interface SaveDegreeInfoDao {
    int saveDegreeInfo(TEducateDegreeEntity tEducateDegreeEntity, int user_id);
}
