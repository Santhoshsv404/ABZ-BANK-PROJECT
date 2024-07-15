package com.abzbank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pwd = req.getParameter("npwd");
		HttpSession session = req.getSession();
		int accno = (int) session.getAttribute("accno");
		try {
		model m = new model();
		m.setAccont_number(accno);
		m.setPassword(pwd);
		boolean b =m.changePwd();
		if(b==true) {
			resp.sendRedirect("ChangePwdSuccess.html");
			}
			else {
			resp.sendRedirect("ChangePwdFail.html");
			}
		
		
		
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}
	
}


