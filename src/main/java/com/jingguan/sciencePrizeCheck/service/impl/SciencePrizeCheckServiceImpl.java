package com.jingguan.sciencePrizeCheck.service.impl;

import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.vo.Page;
import com.jingguan.sciencePrize.po.TEducateScientificEntity;
import com.jingguan.sciencePrize.service.SciencePrizeService;
import com.jingguan.sciencePrizeCheck.dao.TChangeStatusDao;
import com.jingguan.sciencePrizeCheck.dao.VTeachersPrizeCheckEntityDao;
import com.jingguan.sciencePrizeCheck.po.TChangeStatus;
import com.jingguan.sciencePrizeCheck.po.VTeachersPrizeCheckEntity;
import com.jingguan.sciencePrizeCheck.service.SciencePrizeCheckService;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhouliang on 2017/11/19 0019.
 */
@Service("sciencePrizeCheckService")
public class SciencePrizeCheckServiceImpl extends UserDao implements SciencePrizeCheckService {

    @Resource(name = "vTeachersPrizeCheckEntityDao")
    private  VTeachersPrizeCheckEntityDao vTeachersPrizeCheckEntityDao;

    @Resource(name = "tSChangeStatusDao")
    private TChangeStatusDao tChangeStatusDao;

    @Resource(name = "sciencePrizeService")
    private SciencePrizeService sciencePrizeService;


    @Override
    public int getUserIdByTname(String name) {
        return findUserIdByTname(name);
    }

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
    public void inSciencePrize(List<String[]> list) {
        for (int i=0;i<list.size();i++){
            Integer user_id = findUserIdByTname(list.get(i)[0]);
            if(user_id==null) user_id=-1;
            sciencePrizeService.inSciencePrizeAdminTemp(list.get(i),user_id);
        }
    }


    @Override
    public Page<VTeachersPrizeCheckEntity> listRecordsByConditions(Page page) {
        return vTeachersPrizeCheckEntityDao.listRecordsByCondition(page);
    }

    @Override
    public void updateRecord(TEducateScientificEntity tEducateScientificEntity) {
            vTeachersPrizeCheckEntityDao.update(tEducateScientificEntity);
    }

    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

        List<VTeachersPrizeCheckEntity> context=getLists(condition);
        WritableWorkbook workbook= Workbook.createWorkbook(os);
        String[] title={
                "老师姓名",
                "获奖名称",
                "成果名称",
                "证书编号",
                "获奖类别",
                "获奖日期",
                "授奖单位",
                "学校署名",
                "作者署名",
                "成员名单",
                //'证明上传',
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


        for (VTeachersPrizeCheckEntity record:context) {
            Label label1=new Label(0,lines,record.getName()+"");
            sheet.addCell(label1);
            Label label2=new Label(1,lines,record.getPrizeName()+"");
            sheet.addCell(label2);
            Label label3=new Label(2,lines,record.getEducateScientificName()+"");
            sheet.addCell(label3);
            Label label4=new Label(3,lines,record.getCertifyNumber()+"");
              /*    "老师姓名",
                "获奖名称",
                "成果名称",
                "获奖级别",
                "获奖等级",
                "获奖日期",
                "授奖单位",
                "学校署名",
                "作者署名",
                "成员名单",
                //'证明上传',
                "备注",
                "状态",
        */    sheet.addCell(label4);
            Label label5=new Label(4,lines,record.getType()+"");
            sheet.addCell(label5);
            Label label6=new Label(5,lines,record.getPrizeTime()+"");
            sheet.addCell(label6);
            Label label7=new Label(6,lines,record.getTheUnit()+"");
            sheet.addCell(label7);

            Label label8=new Label(7,lines,record.getSchoolName()+"");
            sheet.addCell(label8);
            Label label9=new Label(8,lines,record.getAuthor()+"");
            sheet.addCell(label9);
            Label label10=new Label(9,lines,record.getMembersList()+"");
            sheet.addCell(label10);
            Label label11=new Label(10,lines,record.getOthers()+"");
            sheet.addCell(label11);
            lines++;
        }
        //将创建的写入输出流并关闭
        workbook.write();
        workbook.close();
    }

    @Override
    public List<VTeachersPrizeCheckEntity> getLists(Page.FilterModel condition) {
        return vTeachersPrizeCheckEntityDao.getLists(condition);
    }
}
