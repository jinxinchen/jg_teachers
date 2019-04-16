package com.jingguan.baseInfo.dao;

import java.util.Map;

/**
 * Created by 陈 on 2017/10/18.
 */
public interface AddEduExpDao {
    int addEduExp(Integer user_id, String school, String major, String education, String entrance, String graduationYear, String abroad);
}
