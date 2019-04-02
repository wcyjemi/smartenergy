<#--  chenyi 2019-03-25 20:59:22-->

<html>
<head>
    <title>采集器信息表详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">

              <div class="layui-form-item">
            <label class="layui-label-left">采集器名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.collectorName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">采集器型号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.collectorModel)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">所属集中器<span class="label_span">:</span></label>
            <label class="layui-label-right" >${(model.concentratorName)!"-" }</label>

          </form>
</div>

</body>
</html>
