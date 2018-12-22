package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerifyCustomer
 */
@WebServlet("/VerifyCustomer")
public class VerifyCustomer extends HttpServlet {

	Connection con; PreparedStatement ps;

	@Override
	public void destroy() {
		try {
			con.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void init() throws ServletException {
		try{
		con = DataUtil.connect();
		ps=con.prepareStatement("select cname from customer where email=? and password=?");
		}catch(Exception e){e.printStackTrace();}
	}

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try{
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		boolean found=rs.next();
		if(found==true){
			response.sendRedirect("customerdashboard.jsp");
		}else{
			out.println("<html><body>");
			out.println("<h3>Invalid User Credentials</h3>");
			out.println("<h4><a href=custlogin.jsp>Try-Again</a></h4>");
			out.println("<h4><a href=custregi.jsp>Register-Now</a></h4>");
			out.println("<h4><a href=index.jsp>Home</a></h4>");
			out.println("</body></html>");
		}
			
		}catch(Exception e){
			out.println(e);
		}
	}

}
