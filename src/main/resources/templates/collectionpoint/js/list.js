/**
 * Created by wcy on 2017-10-20 13:54:57
 *  email   :  qq228112142@qq.com//
 */


var listData;

/*分页默认参数*/
var defaultParam = {
    search: false,
    nd: new Date().getTime(),
    limit: 10,
    page: 1,
    sidx: '',
    order: 'desc',
    init:true,
    _: new Date().getTime()
};
layui.config({
    base: '../../statics/libs/',
})

layui.use(['treeTable','layer','code','form'],function(){
    var o = layui.$,
        form = layui.form,
        layer = layui.layer,
        treeTable = layui.treeTable;
    // 直接下载后url: './data/table-tree.json',这个配置可能看不到数据，改为data:[],获取自己的实际链接返回json数组
    var	re = function(str){
        layer.load(2);
        treeTable.render({
            elem: '#pointTable',
            url: '/encollectionpoint/treeTableData?'+str,
            // data:listData,
            icon_key: 'title',
            is_checkbox: false,
            cols: [
                {
                    key: 'title',
                    title: '采集点名称',
                    width: '20%',
                },
                {
                    key: 'concentratorName',
                    title: '归属集中器',
                    width: '10%',
                    align: 'center'
                },
                {
                    key:'phyaddr',
                    title:'物理地址',
                    width:'10%',
                    align:'center'
                },
                {
                    key:'virtaddr',
                    title:'虚拟地址',
                    width:'10%',
                    align:'center'
                },
                {
                    key: 'pointType',
                    title: '采集点类型',
                    width: '10%',
                    align: 'center',
                    template: function(item){
                        if(item.pointType == 1){
                            return '<span style="color:red;">电</span>';
                        }else if(item.pointType == 2){
                            return '<span style="color:green;">水</span>';
                        }else if(item.pointType == 3){
                            return '<span style="color:#aaa;">气</span>';
                        }else{
                            return '<span style="color:#aa6f49;">其他</span>';
                        }
                    }
                },
                {
                    key:'pointBrand',
                    title:'设备品牌',
                    width:'10%',
                    align:'center'
                },
                {
                    key:'pointModel',
                    title:'设备型号',
                    width:'10%',
                    align:'center'
                },
                {
                    title: '操作',
                    align: 'center',
                    width:'15%',
                    template: function(item){
                        return '<button onclick="editOneArea(\''+"/encollectionpoint/edit"+'\',\''+item.id+'\',\'1200px\',\'500px\')" class="layui-btn layui-btn-mini">修改</button> <button onclick="editOneArea(\''+"/encollectionpoint//toSetStandard"+'\',\''+item.id+'\',\'1300px\',\'900px\')" class="layui-btn layui-btn-mini">数据项配置</button> <button onclick="deleteOne(\''+"删除"+'\',\''+"/encollectionpoint/delete"+'\',\''+item.id+'\')" class="layui-btn layui-btn-mini layui-btn-delete">删除</button>'
                    }
                }
            ],
            end: function (res) {
                console.info(res);
                if (res.data.length<=0){
                    $("#noDataTable").css("display","block");
                }else {
                    $("#noDataTable").css("display","none");
                }
                layer.closeAll('loading');
            }
        });

        // $.ajax({
        //     type: "POST",  // 提交方式
        //     url: '/enmonitorunit/treeTableData',
        //     data:defaultParam,
        //     async:false,
        //     dataType: "json",
        //     success: function (R) {
        //         console.info("--3--");
        //         if (R.code == 0) {
        //             data = R.data;
        //             listData = data;
        //
        //
        //         } else {
        //             data = "";
        //             Msg.error(R.msg);
        //         }
        //     }
        // });

    };
    re("");
    //监听提交
    o('#serchForm').click(function(){
        var conditions = $('form').serializeArray();
        var str = "";
        console.info(conditions);
        for (var i = 0;i<conditions.length;i++){
            if (i == conditions.length-1){
                str = str+conditions[i].name+"="+conditions[i].value;
            }else {
                str = str+conditions[i].name+"="+conditions[i].value+"&";
            }
        }
        // $.extend(defaultParam, conditions);
        // getData("/enmonitorunit/treeTableData",defaultParam);
        // $("#monitorUnitName").val(conditions.monitorUnitName);
        // // 渲染数据表
        // re.data.push(listData);
        // treeTable.render(re);
        re(str);
    })
    // form.on('submit(search)', function (data) {
    //     console.info(11);
    //     var conditions = data.field;
    //     $.extend(defaultParam, conditions);
    //     getData("/enmonitorunit/treeTableData",defaultParam);
    //     $("#monitorUnitName").val(conditions.monitorUnitName);
    //     // 渲染数据表
    //     re.data.push(listData);
    //     treeTable.render(re);
    // });
    // 监听展开关闭
    // treeTable.on('tree(flex)',function(data){
    //     layer.msg(JSON.stringify(data));
    // })
    // 监听checkbox选择
    // treeTable.on('tree(box)',function(data){
    //     if(o(data.elem).parents('#tree-table1').length){
    //         var text = [];
    //         o(data.elem).parents('#tree-table1').find('.cbx.layui-form-checked').each(function(){
    //             o(this).parents('[data-pid]').length && text.push(o(this).parents('td').next().find('span').text());
    //         })
    //         o(data.elem).parents('#tree-table1').prev().find('input').val(text.join(','));
    //     }
    //     layer.msg(JSON.stringify(data));
    // })
    // 监听自定义
    // treeTable.on('tree(add)',function(data){
    //     layer.msg(JSON.stringify(data));
    // });
    // 获取选中值，返回值是一个数组（定义的primary_key参数集合）
    // o('.get-checked').click(function(){
    //     layer.msg('选中参数'+treeTable.checked(re).join(','))
    // });
    // 刷新重载树表（一般在异步处理数据后刷新显示）
    // o('.refresh').click(function(){
    //     re.data.push({"id":50,"pid":0,"title":"1-4"},{"id":51,"pid":50,"title":"1-4-1"});
    //     treeTable.render(re);
    // })
    // 全部展开
    // o('.open-all').click(function(){
    //     treeTable.openAll(re);
    // })
    // 全部关闭
    // o('.close-all').click(function(){
    //     treeTable.closeAll(re);
    // })
    // 随机更换小图标
    // o('.change-icon').click(function(){
    //     var arr = [
    //         {
    //             open: 'layui-icon layui-icon-set',
    //             close: 'layui-icon layui-icon-set-fill',
    //             left: 16,
    //         },
    //         {
    //             open: 'layui-icon layui-icon-rate',
    //             close: 'layui-icon layui-icon-rate-solid',
    //             left: 16,
    //         },
    //         {
    //             open: 'layui-icon layui-icon-tread',
    //             close: 'layui-icon layui-icon-praise',
    //             left: 16,
    //         },
    //         {
    //             open: 'layui-icon layui-icon-camera',
    //             close: 'layui-icon layui-icon-camera-fill',
    //             left: 16,
    //         },
    //         {
    //             open: 'layui-icon layui-icon-user',
    //             close: 'layui-icon layui-icon-group',
    //             left: 16,
    //         },
    //     ];
    //     var round = Math.round(Math.random()*(arr.length - 1));
    //     re.icon = arr[round];
    //     treeTable.render(re);
    // })
    // o('#tree1').on('click','[data-down]',function(){
    //     o(this).find('span').length && o(this).parents('.layui-unselect').find('input').val(o(this).text());
    // })

})

// function serchForm(){
//     layui.use(['form'], function () {
//         // getData("/enmonitorunit/treeTableData","");
//         var form = layui.form();
//         //监听提交
//         form.on('submit(search)', function (data) {
//             console.info(11);
//             var conditions = data.field;
//             $.extend(defaultParam, conditions);
//             getData("/enmonitorunit/treeTableData",defaultParam);
//             // 渲染数据表
//             renderTable(listData);
//         });
//
//     });
// }

function getData(url,param){
    $.ajax({
        url: url,
        data:param,
        async:false,
        dataType: "json",
        success: function (R) {
            if (R.code == 0) {
                data = R.data;
                listData = data;
            } else {
                data = "";
                Msg.error(R.msg);
            }
        }
    });
}


