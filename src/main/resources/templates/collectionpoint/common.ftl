<#--  采集点信息表公用页面-->
<#--  wcy 2019-03-19 11:10:52-->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>基本信息</legend>
</fieldset>
<div class="layui-form-item">
    <label class="layui-form-label">采集点名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="collectionPointName" maxlength="50" lay-verify="required"
               value="${(model.collectionPointName)!""}" placeholder="请输入采集点名称" class="layui-input">
    </div>
    <label class="layui-form-label">采集点类型<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="codeName:'monitorType',search:'true'" name="pointType" value="${(model.pointType)!""}" lay-verify="required"
             class="layui-input-normal"></div>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">上级采集点<span class="span_must">*</span></label>
    <input type="hidden" id="cyNodeType" name="cyNodeType" value="${(model.nodeType)!""}"/>
    <div class="layui-input-normal">
        <input value="${(model.concentratorId)!""}" id="concentratorId" cyType="treeTool"
               cyProps="url:'/encompany/sysJgTree?level=3&checkDisable=true&check=false&notClickLevel=2',name:'concentratorId',nodeTypeEm:'cyNodeType'"
               placeholder="请选择监测单位" class="layui-input"/>
    </div>
    <label class="layui-form-label">物理地址<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="phyaddr" maxlength="50" lay-verify="required"
               value="${(model.phyaddr)!""}" placeholder="请输入物理地址" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">虚拟地址<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="virtaddr" maxlength="50" lay-verify="required"
               value="${(model.virtaddr)!""}" placeholder="请输入虚拟地址" class="layui-input">
    </div>
    <label class="layui-form-label">采集点品牌<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="pointBrand" maxlength="50" lay-verify="required"
               value="${(model.pointBrand)!""}" placeholder="请输入采集点设备品牌" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">采集点型号<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="pointModel" maxlength="50" lay-verify="required"
               value="${(model.pointModel)!""}" placeholder="请输入采集点设备型号" class="layui-input">
    </div>
</div>