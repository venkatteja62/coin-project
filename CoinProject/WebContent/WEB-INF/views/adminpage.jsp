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

<div><jsp:include page="header1.jsp"></jsp:include></div>
<%int id=(int)session.getAttribute("id"); %>


<div style="float: left"><div class="btn1"><form action="viewproduct" method="post">
<input type="hidden" name="uid" value=<%=id %>>
<input class="button3" value="My Products" type="submit" ></form>
</div>



<div class="btn1"><form action="addadminproducts" method="post">
<input type="hidden" name="uid" value=<%=session.getAttribute("id") %>>
<input class="button3" value="Add Products" type="submit" ></form>
</div>



<div class="btn1"><form action="viewusers" method="post">
<input type="hidden" name="uid" value=<%=session.getAttribute("id") %>>
<input class="button3" value="View Users" type="submit" ></form>
</div>


<div class="btn1"><form action="./viewallp" method="post">
<input type="hidden" name="uid" value=<%=session.getAttribute("id") %>>
<input class="button3" value="View All Products" type="submit" ></form>
</div>


<div class="btn1"><form action="./viewcart" method="post">
<input type="hidden" name="uid" value=<%=session.getAttribute("id") %>>
<input class="button3" value="My Cart" type="submit" ></form>
</div></div>


</body>
</html>










<%-- <%int id=(int)session.getAttribute("id"); %> --%>
<!-- <form action="viewproduct" method="post"> -->
<%-- <input type="hidden" name="uid" value=<%=id %>> --%>
<!-- <input type="submit" value="my products"> -->
<!-- </form><br><br> -->

<!-- <form action="addadminproducts" method="post"> -->
<%-- <input type="hidden" name="uid" value=<%=session.getAttribute("id") %>> --%>
<!-- <input type="submit" value="add product"> -->
<!-- </form><br><br> -->

<!-- <form action="viewusers" method="post"> -->
<%-- <input type="hidden" name="uid" value=<%=session.getAttribute("id") %>> --%>
<!-- <input type="submit" value="View Users"> -->
<!-- </form><br><br> -->

<!-- <form action="./viewallproduct" method="post"> -->
<%-- <input type="hidden" name="uid" value=<%=session.getAttribute("id") %>> --%>
<!-- <input type="submit" value="View products"> -->
<!-- </form> -->
<!-- <a href="logout">log out</a> -->
<!-- </body> -->
<!-- </html> -->