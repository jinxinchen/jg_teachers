package com.jingguan.baseInfo.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 陈 on 2017/10/17.
 */
@Entity
@Table(name = "t_scientific", schema = "jg_teachers", catalog = "")
public class TScientificEntity {
    private Integer id;
    private Integer userId;
    private Integer scientificId;
    private String scientificName;
    private String scientificSource;
    private Integer level;
    private Timestamp createTime;
    private Timestamp endTime;
    private Integer grants;
    private Integer isComplete;
    private String createScientificEvidenceSrc;
    private String endScientificEvidenceSrc;
    private String scientificPrizeSrc;
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
    @Column(name = "scientific_id")
    public Integer getScientificId() {
        return scientificId;
    }

    public void setScientificId(Integer scientificId) {
        this.scientificId = scientificId;
    }

    @Basic
    @Column(name = "scientific_name")
    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    @Basic
    @Column(name = "scientific_source")
    public String getScientificSource() {
        return scientificSource;
    }

    public void setScientificSource(String scientificSource) {
        this.scientificSource = scientificSource;
    }

    @Basic
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "grants")
    public Integer getGrants() {
        return grants;
    }

    public void setGrants(Integer grants) {
        this.grants = grants;
    }

    @Basic
    @Column(name = "is_complete")
    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

    @Basic
    @Column(name = "create_scientific_evidence_src")
    public String getCreateScientificEvidenceSrc() {
        return createScientificEvidenceSrc;
    }

    public void setCreateScientificEvidenceSrc(String createScientificEvidenceSrc) {
        this.createScientificEvidenceSrc = createScientificEvidenceSrc;
    }

    @Basic
    @Column(name = "end_scientific_evidence_src")
    public String getEndScientificEvidenceSrc() {
        return endScientificEvidenceSrc;
    }

    public void setEndScientificEvidenceSrc(String endScientificEvidenceSrc) {
        this.endScientificEvidenceSrc = endScientificEvidenceSrc;
    }

    @Basic
    @Column(name = "scientific_prize_src")
    public String getScientificPrizeSrc() {
        return scientificPrizeSrc;
    }

    public void setScientificPrizeSrc(String scientificPrizeSrc) {
        this.scientificPrizeSrc = scientificPrizeSrc;
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

        TScientificEntity that = (TScientificEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (scientificId != null ? !scientificId.equals(that.scientificId) : that.scientificId != null) return false;
        if (scientificName != null ? !scientificName.equals(that.scientificName) : that.scientificName != null)
            return false;
        if (scientificSource != null ? !scientificSource.equals(that.scientificSource) : that.scientificSource != null)
            return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (grants != null ? !grants.equals(that.grants) : that.grants != null) return false;
        if (isComplete != null ? !isComplete.equals(that.isComplete) : that.isComplete != null) return false;
        if (createScientificEvidenceSrc != null ? !createScientificEvidenceSrc.equals(that.createScientificEvidenceSrc) : that.createScientificEvidenceSrc != null)
            return false;
        if (endScientificEvidenceSrc != null ? !endScientificEvidenceSrc.equals(that.endScientificEvidenceSrc) : that.endScientificEvidenceSrc != null)
            return false;
        if (scientificPrizeSrc != null ? !scientificPrizeSrc.equals(that.scientificPrizeSrc) : that.scientificPrizeSrc != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (scientificId != null ? scientificId.hashCode() : 0);
        result = 31 * result + (scientificName != null ? scientificName.hashCode() : 0);
        result = 31 * result + (scientificSource != null ? scientificSource.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (grants != null ? grants.hashCode() : 0);
        result = 31 * result + (isComplete != null ? isComplete.hashCode() : 0);
        result = 31 * result + (createScientificEvidenceSrc != null ? createScientificEvidenceSrc.hashCode() : 0);
        result = 31 * result + (endScientificEvidenceSrc != null ? endScientificEvidenceSrc.hashCode() : 0);
        result = 31 * result + (scientificPrizeSrc != null ? scientificPrizeSrc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
