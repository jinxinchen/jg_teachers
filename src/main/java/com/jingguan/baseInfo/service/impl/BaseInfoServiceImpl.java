package com.jingguan.baseInfo.service.impl;

import com.jingguan.baseInfo.dao.GetBaseInfoDao;
import com.jingguan.baseInfo.dao.SaveBaseInfoDao;
import com.jingguan.baseInfo.dao.UpdateBaseInfoDao;
import com.jingguan.baseInfo.po.TTeacherBaseinfoEntity;
import com.jingguan.baseInfo.service.BaseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 陈 on 2017/10/13.
 */
@Service("baseInfoService")
public class BaseInfoServiceImpl implements BaseInfoService {
    @Resource(name="GetBaseInfoDao")
    private GetBaseInfoDao getBaseInfoDao;

    @Resource(name = "updateBaseInfoDao")
    private UpdateBaseInfoDao updateBaseInfoDao;

    @Resource(name = "saveBaseInfoDao")
    private SaveBaseInfoDao saveBaseInfoDao;

    @Override
    public int getUserIdByIdentifyNum(String identityNum) {

        return 0;
    }

    @Override
    public List<TTeacherBaseinfoEntity> getBaseInfo(int user_id) {
        List<TTeacherBaseinfoEntity> info = getBaseInfoDao.getBaseInfo(user_id);
        return info;
    }

    @Override
    public int updateBaseInfo(TTeacherBaseinfoEntity tTeacherBaseinfoEntity,int id) {
        return updateBaseInfoDao.updateBaseInfo(tTeacherBaseinfoEntity,id);
    }

    @Override
    public int saveBaseInfo(TTeacherBaseinfoEntity tTeacherBaseinfoEntity, int user_id) {
        return saveBaseInfoDao.SaveBaseInfo(tTeacherBaseinfoEntity,user_id);
    }

    @Override
    public void uploadFile(String fileName, int id) {
        updateBaseInfoDao.uploadFile(fileName,id);
    }

    @Override
    public void uploadIdentityFile(String fileName, int id) {
        updateBaseInfoDao.uploadIdentityFile(fileName,id);
    }
}
