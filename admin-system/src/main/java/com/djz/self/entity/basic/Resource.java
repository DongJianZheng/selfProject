package com.djz.self.entity.basic;

import java.io.Serializable;
import java.util.Date;

public class Resource implements Serializable {
    private Long id;

    private String code;

    private Long parentid;

    private String parentCode;

    private String path;

    private String resourcename;

    private String url;

    private String urlprefix;

    private String remark;

    private String routetype;

    private String modulepath;

    private String image;

    private String resourcetype;

    private String permission;

    private Double displayorder;

    private Integer nodelevel;

    private String modulemethod;

    private String urltarget;

    private Short sys;

    private String creatorId;

    private String updatorId;

    private String creatorName;

    private String operatorName;

    private Date createTime;

    private Date operateTime;

    private Short status;

    private static final long serialVersionUID = 1L;

    public Resource(Long id, String code, Long parentid, String parentCode, String path, String resourcename, String url, String urlprefix, String remark, String routetype, String modulepath, String image, String resourcetype, String permission, Double displayorder, Integer nodelevel, String modulemethod, String urltarget, Short sys, String creatorId, String updatorId, String creatorName, String operatorName, Date createTime, Date operateTime, Short status) {
        this.id = id;
        this.code = code;
        this.parentid = parentid;
        this.parentCode = parentCode;
        this.path = path;
        this.resourcename = resourcename;
        this.url = url;
        this.urlprefix = urlprefix;
        this.remark = remark;
        this.routetype = routetype;
        this.modulepath = modulepath;
        this.image = image;
        this.resourcetype = resourcetype;
        this.permission = permission;
        this.displayorder = displayorder;
        this.nodelevel = nodelevel;
        this.modulemethod = modulemethod;
        this.urltarget = urltarget;
        this.sys = sys;
        this.creatorId = creatorId;
        this.updatorId = updatorId;
        this.creatorName = creatorName;
        this.operatorName = operatorName;
        this.createTime = createTime;
        this.operateTime = operateTime;
        this.status = status;
    }

    public Resource() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename == null ? null : resourcename.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getUrlprefix() {
        return urlprefix;
    }

    public void setUrlprefix(String urlprefix) {
        this.urlprefix = urlprefix == null ? null : urlprefix.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRoutetype() {
        return routetype;
    }

    public void setRoutetype(String routetype) {
        this.routetype = routetype == null ? null : routetype.trim();
    }

    public String getModulepath() {
        return modulepath;
    }

    public void setModulepath(String modulepath) {
        this.modulepath = modulepath == null ? null : modulepath.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype == null ? null : resourcetype.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public Double getDisplayorder() {
        return displayorder;
    }

    public void setDisplayorder(Double displayorder) {
        this.displayorder = displayorder;
    }

    public Integer getNodelevel() {
        return nodelevel;
    }

    public void setNodelevel(Integer nodelevel) {
        this.nodelevel = nodelevel;
    }

    public String getModulemethod() {
        return modulemethod;
    }

    public void setModulemethod(String modulemethod) {
        this.modulemethod = modulemethod == null ? null : modulemethod.trim();
    }

    public String getUrltarget() {
        return urltarget;
    }

    public void setUrltarget(String urltarget) {
        this.urltarget = urltarget == null ? null : urltarget.trim();
    }

    public Short getSys() {
        return sys;
    }

    public void setSys(Short sys) {
        this.sys = sys;
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
}