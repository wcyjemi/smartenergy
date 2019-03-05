
<div class="layui-form-item">
    <label class="layui-form-label">应用名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="appName" name="appName" value="${(model.appName)!""}" lay-verify="required"
               placeholder="请输入应用名称" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">英文名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="appEnname" name="appEnname" value="${(model.appEnname)!""}" lay-verify="en"
               placeholder="请输入应用英文名称" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">应用图标</label>
    <div class="layui-input-normal" id="appIconDiv">
    	<div cyType="HuploadTool" cyProps="name:'appIcon',url:'/getData/uploads/',uploadId:'${(model.appIcon)!""}',multiple:'false',uploadDir:'appicon',btnName:'上传文件',uploadBtn:'true',deleteBtn:'true'"></div>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">应用简介<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <textarea name="appIntr" lay-verify="required"
               placeholder="请输入应用简介" maxlength="500" class="layui-textarea">${(model.appIntr)!""}</textarea>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">应用状态<span class="span_must">*</span></label>
    <div cyType="radioTool" cyProps="enumName:'AppStatusEnum'"
         name="appStatus" value="${(model.appStatus)!"1"}" class="layui-input-normal">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-normal">
        <textarea name="remark" placeholder="请输入备注"
               maxlength="500" class="layui-textarea">${(model.remark)!""}</textarea>
    </div>
</div>
