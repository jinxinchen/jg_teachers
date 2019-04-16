package com.jingguan.project.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2017/12/13 0013.
 */
@Entity
@Table(name = "t_scientific", schema = "jg_teachers", catalog = "")
public class SrcFileMan {
    private int id;
    private String createScientificEvidenceSrc;
    private String endScientificEvidenceSrc;
    private String createUpdateTime;
    private String endUpdateTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "create_update_time")
    public String getCreateUpdateTime() {
        return createUpdateTime;
    }

    public void setCreateUpdateTime(String createUpdateTime) {
        this.createUpdateTime = createUpdateTime;
    }

    @Basic
    @Column(name = "end_update_time")
    public String getEndUpdateTime() {
        return endUpdateTime;
    }

    public void setEndUpdateTime(String endUpdateTime) {
        this.endUpdateTime = endUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SrcFileMan that = (SrcFileMan) o;

        if (id != that.id) return false;
        if (createScientificEvidenceSrc != null ? !createScientificEvidenceSrc.equals(that.createScientificEvidenceSrc) : that.createScientificEvidenceSrc != null)
            return false;
        if (endScientificEvidenceSrc != null ? !endScientificEvidenceSrc.equals(that.endScientificEvidenceSrc) : that.endScientificEvidenceSrc != null)
            return false;
        if (createUpdateTime != null ? !createUpdateTime.equals(that.createUpdateTime) : that.createUpdateTime != null)
            return false;
        if (endUpdateTime != null ? !endUpdateTime.equals(that.endUpdateTime) : that.endUpdateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createScientificEvidenceSrc != null ? createScientificEvidenceSrc.hashCode() : 0);
        result = 31 * result + (endScientificEvidenceSrc != null ? endScientificEvidenceSrc.hashCode() : 0);
        result = 31 * result + (createUpdateTime != null ? createUpdateTime.hashCode() : 0);
        result = 31 * result + (endUpdateTime != null ? endUpdateTime.hashCode() : 0);
        return result;
    }
}
