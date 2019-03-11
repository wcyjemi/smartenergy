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
                            <button class="layui-btn" onclick="addPageAare('/encompany/add','增加企业信息',1200,800)">
                                <i class="fa fa-plus">&nbsp;</i>增加
                            </button>
                        </@shiro.hasPermission>
                    </div>
                    <div class="layui-form ">
                        <table class="layui-table" id="monitorUnitTable"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/monitorunit/js/list.js"></script>
</body>
</html>