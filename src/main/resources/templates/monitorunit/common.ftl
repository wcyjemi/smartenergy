
<input type="hidden" name="companyId" value="${(model.companyId)!""}"/>
<div class="layui-form-item">
    <label class="layui-form-label">上级建筑<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input value="${(model.parentId)!""}" id="parent" cyType="treeTool" cyProps="url:'/enmonitorunit/select?companyId=${(model.companyId)!""}',name:'parentId'"
               placeholder="请选择监测单位" class="layui-input"/>
        <#--<input value="${(model.parentId)!""}" id="parent" cyType="treeTool" cyProps="url:'/encompany/sysJgTree?level=3&checkDisable=true&check=false',name:'parentId'"-->
               <#--placeholder="请选择监测单位" class="layui-input"/>-->
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">建筑名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="monitorUnitName" name="monitorUnitName" value="${(model.monitorUnitName)!""}" lay-verify="required"
        placeholder="请输入监测单位名称" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">监测类型<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="codeName:'monitorType',search:'true'" name="monitorType" value="${(model.monitorType)!""}" lay-verify="required"
             class="layui-input-normal"></div>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">排序<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="sort" name="sort" value="${(model.sort)!""}" lay-verify="required|number"
               placeholder="请输入应用英文名称" maxlength="50" class="layui-input">
    </div>
</div>
