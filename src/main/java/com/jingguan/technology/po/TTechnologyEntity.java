package com.jingguan.technology.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/10/27.
 */
@Entity
@Table(name = "t_technology", schema = "jg_teachers", catalog = "")
public class TTechnologyEntity {
    private Integer id;
    private String techId;
    private String time;
    private String level;
    private String type;
    private String name;
    private Double funds;
    private String leadPeople;
    private String office;
    private String status;

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
    @Column(name = "techId")
    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "funds")
    public Double getFunds() {
        return funds;
    }

    public void setFunds(Double funds) {
        this.funds = funds;
    }

    @Basic
    @Column(name = "leadPeople")
    public String getLeadPeople() {
        return leadPeople;
    }

    public void setLeadPeople(String leadPeople) {
        this.leadPeople = leadPeople;
    }

    @Basic
    @Column(name = "office")
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TTechnologyEntity that = (TTechnologyEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (techId != null ? !techId.equals(that.techId) : that.techId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (funds != null ? !funds.equals(that.funds) : that.funds != null) return false;
        if (leadPeople != null ? !leadPeople.equals(that.leadPeople) : that.leadPeople != null) return false;
        if (office != null ? !office.equals(that.office) : that.office != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (techId != null ? techId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (funds != null ? funds.hashCode() : 0);
        result = 31 * result + (leadPeople != null ? leadPeople.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
