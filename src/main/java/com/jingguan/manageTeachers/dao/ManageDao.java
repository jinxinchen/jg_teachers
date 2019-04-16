package com.jingguan.manageTeachers.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.manageTeachers.po.*;

import java.util.List;

/**
 * Created by 陈 on 2017/12/12.
 */
public interface ManageDao {
    List<VTeachersAccountsEntity>getAcoountLists(Page.FilterModel condition);
    List<VManageteachersBaseinfoEntity> getLists(Page.FilterModel condition);
    Page loadTeachers(Page page);
    Page loadRecord(Page page);
    void saveRecord(TUsersEntity user);
    void saveTeacherRole(TUsersRoleEntity userRole);
    int editAccount(int id, String account, String password);
    void deleteAccount(int id);
    void  updateDegree(TEducateDegreeEntity tEducateDegreeEntity, TTeacherBaseinfoUpdate tTeacherBaseinfoUpdate);


    VManageteachersBaseinfoEntity getBaseinfoById(Integer id);
    void deleteBaseInfo(Integer userId);
}
