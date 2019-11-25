<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user dash</title>

<link href="css/dashboard.css" rel="stylesheet" />
</head>
<body>

<div style="float: left"><div class="btn1"><form action="viewproduct" method="post">
<input type="hidden" name="uid" value=<%=session.getAttribute("id") %>>
<input class="button3" value="My Products" type="submit" ></form>
</div>
<div class="btn1"><form action="addproduct" method="post">
<input type="hidden" name="uid" value=<%=session.getAttribute("id") %>>
<input class="button3" value="Add Products" type="submit" ></form>
</div>

<div class="btn1"><form action="viewuser" method="post">
<input type="hidden" name="uid" value=<%=session.getAttribute("id") %>>
<input class="button3" value="My Profile" type="submit" ></form>
</div>


<div class="btn1"><form action="./viewallproduct" method="post">
<input type="hidden" name="uid" value=<%=session.getAttribute("id") %>>
<input class="button3" value="View Products" type="submit" ></form>
</div>


<div class="btn1"><form action="./viewcart" method="post">
<input type="hidden" name="uid" value=<%=session.getAttribute("id") %>>
<input class="button3" value="My Cart" type="submit" ></form>
</div></div>




</body>
</html>