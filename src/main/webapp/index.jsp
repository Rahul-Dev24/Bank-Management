
<%
if (session.getAttribute("name") == null) {
	response.sendRedirect("login.jsp");
}
%>

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
<link rel = "stylesheet" href = "alert/dist/sweetalert.css">

</head>
<body >
<input type = "hidden" id="status" value = "<%= request.getAttribute("status") %>">

<div id="nav">
   <div class="logo">
            <img src="images/logo.png" alt="Loading">
        </div>
        <div class="right_nav">
            <h2 class="upi">Email/UPI</h2>
            <h3 class="upiid">${upi }</h3>
            <a href="TransHistory"><button class="trans" >Transaction</button></a>
            <a href="Logout"><button class="logout">Logout</button></a>
        </div>

</div>

<div class="container">
        <div id="card">
            <h2 class="heading">Wellcome To Our Atm Project</h2> <hr> 
            <div class="user_detials">
                <h3 class="heading1"><b>Hi</b><span style="color: #0000ff;"> <%= session.getAttribute("uname")  %></span></h3><br>
                <h3 class="heading1" style="margin-top: -1.5vh;">TotalBal:<span style="color: #006400;"> <%= session.getAttribute("balance") %></span>
                </h3>
            </div>
            <div class="dynamic">
                <h2 class="heading " style=" margin-top: 2vh; color:#ff5100;"><b>Deposit.</b></h2>
                <form method="post" action="userDeposit">
                    <label for="dep1">Enter your amount</label>
                    <input class="input" type="number" name="deposit" id="dep1" /><br>
                    <input type="submit" value="Deposit" class="dy_btn" />
                </form>
            </div>
            <h2 class="heading heading1" style="text-align: left;">Please select an option.</h2>
            <div class="btn">
                <button id="dep">Depoist</button>
                <button id="withdraw">Withdraw</button>
                <button id="transfer">Transfer</button>
            </div>

        </div>
    </div>
    
    

    <script>
        const withdraw = document.querySelector("#withdraw");
        const transfer = document.querySelector('#transfer');
        const dep = document.querySelector('#dep');
        const setdy = document.querySelector(".dynamic");
       
        withdraw.addEventListener("click",function(){
            setdy.innerHTML = `<h2 class="heading " style=" margin-top: 2vh; color:#ff5100;"><b>Withdraw.</b></h2>
                <form method="post" action="userWithdraw">
                    <label for="dep1">Enter your amount</label>
                    <input class="input" type="number" name="withdraw" id="dep1" /><br>
                    <input type="submit" value="Withdraw" class="dy_btn" />
                </form>
                </form>`
            withdraw.style.backgroundColor = "green";
            dep.style.backgroundColor = '#000';
            dep.style.color = '#fff';
            transfer.style.backgroundColor = '#000';
            transfer.style.color = '#fff';
        });
        transfer.addEventListener("click",function(){
            setdy.innerHTML =`<h2 class="heading " style=" margin-top: 2vh; color:#ff5100;"><b>Transfer to Account.</b></h2>
                <form method="post" action="transferInfo">
                    <label for="dep1">Enter UPI or Email</label>
                    <input class="input" type="text" name="trans_email" id="dep1" /><br>
                    <label for="dep1">Enter your amount</label>
                    <input class="input" type="number" name="transfer" id="dep1" /><br>
                    <input type="submit" value="Transfer" class="dy_btn" />
                </form>
                </form>`
            transfer.style.backgroundColor = "green";
            dep.style.backgroundColor = '#000';
            dep.style.color = '#fff';
            withdraw.style.backgroundColor = '#000';
            withdraw.style.color = '#fff';
        });
        dep.addEventListener("click",function(){
            setdy.innerHTML = `   <h2 class="heading " style=" margin-top: 2vh; color:#ff5100;"><b>Deposit.</b></h2>
                <form method="post" action="userDeposit">
                    <label for="dep1">Enter your amount</label>
                    <input class="input" type="number" name="deposit" id="dep1" /><br>
                    <input type="submit" value="Deposit" class="dy_btn" />
                </form>
                </form>`
            dep.style.backgroundColor = 'green';
            dep.style.color = "#fff"
            transfer.style.backgroundColor = "#000";
            transfer.style.color = '#fff';
            withdraw.style.backgroundColor = '#000';
            withdraw.style.color = '#fff';
        });



    </script>

	
	<script src = "https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
	
	var status = document.getElementById("status").value;
	if(status == "success"){
		swal("Congrate","Sucessfully Done.");
	}
	
	</script>


	<!-- Bootstrap core JS-->
	</body>
</html>
