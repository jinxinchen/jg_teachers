package com.jingguan.student.po;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_stu_info", schema = "jg_teachers", catalog = "")
public class TStuInfoEntity {
    private Integer id;
    private String sno;
    private String grade;
    private String name;
    private String gender;
    private String stuType;
    private String birthday;
    private String courseName;
    private String research;
    private String mentor;
    private String identity;
    private String phoneNum;
    private String educateLevel;

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
    @Column(name = "grade")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
    @Column(name = "stuType")
    public String getStuType() {
        return stuType;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
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
    @Column(name = "courseName")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
    @Column(name = "mentor")
    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    @Basic
    @Column(name = "identity")
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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
    @Column(name = "educateLevel")
    public String getEducateLevel() {
        return educateLevel;
    }

    public void setEducateLevel(String educateLevel) {
        this.educateLevel = educateLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TStuInfoEntity that = (TStuInfoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sno, that.sno) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(name, that.name) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(stuType, that.stuType) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(research, that.research) &&
                Objects.equals(mentor, that.mentor) &&
                Objects.equals(identity, that.identity) &&
                Objects.equals(phoneNum, that.phoneNum) &&
                Objects.equals(educateLevel, that.educateLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sno, grade, name, gender, stuType, birthday, courseName, research, mentor, identity, phoneNum, educateLevel);
    }
}
