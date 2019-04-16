package com.jingguan.baseInfo.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 陈 on 2017/10/17.
 */
@Entity
@Table(name = "t_article", schema = "jg_teachers", catalog = "")
public class TArticleEntity {
    private Integer id;
    private Integer userId;
    private String articleName;
    private Integer level;
    private Timestamp postTime;
    private String publicationName;
    private String publicationLevel;
    private Integer isCall;
    private String articleSrc;
    private String articleLevel;
    private Integer status;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "article_name")
    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    @Basic
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "post_time")
    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    @Basic
    @Column(name = "publication_name")
    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    @Basic
    @Column(name = "publication_level")
    public String getPublicationLevel() {
        return publicationLevel;
    }

    public void setPublicationLevel(String publicationLevel) {
        this.publicationLevel = publicationLevel;
    }

    @Basic
    @Column(name = "is_call")
    public Integer getIsCall() {
        return isCall;
    }

    public void setIsCall(Integer isCall) {
        this.isCall = isCall;
    }

    @Basic
    @Column(name = "article_src")
    public String getArticleSrc() {
        return articleSrc;
    }

    public void setArticleSrc(String articleSrc) {
        this.articleSrc = articleSrc;
    }

    @Basic
    @Column(name = "article_level")
    public String getArticleLevel() {
        return articleLevel;
    }

    public void setArticleLevel(String articleLevel) {
        this.articleLevel = articleLevel;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TArticleEntity that = (TArticleEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (articleName != null ? !articleName.equals(that.articleName) : that.articleName != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (postTime != null ? !postTime.equals(that.postTime) : that.postTime != null) return false;
        if (publicationName != null ? !publicationName.equals(that.publicationName) : that.publicationName != null)
            return false;
        if (publicationLevel != null ? !publicationLevel.equals(that.publicationLevel) : that.publicationLevel != null)
            return false;
        if (isCall != null ? !isCall.equals(that.isCall) : that.isCall != null) return false;
        if (articleSrc != null ? !articleSrc.equals(that.articleSrc) : that.articleSrc != null) return false;
        if (articleLevel != null ? !articleLevel.equals(that.articleLevel) : that.articleLevel != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (articleName != null ? articleName.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (postTime != null ? postTime.hashCode() : 0);
        result = 31 * result + (publicationName != null ? publicationName.hashCode() : 0);
        result = 31 * result + (publicationLevel != null ? publicationLevel.hashCode() : 0);
        result = 31 * result + (isCall != null ? isCall.hashCode() : 0);
        result = 31 * result + (articleSrc != null ? articleSrc.hashCode() : 0);
        result = 31 * result + (articleLevel != null ? articleLevel.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
