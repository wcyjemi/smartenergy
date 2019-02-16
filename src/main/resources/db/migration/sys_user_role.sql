-- Create table 角色菜单
create table SYS_USER_ROLE
(
  id NUMBER(20) NOT NULL,
  user_id NUMBER(20) DEFAULT NULL,
  role_id NUMBER(20) DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_USER_ROLE.id
  is '主键';
comment on column SYS_USER_ROLE.user_id
  is '用户id';
comment on column SYS_USER_ROLE.role_id
  is '角色id';


-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_USER_ROLE
  add constraint PK_SYS_USER_ROLE primary key (id)
  using index 
  tablespace LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_USER_ROLE
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;
