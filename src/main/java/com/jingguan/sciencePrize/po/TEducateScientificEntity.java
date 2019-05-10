package com.jingguan.sciencePrize.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2017/11/18 0018.
 */
@Entity
@Table(name = "t_educate_scientific", schema = "jg_teachers", catalog = "")
public class TEducateScientificEntity {
    private int id;
    private Integer userId;
    private String educateScientificName;
    private String prizeName;
    private String prizeTime;
    private String theUnit;
    private String schoolName;
    private String membersList;
    private String type;
    private String status;
    private String author;
    private String others;
    private String evidencePath;
    private String certifyNumber;
    private String uploadTime;
    private String fileName;

    @Basic
    @Column(name="upload_time",updatable = false)
    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Basic
    @Column(name = "certify_number")
    public String getCertifyNumber() {
        return certifyNumber;
    }

    public void setCertifyNumber(String certifyNumber) {
        this.certifyNumber = certifyNumber;
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
    @Column(name = "prize_time")
    public String getPrizeTime() {
        return prizeTime;
    }

    public void setPrizeTime(String prizeTime) {
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
    @Column(name = "status",updatable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
    @Column(name = "evidence_path",updatable = false)
    public String getEvidencePath() {
        return evidencePath;
    }

    public void setEvidencePath(String evidencePath) {
        this.evidencePath = evidencePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TEducateScientificEntity that = (TEducateScientificEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (educateScientificName != null ? !educateScientificName.equals(that.educateScientificName) : that.educateScientificName != null)
            return false;
        if (prizeName != null ? !prizeName.equals(that.prizeName) : that.prizeName != null) return false;
        if (prizeTime != null ? !prizeTime.equals(that.prizeTime) : that.prizeTime != null) return false;
        if (theUnit != null ? !theUnit.equals(that.theUnit) : that.theUnit != null) return false;
        if (schoolName != null ? !schoolName.equals(that.schoolName) : that.schoolName != null) return false;
        if (membersList != null ? !membersList.equals(that.membersList) : that.membersList != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (others != null ? !others.equals(that.others) : that.others != null) return false;
        if (evidencePath != null ? !evidencePath.equals(that.evidencePath) : that.evidencePath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (educateScientificName != null ? educateScientificName.hashCode() : 0);
        result = 31 * result + (prizeName != null ? prizeName.hashCode() : 0);
        result = 31 * result + (prizeTime != null ? prizeTime.hashCode() : 0);
        result = 31 * result + (theUnit != null ? theUnit.hashCode() : 0);
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        result = 31 * result + (membersList != null ? membersList.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (others != null ? others.hashCode() : 0);
        result = 31 * result + (evidencePath != null ? evidencePath.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
