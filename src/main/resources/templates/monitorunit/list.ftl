<!DOCTYPE html>
<html>
<head>
    <title>企业信息</title>
    <script>
        var hasdeleteDepart = false;
        var hasupdateDepart = false;
    </script>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form " action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">单位名称:</label>
                            <div class="layui-input-inline">
                                <input id="monitorUnitName" type="text" name="monitorUnitName" placeholder="请输入监测单位名称" class="layui-input">
                            </div>
                            <label class="layui-form-label">企业名称:</label>
                            <div id="companyId" cyType="selectTool" cyProps="url:'/encompany/queryAll',search:'true'" name="companyId" value="" lay-verify=""
                                 class="layui-input-inline"></div>
                            <label class="layui-form-label">单位类型:</label>
                            <div id="monitorType" cyType="selectTool" cyProps="codeName:'monitorType',search:'true'" name="monitorType" value="" lay-verify=""
                                 class="layui-input-inline"></div>
                            <div class="layui-input-inline">
                                <button id="serchForm" type="button" class="layui-btn search-btn" lay-filter="serchForm">
                                    <i class="fa fa-search">&nbsp;</i>查询
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary">
                                    <i class="fa fa-refresh">&nbsp;</i>重置
                                </button>
                            </div>
                        </div>
                    </form>
                    <div class="layui-btn-group">
                        <@shiro.hasPermission name="energy:monitorunit:save">
                            <button class="layui-btn" onclick="addPageAare('/enmonitorunit/toSelectCompany','选择企业',600,250)">
                                <i class="fa fa-plus">&nbsp;</i>增加
                            </button>
                        </@shiro.hasPermission>
                    </div>
                    <div class="layui-form ">
                        <table class="layui-table" id="monitorUnitTable" lay-filter="monitorUnitTable"></table>

                        <table class="layui-table" id="noDataTable" style="display: none">
                            <thead>
                            <tr>
                                <th width="10%">监测单位名称</th>

                                <th width="5%">监测单位编号</th>

                                <th width="10%">父级单位编号</th>

                                <th width="10%">上级监测单位名称</th>

                                <th width="10%" style="text-align: center">归属公司</th>

                                <th width="10%" style="text-align: center">类型</th>

                                <!--isPrimary：渲染列-->

                                <th width="10%" style="text-align: center">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <tr><td style="text-align: center" colspan="7">暂无数据</td></tr>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/monitorunit/js/list.js"></script>
</body>
</html>