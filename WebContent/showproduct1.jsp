<%@page import="com.ssi.*,java.sql.*"%>

<%
	String code=request.getParameter("t1");
	Product product=new Product();
	product.setPcode(code);
	
%>
<html>
<body>
<h3>Product-Details</h3>
<hr>
<pre>
	PCode	<%=product.getPcode()%>
	PName	<%=product.getPname()%>
	Price	<%=product.getPrice()%>
</pre>
<hr>
<a href="psearch.jsp">Search-Again</a><br>
<a href="admindashboard.jsp">DashBoard</a><br>
</body>
</html>