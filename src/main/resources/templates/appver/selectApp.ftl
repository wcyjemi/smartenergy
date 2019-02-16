<!DOCTYPE html>
<html>
<head>
    <title>选择应用</title>
<#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">选择应用</label>
            <input type="hidden" value="" name="appId" id="appId">
            <div cyType="selectTool" cyProps="url:'/appinfo/findAll?hasSysUser=1&appStatus=1',multiple:'false',filter:'appIdSelect'"
                 value="" name="appIds" class="layui-input-normal"></div>
        </div>
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button type="button" class="layui-btn" onclick="subSelectApp('/appver/verfiyapp')"><i class="fa fa-floppy-o">&nbsp;</i>提交</button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="/appver/js/edit.js"></script>
<script>
    layui.use('form',function () {
        var form = layui.form();
        form.render();
        //下拉事件监控
        form.on('select(appIdSelect)',function (data) {
            var appId = data.value;
            $("#appId").val(appId);
            return false;
        });

    })
</script>

</body>
</html>

