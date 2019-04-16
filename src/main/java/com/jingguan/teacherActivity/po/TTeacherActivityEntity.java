package com.jingguan.teacherActivity.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2017/11/13 0013.
 */
@Entity
@Table(name = "t_teacher_activity", schema = "jg_teachers", catalog = "")
public class TTeacherActivityEntity {
    private int id;
    private Integer userId;//这个不要更新，不用传过来userid，,注解设置updatable = false
    private String activityName;
    private String activityLocation;
    private String activityTime;
    private String activityOrganizers;
    private String others;
    private String status;//这个不要更新，不用传过来status，,注解设置updatable = false
    private String certificate;
    private String certificateUploadTime;

    @Basic
    @Column(name="certificate",updatable = false)
    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Basic
    @Column(name ="certificate_upload_time",updatable = false )
    public String getCertificateUploadTime() {
        return certificateUploadTime;
    }

    public void setCertificateUploadTime(String certificateUploadTime) {
        this.certificateUploadTime = certificateUploadTime;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id",updatable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "activity_name")
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Basic
    @Column(name = "activity_location")
    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }

    @Basic
    @Column(name = "activity_time")
    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    @Basic
    @Column(name = "activity_organizers")
    public String getActivityOrganizers() {
        return activityOrganizers;
    }

    public void setActivityOrganizers(String activityOrganizers) {
        this.activityOrganizers = activityOrganizers;
    }

    @Basic
    @Column(name = "others")
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Basic
    @Column(name = "status",updatable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TTeacherActivityEntity that = (TTeacherActivityEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (activityName != null ? !activityName.equals(that.activityName) : that.activityName != null) return false;
        if (activityLocation != null ? !activityLocation.equals(that.activityLocation) : that.activityLocation != null)
            return false;
        if (activityTime != null ? !activityTime.equals(that.activityTime) : that.activityTime != null) return false;
        if (activityOrganizers != null ? !activityOrganizers.equals(that.activityOrganizers) : that.activityOrganizers != null)
            return false;
        if (others != null ? !others.equals(that.others) : that.others != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (activityName != null ? activityName.hashCode() : 0);
        result = 31 * result + (activityLocation != null ? activityLocation.hashCode() : 0);
        result = 31 * result + (activityTime != null ? activityTime.hashCode() : 0);
        result = 31 * result + (activityOrganizers != null ? activityOrganizers.hashCode() : 0);
        result = 31 * result + (others != null ? others.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
