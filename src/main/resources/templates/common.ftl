<link rel="stylesheet" href="/statics/css/bootstrap.min.css" media="all">
<script src="/statics/plugins/bootstrap-treeview/js/bootstrap-treeview.js"></script>
<style>
    .companyIcon{
        position: absolute;
        bottom:14px;
        right: 4px;
        width: 16px!important;
        height: 16px;
        background: url("/statics/img/sunny.png");
    }
    .pointIcon{
        position: absolute;
        bottom:14px;
        right: 4px;
        width: 16px!important;
        height: 16px;
        background: url("/statics/img/blizard.png");
    }
</style>

<div class="layui-col-sm2">
    <div class="layui-card">
        <div class="layui-card-header">
            采集点结构树
        </div>
        <div id="treeCardBody" class="layui-card-body">
            <div id="treeview-checkable" class=""></div>
        </div>
    </div>
</div>

<script>
    var pointIds = '';
    $(function () {
        $.post("/powerStitcs/getVisTreeViewData",function(da){
            $('#treeview-checkable').treeview({
                data:da,
                showIcon: true,
                levels: 0,
                showCheckbox: true,
                multiSelect: false,
                highlightSelected: true,
                showTags:true,
                onNodeChecked:function(event, node) {
                    getAllCheckedNodes();
                    Msg.info(node.text);
                },
                onNodeUnchecked:function (event, node) {
                    getAllCheckedNodes();
                    Msg.info(node.text);
                }
            });
            getAllCheckedNodes();
        });
    });

    function getAllCheckedNodes() {
        var ls = $('#treeview-checkable').treeview('getChecked');
        pointIds = '';
        for (var i = 0;i<ls.length;i++){
            if (ls[i].selectable) {
                if (pointIds == ''){
                    pointIds = pointIds + ls[i].id;
                }else {
                    pointIds = pointIds + "_" + ls[i].id;
                }
            }
        }
        var _baseurl = $(".layui-this").attr("data-url");;
        document.getElementById('tab-content-iframe').src = _baseurl + "?pointIds=" + pointIds;
    }
</script>