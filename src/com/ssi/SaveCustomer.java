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

public class SaveCustomer extends HttpServlet {
	
	Connection con;
	
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cname=request.getParameter("cname");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		try{
	
			String qr="insert into customer values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, cname);
			ps.setString(4, address);
			ps.setString(5, mobile);
			ps.executeUpdate();
			out.println("<html><body>");
			out.println("<h4>Registered Successfully<h4>");
			out.println("<h4><a href=index.jsp>Home</a><h4>");
			out.println("</body></html>");
			
		}catch(Exception e){
			out.println(e);
		}
		
		
	}
}
