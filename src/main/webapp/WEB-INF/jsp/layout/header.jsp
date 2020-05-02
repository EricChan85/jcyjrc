<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>金昌人才</title>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" >
    

    <link href="<c:url value="/static/css/bootstrap4.3.1.min.css" />" rel="stylesheet">
	<link href="<c:url value="/static/css/welcome.css" />" rel="stylesheet">
  </head>
  
  <body>
    <!-- Navigation -->
	  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
	    <div class="container">
	      <a class="navbar-brand" href="index.html">人才热线：0935-8226212</a>
	      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	      <div class="collapse navbar-collapse" id="navbarResponsive">
	        <ul class="navbar-nav ml-auto">
	          <!-- <li class="nav-item">
	            <a class="nav-link" href="contact.html">Contact</a>
	          </li>	  -->         
				<sec:authorize access="!isAuthenticated()">				
					<li class="nav-item">
			            <a class="nav-link" href="login">登录</a>
					</li>	 
				</sec:authorize> 
				<sec:authorize access="hasRole('ROLE_USER')">
					<li class="nav-item dropdown">
					  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    <sec:authentication property="principal.name" />
					  </a>
					  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
					    <a class="dropdown-item" href="settings/userInfo">进入个人中心</a>
					    <a class="dropdown-item" href="logout">退出</a>
					  </div>
					</li>					
				</sec:authorize>  
				<sec:authorize access="hasRole('ROLE_STAFF')">
					<li class="nav-item dropdown">
					  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    <sec:authentication property="principal.name" />
					  </a>
					  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
					    <a class="dropdown-item" href="apartment/repair">进入公寓维修</a>
					    <a class="dropdown-item" href="logout">退出</a>
					  </div>
					</li>					
				</sec:authorize>  
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="nav-item dropdown">
					  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    <sec:authentication property="principal.name" />
					  </a>
					  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
					    <a class="dropdown-item" href="admin/person/list">进入管理页面</a>
					    <a class="dropdown-item" href="logout">退出</a>
					  </div>
					</li>					
				</sec:authorize>  
	        </ul>
	      </div>
	    </div>
	  </nav>