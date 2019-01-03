package com.ssi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//reads-the-request
		String s1=request.getParameter("t1");
		
		//process-it-using-model
		Product p=new Product();
		p.setPcode(s1);
		
		//store to scope object
		HttpSession session=request.getSession();	
		session.setAttribute("info", p);
		
		//forward-to-view
		response.sendRedirect("showproduct.jsp");
	}

}
