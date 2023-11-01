<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>
<%@page import = "com.user.admin.FetchUser" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<%@page isELIgnored = "false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Rahul-Dev24</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link href="css/index-rahul.css" rel="stylesheet" />
</head>
<body id="page-top">
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container-fluid">
            <div class="logo" style="margin: -14px;">
                <img src="images/logo.png" alt="Loading">
            </div>
          
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
        
            
              <!-- <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Dropdown
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="#">Action</a></li>
                  <li><a class="dropdown-item" href="#">Another action</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
              </li> -->
              
           <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="AdminPage"><button class="trans">User-Data</button></a>
                  </li>
              <li class="nav-item">
                <a class="nav-link" href="AdminBalance"><button class="trans">User-Balance</button></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="AdminTransaction"><button class="trans">Transaction</button></a>
              </li>
               </ul>
            <form class="d-flex">
               <a href = "Logout" class="logout">Logout</a>
            </form>
          </div>
        </div>
      </nav>


    <h2>Users Data...</h2><hr>
    <div class="table-responsive">
        <table class="table">
            <thead class="">
                <tr>
                    <th scope="col" style="background-color: rgb(184, 106, 76); color: #fff;">Id</th>
                    <th scope="col"  style="background-color: rgb(184, 106, 76); color: #fff;">Uname</th>
                    <th scope="col"  style="background-color: rgb(184, 106, 76); color: #fff;">Password</th>
                    <th scope="col"  style="background-color: rgb(184, 106, 76); color: #fff;">email</th>
                </tr>
            </thead>
            <tbody>
            
            	<% List<FetchUser> userData = (List<FetchUser>)session.getAttribute("adminUsers"); 
			      for(FetchUser data1 : userData){%> 
			      <tr>
			   		 <th scope="row"  style="background-color: rgb(221, 195, 171); color: #000;"><%= data1.getId() %></th>
			         <td style="background-color: rgb(221, 195, 171); color: #000;"><%= data1.getName() %></td>
			           <td style="background-color: rgb(221, 195, 171); color: #000;" ><%= data1.getPass() %></td>
			           <td style="background-color: rgb(221, 195, 171); color: #000;"><%= data1.getEmail() %></td>	
			       </tr>
			       <%} %>
            </tbody>
        </table>

    </div>


  
	
	
	
	
	

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<!-- Core theme JS-->

	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	
	
</body>
</html>
