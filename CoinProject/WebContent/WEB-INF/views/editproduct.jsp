<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./editproduct" method="post">
<input type="hidden" name="uid" value=<%=request.getParameter("uid") %>>
<input type="hidden" name="pid" value=<%=request.getParameter("pid") %>>
Product name: <input type="text" value=<%=request.getParameter("ppn") %> name="pname"><br><br>
Product price: <input type="number" value=<%=request.getParameter("ppc") %> name="pprice"><br><br>
Category: <select  name="pcategory">
			<option><%=request.getParameter("pc") %></option>
           <option>Gold</option>
           <option>Silver</option>
           <option>Old Currencies</option>
            <option >Foreign Currency</option>
</select><br><br>
Description: <input type="text" value=<%=request.getParameter("pd") %> name="pdescription"><br><br>
Stock: <select name="pstock">
<option><%=request.getParameter("ps") %></option>
           <option>In Stock</option>
            <option >Out of Stock</option>
</select><br><br>
Period:<select name="pperiod">
<option><%=request.getParameter("pp") %></option>
<option>19th Century</option>
<option>20th Century</option>
<option>21st Century</option>
</select><br><br>

<!-- Material:<select name="pcompany"> -->

<!-- <option>Admin Product</option> -->
<!-- <option >User Product</option> -->

</select><br><br>

Quantity:<input type="number" name="pquantity" value=<%=request.getParameter("pq") %>><br><br>

<input type="submit" value="Update">
</form>
</body>
</html>