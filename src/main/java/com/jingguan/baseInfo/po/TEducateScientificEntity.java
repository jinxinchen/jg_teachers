package com.jingguan.baseInfo.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 陈 on 2017/10/17.
 */
@Entity
@Table(name = "t_educate_scientific", schema = "jg_teachers", catalog = "")
public class TEducateScientificEntity {
    private Integer id;
    private Integer userId;
    private String educateScientificName;
    private String prizeName;
    private String prizeLevel;
    private Timestamp prizeTime;
    private String theUnit;
    private String schoolName;
    private String userName;
    private String membersList;
    private String type;
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
    @Column(name = "educate_scientific_name")
    public String getEducateScientificName() {
        return educateScientificName;
    }

    public void setEducateScientificName(String educateScientificName) {
        this.educateScientificName = educateScientificName;
    }

    @Basic
    @Column(name = "prize_name")
    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    @Basic
    @Column(name = "prize_level")
    public String getPrizeLevel() {
        return prizeLevel;
    }

    public void setPrizeLevel(String prizeLevel) {
        this.prizeLevel = prizeLevel;
    }

    @Basic
    @Column(name = "prize_time")
    public Timestamp getPrizeTime() {
        return prizeTime;
    }

    public void setPrizeTime(Timestamp prizeTime) {
        this.prizeTime = prizeTime;
    }

    @Basic
    @Column(name = "the_unit")
    public String getTheUnit() {
        return theUnit;
    }

    public void setTheUnit(String theUnit) {
        this.theUnit = theUnit;
    }

    @Basic
    @Column(name = "school_name")
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "members_list")
    public String getMembersList() {
        return membersList;
    }

    public void setMembersList(String membersList) {
        this.membersList = membersList;
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

        TEducateScientificEntity that = (TEducateScientificEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (educateScientificName != null ? !educateScientificName.equals(that.educateScientificName) : that.educateScientificName != null)
            return false;
        if (prizeName != null ? !prizeName.equals(that.prizeName) : that.prizeName != null) return false;
        if (prizeLevel != null ? !prizeLevel.equals(that.prizeLevel) : that.prizeLevel != null) return false;
        if (prizeTime != null ? !prizeTime.equals(that.prizeTime) : that.prizeTime != null) return false;
        if (theUnit != null ? !theUnit.equals(that.theUnit) : that.theUnit != null) return false;
        if (schoolName != null ? !schoolName.equals(that.schoolName) : that.schoolName != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (membersList != null ? !membersList.equals(that.membersList) : that.membersList != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (educateScientificName != null ? educateScientificName.hashCode() : 0);
        result = 31 * result + (prizeName != null ? prizeName.hashCode() : 0);
        result = 31 * result + (prizeLevel != null ? prizeLevel.hashCode() : 0);
        result = 31 * result + (prizeTime != null ? prizeTime.hashCode() : 0);
        result = 31 * result + (theUnit != null ? theUnit.hashCode() : 0);
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (membersList != null ? membersList.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
