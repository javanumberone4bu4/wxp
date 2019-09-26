
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>admin-role</title>
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
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <form class="layui-form layui-col-space5">
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                </div>
                <div id="demoTable" class="layui-btn-group demoTable layui-card-header">
                    <button class="layui-btn layui-btn-danger" data-type="delAll">
                        <span class="layui-icon layui-icon-delete"></span> 批量删除</button>
                    <button class="layui-btn" onclick="xadmin.open('添加角色','/role?method=add',600,400)"><i class="layui-icon"></i>添加</button>
                </div>
                <div class="layui-card-body ">
                    <table id="demo" lay-filter="test"></table>
                    <script type="text/html" id="status">
                        <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span>
                    </script>
                    <script type="text/html" id="options">
                        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="show">启用</a>
                        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                    </script>
<%--                    <table class="layui-table layui-form">--%>
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th>--%>
<%--                                <input type="checkbox" name=""  lay-skin="primary">--%>
<%--                            </th>--%>
<%--                            <th>ID</th>--%>
<%--                            <th>角色名</th>--%>
<%--                            <th>拥有权限规则</th>--%>
<%--                            <th>描述</th>--%>
<%--                            <th>状态</th>--%>
<%--                            <th>操作</th>--%>
<%--                        </thead>--%>
<%--                        <tbody>--%>
<%--                        <tr>--%>
<%--                            <td>--%>
<%--                                <input type="checkbox" name=""  lay-skin="primary">--%>
<%--                            </td>--%>
<%--                            <td>1</td>--%>
<%--                            <td>超级管理员</td>--%>
<%--                            <td>会员列表，问题列表</td>--%>
<%--                            <td>具有至高无上的权利</td>--%>
<%--                            <td class="td-status">--%>
<%--                                <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td>--%>
<%--                            <td class="td-manage">--%>
<%--                                <a onclick="member_stop(this,'10001')" href="javascript:;"  title="启用">--%>
<%--                                    <i class="layui-icon">&#xe601;</i>--%>
<%--                                </a>--%>
<%--                                <a title="编辑"  onclick="xadmin.open('编辑','role-add.html')" href="javascript:;">--%>
<%--                                    <i class="layui-icon">&#xe642;</i>--%>
<%--                                </a>--%>
<%--                                <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">--%>
<%--                                    <i class="layui-icon">&#xe640;</i>--%>
<%--                                </a>--%>
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
<script>
    layui.use(['laydate', 'form', 'table'], function () {
        var laydate = layui.laydate;
        var form = layui.form;
        var table = layui.table;
        //执行渲染
        table.render({
            elem: '#demo' //指定原始表格元素选择器（推荐id选择器）
            , url: '/role',
            where: {method: 'data'}
            , height: 315 //容器高度
            , cols: [[
                {checkbox: true, fixed: 'left', align: 'center'}
                , {field: 'id', width: 80, title: 'ID', sort: true}
                , {field: 'roleName', width: 80, title: '角色名'}
                , {field: 'roleRule', width: 80, title: '角色规则'}
                , {field: 'roleDescription', width: 80, title: '角色描述'}
                , {title: '状态', templet: '#status'}
                , {title: '操作', templet: '#options'}
            ]],
            page: true,
            limits: [10, 20, 30, 40],
            loading: true
        });
        table.on('tool(test)',function (obj) {
            var data = obj.data;
            if(obj.event === 'show'){
                layer.confirm('确认要停用吗？', function (index) {

                    if ($(obj).attr('title') == '启用') {

                        //发异步把用户状态进行更改
                        $(obj).attr('title', '停用')
                        $(obj).find('i').html('&#xe62f;');

                        $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                        layer.msg('已停用!', {icon: 5, time: 1000});

                    } else {
                        $(obj).attr('title', '启用')
                        $(obj).find('i').html('&#xe601;');

                        $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                        layer.msg('已启用!', {icon: 5, time: 1000});
                    }

                });
            } else if(obj.event === 'del'){
                var ids=[];
                ids[0] = data.id;
                $.ajax({
                    url: "/role?method=del",
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
                    title: "编辑角色",
                    content: "/role?method=edit&id="+data.id,
                    area: ["500px", "480px"],
                    btn: ["确定", "取消"],
                    yes: function (e, t) {
                        var l = window["layui-layer-iframe" + e],
                            r = t.find("iframe").contents().find("#user-submit");
                        l.layui.form.on("submit(user-submit)", function (t) {
                            t.field;
                            // 提交数据
                            $.ajax({
                                url:'/role?method=update',
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
                    url: "/role?method=del",
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
            // ,add:function(data) {
            //     // 获取整个表单的数据
            //     var field = data.field;
            //     //发异步，把数据提交给php
            //     $.ajax({
            //         type: "POST",
            //         url: "/admin?method=save",
            //         data: field,
            //         success: function(){
            //             layer.alert('成功', {
            //                     icon: 6
            //                 },
            //                 function() {
            //                     //关闭当前frame
            //                     xadmin.close();
            //                     // 可以对父窗口进行刷新
            //                     xadmin.father_reload();
            //                 });
            //         }
            //     });
            //     return false;
            // }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });

    /*用户-停用*/
    // function member_stop(obj, id) {
    //     layer.confirm('确认要停用吗？', function (index) {
    //
    //         if ($(obj).attr('title') == '启用') {
    //
    //             //发异步把用户状态进行更改
    //             $(obj).attr('title', '停用')
    //             $(obj).find('i').html('&#xe62f;');
    //
    //             $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
    //             layer.msg('已停用!', {icon: 5, time: 1000});
    //
    //         } else {
    //             $(obj).attr('title', '启用')
    //             $(obj).find('i').html('&#xe601;');
    //
    //             $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
    //             layer.msg('已启用!', {icon: 5, time: 1000});
    //         }
    //
    //     });
    // }
    //
    // /*用户-删除*/
    // function member_del(obj, id) {
    //     var ids=[];
    //     ids[0]=id;
    //     console.log(ids)
    //     layer.confirm('确认要删除吗？', function (index) {
    //         //发异步删除数据
    //         $.ajax({
    //             url: "/admin?method=del",
    //             type: "POST",
    //             data: {id:ids},
    //             // contentType:'application/json',
    //             success: function(result){
    //                 layer.alert('成功', {
    //                         icon: 1
    //                     },
    //                     function() {
    //                         //关闭当前frame
    //                         xadmin.close();
    //                         // 可以对父窗口进行刷新
    //                         xadmin.father_reload();
    //                     });
    //             }
    //         });
    //         // $(obj).parents("tr").remove();
    //         // layer.msg('已删除!', {icon: 1, time: 1000});
    //     });
    // }
    //     function delAll(argument){
    //             var data = tableCheck.getData();
    //             console.log(data);
    //            var ids=[];
    //             if(data.length>0){
    //                 for (var i = 0; i < data.length; i++) {
    //                     ids= data[i].id;
    //                 }
    //             }
    //             layer.confirm('确认要删除吗？' + ids, function (index) {
    //                 $.ajax({
    //                     url: "/admin?method=del",
    //                     type: "POST",
    //                     data: {"id":ids},
    //                     success: function(result){
    //                         layer.alert('成功', {
    //                                 icon: 1
    //                             },
    //                             function() {
    //                                 //关闭当前frame
    //                                 xadmin.close();
    //                                 // 可以对父窗口进行刷新
    //                                 xadmin.father_reload();
    //                             });
    //                     }
    //                 });
    //                 //捉到所有被选中的，发异步进行删除
    //                 // layer.msg('删除成功', {icon: 1});
    //                 // $(".layui-form-checked").not('.header').parents('tr').remove();
    //             });
    //             //layer.alert(JSON.stringify(data));
    // }
</script>
</html>
