package Electricity_Billing;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
abstract class Details{
	protected static Connection con=null;
	protected static Scanner sc=new Scanner(System.in);
	protected String user,password,url;
	abstract void operations();
}
public class User extends Details {


		protected static Connection con =null;
		protected static Scanner sc = new Scanner(System.in);
		public void operations() {
			try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //registering the driver class 1
			url="jdbc:mysql://localhost:3306/db"; // database path 3
			user="root";// 4
			password="Saikiran.123@";// 5
			con=DriverManager.getConnection(url,user,password); 
                       String id=checkDetails();
                       
						System.out.println("If u wnt to see status of the payment, type'1'"
								+ " and if u want to exit press any of 3,4,5,6,7,8 or 9::");
						System.out.println("Insert choice:");
						int choice=sc.nextInt();
						switch(choice){
						case 1:
							check_Paid(id);
							break;
						
						
						default:
						  
							System.out.println("Thank u.. visit again:::::");
							System.exit(0);
		}}
			catch(Exception e) {
				e.printStackTrace();
	}}
		protected static String checkDetails() throws Exception {
		
		String s1 ="select * from user_register where cus_id = ?";
			System.out.println("Enter your customer id: ");
			PreparedStatement pre= con.prepareStatement(s1);
			String id=sc.next();
	 		pre.setString(1,id);
			ResultSet rt=pre.executeQuery();
			if(rt.next()) {
				System.out.println("Successfully logged in");
				return id;
			}
			else {
				
				System.out.println("First register yourself");
				
				System.exit(0);
			}
			return "";
		}
		protected static void check_Paid(String id) throws Exception{
			
			String s1 ="select * from bill where cus_id = ?";
			PreparedStatement pre= con.prepareStatement(s1);
	 		pre.setString(1,id);
	 		ResultSet rt=pre.executeQuery();
	 		if(rt.next()) {
	 			System.out.println("Bill not paid, your pending bill is: "+(rt.getInt(5)*500));
	 			
	 		}
	 		else {
	 			System.out.println("Bill Paid");
	 		}
			
		}
		
	}

