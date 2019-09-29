
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>member-list1</title>
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
                    <div class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="username" placeholder="请输入登录名" autocomplete="off" class="layui-input"></div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn" lay-submit="" lay-filter="search">
                                <i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </div>
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
<script>  layui.use(['laydate', 'form', 'table'], function () {
    var laydate = layui.laydate;
    var form = layui.form;
    var table = layui.table;
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });

        //执行渲染
        table.render({
            elem: '#demo' //指定原始表格元素选择器（推荐id选择器）
            , url: '/member',
            where: {method: 'data'}
            , height:  'full-300' //容器高度
            ,toolbar:true
            ,defaultToolbar: ['filter', 'print', 'exports']
            , cols: [[
                {checkbox: true, fixed: 'left', align: 'center'}
                , {field: 'id', width: 80, title: 'ID', sort: true}
                , {field: 'username', width: 80, title: '登录名'}
                , {field: 'sex', width: 80, title: '性别', sort: true}
                , {field: 'telephone', width: 80, title: '手机'}
                , {field: 'address', width: 80, title: '地址'}
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
                    username:f_0.username
                }
                ,page :{
                    curr: 1
                }
            });
            // return false;
        });
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                var ids = [];
                ids[0] = data.id;
                $.ajax({
                    url: "/member?method=del",
                    type: "POST",
                    data: {id: ids},
                    dataType: 'json',
                    success: function (result) {
                        layer.alert('成功', {
                                icon: 1
                            },
                            function () {
                                table.reload('demo');
                            });
                    }, error: function () {

                    }
                });
            } else if (obj.event === 'edit') {
                layer.open({
                    type: 2,
                    title: "编辑会员",
                    content: "/member?method=edit&id=" + data.id,
                    area: ["500px", "480px"],
                    btn: ["确定", "取消"],
                    yes: function (e, t) {
                        var l = window["layui-layer-iframe" + e],
                            r = t.find("iframe").contents().find("#user-submit");
                        l.layui.form.on("submit(user-submit)", function (t) {
                            t.field;
                            // 提交数据
                            $.ajax({
                                url: '/member?method=update',
                                type: "post",
                                data: t.field,
                                dataType: "json",
                                success: function (result) {
                                    layer.close(e)
                                    if (result.code === 0) {
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
    });
</script>
</body>
</html>
