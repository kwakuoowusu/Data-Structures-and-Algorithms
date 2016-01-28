/**
 * Kwaku Owusu
 * 109181846
 * HW 3
 * CSE 214 Recitation 3
 * Recitation TA Sun Lin
 * Grading TA Ke Ma
 * @author Kwaku
 * 
 */
public class Card {
	private char suit;
	private int suitType;
	private String value;
	private boolean faceUpValue = false;
	private boolean isRed = false;
	public String foundation;
	private int type;
	//even black
	final static String values[] = {" ","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    final static char suits[]    = {' ', '\u2666', '\u2663','\u2665', '\u2660'};
	
	public Card(){
		
	}
	
	/**
	 * Sets the suit value of a card
	 * @param type
	 */
	public void setSuit(int type){
		  	suitType = type;
			suit = suits[type];
	}
	public int getSuitType(){
		return suitType;
	}
	/**
	 * Returns the suit type of a card
	 * @return suit
	 */
	public char getSuit(){
		return suit;
	}
	
	/**
	 * Sets the value of a card
	 * @param type
	 */
	public void setValue(int type){
		 this.type = type;
		 value =  values[type];
	}
	
	/**
	 * Returns the value of the card
	 * @return
	 */
	public String getValue(){
		return value;
	}
	
	/**
	 * Checks to see if a Card is face up
	 * @return
	 */
	public boolean isFaceUp(){
		if(faceUpValue==false){
			return false;
		}
		else
			return true;
	}
	/**
	 * Sets the foundation name of a card
	 * @param foundation
	 */
	public void setFoundation(String foundation){
		this.foundation = foundation;
	}
	/**
	 * returns the foundation
	 * @return
	 */
	public String getFoundation(){
		return foundation;
	}
	
	/**
	 * Sets the card faceUp when ready
	 * @param faceUp
	 */
	public void setFaceUP(boolean faceUp){
		faceUpValue = faceUp;
	}
	
	/**
	 * Checks to see if a Card is read or not
	 * If the value of the card is even or a queen it is black
	 * Otherwise it will be black
	 * @return
	 */
	public boolean isRed(){
		return isRed;
		
		}
	
	/**
	 * Sets the color of a card
	 * @param color
	 */
	public void setRed(boolean color){
		if(color==true){
			isRed = true;
		}
		else
			isRed = false;
	}
	/**
	 * Prints the qualities of a card
	 */
	public String toString(){
		String s = "[" + value + suit + "]" ;
		return s;
	}
	
	/**
	 * Returns the number value of a card eg. ace=1 j=11 q=12
	 * @return
	 */
	public int getType(){
		return type;
	}
	public static void main(String []args){
	
		
	}
}
