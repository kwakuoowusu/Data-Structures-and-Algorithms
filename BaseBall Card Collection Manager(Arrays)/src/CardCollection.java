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
public class CardCollection {

	static final int MAX_CARDS = 100;
	BaseballCard collection [] = new BaseballCard[MAX_CARDS+1];
	
	/**
	 * Constructs a CardColletcion with no baseball cards
	 * <dt><b>Postcondition</b><dd> Initializes CardCollection with an 
	 * empty list of baseball cards
	 */
	public CardCollection(){
		BaseballCard collection [] = new BaseballCard[MAX_CARDS+1];

	}
	/**
	 * Finds the number of cards in a collection
	 * <dt><b>Precondition:</b><dd> There is a card collection object created
	 * @return The number of baseball cards in a collection
	 */
	public int size(){
		int count = 0;
		for(int i = 1; i<MAX_CARDS+1; i++)
			if(collection[i]instanceof BaseballCard)
				count++;
			return count;
	}
	/**
	 * Adds card to the current collection
	 * @param newCard new card object created by user
	 * @param position position to place card in collection
	 * <dt><b>Precondition: There is a card collection object created, 
	 * 	position is less than one, and less than one greater than number of cards
	 * in list</dt></b>
	 * <dt><b>Postcondition: A BaseballCard is now stored in the collection
	 * @throws IllegalArgumentException If the position is less than one 
	 * the user is prompted to reenter a position
	 * @throws FullCollectionException If the position entered by the user is over 100
	 * the user informed the collection is full
	 */
	public void addCard(BaseballCard newCard, int position) {
		try{
			if(position<1){
				System.out.print("You can't input a position less than 1! Please input a proper position: ");

				throw  new IllegalArgumentException();
			}
			if(position==size()+2){
				System.out.print("Please input a position that is"
						+ " either one plus the amount of cards in your collection, or "
						+ "a number within your collection: ");
				throw new IllegalArgumentException();
				}
		}catch(IllegalArgumentException ex){
			throw new IllegalArgumentException();
		}
		
		try{
			if(position>MAX_CARDS-1)
				throw new FullCollectionException();
		}catch(FullCollectionException ex){
			System.out.println("You can't input a position greater than one hundred!"
					+ "This collection is full");
			System.out.print("Please input a proper position: ");
			Scanner input = new Scanner(System.in);
			int retry = input.nextInt();
			addCard(newCard,retry);
		}
		
		int length = size();
		
		if(position == length +1){
			collection[position] = newCard;
		}
		
		if(position<=length){
			int i = position;
			BaseballCard[] temp = new BaseballCard [2];
			temp[0] = collection[i];
			collection[i] = newCard;
			
			
				while(i<length){
					temp[1] = collection[i+1];
					collection[i+1] = temp[0];
					temp[0] = temp[1];
					i++;
				}
		}
		
	}
	/**
	 * Adds a card to the end of a collection
	 * @param newCard
	 */
	public void addCard(BaseballCard newCard){
		int pos = size() + 1;
		
	
			addCard(newCard,pos);
		
	}
	
	/**
	 * Removes the current collection
	 * @param position position to remove card from collection
	 * <dt><b>Precondition: There is a card collection object created, 
	 * 	position is less than one, and less than one greater than number of cards
	 * in list</dt></b>
	 * <dt><b>Postcondition: A BaseballCard is now removed from the collection
	 * @throws IllegalArgumentException If the position is less than one 
	 * the user is prompted to reenter a position
	 * @throws FullCollectionException If the position entered by the user is over 100
	 * the user informed the maximum amount of card stored is 100
	 */
	public void removeCard(int position){
		try{
			if(position<1)
				throw  new IllegalArgumentException();
		}catch(IllegalArgumentException ex){
			System.out.println("You can't input a position less than zero!");
			System.out.print("Please input a proper position: ");
			Scanner input = new Scanner(System.in);
			int retry = input.nextInt();
			removeCard(retry);
		}
		if(position==size()+2){
			System.out.print("Please input a position that is"
					+ " either one plus the amount of cards in your collection, or "
					+ "a number within your collection: ");
			throw new IllegalArgumentException();
			}
		
		try{
			if(position>MAX_CARDS-1)
				throw new FullCollectionException();
		}catch(FullCollectionException ex){
			System.out.println("You can't input a position greater than one hundred!"
					+ "this collection is full");
			System.out.print("Please input a proper position: ");
			Scanner input = new Scanner(System.in);
			int retry = input.nextInt();
			removeCard(retry);
		}
		
		int length = size();
		
		if(position == length){
			collection[position] = null;
		}
		
		if(position<=length){
			int i = position;
			BaseballCard[] temp = new BaseballCard [2];
			temp[0] = collection[i];
			collection[i] = null;
			
				while(i<length-1){
					temp[1] = collection[i+1];
					collection[i] = temp[0];
					temp[0] = temp[1];
					i++;
				}
		}
	}
	/**
	 * Obtains a BaseballCard for the user
	 * @param position
	 * * <dt><b>Precondition: There is a baseball card in the current collection
	 *  and the position used by the user is greater than 1 and less than or equal
	 *  to the maximum amount of cards in the collection</dt></b>
	 * @return a BaseBallCard
	 */
	public BaseballCard getCard(int position){
		
		
		try {
			if( position>size())
			throw new IllegalArgumentException();
		}catch(IllegalArgumentException ex){
			throw new IllegalArgumentException();
		}
		
		return collection[position];
		}
		

	public void trade(CardCollection other, int myPosition, int theirPosition){
		BaseballCard[] temp= new BaseballCard[2];
		temp[0] = collection[myPosition];
		temp[1] = other.collection[theirPosition];
		other.collection[theirPosition] = temp[0];
		collection[myPosition] = temp[1];
		
	}
	
	/**
	 * Checks if the contents of each card are equal
	 * @param card
	 * <dt><b> Precondition: There is a BaseballCard initialzied
	 * @return boolean true or false
	 */
	public boolean exists(BaseballCard card){
			int count = 0;
			for(int i = 1; i<=size(); i++)
			{
				if(collection[i].equals(card))
				count++;

			}
			if(count>0)
				return true;
			return false;
		
		
	}
	/**
	 * Prints out a formatted table for the BaseballCard objects
	 * Sends the collection to the toString(pos)
	 */
	public void printAllCards(){
		
		String tableNumber = "#";
		tableNumber = String.format("%-5s", tableNumber);
		
		String tableName = "Name";
		tableName= String.format("%-25s",tableName);
		
		String tableManufacturer = "Manufacturer";
		tableManufacturer = String.format("%-25s",tableManufacturer);
		
		String tableYear = "Year";
		tableYear = String.format("%-6s",tableYear);
		
		String tablePrice = "Price";
		tablePrice = String.format("%-11s",tablePrice);
		
		String tableSize = "Size";
		tableSize = String.format("%-11s",tableSize);
		
		String numberDash = "-";
		numberDash = String.format("%-5s", numberDash);
		
		String nameDash = "----";
		nameDash =  String.format("%-25s", nameDash);
		
		String manuDash = "------------";
		manuDash = String.format("%-25s", manuDash);
		
		String yearDash = "----";
		yearDash = String.format("%-6s",yearDash);
		
		String priceDash ="-----";
		priceDash = String.format("%-11s",priceDash);
		
		String sizeDash = "----";
		sizeDash = String.format("%-11s",sizeDash);

			System.out.println(tableNumber + tableName + tableManufacturer + tableYear
					+tablePrice + tableSize +"\n" + numberDash + nameDash +
					manuDash + yearDash + priceDash+ sizeDash);
		
			collection.toString();
		}
		
		
/**
 * Turns the aspects of all BaseballCards inside a collection into a string
 * <dt><b> Precondition: A CardCollection has been created
 * @return S the string form of a BaseballCard
 */
	public String toString(){
		String s ="";
		int amount = size();
		if(amount == 0){
			s= "No cards in this collection";
			System.out.print(s);
			return s;
		}
		if(amount> 0){
			for(int i = 1; i <= size(); i++){
				int numTally = i;
				String numTable = String.format("%-5d", numTally);
				
				String name = collection[i].getName();
				name = String.format("%-25s", name);
				
				String manufacturer = collection[i].getManufacturer();
				manufacturer = String.format("%-25s", manufacturer);
				
				int noyear = collection[i].getYear();
				String year = String.format("%-6d$", noyear);
				
				double noPrice = collection[i].getPrice();
				String price = String.format("%-11.2f", noPrice);
				
				int noSizeX = collection[i].getSizeX();
				
				int noSizeY = collection[i].getSizeX();
				
				String size = noSizeX + "x" +noSizeY;
				String trueSize= String.format("%-11s", size);
				
				 s = s+ numTable + name + manufacturer + year + price + trueSize +"\n";
			
			}
		}
		System.out.print(s);
		return s;
		
		
	}
	/**
	 * Turns the aspects of one BaseballCard inside a collection into a string
	 * @param pos the position of the single card to be printed
	 * <dt><b> Precondition: A CardCollection has been created
	 * @return the string form of a BaseballCard
	 * @throws IllegalArgumentException if the position  is less than 1 or greater than MAX_CARDS
	 */
	public String toString(int pos){
		
		try{
		if(pos<1||pos>MAX_CARDS+2||pos>size()){
			System.out.print("You can not print a card thats not in the collection!");
			throw new IllegalArgumentException();
			}
		}catch(IllegalArgumentException ex){
			throw new IllegalArgumentException();
		}
		
		int numTally = pos;
		String numTable = String.format("%-5d", numTally);
		
		String name = collection[pos].getName();
		name = String.format("%-25s", name);
		
		String manufacturer = collection[pos].getManufacturer();
		manufacturer = String.format("%-25s", manufacturer);
		
		int noyear = collection[pos].getYear();
		String year = String.format("%-6d$", noyear);
		
		double noPrice = collection[pos].getPrice();
		String price = String.format("%-11.2f", noPrice);
		
		int noSizeX = collection[pos].getSizeX();
		
		int noSizeY = collection[pos].getSizeX();
		
		String size = noSizeX + "x" +noSizeY;
		String trueSize= String.format("%-11s", size);
			
			String tableNumber = "#";
			tableNumber = String.format("%-5s", tableNumber);
			
			String tableName = "Name";
			tableName= String.format("%-25s",tableName);
			
			String tableManufacturer = "Manufacturer";
			tableManufacturer = String.format("%-25s",tableManufacturer);
			
			String tableYear = "Year";
			tableYear = String.format("%-6s",tableYear);
			
			String tablePrice = "Price";
			tablePrice = String.format("%-11s",tablePrice);
			
			String tableSize = "Size";
			tableSize = String.format("%-11s",tableSize);
			
			
		
				String numberDash = "-";
				numberDash = String.format("%-5s", numberDash);
				
				String nameDash = "----";
				nameDash =  String.format("%-25s", nameDash);
				
				String manuDash = "------------";
				manuDash = String.format("%-25s", manuDash);
				
				String yearDash = "----";
				yearDash = String.format("%-6s",yearDash);
				
				String priceDash ="-----";
				priceDash = String.format("%-11s",priceDash);
				
				String sizeDash = "----";
				sizeDash = String.format("%-11s",sizeDash);
		
					System.out.println(tableNumber + tableName + tableManufacturer + tableYear
							+tablePrice + tableSize +"\n" + numberDash + nameDash +
							manuDash + yearDash + priceDash+ sizeDash);
				
		return numTable + name + manufacturer + year + price + trueSize +"\n"
				;
	}
	/**
	 * Sums up the value of all cards in a collection
	 * @return value the string form of the value of card in a collection
	 */
	public String value(){
		double numberValue = 0;
		for(int i = 1; i <= size(); i++){
			numberValue = numberValue + collection[i].getPrice();
		}
		String value = "$" + String.format("%.2f", numberValue);
		return  value;
		
	}

	public class FullCollectionException extends Exception{
		/**
		 * Creates an exception with blank parameters
		 */
		   public FullCollectionException() {
		    	  
		      }

		 /**
		  * Handles the exception created when a user enters a
		  * year that is less than 1900
		  * @param info
		  */
		   public FullCollectionException(String info)
		      {
		         super(info);
		      }
		 }
		 		
		 	
	
	public static void main(String[] args) {
			
			
	}
	

}
