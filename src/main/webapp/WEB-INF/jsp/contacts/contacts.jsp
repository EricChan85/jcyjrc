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
		          <a class="nav-link active" href="contacts">通讯录</a>
		        </li>
		      </ul>
		</div>
		<div class="col-xl-10">		
			<div class="container">		    	
		        <table id="contacts" class="table table-hover" style="width:100%">
		        	<thead>
			            <tr class="thead-light">
			            	<th>序号</th>
			                <th>姓名</th>
			                <th>电话</th>
			                <th>住址</th>
			            </tr>
			        </thead>
			        <tbody>
			        	<c:forEach var="person" items="${result.elements}" varStatus="status">
			        		<tr>
			        			<td>${status.index + 1 + (result.pageIndex - 1) * result.limit}</td>
				                <td>${person.name}</td>
				                <td>${person.phone}</td>
				                <td>${person.address}</td>				                
				            </tr>
			        	</c:forEach>
			        </tbody>
		        </table>
		        <nav>
			        <ul class="pagination justify-content-end">			        	
			            <li class="page-item ${result.pageIndex - 1 > 0 ? '' : 'disabled'}"><a href="contacts?page=${result.pageIndex - 1}" class="page-link">上一页</a></li>
			            <c:if test="${result.pageIndex > 2}">
			            	<li class="page-item"><a href="contacts?page=${result.pageIndex - 2}" class="page-link">${result.pageIndex - 2}</a></li>
			            </c:if>
			            <c:if test="${result.pageIndex > 1}">
			            	<li class="page-item"><a href="contacts?page=${result.pageIndex - 1}" class="page-link">${result.pageIndex - 1}</a></li>
			            </c:if>
			            	<li class="page-item active"><a href="#" class="page-link"><c:out value = "${result.pageIndex}"/></a></li>
			            	
			            <c:if test="${result.pageIndex < result.pageCount}">
			            	<li class="page-item"><a href="contacts?page=${result.pageIndex + 1}" class="page-link"><c:out value = "${result.pageIndex + 1}"/></a></li>
			            </c:if>
			            <c:if test="${result.pageIndex + 1 < result.pageCount}">
			            	<li class="page-item"><a href="contacts?page=${result.pageIndex + 2}" class="page-link"><c:out value = "${result.pageIndex + 2}"/></a></li>
			            </c:if>
			            <li class="page-item ${result.pageIndex < result.pageCount ? '' : 'disabled'}"><a href="contacts?page=${result.pageIndex + 1}" class="page-link">下一页</a></li>
			        </ul>
			    </nav>
		    </div>			
		</div>
	</div>
</div>


</body>
</html>