--Create user
create user appveruser identified by apptest123;
grant dba to appveruser

-- Create table字典管理
create table SYS_COMMPARA
(
  para_id NUMBER(11) not null,
  para_code varchar2(20) NOT NULL,
  para_name varchar2(20) NOT NULL,
  para_key varchar2(20) NOT NULL,
  sort_no NUMBER(11) NOT NULL,
  state char(1) NOT NULL,
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_COMMPARA.para_id
  is '主键ID';
comment on column SYS_COMMPARA.para_code
  is '参数编码';
comment on column SYS_COMMPARA.para_name
  is '参数名称';
comment on column SYS_COMMPARA.para_key
is '参数值';
comment on column SYS_COMMPARA.sort_no
is '排序';
comment on column SYS_COMMPARA.state
is '状态';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_COMMPARA
  add constraint PK_SYS_COMMPARA primary key (para_id)
  using index 
  tablespace  LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_COMMPARA
minvalue 1
maxvalue 9999999999
start with 2001
increment by 1
cache 20;
--初始数据
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'state', '启用', '1', '0', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'state', '禁用', '0', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'areaLevel', '国家级', '-1', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'areaLevel', '省级', '1', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'areaLevel', '市级', '2', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'areaLevel', '县级', '3', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'areaLevel', '镇级', '4', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'menuType', '目录', '0', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'menuType', '菜单', '1', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'menuType', '按钮', '2', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'sex', '男', '1', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'sex', '女', '0', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'whether', '是', '1', '1', '1');
INSERT INTO sys_commpara(para_id,para_code,para_name,para_key,sort_no,state)  VALUES (seq_sys_commpara.nextval, 'whether', '否', '0', '1', '1');