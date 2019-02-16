<!DOCTYPE html>
<html>
<head>
    <title>APP版本信息管理</title>
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
                <button class="layui-btn search-btn" table-id="appverTable" lay-submit="" lay-filter="search"><i
                            class="fa fa-search">&nbsp;</i>查询
                </button>
                <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
            </div>
        </div>
    </form>
    <div class="layui-btn-group">
        <@shiro.hasPermission name="appver:save">
            <button class="layui-btn" onclick="addPageAare('/appver/toSelectApp','选择应用',600,250)">
                <i class="fa fa-plus">&nbsp;</i>增加
            </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="appver:update">
            <#--<button class="layui-btn" onclick="editPage('appverTable','/appver/edit')">-->
                <#--<i class="fa fa-pencil-square-o">&nbsp;</i>修改-->
            <#--</button>-->
            <script>
                hasupdateDepart = true;
            </script>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="appver:upOnline">
            <button class="layui-btn layui-btn-green" onclick="updateState('批量发布','appverTable','/appver/upOnline')">
                <i class="fa fa-check-square-o">&nbsp;</i>发布
            </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="appver:downOnline">
            <button class="layui-btn layui-btn-danger" onclick="updateState('批量停用','appverTable','/appver/downOnline')">
                <i class="fa fa-expeditedssl">&nbsp;</i>停用
            </button>
        </@shiro.hasPermission>
        <@shiro.hasPermission name="appver:delete">
            <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','appverTable','/appver/delete');">
                <i class="fa fa-trash-o">&nbsp;</i>删除
            </button>
            <script>
                hasdeleteDepart = true;
            </script>
        </@shiro.hasPermission>
    </div>
    <div class="layui-form ">
        <table class="layui-table" id="appverTable" cyType="pageGrid"
               cyProps="url:'/appver/listData',checkbox:'true',pageColor:'#2991d9'">
            <thead>
            <tr>
                <!--复选框-->
                <th width="1%" param="{type:'checkbox'}">
                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                </th>
                <!--isPrimary：是否是主键-->
                <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}">主键</th>

                <th width="5%" param="{name:'appIcon',render:'Render.showimg'}">应用图标</th>

                <th width="10%" param="{name:'appName'}">应用名称</th>

                <th width="10%" param="{name:'appType',render:'Render.appType'}">应用类型</th>

                <th width="10%" param="{name:'appOutverno'}">版本号</th>

                <th width="10%" param="{name:'appUpdcount'}">下载次数</th>

                <th width="10%" param="{name:'createTime',render:'Render.dateFormat'}">创建时间</th>

                <!--isPrimary：渲染列-->
                <th width="10%" param="{name:'appStatus',codeName:'appforce',render:'Render.customState'}">是否强制</th>
                <th width="10%" param="{name:'appPubstatus',render:'Render.pubState'}">发布状态</th>
                <th width="5%" param="{name:'appQr',render:'Render.showQrimg'}">二维码</th>
                <th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete'}">操作</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script type="text/javascript" src="/appver/js/list.js"></script>
</body>
</html>