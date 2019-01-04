package com.ssi;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextHandler implements ServletContextListener {

	Connection con;
	
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	try{
    		con.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodata","root","root");
    		ServletContext context=arg0.getServletContext();
    		context.setAttribute("mycon", con);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
	
}
