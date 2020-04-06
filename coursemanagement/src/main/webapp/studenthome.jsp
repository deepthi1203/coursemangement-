<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elearning-StudentHome</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<%
String name =(String) session.getAttribute("studentname");
if(name==null)
{
	response.sendRedirect("/admin/");
}
%>

<div class="header1">
<h1 style="text-align: center"> Welcome<span style="color: yellow;"> <%=name.toUpperCase() %></span></h1> 

<ul>

<li ><a href="#">View MyProfile</a></li>
<li ><a href="/listcourse">List Course</a></li>
<li ><a href="/mycourse">View  MyCourse</a></li>
<li ><a href="Logout">LogOut</a></li>
</ul>
</div>
<div align="center">
<table border="2">
<!--  JSTL Core Tag -->
<c:forEach items="${courseList}" var="course">

    <tr>
      <td>${course.courseid}</td>
       <td>${course.courseName}</td>
        <td>${course.fees}</td>
         <td>${course.duration}</td>
          <td>${course.startDate}</td>
           <td>${course.endDate}</td>
           <td> <a href="/applycourse?couresid=${course.courseid}" style="color: yellow;">Take This Course</a> </td>
    </tr>

</c:forEach>

</table>

</div>

</body>
</html>