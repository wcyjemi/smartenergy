<!DOCTYPE html>
<html>
<head>
    <title>菜单列表</title>
    <#include "../resource.ftl"/>
    <link rel="stylesheet" href="/statics/plugins/layui2-4/css/layui.css" media="all">
    <script type="text/javascript" src="/role/js/list.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form " action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">角色名称:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="roleName" placeholder="请输入角色名称" class="layui-input">
                            </div>
                            <div class="layui-input-inline">
                                <button class="layui-btn search-btn" table-id="roleTable" lay-submit="" lay-filter="search"><i class="fa fa-search">&nbsp;</i>查询
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
                            </div>
                        </div>
                    </form>
                    <div class="layui-btn-group">
                        <button class="layui-btn" onclick="add('/sys/role/add')"><i class="fa fa-plus">&nbsp;</i>增加</button>
                        <button class="layui-btn" onclick="edit('roleTable','/sys/role/edit')">
                            <i class="fa fa-pencil-square-o">&nbsp;</i>修改
                        </button>

                        <button class="layui-btn" onclick="deleteBatch('roleTable','/sys/role/delete');">
                            <i class="fa fa-trash-o">&nbsp;</i>删除
                        </button>
                    </div>
                    <div class="layui-form ">
                        <table class="layui-table" id="roleTable" cyType="pageGrid"
                               cyProps="url:'/sys/role/listData',checkbox:'true',pageColor:'#2991d9'">
                            <thead>
                            <tr>
                                <!--复选框-->
                                <th width="1%" param="{type:'checkbox'}">
                                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                                </th>
                                <!--isPrimary：是否是主键-->
                                <th width="10%" param="{name:'roleId',isPrimary:'true',hide:'true'}">角色ID</th>
                                <th width="10%" param="{name:'roleName'}">角色名称</th>
                                <th width="10%" param="{name:'remark'}">备注</th>
                                <th width="10%" param="{name:'createTime'}">创建时间</th>
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