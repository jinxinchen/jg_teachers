package com.jingguan.student.po;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_postgraduate_keyan", schema = "jg_teachers", catalog = "")
public class TPostgraduateKeyanEntity {
    private Integer id;
    private String sno;
    private String name;
    private String grade;
    private String courseName;
    private String mentor;
    private String awardName;
    private String awardLevel;
    private String awardingUnit;
    private String getTime;
    private String awardRank;
    private String ranking;
    private String stuType;
    private String notice;

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
    @Column(name = "courseName")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
    @Column(name = "awardName")
    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
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
    @Column(name = "awardingUnit")
    public String getAwardingUnit() {
        return awardingUnit;
    }

    public void setAwardingUnit(String awardingUnit) {
        this.awardingUnit = awardingUnit;
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
    @Column(name = "awardRank")
    public String getAwardRank() {
        return awardRank;
    }

    public void setAwardRank(String awardRank) {
        this.awardRank = awardRank;
    }

    @Basic
    @Column(name = "ranking")
    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TPostgraduateKeyanEntity that = (TPostgraduateKeyanEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sno, that.sno) &&
                Objects.equals(name, that.name) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(mentor, that.mentor) &&
                Objects.equals(awardName, that.awardName) &&
                Objects.equals(awardLevel, that.awardLevel) &&
                Objects.equals(awardingUnit, that.awardingUnit) &&
                Objects.equals(getTime, that.getTime) &&
                Objects.equals(awardRank, that.awardRank) &&
                Objects.equals(ranking, that.ranking) &&
                Objects.equals(stuType, that.stuType) &&
                Objects.equals(notice, that.notice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sno, name, grade, courseName, mentor, awardName, awardLevel, awardingUnit, getTime, awardRank, ranking, stuType, notice);
    }
}
