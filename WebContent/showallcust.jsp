<%@page import="com.ssi.*,java.util.*"%>
<%
	CustomerDAO dao=new CustomerDAO();
	ArrayList<Customer> list=dao.getAllCustomers();
%>
<html>
<body>
<h3>Customer-List</h3>
<table border="2">
<tr>
<th>Email</th>
<th>Password</th>
<th>Name</th>
<th>Address</th>
<th>Mobile</th>
<tr>
<%
	for(Customer c:list){	
%>
<tr>
	<td><%=c.getEmail()%></td>
	<td><%=c.getPassword()%></td>
	<td><%=c.getCname()%></td>
	<td><%=c.getAddress()%></td>
	<td><%=c.getMobile()%></td>
	
</tr>
<%
	}
%>
</table>
<a href="admindashboard.jsp">DashBoard</a>
</body>
</html>