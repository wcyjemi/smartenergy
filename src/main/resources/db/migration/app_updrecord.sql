-- Create table 应用更新记录表
create table APP_UPDRECORD
(
  id NUMBER(20) NOT NULL,
  app_id NUMBER(20) DEFAULT NULL,
  app_name varchar2(60) DEFAULT NULL,
  app_type char(1) DEFAULT NULL,
  app_outverno varchar2(10) DEFAULT NULL,
  app_innerverno NUMBER(10) DEFAULT NULL,
  app_downurl varchar2(255) DEFAULT NULL,
  ip_addr varchar2(50) DEFAULT NULL,
  py_addr varchar2(50) DEFAULT NULL,
  mobile_type varchar2(100) DEFAULT NULL,
  down_user varchar2(20) DEFAULT NULL,
  down_username varchar2(50) DEFAULT NULL,
  create_time date DEFAULT NULL,
  update_time date DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column APP_UPDRECORD.id
is '主键';
comment on column APP_UPDRECORD.app_id
is 'app基本信息ID';
comment on column APP_UPDRECORD.app_name
is '应用名称';
comment on column APP_UPDRECORD.app_type
is 'app类型 1 Android 2 IOS';
comment on column APP_UPDRECORD.app_outverno
is '对外版本号';
comment on column APP_UPDRECORD.app_innerverno
is '内部版本号';
comment on column APP_UPDRECORD.app_downurl
is 'APP地址';
comment on column APP_UPDRECORD.ip_addr
is 'IP地址';
comment on column APP_UPDRECORD.py_addr
is '物理地址';
comment on column APP_UPDRECORD.mobile_type
is '手机类型';
comment on column APP_UPDRECORD.down_user
is '下载人ID';
comment on column APP_UPDRECORD.down_username
is '下载人名称';
comment on column APP_UPDRECORD.create_time
is '创建时间';
comment on column APP_UPDRECORD.update_time
is '更新时间';




-- Create/Recreate primary, unique and foreign key constraints 
alter table APP_UPDRECORD
  add constraint PK_APP_UPDRECORD primary key (id)
  using index 
  tablespace LDDSINDEX ONLINE;
  
-- Create sequence 
create sequence SEQ_APP_UPDRECORD
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;