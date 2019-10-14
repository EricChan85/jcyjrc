  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
    
    <%-- <%@page isELIgnored = "false" %> --%>
<html>
   <head>
      <title>person list</title>
   </head>

   <body>
      <h2>Person Information</h2>

         <table border="2" width="70%" cellpadding="2">
		<tr><th>Id</th><th>Name</th><th>Name</th><th>Edit</th><th>Delete</th></tr>
	    <c:forEach var="person" items="${lists}"> 
	    <tr>
	    <td>${person.id}</td>
	    <td>${person.name}</td>
	    <td>${person.name}</td>
	    <td><a href="editemp/${person.id}">Edit</a></td>
	    <td><a href="deleteemp/${person.id}">Delete</a></td>
	    </tr>
	    </c:forEach>
	    </table>
	    <br/>
    	<a href="empform">Add a person</a>
   </body>
   
</html>
    
    
    