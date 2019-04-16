package com.jingguan.degree.dao;

import com.jingguan.degree.po.TEducateDegreeEntity;
import com.jingguan.degree.po.VDegreeInfoEntity;

import java.util.List;

/**
 * Created by 陈 on 2017/11/7.
 */
public interface LoadDegreeInfoDao {
    List<TEducateDegreeEntity> loadInfo(int user_id);
}
