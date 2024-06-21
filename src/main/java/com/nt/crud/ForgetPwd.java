package com.nt.crud;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgetPwd
 */
@WebServlet("/forgot")
public class ForgetPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String mailId=req.getParameter("mailId");
		String newPwd=req.getParameter("newpwd");
		
		int k=new forgetDAO().forgetPwd(name,mailId,newPwd);
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		if(k>0) {
			pw.print("<style>body{ text-align:center;}</style>");
			pw.print("<h2>PASSWORD UPDATED SUCESSFULLY.</h2>");
			pw.print("<a href=ForgotPwd.html>BACK</a>");
			
		}
		else{
			pw.print("<style>body{ text-align:center;}</style>");
			pw.print("<h2>FAILED TO UPDATE PASSWORD.</h2>");
			pw.print("<a href=ForgotPwd.html>BACK</a>");
		}
		
	}

}
