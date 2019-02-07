import java.util.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
public class Gym 
{
	//attributes
	private String gymName, managerName, phoneNumber;
	private ArrayList<Member> members; //for account holding
	
//	private ArrayList<Gym> gymDetails; //for gym detail holdings
	
	//methods
	//the constructor
	public Gym()
	{	
		members = new ArrayList<Member>();
	}
	
	public ArrayList<Member> getMember()
	{
		return members;
	}
	
	public Gym(String gymName, String managerName)
	{
		members = new ArrayList<Member>();
		if(gymName.length() <= 30) //check that the name is 30 characters or less
		{
			this.gymName = gymName;
		}
		else
		{
			System.out.println("Gym name is too long");
		}
		this.managerName = managerName;
	}
	
	public Gym(String gymName, String managerName, String phoneNumber)
	{
		members = new ArrayList<Member>();
		if (gymName.length() <= 30)
		{
			this.gymName = gymName;
		}
		else
		{
			System.out.println(gymName);
		}
		
		this.managerName = managerName;
		
		boolean numeric = true;
		try
		{
		}
		catch (NumberFormatException e)
		{
			numeric = false;
		}
		if(numeric)
		{
			this.phoneNumber = phoneNumber;
		}
		else
		{
			this.phoneNumber = "Unknown";
		}
	}
	
	//add a gym member
	public void add (Member member)
	{
		 System.out.print(member.toString());
		 System.out.print("members: "+members);
		members.add(member);
	}
	
	//remove a member, index is number of member that will be removed
	public void remove(int index)
	{
		members.remove(index);
	}
	
	//returns the number of members stored in the gym
	public int numberOfMembers()
	{
		return members.size();
	}
	
	public String listMembers(){
		if (members.size() > 0){
			
			String listOfMembers = "";
			for (int i = 0; i < numberOfMembers(); i++) {
				listOfMembers += i + ": " + members.get(i) + "\n";
			}
			return listOfMembers;
		}
		else {
			return "There are no members in the gym";
		}
	}
	
	private String searchFunction(String category) {
		String result = new String();
		for(Member member :members) {
			if(member.determineBMICategory() == category) {
				result += "\n" + member.getMemberName();
			}
		}
		return result;
	}
	
	public String listBySpecificBMICategory(String category) {
		String result = new String("The list of the members with the requested category has been displayed returning to menu\n");
		String memeberNames = new String();
		switch(category) {
			case "VERY SEVERELY OBESE":
				memeberNames = searchFunction("VERY SEVERELY OBESE");
				if(!memeberNames.isEmpty()) {
					result += "\nThe following people are very severely obese";
					result += memeberNames;
				}
				else {
					result += "\nNo members found with this condition";
				}
				break;
			case "SEVERELY OBESE":
				if(!memeberNames.isEmpty()) {
					result += "\nThe following people are severely obese";
					result += memeberNames;
				}
				else {
					result += "\nNo members found with this condition";
				}
				break;
			case "MODERATELY OBESE":
				if(!memeberNames.isEmpty()) {
					result += "\nThe following people are moderatly obese";
					result += memeberNames;
				}
				else {
					result += "\nNo members found with this condition";
				}
				break;
			case "OVERWEIGHT":
				if(!memeberNames.isEmpty()) {
					result += "\nThe following people are overweight";
					result += memeberNames;
				}
				else {
					result += "\nNo members found with this condition";
				}
				break;
			case "NORMAL":
				if(!memeberNames.isEmpty()) {
					result += "\nThe following people are normal";
					result += memeberNames;
				}
				else {
					result += "\nNo members found with this condition";
				}
				break;
			case "UNDERWEIGHT":
				if(!memeberNames.isEmpty()) {
					result += "\nThe following people are underweight";
					result += memeberNames;
				}
				else {
					result += "\nNo members found with this condition";
				}
				break;
			case "SEVERELY UNDERWEIGHT":
				if(!memeberNames.isEmpty()) {
					result += "\nThe following people are severely underweight";
					result += memeberNames;
				}
				else {
					result += "\nNo members found with this condition";
				}
				break;
			case "VERY SEVERELY UNDERWEIGHT":
				if(!memeberNames.isEmpty()) {
					result += "\nThe following people are very severely underweight";
					result += memeberNames;
				}
				else {
					result += "\nNo members found with this condition";
				}
				break;
			case "OBESE":
				if(!memeberNames.isEmpty()) {
					result += "\nThe following people are obese";
					result += memeberNames;
				}
				else {
					result += "\nNo members found with this condition";
				}
				break; 
		}
		return result;
	}
	
	public String listMembersWithIdealWeight() {
		if(members.size()==0) 
		{
			return "there are no members in the gym";
		}
		else 
		{
		int j=0;
		
		for (Member i: members) {
			if (i.determineBMICategory()=="NORMAL") {
	            System.out.println(i.getMemberName()+" has an ideal bodyweight");
	            j++;
			}
			
		}
		if(j==0) {
			System.out.println("there are no members in the gym with an ideal weight");
		}
		return "the method doesn't work without this so it needs to be here";
		}
	}
	
	public String listMemberDetailsImperialAndMetric() {
		for (Member i: members) {										
            System.out.println(i.getMemberName()+": " +i.getStartingWeight()+" kg (" +i.convertWeightToPounds()+" lbs)"+i.getHeight()+" metres ("+i.convertHeightMetresToInches()+" inches).");
        }																							
		return "filler text";
	}
	
	
	
//	public void addGymDetails (Gym gym)
//	{
//		gymDetails.add(gym);
//	}
	
	//gym methods
	public String getGymName() 
	{
		return gymName;
	}
	
	public String getManagerName()
	{
		return managerName;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	//setter methods
	public void setGymName(String gymName)//checks name is less than 30 characters
	{
		if(gymName.length() <= 30)
		{
			this.gymName = gymName;
		}
		else
		{
			System.out.println(gymName);
		}
	}
	
	public void setManagerName(String managerName)
	{
		this.managerName = managerName;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	public String toString()
	{
		return "\n\nGym Name: " + this.gymName + "\nManager: " + this.managerName + "\nPhone Number: " + this.phoneNumber+  "\n\n " ;
	}
	
	@SuppressWarnings("unchecked")
    public void load() throws Exception //Load from XML File
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("members.xml"));
        members = (ArrayList<Member>) is.readObject();
        is.close();
    }
    public void save() throws Exception //Save to XML File
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("members.xml"));
        out.writeObject(members);
        out.close();    
    }
}


















