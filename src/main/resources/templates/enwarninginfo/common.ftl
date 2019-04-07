<#--  公用页面-->
<#--  wcy 2019-04-02 15:53:34-->

        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">数据项<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="instructionsName" maxlength="50" lay-verify="required"
                 value="${(model.instructionsName)!""}"  placeholder="请输入数据项名称"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">当前值<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="currentValue" maxlength="11,2" lay-verify="required"
                 value="${(model.currentValue)!""}"  placeholder="请输入当前值"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">标准值<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="standardValue" maxlength="11,2" lay-verify="required"
                 value="${(model.standardValue)!""}"  placeholder="请输入标准值"  class="layui-input">
            </div>
        </div>







