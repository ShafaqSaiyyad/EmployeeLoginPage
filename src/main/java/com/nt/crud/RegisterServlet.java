package com.nt.crud;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {

		UserBean ub=new UserBean();
		ub.setUname(req.getParameter("userName"));
		ub.setPassword(req.getParameter("password"));
		ub.setAddress(req.getParameter("address"));
		ub.setMail(req.getParameter("mailId"));
		ub.setPhno(req.getParameter("phno"));
		ub.setState(req.getParameter("state"));
		ub.setCountry(req.getParameter("country"));
		int k=new RegisterDAO().insertData(ub);
		
		if(k>0) {
			
			req.setAttribute("msg","<h1>Data Registered Succesfully...</h1>");
			req.getRequestDispatcher("Success.jsp").forward(req, res);
		}
		else {
			req.setAttribute("msg","<h1>Data Registeration failed...</h1>");
			req.getRequestDispatcher("Fail.jsp").forward(req, res);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}

}
