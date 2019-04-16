package com.jingguan.article.service;

import com.jingguan.article.po.TArticleEntity;
import com.jingguan.common.tool.ExportExcelImpl;
import com.jingguan.common.vo.Page;

import java.util.List;

/**
 * Created by 陈 on 2017/11/11.
 */
public interface ArticleService extends ExportExcelImpl {
    Page<TArticleEntity> loadArticle(Page page, int user_id);
    int addArticle(int user_id, TArticleEntity tArticleEntity);
    int editArticle(int user_id, TArticleEntity tArticleEntity);
    int deleteArticle(int id);
    void uploadFile(String fileName, String filename, int id, int user_id);
    String getArticleSrcById(int id);
    void InArticle(List<String[]> list, int user_id);
}
