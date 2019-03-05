<!DOCTYPE html>
<html>
<head>
    <title>企业信息</title>
    <script>
        var hasdeleteDepart = false;
        var hasupdateDepart = false;
    </script>
    <#include "../resource.ftl"/>
    <link rel="stylesheet" href="/statics/plugins/layui2-4/css/layui.css" media="all">
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form " action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">企业名称:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="companyName" placeholder="请输入名称" class="layui-input">
                            </div>

                            <div class="layui-input-inline">
                                <button class="layui-btn search-btn" table-id="companyTable" lay-submit="" lay-filter="search"><i
                                            class="fa fa-search">&nbsp;</i>查询
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
                            </div>
                        </div>
                    </form>
                    <div class="layui-btn-group">
                        <@shiro.hasPermission name="energy:company:save">
                            <button class="layui-btn" onclick="addPage('/encompany/add')">
                                <i class="fa fa-plus">&nbsp;</i>增加
                            </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="energy:company:update">
                            <button class="layui-btn" onclick="editPage('companyTable','/encompany/edit')">
                                <i class="fa fa-pencil-square-o">&nbsp;</i>修改
                            </button>
                            <script>
                                hasupdateDepart = true;
                            </script>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="energy:company:seriapply">
                            <button class="layui-btn layui-btn-green" onclick="updateState('序列号申请','companyTable','/encompany/seriapply')">
                                <i class="fa fa-check-square-o">&nbsp;</i>序列号申请
                            </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="energy:company:delete">
                            <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','companyTable','/encompany/delete');">
                                <i class="fa fa-trash-o">&nbsp;</i>删除
                            </button>
                            <script>
                                hasdeleteDepart = true;
                            </script>
                        </@shiro.hasPermission>
                    </div>
                    <div class="layui-form ">
                        <table class="layui-table" id="companyTable" cyType="pageGrid"
                               cyProps="url:'/encompany/listData',checkbox:'true',pageColor:'#2991d9'">
                            <thead>
                            <tr>
                                <!--复选框-->
                                <th width="1%" param="{type:'checkbox'}">
                                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                                </th>
                                <!--isPrimary：是否是主键-->
                                <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}">主键</th>

                                <th width="10%" param="{name:'companyName'}">企业名称</th>

                                <th width="5%" param="{name:'companyLogo',render:'Render.showimg'}">企业LOGO</th>

                                <th width="10%" param="{name:'companyAddress'}">企业地址</th>

                                <th width="10%" param="{name:'companyFr'}">企业法人</th>

                                <th width="10%" param="{name:'companyContact'}">企业联系人</th>

                                <th width="10%" param="{name:'contactPhone'}">联系方式</th>

                                <!--isPrimary：渲染列-->
                                <th width="10%" param="{name:'appStatus',enumName:'AppStatusEnum',render:'Render.customState'}">状态</th>

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
<script type="text/javascript" src="/encompany/js/list.js"></script>
</body>
</html>