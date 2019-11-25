<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="./insertadminproduct" method="POST">
<input type="hidden" name="id" value=<%=session.getAttribute("id")%>><br>
Product name: <input type="text" placeholder="Product name" name="pname"><br><br>
Product price: <input type="number" placeholder="Price" name="pprice"><br><br>
Category: <select name="pcategory">
           <option>Gold</option>
           <option>Silver</option>
           <option>Old Currencies</option>
            <option >Foreign Currency</option>
</select><br><br>
Description: <input type="text" placeholder="description" name="pdescription"><br><br>
Stock: <select name="pstock">
           <option>In Stock</option>
            <option >Out of Stock</option>
</select><br><br>
Period:<select name="pperiod">
<option>19th Century</option>
<option>20th Century</option>
<option>21st Century</option>
</select><br><br>

Company:<select name="pcompany" >
<option>Admin Product</option>
<option>User Product</option>
</select><br><br>

Quantity:<input type="number" name="pquantity"><br><br>

<input type="submit" value="SUBMIT">
</form>

</body>

</body>
</html>