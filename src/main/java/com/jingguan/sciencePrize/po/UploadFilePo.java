package com.jingguan.sciencePrize.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2017/12/10 0010.
 */
@Entity
@Table(name = "t_educate_scientific", schema = "jg_teachers", catalog = "")
public class UploadFilePo {
    private int id;
    private String evidencePath;
    private String uploadTime;
    private String fileName;

    @Basic
    @Column(name="upload_time")
    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }


    @Basic
    @Column(name="file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
    @Column(name = "evidence_path")
    public String getEvidencePath() {
        return evidencePath;
    }

    public void setEvidencePath(String evidencePath) {
        this.evidencePath = evidencePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UploadFilePo that = (UploadFilePo) o;

        if (id != that.id) return false;
        if (evidencePath != null ? !evidencePath.equals(that.evidencePath) : that.evidencePath != null) return false;
        if (fileName != that.fileName) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (evidencePath != null ? evidencePath.hashCode() : 0);
        return result;
    }
}
