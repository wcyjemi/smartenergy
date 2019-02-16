<!DOCTYPE html>
<html>
<head>
    <title>应用管理</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="/appver/js/edit.js"></script>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <#include "common.ftl"/>
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/appver/save"><i class="fa fa-floppy-o">&nbsp;</i>保存</button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
