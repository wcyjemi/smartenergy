<!DOCTYPE html>
<html>
<head>
    <title>管理员列表</title>
    <#include "../resource.ftl"/>
</head>
<body>
<div class="layui-field-box">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-normal">
                <input type="text" name="username" value="" lay-verify="required|username" placeholder="请输入用户名"
                      autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-normal">
                <input type="text" name="email" value="" lay-verify="required|email"  placeholder="请输入邮箱" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-normal">
                <input type="text" name="mobile" value="" lay-verify="required|phone" placeholder="请输入手机号" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">所属部门</label>
            <div class="layui-input-normal">

                <input value="" id="demo"
                       cyType="treeTool" cyProps="url:'/organize/select',name:'orgId'"
                       placeholder="请选择所属部门" class="layui-input"/>

            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">所属角色</label>
            <input type="hidden" value="" name="roleIdsStr" id="roleIdsStr">
            <div cyType="selectTool" cyProps="url:'/sys/role/findAll',multiple:'true'"
                value="" name="roleIdList[]" class="layui-input-normal"></div>
        </div>
        
        <div class="layui-form-item">
            <label class="layui-form-label">管理应用</label>
            <input type="hidden" value="" name="appIdsStr" id="appIdsStr">
            <div cyType="selectTool" cyProps="url:'/appinfo/findAll',multiple:'true'"
                value="" name="appIdList[]" class="layui-input-normal"></div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div cyType="radioTool" cyProps="enumName:'StateEnum'" name="status"
                 value="1" class="layui-input-inline"></div>
        </div>

        <div class="page-footer">
            <div class="btn-list">
                <div class="btnlist">
                    <button class="layui-btn" lay-submit="" lay-filter="submit" data-url="/sys/user/save"><i
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
            var appIdsStr = "";
            var roleIdsArr = $("#roleIdsStr").val().split(',');
            var appIdsArr = $("#appIdsStr").val().split(',');
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
                    appIdsArr.removeElem(data.elem.value);
                    appIdsArr.push(data.elem.value);
                    for (var i=0;i<appIdsArr.length;i++){
                        if (appIdsArr[i] != '') {
                            appIdsStr = appIdsStr + appIdsArr[i] +",";
                        }
                    }
                    $("#appIdsStr").val(appIdsStr);
                }else{
                    appIdsArr.removeElem(data.elem.value);
                    for (var i=0;i<appIdsArr.length;i++){
                        if (appIdsArr[i] != '') {
                            appIdsStr = appIdsStr + appIdsArr[i] +",";
                        }
                    }
                    $("#appIdsStr").val(appIdsStr);
                }
            }
            return false;
        });

    })
</script>
</body>

</html>
