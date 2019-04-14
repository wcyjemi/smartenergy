<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>企业序列号申请</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/encompany/js/edit.js"></script>
    <link rel="stylesheet" href="/statics/plugins/layui2-4/css/layui.css" media="all">
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <input type="hidden" name="id" value="${(model.id)!""}">
        <div class="layui-form-item">
            <label class="layui-form-label">序列类型<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <div cyType="radioTool" cyProps="codeName:'seriType',filter:'seriType'" name="keyType"
                     value="1" class="layui-input-inline"></div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">开始时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input class="layui-input" placeholder="开始时间" id="applySt" name="keySttime">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">结束时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input class="layui-input" placeholder="结束时间" id="applyEd" name="keyEdtime">
            </div>
        </div>
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/encompany/generateSeri"><i class="fa fa-floppy-o">&nbsp;</i>保存</button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
