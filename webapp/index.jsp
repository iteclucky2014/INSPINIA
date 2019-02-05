<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Vue 示例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <div id="app">
      <ul>
          <li v-for="book in books">{{ book.name }}</li>
          <li></li>
          <li><a href="src/jsp/login/login.jsp">INSPINIA</a></li>
          <li><a href="layuiAdmin-v1.2.1/views/user/login.html">layuiAdmin</a></li>
          <li><a href="src/jsp/demo/layui.jsp">layout 后台大布局 - Layui</a></li>
      </ul>
    </div>
    <script src="https://unpkg.com/vue/dist/vue.min.js"></script>
    <script>
      new Vue({
    	  el: '#app',
    	  data: {
    		  books: [
    			  { name: '《Vue.js 实战》' },
    			  { name: '《Javascript 语言精粹》' },
    			  { name: '《Javascript 高级程序设计》' }
    		  ]
    	  }
      });
    </script>
  </body>
</html>
