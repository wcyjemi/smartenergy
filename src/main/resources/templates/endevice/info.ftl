<#--  wcy 2019-04-05 17:14:19-->

<html>
<head>
    <title>设备信息表详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">

              <div class="layui-form-item">
            <label class="layui-label-left">设备名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.deviceName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">设备编号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.deviceNo)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">设备品牌<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.deviceBrand)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">设备型号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.deviceModel)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">所属企业ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.companyId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">出厂日期<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.productDate)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">安装日期<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.installDate)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">标称功率（kw）<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.nominalPower)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">设备状态<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.deviceStatus)!"-"}</label>
        </div>

          </form>
</div>

</body>
</html>
