package Electricity_Billing;
	import java.time.*;
	import java.sql.Connection;
	import java.util.*;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.Statement;
	import java.sql.ResultSet;
	abstract class Details1{
		protected static Connection con=null;
		protected static Scanner sc=new Scanner(System.in);
		protected String user,password,url;
		//abstract void operations();
	}
	public class Admin_Bill extends Details1{
		//protected static Connection con =null;
		//protected static Scanner sc = new Scanner(System.in);
		public void operations() {
			System.out.println("Enter your password:");
			String passwrd=sc.next();
			if(passwrd.equals("Saikiran.123@")==false) {
				System.out.println("Wrong password...");
				System.exit(0);
			}
			try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		url="jdbc:mysql://localhost:3306/fprojectONE";
		user="root";
		password="Qwertyuiop1!";
		con=DriverManager.getConnection(url,user,password);
		int f=0;
		while(f==0) {
		System.out.println("If u wnt to insert , type'1',"
				+ "delete  type '2' , "
				+ "update  '3', To see Records type '4', to Exit press '0','5','6','7','8','9'");
		System.out.println("Insert choice:");
		int choice=sc.nextInt();
		switch(choice){
		case 1:
			InsertRecord();
			
			break;
		
		case 2:
			DeleteRecord();
			break;
		case 3:
			UpdateRecord();
			break;
		case 4:
			ShowRecord();
			break;
		default:
			f=1;
			System.out.println("Exit.....:");
			System.exit(0);
		}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
}

			protected static void InsertRecord() throws Exception {
				System.out.println("Enter the number of records to insert :");
				int n=sc.nextInt();
				int i=1;
				while(i<=n) {
				System.out.println("Enter the customer bill details");
				String s1="insert into bill values(?,?,?,?,?,?,?)";
				PreparedStatement pre= con.prepareStatement(s1);
				System.out.println("Enter customer id");
				String id=sc.nextLine();
				System.out.println("Enter customer name");
				String name=sc.next();
				System.out.println("Enter customer phone no");
				String phone_no=sc.nextLine();
				String date=LocalDateTime.now().toString();
				
				System.out.println("Enter the units consumed");
				int units=sc.nextInt();
				
				pre.setString(1, id);
				pre.setString(2,name);
				
				pre.setString(3,phone_no);
				pre.setString(4,date);
				pre.setInt(5,units);
				
				int rows =pre.executeUpdate();
				if(rows>0) {
					System.out.println("Record inserted succesfully");
					System.out.println();
				}
				i++;
				}
				
			}
			protected static void ShowRecord() throws Exception{
			System.out.println("Fetching the customer bill details:");
			System.out.println();
			String sq="select * from bill";
			Statement st= con.createStatement();
			ResultSet rt=st.executeQuery(sq);
			while(rt.next()) {
				System.out.println(rt.getString(1)+ " || " + rt.getString(2)+ " || " + rt.getString(3)+ "|| " +rt.getString(4)+ " || " + rt.getInt(5));
			}
			}
			
		protected static void UpdateRecord() throws Exception{
			System.out.println("Enter name: ");
			String name =sc.next();
			System.out.println("Enter customer id: ");
			int id=sc.nextInt();
			String sq1="update  bill set cus_name= ? where cus_id=?";
			PreparedStatement pq =con.prepareStatement(sq1);
			pq.setString(1,name);
			pq.setInt(2, id);
			int rows =pq.executeUpdate();
			if(rows>0) {
				System.out.println("Record updated succesfully");
			}
			String sq="select * from bill";
			Statement st= con.createStatement();
			ResultSet rt=st.executeQuery(sq);
			while(rt.next()) {
				System.out.println(rt.getString(1)+ " || " + rt.getString(2)+ " || " + rt.getString(3)+ "|| " +rt.getString(4)+ " || " + rt.getString(5));
			}
		}
		protected static void DeleteRecord() throws Exception {
			System.out.println("Enter customer id: ");
			int id =sc.nextInt();
			String sq1="delete from bill where cus_id=?";
			PreparedStatement pq =con.prepareStatement(sq1);
			pq.setInt(1,id);
			int rows =pq.executeUpdate();
			if(rows>0) {
				System.out.println("Record deleted succesfully");
			}
			else {
				System.out.println("Record is empty can't be deleted");
			}
			if(rows>0) {
			System.out.println(" After deleting : ");
			String sq="select * from bill";
			Statement st= con.createStatement();
			ResultSet rt=st.executeQuery(sq);
			while(rt.next()) {
				System.out.println(rt.getString(1)+ " || " + rt.getString(2)+ " || " + rt.getString(3)+ "|| " +rt.getString(4)+ " || " + rt.getString(5));
			}
		}
		}
		
}
