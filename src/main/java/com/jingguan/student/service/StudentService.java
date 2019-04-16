package com.jingguan.student.service;

import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;
import com.jingguan.student.po.*;

import java.util.List;

public interface StudentService extends ExportExcelImpl {
    Page<TStudentEntity> load(Page page);

    Page<TPostgraduateArticleEntity> loadPostGraduateArticle(Page page);

    Page<TPostgraduateKeyanEntity> loadPostGraduateKeyan(Page page);

    Page<TPostgraduateJingsaiEntity> loadPostGraduateJingsai(Page page);

    Page<TStuAbroadEntity> loadStuAbroad(Page page);

    Page<TStuInfoEntity> loadInfo(Page page);

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

    void inStudent(List<String[]> list);

    void inPostGraduateArticle(List<String[]> list);

    void inPostGraduateKeyan(List<String[]> list);

    void inPostGraduateJingsai(List<String[]> list);

    void inStuAbroad(List<String[]> list);

    void inStudentInfo(List<String[]> list);

    String getAwardSrcById(int id);

    String getIssbnSrcById(int id);

    String getJingsaiSrcById(int id);


}
