package ElectricityBillSystem.Bill;

public class Electri_Bill_System extends Admin_Bill{

	public static void main(String[] args)throws Exception {
		System.out.println("Welcome to online Electricity Bill System!!!!!\n");
		boolean rep=true;
		while(rep) {
		try {
			System.out.println("Enter your credentials for login: ");
			Credentials();
			rep=false;
			System.out.println("Successfully logged in ");
		}
			catch(Exception e) {
				System.out.println("Wrong login credentials. Try Again !!!!!!!");
				rep=true;
			}
		}
		   while(true) {
			System.out.println("Enter your choice: ");
			System.out.println("1: User 2: Admin 3: Exit ");
			int choice=sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("1: Fetch Record 2: Bill_Paid 3: Exit");
				int ch1=sc.nextInt();
				switch(ch1) {
				case 1:
				fetchUserDetails();
				break;
				case 2:
					Bill_Paid();
					break;
				case 3:
					System.out.println("Exited Successfully");
					System.exit(0);
					break;
					
				default:
					System.out.println("Invalid Choice");
				}
				break;
			case 2:
				System.out.println(" 1: Insert Record 2: Show Record 3: UpdateRecord 4: DeleteRecord 5: Exit");
				int ch =sc.nextInt();
				switch(ch) {
			case 1:
				InsertRecord();
				break;
				
			case 2:
				ShowRecord();
				break;	
			case 3:
				UpdateRecord();
				break;
			case 4:
				DeleteRecord();
				break;
			case 5:
				System.out.println("Exited Successfully");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
			}
				break;
			case 3:
				System.out.println("Exited Successfully");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				
		   }
	}
	}
}
