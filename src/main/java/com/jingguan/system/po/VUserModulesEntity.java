package com.jingguan.system.po;

import javax.persistence.*;

/**
 * Created by 陈 on 2017/10/14.
 */
@Entity
@Table(name = "v_user_modules", schema = "jg_teachers", catalog = "")
public class VUserModulesEntity {
    private Integer moduleId;
    private Integer user_id;
    private Integer usersRoleId;
    private Integer roleModuleId;
    private String userAccount;
    private String moduleName;
    private Integer moduleFatherId;
    private Integer moduleLevel;
    private Integer moduleSequence;
    private Integer moduleIsDefault;
    private String moduleUrl;
    private Integer moduleStatus;

    @Id
    @Column(name = "module_id")
    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Basic
    @Column(name = "users_role_id")
    public Integer getUsersRoleId() {
        return usersRoleId;
    }

    public void setUsersRoleId(Integer usersRoleId) {
        this.usersRoleId = usersRoleId;
    }

    @Basic
    @Column(name = "role_module_id")
    public Integer getRoleModuleId() {
        return roleModuleId;
    }

    public void setRoleModuleId(Integer roleModuleId) {
        this.roleModuleId = roleModuleId;
    }

    @Basic
    @Column(name = "user_account")
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "module_name")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Basic
    @Column(name = "module_father_id")
    public Integer getModuleFatherId() {
        return moduleFatherId;
    }

    public void setModuleFatherId(Integer moduleFatherId) {
        this.moduleFatherId = moduleFatherId;
    }

    @Basic
    @Column(name = "module_level")
    public Integer getModuleLevel() {
        return moduleLevel;
    }

    public void setModuleLevel(Integer moduleLevel) {
        this.moduleLevel = moduleLevel;
    }

    @Basic
    @Column(name = "module_sequence")
    public Integer getModuleSequence() {
        return moduleSequence;
    }

    public void setModuleSequence(Integer moduleSequence) {
        this.moduleSequence = moduleSequence;
    }

    @Basic
    @Column(name = "module_is_default")
    public Integer getModuleIsDefault() {
        return moduleIsDefault;
    }

    public void setModuleIsDefault(Integer moduleIsDefault) {
        this.moduleIsDefault = moduleIsDefault;
    }

    @Basic
    @Column(name = "module_url")
    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    @Basic
    @Column(name = "module_status")
    public Integer getModuleStatus() {
        return moduleStatus;
    }

    public void setModuleStatus(Integer moduleStatus) {
        this.moduleStatus = moduleStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VUserModulesEntity that = (VUserModulesEntity) o;

        if (moduleId != null ? !moduleId.equals(that.moduleId) : that.moduleId != null) return false;
        if (user_id != null ? !user_id.equals(that.user_id) : that.user_id != null) return false;
        if (usersRoleId != null ? !usersRoleId.equals(that.usersRoleId) : that.usersRoleId != null) return false;
        if (roleModuleId != null ? !roleModuleId.equals(that.roleModuleId) : that.roleModuleId != null) return false;
        if (userAccount != null ? !userAccount.equals(that.userAccount) : that.userAccount != null) return false;
        if (moduleName != null ? !moduleName.equals(that.moduleName) : that.moduleName != null) return false;
        if (moduleFatherId != null ? !moduleFatherId.equals(that.moduleFatherId) : that.moduleFatherId != null)
            return false;
        if (moduleLevel != null ? !moduleLevel.equals(that.moduleLevel) : that.moduleLevel != null) return false;
        if (moduleSequence != null ? !moduleSequence.equals(that.moduleSequence) : that.moduleSequence != null)
            return false;
        if (moduleIsDefault != null ? !moduleIsDefault.equals(that.moduleIsDefault) : that.moduleIsDefault != null)
            return false;
        if (moduleUrl != null ? !moduleUrl.equals(that.moduleUrl) : that.moduleUrl != null) return false;
        if (moduleStatus != null ? !moduleStatus.equals(that.moduleStatus) : that.moduleStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = moduleId != null ? moduleId.hashCode() : 0;
        result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
        result = 31 * result + (usersRoleId != null ? usersRoleId.hashCode() : 0);
        result = 31 * result + (roleModuleId != null ? roleModuleId.hashCode() : 0);
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        result = 31 * result + (moduleName != null ? moduleName.hashCode() : 0);
        result = 31 * result + (moduleFatherId != null ? moduleFatherId.hashCode() : 0);
        result = 31 * result + (moduleLevel != null ? moduleLevel.hashCode() : 0);
        result = 31 * result + (moduleSequence != null ? moduleSequence.hashCode() : 0);
        result = 31 * result + (moduleIsDefault != null ? moduleIsDefault.hashCode() : 0);
        result = 31 * result + (moduleUrl != null ? moduleUrl.hashCode() : 0);
        result = 31 * result + (moduleStatus != null ? moduleStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VUserModulesEntity{" +
                "moduleId=" + moduleId +
                ", user_id=" + user_id +
                ", usersRoleId=" + usersRoleId +
                ", roleModuleId=" + roleModuleId +
                ", userAccount='" + userAccount + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", moduleFatherId=" + moduleFatherId +
                ", moduleLevel=" + moduleLevel +
                ", moduleSequence=" + moduleSequence +
                ", moduleIsDefault=" + moduleIsDefault +
                ", moduleUrl='" + moduleUrl + '\'' +
                ", moduleStatus=" + moduleStatus +
                '}';
    }
}
