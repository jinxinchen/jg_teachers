package com.jingguan.baseInfo.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/10/17.
 */
@Entity
@Table(name = "t_graduate_school", schema = "jg_teachers", catalog = "")
public class TGraduateSchoolEntity {
    private Integer id;
    private Integer userId;
    private String schoolMajor;
    private String graduateCardSrc;
    private String degreeCardSrc;
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
    @Column(name = "school_major")
    public String getSchoolMajor() {
        return schoolMajor;
    }

    public void setSchoolMajor(String schoolMajor) {
        this.schoolMajor = schoolMajor;
    }

    @Basic
    @Column(name = "graduate_card_src")
    public String getGraduateCardSrc() {
        return graduateCardSrc;
    }

    public void setGraduateCardSrc(String graduateCardSrc) {
        this.graduateCardSrc = graduateCardSrc;
    }

    @Basic
    @Column(name = "degree_card_src")
    public String getDegreeCardSrc() {
        return degreeCardSrc;
    }

    public void setDegreeCardSrc(String degreeCardSrc) {
        this.degreeCardSrc = degreeCardSrc;
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

        TGraduateSchoolEntity that = (TGraduateSchoolEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (schoolMajor != null ? !schoolMajor.equals(that.schoolMajor) : that.schoolMajor != null) return false;
        if (graduateCardSrc != null ? !graduateCardSrc.equals(that.graduateCardSrc) : that.graduateCardSrc != null)
            return false;
        if (degreeCardSrc != null ? !degreeCardSrc.equals(that.degreeCardSrc) : that.degreeCardSrc != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (schoolMajor != null ? schoolMajor.hashCode() : 0);
        result = 31 * result + (graduateCardSrc != null ? graduateCardSrc.hashCode() : 0);
        result = 31 * result + (degreeCardSrc != null ? degreeCardSrc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
