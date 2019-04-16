package com.jingguan.project.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2017/12/12 0012.
 */
@Entity
@Table(name = "t_project_user", schema = "jg_teachers", catalog = "")
public class TProjectUserEntity {
    private Integer projectId;
    private Integer userId;
    private Integer level;
    private String isPrincipal;
    private int id;

    @Basic
    @Column(name = "project_id")
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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
    @Column(name = "level")
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Basic
    @Column(name = "is_principal")
    public String getIsPrincipal() {
        return isPrincipal;
    }

    public void setIsPrincipal(String isPrincipal) {
        this.isPrincipal = isPrincipal;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TProjectUserEntity that = (TProjectUserEntity) o;

        if (id != that.id) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (isPrincipal != null ? !isPrincipal.equals(that.isPrincipal) : that.isPrincipal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectId != null ? projectId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (isPrincipal != null ? isPrincipal.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
