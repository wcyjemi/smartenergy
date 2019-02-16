-- Create table操作日志
create table SYS_LOG
(
  id NUMBER(20) NOT NULL,
  username varchar2(50) DEFAULT NULL,
  operation varchar2(50) DEFAULT NULL,
  method varchar2(50) DEFAULT NULL,
  params varchar2(50) DEFAULT NULL,
  ip varchar2(64) DEFAULT NULL,
  remark varchar2(500) DEFAULT NULL,
  create_date date DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_LOG.id
  is '主键ID';
comment on column SYS_LOG.username
  is '用户名';
comment on column SYS_LOG.operation
  is '操作';
comment on column SYS_LOG.method
is '方法';
comment on column SYS_LOG.params
is '参数';
comment on column SYS_LOG.ip
is 'ip';
comment on column SYS_LOG.remark
is '备注';
comment on column SYS_LOG.create_date
is '创建时间';

-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LOG
  add constraint PK_SYS_LOG primary key (id)
  using index 
  tablespace LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_LOG
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;
