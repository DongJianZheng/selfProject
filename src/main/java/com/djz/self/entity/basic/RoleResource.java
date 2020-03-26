package com.djz.self.entity.basic;

public class RoleResource {
    private Double roleid;

    private Double resourceid;

    public RoleResource(Double roleid, Double resourceid) {
        this.roleid = roleid;
        this.resourceid = resourceid;
    }

    public RoleResource() {
        super();
    }

    public Double getRoleid() {
        return roleid;
    }

    public void setRoleid(Double roleid) {
        this.roleid = roleid;
    }

    public Double getResourceid() {
        return resourceid;
    }

    public void setResourceid(Double resourceid) {
        this.resourceid = resourceid;
    }
}