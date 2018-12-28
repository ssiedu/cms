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
import javax.servlet.http.HttpSession;

@WebServlet("/SaveComplaint")
public class SaveComplaint extends HttpServlet {
	Connection con; PreparedStatement ps;
	public void init(){
		try{
			con=DataUtil.connect();
			String qr="insert into complaint(pcode,email,ctext,cdate,status) values(?,?,?,?,?)";
			ps=con.prepareStatement(qr);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void destroy(){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		//reading email from session
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("userid");
		//String email=request.getParameter("email");
		String pcode=request.getParameter("pcode");
		String ctext=request.getParameter("ctext");
		java.util.Date dt=new java.util.Date();
		long val=dt.getTime();
		java.sql.Date cdate=new java.sql.Date(val);
		try{
		ps.setString(1, pcode);
		ps.setString(2, email);
		ps.setString(3, ctext);
		ps.setDate(4, cdate);
		ps.setString(5, "pending");
		ps.executeUpdate();
		out.println("<h3>Complaint Registered Successfully");
		}catch(Exception e){
			out.println(e);
		}
		
	}

}
/*
cmpid  | int(11)      | NO   | PRI | NULL    | au
pcode  | varchar(15)  | YES  |     | NULL    |
email  | varchar(20)  | YES  |     | NULL    |
ctext  | varchar(100) | YES  |     | NULL    |
cdate  | date         | YES  |     | NULL    |
status | varchar(15)  | YES  |     | NULL    |
ecode  | varchar(20)  | YES  |     | NULL    |
vdate  | date         | YES  |     | NULL    |
remark | varchar(100) | YES  |     | NULL    |
*/