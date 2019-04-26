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
        <div class="layui-card-body">
            <div id="treeview-checkable" class=""></div>
        </div>
    </div>
</div>

<script>
    $(function () {
        $.post("/encollectionpoint/getVisTreeViewData",function(da){
            console.info(da);
            $('#treeview-checkable').treeview({
                data:da,
                showIcon: true,
                levels: 0,
                showCheckbox: true,
                multiSelect: false,
                highlightSelected: true,
                showTags:true,
                onNodeChecked:function(event, node) {
                    Msg.info(node.text);
                },
                onNodeUnchecked:function (event, node) {
                    Msg.info(node.text);
                }
            });
        });
    })

</script>