<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ include file="../../layout/admin/header.jsp" %>

<c:url var="staticPath" value="/static/"></c:url>
<script type="text/javascript">
<!--
var staticPath = "${staticPath}";
//-->
</script>
<%-- <script src="<c:url value="/static/js/richtext.js" />"></script>	
<script src="<c:url value="/static/js/richtext-config.js" />"></script>	 --%>

<script src="<c:url value="/static/js/nicEdit.js" />"></script>
<script type="text/javascript">
	bkLib.onDomLoaded(function() { 
		/* new nicEditor({fullPanel : true}).panelInstance('detail'); */
		/* new nicEditor({fullPanel : true}).panelInstance('area1',{hasPanel : true}); */
		nicEditors.allTextAreas();
	});
</script>

<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-xl-2">
			<ul class="nav nav-pills flex-column">
		        <li class="nav-item">		          
		          <a class="nav-link" href="list">活动列表</a>
		        </li>
		        <li class="nav-item">		          
		          <a class="nav-link active" href="add">新建活动</a>
		        </li>
		      </ul>
		</div>
		<div class="col-xl-10">
			<div class="container">
			<form:form class="bb-form validate-form" method="post" action="addActivity" modelAttribute="activity">
				<div class="form-group row">
					<form:label path="title" class="col-sm-2 col-form-label">标题</form:label>
		            <div class="col-sm-5">
		                <form:input type="text" class="form-control" path="title" maxlength="100" />
		                <%-- <form:errors path="userName" class="alert-danger"></form:errors> --%>
		            </div>
				</div>
				<div class="form-group row">
					<form:label path="sketch" class="col-sm-2 col-form-label">简述</form:label>
		            <div class="col-sm-5">
		                <form:input type="text" class="form-control" path="sketch" maxlength="500" />
		                <%-- <form:errors path="userName" class="alert-danger"></form:errors> --%>
		            </div>
				</div>
		    	<div class="form-group row">
		            <!-- <script>
					initRTE('<i>请输入。</i>', '');
					</script> -->
					<form:textarea path="detail" style="width: 100%; height: 300px;" />
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
