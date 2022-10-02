package Ecom.mini;

import java.sql.SQLException;
import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifGPSTagSet;

import ecommerce.LoginMenu;

public class Mobile_Shop {
	
	public static void main(String[] args) throws SQLException{
		Scanner sc=new Scanner(System.in);
		Admin a=new Admin();
		User_info uinfo=new User_info();//user infomation  object create
		int i=0;
		login lo=new login();
		UserLogin ul=new UserLogin();		//user login object create
		
		System.out.println("Welcome To E-Mobile Shop(E-Commerence) ");
		boolean alreadyreg=lo.getdata();	//login/getadata()	
		LoginMenu lm=new LoginMenu();
		if(alreadyreg==true) {
			i=lm.type();			//LoginMenu/type()
		}else{
			Mobile_Shop m=new Mobile_Shop();
			i=lm.type();
			if(i==1) {
				String Aid=a.adminReg();
				uinfo.userGetdata(Aid);
				m.main(null);
			}else {
				String Uid=ul.UserReg();
				uinfo.userGetdata(Uid);
				m.main(null);
			}
			
		}
		
		boolean v1=false;
		if(i==1) {
			login l=new login();
			System.out.println("Enter your UserName = ");
			String U=sc.nextLine();
			
			System.out.println("Enter your Password = ");
			String p=sc.nextLine();
			// v1=l.Validation(U,p) ;
			v1=true;
			if(v1==true ) {
				System.out.println(" Login Sucessfully.....");
				
				i=lm.adminMenu();		//loginMenu/adminMenu()
				switch (i) {
				case 1 :
					AddProductDB addProductDB= new AddProductDB();
					addProductDB.productinsert();
					
					break;
				case 2:
					checkQuantity cq=new checkQuantity();
					cq.seequantity();
					
					break;
				case 3:
					DisplayUser du=new DisplayUser();
					du.UserList();
					
					break;
				default:
					System.out.println("Invalid input .....");
					break ;
				}
			}else {
				 System.out.println(".... Login failed.....!!!!");
			}
		}else {
			login l=new login();
			System.out.println("Enter your UserName = ");
			String U=sc.nextLine();
			
			System.out.println("Enter your Password = ");
			String p=sc.nextLine();
			 v1=l.Validation(U,p) ;
			 if(v1==true) {
				
				 System.out.println(" Login Sucessfully.....");
				
				 i=lm.UserMenu();
				 switch (i) {
				case 1:
					DisplayProductlist dpl=new DisplayProductlist();
					dpl.displayProduct(U);
					break;
				case 2:
					Cart c=new Cart();
					System.out.println("Work in Progress....");
					c.User_view_cart(U);
					break;
				case 3:
					break;

				default:
					System.out.println("invalid Input....");
					
					break ;
				}
			 }else {
				 System.out.println(" Login failed.....");
			}
			
		}
	}
}
		
		
		
		
		
		

//System.out.println("main pass ulog "+ULog);
//uinfo.userGetdata("User");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		
//		
//		
//		
//		boolean b=false;
//		
//		
//		System.out.println("Are YOu Already Registered ...YES OR NO ");
//		String validation=sc.nextLine();
//		b="yes".equalsIgnoreCase(validation);
//		
//		
//		
//		
//		
//		//System.out.println(a);
//		
//		Admin ad=new Admin();//admin object created
//		if(b==true) {
//			
//			
//		}else {
//			ad.adminReg();	
//			uinfo.userGetdata("admin");
//		}
//		
//		
//		
//		menuloop:
//		if( a== true ){
//			
//			
//			
//			
//			
//		}else if( u==true ){
//			String ULog = null;
//			
//			System.out.println("Are YOu Already Registered ...YES OR NO ");
//			validation=sc.nextLine();
//			b="yes".equalsIgnoreCase(validation);
//			
//			
//			System.out.print("Enter Your Choice (eg. 1 or 2 )= ");
//			int  key=Integer.parseInt(sc.nextLine());
//			
//			switch (key) {
//			case 1 :
//				UserLogin ul=new UserLogin();		//user login object create
//				
//				if(b) {
//					ULog= ul.UserReg();
//					System.out.println("main pass ulog "+ULog);
//					uinfo.userGetdata("User");
//				}else {
//					login l=new login();
//					System.out.println("Enter your UserName = ");
//					String U=sc.nextLine();
//					System.out.println("Enter your Password = ");
//					String p=sc.nextLine();
//					v1=l.Validation(U, p);
//					if(v1==true) {
//						System.out.println(" Login Sucessfully.....");
//						break;
//					}else {
//						break menuloop;
//					}
//				}
//					
//				
//			
//				
//				break;
//			case 2:
//				
//				break;
//			case 3:
//				;
//				
//				break;
//			case 4:
//				System.out.println(" is not code added ");
//				break;
//
//			default:
//				System.out.println("Invalid input .....");
//				break;
//			}
//			
//			
//			
//		}
//		else {
//			System.out.println("Invalid Input .....");
//		}
//		
//		System.out.println("Good Bye main .....");
//	}
//	public void login(String T) {
//		if(T=="Admin") {
//			
//		}
//		if(T=="User") {
//			
//		}
//	}
//
//}
