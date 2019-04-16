package com.jingguan.teacherActivity.po;

import javax.persistence.*;

/**
 * Created by zhouliang on 2017/12/10 0010.
 */
@Entity
@Table(name = "t_teacher_activity", schema = "jg_teachers", catalog = "")
public class CertificateUpload {

    private int id;
    private String certificate;
    private String certificateUploadTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "certificate")
    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Basic
    @Column(name = "certificate_upload_time")
    public String getCertificateUploadTime() {
        return certificateUploadTime;
    }

    public void setCertificateUploadTime(String certificateUploadTime) {
        this.certificateUploadTime = certificateUploadTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CertificateUpload that = (CertificateUpload) o;

        if (id != that.id) return false;
        if (certificate != null ? !certificate.equals(that.certificate) : that.certificate != null) return false;
        if (certificateUploadTime != null ? !certificateUploadTime.equals(that.certificateUploadTime) : that.certificateUploadTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (certificate != null ? certificate.hashCode() : 0);
        result = 31 * result + (certificateUploadTime != null ? certificateUploadTime.hashCode() : 0);
        return result;
    }
}
