-- Create table 用户表
create table SYS_USER
(
  user_id NUMBER(20) NOT NULL,
  username varchar2(50) DEFAULT NULL,
  password varchar2(100) DEFAULT NULL,
  email varchar2(100) DEFAULT NULL,
  mobile varchar2(100) DEFAULT NULL,
  status NUMBER(6) DEFAULT NULL,
  create_user_id NUMBER(20) DEFAULT NULL,
  create_time date DEFAULT NULL,
  role_id NUMBER(20) DEFAULT NULL,
  org_id char(10) DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_USER.user_id
  is '用户id';
comment on column SYS_USER.username
  is '用户名';
comment on column SYS_USER.password
  is '密码';
comment on column SYS_USER.email
is '邮箱';
comment on column SYS_USER.mobile
is '手机号';
comment on column SYS_USER.status
is '状态  0：禁用   1：正常';
comment on column SYS_USER.create_user_id
is '创建者ID';
comment on column SYS_USER.create_time
is '创建时间';
comment on column SYS_USER.role_id
is '角色id';
comment on column SYS_USER.org_id
is '部门id';

-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_USER
  add constraint PK_SYS_USER primary key (user_id)
  using index 
  tablespace LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_USER
minvalue 1
maxvalue 9999999999
start with 2
increment by 1
cache 20;
-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO SYS_USER VALUES ('1', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '228112142@qq.com', '15080156828', '1', '1', to_date('2017-08-16 10:08:51','yyyy-mm-dd hh24:mi:ss'), '1', '798e1764df');
commit;