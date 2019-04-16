package com.jingguan.student.po;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_student", schema = "jg_teachers", catalog = "")
public class TStudentEntity {
    private Integer id;
    private String name;
    private String tel;
    private String grade;
    private String clazz;
    private String eduBack;
    private String sex;
    private String address;
    private String mail;
    private String position;
    private String sno;
    private String awardLevel;
    private String awardShape;
    private String awardType;
    private String awardName;
    private String awardingUnit;
    private String awardFileSrc;
    private String awardFileName;
    private String articleLevel;
    private String articleName;
    private String issn;
    private String issnFileSrc;
    private String issnFileName;
    private String getTime;
    private String activity;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
    @Column(name = "class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "eduBack")
    public String getEduBack() {
        return eduBack;
    }

    public void setEduBack(String eduBack) {
        this.eduBack = eduBack;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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
    @Column(name = "awardLevel")
    public String getAwardLevel() {
        return awardLevel;
    }

    public void setAwardLevel(String awardLevel) {
        this.awardLevel = awardLevel;
    }

    @Basic
    @Column(name = "awardShape")
    public String getAwardShape() {
        return awardShape;
    }

    public void setAwardShape(String awardShape) {
        this.awardShape = awardShape;
    }

    @Basic
    @Column(name = "awardType")
    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
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
    @Column(name = "awardingUnit")
    public String getAwardingUnit() {
        return awardingUnit;
    }

    public void setAwardingUnit(String awardingUnit) {
        this.awardingUnit = awardingUnit;
    }

    @Basic
    @Column(name = "awardFileSrc")
    public String getAwardFileSrc() {
        return awardFileSrc;
    }

    public void setAwardFileSrc(String awardFileSrc) {
        this.awardFileSrc = awardFileSrc;
    }

    @Basic
    @Column(name = "awardFileName")
    public String getAwardFileName() {
        return awardFileName;
    }

    public void setAwardFileName(String awardFileName) {
        this.awardFileName = awardFileName;
    }

    @Basic
    @Column(name = "articleLevel")
    public String getArticleLevel() {
        return articleLevel;
    }

    public void setArticleLevel(String articleLevel) {
        this.articleLevel = articleLevel;
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
    @Column(name = "ISSN")
    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    @Basic
    @Column(name = "ISSNFileSrc")
    public String getIssnFileSrc() {
        return issnFileSrc;
    }

    public void setIssnFileSrc(String issnFileSrc) {
        this.issnFileSrc = issnFileSrc;
    }

    @Basic
    @Column(name = "ISSNFileName")
    public String getIssnFileName() {
        return issnFileName;
    }

    public void setIssnFileName(String issnFileName) {
        this.issnFileName = issnFileName;
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
    @Column(name = "activity")
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
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
        TStudentEntity that = (TStudentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(clazz, that.clazz) &&
                Objects.equals(eduBack, that.eduBack) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(address, that.address) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(position, that.position) &&
                Objects.equals(sno, that.sno) &&
                Objects.equals(awardLevel, that.awardLevel) &&
                Objects.equals(awardShape, that.awardShape) &&
                Objects.equals(awardType, that.awardType) &&
                Objects.equals(awardName, that.awardName) &&
                Objects.equals(awardingUnit, that.awardingUnit) &&
                Objects.equals(awardFileSrc, that.awardFileSrc) &&
                Objects.equals(awardFileName, that.awardFileName) &&
                Objects.equals(articleLevel, that.articleLevel) &&
                Objects.equals(articleName, that.articleName) &&
                Objects.equals(issn, that.issn) &&
                Objects.equals(issnFileSrc, that.issnFileSrc) &&
                Objects.equals(issnFileName, that.issnFileName) &&
                Objects.equals(getTime, that.getTime) &&
                Objects.equals(activity, that.activity) &&
                Objects.equals(notice, that.notice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tel, grade, clazz, eduBack, sex, address, mail, position, sno, awardLevel, awardShape, awardType, awardName, awardingUnit, awardFileSrc, awardFileName, articleLevel, articleName, issn, issnFileSrc, issnFileName, getTime, activity, notice);
    }
}
