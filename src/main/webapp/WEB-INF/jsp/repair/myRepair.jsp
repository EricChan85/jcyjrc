<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ include file="../layout/user/header.jsp" %>

<style type="text/css">
  	.form-rounded {
	border-radius: 1rem;
	}
</style>			


<div class="container" style="margin-top: 20px;">
	<div class="form-group">
		<div class="col-xl-4 offset-xl-1">			
			<a href="newRepair" class="btn btn-primary btn-lg stretched-link">我要报修</a>
		</div>
	</div>
	<table class="table">
		<thead>
          <tr>
          	<th>编号</th>
              <th>详情</th>              
              <th>预定维修时间</th>
              <th>状态</th>
              <th>评价</th>
              <th>申请报修时间</th>              
              <th>操作</th>
          </tr>			            
		</thead>
		<tbody>
      	<c:forEach var="repair" items="${list}">
      		<tr>
      			<td>${repair.id}</td>
      			<td>${repair.details}</td>
         		<td>${repair.startTime}~${repair.endTime}</td>
     			<td>${repair.statusValue}</td>        		
        		<td>${repair.evaluation }</td>
        		<td>${repair.createTime}</td>
          		<td>
	          		<c:if test="${repair.status ==2}">
	          			<button type="button" class="btn btn-primary btn-sm">评价</button>
	          		</c:if>	          		
          		</td>
           </tr>
      	</c:forEach>
      	
		</tbody>
	</table>
</div>
<!-- Modal HTML -->

<div id="myModal" class="modal fade" tabindex="-1">
     <div class="modal-dialog model-xl">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title">请对本次维修做出评价</h5>	                   
             </div>
             
             <div class="modal-body">
                 
                 <div class="container">
                 	<div class="form-group ">	                    		                 		                 		                 		
            			<label for="inputEvaluation">评价内容</label>
            			<textarea class="form-control" style="border-radius: 1rem;" rows="3" id="inputEvaluation"></textarea>              
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

<%@ include file="../layout/user/footer.jsp" %>
<<script type="text/javascript">
<!--
	$(document).ready(function() {
		var $tr;			
		var id;
		$('.table').on('click', 'button', function() {
	    	$tr = $(this).closest('tr');
	    	id = $tr.find('td:first').text();
	    	$("#myModal").modal('show');
	    });
		
		$('#btnSave').click(function() {
			var evaluation = $('#inputEvaluation').val();
			var evaluationData = {
				"id" : id,
				"evaluation" : evaluation
			};
			$.ajax({
	    		type : "post", 
	    	    dataType : 'text',
	    		url : "saveEvaluation",
	    		data : evaluationData,
	    		success : function(msg) {
	    			if (msg == "error") {
	    				alert("保存 失败，请刷新重试！");
	    			} else if (msg == "success") {
	    				$tr.find('td').eq(4).text(evaluation);
	    				$tr.find('td').eq(6).text("");
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
		
		$('#btnCancel').click(function() {
	    	$("#myModal").modal('hide');
	    });
		
		
	});
//-->
</script>


