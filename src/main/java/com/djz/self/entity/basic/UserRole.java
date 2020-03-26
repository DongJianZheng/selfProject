package com.djz.self.entity.basic;

public class UserRole {
    private Double userid;

    private Double roleid;

    public UserRole(Double userid, Double roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }

    public UserRole() {
        super();
    }

    public Double getUserid() {
        return userid;
    }

    public void setUserid(Double userid) {
        this.userid = userid;
    }

    public Double getRoleid() {
        return roleid;
    }

    public void setRoleid(Double roleid) {
        this.roleid = roleid;
    }
}