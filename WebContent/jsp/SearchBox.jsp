<div class="conten center">
	<form action="./BecomeFriends" method="post">
	<%
		String r_userId=(String)session.getAttribute("r_userId");
		String r_name=(String)session.getAttribute("r_name");
		if(r_name==null){
	%>
		<div class="container content text-cyan">
			"<%=r_userId%>" no such user id exits...
		</div>
	<%}
		else
		{
		int friendship=(int)session.getAttribute("friendship");
	%>
	 <div class="content">
	 	<span class="left cyan text-white round-xlarge border" style="float:left;width:50%"><b>&nbsp;<%=r_name %>&nbsp;</b></span>
	 	<%if(friendship<1) {%>
		<span style="float:left;width:50%">
			<b><input type="submit" value="Become Friends" class="button text-white padding-small cyan round-xxlarge"></b>
		</span>
		<%} else{%>
			<span class="left white text-cyan border round-xlarge" style="float:left;width:50%"><b>&nbsp;Friends&nbsp;</b></span>
		<%} %>
	 </div>
	<%} %>
	</form>
	<br>
</div>