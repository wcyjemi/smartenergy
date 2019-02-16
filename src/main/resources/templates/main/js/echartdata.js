/**
 * Created by wcy on 2019年1月10日09:54:44
 */
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