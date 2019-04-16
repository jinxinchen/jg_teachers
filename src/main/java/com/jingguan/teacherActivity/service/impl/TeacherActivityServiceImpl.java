package com.jingguan.teacherActivity.service.impl;

import com.jingguan.common.tool.DeleteTools;
import com.jingguan.common.tool.ExportExcel;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherActivity.dao.CertificateUploadDao;
import com.jingguan.teacherActivity.dao.TTeacherActivityDao;
import com.jingguan.teacherActivity.po.CertificateUpload;
import com.jingguan.teacherActivity.po.TTeacherActivityEntity;
import com.jingguan.teacherActivity.service.TeacherActivityService;
import jxl.write.WriteException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.jingguan.common.dao.impl.BaseDao.getCurrentSession;

/**
 * Created by zhouliang on 2017/11/13 0013.
 */
@Service("teacherActivityService")
public class TeacherActivityServiceImpl implements TeacherActivityService {

    @Resource(name = "tTeacherActivityDao")
    private TTeacherActivityDao tTeacherActivityDao;

    @Resource(name = "certificateUploadDao")
    private CertificateUploadDao certificateUploadDao;



    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TTeacherActivityEntity> context=tTeacherActivityDao.getLists(condition);
        String[] fields={"activityName","activityLocation",
                        "activityTime","activityOrganizers",
                        "others"};
        String[] heads={"活动名称","活动地点","活动时间",
                    "举办单位","备注"};
        ExportExcel.getOS(os,context,fields,heads);
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
    public void updatePath(String id, String path) {

        CertificateUpload record = new CertificateUpload();
        record.setId(Integer.valueOf(id.trim()));
        record.setCertificate(path);

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        record.setCertificateUploadTime(time);

        certificateUploadDao.updatePath(record);

    }


    @Override
    public String getPath(String id) {
        return certificateUploadDao.getPath(Integer.valueOf(id.trim()));
    }

    @Override
    public Page<TTeacherActivityEntity> listRecordsByCondition(String userid, Page page) {

        //查询条件
        Page.FilterModel filterModel = new Page.FilterModel();

        //过滤条件Rules是AND还是OR
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        int userId = Integer.valueOf(userid);
        //只要为当前用户的获得记录
        filterModel.getRules().add(new Page.FilterModel.Rule("userId", userId, "eq"));

        page.addFilter(filterModel);

        tTeacherActivityDao.listRecordsByCondition(page);

        return page;
    }

    @Override
    public boolean saveRecord(int userId, TTeacherActivityEntity record) {

        record.setUserId(userId);
        record.setStatus("未通过");
        tTeacherActivityDao.saveRecords(record);
        return true;
    }

    @Override
    public void updateRecord(TTeacherActivityEntity records) {
        tTeacherActivityDao.updateRecords(records);
    }

    @Override
    public void deleteRecord(String id, String realyp) {
        String[] ids = id.split(",");
        for (int i = 0; i < ids.length; i++) {
            TTeacherActivityEntity tTeacherActivityEntity = getRecord(Integer.valueOf(ids[i].trim()));

        /*    //删除上传的文件
            DeleteTools deleteTools = new DeleteTools();
            //deleteTools.setRex("http://127.0.0.1:8080/teachers/");
            deleteTools.setReallyPath(realyp);
            deleteTools.deleteFile(tTeacherActivityEntity.getCertificate());
            */


            tTeacherActivityDao.deleteRecords(tTeacherActivityEntity);
        }
    }

    @Override
    public TTeacherActivityEntity getRecord(Integer id) {
        return tTeacherActivityDao.getRecords(id);
    }

    @Override
    public void inSciencePrizeTemp(List<String[]> list, int user_id) {
       for (int i = 0; i < list.size(); i++) {
            //排除重复导入
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            List<TTeacherActivityEntity> tTeacherActivityEntity = session.createCriteria(TTeacherActivityEntity.class).
                    add(Restrictions.eq("userId", user_id)).
                    add(Restrictions.eq("activityName", list.get(i)[0])).
                    add(Restrictions.eq("activityLocation", list.get(i)[1])).
                    add(Restrictions.eq("activityTime", list.get(i)[2])).
                    add(Restrictions.eq("activityOrganizers", list.get(i)[3]))
                    .list();
            transaction.commit();
            if (tTeacherActivityEntity.size() == 0) {
                TTeacherActivityEntity record = new TTeacherActivityEntity();
                String activityName = list.get(i)[0];
                String activityLocation = list.get(i)[1];
                String activityTime = list.get(i)[2];
                String activityOrganizers = list.get(i)[3];
                String others = list.get(i)[4];
                record.setActivityName(activityName);
                record.setActivityLocation(activityLocation);
                record.setActivityTime(activityTime);
                record.setActivityOrganizers(activityOrganizers);
                record.setOthers(others);
                record.setUserId(user_id);
                record.setStatus("审核通过");

                tTeacherActivityDao.saveRecords(record);
            }
        }
    }


    @Override
    public void inSciencePrizeAdminTemp(String[] list, int user_id) {

            //排除重复导入
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            List<TTeacherActivityEntity> tTeacherActivityEntity = session.createCriteria(TTeacherActivityEntity.class).
                    add(Restrictions.eq("userId", user_id)).
                    add(Restrictions.eq("activityName", list[1])).
                    add(Restrictions.eq("activityLocation", list[2])).
                    add(Restrictions.eq("activityTime", list[3])).
                    add(Restrictions.eq("activityOrganizers", list[4]))
                    .list();
            transaction.commit();
            if (tTeacherActivityEntity.size() == 0) {
                TTeacherActivityEntity record = new TTeacherActivityEntity();
                String teacherName=list[0];
                String activityName = list[1];
                String activityLocation = list[2];
                String activityTime = list[3];
                String activityOrganizers = list[4];
                String others = list[5];

                record.setActivityName(activityName);
                record.setActivityLocation(activityLocation);
                record.setActivityTime(activityTime);
                record.setActivityOrganizers(activityOrganizers);
                record.setOthers(others);
                record.setUserId(user_id);
                record.setStatus("审核通过");

                tTeacherActivityDao.saveRecords(record);
            }

    }
}
