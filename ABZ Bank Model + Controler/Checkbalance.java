package com.abzbank;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Checkbalance")
public class Checkbalance extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		int accno = (int) session.getAttribute("accno");
		
		try {
			
			model m = new model();
			
			m.setAccont_number(accno);
			
			boolean b = m.checkbalance();
			
			if(b==true)
			{
				session.setAttribute("bal", m.getBalance());
				resp.sendRedirect("BalanceView.jsp");	
				
			}
			else
			{
				resp.sendRedirect("BalanceFail.html");
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
