package com.jingguan.student.po;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_postgraduate_jingsai", schema = "jg_teachers", catalog = "")
public class TPostgraduateJingsaiEntity {
    private Integer id;
    private String sno;
    private String name;
    private String grade;
    private String mentor;
    private String competitionName;
    private String worksName;
    private String unit;
    private String awardLevel;
    private String getTime;
    private String stuType;
    private String notice;
    private String fileName;
    private String fileSrc;

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
    @Column(name = "sno")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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
    @Column(name = "grade")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "mentor")
    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    @Basic
    @Column(name = "competitionName")
    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    @Basic
    @Column(name = "worksName")
    public String getWorksName() {
        return worksName;
    }

    public void setWorksName(String worksName) {
        this.worksName = worksName;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "awardLevel")
    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    @Basic
    @Column(name = "getTime")
    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }

    @Basic
    @Column(name = "stuType")
    public String getStuType() {
        return stuType;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
    }

    @Basic
    @Column(name = "notice")
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Basic
    @Column(name = "fileName")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "fileSrc")
    public String getFileSrc() {
        return fileSrc;
    }

    public void setFileSrc(String fileSrc) {
        this.fileSrc = fileSrc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TPostgraduateJingsaiEntity that = (TPostgraduateJingsaiEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sno, that.sno) &&
                Objects.equals(name, that.name) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(mentor, that.mentor) &&
                Objects.equals(competitionName, that.competitionName) &&
                Objects.equals(worksName, that.worksName) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(awardLevel, that.awardLevel) &&
                Objects.equals(getTime, that.getTime) &&
                Objects.equals(stuType, that.stuType) &&
                Objects.equals(notice, that.notice) &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(fileSrc, that.fileSrc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sno, name, grade, mentor, competitionName, worksName, unit, awardLevel, getTime, stuType, notice, fileName, fileSrc);
    }
}
