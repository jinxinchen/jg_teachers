package com.jingguan.project.service;

/**
 * Created by zhouliang on 2017/12/13 0013.
 */
public interface UploadFileService {

    // /上传立项书
    public void uploadCreatePath(String id, String path);

    //上传结项书
    public void uploadEndPath(String id, String path);

    public String getEndPath(String id);


    public String getCreatePath(String id);
}
