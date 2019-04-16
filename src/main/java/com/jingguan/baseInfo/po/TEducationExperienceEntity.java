package com.jingguan.baseInfo.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/12/10.
 */
@Entity
@Table(name = "t_education_experience", schema = "jg_teachers", catalog = "")
public class TEducationExperienceEntity {
    private Integer id;
    private String school;
    private String major;
    private String education;
    private String graduationYear;
    private Integer userId;
    private Integer status;
    private String graduateCard;
    private String degreeCard;
    private String entrance;
    private String abroad;

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
    @Column(name = "school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "abroad")
    public String getAbroad() {
        return abroad;
    }

    public void setAbroad(String abroad) {
        this.abroad = abroad;
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
    @Column(name = "education")
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Basic
    @Column(name = "graduationYear")
    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
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
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "graduate_card")
    public String getGraduateCard() {
        return graduateCard;
    }

    public void setGraduateCard(String graduateCard) {
        this.graduateCard = graduateCard;
    }

    @Basic
    @Column(name = "degree_card",updatable = false)
    public String getDegreeCard() {
        return degreeCard;
    }

    public void setDegreeCard(String degreeCard) {
        this.degreeCard = degreeCard;
    }

    @Basic
    @Column(name = "entrance")
    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TEducationExperienceEntity that = (TEducationExperienceEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (school != null ? !school.equals(that.school) : that.school != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (graduationYear != null ? !graduationYear.equals(that.graduationYear) : that.graduationYear != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (graduateCard != null ? !graduateCard.equals(that.graduateCard) : that.graduateCard != null) return false;
        if (degreeCard != null ? !degreeCard.equals(that.degreeCard) : that.degreeCard != null) return false;
        if (entrance != null ? !entrance.equals(that.entrance) : that.entrance != null) return false;
        if (abroad != null ? !abroad.equals(that.abroad) : that.abroad != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (graduationYear != null ? graduationYear.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (graduateCard != null ? graduateCard.hashCode() : 0);
        result = 31 * result + (degreeCard != null ? degreeCard.hashCode() : 0);
        result = 31 * result + (entrance != null ? entrance.hashCode() : 0);
        result = 31 * result + (abroad != null ? abroad.hashCode() : 0);
        return result;
    }
}
