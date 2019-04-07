<#--  wcy 2019-04-03 10:42:59-->

<html>
<head>
    <title>数据项信息详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
             <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.id)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">指令<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.instructions)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">指令名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.instructionsName)!"-"}</label>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">指令类型<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <div cyType="selectTool" cyProps="codeName:'monitorType',search:'true'" name="instructionsType" value="${(model.instructionsType)!""}" lay-verify="required"
                     class="layui-input-normal"></div>
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-label-left">数据项单位<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.instructionsUnit)!"-"}</label>
        </div>

          </form>
</div>

</body>
</html>
