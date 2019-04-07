<#--  wcy 2019-04-02 15:53:34-->

<html>
<head>
    <title>详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">

              <div class="layui-form-item">
            <label class="layui-label-left">数据项名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.instructionsName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">当前值<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.currentValue)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">标准值<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.standardValue)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">方向<span class="label_span">:</span></label>
            <label class="layui-label-right">

                <#if (model.directionType == '1')>
                    高于最大标准值
                <#else>
                    低于最小标准值
                </#if>

            </label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">差值<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.differenceValue)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left">差值百分比<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.percentageValue)!"-"}</label>
        </div>

          </form>
</div>

</body>
</html>
