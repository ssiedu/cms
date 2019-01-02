package com.ssi;
import java.sql.*;
public class Product {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String pcode;
	private String pname;
	private int price;
	
	public Product(){
		con=com.ssi.DataUtil.connect();
		try{
		ps=con.prepareStatement("select * from products where pcode=?");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
		try{
		ps.setString(1, pcode);
		rs=ps.executeQuery();
		rs.next();
		pcode=rs.getString(1);
		pname=rs.getString(2);
		price=rs.getInt(3);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
