<%@page import="com.ssi.DataUtil"%>
<%
	String qr="select cmpid,pname,ctext,cdate,email from complaint, products where complaint.pcode=products.pcode and status='pending' order by cmpid";
	java.sql.Connection con=DataUtil.connect();
	java.sql.PreparedStatement ps=con.prepareStatement(qr);
	java.sql.ResultSet rs=ps.executeQuery();
%>
<html>
 <head>
  <meta http-equiv="refresh" content="30">
</head> 
<body>
<h3>All-Pending-Complaints</h3>
<table border="2">
<%
	while(rs.next()){
		String s1=rs.getString(1);		
		String s2=rs.getString(2);
		String s3=rs.getString(3);
		String s4=rs.getString(4);
		String s5=rs.getString(5);
	
%>
<tr>
	<td><%=s1%></td>
	<td><%=s2%></td>
	<td><%=s3%></td>
	<td><%=s4%></td>
	<td><a href="pendingdetails.jsp?id=<%=s1%>">details</a></td>
</tr>
<%
	}
%>
</table>
<a href="admindashboard.jsp">Admin-Home</a>
</body>
</html>
<%
con.close();
%>