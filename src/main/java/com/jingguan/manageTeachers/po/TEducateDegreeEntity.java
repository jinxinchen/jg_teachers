package com.jingguan.manageTeachers.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2018/11/25 0025.
 */
@Entity
@Table(name = "t_educate_degree", schema = "jg_teachers", catalog = "")
public class TEducateDegreeEntity {
    private Integer userId;
    private String educateDegreeName;
    private String isMentor;
    private String educateDegreeLevel;
    private String major;
    private String tutorClass;
    private String forClass;
    private String mentorType;
    private String officeStatus;
    private String reportTime;
    private String positionType;

    @Basic
    @Column(name="position_type")
    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    @Basic
    @Column(name = "report_time")
    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }



    @Id
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "educate_degree_name")
    public String getEducateDegreeName() {
        return educateDegreeName;
    }

    public void setEducateDegreeName(String educateDegreeName) {
        this.educateDegreeName = educateDegreeName;
    }

    @Basic
    @Column(name = "is_mentor")
    public String getIsMentor() {
        return isMentor;
    }

    public void setIsMentor(String isMentor) {
        this.isMentor = isMentor;
    }

    @Basic
    @Column(name = "educate_degree_level")
    public String getEducateDegreeLevel() {
        return educateDegreeLevel;
    }

    public void setEducateDegreeLevel(String educateDegreeLevel) {
        this.educateDegreeLevel = educateDegreeLevel;
    }

    @Basic
    @Column(name = "major")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "tutor_class")
    public String getTutorClass() {
        return tutorClass;
    }

    public void setTutorClass(String tutorClass) {
        this.tutorClass = tutorClass;
    }

    @Basic
    @Column(name = "for_class")
    public String getForClass() {
        return forClass;
    }

    public void setForClass(String forClass) {
        this.forClass = forClass;
    }

    @Basic
    @Column(name = "mentor_type")
    public String getMentorType() {
        return mentorType;
    }

    public void setMentorType(String mentorType) {
        this.mentorType = mentorType;
    }

    @Override
    public String toString() {
        return "TEducateDegreeEntity{" +
                "userId=" + userId +
                ", educateDegreeName='" + educateDegreeName + '\'' +
                ", isMentor='" + isMentor + '\'' +
                ", educateDegreeLevel='" + educateDegreeLevel + '\'' +
                ", major='" + major + '\'' +
                ", tutorClass='" + tutorClass + '\'' +
                ", forClass='" + forClass + '\'' +
                ", mentorType='" + mentorType + '\'' +
                ", officeStatus='" + officeStatus + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", positionType='" + positionType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TEducateDegreeEntity that = (TEducateDegreeEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (educateDegreeName != null ? !educateDegreeName.equals(that.educateDegreeName) : that.educateDegreeName != null)
            return false;
        if (isMentor != null ? !isMentor.equals(that.isMentor) : that.isMentor != null) return false;
        if (educateDegreeLevel != null ? !educateDegreeLevel.equals(that.educateDegreeLevel) : that.educateDegreeLevel != null)
            return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (tutorClass != null ? !tutorClass.equals(that.tutorClass) : that.tutorClass != null) return false;
        if (forClass != null ? !forClass.equals(that.forClass) : that.forClass != null) return false;
        if (mentorType != null ? !mentorType.equals(that.mentorType) : that.mentorType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (educateDegreeName != null ? educateDegreeName.hashCode() : 0);
        result = 31 * result + (isMentor != null ? isMentor.hashCode() : 0);
        result = 31 * result + (educateDegreeLevel != null ? educateDegreeLevel.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (tutorClass != null ? tutorClass.hashCode() : 0);
        result = 31 * result + (forClass != null ? forClass.hashCode() : 0);
        result = 31 * result + (mentorType != null ? mentorType.hashCode() : 0);
        return result;
    }
}
