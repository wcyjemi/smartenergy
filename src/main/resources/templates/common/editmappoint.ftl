<#--  wcy 2019-03-19 11:10:52-->
<!DOCTYPE html>
<html>
<head>
    <title>地图选点</title>
    <#include "../resource.ftl"/>
    <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=snC4uGnBKcYv7Ohr9uFndmZXotOGYjql&s=1"></script>
    <style type="text/css">
        #allmap {
            width: 100%;
            height: 700px;
            overflow: hidden;
            margin: 0;
            font-family: "微软雅黑";
            top: 2px;
        }
        input {
            background-color: #FFF;
            background-image: none;
            border: 1px solid #e5e6e7;
            color: inherit;
            display: block;
            padding: 6px 12px;
            font-size: 14px;
            float: right;
        }
    </style>
</head>
<body>
<form class="layui-form" action="">
    <input type="hidden" id="mappointla" name="la" value="${(la)!""}">
    <input type="hidden" id="mappointlo" name="lo" value="${(lo)!""}">
</form>

<div style="position: absolute; z-index: 1; margin: 10px auto;">
    <span style="line-height: 36px;font-size: large;font-weight: 600;">关键词：</span>
    <input id="search" onkeyup="crux(this)">
</div>
<div id="allmap"></div>
</body>
<script type="text/javascript">
    // 百度地图API功能
    var map = new BMap.Map("allmap"); // 创建Map实例
    var top_right_navigation = new BMap.NavigationControl({
        anchor : BMAP_ANCHOR_TOP_RIGHT
    }); //右上角，仅包含平移和缩放按钮
    /*缩放控件type有四种类型:
     BMAP_NAVIGATION_CONTROL_SMALL：仅包含平移和缩放按钮；BMAP_NAVIGATION_CONTROL_PAN:仅包含平移按钮；BMAP_NAVIGATION_CONTROL_ZOOM：仅包含缩放按钮*/

    map.addControl(top_right_navigation);
    map.enableScrollWheelZoom();//启用地图滚轮放大缩小
    var marker = null;
    if ($("#mappointlo").val() != '' && $("#mappointla").val()!='') {
        map.centerAndZoom(new BMap.Point($("#mappointlo").val(), $("#mappointla").val()), 17);
        marker = new BMap.Marker(new BMap.Point($("#mappointlo").val(), $("#mappointla").val()));
        map.addOverlay(marker);
        marker.addEventListener("click", function(){
            this.openInfoWindow(new BMap.InfoWindow('当前经纬度：'+$("#mappointlo").val()+","+$("#mappointla").val()));
        });
    } else {
        map.centerAndZoom(new BMap.Point(118.80041, 32.058287), 11);
        map.setCurrentCity("南京");
    }
    var removeMarker = function(e, ee, marker) {
        if (marker != null) {
            map.removeOverlay(marker);
        }
    };
    //添加标记
    function showInfo(e) {
        if (marker != null) {
            map.removeOverlay(marker);
        }
        //创建右键菜单
        marker = new BMap.Marker(new BMap.Point(e.lng, e.lat)); // 创建点
        $("#mappointlo").val(e.lng);
        $("#mappointla").val(e.lat);
        map.addOverlay(marker);
        marker.addEventListener("click", function(){
            this.openInfoWindow(new BMap.InfoWindow('当前经纬度：'+e.lng+","+e.lat));
        });
        $("#btn").click();
    }
    var menu = new BMap.ContextMenu();
    var txtMenuItem = [ {
        text : '定位',
        callback : function(e) {
            showInfo(e)
        }
    } ];
    for (var i = 0; i < txtMenuItem.length; i++) {
        menu.addItem(new BMap.MenuItem(txtMenuItem[i].text,
            txtMenuItem[i].callback, 100));
    }
    map.addContextMenu(menu);

    var local = new BMap.LocalSearch(map, {
        renderOptions : {
            map : map
        }
    });
    function crux(obj) {
        local.search($(obj).val());
    }
</script>
</html>