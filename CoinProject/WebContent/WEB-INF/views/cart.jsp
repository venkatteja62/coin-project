<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*, com.mphasis.CoinProject.Bo.*,com.mphasis.CoinProject.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ProductBo pb=new ProductBo();
int pid=Integer.parseInt(request.getParameter("pid"));
int quantity=pb.getProductqbypid(pid);

%>
<form action="insertintocart" method="post">
<input type="hidden" name="productid" value=<%=request.getParameter("pid")%>>
<input type="hidden" name="productname" value=<%=request.getParameter("ppn")%>>
product name<input type="text" name="productname" value="<%=request.getParameter("ppn")%>"disabled><br><br>
quantity<input type="text" name="quantity" value=1><%=quantity%><br><br>
price<input type="text" name="productprice" value="<%=request.getParameter("ppc")%>"disabled><br><br>
<input type="hidden" name="productprice" value=<%=request.getParameter("ppc")%>>
<input type="hidden" name="buyerid" value=<%=request.getParameter("bid")%>>
<input type="hidden" name="sellerid" value=<%=request.getParameter("sid")%>>
<input type="submit" value="Add to Cart">
</form>
</body>
</html>