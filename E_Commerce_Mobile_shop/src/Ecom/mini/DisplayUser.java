package Ecom.mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayUser {
	public void UserList()  throws SQLException{
		ConnectionDemo connectiondemo;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			connectiondemo =new ConnectionDemo();
			con=connectiondemo.getConnectionDemo();
			String sql="Select *from user_registration where UserType='user'";
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("User id = "+rs.getInt(1));
		    	   System.out.println("Name = "+rs.getString(2));
		    	   System.out.println("Address = "+rs.getString(3));
		    	   System.out.println("Pincode = "+rs.getInt(4));
		    	   System.out.println("User Type = "+rs.getString(5));
		    	   System.out.println("MObile No. = "+rs.getString(6));
		    	   System.out.println("\n \n ");

			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Display User/userlist()");
		}
		
	}

}
