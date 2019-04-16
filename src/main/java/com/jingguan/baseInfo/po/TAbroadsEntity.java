package com.jingguan.baseInfo.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/10/17.
 */
@Entity
@Table(name = "t_abroads", schema = "jg_teachers", catalog = "")
public class TAbroadsEntity {
    private Integer id;
    private Integer userId;
    private String country;
    private String college;
    private String details;
    private String abroadEvidenceSrc;
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
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "college")
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Basic
    @Column(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Basic
    @Column(name = "abroad_evidence_src")
    public String getAbroadEvidenceSrc() {
        return abroadEvidenceSrc;
    }

    public void setAbroadEvidenceSrc(String abroadEvidenceSrc) {
        this.abroadEvidenceSrc = abroadEvidenceSrc;
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

        TAbroadsEntity that = (TAbroadsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (college != null ? !college.equals(that.college) : that.college != null) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        if (abroadEvidenceSrc != null ? !abroadEvidenceSrc.equals(that.abroadEvidenceSrc) : that.abroadEvidenceSrc != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (college != null ? college.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (abroadEvidenceSrc != null ? abroadEvidenceSrc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
