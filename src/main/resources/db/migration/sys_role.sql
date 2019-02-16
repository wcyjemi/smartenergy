-- Create table角色
create table SYS_ROLE
(
  role_id NUMBER(20) NOT NULL,
  role_name varchar2(100) DEFAULT NULL,
  remark varchar2(100) NOT NULL,
  mobile varchar2(100) DEFAULT NULL,
  status NUMBER(6) DEFAULT NULL,
  create_user_id NUMBER(20) DEFAULT NULL,
  create_time date DEFAULT NULL,
  org_id char(10) DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_ROLE.role_id
  is '角色id';
comment on column SYS_ROLE.role_name
  is '部门名称';
comment on column SYS_ROLE.remark
  is '角色编码';
comment on column SYS_ROLE.mobile
is '手机号';
comment on column SYS_ROLE.status
is '状态  0：禁用   1：正常';
comment on column SYS_ROLE.create_user_id
is '创建者ID';
comment on column SYS_ROLE.create_time
is '创建时间';
comment on column SYS_ROLE.org_id
is '所属部门';

-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLE
  add constraint PK_SYS_ROLE primary key (role_id)
  using index 
  tablespace LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_ROLE
minvalue 1
maxvalue 9999999999
start with 2
increment by 1
cache 20;
-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO SYS_ROLE VALUES ('1', '管理员', 'admin', null, null, '1', to_date('2017-08-16 10:08:51','yyyy-mm-dd hh24:mi:ss'), '');
commit;