
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>order-add</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
 </head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
            <div class="layui-form-item">
                <label for="orderNumber" class="layui-form-label">
                    <span class="x-red">*</span>订单编号</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderNumber" name="orderNumber" required="" lay-verify="orderNumber" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="orderPerson" class="layui-form-label">
                    <span class="x-red">*</span>收货人</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderPerson" name="orderPerson" required="" lay-verify="orderPerson" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="orderSum" class="layui-form-label">
                    <span class="x-red">*</span>总金额</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderSum" name="orderSum" required="" lay-verify="orderSum" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="orderMoney" class="layui-form-label">
                    <span class="x-red">*</span>应付金额</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderMoney" name="orderMoney" required="" lay-verify="orderMoney" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="orderStatus" class="layui-form-label">
                    <span class="x-red">*</span>订单状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="orderStatus" name="orderStatus" required="" lay-verify="orderStatus" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="moneyStatus" class="layui-form-label">
                    <span class="x-red">*</span>支付状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="moneyStatus" name="moneyStatus" required="" lay-verify="moneyStatus" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="goodStatus" class="layui-form-label">
                    <span class="x-red">*</span>发货状态</label>
                <div class="layui-input-inline">
                    <input type="text" id="goodStatus" name="goodStatus" required="" lay-verify="goodStatus" autocomplete="off" class="layui-input"></div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span></div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label for="moneyStyle" class="layui-form-label">支付方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="moneyStyle" name="moneyStyle" required="" lay-verify="moneyStyle" autocomplete="off" class="layui-input"></div>

</div>         <div class="layui-form-item layui-form-text">
                <label for="sendStyle" class="layui-form-label">配送方式</label>
                <div class="layui-input-inline">
                    <input type="text" id="sendStyle" name="sendStyle" required="" lay-verify="sendStyle" autocomplete="off" class="layui-input"></div>

</div>         <div class="layui-form-item layui-form-text">
            <label for="orderTime" class="layui-form-label">配送方式</label>
            <div class="layui-input-inline">
                <input type="text" id="orderTime" name="orderTime" required="" lay-verify="orderTime" autocomplete="off" class="layui-input"></div>

        </div>
<div class="layui-form-item">
    <button type="button"  class="layui-btn"   lay-filter="add" lay-submit >
        增加
        <%--                    <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>--%>
    </button>
</div>
</form>
</div>
</div>
<script>layui.use(['form', 'layer'],
    function() {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function(value) {
                if (value.length < 5) {
                    return '昵称至少得5个字符啊';
                }
            },
            pass: [/(.+){6,12}$/, '密码必须6到12位'],
            repass: function(value) {
                if ($('#L_pass').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)',
            function(data) {
                console.log(data);
                //发异步，把数据提交给php
                layer.alert("增加成功", {
                        icon: 6
                    },
                    function() {
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                    });
                return false;
            });

    });</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>
