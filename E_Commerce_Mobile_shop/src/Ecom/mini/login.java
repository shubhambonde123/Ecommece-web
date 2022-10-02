package Ecom.mini;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class login {
	Scanner sc=new Scanner(System.in);
	public boolean  getdata() {
		boolean b;
		//System.out.println("Welcome To E-Mobile Shop(E-Commerence) ");
		System.out.println("Are YOu Already Registered ...YES OR NO ");
		String validation=sc.nextLine();
		return b="yes".equalsIgnoreCase(validation);
		
	}
	
	public boolean Validation(String u, String p) throws SQLException{
		
		    boolean loginUsername = false;
	        boolean loginPassword = false;
	        boolean r = false;
	        
	        ConnectionDemo connectiondemo;
			Connection con=null;
			PreparedStatement ps;

	        while(u != null) {

	            try {
	            	connectiondemo =new ConnectionDemo();
    				con=connectiondemo.getConnectionDemo();
    				ps=con.prepareStatement("SELECT userid,UserPass FROM user");
               
	    			ResultSet rs = ps.executeQuery();
	    			//u=null;
	    			

	                while(rs.next()) {
	                	
	                	if(u==(rs.getString("userid"))) {
	                		String username = rs.getString("userid");
		                    String Password = rs.getString("UserPass");
		                   // System.out.println("GET USER from database "+username);
		                   // System.out.println("GET pass from database "+Password);
		                    boolean v1=checkU(username,u);
		                    boolean p1=checkp(Password,p);
		                    if(v1==true || p1==true) {
		                    	r=true;
		                    	 
		                    	 break ;
		                    	//if close
		                    }else {
		                    	r= false;
		                    	break;
		                    }
	                	}
	                    
	                    
	                }//inner while close
	                break;
	               //return r; 
	            } catch(SQLException e) {
	            	//e.printStackTrace();

	            	}//catch close
	        }
	        System.out.println(r);
               return r; 	
              
   }//validation close



	private boolean checkU(String Usrname, String u) {
		 boolean Usr= false;
		if(Usrname != null){
			System.out.println(u);
			System.out.println(Usrname);
       	 if(u.equals(Usrname)) {
       		 System.out.println(" ");
       		 	Usr = true;
            }else {
              	System.out.print("  Invalid Userid ...");
                Usr=false;
             }
       	 
		}
		return Usr;
		
	}//close checkU
	
	private boolean checkp(String Usrname, String u) {
		 boolean Usr=false;
		if(Usrname != null){
			
       	 if(u.equals(Usrname)) {
                //  System.out.println(message.invalidUsername());
       		 	Usr = true;
            }else {
              	System.out.print("  Invalid passsword ...");
                Usr=false;
             }
       	 
		}
		return Usr;
	}//close checkp

}//login close
