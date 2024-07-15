package com.abzbank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private HttpSession session;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		 String Customer_ID =  req.getParameter("customer_id");
		 String password =  req.getParameter("userpwd");
		 
		 session = req.getSession(true);
		 
		 try {
			 
			 
			 model m = new model();
			 
			 m.setCustomer_ID(Customer_ID);
			 m.setPassword(password);
			 
			  boolean b = m.Login();
			  
			  if (b == true)
			  {
				  session.setAttribute("accno",m.getAccont_number());
				  resp.sendRedirect("Home.html");
			  }
			  else {
				  resp.sendRedirect("Error.html");
			  }
			 
			 
		 }
		 catch (Exception e) {
			
			 e.printStackTrace();
		}
		
		
		
	}
	
	

}
