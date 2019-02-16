-- Create table 角色菜单
create table SYS_USER_APP
(
  id NUMBER(20) NOT NULL,
  user_id NUMBER(20) DEFAULT NULL,
  app_id NUMBER(20) DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_USER_APP.id
  is '主键';
comment on column SYS_USER_APP.user_id
  is '用户id';
comment on column SYS_USER_APP.app_id
  is '应用id';


-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_USER_APP
  add constraint PK_SYS_USER_APP primary key (id)
  using index 
  tablespace LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_USER_APP
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;
