package com.jingguan.manageTeachers.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/12/23.
 */
@Entity
@Table(name = "v_manageteachers_baseinfo", schema = "jg_teachers", catalog = "")
public class VManageteachersBaseinfoEntity {
    private Integer roleId;
    private String name;
    private String identityNum;
    private String gender;
    private Integer userId;
    private String birthday;
    private String phoneNum;
    private Integer id;
    private String educateDegreeName;
    private String degree;
    private String degreeType;
    private String educateDegreeLevel;
    private String isMentor;
    private String major;
    private String tutorClass;
    private String mentorType;
    private String forClass;

    private String positionType;
    private String reportTime;
    private String officeStatus;

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

    @Basic
    @Column(name = "office_status")
    public String getOfficeStatus() {
        return officeStatus;
    }

    public void setOfficeStatus(String officeStatus) {
        this.officeStatus = officeStatus;
    }

    @Basic
    @Column(name = "identityNum")
    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    @Basic
    @Column(name = "role_id")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "phoneNum")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    @Column(name = "degree")
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Basic
    @Column(name = "degree_type")
    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
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
    @Column(name = "is_mentor")
    public String getIsMentor() {
        return isMentor;
    }

    public void setIsMentor(String isMentor) {
        this.isMentor = isMentor;
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
    @Column(name = "mentor_type")
    public String getMentorType() {
        return mentorType;
    }

    public void setMentorType(String mentorType) {
        this.mentorType = mentorType;
    }

    @Basic
    @Column(name = "for_class")
    public String getForClass() {
        return forClass;
    }

    public void setForClass(String forClass) {
        this.forClass = forClass;
    }

    @Override
    public String toString() {
        return "VManageteachersBaseinfoEntity{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", identityNum='" + identityNum + '\'' +
                ", gender='" + gender + '\'' +
                ", userId=" + userId +
                ", birthday='" + birthday + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", id=" + id +
                ", educateDegreeName='" + educateDegreeName + '\'' +
                ", degree='" + degree + '\'' +
                ", degreeType='" + degreeType + '\'' +
                ", educateDegreeLevel='" + educateDegreeLevel + '\'' +
                ", isMentor='" + isMentor + '\'' +
                ", major='" + major + '\'' +
                ", tutorClass='" + tutorClass + '\'' +
                ", mentorType='" + mentorType + '\'' +
                ", forClass='" + forClass + '\'' +
                ", positionType='" + positionType + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", officeStatus='" + officeStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VManageteachersBaseinfoEntity that = (VManageteachersBaseinfoEntity) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (phoneNum != null ? !phoneNum.equals(that.phoneNum) : that.phoneNum != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (educateDegreeName != null ? !educateDegreeName.equals(that.educateDegreeName) : that.educateDegreeName != null)
            return false;
        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
        if (degreeType != null ? !degreeType.equals(that.degreeType) : that.degreeType != null) return false;
        if (educateDegreeLevel != null ? !educateDegreeLevel.equals(that.educateDegreeLevel) : that.educateDegreeLevel != null)
            return false;
        if (isMentor != null ? !isMentor.equals(that.isMentor) : that.isMentor != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (tutorClass != null ? !tutorClass.equals(that.tutorClass) : that.tutorClass != null) return false;
        if (mentorType != null ? !mentorType.equals(that.mentorType) : that.mentorType != null) return false;
        if (forClass != null ? !forClass.equals(that.forClass) : that.forClass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (educateDegreeName != null ? educateDegreeName.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (degreeType != null ? degreeType.hashCode() : 0);
        result = 31 * result + (educateDegreeLevel != null ? educateDegreeLevel.hashCode() : 0);
        result = 31 * result + (isMentor != null ? isMentor.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (tutorClass != null ? tutorClass.hashCode() : 0);
        result = 31 * result + (mentorType != null ? mentorType.hashCode() : 0);
        result = 31 * result + (forClass != null ? forClass.hashCode() : 0);
        return result;
    }
}
