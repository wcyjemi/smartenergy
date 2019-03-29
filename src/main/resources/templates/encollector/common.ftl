<#--  采集器信息表公用页面-->
<#--  chenyi 2019-03-25 20:59:22-->


              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">采集器名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="collectorName" maxlength="50" lay-verify="required"
                 value="${(model.collectorName)!""}"  placeholder="请输入采集器名称"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">采集器型号<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="collectorModel" maxlength="50" lay-verify="required"
                 value="${(model.collectorModel)!""}"  placeholder="请输入采集器型号"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">所属集中器<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="concentratorId" maxlength="11" lay-verify="required"
                 value="${(model.concentratorId)!""}"  placeholder="请输入所属集中器"  class="layui-input">
            </div>
        </div>



