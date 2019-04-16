package com.jingguan.degree.dao;

import com.jingguan.degree.po.TEducateDegreeEntity;

/**
 * Created by 陈 on 2017/11/10.
 */
public interface UpdateDegreeInfoDao {
    int updateDegreeInfo(int user_id, TEducateDegreeEntity tEducateDegreeEntity);
    void uploadFile(String fileName, String filename, int id, int user_id);
    void uploadMentorFile(String fileName, String filename, int id, int user_id);
    String getDegreeSrcById(int id);
    String getDegreeMentorSrcById(int id);
}
