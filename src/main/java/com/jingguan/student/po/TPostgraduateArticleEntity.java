package com.jingguan.student.po;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_postgraduate_article", schema = "jg_teachers", catalog = "")
public class TPostgraduateArticleEntity {
    private Integer id;
    private String college;
    private String articleName;
    private String postTime;
    private String postTo;
    private String authorList;
    private String workNo;
    private String firstName;
    private String name;
    private String sno;
    private String grade;
    private String courseName;
    private String mentor;
    private String stuType;
    private String issbnLevel;
    private String articelType;

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
    @Column(name = "articleName")
    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    @Basic
    @Column(name = "postTime")
    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    @Basic
    @Column(name = "postTo")
    public String getPostTo() {
        return postTo;
    }

    public void setPostTo(String postTo) {
        this.postTo = postTo;
    }

    @Basic
    @Column(name = "authorList")
    public String getAuthorList() {
        return authorList;
    }

    public void setAuthorList(String authorList) {
        this.authorList = authorList;
    }

    @Basic
    @Column(name = "workNo")
    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
    @Column(name = "stuType")
    public String getStuType() {
        return stuType;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
    }

    @Basic
    @Column(name = "issbnLevel")
    public String getIssbnLevel() {
        return issbnLevel;
    }

    public void setIssbnLevel(String issbnLevel) {
        this.issbnLevel = issbnLevel;
    }

    @Basic
    @Column(name = "articelType")
    public String getArticelType() {
        return articelType;
    }

    public void setArticelType(String articelType) {
        this.articelType = articelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TPostgraduateArticleEntity that = (TPostgraduateArticleEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(college, that.college) &&
                Objects.equals(articleName, that.articleName) &&
                Objects.equals(postTime, that.postTime) &&
                Objects.equals(postTo, that.postTo) &&
                Objects.equals(authorList, that.authorList) &&
                Objects.equals(workNo, that.workNo) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sno, that.sno) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(mentor, that.mentor) &&
                Objects.equals(stuType, that.stuType) &&
                Objects.equals(issbnLevel, that.issbnLevel) &&
                Objects.equals(articelType, that.articelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, college, articleName, postTime, postTo, authorList, workNo, firstName, name, sno, grade, courseName, mentor, stuType, issbnLevel, articelType);
    }
}
