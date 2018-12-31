package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveCustomerUpdates")
public class SaveCustomerUpdates extends HttpServlet {
Connection con; PreparedStatement ps;
	
	@Override
	public void destroy() {
		try
		{
		con.close();
		}catch(Exception e){}
	}

	@Override
	public void init() throws ServletException {
		con=DataUtil.connect();
		String qr="update customer set password=?,cname=?,address=?,mobile=? where email=?";
		try{
		ps=con.prepareStatement(qr);
		}catch(Exception e){}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String email=(String)request.getSession().getAttribute("userid");
		String password=request.getParameter("password");
		String cname=request.getParameter("cname");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		try{
			ps.setString(1, password);
			ps.setString(2, cname);
			ps.setString(3, address);
			ps.setString(4, mobile);
			ps.setString(5, email);
			ps.executeUpdate();
			out.println("<html><body>");
			out.println("<h4>Profile Changed Successfully<h4>");
			out.println("<h4><a href=customerdashboard.jsp>Dashboard</a><h4>");
			out.println("</body></html>");
			
		}catch(Exception e){
			out.println(e);
		}
		
		
	}
}
