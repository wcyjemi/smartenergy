<#--  chenyi 2019-03-19 11:10:52-->

<html>
<head>
    <title>采集点信息表修改页面</title>
    <link rel="stylesheet" href="/statics/plugins/layui2-4/css/layui.css" media="all">
    <#--<script src="/statics/plugins/layui/layui.js"></script>-->
    <#--<script src="/statics/plugins/layui2-4/layui.js"></script></head>-->
<body>
    <table class="layui-table" id="pointStandardSetTable" lay-filter="pointStandardSetTable">
    </table
</body>
<script src="/statics/plugins/layui2-4/layui.js"></script>
<script src="/statics/libs/jquery-1.10.2.min.js"></script>

<script>
    layui.use('table', function(){
        var table = layui.table;

        $.ajax({
            url: '/encollectionpoint/getPointStandard/${model.id}',
            async: false,
            type: 'post',
            dataType: "json",
            success: function (R) {
                if (R.code == 0) {

                    table.render({
                        elem:'#pointStandardSetTable',
                        data:R.data,
                        cols:[[
                            {field:'id',title:'ID'},
                            {field:'collectionPointId', title:'采集点ID', width:200, sort: true},
                            {field:'instructionName', title:'数据项名称', width:315, sort: true, edit: 'text'},
                            {field:'standardValueMin', title:'最低标准值', edit: 'text', width: 300},
                            {field:'standardValueMax', title:'最大标准值', width:300, edit: 'text'}
                        ]]
                    });
                } else {
                    data = {};
                    alert(R.msg);
                }
            }
        });

        //监听单元格编辑
        table.on('edit(pointStandardSetTable)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
        });
    });
</script>
</html>

