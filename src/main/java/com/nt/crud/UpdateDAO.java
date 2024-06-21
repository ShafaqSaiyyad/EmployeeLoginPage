package com.nt.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO {
	Connection con=null;
	int k=0;
	public int updateUser(String name,String password,String address,String mailId,String phno,String state,String country) 
	{
		try {
			con=DBConnection.getCon();
			PreparedStatement pstmt=con.prepareStatement("update userdata set username=?,password=?,address=?,mail=?,phonenumber=?,state=?,country=? where password=?");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, address);
			pstmt.setString(4, mailId);
			pstmt.setString(5, phno);
			pstmt.setString(6, state);
			pstmt.setString(7, country);
			pstmt.setString(8, LoginServlet.id);
			int k=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
