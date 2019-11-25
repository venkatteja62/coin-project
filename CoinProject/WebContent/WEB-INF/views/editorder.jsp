<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./editordersuccess" method="post">
<input type="text" name="oid1" value="<%=request.getParameter("oid") %>" disabled><br><br>
<input type="hidden" name="oid" value="<%=request.getParameter("oid") %>">
<input type="hidden" name="pid" value=<%=request.getParameter("pid") %>>
<input type="hidden" name="p" value=<%=request.getParameter("p") %>>
<input type="hidden" name="pn" value=<%=request.getParameter("pn") %>>
<input type="hidden" name="bd" value=<%=request.getParameter("bd") %>>
<input type="hidden" name="bid" value=<%=request.getParameter("bid") %>>
<input type="hidden" name="sid" value=<%=request.getParameter("sid") %>>
<input type="hidden" name="c" value=<%=request.getParameter("c") %>>
<input type="text" name="s" value=<%=request.getParameter("s") %>>
<input type="hidden" name="pm" value=<%=request.getParameter("pm") %>>
<input type="hidden" name="q" value=<%=request.getParameter("q") %>>


<input type="submit" value="Update">
</form>
</body>
</html>