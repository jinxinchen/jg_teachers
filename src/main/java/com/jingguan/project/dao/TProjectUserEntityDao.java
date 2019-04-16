package com.jingguan.project.dao;

import com.jingguan.project.po.TProjectUserEntity;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
public interface TProjectUserEntityDao {

    public  void saveRecords(TProjectUserEntity record);

    public  void updateRecords(TProjectUserEntity record);

    public  void deleteRecords(TProjectUserEntity record);

    public TProjectUserEntity getRecords(Integer id);

    public List<TProjectUserEntity> findRecords(Integer userid);
}
