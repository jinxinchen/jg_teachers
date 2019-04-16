package com.jingguan.admin.service.impl;

import com.jingguan.admin.dao.AdminCopyRightDao;
import com.jingguan.admin.po.TCopyrightEntity;
import com.jingguan.admin.service.AdminCopyRightService;
import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.vo.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 陈 on 2017/11/15.
 */
@Service("adminCopyRightService")
public class AdminCopyRightServiceImpl extends UserDao implements AdminCopyRightService {
    @Resource(name = "adminCopyRightDao")
    private AdminCopyRightDao adminCopyRightDao;


    @Override
    public Page loadAdminCopyRight(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
//        filterModel.getRules().add(new Page.FilterModel.Rule("status", 1, "eq"));
        page.addFilter(filterModel);
        return adminCopyRightDao.loadAdminCopyRight(page);
    }

    @Override
    public int passCopyRight(int id) {
        return adminCopyRightDao.passCopyRight(id);
    }

    @Override
    public void inCopyRight(List<String[]> lists) {
        for(int i=0;i<lists.size();i++){
            Integer user_id = findUserIdByTname(lists.get(i)[0]);
            if(user_id != null){
                TCopyrightEntity tCopyrightEntity = new TCopyrightEntity();
                tCopyrightEntity.setUserId(user_id);
                tCopyrightEntity.setOwnerName(lists.get(i)[1]);
                tCopyrightEntity.setTitle(lists.get(i)[2]);
                tCopyrightEntity.setIssbn(lists.get(i)[3]);
                tCopyrightEntity.setType(lists.get(i)[4]);
                tCopyrightEntity.setPublishName(lists.get(i)[5]);
                tCopyrightEntity.setPublishTime(lists.get(i)[6]);
                tCopyrightEntity.setPublishId(lists.get(i)[7]);
                tCopyrightEntity.setOtherParticipator(lists.get(i)[8]);
                tCopyrightEntity.setNotice(lists.get(i)[9]);
                adminCopyRightDao.inCopyRight(tCopyrightEntity);

            }
        }
    }
}
