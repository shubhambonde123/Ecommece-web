package Ecom.mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddProductDB extends Product{
	
	Scanner sc=new Scanner(System.in);
	//ArrayList<Product> arrayList1 = new ArrayList<Product>();
	
	
	public void productinsert() {
		//int flag =0;
		boolean b;
		do {
			String ad;
			
			
//			if(flag==0) {//use codition delete comment flag declartion
				/* this if flag condition is use as future as validation of admin .
				 * because invalid admin can not add the product into databse   */
//				System.out.println("Enter Your Admin Username");
//				ad=sc.nextLine();	
//			}
			
			System.out.println(" \t Add Product Details .....");
			System.out.println("Enter Product Name {mobile name length must >4 ) : ");
			String p_name=sc.nextLine();
			setProductName(p_name);
			String subid=p_name.substring(0, 4);
			System.out.println("Enter Product Id ");
			String P_id=subid+sc.nextLine();
			setProductId(P_id);
			System.out.println("Product id="+P_id);
			System.out.println("Enter Product Price");
			int price=Integer.parseInt(sc.nextLine());
			setPrice(price);
			System.out.println("Enter Product Quantity");
			int Quantity= Integer.parseInt(sc.nextLine());
			setQuantity(Quantity);
			System.out.println("Enter Product Description (company name, RAM ,ROM )");
			setDescription(sc.nextLine());		
			System.out.println("Enter your admin Username");
			setAdminid(sc.nextLine());
			
			
		//	System.out.println(getProductId());
			try {
				setproductDB();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(" AddProductDB.productinsert() ");
			}
			
			String str;
			System.out.println(" Add ONE More Product Yes /NO ");
			str=sc.nextLine();
			boolean a="no".equalsIgnoreCase(str);
			b="Yes".equalsIgnoreCase(str);
			
			if(a==true) {
				b=false;
			}
		} while (b==true);
		
	}
	
	
	public void setproductDB() throws SQLException{
		ConnectionDemo connectiondemo;
		Connection con=null;
		PreparedStatement ps=null;
		try {
			connectiondemo =new ConnectionDemo();
			con=connectiondemo.getConnectionDemo();
			
			ps=con.prepareStatement("insert into product(product_id,product_name,price,quantity,discription,userid)values(?,?,?,?,?,?)");

			System.out.println("*****");
			ps.setString(1,getProductId());
			ps.setString(2,getProductName());
			String temp=String.valueOf(getPrice());
			ps.setString(3,temp);
			temp=String.valueOf(getQuantity());
			ps.setString(4,temp);
			ps.setString(5, getDescription());
			ps.setString(6, getAdminid());
			
			int i=ps.executeUpdate();
			//System.out.println("*****");
			System.out.println(" Product Added Sucessfully........."+i);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
