package com.nt.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Spliterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String id;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 	String uname=req.getParameter("uname");
	 	String password=req.getParameter("password");
	 	PrintWriter pw=res.getWriter();
	 	res.setContentType("text/html");
	 	try {
	 		UserBean eb=LoginDAO.login(uname,password);
	 		ArrayList<UserBean> al=LoginDAO.list;
	 		Spliterator <UserBean> sp=al.spliterator();
	 		if(eb!=null) {
	 			sp.forEachRemaining((k)->{
	 				id=k.getPassword();
	 				pw.println("<h2>"+k.getUname()+"&nbsp&nbsp"+k.getPassword()+"&nbsp&nbsp"+k.getAddress()
	 				+"&nbsp&nbsp"+k.getMail()+"&nbsp&nbsp"
	 						+k.getPhno()+"&nbsp&nbsp"+k.getState()+
	 						"&nbsp&nbsp"+k.getCountry());
	 			});
	 			req.getRequestDispatcher("showd.html").include(req, res);
	 		}
	 		else {
	 			req.getRequestDispatcher("failLogin.html").include(req, res);
	 		}
	 		
	 	}
	 	catch(Exception e) {
	 		e.printStackTrace();
	 	}
	}

}
