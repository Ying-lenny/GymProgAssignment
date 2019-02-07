import java.util.*;
public class GymApp 
{
	Scanner input;  //creates scanner object called input that is used by all methods in this class
	Gym gym1;  //creates a bank object called gym1 that can be used by all methods in the class
	String gymName;
	String managerName;
	String phoneNumber;
	
	public GymApp()
	{
		input = new Scanner(System.in);
		System.out.println("please enter the Gym....");
		System.out.print("\tName: ");
		gymName=input.nextLine();
		System.out.print("\tManager Name: ");
		managerName=input.nextLine();
		System.out.print("\tphone number: ");
		phoneNumber=input.nextLine();
		gym1 = new Gym(gymName, managerName, phoneNumber); 
	} 
	//main method creates instance of itself
	public static void main (String args[])
	{
		GymApp app = new GymApp();
		app.runMenu();
	}
	
	//methods 
	
	private int mainMenu()
	{
		System.out.println("\nGym Menu");
		System.out.println("--------------");
		System.out.println(" 1) Add a member");
		System.out.println(" 2) List all members");
		System.out.println(" 3) Remove a member (by index)");
		System.out.println(" 4) Number of members in the gym");
		System.out.println("--------------");
		System.out.println(" 5) List of Gym Details.");
		System.out.println(" 6) List members with ideal starting weight");
		System.out.println(" 7) List members with a specific BMI category");
		System.out.println(" 8) List all members stats imperially and metrically");
		System.out.println("--------------");
		System.out.println(" 9) Save to Members.xml");
		System.out.println(" 10 Load from Members.xml");
		System.out.println(" 0) Exit");
		System.out.print("==>> ");
        int option = input.nextInt();
        return option;
	}
	
	//this method controls the loop
//	private void gymSetup()
//	{
//		
//	}
	
	private void runMenu()
	{
		int option = mainMenu();
		do 
		{
			switch (option)
			{
		    	case 1:    addMember();
		    			   break;
		    			   
		    	case 2:    System.out.println(gym1.listMembers());
		    			   break;
		    			   
		    	case 3:    removeMember();
		    			   break;
		    			   
		    	case 4:    System.out.println("Number of members: " + gym1.numberOfMembers());
		    			   break;
		    			   
		    	case 5:    
		    			   System.out.print(gym1.toString());
		    			   break;
		    	
		    	case 6:    gym1.listMembersWithIdealWeight();
		    			   break;
		    	
		    	case 7:    System.out.println("Enter the category in fullcaps: ");
            			   String category =input.nextLine();
            			   category=input.nextLine();
            			   System.out.print( gym1.listBySpecificBMICategory(category) );
		    			   break;
		    	
		    	case 8:	   gym1.listMemberDetailsImperialAndMetric();
		    			   break;
		    	
		    	case 9:    save();
		    			   break;
		    			   
		    	case 10:   load();
		    			   break;
		    			   
		    	case 0:    break;
		    	
		    	default:   System.out.println("Invalid option entered " + option);
		    	
			}	
			//display menu again
			option = mainMenu();
		}while (option !=0);
		
		//user chooses 0 so the program is exited
		System.out.println("Exiting the Gym system... bye");
		System.exit(0);
	}
	
	private void addMember()
	{
		input.nextLine();
		System.out.println("Please enter the Gym...(Entering more than one word breaks it so please don't do that)");
        
		System.out.println("ID Number (100001 and 999999): ");
		int memberID = input.nextInt();
		
		System.out.println("Name (max 30 characters): ");
		String memberName = input.next();
		
		System.out.println("Address: ");
		String memberAddress = input.next();
		
		System.out.println("Height (Between 1-3 Metres): ");
		double height = input.nextDouble();
		
		System.out.println("Starting Weight (between 35-250KG): ");
		double startingWeight = input.nextDouble();
		
		System.out.println("Gender (M/F); ");
		String gender = input.next();
		
		
		gym1.add(new Member(memberID, memberName, memberAddress, height, startingWeight, gender)); //using the add method in Gym class to add member info into array
	}
	
	private void removeMember()
	{
		//list all members and choose account to remove
		System.out.println(gym1.listMembers());
		
		if (gym1.numberOfMembers() !=0) {
			//only process delete if account exists in arrayList
			System.out.print("Index of members to delete ==>>");
			int index = input.nextInt();
			
			if (index < gym1.numberOfMembers() ) {
				//if index number exists in arrayList, delete it
				gym1.remove(index);
				System.out.println("Account Deleted");
			}
			else 
			{
				System.out.println("There is no account for this index number");
			}
		}
	}

	private void save() //Save to XML File
	{
		try
        {
			gym1.save();
		}
		catch(Exception e)
		{
				System.out.println("Error writing to file:  " + e);
		}
	}
	private void load() //Load from XML File
	{
		try
        {
			gym1.load();
		}
		catch(Exception e)
		{
				System.out.println("Error writing to file:  " + e);
		}
	}
}
		
		
	
	
	
	
	
	
	
