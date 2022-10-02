package Ecom.mini;
import java.lang.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Admin {
	String adUser;
	String apassword;
	Scanner sc=new Scanner(System.in);
	
	
	public String adminReg()throws SQLException {
		System.out.println("\n Welcome to Admin Registration ");
		System.out.println("Create your UserName ");
		adUser =sc.nextLine();
		System.out.println("create your Password ");
		apassword=sc.nextLine();
        boolean b=checkAdmin(adUser,apassword);
		return adUser;
		//System.out.println(b);
		
	}
	private boolean checkAdmin(String u,String p) throws SQLException{
		ConnectionDemo connectiondemo;
		Connection con=null;
		PreparedStatement ps;
		try {
			connectiondemo =new ConnectionDemo();
			con=connectiondemo.getConnectionDemo();
			
			ps=con.prepareStatement("insert into madmin(aduser,APassword)values(?,?)");

			System.out.println("*****");
			ps.setString(1, u);
			ps.setString(2, p);
			
			int i=ps.executeUpdate();
			//System.out.println("*****");
			//System.out.println("record Inserted "+i);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	

}
