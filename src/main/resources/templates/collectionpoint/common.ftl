<#--  采集点信息表公用页面-->
<#--  chenyi 2019-03-19 11:10:52-->
            <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="id" maxlength="11" lay-verify="required"
                 value="${(model.id)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">采集点名称<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="collectionPointName" maxlength="50" lay-verify="required"
                 value="${(model.collectionPointName)!""}"  placeholder="请输入采集点名称"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">物理地址<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="phyaddr" maxlength="50" lay-verify="required"
                 value="${(model.phyaddr)!""}"  placeholder="请输入物理地址"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">虚拟地址<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="virtaddr" maxlength="50" lay-verify="required"
                 value="${(model.virtaddr)!""}"  placeholder="请输入虚拟地址"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">所属集中器ID<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="concentratorId" maxlength="11" lay-verify="required"
                 value="${(model.concentratorId)!""}"  placeholder="请输入所属集中器ID"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">采集点类型：1、电 2、水 3、气 4、其他<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="pointType" maxlength="1" lay-verify="required"
                 value="${(model.pointType)!""}"  placeholder="请输入采集点类型：1、电 2、水 3、气 4、其他"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">采集点设备品牌<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="pointBrand" maxlength="50" lay-verify="required"
                 value="${(model.pointBrand)!""}"  placeholder="请输入采集点设备品牌"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label">采集点设备型号<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="pointModel" maxlength="50" lay-verify="required"
                 value="${(model.pointModel)!""}"  placeholder="请输入采集点设备型号"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="createUser" maxlength="11" lay-verify="required"
                 value="${(model.createUser)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="createTime" maxlength="20" lay-verify="required"
                 value="${(model.createTime)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="updateUser" maxlength="11" lay-verify="required"
                 value="${(model.updateUser)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="updateTime" maxlength="20" lay-verify="required"
                 value="${(model.updateTime)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">${(model.bucket)!""}
            <label class="layui-form-label"><span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text"  name="delFlag" maxlength="1" lay-verify="required"
                 value="${(model.delFlag)!""}"  placeholder="请输入"  class="layui-input">
            </div>
        </div>

              <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="state"
                 value="${(model.state)!"1"}" class="layui-input-inline"></div>
        </div>