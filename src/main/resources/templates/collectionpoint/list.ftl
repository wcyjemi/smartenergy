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
                            <label class="layui-form-label">名称:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="" placeholder="请输入名称" class="layui-input">
                            </div>
                            <div class="layui-input-normal">
                                <button class="layui-btn search-btn" table-id="enCollectionPointTable" lay-submit=""
                                        lay-filter="search">
                                    <i class="fa fa-search">&nbsp;</i>查询
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary"><i
                                            class="fa fa-refresh">&nbsp;</i>重置
                                </button>
                            </div>
                        </div>
                    </form>
                    <div class="layui-btn-group">
                        <@shiro.hasPermission name="encollectionpoint:save">
                            <button class="layui-btn" onclick="addPageAare('/encollectionpoint/add','新增采集点',1200,800)">
                                <i class="fa fa-plus">&nbsp;</i>增加
                            </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="encollectionpoint:update">
                            <button class="layui-btn"
                                    onclick="editPage('enCollectionPointTable','/encollectionpoint/edit')">
                                <i class="fa fa-pencil-square-o">&nbsp;</i>修改
                            </button>
                            <script>
                                hasupdateDepart = true;
                            </script>
                            <button class="layui-btn layui-btn-green"
                                    onclick="updateState('批量启用','enCollectionPointTable','/encollectionpoint/enable')">
                                <i class="fa fa-check-square-o">&nbsp;</i>启用
                            </button>
                            <button class="layui-btn  layui-btn-danger"
                                    onclick="updateState('批量禁用','enCollectionPointTable','/encollectionpoint/limit')">
                                <i class="fa fa-expeditedssl">&nbsp;</i>禁用
                            </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="encollectionpoint:delete">6
                            <button class="layui-btn layui-btn-delete"
                                    onclick="deleteBatch('批量删除','enCollectionPointTable','/encollectionpoint/delete');">
                                <i class="fa fa-trash-o">&nbsp;</i>删除
                            </button>
                            <script>
                                hasdeleteDepart = true;
                            </script>
                        </@shiro.hasPermission>
                    </div>
                    <div class="layui-form">
                        <table class="layui-table" id="enCollectionPointTable" cyType="pageGrid"
                               cyProps="url:'/encollectionpoint/listData',checkbox:'true',pageColor:'#2991d9'">
                            <thead>
                            <tr>
                                <!--复选框-->
                                <th width="1%" param="{type:'checkbox'}">
                                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                                </th>
                                <!--isPrimary：是否是主键-->
                                <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>


                                <th width="10%" param="{name:'collectionPointName'}">采集点名称</th>

                                <th width="10%" param="{name:'phyaddr'}">物理地址</th>

                                <th width="10%" param="{name:'virtaddr'}">虚拟地址</th>

                                <th width="10%" param="{name:'concentratorId'}">所属集中器ID</th>

                                <th width="10%" param="{name:'pointType'}">采集点类型</th>

                                <th width="10%" param="{name:'pointBrand'}">采集点设备品牌</th>

                                <th width="10%" param="{name:'pointModel'}">采集点设备型号</th>

                                <th width="10%"
                                    param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete,Render.setstandard'}">操作
                                </th>
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