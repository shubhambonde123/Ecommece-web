package Ecom.mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class checkQuantity {
	Scanner sc=new Scanner(System.in);
	
	public void seequantity() throws SQLException{
		ConnectionDemo connectiondemo;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			connectiondemo =new ConnectionDemo();
			con=connectiondemo.getConnectionDemo();
			System.out.println("Enter product id ");
			String id=sc.nextLine();
			String sql="select product_name,Quantity from product"+" where product_id='"+id+"'";
			//above line id is not set properly 
			//System.out.println(sql);
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			    	   System.out.println("Name= "+rs.getString(1));
			    	   System.out.println("Quantity= "+rs.getString(2));

			       System.out.println("");	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception Occur in CheckQuantity/seequantity()");
		}

	}

}
