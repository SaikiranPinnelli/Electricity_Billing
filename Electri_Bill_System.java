package Electricity_Billing;
import java.util.*;

public class ElectricityBillingSystem {
	private static Scanner sc=new Scanner(System.in);
	public static  String test() {
		System.out.println("If u r an admin, type 'admin', if u r an user, type 'user'::");
		String type=sc.next();
		if(type.toLowerCase().equals("admin")==false && type.toLowerCase().equals("user")==false) {
			while(type.toLowerCase().equals("admin")==false && type.toLowerCase().equals("user")==false) {
				System.out.println("If u r an admin, type 'admin', if u r an use, type 'user'::");
				type=sc.next();
			}
		}
		return type;
	}
public static void main(String[] args) {
 
	
	String type=test();
	
	
		if(type.toLowerCase().equals("admin")==true) {
			Admin_Bill admin=new Admin_Bill();
			admin.operations();
			
		}
	else {
		User user=new User();
		user.operations();
		}
	
}
}
