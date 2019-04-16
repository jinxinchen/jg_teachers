package com.jingguan.article.dao;

import com.jingguan.article.po.TArticleEntity;
import com.jingguan.common.vo.Page;

import java.util.List;

/**
 * Created by 陈 on 2017/11/11.
 */
public interface ArticleDao {

    List<TArticleEntity> getList(Page.FilterModel condition);
    Page loadArticle(Page page);
    int addArticle(int user_id, TArticleEntity tArticleEntity);
    int editArticle(int user_id, TArticleEntity tArticleEntity);
    int deleteArticle(int id);
    void uploadFile(String fileName, String filename, int id, int user_id);
    String getArticleSrcById(int id);
    void inArticle(TArticleEntity tArticleEntity);
}
