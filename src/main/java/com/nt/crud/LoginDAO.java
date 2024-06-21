package com.nt.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoginDAO {
	public static ArrayList<UserBean> list=new ArrayList<>();
	public static UserBean login(String uname,String password) throws Exception
	{
		Connection con=DBConnection.getCon();
		UserBean ub=null;
		PreparedStatement pstmt=con.prepareStatement("select * from userdata where username=? and password=?");
		pstmt.setString(1, uname);
		pstmt.setString(2, password);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			ub=new UserBean();
			ub.setUname(rs.getString(1));
			ub.setPassword(rs.getString(2));
			ub.setAddress(rs.getString(3));
			ub.setMail(rs.getString(4));
			ub.setPhno(rs.getString(5));
			ub.setState(rs.getString(6));
			ub.setCountry(rs.getString(7));
			list.add(ub);
		}
		return ub;
		
	}

}
