<!DOCTYPE html>
<html>
<head>
    <title>能源分析</title>
    <#include "../resource_new.ftl"/>
    <style>
        html{
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-card">
    <div class="layui-card-body">
        <input type="hidden" id="compareTime" value="${(compareTime)!""}"/>
        <input type="hidden" id="pointIds" value="${(pointIds)!""}"/>
        <div id="main" style="height: 400px" cyType="cyEcharts" cyProps="url:'/powerStitcs/elecRealTime?pointIds=${pointIds}&compareTime=${compareTime}',title:'日电量',realflag:'true'"></div>
        <div class="layui-form">
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>序号</th>
                        <th>时间</th>
                        <th>电量</th>
                    </tr>
                </thead>
                <tbody id="dataTb">
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="/statics/plugins/echarts/echarts4.js"></script>
<script src="/common/js/whole/cyEcharts.js"></script>
<script>
    var compareTime = $("#compareTime").val();
    var pointIds = $("#pointIds").val();
    function getTableData() {
        $.ajax({
            url: '/powerStitcs/elecTableData',
            data:{compareTime:compareTime,pointIds:pointIds},
            async: false,
            dataType: "json",
            success: function (R) {
                var data = R;
                if (R.code == 0) {
                    var htmlTr;
                    for (var i=0;i<data.elecBaseDataList.length;i++){
                        htmlTr = htmlTr + "<tr>";
                        htmlTr = htmlTr + "<td>";
                        htmlTr = htmlTr + i;
                        htmlTr = htmlTr + "</td>";
                        htmlTr = htmlTr + "<td>";
                        htmlTr = htmlTr + $t.dateFormat(data.elecBaseDataList[i].dataTime);
                        htmlTr = htmlTr + "</td>";
                        htmlTr = htmlTr + "<td>";
                        htmlTr = htmlTr + data.elecBaseDataList[i].eleFa + "Kwh";
                        htmlTr = htmlTr + "</td>";
                        htmlTr = htmlTr + "</tr>";
                    }
                    $("#dataTb").html("");
                    $("#dataTb").html(htmlTr);
                    console.info(htmlTr);
                } else {
                    alert(R.msg);
                }
            }
        });
    }
    $(function () {
        getTableData();
        window.setInterval(function (){getTableData()},300000);
    })
</script>
</body>
</html>