<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./updatesuccess" method="post">
<input type="hidden" name="id" value=<%=request.getParameter("id") %>>
Enter Password :<input type="text" name ="pass" ><br><br>

Re-Enter Password :<input type="text" name="pass1"><br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>