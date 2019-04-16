package com.jingguan.projectCheck.service.impl;

import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.vo.Page;
import com.jingguan.project.service.ProjectService;
import com.jingguan.projectCheck.dao.TChangeStatusDao;
import com.jingguan.projectCheck.dao.TScientificEntityDao;
import com.jingguan.projectCheck.po.TChangeStatus;
import com.jingguan.projectCheck.po.TScientificEntity;
import com.jingguan.projectCheck.service.ProjectCheckService;
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
 * Created by zhouliang on 2017/12/18 0018.
 */
@Service("projectCheckService")
public class ProjectCheckServiceImpl extends UserDao implements ProjectCheckService {
    @Resource(name="tPChangeStatusDao")
    private TChangeStatusDao tChangeStatusDao;

    @Resource(name="tCheckScientificEntityDao")
    private TScientificEntityDao tScientificEntityDao;

    @Resource(name = "projectService")
    private ProjectService projectService;


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
    public void inScienceProject(List<String[]> lists) {
        for(int i=0;i<lists.size();i++){
            Integer user_id=-1;
           if(lists.get(i)[10]!=null){
               user_id= findUserIdByTname(lists.get(i)[10]);
               if(user_id==null) user_id=-1;
            }
            projectService.inSciencePrizeAdminTemp(lists.get(i),user_id);
        }
    }

    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {

        List<TScientificEntity> context=getLists(condition);
        WritableWorkbook workbook= Workbook.createWorkbook(os);
        String[] title={
                "项目编号",
                "项目名称",
                "项目来源",
                "项目类别",//等级
                "立项时间",
                "结束时间",

                "是否在研",
                "项目类型",
                "资助经费",
                "备注",
                "立项书上传时间",
                "结项书上传时间",
                "负责人",
                "成员名单",
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


        for (TScientificEntity record:context) {
            Label label1=new Label(0,lines,record.getProjectId()+"");
            sheet.addCell(label1);
            Label label2=new Label(1,lines,record.getScientificName()+"");
            sheet.addCell(label2);
            Label label3=new Label(2,lines,record.getScientificSource()+"");
            sheet.addCell(label3);
            Label label4=new Label(3,lines,record.getLevel()+"");
            sheet.addCell(label4);
            Label label5=new Label(4,lines,record.getCreateTime()+"");
            sheet.addCell(label5);
            Label label6=new Label(5,lines,record.getEndTime()+"");
            sheet.addCell(label6);
            Label label7=new Label(6,lines,record.getIsMarch()+"");
            sheet.addCell(label7);

            Label label8=new Label(7,lines,record.getType()+"");
            sheet.addCell(label8);
            Label label9=new Label(8,lines,record.getGrants()+"");
            sheet.addCell(label9);
            Label label10=new Label(10,lines,record.getCreateUpdateTime()+"");
            sheet.addCell(label10);
            Label label11=new Label(11,lines,record.getEndUpdateTime()+"");
            sheet.addCell(label11);
            Label label13=new Label(9,lines,record.getOthers()+"");
            sheet.addCell(label13);

            String name=record.getHeadName();
            Label label14=new Label(12,lines,name);
            sheet.addCell(label14);

            Label label15=new Label(13,lines,record.getMemberList());
            sheet.addCell(label15);

            lines++;
        }
        //将创建的写入输出流并关闭
        workbook.write();
        workbook.close();

    }

    @Override
    public List<TScientificEntity> getLists(Page.FilterModel condition) {
        return tScientificEntityDao.getLists(condition);
    }

    @Override
    public Page<TScientificEntity> listRecordsByConditions(Page page) {
        return tScientificEntityDao.listRecordsByCondition(page);
    }
}
