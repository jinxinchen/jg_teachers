package com.jingguan.student.po;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_stu_abroad", schema = "jg_teachers", catalog = "")
public class TStuAbroadEntity {
    private Integer id;
    private String college;
    private String sno;
    private String name;
    private String courseName;
    private String grade;
    private String abroad;
    private String country;
    private String abroadSch;
    private String abroadType;
    private String time;
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
    @Column(name = "college")
    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
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
    @Column(name = "courseName")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
    @Column(name = "abroad")
    public String getAbroad() {
        return abroad;
    }

    public void setAbroad(String abroad) {
        this.abroad = abroad;
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
    @Column(name = "abroadSch")
    public String getAbroadSch() {
        return abroadSch;
    }

    public void setAbroadSch(String abroadSch) {
        this.abroadSch = abroadSch;
    }

    @Basic
    @Column(name = "abroadType")
    public String getAbroadType() {
        return abroadType;
    }

    public void setAbroadType(String abroadType) {
        this.abroadType = abroadType;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
        TStuAbroadEntity that = (TStuAbroadEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(college, that.college) &&
                Objects.equals(sno, that.sno) &&
                Objects.equals(name, that.name) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(abroad, that.abroad) &&
                Objects.equals(country, that.country) &&
                Objects.equals(abroadSch, that.abroadSch) &&
                Objects.equals(abroadType, that.abroadType) &&
                Objects.equals(time, that.time) &&
                Objects.equals(stuType, that.stuType) &&
                Objects.equals(notice, that.notice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, college, sno, name, courseName, grade, abroad, country, abroadSch, abroadType, time, stuType, notice);
    }
}
