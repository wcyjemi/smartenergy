<#--  wcy 2019-04-02 15:53:34-->
<!DOCTYPE html>
<html>
<head>
    <title>列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/enwarninginfo/js/list.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-sm12">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form " action="">
                        <div class="layui-form-item">
                            <label class="layui-form-label">数据项名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="instructionsName"  placeholder="请输入数据项名称" class="layui-input">
                            </div>

                            <label class="layui-form-label">方向</label>
                            <div cyType="selectTool" cyProps="codeName:'direction_type',search:'true'" name="directionType" value="" lay-verify=""
                                 class="layui-input-inline"></div>
                            <div class="layui-input-normal">
                                <!--
                                <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                                    <i class="fa fa-chevron-down">&nbsp;</i>更多
                                </button>
                                -->
                                <button class="layui-btn search-btn" table-id="enWarningInfoTable" lay-submit="" lay-filter="search">
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


                    </div>
                    <div class="layui-form ">
                        <table class="layui-table" id="enWarningInfoTable" cyType="pageGrid"
                               cyProps="url:'/enwarninginfo/listData',checkbox:'true',pageColor:'#2991d9'">
                            <thead>
                            <tr>
                                <!--复选框-->
                                <th width="1%" param="{type:'checkbox'}">
                                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                                </th>
                                                                                        <!--isPrimary：是否是主键-->
                                <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>

                                <th width="10%" param="{name:'instructionsName'}">数据项名称</th>
                                                                            
                                <th width="10%" param="{name:'currentValue'}">当前值</th>
                                                                            
                                <th width="10%" param="{name:'standardValue'}">标准值</th>
                                                                            
                                <th width="10%"  param="{name:'directionType',directionTypeName:'directionEnum',render:'Render.directionState'}">方向</th>
                                                                            
                                <th width="10%" param="{name:'differenceValue'}">差值</th>
                                                                            
                                <th width="10%" param="{name:'percentageValue'}">差值百分比</th>
                                                                                    <!--isPrimary：渲染列-->
                               <!--  <th width="10%" param="{name:'state',enumName:'StateEnum',render:'Render.customState'}">状态</th> -->
                                <th width="10%" param="{operate:'true',buttons:'Render.info'}">操作</th>
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