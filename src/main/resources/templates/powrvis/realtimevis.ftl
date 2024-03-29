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
        <div id="main" style="height: 400px" cyType="cyEcharts" cyProps="url:'/powerStitcs/powAtRealTime?pointIds=${pointIds}&compareTime=${compareTime}',title:'日电量',realflag:'true'"></div>
        <div class="layui-form">
            <table class="layui-table">
                <thead>
                    <tr>
                        <td>监测点名称</td>
                        <td>最大负荷</td>
                        <td>最大负荷发生时间</td>
                        <td>最小负荷</td>
                        <td>最小负荷发生时间</td>
                        <td>平均负荷</td>
                        <td>负荷率</td>
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
            url: '/powerStitcs/powAtTableData',
            data:{compareTime:compareTime,pointIds:pointIds},
            async: false,
            dataType: "json",
            success: function (R) {
                var data = R;
                console.info(data);
                if (R.code == 0) {
                    var htmlTr;
                    for (var i=0;i<data.enRealDataTableVos.length;i++){
                        htmlTr = htmlTr + "<tr>";
                        htmlTr = htmlTr + "<td>";
                        htmlTr = htmlTr + data.enRealDataTableVos[i].pointName;
                        htmlTr = htmlTr + "</td>";
                        htmlTr = htmlTr + "<td>";
                        htmlTr = htmlTr + data.enRealDataTableVos[i].maxValue + "Kw";
                        htmlTr = htmlTr + "</td>";
                        htmlTr = htmlTr + "<td>";
                        htmlTr = htmlTr + data.enRealDataTableVos[i].maxDataTime;
                        htmlTr = htmlTr + "</td>";
                        htmlTr = htmlTr + "<td>";
                        htmlTr = htmlTr + data.enRealDataTableVos[i].minValue + "Kw";
                        htmlTr = htmlTr + "</td>";
                        htmlTr = htmlTr + "<td>";
                        htmlTr = htmlTr + data.enRealDataTableVos[i].minDataTime;
                        htmlTr = htmlTr + "</td>";
                        htmlTr = htmlTr + "<td>";
                        htmlTr = htmlTr + data.enRealDataTableVos[i].avgVal + "Kw";
                        htmlTr = htmlTr + "</td>";
                        htmlTr = htmlTr + "<td>";
                        htmlTr = htmlTr + (data.enRealDataTableVos[i].dataPer*100) + "%";
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