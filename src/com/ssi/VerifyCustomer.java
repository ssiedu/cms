package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		ServletContext context=getServletContext();	
		con = (Connection)context.getAttribute("mycon");
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
			
			//storing email to session
			//step-1 fetch the session object created for this user
			HttpSession session=request.getSession();
			session.setAttribute("userid", email);
			
			//store the id/pwd with the help of cookies to client disk
			String toSave=request.getParameter("save");
			if(toSave!=null){
				//step-1 (create cookie object)
				Cookie c1=new Cookie("mailId",email);
				Cookie c2=new Cookie("pwd",password);
				//step-2 (set the maximum age of the cookie)
				c1.setMaxAge(60*60*24*7);
				c2.setMaxAge(60*60*24*7);
				//step-3 (add cookie to response object)
				response.addCookie(c1);
				response.addCookie(c2);
			}
			
			
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
