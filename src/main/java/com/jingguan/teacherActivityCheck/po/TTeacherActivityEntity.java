package com.jingguan.teacherActivityCheck.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2017/11/19 0019.
 */
@Entity
@Table(name = "t_teacher_activity", schema = "jg_teachers", catalog = "")
public class TTeacherActivityEntity {
    private int id;
    private String status;
    private Integer userId;
    private String activityName;
    private String activityLocation;
    private String activityTime;
    private String activityOrganizers;
    private String others;
    private String certificateUploadTime;
    private String certificate;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status")
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
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
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
    @Column(name = "certificate_upload_time")
    public String getCertificateUploadTime() {
        return certificateUploadTime;
    }

    public void setCertificateUploadTime(String certificateUploadTime) {
        this.certificateUploadTime = certificateUploadTime;
    }

    @Basic
    @Column(name = "certificate")
    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
}
