/**
 * Created by wcy on 2017/6/21
 * email   :  3304737387@qq.com
 * 百度Echarts封装
 **/
(function ($) {
    /*默认配置*/
    var cyProps = {};
    var echartOption = {
        title: {
            text: '应用每日更新量'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:[]
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
            data: []
        },
        yAxis: {
            show:true,
            type: 'value'
        },
        series: []
    };
    $.fn.cyEcharts = function () {
        //获取当前echarts对象
        var $cyEchart = this;
        //获取当前cyprops配置
        cyProps = $cyEchart.attr("cyProps");

        var $id = $cyEchart.attr("id");
        if (!cyProps) {
            return
        }
        cyProps = cyProps ? cyProps : "";
        //将表格参数转为json
        cyProps = eval("({" + cyProps + "})");
        //获取数据的地址，只能通过表码或url，如果两个都写，默认是url
        //从后台获取数据
        var url = cyProps.url;
        var title = cyProps.title ? cyProps.title : "";
        var grid = cyProps.grid;
        var echartObj = echartsTool.echartsInit($id);
        echartsTool.drawEcharts(url,echartObj,title,grid);

    };
    var echartsTool = {
        //初始化echarts
        echartsInit : function (id) {
            return echarts.init(document.getElementById(id));
        },
        //加载数据
        drawEcharts : function (url,echartObj,title,grid) {
            echartObj.showLoading();
            $.ajax({
                url: url,
                async: false,
                dataType: "json",
                success: function (R) {
                    var data = R;
                    if (R.code == 0) {
                        echartOption.title.text  = title;
                        echartOption.legend.data = data.legendData;
                        echartOption.xAxis.data  = data.xAxisData;
                        echartOption.series      = data.seriesArray;
                        if (grid){
                            echartOption.grid        = grid;
                        }
                        echartObj.setOption(echartOption);
                        echartObj.hideLoading();
                    } else {
                        data = {};
                        alert(R.msg);
                    }
                }
            });
        }

    }
})(jQuery);

$(document).ready(function () {
    //下拉树查询
    var cyEchartArr = $("[cyType='cyEcharts']");
    for (var i = 0; i < cyEchartArr.length; i++) {
        $(cyEchartArr[i]).cyEcharts();
    }
});