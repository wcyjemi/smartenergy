<#--  wcy 2019-04-07 18:35:07-->

<html>
<head>
    <title>设备维保计划详情页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">

              <div class="layui-form-item">
            <label class="layui-label-left">维保设备ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.deviceId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">维保设备名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.deviceName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">计划名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.planName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">计划开始时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.planSt)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">计划结束时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.panEd)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">责任人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.contact)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">责任人联系方式<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.contactPhone)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">维保反馈信息<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.maintRs)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">维保反馈附件<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.maintFile)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">计划状态<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.planStatus)!"-"}</label>
        </div>

          </form>
</div>

</body>
</html>
