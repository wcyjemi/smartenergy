<!DOCTYPE html>
<html>
<head>
    <title>管理员列表</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <input type="hidden" name="userId" value="${(model.userId?c)!""}">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名<span class="span_must">*</span></label>

            <label class="layui-label-right">${(model.username)!""}</label>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text" name="email" value="${(model.email)!""}" lay-verify="required|email" placeholder="请输入邮箱"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号<span class="span_must">*</span></label>
            <div class="layui-input-normal">
                <input type="text" name="mobile" value="${(model.mobile)!""}" lay-verify="required|phone" placeholder="请输入手机号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所属企业</label>
            <input type="hidden" value="${(companyIdList)!""}" name="companyIdsStr" id="companyIdsStr">
            <div cyType="selectTool" cyProps="url:'/encompany/queryAll',multiple:'false'"
                 value="${(companyIdList)!""}" name="companyIds[]" class="layui-input-normal"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所属部门</label>
            <div class="layui-input-normal">

                <input id="org"
                       cyType="treeTool" cyProps="url:'/organize/select',name:'orgId'"
                       value="${(model.orgId)!""}"   placeholder="请选择所属部门" class="layui-input"/>

            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所属角色</label>
            <input type="hidden" value="${(roleIdList)!""}" name="roleIdsStr" id="roleIdsStr">
            <div cyType="selectTool" cyProps="url:'/sys/role/findAll',multiple:'true'"
                 value="${(roleIdList)!""}" name="roleIdList[]" class="layui-input-normal"></div>
        </div>

		<#--<div class="layui-form-item">-->
            <#--<label class="layui-form-label">管理应用</label>-->
            <#--<input type="hidden" value="${(appIdList)!""}" name="appIdsStr" id="appIdsStr">-->
            <#--<div cyType="selectTool" cyProps="url:'/appinfo/findAll',multiple:'true'"-->
                <#--value="${(appIdList)!""}" name="appIdList[]" class="layui-input-normal"></div>-->
        <#--</div>-->
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="status"
                 value="${(model.status)!""}" class="layui-input-inline"></div>
        </div>
        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/sys/user/update"><i
                            class="fa fa-floppy-o">&nbsp;</i>保存
                    </button>
                    <button class="layui-btn" onclick="$t.closeWindow();"><i class="fa fa-undo">&nbsp;</i>返回</button>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use('form',function () {
        var form = layui.form();
        form.render();
        //下拉事件监控
        form.on('checkbox(searchChecked)',function (data) {
            var roleIdsStr = "";
            var companyIdsStr = "";
            var roleIdsArr = $("#roleIdsStr").val().split(',');
            var companyIdsArr = $("#companyIdsStr").val().split(',');
            var _dataname = data.elem.name;
            if (_dataname == 'roleIdList[]') {
                if (data.elem.checked){
                    roleIdsArr.removeElem(data.elem.value);
                    roleIdsArr.push(data.elem.value);
                    for (var i=0;i<roleIdsArr.length;i++){
                        if (roleIdsArr[i] != '') {
                            roleIdsStr = roleIdsStr + roleIdsArr[i] +",";
                        }
                    }
                    $("#roleIdsStr").val(roleIdsStr);
                }else{
                    roleIdsArr.removeElem(data.elem.value);
                    for (var i=0;i<roleIdsArr.length;i++){
                        if (roleIdsArr[i] != '') {
                            roleIdsStr = roleIdsStr + roleIdsArr[i] +",";
                        }
                    }
                    $("#roleIdsStr").val(roleIdsStr);
                }
            }else{
                if (data.elem.checked){
                    companyIdsArr.removeElem(data.elem.value);
                    companyIdsArr.push(data.elem.value);
                    for (var i=0;i<companyIdsArr.length;i++){
                        if (companyIdsArr[i] != '') {
                            companyIdsStr = companyIdsStr + companyIdsArr[i] +",";
                        }
                    }
                    $("#companyIdsStr").val(companyIdsStr);
                }else{
                    companyIdsArr.removeElem(data.elem.value);
                    for (var i=0;i<companyIdsArr.length;i++){
                        if (companyIdsArr[i] != '') {
                            companyIdsStr = companyIdsStr + companyIdsArr[i] +",";
                        }
                    }
                    $("#companyIdsStr").val(companyIdsStr);
                }
            }
            return false;
        });

    })
</script>
</body>
</html>
