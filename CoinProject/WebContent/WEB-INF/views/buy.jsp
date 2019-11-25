<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./insertorder" method="post">
sid:<input type="hidden" name="sid" value=<%=request.getParameter("sid") %>><br>
bid<input type="hidden" name="bid" value=<%=request.getParameter("bid") %>><br>
pid<input type="hidden" name="pid" value=<%=request.getParameter("pid") %>><br>
Product name: <input type="text" value=<%=request.getParameter("ppn") %> name="pn"><br><br>
Product price: <input type="number" value=<%=request.getParameter("ppc") %> name="pp"><br><br>
Category: <input type="text"  name="pc" value=<%=request.getParameter("pc") %>>
<input type="hidden" name="s" value="start">
			

<input type="submit" value="BUY">
</form>

</body>
</html>