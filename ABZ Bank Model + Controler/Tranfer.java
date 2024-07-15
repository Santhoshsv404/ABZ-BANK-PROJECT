package com.abzbank;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Tranfer")
public class Tranfer extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int accno = (int) session.getAttribute("accno");
		String samt = req.getParameter("amt");
		int amt = Integer.parseInt(samt);
		
		String sraccno = req.getParameter("raccno");
		int raccno = Integer.parseInt(sraccno);
		
		try {
		model m = new model();
		m.setAccont_number(accno); 
		m.setRaccno(raccno);
		m.setBalance(amt);
		boolean b = m.transfer();
		if(b==true) {
			resp.sendRedirect("TransferSuccess.html");
			}
			else {
			resp.sendRedirect("TransferFail.html");
			}
		
		
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		
		
		
	}

}
