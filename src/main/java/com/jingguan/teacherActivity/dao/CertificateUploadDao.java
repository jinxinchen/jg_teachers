package com.jingguan.teacherActivity.dao;

import com.jingguan.teacherActivity.po.CertificateUpload;

/**
 * Created by zhouliang on 2017/12/10 0010.
 */
public interface CertificateUploadDao {

    void updatePath(CertificateUpload record);

    String getPath(Integer id);
}
