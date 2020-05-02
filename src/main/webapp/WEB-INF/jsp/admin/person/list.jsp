<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ include file="../../layout/admin/header.jsp" %>
<link href="<c:url value="/static/css/datatables.min.css" />" rel="stylesheet">

<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-xl-2">
			<ul class="nav nav-pills flex-column">
		        <li class="nav-item">		          
		          <a class="nav-link active" href="list">人员列表</a>
		        </li>
		        <li class="nav-item">		          
		          <a class="nav-link" href="add">新增人员</a>
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
			<!-- <div class="form-group row">
				<div class="col-xl-3">
					<div class="input-group">				
						<input type="text" class="form-control" maxlength="15" />	        
				        <span class="input-group-btn">
				        	<button type="button" class="btn btn-primary" id="btnSearch">点我搜索</button>
				        </span>
					</div>
					
				</div>
		
		    </div> -->
		    <div class="form-group row">
		    	<div class="col-xl-3">
		    		<button type="button" class="btn btn-primary" id="btnResetPassword">重置密码</button>
		    	</div>
		    </div>
		    <table id="table1" class="display nowrap" style="width:100%">
				<thead>
		          <tr>
					<th>编号</th>
					<th>姓名</th>
					<th>出生日期</th>
					<th>名族</th>
					<th>籍贯</th>    					                        		             
					<th>性别</th>
					<th>政治面貌</th>
					<th>引进时间</th>					
					<th>工作单位</th>
					<th>住址</th>
					<th>电话</th>
		          </tr>			            
				</thead>
				<tbody>
		      	<c:forEach var="person" items="${list}">
		      		<tr>
		      			<td>${person.id}</td>
		      			<td>${person.name}</td>
		      			<td>${person.dateOfBirth}</td>
		      			<td>${person.nationality}</td>
		      			<td>${person.nativePlace}</td>         			
		      			<td>${person.gender}</td>
		      			<td>${person.politicalStatus}</td>
		      			<td>${person.dateOfEntering}</td>
		      			<td>${person.institution}</td>
		      			<td>${person.address}</td>
		      			<td>${person.phone}</td>
   		     				        		
		           </tr>
		      	</c:forEach>
		      	
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="../../layout/admin/footer.jsp" %>
<script src="<c:url value="/static/js/datatables.min.js" />"></script>
<script type="text/javascript">
	

	$(document).ready(function () {	  
	    
	    $('#table1').DataTable({
	    	paging: true,
	    	scrollY: 400,
	    	"scrollX": true,
	    	"lengthMenu": [[50, 100, -1], [50, 100, "All"]]
	    });
	    
	    var table = $('#table1').DataTable();
	    
	    $('#table1 tbody').on( 'click', 'tr', function () {
	    	if ( $(this).hasClass('selected') ) { 
	    		$(this).removeClass('selected'); 
	    	} else { 
	    		table.$('tr.selected').removeClass('selected'); 
	    		$(this).addClass('selected'); 
	    	} 
	    } );
	 
	    $('#btnResetPassword').click( function () {		    	
	        var id = table.$('tr.selected').find('td:first').text();
	        if (id != "") {
	        	$.ajax({
		    		type : "post", 
		    	    dataType : 'text',
		    		url : '<c:url value="/admin/person/resetPW" />',
		    		data : { "id" : id},
		    		success : function(msg) {
		    			if (msg == "error") {
		    				alert("重置密码失败！");
		    			} else if (msg == "success") {
		    				alert("重置密码成功！");
		    			}
		    		},
		    		error : function( jqXHR, textStatus) {
		    			console.log(jqXHR);
		    			console.log(textStatus);
		    		}
		    		
		    	});
	        } else {
	        	alert("请先选择要操作的行！");
	        }
	        
	    } );
	});
	
</script>
