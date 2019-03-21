<#--  chenyi 2019-03-19 11:10:52-->

<html>
<head>
    <title>采集点信息表详情页面</title>
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
            <label class="layui-label-left">采集点名称<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.collectionPointName)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">物理地址<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.phyaddr)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">虚拟地址<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.virtaddr)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">所属集中器ID<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.concentratorId)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">采集点类型：1、电 2、水 3、气 4、其他<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.pointType)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">采集点设备品牌<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.pointBrand)!"-"}</label>
        </div>
              <div class="layui-form-item">
            <label class="layui-label-left">采集点设备型号<span class="label_span">:</span></label>
            <label class="layui-label-right">${(model.pointModel)!"-"}</label>
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
