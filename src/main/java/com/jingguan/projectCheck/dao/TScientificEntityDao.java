package com.jingguan.projectCheck.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.projectCheck.po.TScientificEntity;

import java.util.List;

/**
 * Created by zhouliang on 2017/12/18 0018.
 */
public interface TScientificEntityDao {

    public Page<TScientificEntity> listRecordsByCondition(Page page);
    public List<TScientificEntity> getLists(Page.FilterModel condition);

    public String getNumber(int uer_id);

}
