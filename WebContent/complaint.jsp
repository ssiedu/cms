<%@page import="com.ssi.*, java.sql.*"%>

<%
	String qr="select pcode,pname from products";
	Connection con=DataUtil.connect();
	PreparedStatement ps=con.prepareStatement(qr);
	ResultSet rs=ps.executeQuery();		
%>

<html>
<body>
<h3>Customer-Complaint-Form</h3>
<form action="SaveComplaint" method="post">
<table>
<tr>	
	<td>Product</td><td><select name="pcode">
	<%
		while(rs.next()){
			String s1=rs.getString(1);
			String s2=rs.getString(2);
	%>
	
	<option value="<%=s1%>" ><%=s2%></option>
	<%
		}
	%>
				</select></td>
</tr>
<tr>				
	<td>Problem</td><td><textarea name="ctext" rows="5" cols="60"></textarea></td>
</tr>
<tr>
	<td><input type="submit" value="Submit"/></td><td><input type="reset" value="Reset"/></td>
</tr>
</table>		
</form>
<hr>
<a href="customerdashboard.jsp">Customer-Dashboard</a><br>
</body>
</html>
<%
con.close();
%>