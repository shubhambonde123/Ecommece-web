package Ecom.mini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionDemo {
	public Connection getConnectionDemo() {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_commerce","root","Root@1234");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection Problem ....Ecom.mini.ConnectionDEmo");
		}
		return con;
	}
}
