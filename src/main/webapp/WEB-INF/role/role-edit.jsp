
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>role-edit</title>
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
        <form class="layui-form" lay-filter="form-role" id="form-role">
            <input type="hidden" name="id" value="${role.id}"/>
            <div class="layui-form-item">
                <label for="roleName" class="layui-form-label">
                    <span class="x-red">*</span>角色名
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="roleName" name="roleName" value="${role.roleName}" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label for="roleRule" class="layui-form-label">
                    拥有权限
                </label>
                <div class="layui-input-inline">
                    <input type="text" id="roleRule" name="roleRule" value="${role.roleRule}" required="" lay-verify="required"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label for="roleDescription" class="layui-form-label">
                    描述
                </label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" id="roleDescription" name="roleDescription" value="${role.roleDescription}" class="layui-textarea"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-form-item layui-hide">
                    <input type="button" lay-submit lay-filter="user-submit" id="user-submit" value="确认">
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form
            ,layer = layui.layer;

        //自定义验证规则
        form.verify({
            nikename: function(value){
                if(value.length < 5){
                    return '昵称至少得5个字符啊';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
        });

        //监听提交
        form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });


        // form.on('checkbox(father)', function(data){
        //
        //     if(data.elem.checked){
        //         $(data.elem).parent().siblings('td').find('input').prop("checked", true);
        //         form.render();
        //     }else{
        //         $(data.elem).parent().siblings('td').find('input').prop("checked", false);
        //         form.render();
        //     }
        // });


    });
</script>
</body>

</html>
