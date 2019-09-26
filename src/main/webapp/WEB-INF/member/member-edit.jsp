<%--
  Created by IntelliJ IDEA.
  User: rimi
  Date: 2019/9/23
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>member-edit</title>
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
        <form class="layui-form" lay-filter="form-member" id="form-member">
            <input type="hidden" name="id" value="${member.id}"/>
            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>登录名</label>
                <div class="layui-input-inline">
                    <input type="text" id="username" name="username" value="${member.username}" required="" lay-verify="username" autocomplete="off" class="layui-input"></div>
                <div class="layui-form-mid layui-word-aux">
                    <span class="x-red">*</span>将会成为您唯一的登入名</div></div>
            <div class="layui-form-item">
                <label for="sex" class="layui-form-label">
                    <span class="x-red">*</span>性别</label>
                <div class="layui-input-inline">
                    <input type="text" id="sex" name="sex" value="${member.sex}" required="" lay-verify="sex" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="telephone" class="layui-form-label">
                    <span class="x-red">*</span>电话号码</label>
                <div class="layui-input-inline">
                    <input type="text" id="telephone" name="telephone" value="${member.telephone}" required="" lay-verify="telephone" autocomplete="off" class="layui-input"></div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div></div>
            <div class="layui-form-item">
                <label for="address" class="layui-form-label">
                    <span class="x-red">*</span>地址</label>
                <div class="layui-input-inline">
                    <input type="text" id="address" name="address" value="${member.address}" required="" lay-verify="address" autocomplete="off" class="layui-input"></div>
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
            password: [/(.+){6,12}$/, '密码必须6到12位'],
            repass: function(value) {
                if ($('#password').val() != $('#L_repass').val()) {
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(edit)', function(data) {
            // 获取整个表单的数据
            var field = data.field;
            //发异步，把数据提交给php
            $.ajax({
                type: "POST",
                url: "/member?method=update",
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
