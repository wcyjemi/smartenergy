<#--  wcy 2019-03-19 11:10:52-->
<!DOCTYPE html>
<html>
<head>
    <title>采集点信息表列表</title>
    <script>
        var hasdeleteDepart = false;
        var hasupdateDepart = false;
    </script>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/collectionpoint/js/list.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form " action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">采集点名称:</label>
                            <div class="layui-input-inline">
                                <input type="text" id="collectionPointName" name="collectionPointName" placeholder="请输入名称" class="layui-input">
                            </div>
                            <label class="layui-form-label">采集点类型:</label>
                            <div id="pointType" cyType="selectTool" cyProps="codeName:'monitorType',search:'true'" name="pointType" value="" lay-verify=""
                                 class="layui-input-inline"></div>
                            <div class="layui-input-normal">
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
                        <@shiro.hasPermission name="encollectionpoint:save">
                            <button class="layui-btn" onclick="addPageAare('/encollectionpoint/add','新增采集点',1200,500)">
                                <i class="fa fa-plus">&nbsp;</i>增加
                            </button>
                        </@shiro.hasPermission>
                        <#--<@shiro.hasPermission name="encollectionpoint:update">-->
                            <#--<button class="layui-btn"-->
                                    <#--onclick="editPage('enCollectionPointTable','/encollectionpoint/edit')">-->
                                <#--<i class="fa fa-pencil-square-o">&nbsp;</i>修改-->
                            <#--</button>-->
                            <#--<script>-->
                                <#--hasupdateDepart = true;-->
                            <#--</script>-->
                            <#--<button class="layui-btn layui-btn-green"-->
                                    <#--onclick="updateState('批量启用','enCollectionPointTable','/encollectionpoint/enable')">-->
                                <#--<i class="fa fa-check-square-o">&nbsp;</i>启用-->
                            <#--</button>-->
                            <#--<button class="layui-btn  layui-btn-danger"-->
                                    <#--onclick="updateState('批量禁用','enCollectionPointTable','/encollectionpoint/limit')">-->
                                <#--<i class="fa fa-expeditedssl">&nbsp;</i>禁用-->
                            <#--</button>-->
                        <#--</@shiro.hasPermission>-->
                        <#--<@shiro.hasPermission name="encollectionpoint:delete">6-->
                            <#--<button class="layui-btn layui-btn-delete"-->
                                    <#--onclick="deleteBatch('批量删除','enCollectionPointTable','/encollectionpoint/delete');">-->
                                <#--<i class="fa fa-trash-o">&nbsp;</i>删除-->
                            <#--</button>-->
                            <#--<script>-->
                                <#--hasdeleteDepart = true;-->
                            <#--</script>-->
                        <#--</@shiro.hasPermission>-->
                    </div>
                    <div class="layui-form">
                        <table class="layui-table" id="pointTable" lay-filter="monitorUnitTable"></table>
                        <table class="layui-table" id="noDataTable" style="display: none">
                            <thead>
                            <tr>
                                <th width="20%">采集点名称</th>

                                <th width="20%">归属集中器</th>

                                <th width="10%">物理地址</th>

                                <th width="20%">虚拟地址</th>

                                <th width="10%">采集点类型</th>

                                <th width="10%">设备品牌</th>

                                <th width="10%">设备型号</th>

                                <th width="10%">操作</th>
                            </tr>
                            </thead>
                            <tbody><tr><td style="text-align: center" colspan="8">暂无数据</td></tr></tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>