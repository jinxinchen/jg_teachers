package com.jingguan.admin.service.impl;

import com.jingguan.admin.dao.AdminArticleDao;
import com.jingguan.admin.po.TArticleEntity;
import com.jingguan.admin.po.VAdminArticleEntity;
import com.jingguan.admin.po.VAdminCopyrightEntity;
import com.jingguan.admin.service.AdminArticleService;
import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.tool.ExportExcel;
import com.jingguan.common.vo.Page;
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
 * Created by 陈 on 2017/11/14.
 */
@Service("adminArticleService")
public class AdminArticleServiceImpl extends UserDao implements AdminArticleService{

    @Resource(name = "adminArticleDao")
    private AdminArticleDao adminArticleDao;

    @Override
    public Page loadAdminArticle(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        page.addFilter(filterModel);
        return adminArticleDao.loadAdminArticle(page);
    }

    @Override
    public int passArticle(int id) {
        return adminArticleDao.passArticle(id);
    }

    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<VAdminArticleEntity> context=getLists(condition);
        String[] field={"uname","type","articleName","postTime","publicationName","publicationLevel",
                        "publicationId","nums","periods","articleLevel","isCall","notice"};

        String[] heads={"教师","类型","论文名称", "发表时间", "刊物名称", "刊物级别", "刊物刊号",
                        "页码","期数","作者排名（1为第一作者）","是否为通讯作者","备注"};
        ExportExcel.getOS(os,context,field,heads);
    }

    @Override
    public List<VAdminArticleEntity> getLists(Page.FilterModel condition) {
        return adminArticleDao.getLists(condition);
    }

    @Override
    public void getOutCopyRightStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<VAdminCopyrightEntity> context=getCopyRightLists(condition);
        WritableWorkbook workbook= Workbook.createWorkbook(os);
        String[] title={
                "教师",
                "作者姓名",
                "题目",
                "专著/教材/译著/其他",
                "出版社",
                "出版时间",
                "著作号",
                "是否为通讯作者",
                "其他参与者",
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

        for (VAdminCopyrightEntity record:context) {
            Label label1=new Label(0,lines,record.getName()+"");
            sheet.addCell(label1);
            Label label2=new Label(1,lines,record.getOwnerName()+"");
            sheet.addCell(label2);
            Label label3=new Label(2,lines,record.getTitle()+"");
            sheet.addCell(label3);
            Label label4=new Label(3,lines,record.getType()+"");
            sheet.addCell(label4);
            Label label5=new Label(4,lines,record.getPublishName()+"");
            sheet.addCell(label5);
            Label label6=new Label(5,lines,record.getPublishTime()+"");
            sheet.addCell(label6);
            Label label7=new Label(6,lines,record.getPublishId()+"");
            sheet.addCell(label7);
            Label label8=new Label(7,lines,record.getOtherParticipator()+"");
            sheet.addCell(label8);
            Label label9=new Label(8,lines,record.getNotice()+"");
            sheet.addCell(label9);
            lines++;
        }
        //将创建的写入输出流并关闭
        workbook.write();
        workbook.close();
    }

    @Override
    public List<VAdminCopyrightEntity> getCopyRightLists(Page.FilterModel condition) {
        return adminArticleDao.getCopyRightLists(condition);
    }

    @Override
    public void inArticle(List<String[]> lists) {
        for(int i=0;i<lists.size();i++){
            Integer user_id = findUserIdByTname(lists.get(i)[0]);
            if(user_id != null){
                Integer articleRes = findArticleByTname(lists.get(i)[2]);
                if(articleRes != null){

                }else{
                    TArticleEntity tArticleEntity = new TArticleEntity();
                    tArticleEntity.setUserId(user_id);
                    tArticleEntity.setType(lists.get(i)[1]);
                    tArticleEntity.setArticleName(lists.get(i)[2]);
                    tArticleEntity.setPostTime(lists.get(i)[3]);
                    tArticleEntity.setPublicationName(lists.get(i)[4]);
                    tArticleEntity.setPublicationLevel(lists.get(i)[5]);
                    tArticleEntity.setPublicationId(lists.get(i)[6]);
                    tArticleEntity.setNums(lists.get(i)[7]);
                    tArticleEntity.setPeriods(lists.get(i)[8]);
                    tArticleEntity.setLevel(lists.get(i)[9]);
                    tArticleEntity.setIsCall(lists.get(i)[10]);
                    tArticleEntity.setNotice(lists.get(i)[11]);
                    adminArticleDao.inArticle(tArticleEntity);
                }
            }
        }
    }
}
