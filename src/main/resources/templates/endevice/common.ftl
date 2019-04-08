<#--  设备信息表公用页面-->
<script type="text/javascript" src="/endevice/js/edit.js"></script>
<#--  wcy 2019-04-05 17:14:19-->
              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">设备名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="deviceName" maxlength="50" lay-verify="required"
                 value="${(model.deviceName)!""}"  placeholder="请输入设备名称"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">设备编号<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="deviceNo" maxlength="50" lay-verify="required"
                 value="${(model.deviceNo)!""}"  placeholder="请输入设备编号"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">设备品牌<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="deviceBrand" maxlength="50" lay-verify="required"
                 value="${(model.deviceBrand)!""}"  placeholder="请输入设备品牌"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">设备型号<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="deviceModel" maxlength="50" lay-verify="required"
                 value="${(model.deviceModel)!""}"  placeholder="请输入设备型号"  class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">${(model.bucket)!""}

            <label class="layui-form-label">所属企业<span class="span_must">*</span></label>
            <div id="companyId" cyType="selectTool" maxlength="50"  cyProps="url:'/encompany/queryAll',search:'true'" name="companyId" value="${(model.companyId)!""}" lay-verify="" placeholder="请选择所属企业"
                 class="layui-input-inline"></div>

        </div>

        <div class="layui-form-item">${(model.bucket)!""}
        <div class="layui-form-item">
            <label class="layui-form-label">出厂日期<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input class="layui-input" value="${(model.productDate)!""}" placeholder="请输入出厂日期" id="applySt" name="productDate">
            </div>
        </div>

            <div class="layui-form-item">${(model.bucket)!""}
            <div class="layui-form-item">
                <label class="layui-form-label">安装日期<span class="span_must">*</span></label>
                <div class="layui-input-normal">
                    <input class="layui-input"  value="${(model.installDate)!""}" placeholder="请输入安装日期" id="applyEd" name="installDate">
                </div>
            </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">标称功率（kw）<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="nominalPower" maxlength="11,2" lay-verify="required"
                 value="${(model.nominalPower)!""}"  placeholder="请输入标称功率（kw）"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">设备状态<span class="span_must">*</span></label>
                  <div cyType="selectTool" cyProps="codeName:'device_status',search:'true'" name="deviceStatus"  value="${(model.deviceStatus)!""}" lay-verify=""
                       class="layui-input-inline" maxlength="50" ></div>
                  <div class="layui-input-normal">
        </div>





