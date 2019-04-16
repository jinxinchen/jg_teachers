package com.jingguan.baseInfo.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/10/17.
 */
@Entity
@Table(name = "t_ability_project", schema = "jg_teachers", catalog = "")
public class TAbilityProjectEntity {
    private Integer id;
    private String prizeDetails;
    private String prizeEvidenceSrc;
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
    @Column(name = "prize_details")
    public String getPrizeDetails() {
        return prizeDetails;
    }

    public void setPrizeDetails(String prizeDetails) {
        this.prizeDetails = prizeDetails;
    }

    @Basic
    @Column(name = "prize_evidence_src")
    public String getPrizeEvidenceSrc() {
        return prizeEvidenceSrc;
    }

    public void setPrizeEvidenceSrc(String prizeEvidenceSrc) {
        this.prizeEvidenceSrc = prizeEvidenceSrc;
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

        TAbilityProjectEntity that = (TAbilityProjectEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (prizeDetails != null ? !prizeDetails.equals(that.prizeDetails) : that.prizeDetails != null) return false;
        if (prizeEvidenceSrc != null ? !prizeEvidenceSrc.equals(that.prizeEvidenceSrc) : that.prizeEvidenceSrc != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (prizeDetails != null ? prizeDetails.hashCode() : 0);
        result = 31 * result + (prizeEvidenceSrc != null ? prizeEvidenceSrc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
