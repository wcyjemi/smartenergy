<!DOCTYPE html>
<html>
<head>
    <title>APP基本信息管理</title>
    <script>
        var hasdeleteDepart = false;
        var hasupdateDepart = false;
    </script>
    <#include "../resource.ftl"/>
    <link rel="stylesheet" href="/statics/plugins/layui2-4/css/layui.css" media="all">
</head>
<body>
<div class="layui-fluid">

    <form class="layui-form " action="">
        <div class="layui-form-item">
            <label class="layui-form-label">应用名称:</label>
            <div class="layui-input-inline">
                <input type="text" name="appName" placeholder="请输入名称" class="layui-input">
            </div>

            <div class="layui-input-inline">
                <button class="layui-btn search-btn" table-id="appInfoTable" lay-submit="" lay-filter="search"><i
                            class="fa fa-search">&nbsp;</i>查询
                </button>
                <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
            </div>
        </div>
    </form>
    <div class="layui-btn-group">
        <@shiro.hasPermission name="appinfo:save">
            <button class="layui-btn" onclick="addPage('/appinfo/add')">
                <i class="fa fa-plus">&nbsp;</i>增加
            </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="appinfo:update">
            <#--<button class="layui-btn" onclick="editPage('appInfoTable','/appinfo/edit')">-->
                <#--<i class="fa fa-pencil-square-o">&nbsp;</i>修改-->
            <#--</button>-->
            <script>
                hasupdateDepart = true;
            </script>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="appinfo:upOnline">
            <button class="layui-btn layui-btn-green" onclick="updateState('批量上架','appInfoTable','/appinfo/upOnline')">
                <i class="fa fa-check-square-o">&nbsp;</i>上架
            </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="appinfo:downOnline">
            <button class="layui-btn layui-btn-danger" onclick="updateState('批量下架','appInfoTable','/appinfo/downOnline')">
                <i class="fa fa-expeditedssl">&nbsp;</i>下架
            </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="appinfo:delete">
            <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','appInfoTable','/appinfo/delete');">
                <i class="fa fa-trash-o">&nbsp;</i>删除
            </button>
            <script>
                hasdeleteDepart = true;
            </script>
        </@shiro.hasPermission>
    </div>
    <div class="layui-form ">
        <table class="layui-table" id="appInfoTable" cyType="pageGrid"
               cyProps="url:'/appinfo/listData',checkbox:'true',pageColor:'#2991d9'">
            <thead>
            <tr>
                <!--复选框-->
                <th width="1%" param="{type:'checkbox'}">
                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                </th>
                <!--isPrimary：是否是主键-->
                <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}">主键</th>

                <th width="10%" param="{name:'id'}">APPID</th>


                <th width="5%" param="{name:'appIcon',render:'Render.showimg'}">应用图标</th>

                <th width="10%" param="{name:'appName'}">应用名称</th>

                <th width="10%" param="{name:'appIntr'}">应用简介</th>

                <th width="10%" param="{name:'createTime',render:'Render.dateFormat'}">上传时间</th>

                <!--isPrimary：渲染列-->
                <th width="10%" param="{name:'appStatus',enumName:'AppStatusEnum',render:'Render.customState'}">状态</th>
                <th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete'}">操作</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script type="text/javascript" src="/appinfo/js/list.js"></script>
</body>
</html>