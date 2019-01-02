<%@page import="com.ssi.*,java.sql.*"%>


<jsp:useBean id="pr" class="com.ssi.Product"/>
<jsp:setProperty property="pcode" name="pr" param="t1"/>



<html>
<body>
<h3>Product-Details</h3>
<hr>
<pre>
	PCode		<jsp:getProperty name="pr" property="pcode"/>
	PName		<jsp:getProperty name="pr" property="pname"/>
	Price		<jsp:getProperty name="pr" property="price"/>
</pre>
<hr>
<a href="psearch.jsp">Search-Again</a><br>
<a href="admindashboard.jsp">DashBoard</a><br>
</body>
</html>