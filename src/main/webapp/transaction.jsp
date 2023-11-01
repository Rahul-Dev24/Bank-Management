
<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>


<%@page import = "com.user.History" %>
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
<title>Home</title>
<link rel="stylesheet" href="css/index-rahul.css">

</head>
<body >

<div id="nav">
   <div class="logo">
            <img src="images/logo.png" alt="Loading">
        </div>
        <div class="right_nav">
            <h2 class="upi">Email/UPI</h2>
            <h3 class="upiid">${upi }</h3>
           <a href="index.jsp"> <button class="trans" id="t">Home</button></a>
           <a href="Logout"><button class="logout">Logout</button></a>
        </div>

</div>
 
<div class="container"><div id="card">
            <div class="user_detials1">
                <img src="images/back.png" alt="loading..">
                <h2 class="heading">Rahul Singh</h2>
                <p>UPI - <span>${upi }</span></p><br>
            </div>
            <hr>

            <div class="bottom">
			
		

			 <% List<History> r1 = (List<History>)session.getAttribute("list");
			 for(History store : r1){
					 %>
				      <div class="mini_card">
                    <div class="name">
                        <p class="title"><%= store.getName() %></p>
                        <p class="balance"><%= store.getTime() %></p>
                    </div>
                    <div class="type">
                        <p class="pay_type" style="font-size:12px;font-weight: 800;"><%= store.getPay_type() %></p>
                    </div>
                    <div class="amount">
                        <p class="title" style="color:red;font-size:0.80em;font-weight: 800;">-<%= store.getAmount() %></p> 
                        <p class="balance"><%= store.getDate() %></p>
                    </div>
                </div>
                
				
			<%} %>



            </div>
        </div></div>    
	<!-- Bootstrap core JS-->
	<script src = "https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	</body>
</html>
