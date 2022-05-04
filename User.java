package ElectricityBillSystem.Bill;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.*;


public class User  {
	protected static Connection con =null;
	protected static Scanner sc = new Scanner(System.in);
	protected static void fetchUserDetails() throws Exception {
	String s1 ="select *,(units*amt_per_unit) as total_amt from bill where cus_id = ?";
		System.out.println("Fetching User details: ");
		System.out.println("Enter your customer id: ");
		PreparedStatement pre= con.prepareStatement(s1);
		int id=sc.nextInt();
 		pre.setInt(1,id);
		ResultSet rt=pre.executeQuery();
		if(rt.next()) {
			System.out.println(rt.getString(1)+ " || " + rt.getString(2)+ " || " + rt.getString(3)+ "|| " +rt.getString(4)+ " || " + rt.getString(5)+ " || " +rt.getString(6)+ " || " +rt.getString(7)+ " || " +rt.getString(8));
		}
		else {
			System.out.println(" Record not found");
		}
	}
	protected static void Bill_Paid() throws Exception{
		String s1="select *,(units*amt_per_unit) as total_amt from bill where cus_id = ?";
		System.out.println("Enter the customer id: ");
		PreparedStatement pre= con.prepareStatement(s1);
		int id=sc.nextInt();
 		pre.setInt(1,id);
 		ResultSet rt=pre.executeQuery();
 		if(rt.next()) {
 			System.out.println("Bill not paid");
 		}
 		else {
 			System.out.println("Bill Paid");
 		}
		
	}
	protected static String check_password() throws Exception{
		System.out.println("Enter your password to check: ");
		String s1 = sc.nextLine();
		return s1;
	}
}
