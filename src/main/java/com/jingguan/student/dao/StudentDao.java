package com.jingguan.student.dao;

import com.jingguan.common.vo.Page;
import com.jingguan.student.po.*;

import java.util.List;

public interface StudentDao {
    List<TStudentEntity> getList(Page.FilterModel condition);

    List<TPostgraduateArticleEntity> getListPostGraduateArticle(Page.FilterModel condition);

    List<TPostgraduateKeyanEntity> getListPostGraduateKeyan(Page.FilterModel condition);

    List<TPostgraduateJingsaiEntity> getListPostGraduateJingsai(Page.FilterModel condition);

    List<TStuAbroadEntity> getListStuAbroad(Page.FilterModel condition);

    List<TStuInfoEntity> getListStuInfo(Page.FilterModel condition);

    Page load(Page page);

    Page loadPostGraduateArticle(Page page);

    Page loadPostGraduateKeyan(Page page);

    Page loadPostGraduateJingsai(Page page);

    Page loadStuAbroad(Page page);

    Page loadStuInfo(Page page);

    int add(TStudentEntity tStudentEntity);

    int addPostGraduateArticle(TPostgraduateArticleEntity tPostgraduateArticleEntity);

    int addPostGraduateKeyan(TPostgraduateKeyanEntity tPostgraduateKeyanEntity);

    int addPostGraduateJingsai(TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity);

    int addStuAbroad(TStuAbroadEntity tStuAbroadEntity);

    int addInfo(TStuInfoEntity tStuInfoEntity);

    int edit(TStudentEntity tStudentEntity);

    int editPostGraduateArticle(TPostgraduateArticleEntity tPostgraduateArticleEntity);

    int editPostGraduateKeyan(TPostgraduateKeyanEntity tPostgraduateKeyanEntity);

    int editPostGraduateJingsai(TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity);

    int editStuAbroad(TStuAbroadEntity tStuAbroadEntity);

    int editInfo(TStuInfoEntity tStuInfoEntity);

    int delete(int id);

    int deletePostGraduateArticle(int id);

    int deletePostGraduateKeyan(int id);

    int deletePostGraduateJingsai(int id);

    int deleteStuAbroad(int id);

    int deleteInfo(int id);


    void inStudent(TStudentEntity tStudentEntity);

    void inPostGraduateArticle(TPostgraduateArticleEntity tPostgraduateArticleEntity);


    void inPostGraduateKeyan(TPostgraduateKeyanEntity tPostgraduateKeyanEntity);


    void inPostGraduateJingsai(TPostgraduateJingsaiEntity tPostgraduateJingsaiEntity);


    void inStuAbroad(TStuAbroadEntity tStuAbroadEntity);

    void inStudentInfo(TStuInfoEntity tStuInfoEntity);

    String getAwardSrcById(int id);

    String getIssbnSrcById(int id);

    String getJingsaiSrcById(int id);
}
