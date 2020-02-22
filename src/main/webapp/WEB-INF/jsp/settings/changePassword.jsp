<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ include file="../layout/user/header.jsp" %>


<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-xl-2">
			<ul class="nav nav-pills flex-column">
		        <li class="nav-item">		          
		          <a class="nav-link" href="userInfo">基本信息</a>
		        </li>
		        <li class="nav-item">		          
		          <a class="nav-link" href="educationExperience">教育经历</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="workExperience">工作经历</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">获奖情况</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link active" href="changePassword">修改密码</a>
		        </li>
		      </ul>
		</div>
		<div class="col-xl-10">
			<form:form class="bb-form validate-form" method="post" action="savePW" modelAttribute="pwModel">
			<div class="container">
		    	<div class="form-group row">
		            <form:label path="oldPassword" class="col-sm-2 col-form-label">旧密码</form:label>
		            <div class="col-sm-5">
		                <form:input type="password" class="form-control" id="inputOld" path="oldPassword" />
		                <form:errors path="oldPassword"></form:errors>
		            </div>
		        </div>
		        <div class="form-group row">
		            <form:label path="newPassword" class="col-sm-2 col-form-label">新密码</form:label>
		            <div class="col-sm-5">
		                <form:input type="password" class="form-control" id="inputNew" path="newPassword" />
		                <form:errors path="newPassword"></form:errors>
		            </div>
		        </div>
		        <div class="form-group row">
		            <form:label path="confirmedPassword" class="col-sm-2 col-form-label">确认新密码</form:label>
		            <div class="col-sm-5">
		                <form:input type="password" class="form-control" id="inputConfirm" path="confirmedPassword" />
		                <form:errors path="confirmedPassword"></form:errors>
		            </div>
		        </div>
		        <div class="form-group row">
		            <div class="col-sm-10 offset-sm-2">
		                <button type="submit" class="btn btn-primary">保存并重新登录</button>
		            </div>
		        </div>
		    </div>
			</form:form>
		</div>
	</div>
</div>

</body>
</html>