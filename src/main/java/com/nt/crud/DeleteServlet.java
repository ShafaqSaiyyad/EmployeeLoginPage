package com.nt.crud;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		int k= new DeleteDAO().deleteUser(name,password);
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		if(k>0) {
			pw.print("<style>body{ text-align:center;}</style>");
			pw.print("<h2>USER DELETED SUCESSFULLY.</h2>");
			pw.print("<a href=deleteUser.html>BACK</a>");
			
		}
		else {
			pw.print("<style>body{ text-align:center;}</style>");
			pw.print("<h2>FAILED TO DELETE.</h2>");
			pw.print("<a href=deleteUser.html>BACK</a>");
		}
	}

}
