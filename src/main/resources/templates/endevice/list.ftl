<#--  wcy 2019-04-05 17:14:19-->
<!DOCTYPE html>
<html>
<head>
    <title>设备信息表列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/endevice/js/list.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form " action="">

                        <div class="layui-form-item">

                            <label class="layui-form-label">设备名称:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="deviceName"  placeholder="请输入设备名称" class="layui-input">
                            </div>

                            <label class="layui-form-label">公司名称:</label>
                            <div class="layui-input-inline">
                                <input type="text" name="companyName"  placeholder="请输入公司名称" class="layui-input">
                            </div>

                            <label class="layui-form-label">设备状态</label>
                            <div cyType="selectTool" cyProps="codeName:'device_status',search:'true'" name="deviceStatus"  lay-verify=""
                                 class="layui-input-inline" >
                            </div>

                            <div class="layui-input-normal">
                                <button class="layui-btn search-btn" table-id="enDeviceTable" lay-submit="" lay-filter="search">
                                    <i class="fa fa-search">&nbsp;</i>查询
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary"><i class="fa fa-refresh">&nbsp;</i>重置</button>

                            </div>
                        </div>
                            <!--

                        <div class="layui-form-item more-search">
                           <#-- 更多条件-->
                        </div>
                                    -->
                    </form>

                    <div class="layui-btn-group">
                            <@shiro.hasPermission name="endevice:save">
                            <button class="layui-btn" onclick="addPage('/endevice/add')">
                                <i class="fa fa-plus">&nbsp;</i>增加
                            </button>
                            </@shiro.hasPermission>

                            <@shiro.hasPermission name="endevice:update">
                            <button class="layui-btn" onclick="editPage('enDeviceTable','/endevice/edit')">
                                <i class="fa fa-pencil-square-o">&nbsp;</i>修改
                            </button>
                            </@shiro.hasPermission>

                            <@shiro.hasPermission name="endevice:delete">
                             <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','enDeviceTable','/endevice/delete');">
                                <i class="fa fa-trash-o">&nbsp;</i>删除
                            </button>
                            </@shiro.hasPermission>

                    </div>

                    <div class="layui-form ">
                        <table class="layui-table" id="enDeviceTable" cyType="pageGrid"
                               cyProps="url:'/endevice/listData',checkbox:'true',pageColor:'#2991d9'">
                            <thead>
                            <tr>
                                <!--复选框-->
                                <th width="1%" param="{type:'checkbox'}">
                                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                                </th>
                                                                                        <!--isPrimary：是否是主键-->
                                <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>

                                <th width="10%" param="{name:'deviceName'}">设备名称</th>
                                                                            
                                <th width="10%" param="{name:'deviceNo'}">设备编号</th>
                                                                            
                                <th width="10%" param="{name:'deviceBrand'}">设备品牌</th>
                                                                            
                                <th width="10%" param="{name:'deviceModel'}">设备型号</th>

                                <th width="10%" param="{name:'companyName'}">所属公司</th>

                                <th width="10%" param="{name:'nominalPower'}">标称功率（kw）</th>
                                                                                    <!--isPrimary：渲染列-->
                                <th width="10%" param="{name:'deviceStatus',enumName:'DeviceStateEnum',render:'Render.deviceStatus'}">设备状态</th>
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