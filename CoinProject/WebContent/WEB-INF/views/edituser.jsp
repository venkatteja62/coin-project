<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div><jsp:include page="header1.jsp"></jsp:include></div>
<div><jsp:include page="dashboard.jsp"></jsp:include></div>


<form action="./updateuser" method="post">
<input type="hidden" name="id" value=<%=request.getParameter("uid") %>>
User Name :<input type="text" name="uname" value=<%=request.getParameter("un") %>><br><br>
Email Id :<input type="text" name="uemail" value=<%=request.getParameter("ue") %>><br><br>
Mobile :<input type="text" name="umobile" value=<%=request.getParameter("um") %>><br><br>
Password :<input type="text" name="upass" value=<%=request.getParameter("up") %>><br><br>
ConfirmPassword :<input type="hidden" name="ucpass" value=<%=request.getParameter("up") %>>
Date Of Birth <input type="date" name="udob" value=<%=request.getParameter("ud") %>><br><br>
Gender :<select name="ugender">
<option ><%=request.getParameter("ug") %></option>
<option value="Male">Male</option>
<option value="Female">Female</option>
<option value="Other">Other</option>

</select><br><br>

Security Question :<select name="usecurity">
<option value="Favorite Color">Favorite Color</option>
<option value="Favorite Game">Favorite Game</option>
<option value="First School">First School</option>
<option value="Favorite Movie">Favorite Movie</option>
<option value="Favorite Song">Favorite Song</option>
</select><br><br>
Answer :<input type="text" name="uanswer" value=<%=request.getParameter("ua") %>><br><br>

City :<input type="text" name="ucity" ><br><br>

<input type="submit" value="submit">
</form>

</body>
</html>