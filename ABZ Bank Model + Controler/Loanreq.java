package com.abzbank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Loanreq")
public class Loanreq extends HttpServlet {
	
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		int  accno = (int) session.getAttribute("accno");
		
		try {
			
			model m= new model();
			m.setAccont_number(accno);
			boolean b = m.applyloan();
			
			if (b == true)
			{
				session.setAttribute("name",m.getName());
				session.setAttribute("email",m.getEmail());
				resp.sendRedirect("LoanSuccess.jsp");
				
			}
			else {
				resp.sendRedirect("LoanFailed.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
