package com.nt.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO {
	 
	int n=0;
	 Connection con=null;
	public  int insertData(UserBean ub)
    {
		
		
			try {
				con=DBConnection.getCon();
				PreparedStatement pstmt=con.prepareStatement("insert into userdata values(?,?,?,?,?,?,?)");
				pstmt.setString(1, ub.getUname());
				pstmt.setString(2, ub.getPassword());
				pstmt.setString(3, ub.getAddress());
				pstmt.setString(4, ub.getMail());
				pstmt.setString(5, ub.getPhno());
				pstmt.setString(6, ub.getState());
				pstmt.setString(7, ub.getCountry());
				n=pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return n;
	}

}
