<div class="content center">
	<%
		String[] friends=(String[])session.getAttribute("friends");
		int l=0;
		l=friends.length;
		if(l<=0){
	%>
	<div class="content">
	 	<span class="center text-cyan  round-xlarge"><b>&nbsp;no friends...till now..&nbsp;</b></span>
	 </div>
	 <%}else {%>
	 <div class="content">
	 	<span class="left cyan text-white round-xlarge border" style="float:left;width:50%"><b>&nbsp;Id&nbsp;</b></span>
		<span class="left cyan text-white round-xlarge border" style="float:left;width:50%"><b>&nbsp;Name&nbsp;</b></span>
	 </div>
	 <br>
	 <% for(String id : friends) {%>
	 <div class="content">
	 	<span class="left white text-cyan round-xlarge border" style="float:left;width:50%"><b>&nbsp;<%=id %>&nbsp;</b></span>
		<span class="left white text-cyan round-xlarge border" style="float:left;width:50%"><b>&nbsp;<%=CRUD.getUserName(id) %>&nbsp;</b></span>
	 </div>
	 <br>
	 <%}} %>
</div>