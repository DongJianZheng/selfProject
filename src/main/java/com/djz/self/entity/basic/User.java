package com.djz.self.entity.basic;

import java.util.Date;

public class User {
    private String id;

    private String code;

    private String userName;

    private String realName;

    private String password;

    private Integer age;

    private String email;

    private Short sex;

    private String phone;

    private String creatorId;

    private String updatorId;

    private String creatorName;

    private String operatorName;

    private String defaultTheme;

    private String lastIp;

    private Date lastTime;

    private Date createTime;

    private Date operateTime;

    private Short status;

    private Short superman;

    public User(String id, String code, String userName, String realName, String password, Integer age, String email, Short sex, String phone, String creatorId, String updatorId, String creatorName, String operatorName, String defaultTheme, String lastIp, Date lastTime, Date createTime, Date operateTime, Short status, Short superman) {
        this.id = id;
        this.code = code;
        this.userName = userName;
        this.realName = realName;
        this.password = password;
        this.age = age;
        this.email = email;
        this.sex = sex;
        this.phone = phone;
        this.creatorId = creatorId;
        this.updatorId = updatorId;
        this.creatorName = creatorName;
        this.operatorName = operatorName;
        this.defaultTheme = defaultTheme;
        this.lastIp = lastIp;
        this.lastTime = lastTime;
        this.createTime = createTime;
        this.operateTime = operateTime;
        this.status = status;
        this.superman = superman;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public String getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(String updatorId) {
        this.updatorId = updatorId == null ? null : updatorId.trim();
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getDefaultTheme() {
        return defaultTheme;
    }

    public void setDefaultTheme(String defaultTheme) {
        this.defaultTheme = defaultTheme == null ? null : defaultTheme.trim();
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getSuperman() {
        return superman;
    }

    public void setSuperman(Short superman) {
        this.superman = superman;
    }
}