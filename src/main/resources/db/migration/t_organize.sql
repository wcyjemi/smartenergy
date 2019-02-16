-- Create table 用户表
create table T_ORGANIZE
(
  org_id char(10) NOT NULL,
  org_code varchar2(20) NOT NULL,
  org_name varchar2(30) NOT NULL,
  parent_org_id char(10) DEFAULT NULL,
  sort_no NUMBER(6) DEFAULT '1',
  state NUMBER(4) DEFAULT '1',
  in_date date DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column T_ORGANIZE.org_id
  is '部门标识';
comment on column T_ORGANIZE.org_code
  is '部门编号';
comment on column T_ORGANIZE.org_name
  is '部门名称';
comment on column T_ORGANIZE.parent_org_id
is '上一级部门标识';
comment on column T_ORGANIZE.sort_no
is '排序';
comment on column T_ORGANIZE.state
is '是否显示  0：否 1：是';
comment on column T_ORGANIZE.in_date
is '添加时间';


-- Create/Recreate primary, unique and foreign key constraints 
alter table T_ORGANIZE
  add constraint PK_T_ORGANIZE primary key (org_id)
  using index 
  tablespace LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_T_ORGANIZE
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;
