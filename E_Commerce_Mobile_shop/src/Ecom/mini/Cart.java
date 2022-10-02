package Ecom.mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cart {
	ConnectionDemo connectiondemo;
	Connection con=null;
	PreparedStatement ps=null;
	int sum=0;
	
	public void addcartProduct(String Mname,String Ulog)throws SQLException{
		try {
			connectiondemo =new ConnectionDemo();
			con=connectiondemo.getConnectionDemo();
			String sql="insert into cart(productname,userid)values(?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, Mname);
			System.out.println("add  pass ulog "+Ulog);
			ps.setString(2, Ulog);
			int i= ps.executeUpdate();
			System.out.println("add product into cart sucessful....");
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Display User/userlist()");
		}finally {
			//sc.close();
			ps.close();
			con.close();
		}
		
	}
	
	public void removecartproduct() {
		
	}
	public void User_view_cart(String ulog) throws SQLException{
		try {
			connectiondemo =new ConnectionDemo();
			con=connectiondemo.getConnectionDemo();
			String sql="Select product_name,price,discription from product where uerid=ulog;";
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 System.out.println("\n ");
		    	   System.out.println("Mobile Name = "+rs.getString(1));
		    	   int calculate=+rs.getInt(2);
		    	   System.out.println("price = "+calculate);
		    	   System.out.println("Description  = "+rs.getString(3));
		    	   sum=sum+calculate;
			}
		
			System.out.println("All Product Price ="+sum);
		} catch (Exception e) {
			
			System.out.println("cart class / User_view_Cart Exception.........");
			e.printStackTrace();
		}
		
		
		
		
	}

}
