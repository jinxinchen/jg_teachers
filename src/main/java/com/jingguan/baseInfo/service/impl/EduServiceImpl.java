package com.jingguan.baseInfo.service.impl;

import com.jingguan.baseInfo.dao.AddEduExpDao;
import com.jingguan.baseInfo.dao.DeleteEduExpDao;
import com.jingguan.baseInfo.dao.EditEduExpDao;
import com.jingguan.baseInfo.dao.EduDao;
import com.jingguan.baseInfo.dao.impl.EditEduExpDaoImpl;
import com.jingguan.baseInfo.po.TEducationExperienceEntity;
import com.jingguan.baseInfo.service.EduService;
import com.jingguan.common.tool.ExportExcel;
import com.jingguan.common.vo.Page;
import jxl.write.WriteException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.jingguan.common.dao.impl.BaseDao.getCurrentSession;

/**
 * Created by 陈 on 2017/10/17.
 */
@Service("EduService")
public class EduServiceImpl implements EduService {

    @Resource(name = "EduDao")
    private EduDao eduDao;

    @Resource(name = "addEduExpDao")
    private AddEduExpDao addEduExpDao;

    @Resource(name = "editEduExpDao")
    private EditEduExpDao editEduExpDao;

    @Resource(name = "deleteEduExpDao")
    private DeleteEduExpDao deleteEduExpDao;

    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
            List<TEducationExperienceEntity> data=eduDao.getLists(condition);
            String[] heads={"学校", "专业", "最高学历", "入学年份","毕业年份","海外经历"};
            String[] fields={"school","major","education","entrance","graduationYear","abroad"};
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
    public List<TEducationExperienceEntity> loadEduExp(int user_id) {
        return eduDao.loadEducationExp(user_id);
    }

    @Override
    public int addEduExp(Integer user_id, String school, String major, String education, String entrance,String graduationYear,String abroad) {

        return addEduExpDao.addEduExp(user_id,school,major,education,entrance,graduationYear,abroad);
    }

    @Override
    public int editEduExp(int id,Integer user_id, String school, String major, String education, String entrance,String graduationYear,String abroad) {

        return editEduExpDao.editEduExp(id,user_id,school,major,education,entrance,graduationYear,abroad);
    }

    @Override
    public int deleteEduExp(Integer user_id) {

        return deleteEduExpDao.deleteEduExp(user_id);
    }

    @Override
    public Page<TEducationExperienceEntity> searchFromId(Page page, int user_id) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        filterModel.getRules().add(new Page.FilterModel.Rule("userId", user_id, "eq"));
        page.addFilter(filterModel);
        return eduDao.findEduExp(page); 
    }

    @Override
    public void InEdu(List<String[]> list,int user_id) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            List<TEducationExperienceEntity> tEducationExperienceEntities = session.createCriteria(TEducationExperienceEntity.class).add(Restrictions.eq("userId",user_id)).add(Restrictions.eq("entrance",list.get(i)[3])).list();
            if(tEducationExperienceEntities.size() == 0){
                TEducationExperienceEntity tEducationExperienceEntity = new TEducationExperienceEntity();
                String school = list.get(i)[0];
                String major = list.get(i)[1];
                String education = list.get(i)[2];
                String entrance = list.get(i)[3];
                String graduationYear = list.get(i)[4];
                tEducationExperienceEntity.setSchool(school);
                tEducationExperienceEntity.setMajor(major);
                tEducationExperienceEntity.setEducation(education);
                tEducationExperienceEntity.setEntrance(entrance);
                tEducationExperienceEntity.setGraduationYear(graduationYear);
                tEducationExperienceEntity.setUserId(user_id);
                tEducationExperienceEntity.setStatus(1);



                eduDao.inEdu(tEducationExperienceEntity);
            }





        }
    }

}
