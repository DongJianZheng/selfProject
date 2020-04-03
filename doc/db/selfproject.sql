-- 用户表
drop table if exists sys_user;
create table sys_user (
	`id` bigint not null  COMMENT'id',
	`code` varchar(100) not null COMMENT'编码',
	`user_name` varchar(100) not null COMMENT'登录账号',
	`real_name` varchar(100) COMMENT'真实姓名',
	`password` varchar(100) not null COMMENT'登录密码',
	`age` int COMMENT'年龄',
	`email` varchar(50) COMMENT'邮箱',
	`sex`  smallint COMMENT'性别',
	`phone` varchar(50) COMMENT'电话',
	`creator_id` varchar(100) COMMENT'创建人id',
	`updator_id` varchar(100) COMMENT'操作人id',
	`creator_name` varchar(100) COMMENT'创建人名称',
	`operator_name` varchar(100) COMMENT'操作人名称',
	`default_theme` varchar(100) COMMENT'默认主题',
	`last_ip` varchar(100) COMMENT'最后登录ip',
	`last_time` datetime COMMENT'最后登录时间',
	`create_time` datetime COMMENT'创建时间',
	`operate_time` datetime COMMENT'操作时间',
	`status` smallint COMMENT'状态',
	`superman` smallint COMMENT'是否是超级管理员',
	primary key (id)
);


-- 角色表
drop table if exists sys_role;
create table sys_role (
	`id` bigint not null  COMMENT'id',
	`code` varchar(100)  null COMMENT'编码',
	`role_name` varchar(50) not null  COMMENT'角色名称',
	`remark` longtext COMMENT'描述，备注',
	`display_order`  int COMMENT'展示顺序',
	`creator_id` varchar(100) COMMENT'创建人id',
	`updator_id` varchar(100) COMMENT'操作人id',
	`creator_name` varchar(100) COMMENT'创建人名称',
	`operator_name` varchar(100) COMMENT'操作人名称',
	`create_time` datetime COMMENT'创建时间',
	`operate_time` datetime COMMENT'操作时间',
	`status` smallint COMMENT'状态',
	primary key (id)
);

-- 资源权限表
drop table if exists sys_resource;
create table sys_resource (
	`id` bigint not null  COMMENT'id',
	`code` varchar(100)  null COMMENT'编码',
	`parent_id` bigint null  COMMENT'父id',
	`parent_code`  varchar(100)  null  COMMENT'父编码',
	`path` varchar(255)  COMMENT'路径',
	`resource_name` varchar(50) not null  COMMENT'资源名称',
	`url` varchar(200)  COMMENT'url',
	`url_prefix` varchar(200)  COMMENT'url 前缀',
	`remark` varchar(2000)  COMMENT'描述，备注',
	`route_type` varchar(20)  COMMENT'路由类型',
	`module_path` varchar(2000)  COMMENT'模块路径',
	`image_id` varchar(5000)  COMMENT'图片',
	`resource_type` varchar(20)  not null  COMMENT'资源类型',
	`permission` varchar(100)  COMMENT'权限',
	`display_order` int COMMENT'展示顺序',
	`node_level` int null  COMMENT'节点等级',
	`module_method` varchar(20) COMMENT'模块方法',
	`url_target` varchar(20)  COMMENT'urltarget ',
	`sys`  smallint not null default 0 COMMENT'是否系统默认',
	`creator_id` varchar(100) COMMENT'创建人id',
	`updator_id` varchar(100) COMMENT'操作人id',
	`creator_name` varchar(100) COMMENT'创建人名称',
	`operator_name` varchar(100) COMMENT'操作人名称',
	`create_time` datetime COMMENT'创建时间',
	`operate_time` datetime COMMENT'操作时间',
	`status` smallint COMMENT'状态',
	primary key (id)
);

-- 用户角色中间表
drop table if exists sys_user_role;
create table  sys_user_role(
	`user_id` bigint not null ,
	`role_id` bigint not null 
);

-- 角色权限中间表
drop table if exists sys_role_resource;
create table  sys_role_resource(
	`role_id` bigint not null ,
	`resource_id` bigint not null 
);
 