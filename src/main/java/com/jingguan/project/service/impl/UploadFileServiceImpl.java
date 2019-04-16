package com.jingguan.project.service.impl;

import com.jingguan.project.dao.SrcFileManDao;
import com.jingguan.project.po.SrcFileMan;
import com.jingguan.project.service.UploadFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhouliang on 2017/12/13 0013.
 */
@Service("uploadFileService")
public class UploadFileServiceImpl implements UploadFileService {

    @Resource(name = "srcFileManDao")
    private SrcFileManDao srcFileManDao;

    @Override
    public void uploadCreatePath(String id, String path) {

        SrcFileMan record=srcFileManDao.getRecords(Integer.valueOf(id.trim()));
        record.setCreateScientificEvidenceSrc(path);

        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        record.setCreateUpdateTime(time);

        srcFileManDao.updateRecords(record);
    }

    @Override
    public void uploadEndPath(String id, String path) {

        SrcFileMan record=srcFileManDao.getRecords(Integer.valueOf(id.trim()));
        record.setEndScientificEvidenceSrc(path);

        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        record.setEndUpdateTime(time);

        srcFileManDao.updateRecords(record);
    }


    @Override
    public String getEndPath(String id) {
        return srcFileManDao.getEndPath(Integer.valueOf(id.trim()));
    }

    @Override
    public String getCreatePath(String id) {
        return srcFileManDao.getCreatePath(Integer.valueOf(id.trim()));
    }
}
