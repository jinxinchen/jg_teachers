package com.jingguan.abilityProject.service.impl;

import com.jingguan.abilityProject.dao.AbilityProjectDao;
import com.jingguan.abilityProject.po.TAbilityProjectEntity;
import com.jingguan.abilityProject.service.AbilityProjectService;
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

import static com.jingguan.common.dao.impl.BaseDao.getCurrentSession;

/**
 * Created by 陈 on 2017/11/18.
 */
@Service("abilityProjectService")
public class AbilityProjectServiceImpl implements AbilityProjectService {

    @Resource(name = "abilityProjectDao")
    private AbilityProjectDao abilityProjectDao;

    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TAbilityProjectEntity> data=abilityProjectDao.getList(condition);

        String[] field={"prizeId","prizeName","prizeLevel","unitOfPrizes",
                        "winner","winTime","funds","notice"};
        String[] heads={"编号","项目名称","获奖级别", "授予单位",
                        "获奖者","获奖时间", "资助或奖励金额","备注"};
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
    public Page loadAbilityProject(int user_id, Page page) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        filterModel.getRules().add(new Page.FilterModel.Rule("userId", user_id, "eq"));
        page.addFilter(filterModel);
        return abilityProjectDao.loadAbilityProject(page);
    }

    @Override
    public int editAbilityProject(int user_id, TAbilityProjectEntity tAbilityProjectEntity) {
        return abilityProjectDao.editAbilityProject(user_id,tAbilityProjectEntity);
    }

    @Override
    public int addAbilityProject(int user_id, TAbilityProjectEntity tAbilityProjectEntity) {
        return abilityProjectDao.addAbilityProject(user_id,tAbilityProjectEntity);
    }

    @Override
    public int deleteAbilityProject(int id) {
        return abilityProjectDao.deleteAbilityProject(id);
    }

    @Override
    public String getAbilityProjectSrcById(int id) {
        return abilityProjectDao.getAbilityProjectSrcById(id);
    }

    @Override
    public void uploadFile(String fileName, String filename, int id, int user_id) {
        abilityProjectDao.uploadFile(fileName,filename,id,user_id);
    }

    @Override
    public void inAbilityProject(List<String[]> list, int user_id) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            List<TAbilityProjectEntity> tAbilityProjectEntities = session.createCriteria(TAbilityProjectEntity.class).
                    add(Restrictions.eq("userId",user_id)).
                    add(Restrictions.eq("prizeId",list.get(i)[0])).
                    list();
            if(tAbilityProjectEntities.size() == 0){
                TAbilityProjectEntity tAbilityProjectEntity = new TAbilityProjectEntity();
                String prizeId = list.get(i)[0];
                String prizeName = list.get(i)[1];
                String prizeLevel = list.get(i)[2];
                String unitOfPrizes = list.get(i)[3];
                String winner = list.get(i)[4];
                String winTime = list.get(i)[5];
                String funds = list.get(i)[6];
                String notice = list.get(i)[7];
                tAbilityProjectEntity.setPrizeId(prizeId);
                tAbilityProjectEntity.setPrizeName(prizeName);
                tAbilityProjectEntity.setPrizeLevel(prizeLevel);
                tAbilityProjectEntity.setUnitOfPrizes(unitOfPrizes);
                tAbilityProjectEntity.setWinner(winner);
                tAbilityProjectEntity.setWinTime(winTime);
                tAbilityProjectEntity.setFunds(funds);
                tAbilityProjectEntity.setNotice(notice);
                tAbilityProjectEntity.setUserId(user_id);
                tAbilityProjectEntity.setStatus("审核通过");

                abilityProjectDao.inAbilityProject(tAbilityProjectEntity);
            }





        }
    }
}
