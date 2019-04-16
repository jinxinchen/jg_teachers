package com.jingguan.article.service.impl;

import com.jingguan.article.dao.ArticleDao;
import com.jingguan.article.po.TArticleEntity;
import com.jingguan.article.service.ArticleService;
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
 * Created by 陈 on 2017/11/11.
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService{

    @Resource(name = "articleDao")
    private ArticleDao articleDao;

    @Override
    public void getOutStream(ServletOutputStream os, Page.FilterModel condition) throws IOException, WriteException {
        List<TArticleEntity> data=articleDao.getList(condition);

        String[] field={"type","articleName","postTime","publicationName","publicationLevel",
                        "publicationId","nums","periods","articleLevel","isCall","notice"};

         String[] heads={"类型","论文名称", "发表时间", "刊物名称", "刊物级别", "刊物刊号",
                          "页码","期数","作者排名（1为第一作者）","是否为通讯作者","备注"};

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
    public Page<TArticleEntity> loadArticle(Page page, int user_id) {
        Page.FilterModel filterModel = new Page.FilterModel();
        filterModel.setGroupOp(Page.FilterModel.GROUP_AND);
        filterModel.getRules().add(new Page.FilterModel.Rule("userId", user_id, "eq"));
        page.addFilter(filterModel);
        return articleDao.loadArticle(page);
    }

    @Override
    public int addArticle(int user_id, TArticleEntity tArticleEntity) {
        return articleDao.addArticle(user_id,tArticleEntity);
    }

    @Override
    public int editArticle(int user_id, TArticleEntity tArticleEntity) {
        return articleDao.editArticle(user_id,tArticleEntity);
    }

    @Override
    public int deleteArticle(int id) {
        return articleDao.deleteArticle(id  );
    }

    @Override
    public void uploadFile(String fileName,String filename, int id, int user_id) {
        articleDao.uploadFile(fileName,filename,id,user_id);
    }

    @Override
    public String getArticleSrcById(int id) {
        return articleDao.getArticleSrcById(id);
    }

    @Override
    public void InArticle(List<String[]> list, int user_id) {
        for(int i=0;i<list.size();i++){
            //排除重复导入
            Session session = getCurrentSession();
            Transaction transaction = session.beginTransaction();
            List<TArticleEntity> tArticleEntities = session.createCriteria(TArticleEntity.class).
                    add(Restrictions.eq("userId",user_id)).
                    add(Restrictions.eq("type",list.get(i)[0])).
                    add(Restrictions.eq("articleName",list.get(i)[1])).
                    list();
            if(tArticleEntities.size() == 0){
                TArticleEntity tArticleEntity = new TArticleEntity();
                String type = list.get(i)[0];
                String articleName = list.get(i)[1];
                String postTime = list.get(i)[2];
                String publicationName = list.get(i)[3];
                String publicationLevel = list.get(i)[4];
                String publicationId = list.get(i)[5];
                String nums = list.get(i)[6];
                String periods = list.get(i)[7];
                String level = list.get(i)[8];

                String isCall = list.get(i)[9];
                String notice = list.get(i)[10];
                tArticleEntity.setType(type);
                tArticleEntity.setArticleName(articleName);
                tArticleEntity.setPostTime(postTime);
                tArticleEntity.setPublicationName(publicationName);
                tArticleEntity.setPublicationLevel(publicationLevel);
                tArticleEntity.setPublicationId(publicationId);
                tArticleEntity.setNums(nums);
                tArticleEntity.setPeriods(periods);
                tArticleEntity.setLevel(level);
                tArticleEntity.setIsCall(isCall);
                tArticleEntity.setNotice(notice);
                tArticleEntity.setUserId(user_id);
                tArticleEntity.setStatus("审核通过");

                articleDao.inArticle(tArticleEntity);
            }





        }
    }


}
