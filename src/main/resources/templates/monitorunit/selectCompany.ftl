<!DOCTYPE html>
<html>
<head>
    <title>选择企业</title>
<#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form">
        <div class="layui-form-item">
            <label class="layui-form-label">选择企业</label>
            <input type="hidden" value="" name="companyId" id="companyId" lay-verify="required">
            <div id="companyIds" cyType="selectTool" cyProps="url:'/encompany/queryAll',search:'true',filter:'companyIdSelect'" name="companyIds" value="${(model.companyId)!""}" lay-verify="required"
                 class="layui-input-normal"></div>
        </div>
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button type="button" class="layui-btn" onclick="subSelectCompany()"><i class="fa fa-floppy-o">&nbsp;</i>提交</button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use('form',function () {
        var form = layui.form();
        form.render();
        //下拉事件监控
        form.on('select(companyIdSelect)',function (data) {
            var companyId = data.value;
            $("#companyId").val(companyId);
            return false;
        });

    })
    function subSelectCompany(){
        var companyId = $("#companyId").val();
        console.info(companyId);
        if (companyId==''){
            Msg.error("请选择企业！");
            return;
        }
        parent.layer.closeAll();
        parent.layer.open({
            type: 2,
            title: '添加监测单位',
            shadeClose: false,
            shade: [0.3, '#000'],
            area: ['800px','600px'],
            maxmin: true, //开启最大化最小化按钮
            content: '/enmonitorunit/add?companyId='+companyId
        });

        // $.ajax({
        //     type: "post",
        //     url: url,
        //     contentType: "application/json",
        //     data: JSON.stringify({"companyId":companyId}),
        //     async: false,
        //     dataType:"json",
        //     success: function (R) {
        //         if (R.code === 0) {
        //             parent.layer.closeAll();
        //
        //         } else {
        //             parent.layer.msg(R.msg, {icon: 5});
        //         }
        //     },
        //     error: function () {
        //         parent.layer.msg("系统繁忙", {icon: 5});
        //     }
        // });
    }
</script>

</body>
</html>

