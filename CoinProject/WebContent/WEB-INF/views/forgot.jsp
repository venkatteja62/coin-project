<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./ForgotServlet" method="post">
 Mobile :<input type="text" name ="id" ><br><br>
<input type="submit" value="validate"><br><br>
</form>
<h1>OR</h1>
<form action="./forgotemail" method="post">
Email :<input type="text" name="id"><br><br>
<input type="submit" value="validate">

</form>
</body>
</html>