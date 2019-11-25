<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.mphasis.CoinProject.Bo.*,com.mphasis.CoinProject.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="./Forgot1Servlet" method="post">
<input type="hidden" name="id" value=<%=request.getParameter("id")%>>
Enter DoB :<input type="text" name ="name" > yyy-mm-dd<br><br>
Enter S.Quection :<select name="nameq"  >
<option value=""></option>
<option value="Favorite Color">Favorite Color</option>
<option value="Favorite Game">Favorite Game</option>
<option value="First School">First School</option>
<option value="Favorite Movie">Favorite Movie</option>
<option value="Favorite Song">Favorite Song</option>

</select><br><br>
Enter S.Ans :<input type="text" name="name1"><br><br>
<input type="submit" value="Confirm">
</form>
</body>
</html>