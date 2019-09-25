
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
                <a href="">首页</a>
                <a href="">演示</a>
                <a>
                    <cite>导航元素</cite></a>
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
                    <form class="layui-form layui-col-space5">
                        <div class="layui-input-inline layui-show-xs-block">
                            <input class="layui-input" placeholder="开始日" name="start" id="start"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <input class="layui-input" placeholder="截止日" name="end" id="end"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <select name="contrller">
                                <option>支付方式</option>
                                <option>支付宝</option>
                                <option>微信</option>
                                <option>货到付款</option></select>
                        </div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <select name="contrller">
                                <option value="">订单状态</option>
                                <option value="0">待确认</option>
                                <option value="1">已确认</option>
                                <option value="2">已收货</option>
                                <option value="3">已取消</option>
                                <option value="4">已完成</option>
                                <option value="5">已作废</option></select>
                        </div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <input type="text" name="username" placeholder="请输入订单号" autocomplete="off" class="layui-input"></div>
                        <div class="layui-input-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="sreach">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn layui-btn-danger" onclick="delAll()">
                        <i class="layui-icon"></i>批量删除</button>
                    <button class="layui-btn" onclick="xadmin.open('添加用户','./order-add.html',800,600)">
                        <i class="layui-icon"></i>添加</button></div>
                <div class="layui-card-body ">
                    <table id="demo" lay-filter="test"></table>
                    <script type="text/html" id="options">
                        <a title="编辑" onclick="xadmin.open('编辑','<%=request.getContextPath()%>/admin?method=edit')"
                           href="javascript:;">
                            <i class="layui-icon">&#xe642;</i>
                        </a>
                        <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                            <i class="layui-icon">&#xe640;</i>
                        </a>

                    </script>
<%--                    <table class="layui-table layui-form">--%>
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th>--%>
<%--                                <input type="checkbox" name="" lay-skin="primary">--%>
<%--                            </th>--%>
<%--                            <th>订单编号</th>--%>
<%--                            <th>收货人</th>--%>
<%--                            <th>总金额</th>--%>
<%--                            <th>应付金额</th>--%>
<%--                            <th>订单状态</th>--%>
<%--                            <th>支付状态</th>--%>
<%--                            <th>发货状态</th>--%>
<%--                            <th>支付方式</th>--%>
<%--                            <th>配送方式</th>--%>
<%--                            <th>下单时间</th>--%>
<%--                            <th>操作</th></tr>--%>
<%--                        </thead>--%>
<%--                        <tbody>--%>
<%--                        <tr>--%>
<%--                            <td>--%>
<%--                                <input type="checkbox" name="" lay-skin="primary"></td>--%>
<%--                            <td>2017009171822298053</td>--%>
<%--                            <td>老王:18925139194</td>--%>
<%--                            <td>7829.10</td>--%>
<%--                            <td>7854.10</td>--%>
<%--                            <td>待确认</td>--%>
<%--                            <td>未支付</td>--%>
<%--                            <td>未发货</td>--%>
<%--                            <td>其他方式</td>--%>
<%--                            <td>申通物流</td>--%>
<%--                            <td>2017-08-17 18:22</td>--%>
<%--                            <td class="td-manage">--%>
<%--                                <a title="查看" onclick="xadmin.open('编辑','order-view.html')" href="javascript:;">--%>
<%--                                    <i class="layui-icon">&#xe63c;</i></a>--%>
<%--                                <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">--%>
<%--                                    <i class="layui-icon">&#xe640;</i></a>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>--%>
<%--                                <input type="checkbox" name="" lay-skin="primary"></td>--%>
<%--                            <td>2017009171822298053</td>--%>
<%--                            <td>老王:18925139194</td>--%>
<%--                            <td>7829.10</td>--%>
<%--                            <td>7854.10</td>--%>
<%--                            <td>待确认</td>--%>
<%--                            <td>未支付</td>--%>
<%--                            <td>未发货</td>--%>
<%--                            <td>其他方式</td>--%>
<%--                            <td>申通物流</td>--%>
<%--                            <td>2017-08-17 18:22</td>--%>
<%--                            <td class="td-manage">--%>
<%--                                <a title="查看" onclick="xadmin.open('编辑','order-view.html')" href="javascript:;">--%>
<%--                                    <i class="layui-icon">&#xe63c;</i></a>--%>
<%--                                <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">--%>
<%--                                    <i class="layui-icon">&#xe640;</i></a>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>--%>
<%--                                <input type="checkbox" name="" lay-skin="primary"></td>--%>
<%--                            <td>2017009171822298053</td>--%>
<%--                            <td>老王:18925139194</td>--%>
<%--                            <td>7829.10</td>--%>
<%--                            <td>7854.10</td>--%>
<%--                            <td>待确认</td>--%>
<%--                            <td>未支付</td>--%>
<%--                            <td>未发货</td>--%>
<%--                            <td>其他方式</td>--%>
<%--                            <td>申通物流</td>--%>
<%--                            <td>2017-08-17 18:22</td>--%>
<%--                            <td class="td-manage">--%>
<%--                                <a title="查看" onclick="xadmin.open('编辑','order-view.html')" href="javascript:;">--%>
<%--                                    <i class="layui-icon">&#xe63c;</i></a>--%>
<%--                                <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">--%>
<%--                                    <i class="layui-icon">&#xe640;</i></a>--%>
<%--                            </td>--%>
<%--                        </tr>--%>
<%--                        </tbody>--%>
<%--                    </table>--%>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script> layui.use(['laydate', 'form', 'table'], function () {
    var laydate = layui.laydate;
    var form = layui.form;
    var table = layui.table;
    //执行渲染
    table.render({
        elem: '#demo' //指定原始表格元素选择器（推荐id选择器）
        , url: '/order',
        where: {method: 'data'}
        , height: 315 //容器高度
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


    //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

/*用户-停用*/
function member_stop(obj, id) {
    layer.confirm('确认要停用吗？',
        function(index) {

            if ($(obj).attr('title') == '启用') {

                //发异步把用户状态进行更改
                $(obj).attr('title', '停用');
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!', {
                    icon: 5,
                    time: 1000
                });

            } else {
                $(obj).attr('title', '启用');
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!', {
                    icon: 5,
                    time: 1000
                });
            }

        });
}

/*用户-删除*/
function member_del(obj, id) {
    layer.confirm('确认要删除吗？',
        function(index) {
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {
                icon: 1,
                time: 1000
            });
        });
}

function delAll(argument) {

    var data = tableCheck.getData();

    layer.confirm('确认要删除吗？' + data,
        function(index) {
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {
                icon: 1
            });
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
}</script>

</html>
