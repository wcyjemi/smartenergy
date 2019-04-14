<#--  chenyi 2019-03-19 11:10:52-->

<html>
<head>
    <title>采集点信息表修改页面</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
        <input type="hidden" name="id" value="${model.id}">
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>基本信息</legend>
        </fieldset>
        <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">采集点名称:</span></label>
            <label class="layui-label-right">${(model.collectionPointName)!""}</label>
            <label class="layui-label-left"><span class="label_span">物理地址:</span></label>
            <label class="layui-label-right">${(model.phyaddr)!""}</label>
            <label class="layui-label-left"><span class="label_span">虚拟地址:</span></label>
            <label class="layui-label-right">${(model.virtaddr)!""}</label>
            <#--<label class="layui-form-label">采集点名称<span class="span_must">*</span></label>-->
            <#--<div class="layui-input-normal">-->
                <#--<input type="text" name="collectionPointName" maxlength="50" lay-verify="required"-->
                       <#--value="${(model.collectionPointName)!""}" placeholder="请输入采集点名称" class="layui-input">-->
            <#--</div>-->
            <#--<label class="layui-form-label">物理地址<span class="span_must">*</span></label>-->
            <#--<div class="layui-input-normal">-->
                <#--<input type="text" name="phyaddr" maxlength="50" lay-verify="required"-->
                       <#--value="${(model.phyaddr)!""}" placeholder="请输入物理地址" class="layui-input">-->
            <#--</div>-->
        </div>
        <div class="layui-form-item">

            <label class="layui-label-left"><span class="label_span">所属集中器:</span></label>
            <label class="layui-label-right">${(model.concentratorName)!""}</label>
            <#--<div class="layui-input-normal">-->
                <#--<input type="text" name="virtaddr" maxlength="50" lay-verify="required"-->
                       <#--value="${(model.virtaddr)!""}" placeholder="请输入虚拟地址" class="layui-input">-->
            <#--</div>-->
            <#--<label class="layui-form-label">所属集中器<span class="span_must">*</span></label>-->
            <#--<div class="layui-input-normal">-->
                <#--<input value="${(model.concentratorId)!""}" id="concentratorId" cyType="treeTool" cyProps="url:'/encompany/sysJgTree?level=2&checkDisable=true&check=false',name:'concentratorId'"-->
                       <#--placeholder="请选择监测单位" class="layui-input"/>-->
            <#--</div>-->
            <label class="layui-label-left"><span class="label_span">采集点类型:</span></label>
            <label class="layui-label-right">${(model.pointLabel)!""}</label>
            <label class="layui-label-left"><span class="label_span">采集点品牌:</span></label>
            <label class="layui-label-right">${(model.pointBrand)!""}</label>

            <#--<label class="layui-form-label">采集点类型<span class="span_must">*</span></label>-->
            <#--<div class="layui-input-normal">-->
                <#--<div cyType="selectTool" cyProps="codeName:'monitorType',search:'true'" name="pointType" value="${(model.pointType)!""}" lay-verify="required"-->
                     <#--class="layui-input-normal"></div>-->
            <#--</div>-->
            <#--<label class="layui-form-label">采集点品牌<span class="span_must">*</span></label>-->
            <#--<div class="layui-input-normal">-->
                <#--<input type="text" name="pointBrand" maxlength="50" lay-verify="required"-->
                       <#--value="${(model.pointBrand)!""}" placeholder="请输入采集点设备品牌" class="layui-input">-->
            <#--</div>-->
        </div>

        <div class="layui-form-item">
            <label class="layui-label-left"><span class="label_span">采集点型号:</span></label>
            <label class="layui-label-right">${(model.pointModel)!""}</label>

            <#--<label class="layui-form-label">采集点型号<span class="span_must">*</span></label>-->
            <#--<div class="layui-input-normal">-->
                <#--<input type="text" name="pointModel" maxlength="50" lay-verify="required"-->
                       <#--value="${(model.pointModel)!""}" placeholder="请输入采集点设备型号" class="layui-input">-->
            <#--</div>-->
        </div>

        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>标准值配置</legend>
        </fieldset>
    <form id="setForm" class="layui-form" action="">
        <#list data as record>
            <input type="hidden" name="enPoinstandardsets[${record_index}].id" value="${(record.id)!""}"/>
            <input type="hidden" name="enPoinstandardsets[${record_index}].collectionPointId" value="${(record.collectionPointId)!""}"/>
            <input type="hidden" name="enPoinstandardsets[${record_index}].instructionsId" value="${(record.instructionsId)!""}"/>
            <div class="layui-form-item">
                <label class="layui-form-label">数据项名称<span class="span_must">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="enPoinstandardsets[${record_index}].instructionName" maxlength="50" lay-verify="required"
                           value="${(record.instructionName)!""}" placeholder="请输入采集点设备品牌" class="layui-input" readonly="readonly">
                </div>
                <label class="layui-form-label">最低标准值<span class="span_must">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="enPoinstandardsets[${record_index}].standardValueMin" maxlength="50" lay-verify="required"
                           value="${(record.standardValueMin)!""}" placeholder="请输入采集点设备品牌" class="layui-input">
                </div>
                <label class="layui-form-label">最大标准值<span class="span_must">*</span></label>
                <div class="layui-input-inline">
                    <input type="text" name="enPoinstandardsets[${record_index}].standardValueMax" maxlength="50" lay-verify="required"
                           value="${(record.standardValueMax)!""}" placeholder="请输入采集点设备品牌" class="layui-input">
                </div>
            </div>
        </#list>
        <#--<table class="layui-table" lay-data="{url:'/encollectionpoint/getPointStandard/${model.id}',height: '360px', cellMinWidth: 80, id:'pointStandardSetTable'}" lay-filter="pointStandardSetTable">-->
        <#--<thead>-->
        <#--<tr>-->
        <#--<th lay-data="{field:'id'}">id</th>-->
        <#--<th lay-data="{field:'collectionPointId', width:200, sort: true}">采集点ID</th>-->
        <#--<th lay-data="{field:'instructionName', width:315, sort: true, edit: 'text'}">数据项名称</th>-->
        <#--<th lay-data="{field:'standardValueMin', edit: 'text', width: 300}">最低标准值</th>-->
        <#--<th lay-data="{field:'standardValueMax', width:300, edit: 'text'}">最大标准值</th>-->
        <#--</tr>-->
        <#--</thead>-->
        <#--</table-->
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="standarSetsubmit" data-url="/encollectionpoint/standarSetSave"><i class="fa fa-floppy-o">&nbsp;</i>保存</button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>

</div>
</body>
<#--<script src="/statics/plugins/layui2-4/layui.js"></script>-->

<script>
    // layui.use('table', function(){
    //     var table = layui.table;
    //
    //     //监听单元格编辑
    //     table.on('edit(pointStandardSetTable)', function(obj){
    //         var value = obj.value //得到修改后的值
    //             ,data = obj.data //得到所在行所有键值
    //             ,field = obj.field; //得到字段
    //         layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
    //     });
    // });

    //保存或修改
    layui.use(['form'], function () {
        var form = layui.form();
        //监听提交
        form.on('submit(standarSetsubmit)', function (data) {
            var url=$(this).attr("data-url");
            $.ajax({
                url: url,
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(data.field),
                async: false,
                dataType: "json",
                success: function (R) {
                    if (R.code == 0) {
                        $t.Refresh();
                        //刷新页面
                        parent.layer.msg('操作成功 !', {icon: 1});
                    } else {
                        parent.layer.msg(R.msg, {icon: 5});
                    }
                },
                error: function () {
                    alert("系统繁忙");
                }
            });
            return false;
        });
    });


    function standarSetTemplate(id,collectionPointId,instructionsId,instructionName,standardValueMin,standardValueMax){
        var standarSet = new Object();
        standarSet.id = id;
        standarSet.collectionPointId = collectionPointId;
        standarSet.instructionsId = instructionsId;
        standarSet.instructionName = instructionName;
        standarSet.standardValueMin = standardValueMin;
        standarSet.standardValueMax = standardValueMax;
        return standarSet;
    }
</script>
</html>

