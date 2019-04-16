package com.jingguan.teacherActivityCheck.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2017/11/13 0013.
 */
@Entity
@Table(name = "v_teachers_activity_check", schema = "jg_teachers", catalog = "")
public class VTeachersActivityCheckEntity {
    private int userId;
    private String teacherName;
    private int id;
    private Integer baseinfoUserid;
    private String activityName;
    private String activityLocation;
    private String activityTime;
    private String activityOrganizers;
    private String others;
    private String status;
    private String certificate;


    @Basic
    @Column(name = "certificate")
    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "teacher_name")
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
    @Column(name = "baseinfo_userid")
    public Integer getBaseinfoUserid() {
        return baseinfoUserid;
    }

    public void setBaseinfoUserid(Integer baseinfoUserid) {
        this.baseinfoUserid = baseinfoUserid;
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

        VTeachersActivityCheckEntity that = (VTeachersActivityCheckEntity) o;

        if (userId != that.userId) return false;
        if (id != that.id) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
        if (baseinfoUserid != null ? !baseinfoUserid.equals(that.baseinfoUserid) : that.baseinfoUserid != null)
            return false;
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
        int result = userId;
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (baseinfoUserid != null ? baseinfoUserid.hashCode() : 0);
        result = 31 * result + (activityName != null ? activityName.hashCode() : 0);
        result = 31 * result + (activityLocation != null ? activityLocation.hashCode() : 0);
        result = 31 * result + (activityTime != null ? activityTime.hashCode() : 0);
        result = 31 * result + (activityOrganizers != null ? activityOrganizers.hashCode() : 0);
        result = 31 * result + (others != null ? others.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
