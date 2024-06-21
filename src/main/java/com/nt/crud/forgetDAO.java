package com.nt.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class forgetDAO {
	
	int k=0;
	Connection con=null;
	public int forgetPwd(String name,String mail,String newPwd)
	{
		try {
			con=DBConnection.getCon();
			PreparedStatement pstmt=con.prepareStatement("update userdata set password=? where username=? and mail=?");
			pstmt.setString(1, newPwd);
			pstmt.setString(2, name);
			pstmt.setString(3, mail);
			k=pstmt.executeUpdate();
		} catch (Exception e) {
				e.printStackTrace();
		}
		return k;
		
	}

}
