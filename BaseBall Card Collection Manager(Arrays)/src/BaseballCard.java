/**
 * Kwaku Owusu
 * 109181846
 * HW 1
 * CSE 214 Recitation 3
 * Recitation TA Sun Lin
 * Grading TA Ke Ma
 * @author Kwaku
 * 
 */
import java.util.Scanner;

public class BaseballCard {
	
    
	private int year= 0;
	
	private double price =0;
	
	private String manufacturer ="";
	
	private String name = "";
	
	private int[] size =new int [2];
	
	private int sizeX = size[0];
	
	private int sizeY=size[1];
	
	/**
	 * Creates a BaseballCard object with blank parameters
	 */
	
	public BaseballCard(){

	}
	
	/**
	 * Receive the name of the player on a BaseballCard
	 * @return the name of player on a BaseballCard object
	 */
	
	public String getName(){
		return name;
	}
	
	/**
	 * changes the name of a BaseballCard object to one set by the user
	 * @param name
	 */
	
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Receive the manufacturer of the BaseballCard object
	 * @return the name of the manufacturer of the BaseballCard
	 */
	
	public String getManufacturer(){
		return manufacturer;
	}
	
	/**
	 * changes the manufacturer of a BaseballCard object to one set by the user
	 * @param manufacturer
	 */
	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}
	
	/**
	 * Receives the year of a BaseballCard
	 * @return the year of a BaseballCard
	 */
	
	public int getYear(){
		return year;
	}
	
	/**
	 * changes the year of the BaseballCard to one set by the user
	 * @param year
	 * @throws cardYearException, if the card year is less than 1900 the user
	 * is prompted to enter the year again.
	 */
	public void setYear(int year){
		try{
			if(year>=1900)
			this.year = year;
			else
				throw new cardYearException();
		}catch(cardYearException ex){
			System.out.println("Baseball Cards weren't invented "
					+ "before 1900!");
			System.out.print("Please enter a valid year: ");
				Scanner input = new Scanner(System.in);
				int retry = input.nextInt();
				setYear(retry);
		}
	}
	/**
	 * Receives the price of a BaseballCard object
	 * @return the price of a BaseballCard as a double
	 */
	public double getPrice(){
		return price;
	}
	
	/**
	 * changes the price of a BaseballCard to one set by the user
	 * @param price
	 * @throws negativeNumberException if the user enters a price less than zero
	 * they are prompted to enter a valid price again
	 */
	public void setPrice(double price){
		
		try{
			if(price>0)
			this.price = price;
			else
				throw new negativeNumberException();
		}catch (negativeNumberException ex){
			System.out.println("The price can not be negative, "
					+ "please reenter a positive value");
			System.out.println("Enter a price:");
			Scanner input = new Scanner(System.in);
			double retry = input.nextDouble();
			setPrice(retry);
		}
		
	}
	/**
	 * Receives the x dimensions of a BaseballCard object
	 * @return the x dimensions of a BaseballCard as an int
	 */
	public int getSizeX(){
		return size[0];
	}
	/**
	 * Changes the size of the x dimensions of a BseballCard object to one set by user
	 * @param x
	 * @throws negativeNumberException if the x dimensions are less than zero, user is 
	 * prompted to try again
	 */
	public void setSizeX(int x){
		try{
			if(x>0)
				size[0] = x;
			else
			throw new negativeNumberException();
		}catch(negativeNumberException ex){
			System.out.print("Dimensions can not be zero or less!" +"\n");
			System.out.print("Please enter a valid dimension: ");
			Scanner input = new Scanner(System.in);
			int retry = input.nextInt();
			setSizeX(retry);
		}
		
	}
	/**
	 * Receives the y dimensions of a BaseballCard object
	 * @return the y dimensions of a BaseballCard as an int
	 */
	public int getSizeY(){
		return size[1];
	}
	
	
	/**
	 * Changes the size of the y dimensions of a BseballCard object to one set by user
	 * @param y
	 * @throws negativeNumberException if the y dimensions are less than zero, user is 
	 * prompted to try again
	 */
	public void setSizeY(int y){
		
		try{
			if(y>0)
				size[1] = y;
			else
			throw new negativeNumberException();
		}catch(negativeNumberException ex){
			System.out.print("Dimensions can not be zero or less!" +"\n");
			System.out.print("Please enter a valid dimension: ");
			Scanner input = new Scanner(System.in);
			int retry = input.nextInt();
			setSizeY(retry);
		}
	}
	
	/**
	 * Copies all information from the selected baseball card.
	 * Will not modify original
	 * @return a copy of a user selected BaseballCard object
	 */
	public Object clone(){  
		BaseballCard  cloned = new BaseballCard();
		cloned.name = this.getName();
		cloned.manufacturer=this.getManufacturer();
		cloned.year = this.getYear();
		cloned.price = this.getPrice();
		cloned.size[0]= this.getSizeX();
		cloned.size[1]= this.getSizeY();
		return cloned;
	}
	
	/**
	 * Checks to see if each component of a BaseballCard card to see if equal
	 * @param obj
	 * @return boolean if true everything is equal, false not equal
	 */
	public boolean equals(Object obj){
		if(!(obj instanceof BaseballCard))
			return false;
		BaseballCard compareable = (BaseballCard) obj;
		
		return(this.getPrice()==(compareable.getPrice())&&this.getYear()==
				(compareable.getYear())&&this.getSizeX()==(compareable.getSizeX())
				&&this.getSizeY()==(compareable.getSizeY())&&this.getName()==
				compareable.getName()&&this.getManufacturer()==compareable.getManufacturer());
		
	}
	
	public class negativeNumberException extends Exception
	{
		/**
		 * Creates an exception with blank parameters
		 */
		
	      public negativeNumberException() {
	    	  
	      }

	     /**
	      * Handles the exception created when a user enters a negative number
	      * @param info
	      */
	      public negativeNumberException (String info )
	      {
	         super(info);
	      }
	 }
	
	public class cardYearException extends Exception
	{
		/**
		 * Creates an exception with blank parameters
		 */
	      public cardYearException() {
	    	  
	      }

	      /**
		      * Handles the exception created when a user enters a
		      * year that is less than 1900
		      * @param info
		      */
	      public cardYearException(String info)
	      {
	         super(info);
	      }
	 }
	
	public static void main(String[] args) {
		
	}
	

}
