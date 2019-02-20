<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layuiAdmin - 后台模板管理系统</title>
  <link rel="stylesheet" href="../../../src/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo" style="color: rgba(255,255,255,.8);">layuiAdmin</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item layadmin-flexible" lay-unselect>
        <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
          <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
        </a>
      </li>
      <li class="layui-nav-item" lay-unselect>
        <a href="javascript:;" layadmin-event="refresh" title="刷新">
          <i class="layui-icon layui-icon-refresh-3"></i>
        </a>
      </li>
      <li class="layui-nav-item layui-hide-xs" lay-unselect>
        <a href="javascript:;" layadmin-event="fullscreen">
          <i class="layui-icon layui-icon-screen-full"></i>
        </a>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item" lay-unselect>
        <a href="javascript:;" layadmin-event="message" lay-text="消息中心">
          <i class="layui-icon layui-icon-notice"></i>
        </a>
      </li>
      <li class="layui-nav-item">
        <a href="javascript:;">
          卷妹组合
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">修改密码</a></dd>
          <hr>
          <dd layadmin-event="logout" style="text-align: center;"><a href="user/login.jsp">退出</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item layui-hide-xs" lay-unselect>
        <a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
      </li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">所有商品</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="javascript:;">列表三</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">解决方案</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item"><a href="javascript:;">云市场</a></li>
        <li class="layui-nav-item"><a href="javascript:;">发布商品</a></li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">内容主体区域</div>
  </div>
  
  <div class="layui-footer" style="text-align: center;">
    <!-- 底部固定区域 -->
    © 2019 JJ & MM Studio
  </div>
</div>
<script src="../../../src/layui/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
});
</script>
</body>
</html>
