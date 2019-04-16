package com.jingguan.degree.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/12/10.
 */
@Entity
@Table(name = "t_educate_degree", schema = "jg_teachers", catalog = "")
public class TEducateDegreeEntity {
    private Integer id;
    private Integer userId;
    private String educateDegreeName;
    private String educateDegreeTime;
    private String educateDegreeSrc;
    private String educateTime;
    private String isMentor;
    private String mentorEvidenceSrc;
    private Integer status;
    private String major;
    private Integer isTutor;
    private String tutorClass;
    private String adminFunction;
    private Integer academicSecretary;
    private String forClass;
    private String research;
    private String socialFunction;
    private String mentorType;
    private String fileName;
    private String uploadTime;
    private String mentorFileName;
    private String educateDegreeLevel;

    private String positionType;
    private String reportTime;
    private String degreeConfirm;
    private String officeStatus;

    @Basic
    @Column(name="position_type")
    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    @Basic
    @Column(name = "report_time")
    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "degree_confirm")
    public String getDegreeConfirm() {
        return degreeConfirm;
    }

    public void setDegreeConfirm(String degreeConfirm) {
        this.degreeConfirm = degreeConfirm;
    }

    @Basic
    @Column(name = "office_status")
    public String getOfficeStatus() {
        return officeStatus;
    }

    public void setOfficeStatus(String officeStatus) {
        this.officeStatus = officeStatus;
    }

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
    public String getEducateDegreeTime() {
        return educateDegreeTime;
    }

    public void setEducateDegreeTime(String educateDegreeTime) {
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
    public String getEducateTime() {
        return educateTime;
    }

    public void setEducateTime(String educateTime) {
        this.educateTime = educateTime;
    }

    @Basic
    @Column(name = "is_mentor")
    public String getIsMentor() {
        return isMentor;
    }

    public void setIsMentor(String isMentor) {
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

    @Basic
    @Column(name = "major")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Basic
    @Column(name = "is_tutor")
    public Integer getIsTutor() {
        return isTutor;
    }

    public void setIsTutor(Integer isTutor) {
        this.isTutor = isTutor;
    }

    @Basic
    @Column(name = "tutor_class")
    public String getTutorClass() {
        return tutorClass;
    }

    public void setTutorClass(String tutorClass) {
        this.tutorClass = tutorClass;
    }

    @Basic
    @Column(name = "adminFunction")
    public String getAdminFunction() {
        return adminFunction;
    }

    public void setAdminFunction(String adminFunction) {
        this.adminFunction = adminFunction;
    }

    @Basic
    @Column(name = "academicSecretary")
    public Integer getAcademicSecretary() {
        return academicSecretary;
    }

    public void setAcademicSecretary(Integer academicSecretary) {
        this.academicSecretary = academicSecretary;
    }

    @Basic
    @Column(name = "for_class")
    public String getForClass() {
        return forClass;
    }

    public void setForClass(String forClass) {
        this.forClass = forClass;
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
    @Column(name = "socialFunction")
    public String getSocialFunction() {
        return socialFunction;
    }

    public void setSocialFunction(String socialFunction) {
        this.socialFunction = socialFunction;
    }

    @Basic
    @Column(name = "mentor_type")
    public String getMentorType() {
        return mentorType;
    }

    public void setMentorType(String mentorType) {
        this.mentorType = mentorType;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "upload_time")
    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
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
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (isTutor != null ? !isTutor.equals(that.isTutor) : that.isTutor != null) return false;
        if (tutorClass != null ? !tutorClass.equals(that.tutorClass) : that.tutorClass != null) return false;
        if (adminFunction != null ? !adminFunction.equals(that.adminFunction) : that.adminFunction != null)
            return false;
        if (academicSecretary != null ? !academicSecretary.equals(that.academicSecretary) : that.academicSecretary != null)
            return false;
        if (forClass != null ? !forClass.equals(that.forClass) : that.forClass != null) return false;
        if (research != null ? !research.equals(that.research) : that.research != null) return false;
        if (socialFunction != null ? !socialFunction.equals(that.socialFunction) : that.socialFunction != null)
            return false;
        if (mentorType != null ? !mentorType.equals(that.mentorType) : that.mentorType != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (uploadTime != null ? !uploadTime.equals(that.uploadTime) : that.uploadTime != null) return false;

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
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (isTutor != null ? isTutor.hashCode() : 0);
        result = 31 * result + (tutorClass != null ? tutorClass.hashCode() : 0);
        result = 31 * result + (adminFunction != null ? adminFunction.hashCode() : 0);
        result = 31 * result + (academicSecretary != null ? academicSecretary.hashCode() : 0);
        result = 31 * result + (forClass != null ? forClass.hashCode() : 0);
        result = 31 * result + (research != null ? research.hashCode() : 0);
        result = 31 * result + (socialFunction != null ? socialFunction.hashCode() : 0);
        result = 31 * result + (mentorType != null ? mentorType.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "mentor_file_name")
    public String getMentorFileName() {
        return mentorFileName;
    }

    public void setMentorFileName(String mentorFileName) {
        this.mentorFileName = mentorFileName;
    }

    @Basic
    @Column(name = "educate_degree_level")
    public String getEducateDegreeLevel() {
        return educateDegreeLevel;
    }

    public void setEducateDegreeLevel(String educateDegreeLevel) {
        this.educateDegreeLevel = educateDegreeLevel;
    }

    @Override
    public String toString() {
        return "TEducateDegreeEntity{" +
                "id=" + id +
                ", userId=" + userId +
                ", educateDegreeName='" + educateDegreeName + '\'' +
                ", educateDegreeTime='" + educateDegreeTime + '\'' +
                ", educateDegreeSrc='" + educateDegreeSrc + '\'' +
                ", educateTime='" + educateTime + '\'' +
                ", isMentor='" + isMentor + '\'' +
                ", mentorEvidenceSrc='" + mentorEvidenceSrc + '\'' +
                ", status=" + status +
                ", major='" + major + '\'' +
                ", isTutor=" + isTutor +
                ", tutorClass='" + tutorClass + '\'' +
                ", adminFunction='" + adminFunction + '\'' +
                ", academicSecretary=" + academicSecretary +
                ", forClass='" + forClass + '\'' +
                ", research='" + research + '\'' +
                ", socialFunction='" + socialFunction + '\'' +
                ", mentorType='" + mentorType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", mentorFileName='" + mentorFileName + '\'' +
                ", educateDegreeLevel='" + educateDegreeLevel + '\'' +
                ", positionType='" + positionType + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", degreeConfirm='" + degreeConfirm + '\'' +
                ", officeStatus='" + officeStatus + '\'' +
                '}';
    }
}
