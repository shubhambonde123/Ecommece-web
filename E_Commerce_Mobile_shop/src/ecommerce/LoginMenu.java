package ecommerce;

import java.util.Scanner;

public class LoginMenu {
	Scanner sc=new Scanner(System.in);
	public int type() {
		System.out.print("Select Your  Login   \n 1.Admin \n 2.User \n Enter Choice = ");
		String loginT=sc.nextLine();
		String temp=loginT;
		boolean a="admin".equalsIgnoreCase(temp);
		boolean u="user".equalsIgnoreCase(temp);
		if(a=true) {
			return 1;
		}else {
			return 2;
		}
	}// close type
	
	public int adminMenu() {
		System.out.println("\t\tMENU\n\t 1.add Product\n\t 2.check Quantity \n \t 3.Display All User List\n\t 4.");
		System.out.print("Enter Your Choice (eg. 1 or 2 )= ");
		int  key=Integer.parseInt(sc.nextLine());
		return key;
	}
	
	public int UserMenu() {
		System.out.println("\t\tMENU\n\t 1.Display Product\n\t 2. view Cart\n \t 3.");
		System.out.print("Enter Your Choice (eg. 1 or 2 )= ");
		int  key=Integer.parseInt(sc.nextLine());
		return key;
	}
	

}//close LoginMenu class 
