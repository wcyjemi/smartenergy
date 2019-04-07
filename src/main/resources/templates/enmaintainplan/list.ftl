<#--  wcy 2019-04-07 18:35:07-->
<!DOCTYPE html>
<html>
<head>
    <title>设备维保计划列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/enmaintainplan/js/list.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form " action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">计划名称:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="deviceName"  placeholder="请输入计划名称:" class="layui-input">
                            </div>

                            <div class="layui-input-normal">
                                <!--
                                <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                                    <i class="fa fa-chevron-down">&nbsp;</i>更多
                                </button>
                                -->
                                <button class="layui-btn search-btn" table-id="enMaintainPlanTable" lay-submit="" lay-filter="search">
                                    <i class="fa fa-search">&nbsp;</i>查询
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>
                            </div>
                        </div>
                        <div class="layui-form-item more-search">
                           <#-- 更多条件-->
                        </div>
                    </form>
                    <div class="layui-btn-group">
                            <@shiro.hasPermission name="enmaintainplan:save">
                            <button class="layui-btn" onclick="addPage('/enmaintainplan/add')">
                                <i class="fa fa-plus">&nbsp;</i>增加
                            </button>
                            </@shiro.hasPermission>
                            <@shiro.hasPermission name="enmaintainplan:update">
                            <button class="layui-btn" onclick="editPage('enMaintainPlanTable','/enmaintainplan/edit')">
                                <i class="fa fa-pencil-square-o">&nbsp;</i>修改
                            </button>

                            </@shiro.hasPermission>
                            <@shiro.hasPermission name="enmaintainplan:delete">
                             <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','enMaintainPlanTable','/enmaintainplan/delete');">
                                <i class="fa fa-trash-o">&nbsp;</i>删除
                            </button>
                            </@shiro.hasPermission>

                    </div>
                    <div class="layui-form ">
                        <table class="layui-table" id="enMaintainPlanTable" cyType="pageGrid"
                               cyProps="url:'/enmaintainplan/listData',checkbox:'true',pageColor:'#2991d9'">
                            <thead>
                            <tr>
                                <!--复选框-->
                                <th width="1%" param="{type:'checkbox'}">
                                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                                </th>
                                                                                        <!--isPrimary：是否是主键-->
                                <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>
                                
                                                                    
                                                  <th width="10%" param="{name:'deviceId'}">维保设备ID</th>
                                                                            
                                                  <th width="10%" param="{name:'deviceName'}">维保设备名称</th>
                                                                            
                                                  <th width="10%" param="{name:'planName'}">计划名称</th>

                                                  <th width="10%" param="{name:'contact'}">责任人</th>
                                                                            
                                                  <th width="10%" param="{name:'contactPhone'}">责任人联系方式</th>

                                                                            
                                                  <th width="10%" param="{name:'planStatus'}">计划状态</th>

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