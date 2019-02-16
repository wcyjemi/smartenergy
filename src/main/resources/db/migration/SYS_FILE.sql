-- Create table附件表
create table SYS_FILE
(
  id NUMBER(20) not null,
  upload_id varchar2(100) NOT NULL,
  url varchar2(255) DEFAULT NULL,
  file_name varchar2(50) DEFAULT NULL,
  file_type varchar2(50) DEFAULT NULL,
  file_size varchar2(100) DEFAULT NULL,
  create_time date DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_FILE.id
  is '主键ID';
comment on column SYS_FILE.upload_id
  is '控件唯一标识(UUID)';
comment on column SYS_FILE.url
  is '文件路径';
comment on column SYS_FILE.file_name
is '文件名';
comment on column SYS_FILE.file_type
is '附件类型';
comment on column SYS_FILE.file_size
is '附件大小';
comment on column SYS_FILE.create_time
is '上传时间';

-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_FILE
  add constraint PK_SYS_FILE primary key (id,upload_id)
  using index 
  tablespace LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_FILE
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;
