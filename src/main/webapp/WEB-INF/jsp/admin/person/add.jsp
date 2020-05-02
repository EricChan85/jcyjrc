<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ include file="../../layout/admin/header.jsp" %>

<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-xl-2">
			<ul class="nav nav-pills flex-column">
		        <li class="nav-item">		          
		          <a class="nav-link" href="list">人员列表</a>
		        </li>
		        <li class="nav-item">		          
		          <a class="nav-link active" href="add">新增人员</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="workExperience">工作经历</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">获奖情况</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="changePassword">修改密码</a>
		        </li>
		      </ul>
		</div>
		<div class="col-xl-10">
			<div class="container">
			<form:form class="bb-form validate-form" method="post" action="newPerson" modelAttribute="person">
		    	<div class="form-group row">
		            <form:label path="name" class="col-sm-2 col-form-label">姓名</form:label>
		            <div class="col-sm-5">
		                <form:input type="text" class="form-control" path="name" maxlength="15" />
		                <form:errors path="name" class="alert-danger"></form:errors>
		            </div>
		        </div>
		    	<div class="form-group row">
		            <form:label path="userName" class="col-sm-2 col-form-label">登录名</form:label>
		            <div class="col-sm-5">
		                <form:input type="text" class="form-control" path="userName" maxlength="30" />
		                <form:errors path="userName" class="alert-danger"></form:errors>
		            </div>
		        </div>
				<div class="form-group row">		            
		            <form:label path="numberOfIdCard" class="col-sm-2 col-form-label">身份证号</form:label>
		            <div class="col-sm-5">		                
		                <form:input path="numberOfIdCard" class="form-control" maxlength="18" />
		                <form:errors path="numberOfIdCard" class="alert-danger"></form:errors>
		            </div>
		        </div>

		   		<div class="form-group row">		            
		            <form:label path="role" class="col-sm-2 col-form-label">角色</form:label>
		            <div class="col-sm-5">		                		                
		                <form:select path="role" class="form-control">				                	
				        	<form:options items="${roleTypes}"/>
		                </form:select>
		            </div>
		        </div>
		   		<div class="form-group row">
		   			<div class="col-sm-5 offset-sm-2">
		   				<button class="btn btn-primary" name="submit" type="submit"> 保存 </button>
		   			</div>
		   		</div>
		    	
				</form:form>
			</div>
		</div>
	</div>
</div>

<%@ include file="../../layout/admin/footer.jsp" %>
<script type="text/javascript">
	

	$(document).ready(function () {	  
	    
		var result = "${result}";
		if (result != "") {
			alert(result);
		}
	});
</script>
