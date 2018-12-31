<%@page import="com.ssi.*"%>
<%
	String email=(String)session.getAttribute("userid");
	CustomerDAO dao=new CustomerDAO();
	Customer customer=dao.getCustomer(email);
%>
<html>
<body>
<h3>Customer-Profile-Update-Form</h3>
<hr>
<form action="SaveCustomerUpdates" method="post">
<pre>
<!-- Email		<input type="text" name="email"/> -->
Password	<input type="text" name="password" value="<%=customer.getPassword()%>"/>
Name		<input type="text" name="cname" value="<%=customer.getCname()%>"/>
Address		<input type="text" name="address" value="<%=customer.getAddress()%>"/>
Mobile		<input type="text" name="mobile" value="<%=customer.getMobile()%>"/>
		<input type="submit" value="Update"/>
</pre>
</form>
</pre>
<hr>
<a href="customerdashboard.jsp">Dashboard</a>
</body>
</html>