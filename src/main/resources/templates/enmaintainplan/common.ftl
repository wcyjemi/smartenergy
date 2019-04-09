<#--  设备维保计划公用页面-->
<#--  wcy 2019-04-07 18:35:07-->
<script type="text/javascript" src="/enmaintainplan/js/edit.js"></script>
              <div class="layui-form-item">${(model.bucket)!""}

                  <label class="layui-form-label">维保设备<span class="span_must">*</span></label>
                  <div id="deviceId" cyType="selectTool" maxlength="255"  cyProps="url:'/endevice/listAllData',search:'true'" name="deviceId" value="${(model.deviceId)!""}" lay-verify="" placeholder="请选择所属企业"
                       class="layui-input-inline"></div>

        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">计划名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="planName" maxlength="255" lay-verify="required"
                 value="${(model.planName)!""}"  placeholder="请输入计划名称"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">计划开始时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="planSt" maxlength="20" lay-verify="required" id = "applySt"
                 value="${(model.planSt)!""}"  placeholder="请输入计划开始时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">计划结束时间<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="panEd" maxlength="20" lay-verify="required"  id = "applyEd"
                 value="${(model.panEd)!""}"  placeholder="请输入计划结束时间"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">责任人<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="contact" maxlength="50" lay-verify="required"
                 value="${(model.contact)!""}"  placeholder="请输入责任人"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">责任人联系方式<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="contactPhone" maxlength="11" lay-verify="required"
                 value="${(model.contactPhone)!""}"  placeholder="请输入责任人联系方式"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">维保反馈信息<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="maintRs" maxlength="500" lay-verify="required"
                 value="${(model.maintRs)!""}"  placeholder="请输入维保反馈信息"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">维保反馈附件<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="maintFile" maxlength="255" lay-verify="required"
                 value="${(model.maintFile)!""}"  placeholder="请输入维保反馈附件"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
                  <label class="layui-form-label">计划状态<span class="span_must">*</span></label>
                  <div cyType="selectTool" cyProps="codeName:'plan_status',search:'true'" name="planStatus"  value="${(model.planStatus)!""}" lay-verify=""
                       class="layui-input-inline" maxlength="255" ></div>
                  <div class="layui-input-normal">
        </div>

