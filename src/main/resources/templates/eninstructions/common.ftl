<#--  数据项信息公用页面-->
<#--  wcy 2019-04-03 10:42:59-->
              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">指令<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="instructions" maxlength="50" lay-verify="required"
                 value="${(model.instructions)!""}"  placeholder="请输入指令"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">指令名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="instructionsName" maxlength="100" lay-verify="required"
                 value="${(model.instructionsName)!""}"  placeholder="请输入指令名称"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">指令类型<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <div cyType="selectTool" cyProps="codeName:'monitorType',search:'true'" name="instructionsType" value="${(model.instructionsType)!""}" lay-verify="required"
                     class="layui-input-normal"></div>
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">数据项单位<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="instructionsUnit" maxlength="50" lay-verify="required"
                 value="${(model.instructionsUnit)!""}"  placeholder="请输入数据项单位"  class="layui-input">
            </div>
        </div>


