package com.ssi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ProductListHandler extends SimpleTagSupport {

	private int start=1;
	private int end=500000;
	
	
	
    public int getStart() {
		return start;
	}



	public void setStart(int start) {
		this.start = start;
	}



	public int getEnd() {
		return end;
	}



	public void setEnd(int end) {
		this.end = end;
	}



	@Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try{
        	Connection con=com.ssi.DataUtil.connect();
        	PreparedStatement ps=con.prepareStatement("select * from products where price between ? and ?");
        	ps.setInt(1, start);
        	ps.setInt(2, end);
        	ResultSet rs=ps.executeQuery();
        	out.println("<table border=2>");
        	out.println("<tr>");
        	out.println("<td>PCode</td>");
        	out.println("<td>PName</td>");
        	out.println("<td>Price</td>");
        	out.println("</tr>");
        	while(rs.next()){
        		out.println("<tr>");
            	out.println("<td>"+rs.getString(1)+"</td>");
            	out.println("<td>"+rs.getString(2)+"</td>");
            	out.println("<td>"+rs.getString(3)+"</td>");
            	out.println("</tr>");
        	}
        	out.println("</table>");
        	
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
    
}
