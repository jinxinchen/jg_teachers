package com.jingguan.teacherMaterials.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2018/2/5 0005.
 */
@Entity
@Table(name = "v_teacher_materials", schema = "jg_teachers", catalog = "")
public class TimeMan {
    private int id;
    private String fileTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "file_time")
    public String getFileTime() {
        return fileTime;
    }

    public void setFileTime(String fileTime) {
        this.fileTime = fileTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeMan timeMan = (TimeMan) o;

        if (id != timeMan.id) return false;
        if (fileTime != null ? !fileTime.equals(timeMan.fileTime) : timeMan.fileTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fileTime != null ? fileTime.hashCode() : 0);
        return result;
    }
}
