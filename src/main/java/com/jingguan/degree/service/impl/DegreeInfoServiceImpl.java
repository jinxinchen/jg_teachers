package com.jingguan.degree.service.impl;

import com.jingguan.degree.dao.LoadDegreeInfoDao;
import com.jingguan.degree.dao.SaveDegreeInfoDao;
import com.jingguan.degree.dao.UpdateDegreeInfoDao;
import com.jingguan.degree.po.TEducateDegreeEntity;
import com.jingguan.degree.po.VDegreeInfoEntity;
import com.jingguan.degree.service.DegreeInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 陈 on 2017/11/7.
 */
@Service("degreeInfoService")
public class DegreeInfoServiceImpl implements DegreeInfoService{

    @Resource(name = "loadDegreeInfoDao")
    private LoadDegreeInfoDao loadDegreeInfoDao;

    @Resource(name = "saveDegreeInfoDao")
    private SaveDegreeInfoDao saveDegreeInfoDao;

    @Resource(name = "updateDegreeInfo")
    private UpdateDegreeInfoDao updateDegreeInfoDao;

    @Override
    public List<TEducateDegreeEntity> loadDegreeInfo(int user_id) {
        return loadDegreeInfoDao.loadInfo(user_id);
    }

    @Override
    public int saveDegreeInfo(TEducateDegreeEntity tEducateDegreeEntity, int user_id) {
        return saveDegreeInfoDao.saveDegreeInfo(tEducateDegreeEntity,user_id);
    }

    @Override
    public int updateDegreeInfo(int user_id,TEducateDegreeEntity tEducateDegreeEntity) {
        return updateDegreeInfoDao.updateDegreeInfo(user_id,tEducateDegreeEntity);
    }

    @Override
    public void uploadFile(String fileName, String filename, int id, int user_id) {
        updateDegreeInfoDao.uploadFile(fileName,filename,id,user_id);
    }

    @Override
    public void uploadMentorFile(String fileName, String filename, int id, int user_id) {
        updateDegreeInfoDao.uploadMentorFile(fileName,filename,id,user_id);
    }

    @Override
    public String getDegreeSrcById(int id) {
        return updateDegreeInfoDao.getDegreeSrcById(id);
    }

    @Override
    public String getDegreeMentorSrcById(int id) {
        return updateDegreeInfoDao.getDegreeMentorSrcById(id);
    }


}
