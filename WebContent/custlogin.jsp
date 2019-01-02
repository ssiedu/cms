<%@include file="info.jsp" %>
<%
	//step-1 (fetch all cookies)
	Cookie ck[]=request.getCookies();
	//step-2 (search the desired ones)
	String s1="",s2="";
	for(Cookie c:ck){
		String name=c.getName();
		if(name.equals("mailId")){
			s1=c.getValue();
		}else if(name.equals("pwd")){
			s2=c.getValue();
		}
	}
%>

<html>
<body>
<h3>Customer-Login-Form</h3>
<hr>
<form action="VerifyCustomer" method="post">
<pre>
Email		<input type="text" name="email" value="<%=s1%>" />
Password	<input type="password" name="password" value="<%=s2%>"/>
Save Pwd	<input type="checkbox" name="save" value="yes" checked="checked"/>
		<input type="submit" value="Login"/>
</pre>
</form>
</pre>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>