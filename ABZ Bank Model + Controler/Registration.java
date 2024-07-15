package com.abzbank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserReg")
public class Registration  extends HttpServlet{	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 String Name =  req.getParameter("name");
		 String Customer_ID =  req.getParameter("customer_id");
		 String SAccont_number = req.getParameter("account_number");
		 int  Account_number = Integer.parseInt(SAccont_number);
		 String password =  req.getParameter("userpwd");
		 String SBalance = req.getParameter("balance");
		 int   Balance = Integer.parseInt(SBalance); 
		 String Email = req.getParameter("email");
		 
		try {
			
			model m = new model();
			 
			 m.setName(Name);
			 m.setCustomer_ID(Customer_ID);
			 m.setAccont_number(Account_number);
			 m.setPassword(password);
			 m.setBalance(Balance);
			 m.setEmail(Email);
			 
			 boolean b = m.Register();
			 
			 
			 if(b == true) {
				 
				 resp.sendRedirect("RegisterSucces.html");
				 
			 }
			 else {
				 
				 resp.sendRedirect("RegisterFailur.html");
				 
			 }
			
		}
		catch (Exception e) {
			e.getMessage();
		}
		 
		  
		
		
		
		
		
	}
	
	
	

}
