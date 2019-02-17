<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>��¼ - layuiAdmin</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/login.css" media="all">
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="padding-top: 400px;">

  <div class="layadmin-user-login-main">
    <div class="layadmin-user-login-box layadmin-user-login-header">
      <h2>layuiAdmin</h2>
    </div>
    <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
        <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="�û���" class="layui-input">
      </div>
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
        <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="����" class="layui-input">
      </div>
      <%--<div class="layui-form-item">
        <div class="layui-row">
          <div class="layui-col-xs7">
            <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
            <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="ͼ����֤��" class="layui-input">
          </div>
          <div class="layui-col-xs5">
            <div style="margin-left: 10px;">
              <img src="https://www.oschina.net/action/user/captcha" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
            </div>
          </div>
        </div>
      </div>--%>
      <div class="layui-form-item" style="margin-bottom: 40px;">
        <%--<input type="checkbox" name="remember" lay-skin="primary" title="��ס����">
        <a href="forget.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">�������룿</a>--%>
      </div>
      <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">�� ¼</button>
      </div>
      <%--<div class="layui-trans layui-form-item layadmin-user-login-other">
        <label>�罻�˺ŵ���</label>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-qq"></i></a>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo"></i></a>

        <a href="reg.html" class="layadmin-user-jump-change layadmin-link">ע���ʺ�</a>
      </div>--%>
    </div>
  </div>

  <div class="layui-trans layadmin-user-login-footer">

    <p>�0�8 2019 <a href="http://localhost:8080/INSPINIA/">JJ & MM Studio</a></p>
    <%--<p>
      <span><a href="http://www.layui.com/admin/#get" target="_blank">��ȡ��Ȩ</a></span>
      <span><a href="http://www.layui.com/admin/pro/" target="_blank">������ʾ</a></span>
      <span><a href="http://www.layui.com/admin/" target="_blank">ǰ������</a></span>
    </p>--%>
  </div>

  <!--<div class="ladmin-user-login-theme">
    <script type="text/html" template>
      <ul>
        <li data-theme=""><img src="{{ layui.setter.base }}style/res/bg-none.jpg"></li>
        <li data-theme="#03152A" style="background-color: #03152A;"></li>
        <li data-theme="#2E241B" style="background-color: #2E241B;"></li>
        <li data-theme="#50314F" style="background-color: #50314F;"></li>
        <li data-theme="#344058" style="background-color: #344058;"></li>
        <li data-theme="#20222A" style="background-color: #20222A;"></li>
      </ul>
    </script>
  </div>-->

</div>

<script src="../../../layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '../../../layuiadmin/' //��̬��Դ����·��
    }).extend({
        index: 'lib/index' //�����ģ��
    }).use(['index', 'user'], function(){
        var $ = layui.$
            ,setter = layui.setter
            ,admin = layui.admin
            ,form = layui.form
            ,router = layui.router()
            ,search = router.search;

        form.render();

        //�ύ
        form.on('submit(LAY-user-login-submit)', function(obj){

            //�������ӿ�
            admin.req({
                url: layui.setter.base + 'json/user/login.js' //ʵ��ʹ����ĳɷ������ʵ�ӿ�
                ,data: obj.field
                ,done: function(res){

                    //����ɹ���д�� access_token
                    layui.data(setter.tableName, {
                        key: setter.request.tokenName
                        ,value: res.data.access_token
                    });

                    location.href = '../layui.jsp'; //��̨��ҳ

                    //����ɹ�����ʾ����ת
                    /*layer.msg('����ɹ�', {
                        offset: '15px'
                        ,icon: 1
                        ,time: 1000
                    }, function(){
                        location.href = '../index.html'; //��̨��ҳ
                    });*/
                }
            });

        });


        //ʵ��ʹ��ʱ�ǵ�ɾ���ô���
        /*layer.msg('Ϊ�˷�����ʾ���û����������������', {
            offset: '15px'
            ,icon: 1
        });*/

    });
</script>
</body>
</html>