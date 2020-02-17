<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ include file="header.jsp" %>
<style>
    .user-grid {
        width:50%;        
    }
</style>

<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-xl-2">
			<ul class="nav nav-pills flex-column">
		        <li class="nav-item">		          
		          <a class="nav-link active" href="userInfo">基本信息</a>
		        </li>
		        <li class="nav-item">		          
		          <a class="nav-link" href="educationExperience">教育经历</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">工作经历</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">获奖情况</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#">其他设置</a>
		        </li>
		      </ul>
		</div>
		<div class="col-xl-10">
			<form:form class="bb-form validate-form" method="post" action="savePerson" modelAttribute="person">
		    	<div class="row" style="margin-left: 5px; margin-top: 20px;">
		    		<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">
				            <form:label path="name" class="col-sm-3 col-form-label">姓名</form:label>
				            <div class="col-sm-8">
				                <form:input type="text" class="form-control" id="inputName" path="name" />
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">
				            <form:label path="gender" class="col-sm-3 col-form-label">性别</form:label>
				            <div class="col-sm-8">
					            <label class=" col-form-label">
					            	<form:radiobutton path="gender" value="M"/> 男      &nbsp;&nbsp;
					            </label>
					            <label class=" col-form-label">
					            	<form:radiobutton path="gender" value="F"/> 女
					            </label>
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid">
		   				<div class="form-group row">		            
				            <form:label path="dateOfBirth" class="col-sm-3 col-form-label">出生年月</form:label>
				            <div class="col-sm-8">				        
						        <form:input path="dateOfBirth" class="form-control" id="inputDateOfBirth" />
						    </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid">
		   				<div class="form-group row">		            
				            <form:label path="nationality" class="col-sm-3 col-form-label">名族</form:label>
				            <div class="col-sm-8">
						        <form:select path="nationality"  class="custom-select">
						        	<form:option value="0">请选择</form:option>
						        	<form:options items="${nationalityItems}"/>
						        </form:select>
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="nativePlace" class="col-sm-3 col-form-label" >籍贯</form:label>
				            <div class="col-sm-8">		                
				                <form:input path="nativePlace" class="form-control" />
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="birthPlace"  class="col-sm-3 col-form-label">出生地</form:label>
				            <div class="col-sm-8">		                
				                <form:input path="birthPlace"  class="form-control"/>
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="politicalStatus" class="col-sm-3 col-form-label">政治面貌</form:label>
				            <div class="col-sm-8">		                		                
				                <form:select path="politicalStatus" class="form-control">
				                	<form:option value="0">请选择</form:option>
						        	<form:options items="${politicalStatusItems}"/>
				                </form:select>
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="dateOfJoiningTheParty" class="col-sm-3 col-form-label">入党时间</form:label>
				            <div class="col-sm-8">		            	
				            	<form:input path="dateOfJoiningTheParty" class="form-control" id="inputDateOfJoinTheParty"/>
				            </div>		            
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="education"  class="col-sm-3 col-form-label">学历学位</form:label>
				            <div class="col-sm-8">		                
				                <form:input path="education"  class="form-control" />
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="healthCondition" class="col-sm-3 col-form-label">健康状况</form:label>
				            <div class="col-sm-8">		                
				                <form:input path="healthCondition" class="form-control"/>
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="dateOfStartingToWork" class="col-sm-3 col-form-label">参加工作时间</form:label>
				            <div class="col-sm-8">		            	
				            	<form:input path="dateOfStartingToWork" class="form-control" id="inputDateOfStartingToWork"/>
				            </div>		            
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">
				            <!-- <label for="inputDateOfEntering" class="col-sm-3 col-form-label">引进时间</label> -->
				            <form:label path="dateOfEntering" class="col-sm-3 col-form-label">引进时间</form:label>
				            <div class="col-sm-8">
				            	<!-- <input type="text" class="form-control" id="inputDateOfEntering" name="dateOfEntering"> -->
				            	<form:input path="dateOfEntering" class="form-control" id="inputDateOfEntering"/>
				            </div>		            
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="numberOfIdCard" class="col-sm-3 col-form-label">身份证号</form:label>
				            <div class="col-sm-8">		                
				                <form:input path="numberOfIdCard" class="form-control" />
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="phone" class="col-sm-3 col-form-label">联系电话</form:label>
				            <div class="col-sm-8">		                
				                <form:input path="phone" class="form-control" />
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="institution" class="col-sm-3 col-form-label">工作单位</form:label>
				            <div class="col-sm-8">		                
				                <form:input path="institution" class="form-control" />
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid" >
		   				<div class="form-group row">		            
				            <form:label path="position" class="col-sm-3 col-form-label">职务</form:label>
				            <div class="col-sm-8">		                
				                <form:input path="position" class="form-control" />
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid">
		   				<div class="form-group row">		            
				            <form:label path="professionalTechnicalPosition" class="col-sm-3 col-form-label">专业技术职务</form:label>
				            <div class="col-sm-8">		                
				                <form:input path="professionalTechnicalPosition" class="form-control"/>
				            </div>
				        </div>
		   			</div>
		   			<div class="col-xs-6 user-grid">
		   				<div class="form-group row">		            
				            <form:label path="address" class="col-sm-3 col-form-label">住址</form:label>
				            <div class="col-sm-8">		                
				                <form:input path="address" class="form-control"/>
				            </div>
				        </div>
		   			</div>
		   			<div class="login-container-form-btn">
		               <div class="bb-login-form-btn">
		                   <div class="bb-form-bgbtn"></div> 
		                   <button class="btn btn-primary" name="submit" type="submit"> 保存 </button> <input type="hidden" name="id" value="${person.id}" />
		               </div>
		           </div>
		    	</div>
				</form:form>
		</div>
	</div>
</div>


<script type="text/javascript">
	

	$(document).ready(function () {	  
	    
	    $('#inputDateOfJoinTheParty').monthpicker();
	    $('#inputDateOfBirth').monthpicker();
	    $('#inputDateOfStartingToWork').monthpicker();
	    $('#inputDateOfEntering').monthpicker();
	});
</script>

</body>
</html>