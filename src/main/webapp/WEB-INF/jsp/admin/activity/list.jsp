<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ include file="../../layout/admin/header.jsp" %>
<link href="<c:url value="/static/css/datatables.min.css" />" rel="stylesheet">

<div class="container" style="margin-top: 20px;">
	<div class="form-group">
		<div class="col-xl-4 offset-xl-1">			
			<a href="add" class="btn btn-primary btn-lg stretched-link">新建活动</a>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-xl-3">
			<div class="input-group">				
				<select  class="custom-select" id="selectStatus">
					<c:forEach var="mymap" items="${statusItems}">
						<option value="${mymap.key}">${mymap.value}</option>
					</c:forEach>							        
		        <select>		        
		        <span class="input-group-btn">
		        	<button type="button" class="btn btn-primary" id="btnSearch">点我搜索</button>
		        </span>
			</div>
			
		</div>

    </div>
	<div class="row">

		<div class="col-xl-10">

		    
		    <table id="table1" class="table">
				<thead>
		          <tr>
					<th>编号</th>
					<th>标题</th>
					<th>摘要</th>
					<th>创建时间</th>
					<th>操作</th>    					                        		             
		          </tr>			            
				</thead>
				<tbody>
		      	<c:forEach var="activity" items="${result.elements}">
		      		<tr>
		      			<td>${activity.id}</td>
		      			<td>${activity.title}</td>
		      			<td>${activity.sketch}</td>
		      			<td>${activity.createTime}</td>
		      			<td>
							<c:if test="${activity.status ==1}">
			          			<button type="button" class="btn btn-primary btn-sm">取消发布</button>
			          			<button type="button" class="btn btn-primary btn-sm">预览</button>
			          		</c:if>	 
			          		<c:if test="${activity.status ==2}">
			          			<button type="button" class="btn btn-primary btn-sm" name="edit">修改</button>
			          			<button type="button" class="btn btn-primary btn-sm" name="publish">发布</button>
			          		</c:if>	
						</td>         			   		     				        		
		           </tr>
		      	</c:forEach>
		      	
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="../../layout/admin/footer.jsp" %>
<script type="text/javascript">
	

	$(document).ready(function () {	  	    
	    
		var status = ${status};
		
		$('#selectStatus').val(status);
		
		$('#btnSearch').click(function() {
			var status = $('#selectStatus').val();
			var url = "list?status=" + status;
			$(location).attr('href',url);
		});
	    
		$('.table').on('click', 'button', function() {
	    	$tr = $(this).closest('tr');
	    	id = $tr.find('td:first').text();
	    	var name = $(this).attr("name");
	    	if (name == "edit") {
	    		alert("还未实现");
	    	} else {
	    		$.ajax({
		    		type : "get", 
		    		url : "publish?id=" + id,
		    		success : function(msg) {
		    			if (msg == "error") {
		    				alert("发布失败，请刷新重试！");
		    			} else if (msg == "success") {
		    				$tr.remove();
		    				alert("发布成功！");
		    			}
		    		},
		    		error : function( jqXHR, textStatus) {
		    			console.log(jqXHR);
		    			console.log(textStatus);
		    		}
		    		
		    	});
	    	}
	    });
	});
	
</script>
