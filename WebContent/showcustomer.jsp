
<%@page import="com.ssi.*"%>
<jsp:declaration>
	public String convert(String s){
	return s.toUpperCase();
	}
</jsp:declaration>
<jsp:scriptlet>
	String email = request.getParameter("email");
	CustomerDAO dao=new CustomerDAO();
	Customer customer=dao.getCustomer(email);
</jsp:scriptlet>
<html>
<body>
	<h3>Customer-Details</h3>
	<hr>
	<pre>
	<table border="2">
	<tr>
	<td>Name</td><td><jsp:expression>convert(customer.getCname())</jsp:expression></td>
	<tr>
	<tr>
	<td>Address</td><td><%=customer.getAddress()%></td>
	</tr>
	<tr>
	<td>Email</td><td><%=customer.getEmail()%></td>
	</tr>
	<tr>
	<td>Mobile</td><td><%=customer.getMobile()%></td>
	</tr>
	</table>
	<hr>
	<a href="admindashboard.jsp">DashBoard</a>
</body>
</html>