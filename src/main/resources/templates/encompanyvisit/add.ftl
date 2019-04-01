<#--  wcy 2019-03-29 11:11:07-->

<html>
<head>
    <title>企业回访记录信息表添加页面</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/encompanyvisit/js/edit.js"></script>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <input type="hidden" name="companyId"value="${(model.companyId)!""}">
        <div class="layui-form-item">
            <label class="layui-form-label">回访时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input id="visitTime" type="text" name="visitTime" maxlength="20" lay-verify="required"
                       value="" placeholder="请输入回访时间" class="layui-input">
            </div>
        </div>
        <#include "common.ftl"/>
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="layersubmit" data-url="/encompanyvisit/save"><i class="fa fa-floppy-o">&nbsp;</i>保存</button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
