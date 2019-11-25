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
                            <h3 class="mb-0">Login</h3>
                        </div>
                        <div class="card-body">
                            <form class="form" role="form" action="./loginuser" method="post" autocomplete="off" id="formLogin" novalidate="" >
                                <div class="form-group">
                                    <label for="uname">E-mail</label>
                                    <input required type="text" placeholder="Enter Username" name="uname" required="" class="form-control form-control-lg rounded-0">
                                    <div class="invalid-feedback">Oops, you missed this one.</div>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" placeholder="Enter Password" name="upass" required class="form-control form-control-lg rounded-0" id="pwd1" required="" autocomplete="new-password">
                                    <div class="invalid-feedback">Enter your password too!</div>
                                </div>
                                
                                 <div class="form-group">
                                    <label>Captcha</label>
                                    <input type="text" name="country" value=<%=session.getAttribute("s")%> disabled class="form-control form-control-lg rounded-0" id="pwd1" required="">
                                    <input type="text" placeholder="Enter the above text here" name="s" required class="form-control form-control-lg rounded-0" id="pwd1" required="">
                                    <div class="invalid-feedback">Enter Captcha!</div>
                                    
                                </div>
                                
                                
                                <div>
                                    <label class="custom-control custom-checkbox">
                                      <input type="checkbox" class="custom-control-input">
                                      <span class="custom-control-indicator"></span>
                                     
                                    </label>
                                </div>
                                <button type="submit" style="background-color: rgba(235, 82, 51, 1)" class="btn btn-success btn-lg float-right" id="btnLogin">Login</button>
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