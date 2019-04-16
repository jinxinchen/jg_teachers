package com.jingguan.baseInfo.dao;

import com.jingguan.baseInfo.po.TTeacherBaseinfoEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 陈 on 2017/10/23.
 */
public interface UpdateBaseInfoDao {
    int updateBaseInfo(TTeacherBaseinfoEntity tTeacherBaseinfoEntity, int id);
    void uploadFile(String fileName, int id);
    void uploadIdentityFile(String fileName, int id);
}
