<jsp:useBean id="info" class="com.ssi.Product" scope="session" />

<html>
<body>
<h3>Product-Details</h3>
<hr>
<pre>
	PCode		<jsp:getProperty name="info" property="pcode"/>
	PName		<jsp:getProperty name="info" property="pname"/>
	Price		<jsp:getProperty name="info" property="price"/>
</pre>
<hr>
<a href="psearch.jsp">Search-Again</a><br>
<a href="admindashboard.jsp">DashBoard</a><br>
</body>
</html>