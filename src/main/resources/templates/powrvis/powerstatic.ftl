<!DOCTYPE html>
<html>
<head>
    <title>能源分析</title>
    <#include "../resource_new.ftl"/>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <#include "../common.ftl"/>
        <div class="layui-col-sm10">
            <div class="layui-card">
                <div class="layui-card-body">
                    <form class="layui-form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">时间:</label>
                            <div class="layui-input-inline">
                                <input class="layui-input" placeholder="选择时间" id="dataDateTime" name="dataDateTime">
                            </div>
                            <div class="layui-input-inline">
                                <button id="serchForm" type="button" class="layui-btn search-btn"
                                        onclick="serchSubmit()" lay-filter="serchForm"><i
                                            class="fa fa-search">&nbsp;</i>查询
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary"><i
                                            class="fa fa-refresh">&nbsp;</i>重置
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="layui-col-sm10">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                        <ul class="layui-tab-title">
                            <li data-url="/powerStitcs/realTimeVis" class="layui-this">负荷</li>
                            <li data-url="/powerStitcs/realTimeElec">电量</li>
                            <li data-url="/ss3">电压</li>
                            <li data-url="/ss4">电流</li>
                            <li data-url="/ss4">功率因数</li>
                            <li data-url="/ss4">谐波</li>
                        </ul>
                        <div class="layui-tab-content">
                            <section class="content" id="tab-content" style="background:#fff;">
                                <iframe id="tab-content-iframe" scrolling="yes" frameborder="0"
                                        style="width:100%;min-height:200px;overflow:visible;background:#f2f2f2;"
                                        src=""></iframe>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
            <#--<iframe id="dataFrame" src="/powerStitcs/realTimeVis" style="width:100%;min-height:200px;overflow:visible;background:#f2f2f2;border: none;"></iframe>-->
            <#--<div class="layui-card">-->
            <#--<div class="layui-card-body">-->

            <#--</div>-->
            <#--</div>-->

        </div>
    </div>
</div>
<script src="/statics/plugins/laydate/laydate.js"></script>
<script>
    //获取当前被选中的tab请求URL
    //用户刷新iframe路径
    var tabUrl = $(".layui-this").attr("data-url");
    //时间控件配置
    var start = {
        elem: "#dataDateTime",
        format: "YYYY-MM-DD",
        min: "1991-06-16 23:59:59",
        max: "2099-06-16 23:59:59",
        istime: true,
        istoday: false,
        choose: function (datas) {
            // end.min = datas;
            // end.start = datas
        }
    };
    $(function () {
        //初始化时间控件
        laydate(start);
    });
    layui.use('element', function () {
        var $ = layui.jquery, element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
        //tab切换 同时刷新iframe
        element.on('tab(docDemoTabBrief)', function (elem) {
            tabUrl = $(this).attr("data-url");
            document.getElementById('tab-content-iframe').src = $(this).attr("data-url") + "?pointIds=" + pointIds + "&compareTime=" + $("#dataDateTime").val();
        });

    });
    //搜索查询按钮提交
    function serchSubmit() {
        //刷新iframe
        document.getElementById('tab-content-iframe').src = tabUrl + "?pointIds=" + pointIds + "&compareTime=" + $("#dataDateTime").val();
        //刷新子页面列表数据
        document.getElementById('tab-content-iframe').contentWindow.getTableData();
    }

    $(window).on('resize', function () {
        var $content = $('#tab-content');
        var $treeCardBody = $('#treeCardBody');
        $content.height($(this).height() - 114);
        $treeCardBody.height($(this).height() - 86);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
        });
    }).resize();
</script>
</body>
</html>