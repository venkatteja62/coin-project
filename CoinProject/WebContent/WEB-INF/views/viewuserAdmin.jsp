<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
User Details</h1>
<table>
<tr>
<th>User Id</th>
<th>User Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Password</th>
<th>Date Of Birth</th>
<th>Gender</th>

<th>Answer</th>


</tr>
<c:forEach items="${li}" var="p">
 <tr>
<td>${p.userID }</td>
<td>${p.userName}</td>
<td>${p.userEmail}</td>
<td>${p.userMobile}</td>
<td>${p.password}</td>
<td>${p.userDOB}</td>
<td>${p.gender}</td>

<td>${p.answer}</td>


<td><form action="editadminu" method="post">
<input type="hidden" name="uid" value=${p.userID }>
<input type="hidden" name="un" value=${p.userName }>
<input type="hidden" name="ue" value=${p.userEmail }>
<input type="hidden" name="um" value=${p.userMobile }>
<input type="hidden" name="up" value=${p.password }>
<input type="hidden" name="ud" value=${p.userDOB }>
<input type="hidden" name="ug" value=${p.gender }>

<input type="hidden" name="ua" value=${p.answer }>

<input type="submit" value="Edit">
</form></td>
 </tr>
 </c:forEach>

</table>
</body>
</html>