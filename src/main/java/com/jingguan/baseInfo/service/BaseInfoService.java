package com.jingguan.baseInfo.service;

import com.jingguan.baseInfo.po.TTeacherBaseinfoEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 陈 on 2017/10/13.
 */
public interface BaseInfoService {
    int getUserIdByIdentifyNum(String identityNum);
    List<TTeacherBaseinfoEntity> getBaseInfo(int user_id);
    int updateBaseInfo(TTeacherBaseinfoEntity tTeacherBaseinfoEntity, int id);
    int saveBaseInfo(TTeacherBaseinfoEntity tTeacherBaseinfoEntity, int user_id);
    void uploadFile(String fileName, int id);
    void uploadIdentityFile(String fileName, int id);
}
