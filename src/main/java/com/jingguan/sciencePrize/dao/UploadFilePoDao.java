package com.jingguan.sciencePrize.dao;

import com.jingguan.sciencePrize.po.UploadFilePo;

/**
 * Created by zhouliang on 2017/12/10 0010.
 */
public interface UploadFilePoDao {
    void updatePath(UploadFilePo uploadFilePo);
    String getPath(Integer id);
}
