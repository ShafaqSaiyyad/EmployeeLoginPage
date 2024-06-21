package com.nt.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDAO {
	Connection con=null;
	int k=0;
	public int deleteUser(String name,String password) {
		try {
			con=DBConnection.getCon();
			PreparedStatement pstmt=con.prepareStatement("delete from userdata where username=? and password=?");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			k=pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
