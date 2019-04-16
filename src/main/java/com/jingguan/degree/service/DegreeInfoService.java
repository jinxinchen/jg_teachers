package com.jingguan.degree.service;

import com.jingguan.degree.po.TEducateDegreeEntity;
import com.jingguan.degree.po.VDegreeInfoEntity;

import java.util.List;

/**
 * Created by 陈 on 2017/11/7.
 */
public interface DegreeInfoService {
    List<TEducateDegreeEntity> loadDegreeInfo(int user_id);
    int saveDegreeInfo(TEducateDegreeEntity tEducateDegreeEntity, int user_id);
    int updateDegreeInfo(int user_id, TEducateDegreeEntity tEducateDegreeEntity);
    void uploadFile(String fileName, String filename, int id, int user_id);
    void uploadMentorFile(String fileName, String filename, int id, int user_id);
    String getDegreeSrcById(int id);
    String getDegreeMentorSrcById(int id);
}
