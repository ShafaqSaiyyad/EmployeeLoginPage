package com.nt.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VeiwAllDatabase
 */
@WebServlet("/veiw")
public class VeiwAllDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Connection con=DBConnection.getCon();
            PreparedStatement pstmt=con.prepareStatement("select * from userdata");
            ResultSet rs=pstmt.executeQuery();
            PrintWriter pw=res.getWriter();
            while(rs.next()) {
            	pw.println("<h2>"+rs.getString(1)+"&nbsp&nbsp"+
            rs.getString(2)+"&nbsp&nbsp"+rs.getString(3)+
            "&nbsp&nbsp"+rs.getString(4)+"&nbsp&nbsp"+rs.getString(5)
            +"&nbsp&nbsp"+rs.getString(6)+"&nbsp&nbsp"+
            rs.getString(7)+"&nbsp&nbsp"+"</h2>");
            }
		} catch (Exception e) {
  			e.printStackTrace();
		}
	req.getRequestDispatcher("veiwAllData.html").include(req, res);
	}

}
