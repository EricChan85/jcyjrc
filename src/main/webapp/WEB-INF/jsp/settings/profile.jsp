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
		          <a class="nav-link active" href="#">人才简介</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="changePassword">修改密码</a>
		        </li>
		      </ul>
		</div>
		<div class="col-xl-10">
			<div class="container">			
		    	<div class="form-group row">
		    		<label class="col-sm-5 col-form-label">用简短的话介绍自己</label>
					<textarea id="profile" name="detail" style="width: 100%; height: 300px;">${profile}				
					</textarea>
		        </div>
		    	<div class="form-group row">
		   			<div class="col-sm-5 offset-sm-2">
		   				<button class="btn btn-primary" type="button" id="btnSave"> 保存 </button>
		   			</div>
		   		</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../layout/user/footer.jsp" %>

<script type="text/javascript">	

	$(document).ready(function () {	  
	    
		/* var profile = "[[${profile}]]";
		$('#profile').val(profile); */
		
		$('#btnSave').click(function() {
			var desData = {				
				"profile" : $('#profile').val()
			};
			$.ajax({
	    		type : "post", 
	    	    dataType : 'text',
	    		url : "saveProfile",
	    		data : desData,
	    		success : function(msg) {
	    			if (msg == "error") {
	    				alert("保存 失败，请刷新重试！");
	    			} else if (msg == "success") {
	    				alert("保存 成功！");
	    			}
	    		},
	    		error : function( jqXHR, textStatus) {
	    			console.log(jqXHR);
	    			console.log(textStatus);
	    		}
	    		
	    	});
		});
	});
</script>