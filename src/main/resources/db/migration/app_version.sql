-- Create table 应用信息表
create table APP_VERSION
(
  id NUMBER(20) NOT NULL,
  app_id NUMBER(20) DEFAULT NULL,
  app_type char(1) DEFAULT NULL,
  app_outverno varchar2(10) DEFAULT NULL,
  app_innerverno NUMBER(10) DEFAULT NULL,
  app_updcms varchar2(1000) DEFAULT NULL,
  app_url varchar2(50) DEFAULT NULL,
  app_status char(1) DEFAULT '1',
  app_pubstatus char(1) DEFAULT '0',
  app_oprauser NUMBER(20) DEFAULT NULL,
  app_qr varchar2(50) DEFAULT NULL,
  app_updcount NUMBER(20) DEFAULT '0',
  create_time date DEFAULT NULL,
  update_time date DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column APP_VERSION.id
  is '主键';
comment on column APP_VERSION.app_id
  is 'app基本信息ID';
comment on column APP_VERSION.app_type
  is 'app类型 1 Android 2 IOS';
comment on column APP_VERSION.app_outverno
is '对外版本号';
comment on column APP_VERSION.app_innerverno
is '内部版本号';
comment on column APP_VERSION.app_updcms
is '版本更新信息';
comment on column APP_VERSION.app_url
is 'APP地址';
comment on column APP_VERSION.app_status
is 'app版本状态 0 非强制更新 1 强制更新';
comment on column APP_VERSION.app_pubstatus
is 'app版本发布状态 0 未发布 1 已发布';
comment on column APP_VERSION.app_qr
is 'app版本二维码';
comment on column APP_VERSION.app_updcount
is 'app版本更新次数';
comment on column APP_VERSION.app_oprauser
is '操作人';
comment on column APP_VERSION.create_time
is '创建时间';
comment on column APP_VERSION.update_time
is '更新时间';




-- Create/Recreate primary, unique and foreign key constraints 
alter table APP_VERSION
  add constraint PK_APP_VERSION primary key (id)
  using index 
  tablespace LDDSINDEX ONLINE;
  
-- Create sequence 
create sequence SEQ_APP_VERSION
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;