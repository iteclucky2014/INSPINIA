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

    <title>INSPINIA | Register</title>

    <%@ include file="../common/common-header.jsp"%>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown" style="padding-top: 300px;">
        <div>
            <div>

                <h1 class="logo-name">IN+</h1>

            </div>
            <h3>Register to IN+</h3>
            <p>Create account to see it in action.</p>
            <form class="m-t" role="form" id="registerForm">
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <input type="text" name="mobile" class="form-control" placeholder="Mobile">
                </div>
                <div class="form-group">
                    <input type="text" name="email" class="form-control" placeholder="Email">
                </div>
                <%--<div class="form-group">--%>
                        <%--<div class="checkbox i-checks"><label> <input type="checkbox"><i></i> Agree the terms and policy </label></div>--%>
                <%--</div>--%>
                <a id="register" href="javascript:void(0);" class="btn btn-primary block full-width m-b">Register</a>

                <p class="text-muted text-center"><small>Already have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="<%=basePath%>/src/jsp/login/login.jsp">Login</a>
            </form>
            <p class="m-t"> <small>Inspinia we app framework base on Bootstrap 3 &copy; 2018</small> </p>
        </div>
    </div>

    <%@ include file="../common/common-footer.jsp"%>
    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });

            var validator = $("#registerForm").validate({
                rules: {
                    username: {
                        required: true
                    },
                    password: {
                        required: true
                    },
                    mobile: {
                        required: true
                    },
                    email: {
                        required: true
                    }
                }
            });
            
            $("#register").click(function() {
                if (validator.form()) {
                    window.location.href = "<%=basePath%>/src/jsp/template/empty_page.jsp";
                }
            });
        });
    </script>
</body>

</html>
