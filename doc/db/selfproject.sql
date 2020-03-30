-- �û���
DROP TABLE IF EXISTS SYS_USER;
CREATE TABLE SYS_USER (
	ID BIGINT NOT NULL , -- ID
	CODE VARCHAR(100) NOT NULL, -- ����
	USER_NAME VARCHAR(100) NOT NULL,-- ��¼�˺�
	REAL_NAME VARCHAR(100),-- ��ʵ����
	PASSWORD VARCHAR(100) NOT NULL,-- ��¼����
	AGE INT,-- ����
	EMAIL VARCHAR(50),-- ����
	SEX  SMALLINT,-- �Ա�
	PHONE VARCHAR(50),-- �绰
	CREATOR_ID VARCHAR(100),-- ������ID
	UPDATOR_ID VARCHAR(100),-- ������ID
	CREATOR_NAME VARCHAR(100),-- ����������
	OPERATOR_NAME VARCHAR(100),-- ����������
	DEFAULT_THEME VARCHAR(100), -- Ĭ������
	LAST_IP VARCHAR(100), -- ����¼IP
	LAST_TIME DATETIME,-- ����¼ʱ��
	CREATE_TIME DATETIME,-- ����ʱ��
	OPERATE_TIME DATETIME,-- ����ʱ��
	STATUS SMALLINT,-- ״̬
	SUPERMAN SMALLINT,-- �Ƿ��ǳ�������Ա
	PRIMARY KEY (ID)
);


-- ��ɫ��
DROP TABLE IF EXISTS SYS_ROLE;
CREATE TABLE SYS_ROLE (
	ID BIGINT NOT NULL , -- ID
	CODE VARCHAR(100)  NULL, -- ����
	ROLE_NAME VARCHAR(50) NOT NULL , -- ��ɫ����
	REMARK LONGTEXT, -- ��������ע
	DISPLAY_ORDER  DECIMAL(18,2) NULL , -- չʾ˳��
	CREATOR_ID VARCHAR(100),-- ������ID
	UPDATOR_ID VARCHAR(100),-- ������ID
	CREATOR_NAME VARCHAR(100),-- ����������
	OPERATOR_NAME VARCHAR(100),-- ����������
	CREATE_TIME DATETIME,-- ����ʱ��
	OPERATE_TIME DATETIME,-- ����ʱ��
	STATUS SMALLINT,-- ״̬
	PRIMARY KEY (ID)
);

-- ��ԴȨ�ޱ�
DROP TABLE IF EXISTS SYS_RESOURCE;
CREATE TABLE SYS_RESOURCE (
	ID BIGINT NOT NULL , -- ID
	CODE VARCHAR(100)  NULL, -- ����
	PARENTID BIGINT NULL , -- ��ID
	PARENT_CODE  VARCHAR(100)  NULL ,  -- ������
	PATH VARCHAR(255) ,-- ·��
	RESOURCENAME VARCHAR(50) NOT NULL ,-- ��Դ����
	URL VARCHAR(200) , -- url
	URLPREFIX VARCHAR(200) , -- url ǰ׺
	REMARK VARCHAR(2000) , -- ��������ע
	ROUTETYPE VARCHAR(20) ,-- ·������
	MODULEPATH VARCHAR(2000) , -- ģ��·��
	IMAGE VARCHAR(5000) , -- ͼƬ
	RESOURCETYPE VARCHAR(20)  NOT NULL , -- ��Դ����
	PERMISSION VARCHAR(100) , -- Ȩ��
	DISPLAYORDER DECIMAL(18,2) NULL , -- չʾ˳��
	NODELEVEL INT NULL , -- �ڵ�ȼ�
	MODULEMETHOD VARCHAR(20), -- ģ�鷽��
	URLTARGET VARCHAR(20) , -- URLTARGET 
	SYS  SMALLINT NOT NULL DEFAULT 0, -- �Ƿ�ϵͳĬ��
	CREATOR_ID VARCHAR(100),-- ������ID
	UPDATOR_ID VARCHAR(100),-- ������ID
	CREATOR_NAME VARCHAR(100),-- ����������
	OPERATOR_NAME VARCHAR(100),-- ����������
	CREATE_TIME DATETIME,-- ����ʱ��
	OPERATE_TIME DATETIME,-- ����ʱ��
	STATUS SMALLINT,-- ״̬
	PRIMARY KEY (ID)
);

-- �û���ɫ�м��
DROP TABLE IF EXISTS SYS_USER_ROLE;
CREATE TABLE  SYS_USER_ROLE(
	USERID BIGINT NOT NULL ,
	ROLEID BIGINT NOT NULL 
);

-- ��ɫȨ���м��
DROP TABLE IF EXISTS SYS_ROLE_RESOURCE;
CREATE TABLE  SYS_ROLE_RESOURCE(
	ROLEID BIGINT NOT NULL ,
	RESOURCEID BIGINT NOT NULL 
);
 