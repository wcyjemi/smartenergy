<!DOCTYPE html>
<html>
<head>
    <title>管理员列表</title>
    <#include "../resource.ftl"/>
    <link rel="stylesheet" href="/statics/plugins/layui2-4/css/layui.css" media="all">
    <script type="text/javascript" src="/user/js/list.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form " action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">用户名:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="username" placeholder="请输入用户名" class="layui-input">
                            </div>
                            <label class="layui-form-label">手机号:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="mobile" placeholder="请输入手机号" class="layui-input">
                            </div>
                            <div class="layui-input-inline">
                                <button class="layui-btn search-btn" table-id="userTable" lay-submit="" lay-filter="search"><i class="fa fa-search">&nbsp;</i>查询
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
                            </div>
                        </div>
                    </form>
                    <div class="layui-btn-group">
                        <@shiro.hasPermission name="sys:user:save">
                            <button class="layui-btn" onclick="add('/sys/user/add')"><i class="fa fa-plus">&nbsp;</i>增加</button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="sys:user:update">
                            <button class="layui-btn" onclick="edit('userTable','/sys/user/edit')">
                                <i class="fa fa-pencil-square-o">&nbsp;</i>修改
                            </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="sys:user:delete">
                            <button class="layui-btn" onclick="deleteBatch('userTable','/sys/user/delete');">
                                <i class="fa fa-trash-o">&nbsp;</i>删除
                            </button>
                        </@shiro.hasPermission>
                        <button class="layui-btn" onclick="initPassword('userTable','/sys/user/initPassword');">
                            <i class="fa fa-refresh">&nbsp;</i>初始化密码 123456
                        </button>
                        <a class="layui-btn" href="/sys/user/exportUser" target="_blank">
                            <i class="fa fa-refresh">&nbsp;</i>导出数据
                        </a>

                    </div>
                    <div class="layui-form ">
                        <table class="layui-table" id="userTable" cyType="pageGrid"
                               cyProps="url:'/sys/user/listData',checkbox:'true',pageColor:'#2991d9'">
                            <thead>
                            <tr>
                                <!--复选框-->
                                <th width="1%" param="{type:'checkbox'}">
                                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                                </th>
                                <!--isPrimary：是否是主键-->
                                <th width="10%" param="{name:'userId',isPrimary:'true',hide:'true'}">用户ID</th>
                                <th width="10%" param="{name:'username',sort:'true'}">用户名</th>
                                <th width="10%" param="{name:'email',sort:'false'}">邮箱</th>
                                <th width="10%" param="{name:'mobile',sort:'true'}">手机号</th>
                                <th width="10%" param="{name:'createTime',sort:'true'}">创建时间</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>