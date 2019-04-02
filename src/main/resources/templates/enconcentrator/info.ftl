<#--  zwg 2019-03-28 14:44:28-->

<html>
<head>
<title>集中器信息表详情页面</title>
<#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">

        <#--  <div class="layui-form-item">
        <label class="layui-label-left" hidden="true"><span class="label_span" hidden="true"></span></label>
        <label class="layui-label-right" hidden="true">${(model.id)!"-"}</label>
        </div>-->

        <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">集中器名称:</span></label>
            <label class="layui-label-right">${(model.concentratorName)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">集中器型号:</span></label>
            <label class="layui-label-right">${(model.concentratorModel)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">所属单位:</span></label>
            <label class="layui-label-right">${(model.monitorUnitName)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">地址:</span></label>
            <label class="layui-label-right">${(model.address)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">服务器地址:</span></label>
            <label class="layui-label-right">${(model.serviceHost)!"-"}</label>
        </div>
        <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">时间校验地址:</span></label>
            <label class="layui-label-right">${(model.timeCheck)!"-"}</label>
        </div>

    </form>
</div>

</body>
</html>
