package Ecom.mini;

import java.lang.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class UserLogin {
	
		String UserLogin;
		String UserPass;
		Scanner sc=new Scanner(System.in);
		
		
		public String UserReg()throws SQLException {
			System.out.println("Welcome to User Registration ");
			System.out.println("Create your UserName ");
			UserLogin =sc.nextLine();
			System.out.println("Create your Password ");
			UserPass=sc.nextLine();
	        boolean b=checkUser(UserLogin,UserPass);
			return UserLogin;
			//System.out.println(b);
			
		}
		private boolean checkUser(String u,String p) throws SQLException{
			ConnectionDemo connectiondemo;
			Connection con=null;
			PreparedStatement ps;
			try {
				connectiondemo =new ConnectionDemo();
				con=connectiondemo.getConnectionDemo();
				
				ps=con.prepareStatement("insert into user(userid,UserPass)values(?,?)");

				//System.out.println("*****");
				ps.setString(1, u);
				ps.setString(2, p);
				
				int i=ps.executeUpdate();
				//System.out.println("*****");
				System.out.println(" 	Registration Sucessful........."+i);
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return true;
			
		}
		

}
