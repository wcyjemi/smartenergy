
<div class="layui-form-item">
    <label class="layui-form-label">企业名称<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="companyName" name="companyName" value="${(model.companyName)!""}" lay-verify="required"
               placeholder="请输入企业名称" maxlength="50" class="layui-input">
    </div>

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
    <label class="layui-form-label">法人电话<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="companyFrPhone" name="companyFrPhone" value="${(model.companyFrPhone)!""}" lay-verify="required|phone"
               placeholder="请输入联系方式" maxlength="50" class="layui-input">
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">企业类型<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="codeName:'companyType',search:'true'" name="companyType" value="${(model.companyType)!""}" lay-verify="required"
             class="layui-input-normal"></div>
    </div>
    <label class="layui-form-label">用电容量<span class="span_must">*</span></label>
    <div class="layui-inline">
        <div class="layui-input-normal">
            <input type="text" id="companyCapacity" name="companyCapacity" value="${(model.companyCapacity?c)!""}" lay-verify="required"
                   placeholder="请输入用电容量" maxlength="50" class="layui-input">
        </div>
        <div class="layui-form-mid">Kw</div>
    </div>
</div>

<div class="layui-form-item">
    <label class="layui-form-label">联系人<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="companyContact" name="companyContact" value="${(model.companyContact)!""}" lay-verify="required"
               placeholder="请输入联系人" maxlength="50" class="layui-input">
    </div>
    <label class="layui-form-label">联系人电话<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="contactPhone" name="contactPhone" value="${(model.contactPhone)!""}" lay-verify="required|phone"
               placeholder="请输入联系方式" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">所在地区<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="linkSelectTool" cyProps="url:'/area/normalList/',topId:'0000000000',name:'companyAreaIds[]',value:'${(model.companyAreapath)!""}'"
             value="${(model.companyAreapath)!""}" class="layui-input-inline formitem-inline-select"></div>
    </div>
    <label class="layui-form-label">详细地址<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <input type="text" id="companyAddress" name="companyAddress" value="${(model.companyAddress)!""}" lay-verify="required"
               placeholder="请输入详细地址" maxlength="50" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">缴费类型<span class="span_must">*</span></label>
    <div class="layui-input-normal">
        <div cyType="selectTool" cyProps="codeName:'companyPayType',search:'true'" name="payType" value="${(model.payType)!""}" lay-verify="required"
             class="layui-input-normal"></div>
    </div>
    <label class="layui-form-label">经纬度<span class="span_must">*</span></label>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <input type="text" id="companyLo" name="companyLo" value="${(model.companyLo)!""}" lay-verify="required"
                   placeholder="经度" maxlength="50" class="layui-input" readonly="readonly">
        </div>
        <div class="layui-input-inline">
            <input type="text" id="companyLa" name="companyLa" value="${(model.companyLa)!""}" lay-verify="required"
                   placeholder="纬度" maxlength="50" class="layui-input" readonly="readonly">
        </div>
        <div class="layui-form-mid">
            <a href="javascript:void(0); " onclick="openIframeHasBtn('地图','index/map?objId=${(model.id)!""}&la=${(model.companyLa)!""}&lo=${(model.companyLo)!""}','companyLa','companyLo')">
                <i class="fa fa-map-marker">&nbsp;</i>
            </a>
            <#--<button type="button"  class="layui-btn layui-btn-primary" onclick="openIframeHasBtn('地图','index/map?objId=${(model.id)!""}&la=32.727396&lo=118.727396','companyLa','companyLo')"></button>-->
        </div>
        <#--<button type="button"  class="layui-btn layui-btn-primary" onclick="openIframeHasBtn('地图','index/map?objId=${(model.id)!""}&la=${(model.companyLa)!""}&lo=${(model.companyLo)!""}','companyLa','companyLo')"><i class="fa fa-refresh">&nbsp;</i></button>-->
    </div>
</div>
