package com.jingguan.student.service.impl;

import com.jingguan.common.tool.ExportExcel;
import com.jingguan.common.vo.Page;
import com.jingguan.student.dao.StudentDao;
import com.jingguan.student.po.*;
import com.jingguan.student.service.StudentService;
import jxl.write.WriteException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

import static com.jingguan.common.dao.impl.BaseDao.getCurrentSession;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TStudentEntity> data=studentDao.getList(condition);

        String[] field={"grade","eduBack","clazz","name",
                "sno", "sex","address","tel","mail","position", "awardLevel","awardShape","awardType","awardName","awardingUnit", "getTime","articleLevel","articleName","issn","activity","notice"};
        String[] heads={ "年级",
                "学历",
                "班级",
                "姓名",
                "学号",
                "性别",
                "家庭详细地址",
                "联系电话",
                "邮箱",
                "任职情况",
                "获奖级别",
                "获奖形式",
                "获奖类型",
                "荣誉全称（部分荣誉需包括作品名称）",
                "授奖单位",
                "获奖时间",
                "论文级别",
                "论文题目",
                "刊号",
                "公共活动认证",
                "备注"};

        ExportExcel.getOS(os,data,field,heads);

    }

    @Override
    public void getOutStreamPostGraduateArticle(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TPostgraduateArticleEntity> data=studentDao.getListPostGraduateArticle(condition);

        String[] field={"articleName","postTime","postTo","authorList",
                "firstName", "name","sno","grade","college","courseName", "mentor","stuType","issbnLevel","articelType"};
        String[] heads={ "论文名称",
                "发表年月",
                "发表刊物",
                "作者名单",
                "第一作者或通讯作者",
                "姓名",
                "学号",
                "年级",
                "学院",
                "专业",
                "导师",
                "学生类别",
                "刊物级别",
                "论文分类"};

        ExportExcel.getOS(os,data,field,heads);
    }

    @Override
    public void getOutStreamPostGraduateKeyan(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TPostgraduateKeyanEntity> data=studentDao.getListPostGraduateKeyan(condition);

        String[] field={"sno","name","grade","courseName",
                "mentor", "awardName","awardLevel","awardingUnit","getTime","awardRank", "ranking","stuType","notice"};
        String[] heads={ "学号",
                "姓名",
                "年级",
                "专业名称",
                "导师姓名",
                "获奖成果名称",
                "获奖等级",
                "授奖单位",
                "获奖时间",
                "获奖级别",
                "获奖人排名",
                "学生类别",
                "备注"};

        ExportExcel.getOS(os,data,field,heads);
    }

    @Override
    public void getOutStreamPostGraduateJingsai(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TPostgraduateJingsaiEntity> data=studentDao.getListPostGraduateJingsai(condition);

        String[] field={"sno","name","grade","mentor",
                "competitionName", "worksName","unit","awardLevel","stuType","notice"};
        String[] heads={  "学号",
                "姓名",
                "年级",
                "指导教师",
                "竞赛名称",
                "参赛作品名称",
                "主办单位",
                "获奖等级",
                "获奖时间",
                "学生类别",
                "备注"};

        ExportExcel.getOS(os,data,field,heads);
    }

    @Override
    public void getOutStreamStuAbroad(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TStuAbroadEntity> data=studentDao.getListStuAbroad(condition);

        String[] field={"college","sno","name","courseName",
                "grade", "abroad","country","abroadSch","abroadType","time", "stuType","notice"};
        String[] heads={  "学院",
                "学号",
                "姓名",
                "专业名称",
                "年级",
                "出/回国",
                "留学国家",
                "留学院校名称及专业",
                "留学类别",
                "交流起止时间",
                "学生类别",
                "备注"};

        ExportExcel.getOS(os,data,field,heads);
    }

    @Override
    public void getOutStreamStuInfo(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TStuInfoEntity> data=studentDao.getListStuInfo(condition);

        String[] field={"sno","grade","name","gender",
                "stuType", "birthday","courseName","research","mentor","identity","phoneNum"};
        String[] heads={ "学号",
                "年级",
                "姓名",
                "性别",
                "学生类别",
                "出生日期",
                "专业",
                "研究方向",
                "导师姓名",
                "身份证号",
                "联系电话"};

        ExportExcel.getOS(os,data,field,heads);
    }


    @Override
    public Page<TStudentEntity> load(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
//        filterModel.getRules().add(new Page.FilterModel.Rule("status", 1, "eq"));
        page.addFilter(filterModel);
        return studentDao.load(page);
    }

    @Override
    public Page<TPostgraduateArticleEntity> loadPostGraduateArticle(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
//        filterModel.getRules().add(new Page.FilterModel.Rule("status", 1, "eq"));
        page.addFilter(filterModel);
        return studentDao.loadPostGraduateArticle(page);
    }

    @Override
    public Page<TPostgraduateKeyanEntity> loadPostGraduateKeyan(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
//        filterModel.getRules().add(new Page.FilterModel.Rule("status", 1, "eq"));
        page.addFilter(filterModel);
        return studentDao.loadPostGraduateKeyan(page);
    }

    @Override
    public Page<TPostgraduateJingsaiEntity> loadPostGraduateJingsai(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
//        filterModel.getRules().add(new Page.FilterModel.Rule("status", 1, "eq"));
        page.addFilter(filterModel);
        return studentDao.loadPostGraduateJingsai(page);
    }

    @Override
    public Page<TStuAbroadEntity> loadStuAbroad(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
//        filterModel.getRules().add(new Page.FilterModel.Rule("status", 1, "eq"));
        page.addFilter(filterModel);
        return studentDao.loadStuAbroad(page);
    }

    @Override
    public Page<TStuInfoEntity> loadInfo(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
//        filterModel.getRules().add(new Page.FilterModel.Rule("status", 1, "eq"));
        page.addFilter(filterModel);
        return studentDao.loadStuInfo(page);
    }

    @Override
    public int add(TStudentEntity tStudentEntity) {
//        Session session = getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        List<TStudentEntity> tStudentEntities = session.createCriteria(TStudentEntity.class).
//                add(Restrictions.eq("sno",tStudentEntity.getSno())).
//                list();
//        if(tStudentEntities.size() == 0){
            return studentDao.add(tStudentEntity);
//        }
//        return 0;
    }

    @Override
    public int addPostGraduateArticle(TPostgraduateArticleEntity tPostgraduateArticleEntity) {
        return studentDao.addPostGraduateArticle(tPostgraduateArticleEntity);
    }

    @Override
    public int addPostGraduateKeyan(TPostgraduateKeyanEntity tPostgraduateKeyanEntity) {
        return studentDao.addPostGraduateKeyan(tPostgraduateKeyanEntity);
    }

    @Override
    public int addPostGraduateJingsai(TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity) {
        return studentDao.addPostGraduateJingsai(tPostgraduateJingsaiEntity);
    }

    @Override
    public int addStuAbroad(TStuAbroadEntity tStuAbroadEntity) {
        return studentDao.addStuAbroad(tStuAbroadEntity);
    }

    @Override
    public int addInfo(TStuInfoEntity tStuInfoEntity) {
        return studentDao.addInfo(tStuInfoEntity);
    }

    @Override
    public int edit(TStudentEntity tStudentEntity) {
//        Session session = getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        List<TStudentEntity> tStudentEntities = session.createCriteria(TStudentEntity.class).
//                add(Restrictions.eq("sno",tStudentEntity.getSno())).
//                list();
//        if(tStudentEntities.size() == 0){
            return studentDao.edit(tStudentEntity);
//        }
//        return 0;
    }

    @Override
    public int editPostGraduateArticle(TPostgraduateArticleEntity tPostgraduateArticleEntity) {
        return studentDao.editPostGraduateArticle(tPostgraduateArticleEntity);
    }

    @Override
    public int editPostGraduateKeyan(TPostgraduateKeyanEntity tPostgraduateKeyanEntity) {
        return studentDao.editPostGraduateKeyan(tPostgraduateKeyanEntity);
    }

    @Override
    public int editPostGraduateJingsai(TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity) {
        return studentDao.editPostGraduateJingsai(tPostgraduateJingsaiEntity);
    }

    @Override
    public int editStuAbroad(TStuAbroadEntity tStuAbroadEntity) {
        return studentDao.editStuAbroad(tStuAbroadEntity);
    }

    @Override
    public int editInfo(TStuInfoEntity tStuInfoEntity) {
        return studentDao.editInfo(tStuInfoEntity);
    }

    @Override
    public int delete(int id) {
        return studentDao.delete(id);
    }

    @Override
    public int deletePostGraduateArticle(int id) {
        return studentDao.deletePostGraduateArticle(id);
    }

    @Override
    public int deletePostGraduateKeyan(int id) {
        return studentDao.deletePostGraduateKeyan(id);
    }

    @Override
    public int deletePostGraduateJingsai(int id) {
        return studentDao.deletePostGraduateJingsai(id);
    }

    @Override
    public int deleteStuAbroad(int id) {
        return studentDao.deleteStuAbroad(id);
    }

    @Override
    public int deleteInfo(int id) {
        return studentDao.deleteInfo(id);
    }

    @Override
    public void inStudent(List<String[]> list) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
//            Session session = getCurrentSession();
//            Transaction transaction = session.beginTransaction();
//            List<TStudentEntity> tStudentEntities = session.createCriteria(TStudentEntity.class).
//                    add(Restrictions.eq("sno",Integer.valueOf(list.get(i)[4]))).
//                    list();
//            if(tStudentEntities.size() == 0){
                TStudentEntity tStudentEntity = new TStudentEntity();
                tStudentEntity.setGrade(list.get(i)[0]);
                tStudentEntity.setEduBack(list.get(i)[1]);
                tStudentEntity.setClazz(list.get(i)[2]);
                tStudentEntity.setName(list.get(i)[3]);
                tStudentEntity.setSno(list.get(i)[4]);
                tStudentEntity.setSex(list.get(i)[5]);
                tStudentEntity.setAddress(list.get(i)[6]);
                tStudentEntity.setTel(list.get(i)[7]);
                tStudentEntity.setMail(list.get(i)[8]);
                tStudentEntity.setPosition(list.get(i)[9]);
                tStudentEntity.setAwardLevel(list.get(i)[10]);
                tStudentEntity.setAwardType(list.get(i)[11]);
                tStudentEntity.setAwardShape(list.get(i)[12]);
                tStudentEntity.setAwardName(list.get(i)[13]);
                tStudentEntity.setAwardingUnit(list.get(i)[14]);
                tStudentEntity.setGetTime(list.get(i)[15]);
            tStudentEntity.setArticleLevel(list.get(i)[16]);
            tStudentEntity.setArticleName(list.get(i)[17]);
            tStudentEntity.setIssn(list.get(i)[18]);
            tStudentEntity.setActivity(list.get(i)[19]);
            tStudentEntity.setNotice(list.get(i)[20]);

                studentDao.inStudent(tStudentEntity);
//            }





        }
    }

    @Override
    public void inPostGraduateArticle(List<String[]> list) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
//            Session session = getCurrentSession();
//            Transaction transaction = session.beginTransaction();
//            List<TStudentEntity> tStudentEntities = session.createCriteria(TStudentEntity.class).
//                    add(Restrictions.eq("sno",Integer.valueOf(list.get(i)[4]))).
//                    list();
//            if(tStudentEntities.size() == 0){
            TPostgraduateArticleEntity tPostgraduateArticleEntity = new TPostgraduateArticleEntity();
            tPostgraduateArticleEntity.setArticleName(list.get(i)[0]);
            tPostgraduateArticleEntity.setPostTime(list.get(i)[1]);
            tPostgraduateArticleEntity.setPostTo(list.get(i)[2]);
            tPostgraduateArticleEntity.setAuthorList(list.get(i)[3]);
            tPostgraduateArticleEntity.setFirstName(list.get(i)[4]);
            tPostgraduateArticleEntity.setName(list.get(i)[5]);
            tPostgraduateArticleEntity.setSno(list.get(i)[6]);
            tPostgraduateArticleEntity.setGrade(list.get(i)[7]);
            tPostgraduateArticleEntity.setCollege(list.get(i)[8]);
            tPostgraduateArticleEntity.setCourseName(list.get(i)[9]);
            tPostgraduateArticleEntity.setMentor(list.get(i)[10]);
            tPostgraduateArticleEntity.setStuType(list.get(i)[11]);
            tPostgraduateArticleEntity.setIssbnLevel(list.get(i)[12]);
            tPostgraduateArticleEntity.setArticelType(list.get(i)[13]);

            studentDao.inPostGraduateArticle(tPostgraduateArticleEntity);
//            }





        }
    }

    @Override
    public void inPostGraduateKeyan(List<String[]> list) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
//            Session session = getCurrentSession();
//            Transaction transaction = session.beginTransaction();
//            List<TStudentEntity> tStudentEntities = session.createCriteria(TStudentEntity.class).
//                    add(Restrictions.eq("sno",Integer.valueOf(list.get(i)[4]))).
//                    list();
//            if(tStudentEntities.size() == 0){
            TPostgraduateKeyanEntity tPostgraduateKeyanEntity = new TPostgraduateKeyanEntity();
            tPostgraduateKeyanEntity.setSno(list.get(i)[0]);
            tPostgraduateKeyanEntity.setName(list.get(i)[1]);
            tPostgraduateKeyanEntity.setGrade(list.get(i)[2]);
            tPostgraduateKeyanEntity.setCourseName(list.get(i)[3]);
            tPostgraduateKeyanEntity.setMentor(list.get(i)[4]);
            tPostgraduateKeyanEntity.setAwardName(list.get(i)[5]);
            tPostgraduateKeyanEntity.setAwardLevel(list.get(i)[6]);
            tPostgraduateKeyanEntity.setAwardingUnit(list.get(i)[7]);
            tPostgraduateKeyanEntity.setGetTime(list.get(i)[8]);
            tPostgraduateKeyanEntity.setAwardRank(list.get(i)[9]);
            tPostgraduateKeyanEntity.setRanking(list.get(i)[10]);
            tPostgraduateKeyanEntity.setStuType(list.get(i)[11]);
            tPostgraduateKeyanEntity.setNotice(list.get(i)[12]);

            studentDao.inPostGraduateKeyan(tPostgraduateKeyanEntity);
//            }





        }
    }

    @Override
    public void inPostGraduateJingsai(List<String[]> list) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
//            Session session = getCurrentSession();
//            Transaction transaction = session.beginTransaction();
//            List<TStudentEntity> tStudentEntities = session.createCriteria(TStudentEntity.class).
//                    add(Restrictions.eq("sno",Integer.valueOf(list.get(i)[4]))).
//                    list();
//            if(tStudentEntities.size() == 0){
            TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity = new TPostgraduateJingsaiEntity();
            tPostgraduateJingsaiEntity.setSno(list.get(i)[0]);
            tPostgraduateJingsaiEntity.setName(list.get(i)[1]);
            tPostgraduateJingsaiEntity.setGrade(list.get(i)[2]);
            tPostgraduateJingsaiEntity.setMentor(list.get(i)[3]);
            tPostgraduateJingsaiEntity.setCompetitionName(list.get(i)[4]);
            tPostgraduateJingsaiEntity.setWorksName(list.get(i)[5]);
            tPostgraduateJingsaiEntity.setUnit(list.get(i)[6]);
            tPostgraduateJingsaiEntity.setAwardLevel(list.get(i)[7]);
            tPostgraduateJingsaiEntity.setGetTime(list.get(i)[8]);
            tPostgraduateJingsaiEntity.setStuType(list.get(i)[9]);
            tPostgraduateJingsaiEntity.setNotice(list.get(i)[10]);

            studentDao.inPostGraduateJingsai(tPostgraduateJingsaiEntity);
//            }





        }
    }

    @Override
    public void inStuAbroad(List<String[]> list) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
//            Session session = getCurrentSession();
//            Transaction transaction = session.beginTransaction();
//            List<TStudentEntity> tStudentEntities = session.createCriteria(TStudentEntity.class).
//                    add(Restrictions.eq("sno",Integer.valueOf(list.get(i)[4]))).
//                    list();
//            if(tStudentEntities.size() == 0){
            TStuAbroadEntity tStuAbroadEntity = new TStuAbroadEntity();
            tStuAbroadEntity.setCollege(list.get(i)[0]);
            tStuAbroadEntity.setSno(list.get(i)[1]);
            tStuAbroadEntity.setName(list.get(i)[2]);
            tStuAbroadEntity.setCourseName(list.get(i)[3]);
            tStuAbroadEntity.setGrade(list.get(i)[4]);
            tStuAbroadEntity.setAbroad(list.get(i)[5]);
            tStuAbroadEntity.setCountry(list.get(i)[6]);
            tStuAbroadEntity.setAbroadSch(list.get(i)[7]);
            tStuAbroadEntity.setAbroadType(list.get(i)[8]);
            tStuAbroadEntity.setTime(list.get(i)[9]);
            tStuAbroadEntity.setStuType(list.get(i)[10]);
            tStuAbroadEntity.setNotice(list.get(i)[11]);

            studentDao.inStuAbroad(tStuAbroadEntity);
//            }





        }
    }

    @Override
    public void inStudentInfo(List<String[]> list) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
//            Session session = getCurrentSession();
//            Transaction transaction = session.beginTransaction();
//            List<TStudentEntity> tStudentEntities = session.createCriteria(TStudentEntity.class).
//                    add(Restrictions.eq("sno",Integer.valueOf(list.get(i)[4]))).
//                    list();
//            if(tStudentEntities.size() == 0){
            TStuInfoEntity tStuInfoEntity = new TStuInfoEntity();
            tStuInfoEntity.setSno(list.get(i)[0]);
            tStuInfoEntity.setGrade(list.get(i)[1]);
            tStuInfoEntity.setName(list.get(i)[2]);
            tStuInfoEntity.setGender(list.get(i)[3]);
            tStuInfoEntity.setStuType(list.get(i)[4]);
            tStuInfoEntity.setBirthday(list.get(i)[5]);
            tStuInfoEntity.setCourseName(list.get(i)[6]);
            tStuInfoEntity.setResearch(list.get(i)[7]);
            tStuInfoEntity.setMentor(list.get(i)[8]);
            tStuInfoEntity.setIdentity(list.get(i)[9]);
            tStuInfoEntity.setPhoneNum(list.get(i)[10]);

            studentDao.inStudentInfo(tStuInfoEntity);
//            }





        }
    }

    @Override
    public String getAwardSrcById(int id) {

        return studentDao.getAwardSrcById(id);
    }

    @Override
    public String getIssbnSrcById(int id) {
        return studentDao.getIssbnSrcById(id);
    }

    @Override
    public String getJingsaiSrcById(int id) {
        return studentDao.getJingsaiSrcById(id);
    }
}