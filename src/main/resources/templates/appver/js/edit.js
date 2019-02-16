function subSelectApp(url){
    var appId = $("#appId").val();
    $.ajax({
        type: "post",
        url: url,
        contentType: "application/json",
        data: JSON.stringify({"appId":appId}),
        async: false,
        dataType:"json",
        success: function (R) {
            if (R.code === 0) {
                parent.layer.closeAll();
                parent.layer.open({
                    type: 2,
                    title: '添加',
                    shadeClose: false,
                    shade: [0.3, '#000'],
                    area: ['800px','600px'],
                    maxmin: true, //开启最大化最小化按钮
                    content: 'appver/add?appId='+appId
                });
            } else {
                parent.layer.msg(R.msg, {icon: 5});
            }
        },
        error: function () {
            parent.layer.msg("系统繁忙", {icon: 5});
        }
    });
}

function getAppFileUrl(obj,url) {
    $.ajax({
        type: "POST",  // 提交方式
        url: url,// 路径
        dataType: "json",
        success: function (result) {// 返回数据根据结果进行相应的处理
            if (result.code == '0') {
                var list = result.fileList;
                if(list.length>0){
                    obj.src = list[0].url;
                }
                obj.onload=null;
            }
        }
    });
}