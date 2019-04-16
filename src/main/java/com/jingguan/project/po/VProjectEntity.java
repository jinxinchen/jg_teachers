package com.jingguan.project.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
@Entity
@Table(name = "t_scientific", schema = "jg_teachers", catalog = "")
public class VProjectEntity {
    private int id;
    private String scientificName;
    private String scientificSource;
    private String type;
    private String isMarch;
    private String createTime;
    private String endTime;
    private String grants;
    private String createScientificEvidenceSrc;
    private String createUpdateTime;
    private String endScientificEvidenceSrc;
    private String endUpdateTime;
    private String others;
    private String status;
    private Integer userId;
    private String memberList;
    private String level;
    private String projectId;
    private String headName;

    @Basic
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "is_march")
    public String getIsMarch() {
        return isMarch;
    }

    public void setIsMarch(String isMarch) {
        this.isMarch = isMarch;
    }

    @Basic
    @Column(name = "create_time")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "end_time")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "grants")
    public String getGrants() {
        return grants;
    }

    public void setGrants(String grants) {
        this.grants = grants;
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
    @Column(name = "create_update_time")
    public String getCreateUpdateTime() {
        return createUpdateTime;
    }

    public void setCreateUpdateTime(String createUpdateTime) {
        this.createUpdateTime = createUpdateTime;
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
    @Column(name = "end_update_time")
    public String getEndUpdateTime() {
        return endUpdateTime;
    }

    public void setEndUpdateTime(String endUpdateTime) {
        this.endUpdateTime = endUpdateTime;
    }

    @Basic
    @Column(name = "others")
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "member_list")
    public String getMemberList() {
        return memberList;
    }

    public void setMemberList(String memberList) {
        this.memberList = memberList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VProjectEntity that = (VProjectEntity) o;

        if (id != that.id) return false;
        if (scientificName != null ? !scientificName.equals(that.scientificName) : that.scientificName != null)
            return false;
        if (scientificSource != null ? !scientificSource.equals(that.scientificSource) : that.scientificSource != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (isMarch != null ? !isMarch.equals(that.isMarch) : that.isMarch != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (grants != null ? !grants.equals(that.grants) : that.grants != null) return false;
        if (createScientificEvidenceSrc != null ? !createScientificEvidenceSrc.equals(that.createScientificEvidenceSrc) : that.createScientificEvidenceSrc != null)
            return false;
        if (createUpdateTime != null ? !createUpdateTime.equals(that.createUpdateTime) : that.createUpdateTime != null)
            return false;
        if (endScientificEvidenceSrc != null ? !endScientificEvidenceSrc.equals(that.endScientificEvidenceSrc) : that.endScientificEvidenceSrc != null)
            return false;
        if (endUpdateTime != null ? !endUpdateTime.equals(that.endUpdateTime) : that.endUpdateTime != null)
            return false;
        if (others != null ? !others.equals(that.others) : that.others != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (memberList != null ? !memberList.equals(that.memberList) : that.memberList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (scientificName != null ? scientificName.hashCode() : 0);
        result = 31 * result + (scientificSource != null ? scientificSource.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (isMarch != null ? isMarch.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (grants != null ? grants.hashCode() : 0);
        result = 31 * result + (createScientificEvidenceSrc != null ? createScientificEvidenceSrc.hashCode() : 0);
        result = 31 * result + (createUpdateTime != null ? createUpdateTime.hashCode() : 0);
        result = 31 * result + (endScientificEvidenceSrc != null ? endScientificEvidenceSrc.hashCode() : 0);
        result = 31 * result + (endUpdateTime != null ? endUpdateTime.hashCode() : 0);
        result = 31 * result + (others != null ? others.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (memberList != null ? memberList.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "project_id")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "head_name")
    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }
}
