package com.jingguan.admin.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/11/19.
 */
@Entity
@Table(name = "t_copyright", schema = "jg_teachers", catalog = "")
public class TCopyrightEntity {
    private Integer id;
    private String ownerName;
    private String title;
    private String type;
    private String publishName;
    private String publishId;
    private String otherParticipator;
    private String notice;
    private String status;
    private Integer userId;
    private String publishTime;
    private String issbn;
    private String uploadTime;
    private String fileName;
    private String copyRightSrc;

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
    @Column(name = "copyRightSrc")
    public String getCopyRightSrc() {
        return copyRightSrc;
    }

    public void setCopyRightSrc(String copyRightSrc) {
        this.copyRightSrc = copyRightSrc;
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
    @Basic
    @Column(name = "owner_name")
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "publish_name")
    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    @Basic
    @Column(name = "publish_id")
    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    @Basic
    @Column(name = "other_participator")
    public String getOtherParticipator() {
        return otherParticipator;
    }

    public void setOtherParticipator(String otherParticipator) {
        this.otherParticipator = otherParticipator;
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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "publishTime")
    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TCopyrightEntity that = (TCopyrightEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ownerName != null ? !ownerName.equals(that.ownerName) : that.ownerName != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (publishName != null ? !publishName.equals(that.publishName) : that.publishName != null) return false;
        if (publishId != null ? !publishId.equals(that.publishId) : that.publishId != null) return false;
        if (otherParticipator != null ? !otherParticipator.equals(that.otherParticipator) : that.otherParticipator != null)
            return false;
        if (notice != null ? !notice.equals(that.notice) : that.notice != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (publishTime != null ? !publishTime.equals(that.publishTime) : that.publishTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (publishName != null ? publishName.hashCode() : 0);
        result = 31 * result + (publishId != null ? publishId.hashCode() : 0);
        result = 31 * result + (otherParticipator != null ? otherParticipator.hashCode() : 0);
        result = 31 * result + (notice != null ? notice.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "ISSBN")
    public String getIssbn() {
        return issbn;
    }

    public void setIssbn(String issbn) {
        this.issbn = issbn;
    }
}
