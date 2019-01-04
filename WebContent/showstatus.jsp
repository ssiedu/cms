<%@page import="com.ssi.DataUtil,java.sql.*"%>
<%
String email=(String)session.getAttribute("userid");
/*
if(email==null){
	response.sendRedirect("custlogin.jsp");
}
*/
String qr="select * from complaint where email=?";
//Connection con=DataUtil.connect();
Connection con=(Connection)application.getAttribute("mycon");
PreparedStatement ps=con.prepareStatement(qr);
ps.setString(1,email);
ResultSet rs=ps.executeQuery();
%>
<html>
<body>
<h3>Your Complaint Status</h3>
<hr>
<table border="2">
<%
while(rs.next()){
	String s1=rs.getString("cmpid");
	String s2=rs.getString("ctext");
	String s3=rs.getString("cdate");
	String s4=rs.getString("status");
%>
<tr>
	<td><%=s1%></td><td><%=s2%></td><td><%=s3%></td><td><%=s4%></td>
</tr>
<% 	
}
con.close();
%>
</table>
<hr>
<a href="customerdashboard.jsp">Customer-Dashboard</a>
</body>
</html>