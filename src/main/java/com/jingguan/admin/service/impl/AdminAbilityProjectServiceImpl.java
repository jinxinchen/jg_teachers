package com.jingguan.admin.service.impl;

import com.jingguan.admin.po.TAbilityProjectEntity;
import com.jingguan.admin.dao.AdminAbilityProjectDao;
import com.jingguan.admin.po.VAdminAbilityprojectEntity;
import com.jingguan.admin.service.AdminAbilityProjectService;
import com.jingguan.common.dao.impl.UserDao;
import com.jingguan.common.vo.Page;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
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
 * Created by 陈 on 2017/11/20.
 */
@Service("adminabilityProjectService")
public class AdminAbilityProjectServiceImpl extends UserDao implements AdminAbilityProjectService{

    @Resource(name = "adminabilityProjectDao")
    private AdminAbilityProjectDao adminAbilityProjectDao;


    @Override
    public Page loadAbilityProject(Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
//        filterModel.getRules().add(new Page.FilterModel.Rule("status", 1, "eq"));
        page.addFilter(filterModel);
        return adminAbilityProjectDao.loadAbilityProject(page);
    }

    @Override
    public int passAbilityProject(int id) {
        return adminAbilityProjectDao.passAbilityProject(id);
    }

    @Override
    public void inAbilityProject(List<String[]> lists) {
        for(int i=0;i<lists.size();i++){
            Integer user_id = findUserIdByTname(lists.get(i)[0]);
            if(user_id != null){
                //排除重复导入
                Session session = getCurrentSession();
                Transaction transaction = session.beginTransaction();
                List<TAbilityProjectEntity> tAbilityProjectEntities = session.createCriteria(TAbilityProjectEntity.class).
                        add(Restrictions.eq("userId",user_id)).
                        add(Restrictions.eq("prizeId",lists.get(i)[1])).list();
                if(tAbilityProjectEntities.size() == 0){
                    TAbilityProjectEntity tAbilityProjectEntity = new TAbilityProjectEntity();
                    tAbilityProjectEntity.setUserId(user_id);
                    tAbilityProjectEntity.setPrizeId(lists.get(i)[1]);
                    tAbilityProjectEntity.setPrizeName(lists.get(i)[2]);
                    tAbilityProjectEntity.setPrizeLevel(lists.get(i)[3]);
                    tAbilityProjectEntity.setUnitOfPrizes(lists.get(i)[4]);
                    tAbilityProjectEntity.setWinner(lists.get(i)[5]);
                    tAbilityProjectEntity.setWinTime(lists.get(i)[6]);
                    tAbilityProjectEntity.setFunds(lists.get(i)[7]);
                    tAbilityProjectEntity.setNotice(lists.get(i)[8]);
                    adminAbilityProjectDao.inAbilityProject(tAbilityProjectEntity);
                }

            }
        }
    }

    @Override
    public void getOutAbilityProjectStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<VAdminAbilityprojectEntity> context=getAbilityProjectLists(condition);
        WritableWorkbook workbook= Workbook.createWorkbook(os);
        String[] title={
                "教师",
                "编号",
                "称号",
                "获奖级别",
                "授予单位",
                "获奖者",
                "获奖时间",
                "资助获奖励金额",
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

        for (VAdminAbilityprojectEntity record:context) {
            Label label1=new Label(0,lines,record.getName()+"");
            sheet.addCell(label1);
            Label label2=new Label(1,lines,record.getPrizeId()+"");
            sheet.addCell(label2);
            Label label3=new Label(2,lines,record.getPrizeName()+"");
            sheet.addCell(label3);
            Label label4=new Label(3,lines,record.getPrizeLevel()+"");
            sheet.addCell(label4);
            Label label5=new Label(4,lines,record.getUnitOfPrizes()+"");
            sheet.addCell(label5);
            Label label6=new Label(5,lines,record.getWinner()+"");
            sheet.addCell(label6);
            Label label7=new Label(6,lines,record.getWinTime()+"");
            sheet.addCell(label7);
            Label label8=new Label(7,lines,record.getFunds()+"");
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
    public List<VAdminAbilityprojectEntity> getAbilityProjectLists(Page.FilterModel condition) {
        return adminAbilityProjectDao.getAbilityProjectLists(condition);
    }
}
