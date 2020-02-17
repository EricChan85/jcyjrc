<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ include file="header.jsp" %>


<div class="container" style="margin-top: 20px;">
	<div class="row">
		<div class="col-xl-2">
			<ul class="nav nav-pills flex-column">
		        <li class="nav-item">		          
		          <a class="nav-link" href="userInfo">基本信息</a>
		        </li>
		        <li class="nav-item">		          
		          <a class="nav-link active" href="educationExperience">教育经历</a>
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
			<div class="row" style="margin: 20px;">
	    		<div class="col-12">
	                <div style="padding: 15px;">						
						<button type="button" class="btn btn-primary" data-toggle="modal" id="btnToAdd">新增</button>
                   		<button class="btn btn-primary" type="button" id="btnToSave"> 保存 </button>
					</div>
	            </div>
	    		<table class="table">
	    			<thead>
			            <tr>
			                <th>开始日期</th>
			                <th>结束日期</th>
			                <th>教育经历</th>
			                <th>操作</th>
			            </tr>			            
			        </thead>
			        <tbody>
			        	<c:forEach var="ee" items="${modelList}">
			        		<tr>
				                <td>${ee.startDate}</td>
				                <td>${ee.endDate}</td>
				                <td>${ee.details}</td>
				                <td><button type="button" class="btn btn-primary btn-sm btnEdit">修改</button>&nbsp;<button type="button" class="btn btn-primary btn-sm btnDelete">删除</button> </td>
				            </tr>
			        	</c:forEach>
			        	
			        </tbody>
	    		</table>
	    		
	    	</div>
		</div>
	</div>
</div>
<!-- Modal HTML -->
<div id="myModal" class="modal fade" tabindex="-1">
     <div class="modal-dialog modal-lg">
         <div class="modal-content">
             <div class="modal-header">
                 <h5 class="modal-title">请填入教育经历，格式：20XX.XX-20XX.XX    XX学校  学习  。如果还在单位，请选择9999年</h5>	                   
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

<script src="<c:url value="/static/js/page/user/educationExperiences.js?v=01" />"></script>

</body>
</html>
