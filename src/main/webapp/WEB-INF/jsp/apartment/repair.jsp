  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/user";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta name="renderer" content="webkit">
	    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" >
		<title>个人中心</title>
		<link href="<c:url value="/static/css/bootstrap4.3.1.min.css" />" rel="stylesheet">
		<link href="<c:url value="/static/css/jquery-ui.css" />" rel="stylesheet">				
	    <style type="text/css">
	    	.form-rounded {
				border-radius: 1rem;
				}
	    </style>
	</head>
<body>
<div class="jumbotron" style="margin-bottom:0; padding : 0.5em;">
	<div class="container">
		<div class="row">
			<div class="col-xl-6">
				<p>服务电话：<strong>0935-8226212</strong></p>
			</div>
			<div class="col-xl-6 d-inline-flex flex-row-reverse">
				<sec:authorize access="isAuthenticated()">
				<div class="p-2"><a href="<c:url value="/logout" />">退出</a></div>
				<div class="p-2"><sec:authentication property="principal.name" /></div>
				<div class="p-2"><img width="20" height="20" src="<c:url value="/static/img/default_profile_photo.png" />"/></div>								
				</sec:authorize>
			</div>
		</div>
		
	</div>		
</div>
<nav class="navbar navbar-expand-xl bg-primary navbar-dark">
	<div class="container">
		<a href="index.html"><img  width="60" height="60" class="fl" src="<c:url value="/static/img/logo.jpg" />"/></a>
		<div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav">
                <a class="nav-item nav-link" href="<c:url value="/welcome" />">首页 <span class="sr-only">(current)</span></a>
                <a class="nav-item nav-link active" href="<c:url value="/apartment/repair" />">公寓报修</a>
            </div>
        </div>	
	</div>
</nav>

<div class="container" style="margin-top: 20px;">
	<form>
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
    </form>
	
	<table class="table">
		<thead>
          <tr>
          	<th>编号</th>
              <th>详情</th>                            
              
              <th>创建时间</th>
              <th>地址</th>
              <th>联系方式</th>
              <c:set var = "myStatus" scope = "session" value = "${status}"/>
              <c:choose>
              	<c:when test="${myStatus == 1}">              		
              		<th>预约维修时间</th>
              		<th>操作</th>            		
              	</c:when>
              	<c:when test="${myStatus == 2}">              		
              		<th>维修情况</th>
              	</c:when>
              	<c:when test="${myStatus == 3}">              		
              		<th>评价</th>
              	</c:when>
              </c:choose>
              
              
              
          </tr>			            
		</thead>
		<tbody>
      	<c:forEach var="repair" items="${result.elements}">
      		<tr>
      			<td>${repair.id}</td>
      			<td>${repair.details}</td>      			
      			<td>${repair.createTime}</td>
      			<td>${repair.address}</td>
      			<td>${repair.phone}</td>
      			<c:choose>
	              	<c:when test="${repair.status == 1}">	              		     					     					
     					<td>${repair.startTime}~${repair.endTime}</td>
     					<td><button type="button" class="btn btn-primary btn-sm">完成修理</button></td>
	              	</c:when>
	              	<c:when test="${repair.status == 2}">              		
	              		<td>${repair.repairDescription}</td>
	              	</c:when>
	              	<c:when test="${repair.status == 3}">              		
	              		<td>${repair.evaluation}</td>
	              	</c:when>
	          	</c:choose>         		     		
        		
          		
           </tr>
      	</c:forEach>
      	
		</tbody>
	</table>
	<nav>
        <ul class="pagination justify-content-end">			        	
            <li class="page-item ${result.pageIndex - 1 > 0 ? '' : 'disabled'}"><a href="repair?page=${result.pageIndex - 1}" class="page-link">上一页</a></li>
            <c:if test="${result.pageIndex > 2}">
            	<li class="page-item"><a href="repair?page=${result.pageIndex - 2}" class="page-link">${result.pageIndex - 2}</a></li>
            </c:if>
            <c:if test="${result.pageIndex > 1}">
            	<li class="page-item"><a href="repair?page=${result.pageIndex - 1}" class="page-link">${result.pageIndex - 1}</a></li>
            </c:if>
            	<li class="page-item active"><a href="#" class="page-link"><c:out value = "${result.pageIndex}"/></a></li>
            	
            <c:if test="${result.pageIndex < result.pageCount}">
            	<li class="page-item"><a href="repair?page=${result.pageIndex + 1}" class="page-link"><c:out value = "${result.pageIndex + 1}"/></a></li>
            </c:if>
            <c:if test="${result.pageIndex + 1 < result.pageCount}">
            	<li class="page-item"><a href="repair?page=${result.pageIndex + 2}" class="page-link"><c:out value = "${result.pageIndex + 2}"/></a></li>
            </c:if>
            <li class="page-item ${result.pageIndex < result.pageCount ? '' : 'disabled'}"><a href="repair?page=${result.pageIndex + 1}" class="page-link">下一页</a></li>
        </ul>
    </nav>
</div>
<!-- Modal HTML -->

<div id="myModal" class="modal fade" tabindex="-1">
     <div class="modal-dialog model-xl">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title">维修工作描述（例如：使用消耗品电灯泡，水管）</h5>	                   
             </div>
             
             <div class="modal-body">
                 
                 <div class="container">
                 	<div class="form-group ">	                    		                 		                 		
                 		<label for="inputDescription">维修工作描述</label>
            			<textarea class="form-control form-rounded" rows="3" id="inputDescription"></textarea>            
                 	</div>
                 	
                 </div>
             </div>
             <div class="modal-footer">
                 <button type="button" class="btn btn-secondary" id="btnCancel">取消</button>
                 <button type="submit" class="btn btn-primary" id="btnSave">确认</button>
             </div>         
         </div>
     </div>
 </div>	
 
 <script src="<c:url value="/static/js/jquery.min.js" />"></script>
 <script src="<c:url value="/static/js/bootstrap4.3.1.min.js" />"></script>		
<script src="<c:url value="/static/js/jquery-ui.min.js" />"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var id;
		var status = ${status};
		var $tr;
		$('#selectStatus').val(status);
		$('.pagination').find('a').each(function() {			
			$(this).attr('href', $(this).attr('href') + "&status=" + status);
		});		
		
		$('#btnSearch').click(function() {
			var status = $('#selectStatus').val();
			var url = "repair?status=" + status;
			$(location).attr('href',url);
		});
		
		$('.table').on('click', 'button', function() {
	    	$tr = $(this).closest('tr');
	    	id = $tr.find('td:first').text();
	    	$("#myModal").modal('show');
	    });
		
		$('#btnCancel').click(function() {
			$("#myModal").modal('hide');
		});
		
		$('#btnSave').click(function() {
			var desData = {
				"id" : id,
				"description" : $('#inputDescription').val()
			};
			$.ajax({
	    		type : "post", 
	    	    dataType : 'text',
	    		url : "saveDescription",
	    		data : desData,
	    		success : function(msg) {
	    			if (msg == "error") {
	    				alert("保存 失败，请刷新重试！");
	    			} else if (msg == "success") {
	    				$tr.remove();
	    				alert("保存 成功！");
	    			}
	    		},
	    		error : function( jqXHR, textStatus) {
	    			console.log(jqXHR);
	    			console.log(textStatus);
	    		}
	    		
	    	});
			$("#myModal").modal('hide');
		});
	});
</script>		
</body>
</html>

