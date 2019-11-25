<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="paymentsuccess" method="post">

<input type="text" name="uid" value=<%=request.getParameter("uid") %>>
Price <input type="text" name="price" value="${d}" disabled >
<input type="submit" value="buy">
</form>
</body>
</html>