-- Create table 应用信息表
create table APP_BASEINFO
(
  id NUMBER(20) NOT NULL,
  app_name varchar2(60) DEFAULT NULL,
  app_enname varchar2(60) DEFAULT NULL,
  app_icon varchar2(256) DEFAULT NULL,
  app_intr varchar2(500) DEFAULT NULL,
  app_status char(1) DEFAULT '1',
  remark varchar2(500) DEFAULT NULL,
  opra_user NUMBER(20) DEFAULT NULL,
  create_time date DEFAULT NULL,
  update_time date DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column APP_BASEINFO.id
is '主键';
comment on column APP_BASEINFO.app_name
is 'app名称';
comment on column APP_BASEINFO.app_enname
is 'app英文名称';
comment on column APP_BASEINFO.app_icon
is 'app图标';
comment on column APP_BASEINFO.app_intr
is 'app介绍';
comment on column APP_BASEINFO.app_status
is 'app状态：0 未上架，1 已上架';
comment on column APP_BASEINFO.remark
is '备注';
comment on column APP_BASEINFO.opra_user
is '操作人';
comment on column APP_BASEINFO.create_time
is '创建时间';
comment on column APP_BASEINFO.update_time
is '更新时间';




-- Create/Recreate primary, unique and foreign key constraints 
alter table APP_BASEINFO
  add constraint PK_APP_BASEINFO primary key (id)
  using index 
  tablespace LDDSINDEX ONLINE;
  
-- Create sequence 
create sequence SEQ_APP_BASEINFO
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;