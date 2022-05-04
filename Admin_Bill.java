package ElectricityBillSystem.Bill;

    //import java.sql.Connection;
    //import java.util.*;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.Statement;
	import java.sql.ResultSet;

	public class Admin_Bill extends User{
		//protected static Connection con =null;
		//protected static Scanner sc = new Scanner(System.in);
		 public static void Credentials() throws Exception{
			System.out.println("Enter the username: ");
			final String user=sc.next();
			System.out.println("Enter your password: ");
			final String password=sc.next();
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/rahul_revature";
			con=DriverManager.getConnection(url,user,password);
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
				int id=sc.nextInt();
				System.out.println("Enter customer name");
				String name=sc.next();
				System.out.println("Enter customer address");
				String address=sc.next();
				System.out.println("Enter customer phone no");
				long phone_no=sc.nextLong();
				System.out.println("Enter customer payment date");
				String date=sc.next();
				System.out.println("Enter the units consumed");
				int units=sc.nextInt();
				System.out.println("Enter the amount per unit");
				int amtperunit=sc.nextInt();
				pre.setInt(1, id);
				pre.setString(2,name);
				pre.setString(3,address);
				pre.setLong(4,phone_no);
				pre.setString(5,date);
				pre.setInt(6,units);
				pre.setInt(7,amtperunit);
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
			String sq="select *,(units*amt_per_unit) as total_amt from bill";
			Statement st= con.createStatement();
			ResultSet rt=st.executeQuery(sq);
			while(rt.next()) {
				System.out.println(rt.getString(1)+ " || " + rt.getString(2)+ " || " + rt.getString(3)+ "|| " +rt.getString(4)+ " || " + rt.getString(5)+ " || " +rt.getString(6)+ " || " +rt.getString(7)+ " || " +rt.getString(8));
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
			String sq="select *,(units*amt_per_unit) as total_amt from bill";
			Statement st= con.createStatement();
			ResultSet rt=st.executeQuery(sq);
			while(rt.next()) {
				System.out.println(rt.getString(1)+ " || " + rt.getString(2)+ " || " + rt.getString(3)+ "|| " +rt.getString(4)+ " || " + rt.getString(5)+ " || " +rt.getString(6)+ " || " +rt.getString(7)+ " || " +rt.getString(8));
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
			String sq="select *,(units*amt_per_unit) as total_amt from bill";
			Statement st= con.createStatement();
			ResultSet rt=st.executeQuery(sq);
			while(rt.next()) {
				System.out.println(rt.getString(1)+ " || " + rt.getString(2)+ " || " + rt.getString(3)+ "|| " +rt.getString(4)+ " || " + rt.getString(5)+ " || " +rt.getString(6)+ " || " +rt.getString(7)+ " || " +rt.getString(8));
			}
		}
		}
		
}
