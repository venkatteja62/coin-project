<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="css/loginform.css" rel="stylesheet" />
<script src="js/login.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div><jsp:include page="header.jsp"></jsp:include></div>
<div class="container">
    <div class="row">
        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
            <div class="row">
                <div class="col-lg-6 col-md-8 mx-auto">
                    <div class="card rounded shadow shadow-sm">
                        <div class="card-header">
                            <h3 class="mb-0">Register</h3>
                        </div>
                        <div class="card-body">
                            <form class="form" role="form" action="./insertuser" method="post" autocomplete="off" id="formLogin" novalidate="" onsubmit="return fun(this)">
                                <div class="form-group">
                                    <label for="uname">Username</label>
                                    <input input type="text" name="uname" pattern="[A-Za-z]{1,}" title="only alphabets" required="required" class="form-control form-control-lg rounded-0">
                                    <div class="invalid-feedback">Oops, you missed this one.</div>
                                </div>
                                <div class="form-group">
                                    <label>E-mail</label>
                                    <input type="text" name="uemail" placeholder="Enter Password" required="required"class="form-control form-control-lg rounded-0" id="pwd1" required="" autocomplete="new-password">
                                    <div class="invalid-feedback">Enter your password too!</div>
                                </div>
                                
                                
                                <div class="form-group">
                                    <label>Date of Birth</label>
                                    <input type="text" name="udob" placeholder="dd/mm/yyyy" required="required"class="form-control form-control-lg rounded-0" id="pwd1" required="" autocomplete="new-password">
                                    <div class="invalid-feedback">Enter your Date of Birth!</div>
                                </div>

                                
                                
                                 <div class="form-group">
                                    <label>Mobile Number</label>
                                    
                                    <input type="text" name="umobile" pattern="[0-9]{1}[0-9]{9}" title="please enter valid mobile number"  title="please enter valid mobile number" required="required"name="s"  class="form-control form-control-lg rounded-0" id="pwd1" >
                                    <div class="invalid-feedback">Enter Mobile</div>
                                    
                                </div>
                                
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" name="upass" placeholder="Enter Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"required="required"class="form-control form-control-lg rounded-0" id="pwd1" autocomplete="new-password">
                                    <div class="invalid-feedback">Enter your password</div>
                                </div>
                                
                                <div class="form-group">
                                    <label>Re-Enter Password</label>
                                    <input type="password" name="ucpass" placeholder="Enter Password" required="required"class="form-control form-control-lg rounded-0" id="pwd1" autocomplete="new-password">
                                    <div class="invalid-feedback">Re-Enter your password</div>
                                </div>
                                
                                <div class="form-group">
                                    <label>Gender</label>
                                    <select name="ugender" required="required" class="form-control form-control-lg rounded-0" id="pwd1" autocomplete="new-password">

<option value="Male">Male</option>
<option value="Female">Female</option>
<option value="Other">Other</option>

</select>

 <div class="form-group">
                                    <label>Security Question</label>
                                    
                                    <select name="usecurity" required="required"class="form-control form-control-lg rounded-0" id="pwd1" autocomplete="new-password">
<option value="Favorite Color">Favorite Color</option>
<option value="Favorite Game">Favorite Game</option>
<option value="First School">First School</option>
<option value="Favorite Movie">Favorite Movie</option>
<option value="Favorite Song">Favorite Song</option>
</select>

                                </div>
<div class="form-group">
                                    <label>Answer</label>
                                    <input input type="text" name="uanswer"  required="required"class="form-control form-control-lg rounded-0" id="pwd1" >
                                    <div class="invalid-feedback">Enter the answer</div>
                                </div>
                                
                                <div class="form-group">
                                    <label>City</label>
                                    <input input type="text" name="ucity"  required="required"class="form-control form-control-lg rounded-0" id="pwd1" >
                                    <div class="invalid-feedback">Enter the city</div>
                                </div>
                                
                                <div>
                                    <label class="custom-control custom-checkbox">
                                      <input type="checkbox" class="custom-control-input">
                                      <span class="custom-control-indicator"></span>
                                     
                                    </label>
                                </div>
                                <button type="submit" style="background-color: rgba(235, 82, 51, 1)"class="btn btn-success btn-lg float-right" id="btnLogin">Register</button>
                            </form>
                        </div>
                      
                    </div>
                   

                </div>


            </div>
      

        </div>
       
    </div>

</div>
<script src="js/valid.js"></script>
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/jquery.timepicker.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>

</body>
</html>
