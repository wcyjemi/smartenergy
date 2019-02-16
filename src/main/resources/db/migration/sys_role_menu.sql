-- Create table 角色菜单
create table SYS_ROLE_MENU
(
  id NUMBER(20) NOT NULL,
  menu_id NUMBER(20) DEFAULT NULL,
  role_id NUMBER(20) DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_ROLE_MENU.id
  is '主键';
comment on column SYS_ROLE_MENU.menu_id
  is '菜单id';
comment on column SYS_ROLE_MENU.role_id
  is '角色id';


-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLE_MENU
  add constraint PK_SYS_ROLE_MENU primary key (id)
  using index 
  tablespace LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_ROLE_MENU
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;
