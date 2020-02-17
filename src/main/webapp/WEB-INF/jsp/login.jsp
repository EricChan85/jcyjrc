<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>金昌人才-登录</title>
	<link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/static/css/materialdesignicons.css" />" rel="stylesheet">
	<link href="<c:url value="/static/css/page/login.css" />" rel="stylesheet">
	

  </head>
  
  <body>
    <div class="limit">
	    <div class="login-container">
	        <div class="bb-login">
	            <form class="bb-form validate-form" method="post" action="login" modelAttribute="user"> 
	            	<span class="bb-form-title p-b-26"> 登录 </span> 
	            	<span class="bb-form-title p-b-48"> <i class="mdi mdi-symfony"></i> </span>
	                <div class="wrap-input100 validate-input" data-validate="用户名不能为空"> 
	                	<input class="input100" type="text" name="username" value=""> 
	                	<span class="bbb-input" data-placeholder="用户名"></span> 
	                </div>
	                <div class="wrap-input100 validate-input" data-validate="输入密码"> 
	                	<span class="btn-show-pass"> 
	                		<i class="mdi mdi-eye show_password"></i> 
	                	</span> 
	                	<input class="input100" type="password" name="password"> 
	                	<span class="bbb-input" data-placeholder="密码"></span> 
	                </div>
	                <div class="text-center p-t-10"> 
	                	<span class="txt1"> ${msg} </span>  
	                </div>
	                <div class="login-container-form-btn">
	                    <div class="bb-login-form-btn">
	                        <div class="bb-form-bgbtn"></div> 
	                        <button class="bb-form-btn" name="submit" type="submit"> 登录 </button>
	                    </div>
	                </div>
	                <!-- <div class="text-center p-t-115"> <span class="txt1"> Don’t have an account? </span> <a class="txt2" href="#"> Sign Up </a> </div> -->
	            </form>
	        </div>
	    </div>
	</div>
	<script src="<c:url value="/static/js/jquery.min.js" />"></script>
	<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/static/js/page/login.js" />"></script>
</html>
