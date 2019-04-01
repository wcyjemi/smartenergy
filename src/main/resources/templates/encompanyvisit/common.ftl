<#--  企业回访记录信息表公用页面-->
<#--  wcy 2019-03-29 11:11:07-->
<div class="layui-form-item">
    <label class="layui-form-label">回访人<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="visitPerson" maxlength="50" lay-verify="required"
               value="${(model.visitPerson)!""}" placeholder="请输入回访人" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">接待人<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="receptionist" maxlength="50" lay-verify="required"
               value="${(model.receptionist)!""}" placeholder="请输入接待人" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">回访方式<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" name="visitType" maxlength="100" lay-verify="required"
               value="${(model.visitType)!""}" placeholder="请输入回访方式" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">回访类容<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <textarea name="visitContent" style="height:200px" lay-verify="required" class="layui-input">${(model.visitContent)!""}</textarea>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">回访附件</label>
    <div class="layui-input-normal">
        <div cyType="HuploadTool" cyProps="name:'visitFile',url:'/getData/uploads/',uploadId:'${(model.visitFile)!""}',multiple:'false',uploadDir:'visitFile',btnName:'上传文件',uploadBtn:'true',deleteBtn:'true'"></div>
    </div>
</div>