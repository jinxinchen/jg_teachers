package com.jingguan.project.service;

import com.jingguan.common.vo.Page;
import com.jingguan.project.po.TProjectUserEntity;
import com.jingguan.project.po.VProjectUserEntity;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
public interface MembersService {

    public Page<VProjectUserEntity> listRecordsByCondition(String projectid, Page page);

    public boolean saveRecord(String userId, TProjectUserEntity record);

    public void updateRecord(TProjectUserEntity records);

    public void deleteRecord(String id);

    public TProjectUserEntity getRecord(Integer id);

    public int getUserId(String name);
}
