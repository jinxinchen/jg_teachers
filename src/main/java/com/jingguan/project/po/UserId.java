package com.jingguan.project.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2017/12/18 0018.
 */
@Entity
@Table(name = "t_teacher_baseinfo", schema = "jg_teachers", catalog = "")
public class UserId {
    private int id;
    private String name;
    private Integer user_id;

    @Basic
    @Column(name = "user_id")
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserId userId = (UserId) o;

        if (id != userId.id) return false;
        if (name != null ? !name.equals(userId.name) : userId.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
