<!DOCTYPE html>
<html>
<head>
    <title>能源分析</title>
    <#include "../resource_new.ftl"/>
</head>
<body>
<div class="layui-card">
    <div class="layui-card-body">
        <div id="main" style="height: 600px" cyType="cyEcharts" cyProps="url:'/powerStitcs/powAtRealTime?pointIds=${pointIds}&beginTime=&endTime=',title:'日电量',realflag:'true'"></div>
    </div>
</div>
<script src="/statics/plugins/echarts/echarts4.js"></script>
<script src="/common/js/whole/cyEcharts.js"></script>
</body>
</html>