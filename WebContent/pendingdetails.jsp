<%@page import="com.ssi.DataUtil,java.sql.*"%>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	String qr="select cmpid,ctext,cdate,pname,cname,address,complaint.email,mobile from complaint,products,customer where complaint.pcode=products.pcode and complaint.email=customer.email and cmpid=?";
	Connection con=DataUtil.connect();
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setInt(1, id);
	ResultSet rs=ps.executeQuery();
	rs.next();
	String s1=rs.getString(1);
	String s2=rs.getString(2);
	String s3=rs.getString(3);
	String s4=rs.getString(4);
	String s5=rs.getString(5);
	String s6=rs.getString(6);
	String s7=rs.getString(7);
	String s8=rs.getString(8);
	String qr1="select ecode,ename from employee";
	PreparedStatement ps1=con.prepareStatement(qr1);
	ResultSet rs1=ps1.executeQuery();
%>
<html>
<body>
<h3>Pending-Complaints-Details</h3>
<form action="AssignComplaint" method="post">
<input type="hidden" name="cid" value="<%=s1%>"/>
<table border="2">
<tr>
<td>Code</td><td><%=s1%></td>
<tr>
<tr>
<td>CText</td><td><%=s2%></td>
<tr>
<tr>
<td>CDate</td><td><%=s3%></td>
<tr>
<tr>
<td>Pname</td><td><%=s4%></td>
<tr>
<tr>
<td>Cname</td><td><%=s5%></td>
<tr>
<tr>
<td>Address</td><td><%=s6%></td>
<tr>
<tr>
<td>Email</td><td><%=s7%></td>
<tr>
<tr>
<td>Mobile</td><td><%=s8%></td>
<tr>
<tr>
<td>Engineer</td>
<td>
	<select name="ecode">
	<%
	while(rs1.next()) {
		String eid=rs1.getString(1);
		String ename=rs1.getString(2);
	%>
	<option value="<%=eid%>"><%=ename%></option>
	<%}%>
	</select>
</td>
<tr>
<tr>
<td><input type="submit" value="Asssign"/></td></td>
<tr>
</table>
</form>
<pre>
<a href="admindashboard.jsp">Dashboard</a>
<a href="showallcomplaints.jsp">Pending-Complaints</a>
</pre>
</body>
</html>
<%
con.close();
%>