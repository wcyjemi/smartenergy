<#--  wcy 2019-04-03 10:42:59-->
<!DOCTYPE html>
<html>
<head>
    <title>数据项信息列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/eninstructions/js/list.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form " action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">指令名称:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="instructionsName"  placeholder="请输入名称" class="layui-input">
                            </div>

                            <label class="layui-form-label">指令类型</label>
                            <div class="layui-input-normal">
                                <div cyType="selectTool" cyProps="codeName:'monitorType',search:'true'" name="instructionsType"  lay-verify="required"
                                     class="layui-input-normal"></div>
                            </div>

                            <div class="layui-input-normal">
                                <!--
                                <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                                    <i class="fa fa-chevron-down">&nbsp;</i>更多
                                </button>
                                -->
                                <button class="layui-btn search-btn" table-id="enInstructionsTable" lay-submit="" lay-filter="search">
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
                            <@shiro.hasPermission name="eninstructions:save">
                            <button class="layui-btn" onclick="addPage('/eninstructions/add')">
                                <i class="fa fa-plus">&nbsp;</i>增加
                            </button>
                            </@shiro.hasPermission>
                            <@shiro.hasPermission name="eninstructions:update">
                            <button class="layui-btn" onclick="editPage('enInstructionsTable','/eninstructions/edit')">
                                <i class="fa fa-pencil-square-o">&nbsp;</i>修改
                            </button>
                            <!--
                             <button class="layui-btn layui-btn-green" onclick="updateState('批量启用','enInstructionsTable','/eninstructions/enable')">
                                <i class="fa fa-check-square-o">&nbsp;</i>启用
                            </button>
                            <button class="layui-btn  layui-btn-danger" onclick="updateState('批量禁用','enInstructionsTable','/eninstructions/limit')">
                                <i class="fa fa-expeditedssl">&nbsp;</i>禁用
                            </button>
                            -->
                            </@shiro.hasPermission>
                            <@shiro.hasPermission name="eninstructions:delete">
                             <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','enInstructionsTable','/eninstructions/delete');">
                                <i class="fa fa-trash-o">&nbsp;</i>删除
                            </button>
                            </@shiro.hasPermission>

                    </div>
                        <div class="layui-form ">
                        <table class="layui-table" id="enInstructionsTable" cyType="pageGrid"
                               cyProps="url:'/eninstructions/listData',checkbox:'true',pageColor:'#2991d9'">
                            <thead>
                            <tr>
                                <!--复选框-->
                                <th width="1%" param="{type:'checkbox'}">
                                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                                </th>
                                                                                        <!--isPrimary：是否是主键-->
                                <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>
                                
                                <th width="10%" param="{name:'instructions'}">指令</th>
                                                                            
                                <th width="10%" param="{name:'instructionsName'}">指令名称</th>
                                                                            
                                <th width="10%" param="{name:'instructionsType',enumName:'instructionsEnum',render:'Render.updateType'}">指令类型</th>
                                                                            
                                <th width="10%" param="{name:'instructionsUnit'}">数据项单位</th>
                                                                                    <!--isPrimary：渲染列-->
                                <!-- <th width="10%" param="{name:'state',enumName:'StateEnum',render:'Render.customState'}">状态</th>-->
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