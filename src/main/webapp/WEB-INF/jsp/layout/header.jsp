  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
   <head>
	<meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" >
   		
	<title>金昌人才</title>
	<link href="<c:url value="/static/css/style.css" />" rel="stylesheet">
	<link href="<c:url value="/static/css/reset.css" />" rel="stylesheet">
	<link href="<c:url value="/static/css/animate.css" />" rel="stylesheet">

<%-- 	<link rel="stylesheet" type="text/css" href="<%=path %>/static/css/style.css"> --%>
		
   </head>
   <body>
   <section class="headerwrap ">
    <header>
		<div  class=" header">
 			<div class="top">
				<div class="wp">
					<div class="fl"><p>人才热线：<b>0935-8226212</b></p></div>
					<!--登录后跳转-->   
						<sec:authorize access="!isAuthenticated()">
							<a style="color:white" class="fr loginbtn" href="login">登录</a>
						</sec:authorize>                                     
                        <sec:authorize access="isAuthenticated()">
							<div class="personal">
	                            <dl class="user fr">
	                                <dd><sec:authentication property="principal.name" /><img class="down fr" src="<c:url value="/static/img/top_down.png" />"/></dd>
	                                <dt><img width="20" height="20" src="<c:url value="/static/img/default_profile_photo.png" />" /></dt>
	                            </dl>
	                            <div class="userdetail">
	                            	<dl>
		                                <dt><img width="80" height="80" src="<c:url value="/static/img/default_profile_photo.png" />" /></dt>
		                                <dd>
		                                    <h2><!-- 李丹阳 --><sec:authentication property="principal.name" /></h2>
		                                    <!-- <p>市司法局</p> -->
		                                </dd>
	                                </dl>
	                                <div class="btn">
		                                <a class="personcenter fl" href="user/userInfo">进入个人中心</a>
		                                <a class="fr" href="logout">退出</a>
	                                </div>
	                            </div>
	                        </div>
						</sec:authorize> 
						
						


				</div>
			</div>

            <div class="middle">
                <div class="wp">
                    <a href="index.html"><img class="fl" src="../img1/logo.png"/></a>
                    <div class="searchbox fr">
                        <div class="selectContainer fl">
                            <span class="selectOption" id="jsSelectOption" data-value="course">
                                人才标签
                            </span>
                            <ul class="selectMenu" id="jsSelectMenu">
                                <li data-value="course">活动</li>
                              
                                
                            </ul>
                        </div>
                        <input id="search_keywords" class="fl" type="text" value="" placeholder="请输入搜索内容"/>
                        <img class="search_btn fr" id="jsSearchBtn" src="../images/search_btn.png"/>
                    </div>
                </div>
            </div>
            
            
			<nav>
				<div class="nav">
					<div class="wp">
						<ul>
							<li class="active" ><a href="index.html">首页</a></li>
							<li >
								<a href="course-list.html">
									人才活动<img class="hot" src="../images/nav_hot.png">
								</a>
							</li>
							<li >
								<a href="teachers-list.html">优秀人才</a>
							</li>
							<li ><a href="org-list.html">人才招聘</a></li>
						</ul>
					</div>
				</div>
			</nav>
            
			</div>
    </header>
</section>
   