-- Create table OSS配置
create table SYS_OSS
(
  bucket varchar2(50) NOT NULL,
  url varchar2(100) NOT NULL,
  endpoint varchar2(100) NOT NULL,
  access_key_id varchar2(50) DEFAULT NULL,
  access_key_secret varchar2(50) DEFAULT NULL,
  state char(1) DEFAULT NULL,
  create_time date DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_OSS.bucket
  is 'bucket';
comment on column SYS_OSS.url
  is '访问域名';
comment on column SYS_OSS.endpoint
  is 'endpoint';
comment on column SYS_OSS.access_key_id
is 'accessKeyId';
comment on column SYS_OSS.access_key_secret
is 'accessKeySecret';
comment on column SYS_OSS.state
is '状态';
comment on column SYS_OSS.create_time
is '创建时间';

-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_OSS
  add constraint PK_SYS_OSS primary key (bucket)
  using index 
  tablespace LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_OSS
minvalue 1
maxvalue 9999999999
start with 1
increment by 1
cache 20;
