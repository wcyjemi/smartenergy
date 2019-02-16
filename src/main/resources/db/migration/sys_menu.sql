-- Create table菜单
create table SYS_MENU
(
  menu_id INTEGER NOT NULL,
  parent_id INTEGER DEFAULT NULL,
  name varchar2(50) DEFAULT NULL,
  url varchar2(200) DEFAULT NULL,
  perms varchar2(500) DEFAULT NULL,
  type INTEGER DEFAULT NULL,
  icon varchar2(50) DEFAULT NULL,
  order_num INTEGER DEFAULT NULL
)
tablespace LDDSDATA;
 
-- Add comments to the columns 
comment on column SYS_MENU.menu_id
  is '菜单id';
comment on column SYS_MENU.parent_id
  is '上级id';
comment on column SYS_MENU.name
  is '菜单名称';
comment on column SYS_MENU.url
is '地址';
comment on column SYS_MENU.perms
is '权限';
comment on column SYS_MENU.type
is '类型';
comment on column SYS_MENU.icon
is '图标';
comment on column SYS_MENU.order_num
is '排序';

-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_MENU
  add constraint PK_SYS_MENU primary key (menu_id)
  using index 
  tablespace LDDSINDEX ONLINE;

-- Create sequence 
create sequence SEQ_SYS_MENU
minvalue 1
maxvalue 9999999999
start with 220
increment by 1
cache 20;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO SYS_MENU VALUES ('1', '0', '系统管理', '', '', '0', 'fa fa-cog', '2');
INSERT INTO SYS_MENU VALUES ('2', '1', '管理员列表', 'sys/user/list', 'sys:user:list', '1', 'fa fa-user', '1');
INSERT INTO SYS_MENU VALUES ('3', '1', '角色管理', 'sys/role/list', 'sys:role:list', '1', 'fa fa-user-secret', '2');
INSERT INTO SYS_MENU VALUES ('4', '1', '菜单管理', 'sys/menu/list', 'sys:menu:list', '1', 'fa fa-th-list', '1');
INSERT INTO SYS_MENU VALUES ('5', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('6', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('7', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('8', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('9', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('10', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('11', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('12', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('13', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('14', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('15', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('16', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO SYS_MENU VALUES ('17', '1', '参数管理', 'sys/config/list', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO SYS_MENU VALUES ('18', '1', '系统日志', 'sys/log/list', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO SYS_MENU VALUES ('20', '1', '地区管理', '/area/list', '', '1', 'fa fa-area-chart', '7');
INSERT INTO SYS_MENU VALUES ('21', '20', '查看', null, 'area:list,area:info', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('22', '20', '新增', null, 'area:save', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('23', '20', '修改', null, 'area:update', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('24', '20', '删除', null, 'area:delete', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('81', '1', '字典管理', 'commpara/list', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO SYS_MENU VALUES ('82', '81', '查看', null, 'commpara:list,commpara:info', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('83', '81', '新增', null, 'commpara:save', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('84', '81', '修改', null, 'commpara:update', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('85', '81', '删除', null, 'commpara:delete', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('86', '1', '部门管理', 'organize/list', 'organize:list', '1', 'fa fa-users', '4');
INSERT INTO SYS_MENU VALUES ('87', '86', '查看', null, 'organize:info', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('88', '86', '新增', null, 'organize:save', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('89', '86', '修改', null, 'organize:update', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('90', '86', '删除', null, 'organize:delete', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('208', '1', 'oss配置', 'sysoss/list', null, '1', 'fa fa-upload', '6');
INSERT INTO SYS_MENU VALUES ('209', '208', '查看', null, 'sysoss:list,sysoss:info', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('210', '208', '新增', null, 'sysoss:save', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('211', '208', '修改', null, 'sysoss:update', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('212', '208', '删除', null, 'sysoss:delete', '2', null, '6');
INSERT INTO SYS_MENU VALUES ('216', '0', '开发工具', '', '', '0', 'fa fa-cogs', '1');
INSERT INTO SYS_MENU VALUES ('217', '216', '代码生成器', '/sys/generator/list', '', '1', 'fa fa-rocket', null);
INSERT INTO SYS_MENU VALUES ('218', '216', 'sql监控', '/druid/sql.html', '', '1', 'fa fa-bug', null);
INSERT INTO SYS_MENU VALUES ('219', '216', 'api接口文档', '/swagger-ui.html', '', '1', 'fa fa-envira', null);



























