package com.jingguan.common.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2018/5/15.
 */
@Entity
@Table(name = "t_article", schema = "jg_teachers", catalog = "")
public class TArticleEntity {
    private Integer id;
    private Integer userId;
    private String articleName;
    private String level;
    private String postTime;
    private String publicationName;
    private String publicationLevel;
    private String isCall;
    private String articleSrc;
    private String articleLevel;
    private String status;
    private String publicationId;
    private String notice;
    private String type;
    private String nums;
    private String periods;
    private String uploadTime;
    private String fileName;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "post_time")
    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
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
    public String getIsCall() {
        return isCall;
    }

    public void setIsCall(String isCall) {
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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "publication_id")
    public String getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(String publicationId) {
        this.publicationId = publicationId;
    }

    @Basic
    @Column(name = "notice")
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "nums")
    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

    @Basic
    @Column(name = "periods")
    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    @Basic
    @Column(name = "upload_time")
    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
        if (publicationId != null ? !publicationId.equals(that.publicationId) : that.publicationId != null)
            return false;
        if (notice != null ? !notice.equals(that.notice) : that.notice != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (nums != null ? !nums.equals(that.nums) : that.nums != null) return false;
        if (periods != null ? !periods.equals(that.periods) : that.periods != null) return false;
        if (uploadTime != null ? !uploadTime.equals(that.uploadTime) : that.uploadTime != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;

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
        result = 31 * result + (publicationId != null ? publicationId.hashCode() : 0);
        result = 31 * result + (notice != null ? notice.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (nums != null ? nums.hashCode() : 0);
        result = 31 * result + (periods != null ? periods.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        return result;
    }
}
