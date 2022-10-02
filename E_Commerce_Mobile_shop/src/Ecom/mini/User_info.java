package Ecom.mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class User_info{
	public void userGetdata(String type) throws SQLException{
		Scanner sc=new Scanner(System.in);
		ConnectionDemo connectiondemo;
		Connection con=null;
		PreparedStatement ps;
		
		System.out.println("Enter user Name : ");
		String name=sc.nextLine();
		System.out.println("Enter address : ");
		String address=sc.nextLine();
		System.out.println("Enter pincode : ");
		int pincode=Integer.parseInt(sc.nextLine());
		System.out.println("Enter Mobile NO : ");
		String mo=sc.nextLine();
		try {
			connectiondemo =new ConnectionDemo();
			con=connectiondemo.getConnectionDemo();
			
			ps=con.prepareStatement("insert into user_registration(U_name,U_address,U_pincode,UserType,MObile) values(?,?,?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, address);
			String p=String.valueOf(pincode);
			ps.setString(3,p);
			ps.setString(4,type);
			ps.setString(5,mo);
			int i=ps.executeUpdate();
			System.out.println("*****");
			
			
			//System.out.println("*****");
			System.out.println("record Inserted "+i);
			
			System.out.println("record Inserted "+i);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}