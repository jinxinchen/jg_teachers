package com.jingguan.baseInfo.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 陈 on 2017/10/17.
 */
@Entity
@Table(name = "t_more_language", schema = "jg_teachers", catalog = "")
public class TMoreLanguageEntity {
    private Integer id;
    private Integer userId;
    private String languages;
    private Timestamp getTime;
    private String languageEvidenceSrc;
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
    @Column(name = "languages")
    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @Basic
    @Column(name = "get_time")
    public Timestamp getGetTime() {
        return getTime;
    }

    public void setGetTime(Timestamp getTime) {
        this.getTime = getTime;
    }

    @Basic
    @Column(name = "language_evidence_src")
    public String getLanguageEvidenceSrc() {
        return languageEvidenceSrc;
    }

    public void setLanguageEvidenceSrc(String languageEvidenceSrc) {
        this.languageEvidenceSrc = languageEvidenceSrc;
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

        TMoreLanguageEntity that = (TMoreLanguageEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (languages != null ? !languages.equals(that.languages) : that.languages != null) return false;
        if (getTime != null ? !getTime.equals(that.getTime) : that.getTime != null) return false;
        if (languageEvidenceSrc != null ? !languageEvidenceSrc.equals(that.languageEvidenceSrc) : that.languageEvidenceSrc != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (languages != null ? languages.hashCode() : 0);
        result = 31 * result + (getTime != null ? getTime.hashCode() : 0);
        result = 31 * result + (languageEvidenceSrc != null ? languageEvidenceSrc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
