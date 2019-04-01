/**
 * Created by chenyi on 2017-10-20 13:54:57
 *  email   :  qq228112142@qq.com//
 */

/** 数据渲染对象 */
var Render = {
    /**
	 * 渲染状态列
	 * 
	 * @param rowdata 行数据
	 * @param index
	 * @param value
	 */
    customState: function (rowdata,renderData, index, value) {
        if(value == "1"){
            return '<span style="color:green">已上架</span>';
        }
        if(value == "0"){
            return '<span style="color:red">未上架</span>';
        }
        return value;
    },
    /**
	 * @param rowdata
	 *            行数据
	 * @state 状态值 1|0
	 * @description 详情按钮渲染
	 */
    info:function(rowdata,renderData){
        var btn=' <button onclick="detailOne(\''+"/encompany/info"+'\',\''+rowdata.id+'\')" class="layui-btn layui-btn-mini">详情</button>';
        return btn;
    },
    /**
	 * @param rowdata
	 *            行数据
	 * @state 状态值 1|0
	 * @description 修改按钮渲染
	 */
    edit:function(rowdata,renderData){
    	var btn = '';
    	if(hasupdateDepart){
    		btn=' <button onclick="editOne(\''+"/encompany/edit"+'\',\''+rowdata.id+'\')" class="layui-btn layui-btn-mini">修改</button>';
    	}
        return btn;
    },
    /**
	 * @param rowdata
	 *            行数据
	 * @state 状态值 1|0
	 * @description 删除按钮渲染
	 */
    delete:function(rowdata,renderData){
    	var btn = '';
    	if (hasdeleteDepart) {
    		btn='<button onclick="deleteOne(\''+"删除"+'\',\''+"/encompany/delete"+'\',\''+rowdata.id+'\')" class="layui-btn layui-btn-mini layui-btn-delete">删除</button>';
		}
        return btn;
    },
    /**
     * @param rowdata
     *            行数据
     * @description 查看回访记录渲染
     */
    recvist:function(rowdata,renderData){
        var btn = '';
        if (hasvistDepart) {
            btn='<button onclick="windowsFull(\''+"企业回访记录"+'\',\''+"/encompanyvisit/list"+'\',\''+rowdata.id+'\')" class="layui-btn layui-btn-mini layui-btn-danger">回访记录</button>';
        }
        return btn;
    },
    /**
	 * @param rowdata
	 *            行数据
	 * @state 状态值 1|0
	 * @description 启用禁用按钮渲染
	 */
    state:function(rowdata,renderData){
        if(renderData.state=='0'){
            return' <button onclick="updateStateOne(\''+"下架"+'\',\''+"/encompany/enable"+'\',\''+rowdata.id+'\')"' +
                '  class="layui-btn layui-btn-mini layui-btn-green">下架</button>';
        }
        if(renderData.state=='1'){
            return' <button  onclick="updateStateOne(\''+"上架"+'\',\''+"/encompany/limit"+'\',\''+rowdata.id+'\')" ' +
                'class="layui-btn layui-btn-mini layui-btn-danger">上架</button>';
        }
        return "";
    },
    /**
	 * @param rowdata
	 *            行数据
	 * @state 状态值 1|0
	 * @description 显示图片
	 */
    showimg:function(rowdata,renderData){
    	var uploadId = rowdata.companyLogo;
    	var imgPart = '';
        if(uploadId){
            $.ajax({
                type: "POST",  // 提交方式
                url: "/getData/getFile/" + uploadId,// 路径
                dataType: "json",
                async:false,
                success: function (result) {// 返回数据根据结果进行相应的处理
                    if (result.code == '0') {
                        var list = result.fileList;
                        for (var i = 0; i < list.length; i++) {
                            list[i].img= list[i].url;
                            if (list[i].fileType != "image") {
                                list[i].img = "/statics/img/notImg.png";
                            }
                            imgPart = imgPart + '<div class="float-left"> ' +
                                '<img src="' + list[i].img + '" class="layui-upload-img"> ' +
                                '</div>';
                        }

                    }
                }
            });
        }
        return imgPart;
    },
    dateFormat:function(rowdata,renderData,index, value){ // author: meizz
    	var date = new Date(value);
    	var fmt = 'yyyy-MM-dd hh:mm:ss';
      var o = {   
        "M+" : date.getMonth()+1,                 // 月份
        "d+" : date.getDate(),                    // 日
        "h+" : date.getHours(),                   // 小时
        "m+" : date.getMinutes(),                 // 分
        "s+" : date.getSeconds(),                 // 秒
        "q+" : Math.floor((date.getMonth()+3)/3), // 季度
        "S"  : date.getMilliseconds()             // 毫秒
      };   
      if(/(y+)/.test(fmt))   
        fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
      for(var k in o)   
        if(new RegExp("("+ k +")").test(fmt))   
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
      return fmt;   
    }
    
};
