<!DOCTYPE html>
<html>
<head>
    <title>oss配置</title>
    <#include "../resource.ftl"/>
    <link rel="stylesheet" href="/statics/plugins/layui2-4/css/layui.css" media="all">
    <script type="text/javascript" src="/sysoss/js/list.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form " action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">名称:</label>
                            <div class="layui-input-inline">
                                <input type="text" name=""  placeholder="请输入名称" class="layui-input">
                            </div>

                            <div class="layui-input-inline">
                                <button class="layui-btn search-btn" table-id="sysOssTable" lay-submit="" lay-filter="search"><i class="fa fa-search">&nbsp;</i>查询
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
                            </div>
                        </div>
                    </form>
                    <div class="layui-btn-group">
                        <@shiro.hasPermission name="sysoss:save">
                            <button class="layui-btn" onclick="addPage('/sysoss/add')">
                                <i class="fa fa-plus">&nbsp;</i>增加
                            </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="sysoss:update">
                            <button class="layui-btn" onclick="editPage('sysOssTable','/sysoss/edit')">
                                <i class="fa fa-pencil-square-o">&nbsp;</i>修改
                            </button>
                            <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','sysOssTable','/sysoss/enable')">
                                <i class="fa fa-check-square-o">&nbsp;</i>启用
                            </button>
                            <button class="layui-btn  layui-btn-danger" onclick="updateState('批量禁用','sysOssTable','/sysoss/limit')">
                                <i class="fa fa-expeditedssl">&nbsp;</i>禁用
                            </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="sysoss:delete">
                            <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','sysOssTable','/sysoss/delete');">
                                <i class="fa fa-trash-o">&nbsp;</i>删除
                            </button>
                        </@shiro.hasPermission>
                        </button>
                    </div>
                    <div class="layui-form nowrap">
                        <table class="layui-table" id="sysOssTable" cyType="pageGrid"
                               cyProps="url:'/sysoss/listData',checkbox:'true',pageColor:'#2991d9'">
                            <thead>
                            <tr>
                                <!--复选框-->
                                <th width="1%" param="{type:'checkbox'}">
                                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                                </th>
                                <!--isPrimary：是否是主键-->
                                <th width="10%" param="{name:'bucket',isPrimary:'true'}">bucket</th>


                                <th width="10%" param="{name:'url'}">访问域名</th>

                                <th width="10%" param="{name:'endpoint'}">endpoint</th>

                                <th width="10%" param="{name:'accessKeyId'}">accessKeyId</th>

                                <th width="10%" param="{name:'accessKeySecret'}">accessKeySecret</th>

                                <th width="10%" param="{name:'createTime'}">创建时间</th>
                                <!--isPrimary：渲染列-->
                                <th width="10%" param="{name:'state',codeName:'state',render:'Render.customState'}">状态</th>
                                <th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete'}">操作</th>
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