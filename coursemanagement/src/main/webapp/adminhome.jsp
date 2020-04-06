<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELearning - Admin Home</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>

<%
String username =(String) session.getAttribute("adminusername");
if(username==null)
{
	response.sendRedirect("/admin/");
}
%>

<div class="header1">
<h1 style="text-align: center"> Welcome<span style="color: yellow;"> <%=username.toUpperCase() %></span></h1> 

<ul>

<li ><a href="#">Faculty</a></li>
<li ><a href="/admin/students">Students</a></li>
<li ><a href="/admin/addCourse">Add Course</a></li>
<li ><a href="/admin/listcourse">List Course</a></li>
<li ><a href="/admin/adminLogout">LogOut</a></li>
</ul>

</div>
<div align="center">
<table border="2">
<!--  JSTL Core Tag -->
<c:forEach items="${studentsList}" var="student">

    <tr>
      <td>${student.name}</td>
          <td>${student.email}</td>
           <td>${student.mobile}</td>
          <td>
          <c:forEach items="${student.courseList}" var="course">
          ${course.courseName}
          </c:forEach>
          </td>
             </tr>

</c:forEach>
<c:forEach items="${courseList}" var="course">
    <tr>
      <td>${course.courseid}</td>
       <td>${course.courseName}</td>
        <td>${course.fees}</td>
         <td>${course.duration}</td>
          <td>${course.startDate}</td>
           <td>${course.endDate}</td>          
    </tr>
</c:forEach>
</table>
</div>
${addmessage}
${coursemessage}
</body>
</html>