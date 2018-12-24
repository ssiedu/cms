package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VerifyAdmin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		ServletConfig config=getServletConfig();
		
		String adminid=config.getInitParameter("admin-id");
		String adminpw=config.getInitParameter("admin-pw");
		
		if(id.equals(adminid) && pw.equals(adminpw)){
			response.sendRedirect("admindashboard.jsp");
		}else{
			out.println("Invalid Admin Account");
		}
	}

}
