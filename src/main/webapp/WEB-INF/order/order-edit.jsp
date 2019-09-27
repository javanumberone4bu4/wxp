<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>order-edit</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8"/>
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form" lay-filter="form-order" id="form-order">
            <input type="hidden" name="id" value="${order.id}"/>
            <div class="layui-form-item">
                <label for="orderNumber" class="layui-form-label">
                    <span class="x-red">*</span>订单编号</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderNumber" name="orderNumber" value="${order.orderNumber}" required=""
                           lay-verify="orderNumber" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="orderPerson" class="layui-form-label">
                    <span class="x-red">*</span>收货人</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderPerson" name="orderPerson" value="${order.orderPerson}" required=""
                           lay-verify="orderPerson" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="orderSum" class="layui-form-label">
                    <span class="x-red">*</span>总金额</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderSum" name="orderSum" value="${order.orderSum}" required=""
                           lay-verify="orderSum" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label for="orderMoney" class="layui-form-label">
                    <span class="x-red">*</span>应付金额</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderMoney" name="orderMoney" value="${order.orderMoney}" required=""
                           lay-verify="orderMoney" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="orderStatus" class="layui-form-label">
                    <span class="x-red">*</span>订单状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderStatus" name="orderStatus" value="${order.orderStatus}" required=""
                           lay-verify="orderStatus" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="moneyStatus" class="layui-form-label">
                    <span class="x-red">*</span>支付状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="moneyStatus" name="moneyStatus" value="${order.moneyStatus}" required=""
                           lay-verify="moneyStatus" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="goodStatus" class="layui-form-label">
                    <span class="x-red">*</span>发货状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="goodStatus" name="goodStatus" value="${order.goodStatus}" required=""
                           lay-verify="goodStatus" autocomplete="off" class="layui-input"></div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span></div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label for="moneyStyle" class="layui-form-label">支付方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="moneyStyle" name="moneyStyle" value="${order.moneyStyle}" required=""
                           lay-verify="moneyStyle" autocomplete="off" class="layui-input"></div>

            </div>
            <div class="layui-form-item layui-form-text">
                <label for="sendStyle" class="layui-form-label">配送方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="sendStyle" name="sendStyle" value="${order.sendStyle}" required=""
                           lay-verify="sendStyle" autocomplete="off" class="layui-input"></div>

            </div>
            <div class="layui-form-item layui-form-text">
                <label for="orderTime" class="layui-form-label">下单时间</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderTime" name="orderTime" value="${order.orderTime}" required=""
                           lay-verify="orderTime" autocomplete="off" class="layui-input"></div>

            </div>
            <div class="layui-form-item">
                <div class="layui-form-item layui-hide">
                    <input type="button" lay-submit lay-filter="user-submit" id="user-submit" value="确认">
                </div>
            </div>
        </form>
    </div>
</div>
<script>layui.use(['form', 'layer'],
    function () {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function (value) {
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            },
            password: [/(.+){6,12}$/, '密码必须6到12位'],
            repass: function (value) {
                if ($('#password').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(edit)', function (data) {
            // 获取整个表单的数据
            var field = data.field;
            //发异步，把数据提交给php
            $.ajax({
                type: "POST",
                url: "/order?method=update",
                data: field,
                success: function () {
                    layer.alert('成功', {
                            icon: 6
                        },
                        function () {
                            //关闭当前frame
                            xadmin.close();
                            // 可以对父窗口进行刷新
                            xadmin.father_reload();
                        });
                }
            });
            // console.log(data);
            // layer.alert(JSON.stringify(data.field), {
            //         title: 6
            //     },
            //     function() {
            //         //关闭当前frame
            //         xadmin.close();
            //
            //         // 可以对父窗口进行刷新
            //         xadmin.father_reload();
            //     });
            return false;
        });
    });</script>
</body>

</html>
