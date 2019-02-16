<html>
<head>
    <title>系统首页</title>
    <#include "../resource.ftl"/>
    <link rel="stylesheet" href="/statics/css/layui-admin.css">
    <link rel="stylesheet" href="/statics/plugins/layui2-4/css/layui.css" media="all">
    <#--<script type="text/javascript" src="/statics/plugins/layui2-4/layui.js"></script>-->
    <link type="text/css" rel="stylesheet" href="/statics/plugins/raty/demo/css/application.css">
    <script type="text/javascript" src="/statics/plugins/raty/lib/jquery.raty.min.js"></script>
    <script type="text/javascript" src="/main/js/echartdata.js"></script>
</head>
<body>
    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-sm2">
                <#list appList as app>
                    <div class="layui-card">
                        <div class="layui-card-header">
                            <h3>${(app.appName)!""}
                                <#if app.appType == '1'>
                                    <i class="fa fa-android"></i>
                                </#if>
                                <#if app.appType == '2'>
                                    <i class="fa fa-apple"></i>
                                </#if>
                            </h3>
                            <a href="javascript:void(0);" id="aa_1" onmouseover="aMOverOn(this,${(app.id)!""})" onmouseout="aMOut(this,${(app.id)!""})">
                                <i class="layui-inline layui-icon layui-icon-download-circle"></i>
                            </a>
                        </div>
                        <div class="layui-card-body layuiadmin-card-list">
                            <div class="layui-row layui-col-space15">
                                <div class="layui-col-sm6" id="icon_${(app.id)!""}">
                                    <img width="115" height="115" onload="getAppFileUrl(this,'/getData/getFile/${(app.appIcon)!""}')" onerror="this.src='/statics/img/notImg.png'" src="/statics/img/noImg.png">
                                </div>
                                <div class="layui-col-sm6" id="count_${(app.id)!""}">
                                    <p class="layuiadmin-big-font" style="margin-top:30;padding-left: 20px">
                                        ${(app.appUpdcount)!"0"}
                                    </p>
                                </div>
                                <div class="layui-col-sm12" id="downqr_${(app.id)!""}" style="display: none;position: absolute;left: 0;padding-left:28%;padding-right:28%;background-color: #615a5a59;">
                                    <img width="115" onload="getAppFileUrl(this,'/getData/getFile/${(app.appQr)!""}')" onerror="this.src='/statics/img/notImg.png'" src="/statics/img/noImg.png">
                                </div>
                                <div class="layui-col-sm12">
                                    <p>
                                        评分：
                                        <span class="layuiadmin-span-color">
                                            <div id="rate_${(app.id)!""}"></div>
                                            <script>
                                                $('#rate_'+${(app.id)!""}).raty({
                                                    half: true,
                                                    readOnly: true,
                                                    score: 3,
                                                    starHalf:'/statics/plugins/raty/lib/img/star-half.png',
                                                    starOff:'/statics/plugins/raty/lib/img/star-off.png',
                                                    starOn:'/statics/plugins/raty/lib/img/star-on.png'
                                                });
                                            </script>
                                        </span>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>

            </div>
            <div class="layui-col-sm10">
                <div class="layui-card">
                    <div class="layui-card-header">
                        <h3>统计信息</h3>
                    </div>
                    <div class="layui-card-body">
                        <div class="layui-row">
                            <div class="layui-col-sm6">
                                <div id="main" style="height: 600px;"></div>
                            </div>
                            <div class="layui-col-sm6">
                                <div id="main2" style="height: 600px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="/statics/plugins/echarts/echarts4.js"></script>
<script type="text/javascript">

    $(function () {
        getDayUpdData();
        appZbPie();
    });
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    // 指定图表的配置项和数据
    function getDayUpdData() {
        myChart.showLoading();
        $.ajax({
            type: "POST",  // 提交方式
            url: "/statics/stcUpdCountByDay",// 路径
            dataType: "json",
            success: function (result) {// 返回数据根据结果进行相应的处理
                var data = result.resultData;
                if (result.code == '0') {
                    var option = {
                        title: {
                            text: '应用每日更新量'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data:data.legendData
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        toolbox: {
                            feature: {
                                saveAsImage: {}
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: data.xAxisData
                        },
                        yAxis: {
                            show:false,
                            type: 'value'
                        },
                        series: data.seriesArray
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                    myChart.hideLoading();
                }
            }
        });
    }
    // 基于准备好的dom，初始化echarts实例
    var myChart2 = echarts.init(document.getElementById('main2'));

    // 指定图表的配置项和数据


    function appZbPie() {
        myChart2.showLoading();
        $.ajax({
            type: "POST",  // 提交方式
            url: "/statics/appZbPie",// 路径
            dataType: "json",
            success: function (result) {// 返回数据根据结果进行相应的处理
                var lends = result.lends;
                var data = result.data;
                if (result.code == '0') {
                    var option = {
                        title : {
                            text: '应用更新总量占比',
                            x:'center'
                        },
                        tooltip : {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            data: lends
                        },
                        series : [
                            {
                                name: '应用更新总量占比',
                                type: 'pie',
                                radius : '55%',
                                center: ['50%', '60%'],
                                data:data,
                                itemStyle: {
                                    emphasis: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart2.setOption(option);
                    myChart2.hideLoading();
                }
            }
        });
    }
    function aMOverOn(obj,v){
        $("#downqr_"+v).css("display","block");
    }
    function aMOut(obj,v) {
        $("#downqr_"+v).css("display","none");
    }

</script>
</html>