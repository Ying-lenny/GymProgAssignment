
public class Member 
{
	
	//The Attributes
	private int memberId;
	private String memberName;
	private String memberAddress;
	private double height; //in meters
	private double startingWeight; //in kg
	private String gender;
	
	//The Constructor and parameters
	public Member (int memberId, String memberName, String memberAddress, double height, double startingWeight, String gender)
	{
		if(memberId > 100000 && memberId <= 999999) //refining the id system
		{
			this.memberId = memberId;
		}
		else 
		{
			System.out.println("\t*ID not registered, invalid ID entered");
		}
		
		if(memberName.length() <= 30) //restricting the character limit to 30
		{
			this.memberName = memberName;
		}
		else 
		{
			System.out.println("\t*Name not registered, outside of character limit");
		}
		
			this.memberAddress = memberAddress; //no parameters
		
		if(height >= 1.0 && height <= 3.0)//height must be within 1 to 3 meters
		{
			this.height = height;
		}
		else
		{
			System.out.println("\t*Height is too wacky");
		}
		
		if(startingWeight >= 35 && startingWeight <= 250)//weight parameters
		{
			this.startingWeight = startingWeight;
		}
		else 
		{
			System.out.println("\t*You are too heavy/light");
		}
		
		if(gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("M")) //gender is either M, F or unspecified 
		{
			this.gender = gender;
		}
		else 
		{
			this.gender = "Unspecified ";
		}
	}
	
	//method to override string command
	public String toString()
	{
		return "\n Member id: " + memberId + "\n Name: " + memberName + "\n Address: " + memberAddress + "\n Height: " + height + "\n Starting Weight(KG): " + startingWeight + "\n Gender: " + gender + "\n Your BMI is: " +calculateBMI() + "\n";
	}
	
	public double convertHeightMetresToInches()
	{
		double total = 0;
		double inch = 39.37;
		total = (height * inch);
		double totalInches2dp = Math.round(total*100.0)/100.0;
		
		return totalInches2dp;
	}
	
	public double convertWeightToPounds()
	{
		return startingWeight * 2.204;
	}
	
	public Double calculateBMI()
	{
		Double result = 0.0;
		if( (height >= 1.0 && height <= 3.0) )//height must be within 1 to 3 meters
		{
			double heightSquared = height * height;
			
			result = startingWeight / heightSquared;
			result = toTwoDecimalPlaces(result);
		}
		return result;
	}
	
	private double toTwoDecimalPlaces(double num) {
		return (int) (num * 100) /100.0;
	}
	
	//checks if the bodyweight is ideal for each gender
	public boolean isIdealBodyWeight() {
		boolean isIdeal;
		switch(gender) {
		case"M":
			double ibw = (50+2.3)*(convertHeightMetresToInches()-60);
			if (startingWeight==ibw) {
				isIdeal=true;
				System.out.println("Body weight is ideal");
				break;
			}else {
				isIdeal=false;
				System.out.println("Body weight is not ideal");
				break;
			}
		
			
		case "F":
			ibw = (45.5+2.3)*(convertHeightMetresToInches()-60);
			if (startingWeight==ibw) {
				isIdeal=true;
				break;
			}else {
				isIdeal=false;
				break;
			}
			
		default: //defaults to female if unspecified
			ibw = (45.5+2.3)*(convertHeightMetresToInches()-60);
			if (startingWeight==ibw) {
				isIdeal=true;
				break;
			}else {
				isIdeal=false;
				break;
			}
		}	
		return isIdeal;
	}
	
	public String determineBMICategory() {
		double $bmi = calculateBMI();
		if ($bmi != 0.0) {
			if( $bmi >= 40 ) 
			{
				return "VERY SEVERELY OBESE";
			}
			else if(( $bmi >= 35) && ($bmi <= 39.9)) 
			{
				return "SEVERELY OBESE";
			}
			else if(( $bmi >=30) && ( $bmi <=34.9)) 
			{
				return "MODERATELY OBESE";
			}
			else if( ($bmi >=25) && ( $bmi <=29.9)) 
			{
				return "OVERWEIGHT";
			}
			else if(( $bmi >=18.5) && ( $bmi <=24.99)) 
			{
				return "NORMAL";
			}
			else if (( $bmi >=17) && ( $bmi <=18.49)) 
			{
				return "UNDERWEIGHT";
			}
			else if (( $bmi >=16) && ( $bmi <=16.99)) {
				return "SEVERELY UNDERWEIGHT";
			}
			else 
			{
				return "VERY SEVERELY UNDERWEIGHT";
			}			
		}
		return "Unavailable";
	}
	
	//getters to read attributes
		public int getMemberId()
		{
			return memberId;
		}
		
		public String getMemberName()
		{
			return memberName;
		}
		
		public String getMemberAddress()
		{
			return memberAddress;
		}
		
		public double getHeight()
		{
			return height;
		}
		
		public double getStartingWeight()
		{
			return startingWeight;
		}
		
		public String getMemberGender()
		{
			return gender;
		}
		
		
		//setter methods to assign values to each attribute
		public void setMemberId(int memberId)
		{
			if(memberId > 100000 && memberId <= 999999) //refining the id system
				{
					this.memberId = memberId;
				}
			else 
				{
					System.out.println("\t*ID not registered, invalid ID entered");
				}
		}
		
		public void setMemberName(String memberName)
		{
			if(memberName.length() <= 30) //restricting the character limit to 30
			{
				this.memberName = memberName;
			}
			else 
			{
				System.out.println("\t*Name not registered, outside of character limit");
			}
		}
		
		public void setMemberAddress(String memberAddress)
		{
			this.memberAddress= memberAddress;
		}
		
		public void setHeight(double height)
		{
			if(height > 1.0 && height < 3.0)//height must be within 1 to 3 meters
			{
				this.height = height;
			}
			else
			{
				System.out.println("\t*Height is too wacky");
			}
		}
		
		public void setStartingWeight(double startingWeight)
		{
			if(startingWeight >= 35 && startingWeight <= 250)//weight parameters
			{
				this.startingWeight = startingWeight;
			}
			else 
			{
				System.out.println("\t*You are too heavy/light");
			}
		}
		
		public void setGender(String gender)
		{
			if(gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("M")) //gender is either M, F or unspecified 
			{
				this.gender = gender;
			}
			else 
			{
				this.gender = "Unspecified ";
			}
		}
	

}






