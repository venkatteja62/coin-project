<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
view cart page

<table style="border:2px">
<tr>
<th>Cart Id</th>
<th>Product Id</th>
<th>Product Name</th>
<th>Seller Id</th>
<th>buyer Id</th>
<th>quantity</th>
<th>Price</th>
<th></th>
</tr>
<c:forEach items="${li}" var="p">
 <tr>
 <td>${p.cartID}</td>
 <td>${p.productID}</td>
<td>${p.productname}</td>
<td>${p.sellerId}</td>
<td>${p.buyerID}</td>
<td>${p.quantity }</td>
<td><h2 style="color:blue">${p.price }</h2>
<td><form action="editquantity" method="post">
<input type="hidden" name="pid" value=${p.productID }>
<input type="hidden" name="ppn" value=${p.productname }>
<input type="hidden" name="cid" value=${p.cartID }>
<input type="hidden" name="bid" value=${p.buyerID }>
<input type="hidden" name="sid" value=${p.sellerId }>
<input type="hidden" name="pq" value=${p.quantity }>
<input type="hidden" name="ppc" value=${p.price }>
<input type="submit" value="Edit quantity">
</form></td>
<td><form action="deletecart" method="post">
<input type="hidden" name="uid" value=${p.buyerID }>
<input type="hidden" name="cartid" value=${p.cartID }>
<input type="submit" value="Delete">
</form></td>
 </tr>
 </c:forEach>
</table>
<form action="buycoin"method="post">
<input type="text" name="uid" value=<%=session.getAttribute("id") %>>
<input type="submit" value="Buy">
</form>
</body>
</html>