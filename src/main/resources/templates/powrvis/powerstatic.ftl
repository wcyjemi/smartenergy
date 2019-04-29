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
                    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                        <ul class="layui-tab-title">
                            <li data-url="/powerStitcs/realTimeVis" class="layui-this">网站设置</li>
                            <li data-url="/ss1">用户管理</li>
                            <li data-url="/ss2">权限分配</li>
                            <li data-url="/ss3">商品管理</li>
                            <li data-url="/ss4">订单管理</li>
                        </ul>
                        <div class="layui-tab-content">
                            <section class="content" id="tab-content" style="background:#fff;">
                                <iframe id="tab-content-iframe" scrolling="yes" frameborder="0" style="width:100%;min-height:200px;overflow:visible;background:#f2f2f2;" src=""></iframe>
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
<script>
    layui.use('element', function(){
        var $ = layui.jquery,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {
            tabAdd: function(){
                //新增一个Tab项
                element.tabAdd('demo', {
                    title: '新选项'+ (Math.random()*1000|0) //用于演示
                    ,content: '内容'+ (Math.random()*1000|0)
                    ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
                })
            }
            ,tabDelete: function(othis){
                //删除指定Tab项
                element.tabDelete('demo', '44'); //删除：“商品管理”


                othis.addClass('layui-btn-disabled');
            }
            ,tabChange: function(){
                //切换到指定Tab项
                element.tabChange('demo', '22'); //切换到：用户管理
            }
        };
        element.on('tab(docDemoTabBrief)', function(elem){
            console.info($(this).attr("data-url"));
            document.getElementById('tab-content-iframe').src = $(this).attr("data-url")+"?pointIds="+pointIds;
        });

    });
    $(window).on('resize', function () {
        var $content = $('#tab-content');
        var $treeCardBody = $('#treeCardBody');
        $content.height($(this).height()-114);
        $treeCardBody.height($(this).height()-86);
        $content.find('iframe').each(function () {
            $(this).height($content.height());
        });
    }).resize();
</script>
</body>
</html>