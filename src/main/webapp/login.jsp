<%@ page import="com.rimi.item.util.CookieUtils" %>
<%@ page import="com.rimi.item.common.LoginConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script src="/layui/layui.js" charset="utf-8"></script>
    <style>
        p{
            color: red;
        }
    </style>
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">管理登录</div>
    <div id="darkbannerwrap"></div>
    <%
        String contextPath = request.getContextPath();
        String username = CookieUtils.getCookies(request, "username");
        String password = CookieUtils.getCookies(request, "password");
        if(username==null) {
            username="";
        }
        if(password==null) {
            password="";
        }
    %>

    <form action="<%=contextPath%>/login" method="post" class="layui-form" >
        <input name="<%=LoginConstant.LOGIN_USERNAME%>" placeholder="用户名" type="text" lay-verify="required" class="layui-input" value="<%=username%>" >
        <hr class="hr15">
        <input name="<%=LoginConstant.LOGIN_PASSWORD%>" lay-verify="required" placeholder="密码"  type="password" class="layui-input" value="<%=password%>">
        <hr class="hr15">
        <input type="checkbox" name="<%=LoginConstant.LOGIN_REMEMBER%>" class="layui-input">记住我
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
        <p><%=request.getAttribute(LoginConstant.LOGIN_ERROR)==null?"":request.getAttribute(LoginConstant.LOGIN_ERROR)%></p>
    </form>
</div>

<script>
    $(function  () {
        layui.use('form', function(){
            var form = layui.form;
            // layer.msg('玩命卖萌中', function(){
            //   //关闭后的操作
            //   });
            //监听提交
        //     form.on('submit(login)', function(data){
        //         // alert(888)
        //         layer.msg(JSON.stringify(data.field),function(){
        //             location.href='index.html'
        //         });
        //         return false;
        //     });
        });
    })
</script>
</body>
</html>