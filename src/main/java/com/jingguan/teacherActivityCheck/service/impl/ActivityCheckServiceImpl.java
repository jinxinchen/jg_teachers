package com.jingguan.teacherActivityCheck.service.impl;

import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.vo.Page;
import com.jingguan.teacherActivity.service.TeacherActivityService;
import com.jingguan.teacherActivityCheck.dao.TChangeStatusDao;
import com.jingguan.teacherActivityCheck.dao.VTeacherActivityCheckDao;
import com.jingguan.teacherActivityCheck.po.TChangeStatus;
import com.jingguan.teacherActivityCheck.po.VTeachersActivityCheckEntity;
import com.jingguan.teacherActivityCheck.service.ActivityCheckService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhouliang on 2017/11/13 0013.
 */
@Repository("activityCheckService")
public class ActivityCheckServiceImpl extends UserDao implements ActivityCheckService {

    @Resource(name = "vTeacherActivityCheckDao")
    private VTeacherActivityCheckDao vTeacherActivityCheckDao;
    @Resource(name="tAChangeStatusDaoImpl")
    private TChangeStatusDao tChangeStatusDao;
    @Resource(name="teacherActivityService")
    private TeacherActivityService teacherActivityService;

    @Override
    public void check(String id) {
        TChangeStatus tChangeStatus =tChangeStatusDao.getRecords(Integer.valueOf(id.trim()));
        if(("通过").equals(tChangeStatus.getStatus())){
            tChangeStatus.setStatus("未通过");
        }else {
            tChangeStatus.setStatus("通过");
        }
        tChangeStatusDao.update(tChangeStatus);
    }

    @Override
    public void inActivity(List<String[]> list) {
        for (int i=0;i<list.size();i++){
            Integer user_id = findUserIdByTname(list.get(i)[0]);
            if(user_id!=null){
                    teacherActivityService.inSciencePrizeAdminTemp(list.get(i),user_id);
            }
            /*if(user_id != null){
                TTeacherActivityEntity tTeacherActivityEntity = new TTeacherActivityEntity();
                tTeacherActivityEntity.setUserId(user_id);
                tTeacherActivityEntity.setActivityName(list.get(i)[1]);
                tTeacherActivityEntity.setActivityLocation(list.get(i)[2]);
                tTeacherActivityEntity.setActivityTime(list.get(i)[3]);
                tTeacherActivityEntity.setActivityOrganizers(list.get(i)[4]);
                tTeacherActivityEntity.setOthers(list.get(i)[5]);
                vTeacherActivityCheckDao.inActivity(tTeacherActivityEntity);
            }
            */

        }
    }

    @Override
    public Page<VTeachersActivityCheckEntity> listRecordsByConditions(Page page) {
        return vTeacherActivityCheckDao.listRecordsByCondition(page);
    }

    @Override
    public void getOutStream(ServletOutputStream os,Page.FilterModel condition) throws IOException, WriteException {

        List<VTeachersActivityCheckEntity> context=getLists(condition);
        WritableWorkbook workbook= Workbook.createWorkbook(os);
        String[] title={
                "老师姓名",
                "活动名称",
                "活动地点",
                "活动时间",
                "举办单位",
                "备注",
                };

        int cols=title.length;

        int lines=1;//记录到第几行

        //创建新的一页
        WritableSheet sheet=workbook.createSheet("First Sheet",0);

        //创建表头
        for(int i=0;i<cols;i++){
            Label label=new Label(i,0,title[i]);
            sheet.addCell(label);
        }

        for (VTeachersActivityCheckEntity record:context) {
            Label label1=new Label(0,lines,record.getTeacherName()+"");
            sheet.addCell(label1);
            Label label2=new Label(1,lines,record.getActivityName()+"");
            sheet.addCell(label2);
            Label label3=new Label(2,lines,record.getActivityLocation()+"");
            sheet.addCell(label3);
            Label label4=new Label(3,lines,record.getActivityTime()+"");
            sheet.addCell(label4);
            Label label5=new Label(4,lines,record.getActivityOrganizers()+"");
            sheet.addCell(label5);
            Label label7=new Label(5,lines,record.getOthers()+"");
            sheet.addCell(label7);
            lines++;
        }
        //将创建的写入输出流并关闭
        workbook.write();
        workbook.close();
    }

    @Override
    public void updateRecord(String id, String status) {

        vTeacherActivityCheckDao.update(Integer.valueOf(id.trim()),status.trim());

    }

    @Override
    public List<VTeachersActivityCheckEntity> getLists(Page.FilterModel condition) {
        return vTeacherActivityCheckDao.getLists(condition);
    }
}
