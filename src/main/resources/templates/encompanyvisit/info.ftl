<#--  wcy 2019-03-29 11:11:07-->

<html>
<head>
    <title>企业回访记录信息表详情页面</title>
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
            <label class="layui-label-left">企业ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.companyId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">回访时间<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.visitTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">回访人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.visitPerson)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">接待人<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.receptionist)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">回访方式<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.visitType)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">回访类容<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.visitContent)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">回访附件<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.visitFile)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createUser)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.createTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateUser)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.updateTime)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.delFlag)!"-"}</label>
        </div>
          </form>
</div>

</body>
</html>
