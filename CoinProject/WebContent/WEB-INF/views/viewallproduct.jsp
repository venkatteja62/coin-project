<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

table, th, tr{
 border:2px solid black;
}

</style>

</head>
<body>
<div><jsp:include page="header1.jsp"></jsp:include></div>
<div><jsp:include page="dashboard.jsp"></jsp:include></div>
<div class="display"><table style="border:2px">
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Category</th>
<th>Period</th>
<th>Stock</th>
<th>Quantity<th>
<th>Price</th>
<th></th>
</tr>
<c:forEach items="${li}" var="p">
 <tr>
 <td>${p.productID }</td>
<td>${p.productName}</td>
<td>${p.category}</td>
<td>${p.period}</td>
<td>${p.stock}</td>
<td>${p.quantity }</td>
<td><h2 style="color:blue">${p.price }</h2>
<td><form action="./insertcart" method="post">
<input type="hidden" name="pid" value=${p.productID }>
<input type="hidden" name="ppn" value=${p.productName }>
<input type="hidden" name="pc" value=${p.category }>
<input type="hidden" name="pp" value=${p.period }>
<input type="hidden" name="ps" value=${p.stock }>

<input type="hidden" name="ppc" value=${p.price }>
<input type="hidden" name="pd" value=${p.description }>
<input type="hidden" name="pq" value=${p.quantity }>
<input type="hidden" name="sid" value=${p.userId }>
<input type="hidden" name="bid" value=<%=session.getAttribute("id") %>>
<input type="submit" value="add to cart">
</form></td>
 </tr>
 </c:forEach>


</table></div>
</body>
</html>