/**
 * 采集器信息表
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-03-25 20:59:22
 */

/**数据渲染对象*/
var Render = {
    /**
     * 渲染状态列
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @param index
     * @param value      当前对象值
     */
    customState: function (rowdata,renderData, index, value) {
        if(value == "启用"){
            return '<span style="color:green">'+value+'</span>';
        }
        if(value == "禁用"){
            return '<span style="color:red">'+value+'</span>';
        }
        return value;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      详情按钮渲染
     */
    info:function(rowdata,renderData){
        var btn=' <button  onclick="detailOne(\''+"/encollector/details/"+'\',\''+rowdata.id+'\')" class="layui-btn layui-btn-mini">详情</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      修改按钮渲染
     */
    edit:function(rowdata,renderData){
        var btn=' <button  onclick="editOneArea(\''+"/encollector/edit"+'\',\''+rowdata.id+'\',\'800px\',\'300px\')" class="layui-btn layui-btn-mini">修改</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      删除按钮渲染
     */
    delete:function(rowdata,renderData){
        var btn=' <button  onclick="deleteOne(\''+"删除"+'\',\''+"/encollector/delete"+'\',\''+rowdata.id+'\')" class="layui-btn layui-btn-mini layui-btn-delete">删除</button>';
        return btn;
    },
    /**
     * @param rowdata    行数据
     * @param renderData 渲染后的列
     * @description      启用禁用按钮渲染
     */
    state:function(rowdata,renderData){
        if(rowdata.state=='0'){
            return' <button onclick="updateStateOne(\''+"启用"+'\',\''+"/encollector/enable"+'\',\''+rowdata.id+'\')"' +
                '  class="layui-btn layui-btn-mini layui-btn-green">启用</button>';
        }
        if(rowdata.state=='1'){
            return' <button  onclick="updateStateOne(\''+"禁用"+'\',\''+"/encollector/limit"+'\',\''+rowdata.id+'\')" ' +
                'class="layui-btn layui-btn-mini layui-btn-danger">禁用</button>';
        }
        return "";
    }
};
