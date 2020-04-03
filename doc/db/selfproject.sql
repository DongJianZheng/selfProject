-- �û���
drop table if exists sys_user;
create table sys_user (
	`id` bigint not null  COMMENT'id',
	`code` varchar(100) not null COMMENT'����',
	`user_name` varchar(100) not null COMMENT'��¼�˺�',
	`real_name` varchar(100) COMMENT'��ʵ����',
	`password` varchar(100) not null COMMENT'��¼����',
	`age` int COMMENT'����',
	`email` varchar(50) COMMENT'����',
	`sex`  smallint COMMENT'�Ա�',
	`phone` varchar(50) COMMENT'�绰',
	`creator_id` varchar(100) COMMENT'������id',
	`updator_id` varchar(100) COMMENT'������id',
	`creator_name` varchar(100) COMMENT'����������',
	`operator_name` varchar(100) COMMENT'����������',
	`default_theme` varchar(100) COMMENT'Ĭ������',
	`last_ip` varchar(100) COMMENT'����¼ip',
	`last_time` datetime COMMENT'����¼ʱ��',
	`create_time` datetime COMMENT'����ʱ��',
	`operate_time` datetime COMMENT'����ʱ��',
	`status` smallint COMMENT'״̬',
	`superman` smallint COMMENT'�Ƿ��ǳ�������Ա',
	primary key (id)
);


-- ��ɫ��
drop table if exists sys_role;
create table sys_role (
	`id` bigint not null  COMMENT'id',
	`code` varchar(100)  null COMMENT'����',
	`role_name` varchar(50) not null  COMMENT'��ɫ����',
	`remark` longtext COMMENT'��������ע',
	`display_order`  int COMMENT'չʾ˳��',
	`creator_id` varchar(100) COMMENT'������id',
	`updator_id` varchar(100) COMMENT'������id',
	`creator_name` varchar(100) COMMENT'����������',
	`operator_name` varchar(100) COMMENT'����������',
	`create_time` datetime COMMENT'����ʱ��',
	`operate_time` datetime COMMENT'����ʱ��',
	`status` smallint COMMENT'״̬',
	primary key (id)
);

-- ��ԴȨ�ޱ�
drop table if exists sys_resource;
create table sys_resource (
	`id` bigint not null  COMMENT'id',
	`code` varchar(100)  null COMMENT'����',
	`parent_id` bigint null  COMMENT'��id',
	`parent_code`  varchar(100)  null  COMMENT'������',
	`path` varchar(255)  COMMENT'·��',
	`resource_name` varchar(50) not null  COMMENT'��Դ����',
	`url` varchar(200)  COMMENT'url',
	`url_prefix` varchar(200)  COMMENT'url ǰ׺',
	`remark` varchar(2000)  COMMENT'��������ע',
	`route_type` varchar(20)  COMMENT'·������',
	`module_path` varchar(2000)  COMMENT'ģ��·��',
	`image_id` varchar(5000)  COMMENT'ͼƬ',
	`resource_type` varchar(20)  not null  COMMENT'��Դ����',
	`permission` varchar(100)  COMMENT'Ȩ��',
	`display_order` int COMMENT'չʾ˳��',
	`node_level` int null  COMMENT'�ڵ�ȼ�',
	`module_method` varchar(20) COMMENT'ģ�鷽��',
	`url_target` varchar(20)  COMMENT'urltarget ',
	`sys`  smallint not null default 0 COMMENT'�Ƿ�ϵͳĬ��',
	`creator_id` varchar(100) COMMENT'������id',
	`updator_id` varchar(100) COMMENT'������id',
	`creator_name` varchar(100) COMMENT'����������',
	`operator_name` varchar(100) COMMENT'����������',
	`create_time` datetime COMMENT'����ʱ��',
	`operate_time` datetime COMMENT'����ʱ��',
	`status` smallint COMMENT'״̬',
	primary key (id)
);

-- �û���ɫ�м��
drop table if exists sys_user_role;
create table  sys_user_role(
	`user_id` bigint not null ,
	`role_id` bigint not null 
);

-- ��ɫȨ���м��
drop table if exists sys_role_resource;
create table  sys_role_resource(
	`role_id` bigint not null ,
	`resource_id` bigint not null 
);
 