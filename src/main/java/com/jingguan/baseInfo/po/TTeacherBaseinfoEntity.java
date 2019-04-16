package com.jingguan.baseInfo.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 陈 on 2017/12/9.
 */
@Entity
@Table(name = "t_teacher_baseinfo", schema = "jg_teachers", catalog = "")
public class TTeacherBaseinfoEntity {
    private Integer id;
    private Integer userId;
    private String name;
    private String gender;
    private String birthday;
    private String email;
    private String identityNum;
    private String picture;
    private Timestamp createTime;
    private String address;
    private String phoneNum;
    private Integer isMoreLangue;
    private String major;
    private Integer isTutor;
    private String forClass;
    private String research;
    private Integer status;
    private String tutorClass;
    private String adminFunction;
    private Integer academicSecretary;
    private String socialFunction;
    private String degree;
    private String degreeType;
    private String identityPic;

    private String degreeConfirm;
    private String officeStatus;

    @Basic
    @Column(name = "degree_confirm")
    public String getDegreeConfirm() {
        return degreeConfirm;
    }

    public void setDegreeConfirm(String degreeConfirm) {
        this.degreeConfirm = degreeConfirm;
    }

    @Basic
    @Column(name="office_status")
    public String getOfficeStatus() {
        return officeStatus;
    }

    public void setOfficeStatus(String officeStatus) {
        this.officeStatus = officeStatus;
    }

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
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phoneNum")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Basic
    @Column(name = "is_more_langue")
    public Integer getIsMoreLangue() {
        return isMoreLangue;
    }

    public void setIsMoreLangue(Integer isMoreLangue) {
        this.isMoreLangue = isMoreLangue;
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
    @Column(name = "is_tutor")
    public Integer getIsTutor() {
        return isTutor;
    }

    public void setIsTutor(Integer isTutor) {
        this.isTutor = isTutor;
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
    @Column(name = "research")
    public String getResearch() {
        return research;
    }

    public void setResearch(String research) {
        this.research = research;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
    @Column(name = "adminFunction")
    public String getAdminFunction() {
        return adminFunction;
    }

    public void setAdminFunction(String adminFunction) {
        this.adminFunction = adminFunction;
    }

    @Basic
    @Column(name = "academicSecretary")
    public Integer getAcademicSecretary() {
        return academicSecretary;
    }

    public void setAcademicSecretary(Integer academicSecretary) {
        this.academicSecretary = academicSecretary;
    }

    @Basic
    @Column(name = "socialFunction")
    public String getSocialFunction() {
        return socialFunction;
    }

    public void setSocialFunction(String socialFunction) {
        this.socialFunction = socialFunction;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TTeacherBaseinfoEntity that = (TTeacherBaseinfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (identityNum != null ? !identityNum.equals(that.identityNum) : that.identityNum != null) return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phoneNum != null ? !phoneNum.equals(that.phoneNum) : that.phoneNum != null) return false;
        if (isMoreLangue != null ? !isMoreLangue.equals(that.isMoreLangue) : that.isMoreLangue != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (isTutor != null ? !isTutor.equals(that.isTutor) : that.isTutor != null) return false;
        if (forClass != null ? !forClass.equals(that.forClass) : that.forClass != null) return false;
        if (research != null ? !research.equals(that.research) : that.research != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (tutorClass != null ? !tutorClass.equals(that.tutorClass) : that.tutorClass != null) return false;
        if (adminFunction != null ? !adminFunction.equals(that.adminFunction) : that.adminFunction != null)
            return false;
        if (academicSecretary != null ? !academicSecretary.equals(that.academicSecretary) : that.academicSecretary != null)
            return false;
        if (socialFunction != null ? !socialFunction.equals(that.socialFunction) : that.socialFunction != null)
            return false;
        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
        if (degreeType != null ? !degreeType.equals(that.degreeType) : that.degreeType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (identityNum != null ? identityNum.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (isMoreLangue != null ? isMoreLangue.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (isTutor != null ? isTutor.hashCode() : 0);
        result = 31 * result + (forClass != null ? forClass.hashCode() : 0);
        result = 31 * result + (research != null ? research.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (tutorClass != null ? tutorClass.hashCode() : 0);
        result = 31 * result + (adminFunction != null ? adminFunction.hashCode() : 0);
        result = 31 * result + (academicSecretary != null ? academicSecretary.hashCode() : 0);
        result = 31 * result + (socialFunction != null ? socialFunction.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        result = 31 * result + (degreeType != null ? degreeType.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "identity_pic")
    public String getIdentityPic() {
        return identityPic;
    }

    public void setIdentityPic(String identityPic) {
        this.identityPic = identityPic;
    }

    @Override
    public String toString() {
        return "TTeacherBaseinfoEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", identityNum='" + identityNum + '\'' +
                ", picture='" + picture + '\'' +
                ", createTime=" + createTime +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", isMoreLangue=" + isMoreLangue +
                ", major='" + major + '\'' +
                ", isTutor=" + isTutor +
                ", forClass='" + forClass + '\'' +
                ", research='" + research + '\'' +
                ", status=" + status +
                ", tutorClass='" + tutorClass + '\'' +
                ", adminFunction='" + adminFunction + '\'' +
                ", academicSecretary=" + academicSecretary +
                ", socialFunction='" + socialFunction + '\'' +
                ", degree='" + degree + '\'' +
                ", degreeType='" + degreeType + '\'' +
                ", identityPic='" + identityPic + '\'' +
                ", degreeConfirm='" + degreeConfirm + '\'' +
                ", officeStatus='" + officeStatus + '\'' +
                '}';
    }
}
