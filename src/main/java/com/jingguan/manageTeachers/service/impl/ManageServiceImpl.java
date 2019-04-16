package com.jingguan.manageTeachers.service.impl;

import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.tool.ExportExcel;
import com.jingguan.common.vo.Page;
import com.jingguan.manageTeachers.dao.ManageDao;
import com.jingguan.manageTeachers.po.*;
import com.jingguan.manageTeachers.service.ManageService;
import jxl.write.WriteException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 陈 on 2017/12/12.
 */
@Service("manageService")
public class ManageServiceImpl extends UserDao implements ManageService {

    @Resource(name = "manageDao")
    private ManageDao manageDao;


    @Override
    public void updateDegree(TEducateDegreeEntity tEducateDegreeEntity, TTeacherBaseinfoUpdate tTeacherBaseinfoUpdate) {
        manageDao.updateDegree(tEducateDegreeEntity,tTeacherBaseinfoUpdate);
    }

    @Override
    public VManageteachersBaseinfoEntity getBaseinfoById(Integer id) {
        return manageDao.getBaseinfoById(id);
    }

    @Override
    public void deleteBaseInfo(Integer userId) {
        manageDao.deleteBaseInfo(userId);
    }

    @Override
    public void getOutAccountStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<VTeachersAccountsEntity> data=manageDao.getAcoountLists(condition);
        String[] heads={"账号", "创建时间" };
        String[] fields={"account","createTime"};
        ExportExcel.getOS(os,data,fields,heads);
    }

    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

        List<VManageteachersBaseinfoEntity> data=manageDao.getLists(condition);
        String[] heads={"身份证号","姓名", "性别", "来校报道时间","岗位类别","联系电话", "出生年月",
                "学位","学位类型","职称","职称等级","是否为导师","导师类型",
                "所属系","任教专业","任职状态"};
        String[] fields={"identityNum","name","gender","reportTime","positionType","phoneNum",
                "birthday","degree",
                "degreeType","educateDegreeName","educateDegreeLevel","isMentor","mentorType",
                "major","forClass","officeStatus"};

        ExportExcel.getOS(os,data,fields,heads);
    }

    @Override
    public void getOutStreamPostGraduateArticle(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamPostGraduateKeyan(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamPostGraduateJingsai(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamStuAbroad(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public void getOutStreamStuInfo(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

    }

    @Override
    public Page loadTeachers(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        filterModel.getRules().add(new Page.FilterModel.Rule("roleId", 1, "eq"));
        page.addFilter(filterModel);
        return manageDao.loadTeachers(page);
    }



    @Override
    public Page loadRecord(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        filterModel.getRules().add(new Page.FilterModel.Rule("roleId", 1, "eq"));
        page.addFilter(filterModel);
        return manageDao.loadRecord(page);
    }

    @Override
    public void saveUserAccounts(List<String> accounts) {
        for(int i=0;i<accounts.size();i++){
            String account = accounts.get(i);
            //如果数据库里面没有记录则保存
            Integer user_id = findUserIdByUserAccount(account);
            if(user_id == null){
                TUsersEntity user = new TUsersEntity();
                user.setAccount(account);
                user.setPassword(account);
                user.setStatus(1);
                Date dnow = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                user.setCreateTime(ft.format(dnow).toString());
                manageDao.saveRecord(user);
                //添加教师角色
                TUsersRoleEntity userRole = new TUsersRoleEntity();
                userRole.setUserId(user.getId());
                userRole.setRoleId(1);
                userRole.setStatus(1);
                manageDao.saveTeacherRole(userRole);

            }
        }
    }

    @Override
    public void saveUserAccountByExcel(List<String[]> list) {
        for(int i=0;i<list.size();i++){
            String account = list.get(i)[0];
            //如果数据库里面没有记录则保存
            Integer user_id = findUserIdByUserAccount(account);
            if(user_id == null){
                TUsersEntity user = new TUsersEntity();
                user.setAccount(account);
                user.setPassword(account);
                user.setStatus(1);
                Date dnow = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                user.setCreateTime(ft.format(dnow).toString());
                manageDao.saveRecord(user);
                //添加教师角色
                TUsersRoleEntity userRole = new TUsersRoleEntity();
                userRole.setUserId(user.getId());
                userRole.setRoleId(1);
                userRole.setStatus(1);
                manageDao.saveTeacherRole(userRole);

            }else{

            }





        }
    }

    @Override
    public int editAccount(int id, String account,String password) {
        return manageDao.editAccount(id,account,password);
    }

    @Override
    public void deleteAccount(int id) {
        manageDao.deleteAccount(id);
    }
}
