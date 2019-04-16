package com.jingguan.admin.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/12/19.
 */
@Entity
@Table(name = "t_ability_project", schema = "jg_teachers", catalog = "")
public class TAbilityProjectEntity {
    private Integer id;
    private String prizeEvidenceSrc;
    private String status;
    private Integer userId;
    private String prizeLevel;
    private String unitOfPrizes;
    private String winner;
    private String winTime;
    private String funds;
    private String notice;
    private String prizeId;
    private String prizeName;
    private String fileName;
    private String uploadTime;

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
    @Column(name = "prize_evidence_src")
    public String getPrizeEvidenceSrc() {
        return prizeEvidenceSrc;
    }

    public void setPrizeEvidenceSrc(String prizeEvidenceSrc) {
        this.prizeEvidenceSrc = prizeEvidenceSrc;
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
    @Column(name = "prize_level")
    public String getPrizeLevel() {
        return prizeLevel;
    }

    public void setPrizeLevel(String prizeLevel) {
        this.prizeLevel = prizeLevel;
    }

    @Basic
    @Column(name = "unit_of_prizes")
    public String getUnitOfPrizes() {
        return unitOfPrizes;
    }

    public void setUnitOfPrizes(String unitOfPrizes) {
        this.unitOfPrizes = unitOfPrizes;
    }

    @Basic
    @Column(name = "winner")
    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Basic
    @Column(name = "win_time")
    public String getWinTime() {
        return winTime;
    }

    public void setWinTime(String winTime) {
        this.winTime = winTime;
    }

    @Basic
    @Column(name = "funds")
    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    @Basic
    @Column(name = "notice")
    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Basic
    @Column(name = "prize_id")
    public String getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(String prizeId) {
        this.prizeId = prizeId;
    }

    @Basic
    @Column(name = "prize_name")
    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
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

        TAbilityProjectEntity that = (TAbilityProjectEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (prizeEvidenceSrc != null ? !prizeEvidenceSrc.equals(that.prizeEvidenceSrc) : that.prizeEvidenceSrc != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (prizeLevel != null ? !prizeLevel.equals(that.prizeLevel) : that.prizeLevel != null) return false;
        if (unitOfPrizes != null ? !unitOfPrizes.equals(that.unitOfPrizes) : that.unitOfPrizes != null) return false;
        if (winner != null ? !winner.equals(that.winner) : that.winner != null) return false;
        if (winTime != null ? !winTime.equals(that.winTime) : that.winTime != null) return false;
        if (funds != null ? !funds.equals(that.funds) : that.funds != null) return false;
        if (notice != null ? !notice.equals(that.notice) : that.notice != null) return false;
        if (prizeId != null ? !prizeId.equals(that.prizeId) : that.prizeId != null) return false;
        if (prizeName != null ? !prizeName.equals(that.prizeName) : that.prizeName != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (uploadTime != null ? !uploadTime.equals(that.uploadTime) : that.uploadTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (prizeEvidenceSrc != null ? prizeEvidenceSrc.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (prizeLevel != null ? prizeLevel.hashCode() : 0);
        result = 31 * result + (unitOfPrizes != null ? unitOfPrizes.hashCode() : 0);
        result = 31 * result + (winner != null ? winner.hashCode() : 0);
        result = 31 * result + (winTime != null ? winTime.hashCode() : 0);
        result = 31 * result + (funds != null ? funds.hashCode() : 0);
        result = 31 * result + (notice != null ? notice.hashCode() : 0);
        result = 31 * result + (prizeId != null ? prizeId.hashCode() : 0);
        result = 31 * result + (prizeName != null ? prizeName.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        return result;
    }
}
