<%
	String email=(String)session.getAttribute("userid");
/*
	if(email==null){
		response.sendRedirect("custlogin.jsp");
	}
*/	
	int n=session.getMaxInactiveInterval();
	
%>
<html>
<body>
	<h3>Welcome <%=email%></h3>
	<h5>If you remain idle for <%=n%> seconds your session will expire</h5>
	<hr>
	<pre>
		<a href="profileupdateform.jsp">Change-Profile</a>
		<a href="complaint.jsp">Complaint</a>
		<a href="showstatus.jsp">Complaint-Status</a>
		<a href="">Cancel-Complaint</a>
		<a href="EndSession">Logout</a>
	</pre>
	<hr>
</body>
</html>