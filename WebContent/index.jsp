<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.friendbook.db.CRUD" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>FriendBook</title>
<link rel="StyleSheet" href="css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
	function signup()
	{
		document.getElementById("signup").style.display='block';
		document.getElementById("signin").style.display='none';
		document.getElementById("c_password").setAttribute("disabled", true);
		document.getElementById("sign").setAttribute("disabled", true);
		conPass();
	}
	function signin()
	{
		document.getElementById("signup").style.display='none';
		document.getElementById("signin").style.display='block';
	}
	function chkPass()
	{
		pass1=document.getElementById("password").value;
		pass2=document.getElementById("c_password");
		 
		if(pass1.length>8)
			{
			pass2.removeAttribute('disabled');
			document.getElementById("sign").removeAttribute('disabled');
			}
		else
			{
			pass2.setAttribute("disabled", true);
			document.getElementById("sign").setAttribute("disabled", true);
			}
	}
	function conPass()
	{
		pass1=document.getElementById("password").value;
		pass2=document.getElementById("c_password").value;
		cnf=document.getElementById("cnf");
		
		if(pass2==pass1)
			{
			cnf.innerHTML="";
			}
		else
			{
			cnf.innerHTML="password didn't match";
			pass2=document.getElementById("password2").value='';
			}
	}
</script>
</head>
<body onload="signup()">
	<div class="content" style="max-width:2000px">
		<div class="bar cyan card-2 text-white">
  			<div class="card-4 center container content round-xxlarge padding-large" style="max-width:800px">
  				<b>FriendBook</b>
  			</div>
  		</div>
		<div class="container content padding-64" style="max-width:600px">
		<% 
			String msg=(String)session.getAttribute("msg");
			session.setAttribute("msg", null);
			session.removeAttribute("msg");
			String view=(String)session.getAttribute("view");
			String name=(String)session.getAttribute("name");
			session.removeAttribute("view");
			if(msg!=null)
			{
		%>
		<div class="center content text-cyan">
			<span><%=msg%></span>
		</div>
		<%} 
		if(name!=null && view!=null)
			{
		%>
		<div class="center content text-cyan">
			<span>h! <%=name%></span>
		</div>
		<%} %>
			<div class="container content border round-xlarge">
				<div class="content round-xlarge">
				<br>
				<%if(view==null){ %>
					<%@ include file="/jsp/Sign.jsp" %>
				<% }else if(view.equals("login")){%>
					<%@ include file="/jsp/Login.jsp" %>
				<%}else if(view.equals("searchBox")){%>
					<%@ include file="/jsp/SearchBox.jsp" %>
				<%}else if(view.equals("friendList")){%>
				<%@ include file="/jsp/FriendList.jsp" %>
				<%} %> 
					 
				<br>
				<%
					if(view!=null && !(view.equals("login"))){
				%>
					<div class="right padding-small text-cyan">
						<a href="./Home">Go back to home..</a>
					</div>
				<%} %>
				</div>
			</div>
		</div>
	</div>
</body>
</html>