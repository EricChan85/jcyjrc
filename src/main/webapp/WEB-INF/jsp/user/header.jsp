  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/user";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" >
		<title>个人中心</title>
		<link href="<c:url value="/static/css/bootstrap4.3.1.min.css" />" rel="stylesheet">
		<link href="<c:url value="/static/css/jquery-ui.css" />" rel="stylesheet">
		
		
	    <script src="<c:url value="/static/js/jquery.min.js" />"></script>
		<script src="<c:url value="/static/js/bootstrap4.3.1.min.js" />"></script>		
		<script src="<c:url value="/static/js/jquery-ui.min.js" />"></script>		
		<script src="<c:url value="/static/js/jquery.mtz.monthpicker.js" />"></script>
	</head>
<body>
<div class="jumbotron" style="margin-bottom:0; padding : 0.5em;">
	<div class="container">
		<div class="row">
			<div class="col-xl-6">
				<p>服务电话：<strong>0935-8226212</strong></p>
			</div>
			<div class="col-xl-6 d-inline-flex flex-row-reverse">
				<sec:authorize access="isAuthenticated()">
				<div class="p-2"><a href="<c:url value="/logout" />">退出</a></div>
				<div class="p-2"><sec:authentication property="principal.name" /></div>
				<div class="p-2"><img width="20" height="20" src="<c:url value="/static/img/default_profile_photo.png" />"/></div>								
				</sec:authorize>
			</div>
		</div>
		
	</div>		
</div>
<nav class="navbar navbar-expand-xl bg-primary navbar-dark">
	<div class="container">
		<a href="index.html"><img  width="60" height="60" class="fl" src="<c:url value="/static/img/logo.jpg" />"/></a>
		<div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="<c:url value="/welcome" />">首页 <span class="sr-only">(current)</span></a>
                <a class="nav-item nav-link active" href="#">个人信息</a>
                <a class="nav-item nav-link" href="#">通讯录</a>
                <a class="nav-item nav-link" href="#">故障报修</a>
                <a class="nav-item nav-link" href="#">留言</a>
            </div>
        </div>	
	</div>
</nav>