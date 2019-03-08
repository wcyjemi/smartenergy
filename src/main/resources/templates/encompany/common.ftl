
<div class="layui-form-item">
    <label class="layui-form-label">企业名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="companyName" name="companyName" value="${(model.companyName)!""}" lay-verify="required"
               placeholder="请输入企业名称" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">企业LOGO</label>
    <div class="layui-input-normal" id="appIconDiv">
        <div cyType="HuploadTool" cyProps="name:'companyLogo',url:'/getData/uploads/',uploadId:'${(model.companyLogo)!""}',multiple:'false',uploadDir:'companylogo',btnName:'上传文件',uploadBtn:'true',deleteBtn:'true'"></div>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">企业简称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="companyShortname" name="companyShortname" value="${(model.companyShortname)!""}" lay-verify="required"
               placeholder="请输入企业简称" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">英文名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="companyEname" name="companyEname" value="${(model.companyEname)!""}" lay-verify="en"
               placeholder="请输入应用英文名称" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">企业法人<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="companyFr" name="companyFr" value="${(model.companyFr)!""}" lay-verify="required"
               placeholder="请输入企业法人" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">联系人<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="companyContact" name="companyContact" value="${(model.companyContact)!""}" lay-verify="required"
               placeholder="请输入联系人" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">联系方式<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="contactPhone" name="contactPhone" value="${(model.contactPhone)!""}" lay-verify="required|phone"
               placeholder="请输入联系方式" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">所在地区<span class="span_must">*</span></label>
    <div class="layui-input-inline" style="width:420px;">
        <div cyType="linkSelectTool" cyProps="url:'/area/normalList/',topId:'0000000000',name:'companyAreaIds[]',value:'${(model.companyAreapath)!""}'"
             value="${(model.companyAreapath)!""}" class="layui-input-inline"></div>

    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">详细地址<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="companyAddress" name="companyAddress" value="${(model.companyAddress)!""}" lay-verify="required"
               placeholder="请输入详细地址" maxlength="50" class="layui-input">
    </div>
</div>
