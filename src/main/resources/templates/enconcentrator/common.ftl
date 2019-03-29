<#--  集中器信息表公用页面-->
<#--  zwg 2019-03-28 14:44:28-->


              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">集中器名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="concentratorName" maxlength="50" lay-verify="required"
                 value="${(model.concentratorName)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">集中器型号<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="concentratorModel" maxlength="50" lay-verify="required"
                 value="${(model.concentratorModel)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">所属单位<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="monitorUnitId" maxlength="11" lay-verify="required"
                 value="${(model.monitorUnitId)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">地址<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="address" maxlength="255" lay-verify="required"
                 value="${(model.address)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">服务器地址<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="serviceHost" maxlength="50" lay-verify="required"
                 value="${(model.serviceHost)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">时间校验地址<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="timeCheck" maxlength="50" lay-verify="required"
                 value="${(model.timeCheck)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

