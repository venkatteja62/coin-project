<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
th{
border:2px solid black;

}

</style>

</head>
<body>
<table style="border:2px solid black">
<tr>
<th>User Id</th>
<th>Product Id</th>
<th>Product Name</th>
<th>Category</th>
<th>Period</th>
<th>Stock</th>
<th>Price</th>
<th></th>
</tr>
<c:forEach items="${li}" var="p">
 <tr>
 <td>${p.userId}</td>
 <td>${p.productID}</td>
<td>${p.productName}</td>
<td>${p.category}</td>
<td>${p.period}</td>
<td>${p.stock}</td>

<td>${p.description }</td>
<td>${p.quantity }</td>
<td><h2 style="color:blue">${p.price }</h2>
<td><form action="editAdminp" method="post">
<input type="hidden" name="pid" value=${p.productID }>
<input type="hidden" name="ppn" value=${p.productName }>
<input type="hidden" name="pc" value=${p.category }>
<input type="hidden" name="pp" value=${p.period }>
<input type="hidden" name="ps" value=${p.stock }>

<input type="hidden" name="ppc" value=${p.price }>
<input type="hidden" name="pd" value=${p.description }>
<input type="hidden" name="pq" value=${p.quantity }>
<input type="hidden" name="uid" value=${p.userId }>
<input type="submit" value="Edit">
</form></td>
<td><form action="deletep" method="post">
<input type="hidden" name="pid" value=${p.productID }>
<input type="hidden" name="uid" value=${p.userId }>
<input type="submit" value="Delete">
</form></td>
 </tr>
 </c:forEach>


</table>
</body>
</body>
</html>