package com.nt.crud;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException
	{
		try {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String addr=req.getParameter("address");
		String mail=req.getParameter("mailId");
		String phno=req.getParameter("phno");
		String state=req.getParameter("state");
		String country=req.getParameter("country");
		int k=new UpdateDAO().updateUser(name,password,addr,mail,phno,state,country);
		PrintWriter pw=res.getWriter();
		if(k>0) {
			pw.println("Sucessfully updated...");
		}
		else {
			pw.println("Failed to update...");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
