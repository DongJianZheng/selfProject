package com.djz.self.entity.basic;

import java.io.Serializable;

public class UserRole implements Serializable {
    private Long userid;

    private Long roleid;

    private static final long serialVersionUID = 1L;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }
}