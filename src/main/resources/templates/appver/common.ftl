
<div class="layui-form-item">
    <label class="layui-form-label">应用图标<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div class="float-left">
            <img onload="getAppFileUrl(this,'/getData/getFile/${(model.appIcon)!""}')" src="/statics/img/notImg.png" class="layui-upload-img">
        </div>
    </div>
</div>

<input type="hidden" name="appId" value="${(model.appId)!""}">
<input type="hidden" name="appEnname" value="${(model.appEnname)!""}">

<div class="layui-form-item">
    <label class="layui-form-label">应用名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="appName" name="appName" value="${(model.appName)!""}" lay-verify="required" readonly="readonly"
               placeholder="请输入应用名称" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">应用类型<span class="span_must">*</span></label>
    <div cyType="radioTool" cyProps="codeName:'appType'"
         name="appType" value="${(model.appType)!"1"}" class="layui-input-normal">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">版本号<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="appOutverno" name="appOutverno" value="${(model.appOutverno)!""}" lay-verify="required"
               placeholder="请输入版本号" maxlength="50" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">内部版本号<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="appInnerverno" name="appInnerverno" value="${(model.appInnerverno)!""}" lay-verify="number"
               placeholder="请输入内部版本号" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">版本更新信息<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <textarea name="appUpdcms" lay-verify="required"
                  placeholder="请输入更新内容" maxlength="500" class="layui-textarea">${(model.appUpdcms)!""}</textarea>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">上传文件</label>
    <div class="layui-input-normal" id="appUrlDiv">
    	<div cyType="HuploadTool" cyProps="name:'appUrl',url:'/getData/uploads/',uploadId:'${(model.appUrl)!""}',multiple:'false',uploadDir:'${(model.appEnname)!''}',btnName:'上传文件',uploadBtn:'true',deleteBtn:'true'"></div>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">版本状态<span class="span_must">*</span></label>
    <div cyType="radioTool" cyProps="codeName:'appforce'"
         name="appStatus" value="${(model.appStatus)!"1"}" class="layui-input-normal">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">发布状态<span class="span_must">*</span></label>
    <div cyType="radioTool" cyProps="codeName:'appPubstatus'"
         name="appPubstatus" value="${(model.appPubstatus)!"0"}" class="layui-input-normal">
    </div>
</div>
