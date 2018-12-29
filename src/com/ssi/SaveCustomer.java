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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cname=request.getParameter("cname");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		Customer c=new Customer(email,password,cname,address,mobile);
		CustomerDAO dao=new CustomerDAO();
		dao.saveCustomerRecord(c);
		out.println("<html><body>");
		out.println("<h4>Registered Successfully<h4>");
		out.println("<h4><a href=index.jsp>Home</a><h4>");
		out.println("</body></html>");
			
			
		
	}
}
