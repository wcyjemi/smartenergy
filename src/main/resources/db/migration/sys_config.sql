-- Create table参数表
create table SYS_CONFIG
(
  id NUMBER(20) not null,
  code varchar2(50) DEFAULT NULL,
  value varchar2(500) DEFAULT NULL,
  status char(1) DEFAULT NULL,
  remark varchar2(500) DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_CONFIG.id
  is '主键ID';
comment on column SYS_CONFIG.code
  is 'code';
comment on column SYS_CONFIG.value
  is 'value';
comment on column SYS_CONFIG.status
is '状态  0：禁用   1：正常';
comment on column SYS_CONFIG.remark
is '备注';

-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_CONFIG
  add constraint PK_SYS_CONFIG primary key (id)
  using index 
  tablespace  LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_CONFIG
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;
