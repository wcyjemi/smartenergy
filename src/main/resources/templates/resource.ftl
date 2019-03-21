<script src="/statics/libs/jquery-1.10.2.min.js"></script>
<#--<script src="/statics/libs/jquery.js"></script>-->
<link rel="stylesheet" href="/statics/css/font-awesome.min.css">
<!--layui ztree样式-->
<link rel="stylesheet" href="/statics/plugins/layui/css/layui.css" media="all">
<link rel="stylesheet" href="/statics/plugins/layui2-4/css/layui.css" media="all">
<script src="/statics/plugins/layer/layer.js"></script>
<script src="/statics/plugins/layui/layui.js"></script>
<#--<script type="text/javascript" src="/statics/plugins/layui2-4/layui.js"></script>-->
<script src="/statics/plugins/ztree/jquery.ztree.all.min.js"></script>
<link rel="stylesheet" href="/statics/plugins/ztree/css/metroStyle/metroStyle.css">
<!--js组件-->
<script src="/common/js/pageGrid.js"></script>
<script src="/common/js/selectTool.js"></script>
<script src="/common/js/radioTool.js"></script>
<script src="/common/js/checkboxTool.js"></script>
<script src="/common/js/treeTool.js"></script>
<script src="/common/js/labelTool.js"></script>
<script src="/common/js/linkSelectTool.js"></script>
<script src="/common/js/uploadTool.js"></script>
<script src="/common/js/HuploadTool.js"></script>
<script src="/common/js/tplTool.js"></script>
<script src="/common/js/editGrid.js"></script>
<!--全局-->
<script src="/common/js/whole/cyLayer.js"></script>
<script src="/common/js/whole/common.js"></script>
<script src="/common/js/whole/setting.js"></script>
<script src="/common/js/whole/utils.js"></script>
<script src="/common/js/whole/monitor.js"></script>
<!--样式-->
<link rel="stylesheet" href="/common/css/cyStyle.css">
<link rel="stylesheet" href="/common/css/cyType.css">
<link rel="stylesheet" href="/common/css/yfdc.css">
<link rel="stylesheet" href="/common/css/public.css">
<!--日期-->
<script src="/statics/plugins/My97DatePicker/WdatePicker.js" type="text/javascript" charset="utf-8"></script>
<script src="/statics/plugins/My97DatePicker/duceap.date.js" type="text/javascript" charset="utf-8"></script>
<!--上传-->
<script src="/statics/plugins/Huploadify/jquery.Huploadify.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="/statics/plugins/Huploadify/Huploadify.css">
<!--Bootstrap select-->
<#--<link rel="stylesheet" href="/statics/css/bootstrap.min.css">-->
<#--<link rel="stylesheet" href="/statics/plugins/bootstrap-select/dist/css/bootstrap-select.min.css">-->
<#--<script src="/statics/libs/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>-->
<#--<script src="/statics/plugins/bootstrap-select/dist/js/bootstrap-select.min.js" type="text/javascript" charset="utf-8"></script>-->

<script>
    function imgOpenView(obj){
        var url=$(obj).attr("src");
        console.info($(obj));
        var img = new Image();
        img.src = url;
        img.onerror = function(){
            Msg.error("找不到图片");
            setTimeout("parent.layer.closeAll()",3000);
            return;
        };
        var height=0;
        var width=0;
        if(img.complete){
            height=img.height;
            width=img.width;
        }else{
            img.onload = function(){
                height=img.height;
                width=img.width;
                img.onload=null;//避免重复加载
            }
        }
        parent.layer.open({
            type: 1,                   //类型 1页面 2iframe
            title:"",
            shadeClose: false,         //是否关闭遮罩
            shade: [0.3, '#000'],      //遮罩
            maxmin: false,              //开启最大化最小化按钮
            area: [ width+"px",height+"px"],
            content: '<img src="'+url+'">'
        });
    }
</script>

