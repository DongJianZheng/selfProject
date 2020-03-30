-- �û���
drop table if exists sys_user;
create table sys_user (
	id bigint not null , -- id
	code varchar(100) not null, -- ����
	user_name varchar(100) not null,-- ��¼�˺�
	real_name varchar(100),-- ��ʵ����
	password varchar(100) not null,-- ��¼����
	age int,-- ����
	email varchar(50),-- ����
	sex  smallint,-- �Ա�
	phone varchar(50),-- �绰
	creator_id varchar(100),-- ������id
	updator_id varchar(100),-- ������id
	creator_name varchar(100),-- ����������
	operator_name varchar(100),-- ����������
	default_theme varchar(100), -- Ĭ������
	last_ip varchar(100), -- ����¼ip
	last_time datetime,-- ����¼ʱ��
	create_time datetime,-- ����ʱ��
	operate_time datetime,-- ����ʱ��
	status smallint,-- ״̬
	superman smallint,-- �Ƿ��ǳ�������Ա
	primary key (id)
);


-- ��ɫ��
drop table if exists sys_role;
create table sys_role (
	id bigint not null , -- id
	code varchar(100)  null, -- ����
	role_name varchar(50) not null , -- ��ɫ����
	remark longtext, -- ��������ע
	display_order  decimal(18,2) null , -- չʾ˳��
	creator_id varchar(100),-- ������id
	updator_id varchar(100),-- ������id
	creator_name varchar(100),-- ����������
	operator_name varchar(100),-- ����������
	create_time datetime,-- ����ʱ��
	operate_time datetime,-- ����ʱ��
	status smallint,-- ״̬
	primary key (id)
);

-- ��ԴȨ�ޱ�
drop table if exists sys_resource;
create table sys_resource (
	id bigint not null , -- id
	code varchar(100)  null, -- ����
	parent_id bigint null , -- ��id
	parent_code  varchar(100)  null ,  -- ������
	path varchar(255) ,-- ·��
	resource_name varchar(50) not null ,-- ��Դ����
	url varchar(200) , -- url
	url_prefix varchar(200) , -- url ǰ׺
	remark varchar(2000) , -- ��������ע
	route_type varchar(20) ,-- ·������
	module_path varchar(2000) , -- ģ��·��
	image varchar(5000) , -- ͼƬ
	resource_type varchar(20)  not null , -- ��Դ����
	permission varchar(100) , -- Ȩ��
	display_order decimal(18,2) null , -- չʾ˳��
	node_level int null , -- �ڵ�ȼ�
	modulemethod varchar(20), -- ģ�鷽��
	urltarget varchar(20) , -- urltarget 
	sys  smallint not null default 0, -- �Ƿ�ϵͳĬ��
	creator_id varchar(100),-- ������id
	updator_id varchar(100),-- ������id
	creator_name varchar(100),-- ����������
	operator_name varchar(100),-- ����������
	create_time datetime,-- ����ʱ��
	operate_time datetime,-- ����ʱ��
	status smallint,-- ״̬
	primary key (id)
);

-- �û���ɫ�м��
drop table if exists sys_user_role;
create table  sys_user_role(
	user_id bigint not null ,
	role_id bigint not null 
);

-- ��ɫȨ���м��
drop table if exists sys_role_resource;
create table  sys_role_resource(
	role_id bigint not null ,
	resource_id bigint not null 
);
 