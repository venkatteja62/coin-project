<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${list}" var="o">
<form action="./insertOrderTable" method="POST" id="ordersform">

<input type="text" name="productid" value="${o.productID}">
<input type="text" name="productname" value="${o.productName}">
<input type="text" name="productcategory" value="${o.category}">
<input type="text" name="sellerid" value="${o.userid}">
<input type="text" name="productprice" value="${o.price}">
<input type="text" name="userid" value=<%=session.getAttribute("userid")%>>

<select name="paymentmode">
<option selected>Cash</option>
<option>Wallets</option>
<option>Internet Banking</option>
<option>Credit/Debit Card</option>
</select>

Enter Quantity:<input type="number" name="quantity">

<input type="submit" value ="buy">
<textarea name="comment" form="ordersform">Enter text here </textarea>

<table>
<tr>
<th> Product Id</th>
<th> Product Name</th>
<th> Product Category</th>
<th> Product Seller</th>
<th> Product Price</th>
</tr>


 <tr>
<td>${o.productID}</td>
<td >${o.productName}</td>
<td>${o.category}</td>
<td>${o.userid}</td>
<td>${o.price }</td>
</form>
</c:forEach>
</table>



</body>
</html>