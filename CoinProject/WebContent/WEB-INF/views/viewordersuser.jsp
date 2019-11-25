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
<table>
<tr>
<th>ProductID</th>
<th>Product Name</th>
<th>Buy Date</th>
<th>Payment Model</th>
<th>Price</th>
<th>Quantity</th>
<th>Status</th>
</tr>
<%
int uid=(int) session.getAttribute("id");
OrdersBo pb=new OrdersBo();
List<Orders> li=pb.getorderbyuid(uid);
for(Orders o:li){
%>
<tr>
<td><%=o.getProductid() %></td>
<td><%=o.getProductN() %> </td>
<td><%=o.getBuydate() %></td>
<td><%=o.getPaymentmode() %> </td>
<td><%=o.getPrice() %></td>
<td><%=o.getQuantity() %></td>
<td><%=o.getStatus() %> </td>

</tr>

</table>
<%} %>
</body>
</html>