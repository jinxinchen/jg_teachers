package com.jingguan.baseInfo.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 陈 on 2017/10/17.
 */
@Entity
@Table(name = "t_educate_degree", schema = "jg_teachers", catalog = "")
public class TEducateDegreeEntity {
    private Integer id;
    private Integer userId;
    private String educateDegreeName;
    private Timestamp educateDegreeTime;
    private String educateDegreeSrc;
    private Timestamp educateTime;
    private Integer isMentor;
    private String mentorEvidenceSrc;
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
    @Column(name = "educate_degree_name")
    public String getEducateDegreeName() {
        return educateDegreeName;
    }

    public void setEducateDegreeName(String educateDegreeName) {
        this.educateDegreeName = educateDegreeName;
    }

    @Basic
    @Column(name = "educate_degree_time")
    public Timestamp getEducateDegreeTime() {
        return educateDegreeTime;
    }

    public void setEducateDegreeTime(Timestamp educateDegreeTime) {
        this.educateDegreeTime = educateDegreeTime;
    }

    @Basic
    @Column(name = "educate_degree_src")
    public String getEducateDegreeSrc() {
        return educateDegreeSrc;
    }

    public void setEducateDegreeSrc(String educateDegreeSrc) {
        this.educateDegreeSrc = educateDegreeSrc;
    }

    @Basic
    @Column(name = "educate_time")
    public Timestamp getEducateTime() {
        return educateTime;
    }

    public void setEducateTime(Timestamp educateTime) {
        this.educateTime = educateTime;
    }

    @Basic
    @Column(name = "is_mentor")
    public Integer getIsMentor() {
        return isMentor;
    }

    public void setIsMentor(Integer isMentor) {
        this.isMentor = isMentor;
    }

    @Basic
    @Column(name = "mentor_evidence_src")
    public String getMentorEvidenceSrc() {
        return mentorEvidenceSrc;
    }

    public void setMentorEvidenceSrc(String mentorEvidenceSrc) {
        this.mentorEvidenceSrc = mentorEvidenceSrc;
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

        TEducateDegreeEntity that = (TEducateDegreeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (educateDegreeName != null ? !educateDegreeName.equals(that.educateDegreeName) : that.educateDegreeName != null)
            return false;
        if (educateDegreeTime != null ? !educateDegreeTime.equals(that.educateDegreeTime) : that.educateDegreeTime != null)
            return false;
        if (educateDegreeSrc != null ? !educateDegreeSrc.equals(that.educateDegreeSrc) : that.educateDegreeSrc != null)
            return false;
        if (educateTime != null ? !educateTime.equals(that.educateTime) : that.educateTime != null) return false;
        if (isMentor != null ? !isMentor.equals(that.isMentor) : that.isMentor != null) return false;
        if (mentorEvidenceSrc != null ? !mentorEvidenceSrc.equals(that.mentorEvidenceSrc) : that.mentorEvidenceSrc != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (educateDegreeName != null ? educateDegreeName.hashCode() : 0);
        result = 31 * result + (educateDegreeTime != null ? educateDegreeTime.hashCode() : 0);
        result = 31 * result + (educateDegreeSrc != null ? educateDegreeSrc.hashCode() : 0);
        result = 31 * result + (educateTime != null ? educateTime.hashCode() : 0);
        result = 31 * result + (isMentor != null ? isMentor.hashCode() : 0);
        result = 31 * result + (mentorEvidenceSrc != null ? mentorEvidenceSrc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
