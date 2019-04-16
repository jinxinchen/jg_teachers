package com.jingguan.system.config;

/**
 * Created by 陈 on 2017/9/22.
 */
public class ProjectInfo {
    private String projectName;

    private boolean startPrivilege;

    public boolean isStartPrivilege() {
        return startPrivilege;
    }

    public void setStartPrivilege(boolean startPrivilege) {
        this.startPrivilege = startPrivilege;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
