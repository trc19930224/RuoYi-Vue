package com.ruoyi.quartz.domain;

public class HrUserSession {

    private Integer inquire;

    private String loginTime;

    private String loginName;

    private String userSession;

    private Integer id;

    public Integer getInquire() {
        return inquire;
    }

    public void setInquire(Integer inquire) {
        this.inquire = inquire;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserSession() {
        return userSession;
    }

    public void setUserSession(String userSession) {
        this.userSession = userSession;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
