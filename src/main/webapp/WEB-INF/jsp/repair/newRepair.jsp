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
		          <a class="nav-link" href="myRepair">我的报修</a>
		        </li>
		        <li class="nav-item">		          
		          <a class="nav-link active" href="newRepair">我要报修</a>
		        </li>
		      </ul>
		</div>
		<div class="col-xl-8">
			<form:form id="from" class="bb-form validate-form" method="post" action="createRepair" modelAttribute="model">
			<div class="container">
		    	<div class="form-group row">	                    		                 		                 		
               		<form:label path="details" class="col-sm-2 col-form-label">报修事项</form:label>
               		<div class="col-sm-8">               			
               			<form:textarea path="details" row="5" class="form-control"/>
               			<form:errors path="details"></form:errors>	
               		</div>
               				            
               	</div>
               	<div class="form-group row">
               		<form:label path="details" class="col-sm-2 col-form-label">维修时间</form:label>
               		<div class="col-sm-9 row">
               			<div class="col-sm-5">				                
			                <form:input path="startTime" type="text" class="form-control" id="inputStartTime" autocomplete='off' />
			                <form:errors path="startTime"></form:errors>	
			            </div>
			            <label class="col-sm-1 col-form-label">~</label>
			            <div class="col-sm-5">				                
			                <form:input path="endTime" type="text" class="form-control" id="inputEndTime" autocomplete='off' />
			                <form:errors path="endTime"></form:errors>	
			            </div>
               		</div>
	            
               	</div>
               	<div class="form-group row">
               		<form:label path="address" class="col-sm-2 col-form-label">维修地点</form:label>
               		<div class="col-sm-8">
               			<form:input path="address" type="text" class="form-control" />
               			<form:errors path="address"></form:errors>
               		</div>               			
               	</div>
               	<div class="form-group row">
               		<form:label path="phone" class="col-sm-2 col-form-label">联系电话</form:label>
               		<div class="col-sm-8">
               			<form:input path="phone" type="text" class="form-control" />
               			<form:errors path="phone"></form:errors>
               		</div>               			
               	</div>
               	<div class="form-group row">
               		<div class="col-sm-3 offset-sm-2">
               			<button type="button" class="btn btn-primary btn-lg btn-block" id="btnSave">提交</button>	
               		</div>
               	</div>
               	
		    </div>
			</form:form>
		</div>
	</div>
	<div id="myModal" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title">确认</h5>
	            </div>
	            <div class="modal-body">                          
	                <p>报修提交后不能修改，确定要提交报修申请吗？</p>
	            	<p class="text-secondary"><small>提交前请确认预约报修时间是否合理.</small></p>               
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-secondary" data-dismiss="modal" id="modal-btn-no">取消</button>
	                <button type="button" class="btn btn-primary" id="modal-btn-yes">提交</button>
	            </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../layout/user/footer.jsp" %>
<script src="<c:url value="/static/js/jquery.datetimepicker.js" />"></script>
<script type="text/javascript">
<!--
	$(document).ready(function() {
		
		$('#inputStartTime').datetimepicker({
			lang:'ch'
		});
		
		$('#inputEndTime').datetimepicker({
			lang:'ch'
		});
		
		var modalConfirm = function(callback){
			
			$('#btnSave').on('click', function() {
				$('#myModal').modal('show');			
			}); 
			
			$("#modal-btn-yes").on("click", function(){
				callback(true);
				$("#mi-modal").modal('hide');
			});
			  
			$("#modal-btn-no").on("click", function(){
				callback(false);
				$("#mi-modal").modal('hide');
			});
		};
		
		
		
		modalConfirm(function(confirm){
			if(confirm){
			  $('#from').submit();
			}
		});
	});
//-->
</script>
