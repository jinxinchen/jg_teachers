package com.jingguan.project.service.impl;

import com.jingguan.common.vo.Page;
import com.jingguan.project.dao.TProjectUserEntityDao;
import com.jingguan.project.dao.UserIdDao;
import com.jingguan.project.dao.VProjectUserEntityDao;
import com.jingguan.project.po.TProjectUserEntity;
import com.jingguan.project.po.VProjectUserEntity;
import com.jingguan.project.service.MembersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
@Service("membersService")
public class MembersServiceImpl implements MembersService {

    @Resource(name="vProjectUserEntityDao")
    private VProjectUserEntityDao vProjectUserEntityDao;

    @Resource(name="tProjectUserEntityDao")
    private TProjectUserEntityDao tProjectUserEntityDao;

    @Resource(name="userIdDao")
    private UserIdDao userIdDao;

    @Override
    public Page<VProjectUserEntity> listRecordsByCondition(String projectid, Page page) {
        Page.FilterModel filterModel=new Page.FilterModel();

        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);

        /*List<TProjectUserEntity> listRecord=tProjectUserEntityDao.findRecords(Integer.valueOf(userid.trim()));
        for(int i=0;i<listRecord.size();i++){
            filterModel.getRules().add(new Page.FilterModel.Rule("userId",listRecord.get(i).getProjectId(),"eq"));
        }

        */   int projectId=Integer.valueOf(projectid);
        //只要为当前用户的获得记录
        filterModel.getRules().add(new Page.FilterModel.Rule("projectId",projectId,"eq"));


        page.addFilter(filterModel);

        vProjectUserEntityDao.listRecordsByCondition(page);

        return  page;
    }

    @Override
    public boolean saveRecord(String userId, TProjectUserEntity record) {
        tProjectUserEntityDao.saveRecords(record);
        return true;
    }

    @Override
    public void updateRecord(TProjectUserEntity records) {
        tProjectUserEntityDao.updateRecords(records);
    }

    @Override
    public void deleteRecord(String id) {
        String[] ids=id.split(",");
        for (int i=0;i<ids.length;i++){
            TProjectUserEntity tProjectUserEntity=getRecord(Integer.valueOf(ids[i].trim()));

            tProjectUserEntityDao.deleteRecords(tProjectUserEntity);
        }
    }

    @Override
    public TProjectUserEntity getRecord(Integer id) {
        return tProjectUserEntityDao.getRecords(id);
    }

    @Override
    public int getUserId(String name) {
        return userIdDao.getUserIdByName(name);
    }
}
