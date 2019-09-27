
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>order-list</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script src="/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
</head>

<body>
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a href="" >首页</a>
            <a>
              <cite>列表</cite>
            </a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <div class="layui-form layui-col-space5" >
                        <div class="layui-input-inline layui-show-xs-block">
                            <select name="moneyStyle">
                                <option value="">支付方式</option>
                                <option value="支付宝">支付宝</option>
                                <option value="微信">微信</option>
                                <option value="货到付款">货到付款</option>
                            </select>
                        </div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <select name="orderStatus">
                                <option value="">订单状态</option>
                                <option value="未收货">未收货</option>
                                <option value="已确认">已确认</option>
                                <option value="已收货">已收货</option>
                                <option value="已取消">已取消</option>
                                <option value="已完成">已完成</option>
                                <option value="已作废">已作废</option>
                            </select>
                        </div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <input type="text" name="orderNumber" placeholder="请输入订单号" autocomplete="off" class="layui-input"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit lay-filter="search">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </div>
                </div>
                <div id="demoTable" class="layui-btn-group demoTable layui-card-header">
                    <button class="layui-btn layui-btn-danger" data-type="delAll">
                        <span class="layui-icon layui-icon-delete"></span> 批量删除</button>
                    <button class="layui-btn" onclick="xadmin.open('添加用户','/order?method=add',600,400)"><i class="layui-icon"></i>添加</button>
                </div>
                <div class="layui-card-body ">
                    <table id="demo" lay-filter="test"></table>
                    <script type="text/html" id="options">
                        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<script> layui.use(['laydate', 'form', 'table'], function () {
    var laydate = layui.laydate;
   var form = layui.form;
    var table = layui.table;
    //执行渲染
    table.render({
        elem: '#demo' //指定原始表格元素选择器（推荐id选择器）
        , url: '/order',
        where: {method: 'data'}
        , height:  'full-300' //容器高度
        , cols: [[
            {checkbox: true, fixed: 'left', align: 'center'}
            , {field: 'id', width: 80, title: 'ID', sort: true}
            , {field: 'orderNumber', width: 80, title: '订单编号',sort: true}
            , {field: 'orderPerson', width: 80, title: '收货人'}
            , {field: 'orderSum', width: 80, title: '总金额'}
            , {field: 'orderMoney', width: 80, title: '应付金额'}
            , {field: 'orderStatus', width: 80, title: '订单状态'}
            , {field: 'moneyStatus', width: 80, title: '支付状态'}
            , {field: 'goodStatus', width: 80, title: '发货状态'}
            , {field: 'moneyStyle', width: 80, title: '支付方式'}
            , {field: 'sendStyle', width: 80, title: '配送方式'}
            , {title: '下单时间', templet: '<div>{{ layui.util.toDateString(d.orderTime) }}</div>'}
            , {title: '操作', templet: '#options'}
        ]],
        page: true,
        limits: [10, 20, 30, 40],
        loading: true
    });

    form.on('submit(search)',function (data){
        var f_0 = data.field;
        // console.log(f_0);
        table.reload('demo',{
            where :{
                method:'data',
                moneyStyle:f_0.moneyStyle,
                orderStatus:f_0.orderStatus,
                orderNumber:f_0.orderNumber
            }
            ,page :{
                curr: 1
            }
        });
        // return false;
    });
    table.on('tool(test)',function (obj) {
        var data = obj.data;
         if(obj.event === 'del'){
            var ids=[];
            ids[0] = data.id;
            $.ajax({
                url: "/order?method=del",
                type: "POST",
                data: {id:ids},
                dataType:'json',
                success: function(result){
                    layer.alert('成功', {
                            icon: 1
                        },
                        function() {
                            table.reload('demo');
                        });
                },error:function () {

                }
            });
        } else if(obj.event === 'edit'){
            layer.open({
                type: 2,
                title: "编辑订单",
                content: "/order?method=edit&id="+data.id,
                area: ["600px", "580px"],
                btn: ["确定", "取消"],
                yes: function (e, t) {
                    var l = window["layui-layer-iframe" + e],
                        r = t.find("iframe").contents().find("#user-submit");
                    l.layui.form.on("submit(user-submit)", function (t) {
                        t.field;
                        // 提交数据
                        $.ajax({
                            url:'/order?method=update',
                            type:"post",
                            data: t.field,
                            dataType:"json",
                            success:function (result) {
                                layer.close(e)
                                if (result.code === 0){
                                    layer.msg("操作成功")
                                    table.reload('demo');
                                } else {
                                    layer.msg("操作失败")
                                }
                            }
                        })

                    }), r.trigger("click")
                },
                success: function (e, t) {
                }
            })
        }
    });

    //执行一个laydate实例
    laydate.render({
        elem: '#start' //指定元素
    });

    //执行一个laydate实例
    laydate.render({
        elem: '#end' //指定元素
    });

    var $ = layui.$, active = {
        delAll: function(){ //获取选中数据
            var checkStatus = table.checkStatus('demo')
                ,data = checkStatus.data;
            var ids=[],count=0;
            for(var d in data){
                ids[count] = data[d].id;
                count++;
            }
            //提交数据
            $.ajax({
                url: "/order?method=del",
                type: "POST",
                data: {id:ids},
                success: function(result){
                    layer.alert('成功', {
                            icon: 1
                        },
                        function() {
                            //关闭当前frame
                            xadmin.close();
                            // 可以对父窗口进行刷新
                            xadmin.father_reload();
                        });
                }
            });
        }
    };

    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});
</script>
</body>
</html>
