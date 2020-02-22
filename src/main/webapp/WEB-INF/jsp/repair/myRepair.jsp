<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ include file="../layout/user/header.jsp" %>


<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-xl-6 offset-xl-2">
			<button type="button" class="btn btn-primary" data-toggle="modal" id="btnToAdd">新增</button>
		</div>
	</div>
	<table class="table">
		<thead>
          <tr>
          	<th>编号</th>
              <th>详情</th>              
              <th>预定维修时间</th>
              <th>状态</th>
              <th>创建时间</th>
              <th>操作</th>
          </tr>			            
		</thead>
		<tbody>
      	<c:forEach var="repair" items="${list}">
      		<tr>
      			<td>${repair.id}</td>
      			<td>${repair.details}</td>
         		<td>${repair.startTime}~${repair.endTime}</td>
     			<td>已提交</td>
        		<td>${repair.createTime}</td>
          		<td><button type="button" class="btn btn-primary btn-sm btnEdit">修改</button>&nbsp;<button type="button" class="btn btn-primary btn-sm btnDelete">删除</button> </td>
           </tr>
      	</c:forEach>
      	
		</tbody>
	</table>
</div>
<!-- Modal HTML -->
<div id="myModal" class="modal fade" tabindex="-1">
     <div class="modal-dialog modal-lg">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title">报修</h5>	                   
             </div>
             <div class="modal-body">
                 
                 <div class="container">
                 	<div class="row">	                    		
                 		<div class="col-sm-2">
                 			<input  class="form-control" type="text" id="inputStart" />
                 		</div>
                 		 - 
                 		<div class="col-sm-2">
                 			<input  class="form-control" type="text" id="inputEnd"  />
                 		</div>
                 		<div class="col-sm-7">
                 			<input  class="form-control" type="text" id="inputStudy" />
                 		</div>
                 	</div>
                 </div>
             </div>
             <div class="modal-footer">
             	<div class="alert alert-warning alert-dismissible fade show" id="divMsg">
	         	教育经历为必填项.					        
	    </div>
                 <button type="button" class="btn btn-secondary" id="btnCancel">取消</button>
                 <button type="button" class="btn btn-primary" id="btnFinish">确认</button>
             </div>
         </div>
     </div>
 </div>	

<%-- <script src="<c:url value="/static/js/page/user/workExperience.js?v=01" />"></script> --%>

</body>
</html>
