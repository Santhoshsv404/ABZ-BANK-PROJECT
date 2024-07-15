package com.abzbank;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GetStatement")
public class GetStatement extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		int accno = (int) session.getAttribute("accno");
		
		try {
			
		model m = new model();
		m.setAccont_number(accno);
		
		ArrayList al = m.getStatement();
		
		
		
		if(al.isEmpty() ==true) {
			resp.sendRedirect("StatementFail.html");
			}
			else {
			session.setAttribute("sal", m.sal);
			session.setAttribute("ral", m.ral);
			session.setAttribute("al", m.al);
			resp.sendRedirect("StatementSuccess.jsp");
			}
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
