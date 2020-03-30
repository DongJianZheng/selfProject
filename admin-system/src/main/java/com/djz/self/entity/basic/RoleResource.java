package com.djz.self.entity.basic;

import java.io.Serializable;

public class RoleResource implements Serializable {
    private Long roleid;

    private Long resourceid;

    private static final long serialVersionUID = 1L;

    public RoleResource(Long roleid, Long resourceid) {
        this.roleid = roleid;
        this.resourceid = resourceid;
    }

    public RoleResource() {
        super();
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public Long getResourceid() {
        return resourceid;
    }

    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }
}