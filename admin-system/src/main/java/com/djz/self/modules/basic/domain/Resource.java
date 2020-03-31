package com.djz.self.modules.basic.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_resource")
public class Resource implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "parent_code")
    private String parentCode;

    @Column(name = "path")
    private String path;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "url")
    private String url;

    @Column(name = "url_prefix")
    private String urlPrefix;

    @Column(name = "remark")
    private String remark;

    @Column(name = "route_type")
    private String routeType;

    @Column(name = "module_path")
    private String modulePath;

    @Column(name = "image")
    private String image;

    @Column(name = "resource_type")
    private String resourceType;

    @Column(name = "permission")
    private String permission;

    @Column(name = "display_order")
    private Double displayOrder;

    @Column(name = "node_level")
    private Integer nodeLevel;

    @Column(name = "modulemethod")
    private String modulemethod;

    @Column(name = "urltarget")
    private String urltarget;

    @Column(name = "sys")
    private Short sys;

    @Column(name = "creator_id")
    private String creatorId;

    @Column(name = "updator_id")
    private String updatorId;

    @Column(name = "creator_name")
    private String creatorName;

    @Column(name = "operator_name")
    private String operatorName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "operate_time")
    private Date operateTime;

    @Column(name = "status")
    private Short status;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return parent_code
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * @param parentCode
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * @return resource_name
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * @param resourceName
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return url_prefix
     */
    public String getUrlPrefix() {
        return urlPrefix;
    }

    /**
     * @param urlPrefix
     */
    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix == null ? null : urlPrefix.trim();
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * @return route_type
     */
    public String getRouteType() {
        return routeType;
    }

    /**
     * @param routeType
     */
    public void setRouteType(String routeType) {
        this.routeType = routeType == null ? null : routeType.trim();
    }

    /**
     * @return module_path
     */
    public String getModulePath() {
        return modulePath;
    }

    /**
     * @param modulePath
     */
    public void setModulePath(String modulePath) {
        this.modulePath = modulePath == null ? null : modulePath.trim();
    }

    /**
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * @return resource_type
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * @param resourceType
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    /**
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * @return display_order
     */
    public Double getDisplayOrder() {
        return displayOrder;
    }

    /**
     * @param displayOrder
     */
    public void setDisplayOrder(Double displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * @return node_level
     */
    public Integer getNodeLevel() {
        return nodeLevel;
    }

    /**
     * @param nodeLevel
     */
    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    /**
     * @return modulemethod
     */
    public String getModulemethod() {
        return modulemethod;
    }

    /**
     * @param modulemethod
     */
    public void setModulemethod(String modulemethod) {
        this.modulemethod = modulemethod == null ? null : modulemethod.trim();
    }

    /**
     * @return urltarget
     */
    public String getUrltarget() {
        return urltarget;
    }

    /**
     * @param urltarget
     */
    public void setUrltarget(String urltarget) {
        this.urltarget = urltarget == null ? null : urltarget.trim();
    }

    /**
     * @return sys
     */
    public Short getSys() {
        return sys;
    }

    /**
     * @param sys
     */
    public void setSys(Short sys) {
        this.sys = sys;
    }

    /**
     * @return creator_id
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * @return updator_id
     */
    public String getUpdatorId() {
        return updatorId;
    }

    /**
     * @param updatorId
     */
    public void setUpdatorId(String updatorId) {
        this.updatorId = updatorId == null ? null : updatorId.trim();
    }

    /**
     * @return creator_name
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * @param creatorName
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * @return operator_name
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * @param operatorName
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return operate_time
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * @param operateTime
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * @return status
     */
    public Short getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}