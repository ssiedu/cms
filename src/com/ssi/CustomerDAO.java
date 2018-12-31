package com.ssi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAO {

	Connection con;

	public CustomerDAO(){
		con=com.ssi.DataUtil.connect();
	}
	public ArrayList<Customer> getAllCustomers(){
		ArrayList<Customer> list=new ArrayList<Customer>();
		
		String qr="select * from customer";
		try{
		PreparedStatement ps=con.prepareStatement(qr);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			
			Customer c=new Customer();
			c.setEmail(rs.getString("email"));
			c.setPassword(rs.getString("password"));
			c.setCname(rs.getString("cname"));
			c.setAddress(rs.getString("address"));
			c.setMobile(rs.getString("mobile"));
			list.add(c);
		}
		
		
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	public Customer getCustomer(String email){
		
		Customer customer=new Customer();
		String qr="select * from customer where email=?";
		try{
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		rs.next();
		customer.setEmail(rs.getString(1));
		customer.setPassword(rs.getString(2));
		customer.setCname(rs.getString(3));
		customer.setAddress(rs.getString(4));
		customer.setMobile(rs.getString(5));
		}catch(Exception e){
			e.printStackTrace();
		}
		return customer;
	}
	
	
	
	
	
	public void saveCustomerRecord(Customer customer){
		
		String qr="insert into customer values(?,?,?,?,?)";
		try{
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1,customer.getEmail());
		ps.setString(2, customer.getPassword());
		ps.setString(3, customer.getCname());
		ps.setString(4, customer.getAddress());
		ps.setString(5, customer.getMobile());
		ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
}
