<html>
<head>
    <title>系统首页</title>
    <#include "../resource.ftl"/>
    <link rel="stylesheet" href="/statics/css/layui-admin.css">
    <link rel="stylesheet" href="/statics/plugins/layui2-4/css/layui.css" media="all">
    <#--<script type="text/javascript" src="/statics/plugins/layui2-4/layui.js"></script>-->
    <#--<link type="text/css" rel="stylesheet" href="/statics/plugins/raty/demo/css/application.css">-->
    <#--<script type="text/javascript" src="/statics/plugins/raty/lib/jquery.raty.min.js"></script>-->
    <script type="text/javascript" src="/main/js/echartdata.js"></script>
</head>
<body>
    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-sm6 layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-header">企业数</div>
                    <div class="layui-card-body layuiadmin-card-list">
                        <a class="cy-page" href="javascript:;" data-url="/encompany/list" title="企业信息">
                            <p class="layuiadmin-big-font">60</p>
                            <p>总接入企业数<span class="layuiadmin-span-color"><i class="layui-inline layui-icon layui-icon-user"></i></span></p>
                        </a>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm6 layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-header">采集点数</div>
                    <div class="layui-card-body layuiadmin-card-list">
                        <a class="cy-page" href="javascript:;" data-url="/encollectionpoint/list" title="采集点管理">
                            <p class="layuiadmin-big-font">60</p>
                            <p>总接入采集点数<span class="layuiadmin-span-color"><i class="layui-inline layui-icon layui-icon-website"></i></span></p>
                        </a>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm6 layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-header">预警数</div>
                    <div class="layui-card-body layuiadmin-card-list">
                        <a class="cy-page" href="javascript:;" data-url="/enwarninginfo/list" title="预警信息">
                            <p class="layuiadmin-big-font">60</p>
                            <p>总预警数<span class="layuiadmin-span-color"><i class="layui-inline layui-icon layui-icon-404"></i></span></p>
                        </a>
                    </div>
                </div>
            </div>
            <div class="layui-col-sm6 layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-header">企业数</div>
                    <div class="layui-card-body layuiadmin-card-list">
                        <a class="cy-page" href="javascript:;" data-url="/encompany/list" title="企业信息">
                            <p class="layuiadmin-big-font">60</p>
                            <p>总接入企业数<span class="layuiadmin-span-color"><i class="layui-inline layui-icon layui-icon-user"></i></span></p>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-row layui-col-space15">
            <div class="layui-col-sm12 layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header">日电量</div>
                    <div class="layui-card-body layuiadmin-card-list">
                        <div id="main" style="height: 600px" cyType="cyEcharts" cyProps="url:'/getData/getCompanyData',title:'日电量'"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="/statics/plugins/echarts/echarts4.js"></script>
<script src="/common/js/whole/cyEcharts.js"></script>
<script type="text/javascript">

    $("a.cy-page").on("click",function () {
        var $this = $(this);
        var name = $this.attr("title");
        var url = unescape($this.attr("data-url")) || "";
        if ($("#navTab").find("li[data-url='" + url + "']").length === 0) {
            //判断该页面是否已存在
            console.log( $("#navTab",window.parent.document).find("li"));
            var index = Loading.open(1,false);
            //如果不存在
            $("#navTab",window.parent.document).find("li").removeClass("selected");
            //新增tab页
            var _li = ['<li tabid="tools-utils" class="selected" data-url="' + url + '">',
                '<a href="javascript:" title="' + name + '" class="tools-utils">',
                '<span>' + name + '</span>',
                '</a>',
                '<a href="javascript:;" class="close">close</a>',
                '</li>'].join("");
            $("#navTab",window.parent.document).find("ul").append(_li);
            //新增右侧更多list
            $(".tabsMoreList",window.parent.document).find("li").removeClass("selected");
            var moreli = '<li class="selected" data-url="'+url+'"><a href="javascript:"  title="' + name + '">' + name + '</a></li>';
            $(".tabsMoreList",window.parent.document).append(moreli);

            $(".content",window.parent.document).find("iframe").removeClass("cy-show");
            //打开iframe
            var iframe = $('<iframe class="cy-show" scrolling="yes" frameborder="0" style="width: 100%; height: 100%; overflow: visible; background: rgb(242, 242, 242);"></iframe>');
            $(iframe).attr("src", url);
            $(".content",window.parent.document).append(iframe);
            $(iframe).load(function() {
                Loading.close(index);
            });

            //tab过多时
            var _lis = $(".tabsPageHeaderContent",window.parent.document).find("li");
            var n = 0;
            for (var i = 0; i < _lis.length; i++) {
                n += $(_lis[i]).width();
            }

            //获取右侧区域宽度
            var _width = $("#navTab",window.parent.document).width();
            if (n > parseInt(_width)-150 ) {
                $(".tabsRight,.tabsLeft",window.parent.document).show();
            }


        }else{
            $("#navTab",window.parent.document).find("li").removeClass("selected");
            $("#navTab",window.parent.document).find("li[data-url='" + url + "']").addClass("selected");
            $(".content",window.parent.document).find("iframe").removeClass("cy-show");
            $(".content",window.parent.document).find("iframe[src='"+url+"']").addClass("cy-show");
            //更多列表
            $(".tabsMoreList",window.parent.document).find("li").removeClass("selected");
            $(".tabsMoreList",window.parent.document).find("li[data-url='"+url+"']").addClass("selected");
        }

    })
    // $(function () {
    //     getDayUpdData();
    //     appZbPie();
    // });
    // // 基于准备好的dom，初始化echarts实例
    // var myChart = echarts.init(document.getElementById('main'));
    // // 指定图表的配置项和数据
    // function getDayUpdData() {
    //     myChart.showLoading();
    //     $.ajax({
    //         type: "POST",  // 提交方式
    //         url: "/statics/stcUpdCountByDay",// 路径
    //         dataType: "json",
    //         success: function (result) {// 返回数据根据结果进行相应的处理
    //             var data = result.resultData;
    //             if (result.code == '0') {
    //                 var option = {
    //                     title: {
    //                         text: '应用每日更新量'
    //                     },
    //                     tooltip: {
    //                         trigger: 'axis'
    //                     },
    //                     legend: {
    //                         data:data.legendData
    //                     },
    //                     grid: {
    //                         left: '3%',
    //                         right: '4%',
    //                         bottom: '3%',
    //                         containLabel: true
    //                     },
    //                     toolbox: {
    //                         feature: {
    //                             saveAsImage: {}
    //                         }
    //                     },
    //                     xAxis: {
    //                         type: 'category',
    //                         boundaryGap: false,
    //                         data: data.xAxisData
    //                     },
    //                     yAxis: {
    //                         show:false,
    //                         type: 'value'
    //                     },
    //                     series: data.seriesArray
    //                 };
    //                 // 使用刚指定的配置项和数据显示图表。
    //                 myChart.setOption(option);
    //                 myChart.hideLoading();
    //             }
    //         }
    //     });
    // }
    // // 基于准备好的dom，初始化echarts实例
    // var myChart2 = echarts.init(document.getElementById('main2'));
    //
    // // 指定图表的配置项和数据
    //
    //
    // function appZbPie() {
    //     myChart2.showLoading();
    //     $.ajax({
    //         type: "POST",  // 提交方式
    //         url: "/statics/appZbPie",// 路径
    //         dataType: "json",
    //         success: function (result) {// 返回数据根据结果进行相应的处理
    //             var lends = result.lends;
    //             var data = result.data;
    //             if (result.code == '0') {
    //                 var option = {
    //                     title : {
    //                         text: '应用更新总量占比',
    //                         x:'center'
    //                     },
    //                     tooltip : {
    //                         trigger: 'item',
    //                         formatter: "{a} <br/>{b} : {c} ({d}%)"
    //                     },
    //                     legend: {
    //                         orient: 'vertical',
    //                         left: 'left',
    //                         data: lends
    //                     },
    //                     series : [
    //                         {
    //                             name: '应用更新总量占比',
    //                             type: 'pie',
    //                             radius : '55%',
    //                             center: ['50%', '60%'],
    //                             data:data,
    //                             itemStyle: {
    //                                 emphasis: {
    //                                     shadowBlur: 10,
    //                                     shadowOffsetX: 0,
    //                                     shadowColor: 'rgba(0, 0, 0, 0.5)'
    //                                 }
    //                             }
    //                         }
    //                     ]
    //                 };
    //                 // 使用刚指定的配置项和数据显示图表。
    //                 myChart2.setOption(option);
    //                 myChart2.hideLoading();
    //             }
    //         }
    //     });
    // }
    // function aMOverOn(obj,v){
    //     $("#downqr_"+v).css("display","block");
    // }
    // function aMOut(obj,v) {
    //     $("#downqr_"+v).css("display","none");
    // }

</script>
</html>