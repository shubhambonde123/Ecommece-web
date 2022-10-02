package Ecom.mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayProductlist {
	Scanner sc=new Scanner(System.in);
	public void displayProduct(String Ulog)throws SQLException{
		ConnectionDemo connectiondemo;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			connectiondemo =new ConnectionDemo();
			con=connectiondemo.getConnectionDemo();
			String sql="Select product_name,price,discription from product order by product_name ASC;";
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 System.out.println("\n ");
		    	   System.out.println("Mobile Name = "+rs.getString(1));
		    	   System.out.println("price = "+rs.getInt(2));
		    	   System.out.println("Description  = "+rs.getString(3));
		    	 
			}
			rs.close();
			System.out.println("\n \t menu");
			System.out.println("\n 1.add Cart \n 2.Buy Product \n Select Your Choice 1 or 2");
			int ch=Integer.parseInt(sc.nextLine());
			switch (ch) {
			case 1:
				System.out.println("Enter Mobile Name : ");
				String Mname=sc.nextLine();
				Cart c=new Cart();
				System.out.println("dipaly pass ulog "+Ulog);
				c.addcartProduct(Mname,Ulog);
				break;
			case 2:
				
				break;

			default:
				break;
			}
		}catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Display User/userlist()");
		}finally {
			sc.close();
			ps.close();
			con.close();
			//rs.close();
		}
		
		
	}

}
