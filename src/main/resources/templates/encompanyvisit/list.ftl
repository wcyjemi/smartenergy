<#--  wcy 2019-03-29 11:11:07-->
<!DOCTYPE html>
<html>
<head>
    <title>企业回访记录信息表列表</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/encompanyvisit/js/list.js"></script>
</head>
<body>
<div class="layui-fluid">
    <#--<div class="layui-row layui-col-space15">-->
        <#--<div class="layui-col-sm12">-->
            <#--<div class="layui-card">-->
                <#--<div class="layui-card-body">-->
    <form class="layui-form " action="">
        <div class="layui-form-item">
            <input type="hidden" name="companyId" value="${companyId}"/>
            <label class="layui-form-label">回访人:</label>
            <div class="layui-input-inline">
                <input type="text" name="visitPerson"  placeholder="请输入回访人" class="layui-input">
            </div>

            <div class="layui-input-normal">
                <!--
                <button class="layui-btn layui-btn-green" lay-submit="" lay-filter="moreSearch">
                    <i class="fa fa-chevron-down">&nbsp;</i>更多
                </button>
                -->
                <button class="layui-btn search-btn" table-id="enCompanyVisitTable" lay-submit="" lay-filter="search">
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
            <button class="layui-btn" onclick="addPage('/encompanyvisit/add?companyId=${companyId}')">
                <i class="fa fa-plus">&nbsp;</i>增加
            </button>
            <button class="layui-btn" onclick="editPage('enCompanyVisitTable','/encompanyvisit/edit')">
                <i class="fa fa-pencil-square-o">&nbsp;</i>修改
            </button>
             <button class="layui-btn layui-btn-delete" onclick="deleteBatch('批量删除','enCompanyVisitTable','/encompanyvisit/delete');">
                <i class="fa fa-trash-o">&nbsp;</i>删除
            </button>
    </div>
    <div class="layui-form ">
        <table class="layui-table" id="enCompanyVisitTable" cyType="pageGrid"
               cyProps="url:'/encompanyvisit/listData?companyId=${companyId}',checkbox:'true',pageColor:'#2991d9'">
            <thead>
            <tr>
                <!--复选框-->
                <th width="1%" param="{type:'checkbox'}">
                    <input type="checkbox" lay-skin="primary" lay-filter="allChoose">
                </th>
                <!--isPrimary：是否是主键-->
                <th width="10%" param="{name:'id',isPrimary:'true',hide:'true'}"></th>

                <th width="10%" param="{name:'visitTime',render:'Render.dateFormat'}">回访时间</th>

                <th width="10%" param="{name:'visitPerson'}">回访人</th>

                <th width="10%" param="{name:'receptionist'}">接待人</th>

                <th width="10%" param="{name:'visitType'}">回访方式</th>

                <th width="10%" param="{name:'visitContent'}">回访类容</th>

                <!--isPrimary：渲染列-->
                <th width="10%" param="{operate:'true',buttons:'Render.state,Render.edit,Render.delete'}">操作</th>
            </tr>
            </thead>
        </table>
    </div>
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
</div>
</body>
</html>