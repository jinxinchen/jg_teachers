package com.jingguan.honorStatistics.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/10/23.
 */
@Entity
@Table(name = "t_honor_statistics", schema = "jg_teachers", catalog = "")
public class THonorStatisticsEntity {
    private Integer id;
    private String award_method;
    private String award_winner;
    private String atClass;
    private String award_level;
    private String award_type;
    private String award_name;
    private String the_unit;
    private String awardTime;
    private String note;
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
    @Column(name = "award_method")
    public String getaward_method() {
        return award_method;
    }

    public void setaward_method(String award_method) {
        this.award_method = award_method;
    }

    @Basic
    @Column(name = "award_winner")
    public String getAward_winner() {
        return award_winner;
    }

    public void setAward_winner(String award_winner) {
        this.award_winner = award_winner;
    }

    @Basic
    @Column(name = "atClass")
    public String getAtClass() {
        return atClass;
    }

    public void setAtClass(String atClass) {
        this.atClass = atClass;
    }

    @Basic
    @Column(name = "award_level")
    public String getAward_level() {
        return award_level;
    }

    public void setAward_level(String award_level) {
        this.award_level = award_level;
    }

    @Basic
    @Column(name = "award_type")
    public String getAward_type() {
        return award_type;
    }

    public void setAward_type(String award_type) {
        this.award_type = award_type;
    }

    @Basic
    @Column(name = "award_name")
    public String getAward_name() {
        return award_name;
    }

    public void setAward_name(String award_name) {
        this.award_name = award_name;
    }

    @Basic
    @Column(name = "the_unit")
    public String getThe_unit() {
        return the_unit;
    }

    public void setThe_unit(String the_unit) {
        this.the_unit = the_unit;
    }

    @Basic
    @Column(name = "awardTime")
    public String getawardTime() {
        return awardTime;
    }

    public void setawardTime(String awardTime) {
        this.awardTime = awardTime;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

        THonorStatisticsEntity that = (THonorStatisticsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (award_method != null ? !award_method.equals(that.award_method) : that.award_method != null) return false;
        if (award_winner != null ? !award_winner.equals(that.award_winner) : that.award_winner != null) return false;
        if (atClass != null ? !atClass.equals(that.atClass) : that.atClass != null) return false;
        if (award_level != null ? !award_level.equals(that.award_level) : that.award_level != null) return false;
        if (award_type != null ? !award_type.equals(that.award_type) : that.award_type != null) return false;
        if (award_name != null ? !award_name.equals(that.award_name) : that.award_name != null) return false;
        if (the_unit != null ? !the_unit.equals(that.the_unit) : that.the_unit != null) return false;
        if (awardTime != null ? !awardTime.equals(that.awardTime) : that.awardTime != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (award_method != null ? award_method.hashCode() : 0);
        result = 31 * result + (award_winner != null ? award_winner.hashCode() : 0);
        result = 31 * result + (atClass != null ? atClass.hashCode() : 0);
        result = 31 * result + (award_level != null ? award_level.hashCode() : 0);
        result = 31 * result + (award_type != null ? award_type.hashCode() : 0);
        result = 31 * result + (award_name != null ? award_name.hashCode() : 0);
        result = 31 * result + (the_unit != null ? the_unit.hashCode() : 0);
        result = 31 * result + (awardTime != null ? awardTime.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
