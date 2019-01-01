<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Login</title>

    <%@ include file="../common/common-header.jsp"%>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">IN+</h1>

            </div>
            <h3>Welcome to IN+</h3>
            <%--<p>Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.--%>
                <%--<!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->--%>
            <%--</p>--%>
            <p>Login in. To see it in action.</p>
            <form class="m-t" role="form">
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Email" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" required="">
                </div>
                <a href="<%=basePath%>/src/jsp/template/empty_page.jsp" class="btn btn-primary block full-width m-b">Login</a>

                <a href="<%=basePath%>/src/jsp/login/forgot_password.jsp"><small>Forgot password?</small></a>
                <p class="text-muted text-center"><small>Do not have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="<%=basePath%>/src/jsp/login/register.jsp">Create an account</a>
            </form>
            <p class="m-t"> <small>Inspinia we app framework base on Bootstrap 3 &copy; 2018</small> </p>
        </div>
    </div>

    <%@ include file="../common/common-footer.jsp"%>

</body>

</html>
