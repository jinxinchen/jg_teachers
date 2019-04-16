package com.jingguan.project.service.impl;

import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.tool.DeleteTools;
import com.jingguan.common.tool.ExportExcel;
import com.jingguan.common.vo.Page;
import com.jingguan.project.dao.TProjectUserEntityDao;
import com.jingguan.project.dao.TScientificEntityDao;
import com.jingguan.project.dao.VProjectEntityDao;
import com.jingguan.project.po.TScientificEntity;
import com.jingguan.project.po.VProjectEntity;
import com.jingguan.project.service.ProjectService;
import jxl.write.WriteException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
@Service("projectService")
public class ProjectServiceImpl extends UserDao implements ProjectService {
    @Resource(name = "vProjectEntityDao")
    private VProjectEntityDao vProjectEntityDao;

    @Resource(name="tScientificEntityDao")
    private TScientificEntityDao tScientificEntityDao;

    @Resource(name="tProjectUserEntityDao")
    private TProjectUserEntityDao tProjectUserEntityDao;

    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TScientificEntity> data= tScientificEntityDao.getLists(condition);
        String[] field={"projectId","scientificName","scientificSource","level","createTime",
                        "endTime","isMarch","type","memberList",  "grants","headName",
                        "others"};
        String[] heads={"项目编号","项目名称","项目来源", "项目级别","立项时间","结项时间",
                "是否在研","项目类型","成员名单","资助经费",
                       "项目负责人","备注"};
        ExportExcel.getOS(os,data,field,heads);
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
    public Page<VProjectEntity> listRecordsByCondition(String userid, Page page) {
        Page.FilterModel filterModel=new Page.FilterModel();

        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);

        int userId=Integer.valueOf(userid);

        filterModel.getRules().add(new Page.FilterModel.Rule("userId",userId,"eq"));

        page.addFilter(filterModel);

        vProjectEntityDao.listRecordsByCondition(page);

        return  page;

    }

    @Override
    public Page<VProjectEntity> listRecordsByCondition(Page page) {
        tScientificEntityDao.listRecordsByCondition(page);

        return  page;
    }

    @Override
    public boolean saveRecord(String userId, TScientificEntity record) {

        int id=tScientificEntityDao.saveRecords(record);
        return true;
    }

    @Override
    public void updateRecord(TScientificEntity records) {
            tScientificEntityDao.updateRecords(records);
    }

    @Override
    public void deleteRecord(String id,String realyp) {
        String[] ids=id.split(",");
        for (int i=0;i<ids.length;i++){
            TScientificEntity tScientificEntity=getRecord(Integer.valueOf(ids[i].trim()));

            //删除上传的文件
            DeleteTools deleteTools=new DeleteTools();
            //deleteTools.setRex("http://127.0.0.1:8080/teachers/");

            deleteTools.setReallyPath(realyp);

            tScientificEntityDao.deleteRecords(tScientificEntity);
        }
    }

    @Override
    public TScientificEntity getRecord(Integer id) {
        return tScientificEntityDao.getRecords(id);
    }

    @Override
    public void inSciencePrizeTemp(List<String[]> list, int user_id,String headName) {


        for(int i=0;i<list.size();i++){
            //排除重复导入
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            List<TScientificEntity> tEducateScientificEntities = session.createCriteria(TScientificEntity.class).
                    add(Restrictions.eq("projectId",list.get(i)[0])).list();
            transaction.commit();
            if(tEducateScientificEntities.size() == 0){
                TScientificEntity record = new TScientificEntity();
                String projectId=list.get(i)[0];
                String scientificName = list.get(i)[1];
                String scientificSource= list.get(i)[2];
                String level = list.get(i)[3];
                String createTime = list.get(i)[4];
                String endTime = list.get(i)[5];
                String isMarch = list.get(i)[6];
                String type = list.get(i)[7];
                String grants = list.get(i)[8];
                String others = list.get(i)[9];
                String memberList=list.get(i)[10];




                //headName=findTnameByUserId(user_id);
                record.setProjectId(projectId);
                record.setHeadName(headName);
                record.setMemberList(memberList);
                record.setUserId(user_id);
                record.setScientificName(scientificName);
                record.setScientificSource(scientificSource);
                record.setLevel(level);
                record.setCreateTime(createTime);
                record.setEndTime(endTime);
                record.setIsMarch(isMarch);
                record.setType(type);
                if (grants==null){grants="0";}
                record.setGrants(grants);
                record.setOthers(others);
                record.setStatus("审核通过");

                saveRecord(user_id+"",record);
            }





        }
    }

    @Override
    public void inSciencePrizeAdminTemp(String[] list, int user_id) {

            //排除重复导入
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            List<TScientificEntity> tEducateScientificEntities = session.createCriteria(TScientificEntity.class).
                    add(Restrictions.eq("projectId",list[0])).list();
        transaction.commit();
            if(tEducateScientificEntities.size() == 0){
                TScientificEntity record = new TScientificEntity();
                String projectId=list[0];
                String scientificName = list[1];
                String scientificSource= list[2];
                String level = list[3];
                String createTime = list[4];
                String endTime = list[5];
                String isMarch = list[6];
                String type = list[7];
                String grants = list[8];
                String others = list[9];
                String headName=list[10];
                String memeberList=list[11];

                record.setProjectId(projectId);
                record.setMemberList(memeberList);
                record.setHeadName(headName);
                record.setUserId(user_id);
                record.setScientificName(scientificName);
                record.setScientificSource(scientificSource);
                record.setLevel(level);
                record.setCreateTime(createTime);
                record.setEndTime(endTime);
                record.setIsMarch(isMarch);
                record.setType(type);
                if (grants==null){grants="0";}
                record.setGrants(grants);
                record.setOthers(others);
                record.setStatus("审核通过");

                tScientificEntityDao.saveRecords(record);
                /*
                String u=user_id+"";
                if(user_id<0) u=null;

                saveRecord(u,record);
                */
            }






    }
}
