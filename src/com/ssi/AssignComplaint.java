package com.ssi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignComplaint")
public class AssignComplaint extends HttpServlet {

	Connection con; PreparedStatement ps,ps1;
	
	@Override
	public void destroy() {
		try
		{
		con.close();
		}catch(Exception e){}
	}

	@Override
	public void init() throws ServletException {
		String qr="insert into comp_eng values(?,?,Now())";
		String qr1="update complaint set status='assigned' where cmpid=?";
		con=DataUtil.connect();
		try{
		ps=con.prepareStatement(qr);
		ps1=con.prepareStatement(qr1);
		}catch(Exception e){}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cid=Integer.parseInt(request.getParameter("cid"));
		String ecode=request.getParameter("ecode");
		try{
		ps.setInt(1, cid);
		ps.setString(2, ecode);
		ps.executeUpdate();
		
		ps1.setInt(1, cid);
		ps1.executeUpdate();
		
		response.sendRedirect("showallcomplaints.jsp");
		
		
		}catch(Exception e){e.printStackTrace();}
		
	}

}
