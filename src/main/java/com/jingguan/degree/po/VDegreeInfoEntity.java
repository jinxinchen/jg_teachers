package com.jingguan.degree.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/11/8.
 */
@Entity
@Table(name = "v_degree_info", schema = "jg_teachers", catalog = "")
public class VDegreeInfoEntity {
    private Integer id;
    private String socialFunction;
    private String research;
    private String for_class;
    private Integer academicSecretary;
    private String adminFunction;
    private String tutor_class;
    private Integer is_tutor;
    private String major;
    private String mentor_evidence_src;
    private String is_mentor;
    private String educate_time;
    private String educate_degree_src;
    private String educate_degree_time;
    private String educate_degree_name;
    private Integer status;

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
    @Column(name = "socialFunction")
    public String getSocialFunction() {
        return socialFunction;
    }

    public void setSocialFunction(String socialFunction) {
        this.socialFunction = socialFunction;
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
    @Column(name = "for_class")
    public String getfor_class() {
        return for_class;
    }

    public void setfor_class(String for_class) {
        this.for_class = for_class;
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
    @Column(name = "adminFunction")
    public String getAdminFunction() {
        return adminFunction;
    }

    public void setAdminFunction(String adminFunction) {
        this.adminFunction = adminFunction;
    }

    @Basic
    @Column(name = "tutor_class")
    public String gettutor_class() {
        return tutor_class;
    }

    public void settutor_class(String tutor_class) {
        this.tutor_class = tutor_class;
    }

    @Basic
    @Column(name = "is_tutor")
    public Integer getis_tutor() {
        return is_tutor;
    }

    public void setis_tutor(Integer is_tutor) {
        this.is_tutor = is_tutor;
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
    @Column(name = "mentor_evidence_src")
    public String getmentor_evidence_src() {
        return mentor_evidence_src;
    }

    public void setmentor_evidence_src(String mentor_evidence_src) {
        this.mentor_evidence_src = mentor_evidence_src;
    }

    @Basic
    @Column(name = "is_mentor")
    public String getis_mentor() {
        return is_mentor;
    }

    public void setis_mentor(String is_mentor) {
        this.is_mentor = is_mentor;
    }

    @Basic
    @Column(name = "educate_time")
    public String geteducate_time() {
        return educate_time;
    }

    public void seteducate_time(String educate_time) {
        this.educate_time = educate_time;
    }

    @Basic
    @Column(name = "educate_degree_src")
    public String geteducate_degree_src() {
        return educate_degree_src;
    }

    public void seteducate_degree_src(String educate_degree_src) {
        this.educate_degree_src = educate_degree_src;
    }

    @Basic
    @Column(name = "educate_degree_time")
    public String geteducate_degree_time() {
        return educate_degree_time;
    }

    public void seteducate_degree_time(String educate_degree_time) {
        this.educate_degree_time = educate_degree_time;
    }

    @Basic
    @Column(name = "educate_degree_name")
    public String geteducate_degree_name() {
        return educate_degree_name;
    }

    public void seteducate_degree_name(String educate_degree_name) {
        this.educate_degree_name = educate_degree_name;
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

        VDegreeInfoEntity that = (VDegreeInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (socialFunction != null ? !socialFunction.equals(that.socialFunction) : that.socialFunction != null)
            return false;
        if (research != null ? !research.equals(that.research) : that.research != null) return false;
        if (for_class != null ? !for_class.equals(that.for_class) : that.for_class != null) return false;
        if (academicSecretary != null ? !academicSecretary.equals(that.academicSecretary) : that.academicSecretary != null)
            return false;
        if (adminFunction != null ? !adminFunction.equals(that.adminFunction) : that.adminFunction != null)
            return false;
        if (tutor_class != null ? !tutor_class.equals(that.tutor_class) : that.tutor_class != null) return false;
        if (is_tutor != null ? !is_tutor.equals(that.is_tutor) : that.is_tutor != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (mentor_evidence_src != null ? !mentor_evidence_src.equals(that.mentor_evidence_src) : that.mentor_evidence_src != null)
            return false;
        if (is_mentor != null ? !is_mentor.equals(that.is_mentor) : that.is_mentor != null) return false;
        if (educate_time != null ? !educate_time.equals(that.educate_time) : that.educate_time != null) return false;
        if (educate_degree_src != null ? !educate_degree_src.equals(that.educate_degree_src) : that.educate_degree_src != null)
            return false;
        if (educate_degree_time != null ? !educate_degree_time.equals(that.educate_degree_time) : that.educate_degree_time != null)
            return false;
        if (educate_degree_name != null ? !educate_degree_name.equals(that.educate_degree_name) : that.educate_degree_name != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (socialFunction != null ? socialFunction.hashCode() : 0);
        result = 31 * result + (research != null ? research.hashCode() : 0);
        result = 31 * result + (for_class != null ? for_class.hashCode() : 0);
        result = 31 * result + (academicSecretary != null ? academicSecretary.hashCode() : 0);
        result = 31 * result + (adminFunction != null ? adminFunction.hashCode() : 0);
        result = 31 * result + (tutor_class != null ? tutor_class.hashCode() : 0);
        result = 31 * result + (is_tutor != null ? is_tutor.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (mentor_evidence_src != null ? mentor_evidence_src.hashCode() : 0);
        result = 31 * result + (is_mentor != null ? is_mentor.hashCode() : 0);
        result = 31 * result + (educate_time != null ? educate_time.hashCode() : 0);
        result = 31 * result + (educate_degree_src != null ? educate_degree_src.hashCode() : 0);
        result = 31 * result + (educate_degree_time != null ? educate_degree_time.hashCode() : 0);
        result = 31 * result + (educate_degree_name != null ? educate_degree_name.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
