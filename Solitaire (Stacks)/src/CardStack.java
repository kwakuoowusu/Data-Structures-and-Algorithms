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



import java.util.Stack;




public class CardStack extends Stack<Object> implements Cloneable{
	char type;
	private String name = "";
	String foundation= "";
	public int capacity = 50;
	 Card[] data ;
	private int top = -1;
	
	public CardStack(char type){
		this.type = type;
		//t = tableau f = foundation w = waste s = stock
		if(type=='f'){
			capacity = 13;
			data = new Card[capacity];
		} 
		if(type=='t'){
			capacity = 20;
			data = new Card[capacity];
		}
		if(type == 's'||type == 'w'){
			capacity = 24;
			data = new  Card[capacity];
		}
		if(type == 'm'){
			capacity = 52;
			data = new Card[capacity];
		}
		
	}
	
	/** 
	 * Sets the foundation number of a type f card Stack can be f1-f4
	 * @param foundation
	 */
	public void setFoundation(String foundation){
		this.foundation = foundation;
		
	}
	
	/**
	 * Returns the foundation type
	 * @return foundation
	 */
	public String getFoundation(){
		return foundation;
	}
	
	/**
	 * Returns the type of a CardStack
	 * @return type
	 */
	public char getType(){
		return type;
	}
	
	/**
	 * Adds a card to the CardStacl
	 * If it is full no more can be added
	 * @param newCard
	 */
	public void push(Card newCard){
		if(top == capacity )
			return;
		top++;
		data[top] = newCard;
	}
	
	/**
	 * returns the top of a card stack
	 * @return ejected
	 */
	public Card pop(){
		Card ejected;
		if(isEmpty())
			throw new IllegalArgumentException("");
		ejected = data[top];
		data[top] = null;
		top--;
		return ejected;
		
	}
	
	public Card peek(){
		if(isEmpty()){
			return null;
			}
		
		return data[top];
	}
	
	/**
	 * Checks to see if the stack is empty
	 */
	public boolean isEmpty(){
		if(top<0){
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Checks the size of a cardStack
	 */
	public int size(){
		return (top+ 1);
	}
	
	/**
	 * Sets the name of a cardstack
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * Returns the name of a cardStack
	 * @return
	 */
	public String getName(){
		return name;
	}
	/**
	 * Prints a cardStack depending on the type
	 * @param type
	 */
	public void printStack(char type){
	 switch (type){
	 		
	 		case('s'):	if(!isEmpty()){
	 						
	 						System.out.print("[XX]");
	 						break;
	 					}
	 						else
	 							System.out.print("[  ]");
	 							break;
	 					
	 					
	 		case('w'):  if(top>-1){
	 					
	 						System.out.print(data[top].toString());
	 						break;
	 					}
	 		
	 					else
	 						System.out.print("[  ]");
	 						break;
	 					
	 		case('f'):  
	 					if(!isEmpty()){
	 						//System.out.print("F" + foundCount);
	 						//foundCount++;
	 						
	 						System.out.print(data[top].toString());
	 						break;
	 					}
	 					
	 					else{
	 						
	 						System.out.print("[" + getFoundation() + "]");
	 						break;
	 					}
	 					
	 		case('t'):
	 					
			 			if(top==-1){
		 					System.out.print("[  ]");
		 					System.out.println();
		 					break;
		 				}
	 					if(top==0){
	 						System.out.print(data[top].toString());
	 						System.out.println();
	 						break;
	 					}
	 					for(int i = 0 ; i < top; i++){
	 						if(!data[i].isFaceUp()){
	 							System.out.print("[XX]");
	 						}
	 						
	 						if(data[i].isFaceUp()){
	 								System.out.print(data[i].toString());
	 							}
	 							
	 						
	 					}
	 				
	 				
	 					System.out.print(data[top].toString());
	 					System.out.println();
	 						break;
	 		//for testing			
	 		case('m'): for(int i = 0; i < top; i++){
	 					System.out.print(data[i].toString());
	 		}
	 					break;
	
	 }
	 
	 
	}
	public static void main(String[] args) {

	}
	public class emptyListException extends Exception{
		public emptyListException(String message){
			super(message);
		}
	}

}
