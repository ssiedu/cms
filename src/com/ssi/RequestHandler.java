package com.ssi;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class RequestHandler implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent arg0)  { 
    	System.out.println("REQUEST DESTROYED================>>>>");
    }

    public void requestInitialized(ServletRequestEvent arg0)  { 
    	System.out.println("REQUEST INITIALIZED================>>>>");
    }
	
}
