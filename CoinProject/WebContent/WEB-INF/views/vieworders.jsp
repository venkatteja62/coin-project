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
List<Orders> li=pb.getorder();
for(Orders o:li){
%>
<tr>
<td><%=o.getProductid() %></td>
<td><%=o.getProductN() %> </td>
<td><%=o.getBuydate() %></td>
<td><%=o.getPaymentmode() %> </td>
<td><%=o.getPrice() %></td>
<td><%=o.getQuantity() %></td>
<td><%=o.getSeller() %></td>
<td><%=o.getBuyer() %>
<td><%=o.getStatus() %> </td>
<td><form action="./editorder" method="post">

<input type="hidden" name="pid" value=<%=o.getProductid() %>>
<input type="hidden" name="pn" value=<%=o.getProductN() %>>
<input type="hidden" name="pm" value=<%=o.getPaymentmode() %> >
<input type="hidden" name="oid" value=<%=o.getOrderid() %>>
<input type="hidden" name="bd" value=<%=o.getBuydate() %>>
<input type="hidden" name="c" value=<%=o.getComments() %>>
<input type="hidden" name="q" value=<%=o.getQuantity() %>>
<input type="hidden" name="p" value=<%=o.getPrice() %>>
<input type="hidden" name="s" value=<%=o.getStatus() %>>
<input type="hidden" name="sid" value=<%=o.getSeller() %>>
<input type="hidden" name="bid" value=<%=o.getBuyer() %>>
<input type="submit" value="edit order">
</form></td>
</tr>

</table>
<%} %>
</body>
</html>