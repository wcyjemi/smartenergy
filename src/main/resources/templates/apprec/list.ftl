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
    <div class="layui-form ">
        <table class="layui-table" id="appverTable" cyType="pageGrid"
               cyProps="url:'/apprec/listData',checkbox:'true',pageColor:'#2991d9'">
            <thead>
            <tr>
                <!--复选框-->
                <th width="1%" param="{type:'checkbox'}">
                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                </th>
                <!--isPrimary：是否是主键-->
                <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}">主键</th>

                <th width="10%" param="{name:'appName'}">应用名称</th>

                <th width="10%" param="{name:'appType',render:'Render.appType'}">应用类型</th>

                <th width="10%" param="{name:'appOutverno'}">版本号</th>

                <th width="10%" param="{name:'appInnerverno'}">内部版本号</th>
                <th width="10%" param="{name:'appDownurl'}">应用下载地址</th>
                <th width="10%" param="{name:'ipAddr'}">IP</th>
                <th width="10%" param="{name:'pyAddr'}">物理地址</th>
                <th width="10%" param="{name:'mobileType'}">手机类型</th>
                <th width="10%" param="{name:'downUser'}">下载用户</th>
                <th width="10%" param="{name:'downUsername'}">下载用户名称</th>

                <th width="10%" param="{name:'createTime',render:'Render.dateFormat'}">创建时间</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<script type="text/javascript" src="/appver/js/list.js"></script>
</body>
</html>