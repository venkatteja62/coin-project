<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="css/loginform.css" rel="stylesheet" />
<script src="js/login.js"></script>
</head><body>
<div><jsp:include page="header.jsp"></jsp:include></div>
<div class="container">
    <div class="row">
        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
            <div class="row">
                <div class="col-lg-6 col-md-8 mx-auto">
                    <div class="card rounded shadow shadow-sm">
                        <div class="card-header">
                            <h3 class="mb-0">Add Product</h3>
                        </div>
                        <div class="card-body">
                            <form class="form" role="form" action="./insertproduct" method="post" autocomplete="off" id="formLogin" novalidate="" >
                                <div class="form-group">
                                
                                
                                
                                <input type="hidden" name="id" value=<%=session.getAttribute("id")%>><br>
                                
                                    <label for="uname">Product Name</label>
                                    <input type="text"  required="required" placeholder="Product name" name="pname" required="required" class="form-control form-control-lg rounded-0" id="pwd1" required="" autocomplete="new-password">
                                    <div class="invalid-feedback">Oops, you missed this one.</div>
                                </div>
                                
                                <div class="form-group">
                                    <label>Product Price</label>
                                    <input type="number" placeholder="Price" name="pprice" class="form-control form-control-lg rounded-0" id="pwd1" required="" autocomplete="new-password">
                                    <div class="invalid-feedback">Enter the price</div>
                                </div>
                                
                                
                                <div class="form-group">
                                    <label>Category</label>
                                    <select name="pcategory" required="required" class="form-control form-control-lg rounded-0" id="pwd1">

<option>Gold</option>
           <option>Silver</option>
           <option>Old Currencies</option>
            <option >Foreign Currency</option>

</select></div>
                                
                                
                                <div class="form-group">
                                    <label>Description</label>
                                    <input type="text" placeholder="description" name="pdescription" placeholder="enter product description" required="required"class="form-control form-control-lg rounded-0" id="pwd1" >
                                    <div class="invalid-feedback">Enter your Date of Birth!</div>
                                </div>
                                
                                
                                <div class="form-group">
                                    <label>Stock</label>
                                    <select name="pstock" required="required" class="form-control form-control-lg rounded-0" id="pwd1">

 <option>In Stock</option>
            <option >Out of Stock</option>
</select></div>


<div class="form-group">
                                    <label>Period</label>
                                    <select name="pperiod" required="required" class="form-control form-control-lg rounded-0" id="pwd1">
<option>19th Century</option>
<option>20th Century</option>
<option>21st Century</option>
</select></div>



<input type="hidden" name="pcompany" value="User Product">



                                
                                
                                 <div class="form-group">
                                    <label>Quantity</label>
                                    
                                    <input type="number" name="pquantity" required="required" name="s"  class="form-control form-control-lg rounded-0" id="pwd1" >
                                    <div class="invalid-feedback">Enter Quantity</div>
                                    
                                </div>
                                
                                
                                <button type="submit" style="width:40%; background-color: rgba(235, 82, 51, 1)"class="btn btn-success btn-lg float-right" id="btnLogin">Add Product</button>
                            </form>
                        </div>
                      
                    </div>
                   

                </div>


            </div>
      

        </div>
       
    </div>

</div>

</body>
</html>

















<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="ISO-8859-1"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->

<!-- <form action="./insertproduct" method="POST"> -->
<%-- <input type="hidden" name="id" value=<%=session.getAttribute("id")%>><br> --%>
<!-- Product name: <input type="text" placeholder="Product name" name="pname"><br><br> -->
<!-- Product price: <input type="number" placeholder="Price" name="pprice"><br><br> -->
<!-- Category: <select name="pcategory"> -->
<!--            <option>Gold</option> -->
<!--            <option>Silver</option> -->
<!--            <option>Old Currencies</option> -->
<!--             <option >Foreign Currency</option> -->
<!-- </select><br><br> -->
<!-- Description: <input type="text" placeholder="description" name="pdescription"><br><br> -->
<!-- Stock: <select name="pstock"> -->
<!--            <option>In Stock</option> -->
<!--             <option >Out of Stock</option> -->
<!-- </select><br><br> -->
<!-- Period:<select name="pperiod"> -->
<!-- <option>19th Century</option> -->
<!-- <option>20th Century</option> -->
<!-- <option>21st Century</option> -->
<!-- </select><br><br> -->

<!-- <input type="hidden" name="pcompany" value="User Product"><br><br> -->

<!-- Quantity:<input type="number" name="pquantity"><br><br> -->

<!-- <input type="submit" value="SUBMIT"> -->
<!-- </form> -->

<!-- </body> -->
<!-- </html> -->