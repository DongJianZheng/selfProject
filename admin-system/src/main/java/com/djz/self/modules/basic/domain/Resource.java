package com.djz.self.modules.basic.domain;

import com.djz.self.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_resource")
public class Resource extends BaseEntity implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 编码
     */
    @Column(name = "code")
    private String code;

    /**
     * 父id
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 父编码
     */
    @Column(name = "parent_code")
    private String parentCode;

    /**
     * 路径
     */
    @Column(name = "path")
    private String path;

    /**
     * 资源名称
     */
    @Column(name = "resource_name")
    private String resourceName;

    /**
     * url
     */
    @Column(name = "url")
    private String url;

    /**
     * url 前缀
     */
    @Column(name = "url_prefix")
    private String urlPrefix;

    /**
     * 描述，备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 路由类型
     */
    @Column(name = "route_type")
    private String routeType;

    /**
     * 模块路径
     */
    @Column(name = "module_path")
    private String modulePath;

    /**
     * 图片
     */
    @Column(name = "image_id")
    private String imageId;

    /**
     * 资源类型
     */
    @Column(name = "resource_type")
    private String resourceType;

    /**
     * 权限
     */
    @Column(name = "permission")
    private String permission;

    /**
     * 展示顺序
     */
    @Column(name = "display_order")
    private Integer displayOrder;

    /**
     * 节点等级
     */
    @Column(name = "node_level")
    private Integer nodeLevel;

    /**
     * 模块方法
     */
    @Column(name = "module_method")
    private String moduleMethod;

    /**
     * urltarget 
     */
    @Column(name = "url_target")
    private String urlTarget;

    /**
     * 是否系统默认
     */
    @Column(name = "sys")
    private Short sys;

    /**
     * 创建人id
     */
    @Column(name = "creator_id")
    private String creatorId;

    /**
     * 操作人id
     */
    @Column(name = "updator_id")
    private String updatorId;

    /**
     * 创建人名称
     */
    @Column(name = "creator_name")
    private String creatorName;

    /**
     * 操作人名称
     */
    @Column(name = "operator_name")
    private String operatorName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 操作时间
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 状态
     */
    @Column(name = "status")
    private Short status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取编码
     *
     * @return code - 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编码
     *
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取父id
     *
     * @return parent_id - 父id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父id
     *
     * @param parentId 父id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取父编码
     *
     * @return parent_code - 父编码
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 设置父编码
     *
     * @param parentCode 父编码
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    /**
     * 获取路径
     *
     * @return path - 路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置路径
     *
     * @param path 路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取资源名称
     *
     * @return resource_name - 资源名称
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 设置资源名称
     *
     * @param resourceName 资源名称
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * 获取url
     *
     * @return url - url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取url 前缀
     *
     * @return url_prefix - url 前缀
     */
    public String getUrlPrefix() {
        return urlPrefix;
    }

    /**
     * 设置url 前缀
     *
     * @param urlPrefix url 前缀
     */
    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix == null ? null : urlPrefix.trim();
    }

    /**
     * 获取描述，备注
     *
     * @return remark - 描述，备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置描述，备注
     *
     * @param remark 描述，备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取路由类型
     *
     * @return route_type - 路由类型
     */
    public String getRouteType() {
        return routeType;
    }

    /**
     * 设置路由类型
     *
     * @param routeType 路由类型
     */
    public void setRouteType(String routeType) {
        this.routeType = routeType == null ? null : routeType.trim();
    }

    /**
     * 获取模块路径
     *
     * @return module_path - 模块路径
     */
    public String getModulePath() {
        return modulePath;
    }

    /**
     * 设置模块路径
     *
     * @param modulePath 模块路径
     */
    public void setModulePath(String modulePath) {
        this.modulePath = modulePath == null ? null : modulePath.trim();
    }

    /**
     * 获取图片
     *
     * @return image_id - 图片
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * 设置图片
     *
     * @param imageId 图片
     */
    public void setImageId(String imageId) {
        this.imageId = imageId == null ? null : imageId.trim();
    }

    /**
     * 获取资源类型
     *
     * @return resource_type - 资源类型
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * 设置资源类型
     *
     * @param resourceType 资源类型
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    /**
     * 获取权限
     *
     * @return permission - 权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限
     *
     * @param permission 权限
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * 获取展示顺序
     *
     * @return display_order - 展示顺序
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * 设置展示顺序
     *
     * @param displayOrder 展示顺序
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * 获取节点等级
     *
     * @return node_level - 节点等级
     */
    public Integer getNodeLevel() {
        return nodeLevel;
    }

    /**
     * 设置节点等级
     *
     * @param nodeLevel 节点等级
     */
    public void setNodeLevel(Integer nodeLevel) {
        this.nodeLevel = nodeLevel;
    }

    /**
     * 获取模块方法
     *
     * @return module_method - 模块方法
     */
    public String getModuleMethod() {
        return moduleMethod;
    }

    /**
     * 设置模块方法
     *
     * @param moduleMethod 模块方法
     */
    public void setModuleMethod(String moduleMethod) {
        this.moduleMethod = moduleMethod == null ? null : moduleMethod.trim();
    }

    /**
     * 获取urltarget 
     *
     * @return url_target - urltarget 
     */
    public String getUrlTarget() {
        return urlTarget;
    }

    /**
     * 设置urltarget 
     *
     * @param urlTarget urltarget 
     */
    public void setUrlTarget(String urlTarget) {
        this.urlTarget = urlTarget == null ? null : urlTarget.trim();
    }

    /**
     * 获取是否系统默认
     *
     * @return sys - 是否系统默认
     */
    public Short getSys() {
        return sys;
    }

    /**
     * 设置是否系统默认
     *
     * @param sys 是否系统默认
     */
    public void setSys(Short sys) {
        this.sys = sys;
    }

    /**
     * 获取创建人id
     *
     * @return creator_id - 创建人id
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * 获取操作人id
     *
     * @return updator_id - 操作人id
     */
    public String getUpdatorId() {
        return updatorId;
    }

    /**
     * 设置操作人id
     *
     * @param updatorId 操作人id
     */
    public void setUpdatorId(String updatorId) {
        this.updatorId = updatorId == null ? null : updatorId.trim();
    }

    /**
     * 获取创建人名称
     *
     * @return creator_name - 创建人名称
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * 设置创建人名称
     *
     * @param creatorName 创建人名称
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * 获取操作人名称
     *
     * @return operator_name - 操作人名称
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置操作人名称
     *
     * @param operatorName 操作人名称
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取操作时间
     *
     * @return operate_time - 操作时间
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置操作时间
     *
     * @param operateTime 操作时间
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}