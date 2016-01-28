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

import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

public class Stackotaire {

	/** 
	 * Displays the game board, called every time the user inputs
	 * <dt><b> Precondition: There is a CardStack initialized
	 * @param storage an array of CardStacks for easy access 
	 */
	public static void displayBoard(CardStack[]storage){
		storage[0].printStack('f');
		storage[1].printStack('f');
		storage[2].printStack('f');
		storage[3].printStack('f');
		
		System.out.print("   ");
		System.out.print("W1");
		if(!storage[4].isEmpty()){
		storage[4].peek().setFaceUP(true);
		}
		storage[4].printStack('w');
		System.out.print("   ");
		
		
		storage[5].printStack('s');
		System.out.print( "  " + storage[5].size());
		
		System.out.println();
		System.out.println();
		
		
		System.out.print("T1  ");
		if(!storage[6].isEmpty()){
			storage[6].peek().setFaceUP(true);
		}
		storage[6].printStack('t');
		
		System.out.print("T2  ");
		if(!storage[7].isEmpty()){
			storage[7].peek().setFaceUP(true);
		}
		storage[7].printStack('t');
		
		System.out.print("T3  ");
		if(!storage[8].isEmpty()){
			storage[8].peek().setFaceUP(true);
		}
		storage[8].printStack('t');

		System.out.print("T4  ");
		if(!storage[9].isEmpty()){
			storage[9].peek().setFaceUP(true);
		}
		storage[9].printStack('t');
		
		System.out.print("T5  ");
		if(!storage[10].isEmpty()){
			storage[10].peek().setFaceUP(true);
		}
		storage[10].printStack('t');
		
		System.out.print("T6  ");
		if(!storage[11].isEmpty()){
			storage[11].peek().setFaceUP(true);
		}
		storage[11].printStack('t');
		
		System.out.print("T7  ");
		if(!storage[12].isEmpty()){
			storage[12].peek().setFaceUP(true);
		}
		storage[12].printStack('t');
		
		System.out.println("\n");
		if(checkWin(storage)==true){
			
			test();
			return;
		}
		System.out.print("Enter command:");
		
	}

	/**
	 * Creates a deck of 52 cards
	 * @return  a cardStack with 52 cards in order
	 */
	public static CardStack deckCreate(){
		CardStack mainStack = new CardStack('m');
		
		int counter = 1;
		for(int i = 1; i<=4;i++){
			
			
			
				for(int j = 1; j< 14; j++){
					
					Card newCard = new Card();
					newCard.setSuit(i);
					newCard.setValue(counter);
					
					if(j %2 == 0){
						newCard.setRed(true);
					}
					
					mainStack.push(newCard);
					 counter++;
					if(counter==14){
						counter = 1;
					}
				}
			
			
		}
		
		return mainStack;
		
	}
	
	/**
	 * Checks to see if a user has completed the game
	 * If all foundations are full the user wins
	 * @param storage
	 */
	public static boolean checkWin(CardStack [] storage){
		if(storage[0].size() == 13 && storage[1].size() == 13
				&& storage[2].size() == 13 && storage[3].size() == 13){
		
		return true;
		}
		else
			return false;
	
		
	}
	
	public static void test(){
		System.out.println("You win! Congratualtions!");
		System.out.print("Would you like to play again?(Y/N):");
		Scanner input = new Scanner(System.in);
		String response = input.nextLine();
		response = response.toUpperCase();
		if(response.charAt(0)=='Y'){
			System.out.println("Restarting..");
			CardStack [] storage = restart();
			displayBoard(storage);
			inputHandler(storage);
			return;
		}
		else
			System.out.println("Quitting now");
			System.exit(0);
	}
	
	/**
	 * Shuffles a deck of cards
	 * @param newStack
	 */
	public static void shuffle(CardStack newStack){
		Collections.shuffle(Arrays.asList(newStack.data));
	}
	
	
	public static CardStack[] restart(){
		CardStack mainStack= deckCreate();
		shuffle(mainStack);
		
		CardStack f1 = new CardStack('f'); 
		f1.setName("F1");
		
		CardStack f2 = new CardStack('f');
		f2.setName("F2");
		
		CardStack f3 = new CardStack('f');
		f3.setName("F3");
		
		CardStack f4 = new CardStack('f');
		f4.setName("F4");
		
		CardStack waste = new CardStack('w');
		waste.setName("W1");
		
		CardStack stock = new CardStack('s');
		stock.setName("S");
		
		 CardStack t1 = new CardStack('t');
		 t1.setName("T1");
		 
		 CardStack t2 = new CardStack('t');
		 t2.setName("T2");
		 
		 CardStack t3 = new CardStack('t');
		 t3.setName("T3");
		 
		 CardStack t4 = new CardStack('t');
		 t4.setName("T4");
		 
		 CardStack t5 = new CardStack('t');
		 t5.setName("T5");
		 
		 CardStack t6 = new CardStack('t');
		 t6.setName("T6");
		 
		 CardStack t7 = new CardStack('t');
		 t7.setName("T7");
		 
		 f1.setFoundation("F1");
		 f2.setFoundation("F2");
		 f3.setFoundation("F3");
		 f4.setFoundation("F4");
		 
		CardStack[] storage = {f1, f2, f3, f4, waste, stock , t1, t2, t3, t4, t5, t6,t7};
		 //4 = waste, 5 = stock
		 storage[6].push(mainStack.pop());
		 storage[6].peek().setFaceUP(true);
		 
		 for(int i = 0; i < 2; i++){
			 storage[7].push(mainStack.pop());
			 
		 }
		 storage[7].peek().setFaceUP(true);
		 
		 for(int i = 0; i < 3; i++){
			storage[8].push(mainStack.pop());
		 }
		 storage[8].peek().setFaceUP(true);
		 
		 for(int i = 0; i < 4; i++){
			 storage[9].push(mainStack.pop());
		 }
		 storage[9].peek().setFaceUP(true);
		 
		 for(int i = 0; i < 5; i++){
			 storage[10].push(mainStack.pop());
		 }
		 storage[10].peek().setFaceUP(true);
		 
		 for(int i = 0; i < 6; i++){
			 storage[11].push(mainStack.pop());
		 }
		 storage[11].peek().setFaceUP(true);
		
		 for(int i = 0; i < 7; i++){
			 storage[12].push(mainStack.pop());
		 }
		 storage[11].peek().setFaceUP(true);
		 
		 int temp = mainStack.size();
		 
		 for(int i = 0; i<temp; i++){
			storage[5].push(mainStack.pop());
			storage[5].peek().setFaceUP(true);
		 }
		 
		 return storage;
	}
	
	/**
	 * Handles the user inputs and appropriately puts them into the correct move manager
	 * <dt><b>Precondition: there is an array of card stacks created<dt> <b>
	 * @param Storage an array of cardstack for easy transport
	 */
	public static void inputHandler(CardStack[] Storage){
			Scanner input = new Scanner(System.in);
			
			String command = input.nextLine();
			
			command = command.toUpperCase();
			
			if(command.length()>4){
				if(command.substring(0,5).equals("MOVEN")){
					
					String arg1 = command.substring(6, 8);
					String arg2 = command.substring(9,11);
					int iteration = Integer.parseInt(command.substring(12,13));
					
					try {
						nMoveManager(Storage, arg1, arg2, iteration);
					} catch (Exception e) {
						System.out.println("Invalid Input");
						displayBoard(Storage);
						inputHandler(Storage);
						
					}
					
					
				}
				if(command.substring(0,6).equals("MOVE F")||command.substring(0,6).equals("MOVE T")){
					String arg1 = command.substring(5,7);
					String arg2 = command.substring(8,10);
					
					
					try {
						tfMoveManager(arg1,arg2,Storage);
					} catch (Exception e) {
						System.out.println("Invalid input");
						displayBoard(Storage);
						inputHandler(Storage);
						
					}
				
					return;
				}
				if(command.substring(0,7).equals("MOVE W1")){
					try {
						wMoveManager(command, Storage);
					} catch (Exception e) {
						System.out.println("Invalid Input ");
						displayBoard(Storage);
						inputHandler(Storage);
					}
					return;
			}
			}
			
			
			switch(command){
				
			case("DRAW"):{
				if(Storage[4].size()==0&&Storage[5].size()==0){
					System.out.println("You can not draw anymore");
					displayBoard(Storage);
					displayBoard(Storage);
					break;
				}
				if(Storage[5].size()==0){
					int temp = Storage[4].size();
					for(int i = 0; i <temp;i++){
						Storage[5].push(Storage[4].pop());
						
					}
					displayBoard(Storage);
					inputHandler(Storage);
					break;
				}
				Storage[4].push(Storage[5].pop());
				displayBoard(Storage);
				inputHandler(Storage);
				break;
			}
			
			case("RESTART"):{
				System.out.print("Do you really want to restart? Y/N: ");
				String yn = input.nextLine();
				yn = yn.toUpperCase();
				
				if(yn.charAt(0)=='Y'){
				System.out.println("Restarting..");
				System.out.println();
				Storage = restart();
				displayBoard(Storage);
				inputHandler(Storage);
				break;
				}
				
				if(yn.charAt(0)=='N'){
					displayBoard(Storage);
					inputHandler(Storage);
					break;
				}
			}
			
			case("QUIT"):{
				Lose();
				
			}
		
		
			
			}
				
	 
		
	}
	/**
	 * Prints the lose message
	 */
	public static void Lose(){
		System.out.print("You lose");
		System.exit(0);
		
	}
	/**
	 * Handles moving a card from the w1 stack to either the f1-4 stacks or t1-7 stacks
	 * @param move
	 * @param storage
	 * @throws invalidInputException if any command is wrong the user is returned back to the inputHandler to re enter a command
	 */
	public static void wMoveManager(String move,CardStack[]storage) throws  invalidInputException{
		//if(move.substring(0,4).equals("MOVE")){
			
		//String arg1 = move.substring(5, 7).toUpperCase();
		String arg2 = move.substring(8, 10).toUpperCase();
		if(arg2.substring(0,1).equals("F")){
			for(int i = 0; i < 4; i++){
				 if(storage[i].getName().equals(arg2)&& storage[i].size() == 0 && storage[4].peek().getType()==1){
					 storage[i].push(storage[4].pop());
					 displayBoard(storage);
					 inputHandler(storage);
					 break;
				 }
				 if(storage[i].getName().equals(arg2)&& storage[i].size() != 13){
					 
					 if(storage[i].peek().getSuit()==storage[4].peek().getSuit()){
						 if(storage[i].peek().getType()==storage[4].peek().getType()-1){
					 
							 storage[i].push(storage[4].pop());
							 displayBoard(storage);
							 inputHandler(storage);
							 break;
						 }
					 }
				 }
			}
		}
		
		
		
		 if(arg2.substring(0,1).equals("T")){
			for(int i = 0 ; i< 13 ;i++){

				if (storage[i].getName().equals(arg2)){
					if(storage[i].isEmpty()){
						if(storage[4].peek().getType()==13){
							storage[i].push(storage[4].pop());
							displayBoard(storage);
							inputHandler(storage);
							break;
						}
					}
				
				
				if(storage[i].peek().getType() == storage[4].peek().getType()+1){
						if( storage[i].peek().isRed()==true&&  storage[4].peek().isRed()==false){
							storage[i].push(storage[4].pop());
							displayBoard(storage);
							inputHandler(storage);
							break;
							
						}
					
						if(storage[i].peek().isRed()==false&& storage[4].peek().isRed()==true){
							
							storage[i].push(storage[4].pop());
							displayBoard(storage);
							inputHandler(storage);
							break;
							
						}
						
					}
				
				}
					
			}
			
		}
		 else throw new invalidInputException("invalid input");	
	}
		

		
	

	
	/**
	 * Handles moving from either across the f1-f4 stacks and t1-t7 stacks
	 * @param arg1 the location of the card to be moved
	 * @param arg2 the location to move the card
	 * @param storage an array of CardStacks created by the program
	 * @throws invalidInputException 
	 */
	public static void tfMoveManager(String arg1, String arg2, CardStack[] storage) throws invalidInputException{
		
		char location1 = arg1.charAt(0);
		char location2 = arg2.charAt(0);
		if(location1=='W'||location2=='W'){
			throw new invalidInputException("Invalid input");
		}
		switch(location1){
		// to do TT move a card over 
			case('T'):
				
				switch(location2){
					case('T'):
						//check if the value in arg1 is a king a checks if arg2 is empty then push
							for(int i = 0; i <13; i++ ){
								if(storage[i].getName().equals(arg1)){
									for(int j = 0; j < 13; j++){
										if(storage[i].peek().getType()==13){
											if(storage[j].getName().equals(arg2)){
												if(storage[j].isEmpty()){
													storage[j].push(storage[i].pop());
													displayBoard(storage);
													inputHandler(storage);
													break;
												}
											}
										}
								//checks to see if the value in arg1  is red and is sequential if it arg1
									if(storage[j].getName().equals(arg2)){
											if(storage[i].peek().getType()==storage[j].peek().getType()-1){
												if(storage[i].peek().isRed()==true&&storage[j].peek().isRed()==false){
													storage[j].push(storage[i].pop());
													displayBoard(storage);
													inputHandler(storage);
													break;
												}
												
												if(storage[i].peek().isRed()==false&&storage[j].peek().isRed()==true){
													storage[j].push(storage[i].pop());
													displayBoard(storage);
													inputHandler(storage);
													break;
													
												}
											}
												else throw new invalidInputException("Invalid input "+ "\n");
											}
										}
									}
								
								}
				
				case('F'):
							for(int i = 0; i < 13; i++){
								if(storage[i].getName().equals(arg1)){
									for(int j= 0; j < 13; j++){
										if(storage[j].getName().equals(arg2)){
											
											if(storage[j].isEmpty() && storage[i].peek().getType()==1){
												storage[j].push(storage[i].pop());
												displayBoard(storage);
												inputHandler(storage);
												break;
												
											}
											
											//checks to see if the value in the tableau is one less than foundation before pushing
											if(storage[j].isEmpty()){
												throw new invalidInputException(null);
											}
											if(storage[i].peek().getType() == storage[j].peek().getType() +1){
												if(storage[i].peek().getSuit()==storage[j].peek().getSuit()){
													storage[j].push(storage[i].pop());
													displayBoard(storage);
													inputHandler(storage);
													break;
													
												}
												else throw new invalidInputException(null);
											}
										}
									
									}
								
								}
						}
				break;
					
		}
				
						
			
		case('F'):
				switch(location2){
					case('T'):{
							for(int i = 0 ; i <13; i++){
								if(storage[i].getName().equals(arg1)){
									for(int j = 0; j <13; j++){
										if(storage[j].getName().equals(arg2)){
											if(storage[i].peek().isRed()==true&&storage[j].peek().isRed()==false&&storage[i].peek().getType()==storage[j].peek().getType()-1){
												storage[j].push(storage[i].pop());
												displayBoard(storage);
												inputHandler(storage);
												break;
											}
											if(storage[i].peek().isRed()==false&&storage[j].peek().isRed()==true&&storage[i].peek().getType()==storage[j].peek().getType()-1){
												storage[j].push(storage[i].pop());
												displayBoard(storage);
												inputHandler(storage);
												break;
											}
										}
									}
								
								}
							
							}
						break;
						}
				}
			
			}
			
		}
		
	/**
	 * Handles the moveN command inputed by the user
	 * @param storage an array of card stacks created by the user
	 * @param arg1 the location of cards to be moved
	 * @param arg2 the location of cards to be moved to
	 * @param iteration the amount of cards to be removed from the first stack
	 * @throws invalidInputException
	 */
	public static void nMoveManager(CardStack[] storage, String arg1,String arg2, int iteration) throws invalidInputException{
		if(iteration==1||arg1.equals(arg2)){
			throw new invalidInputException("Invalid input");
		}
		if(arg1.charAt(0)=='T'&&arg2.charAt(0)=='T'){
			CardStack temp = new CardStack('f');
			for(int i = 0 ; i< 13; i++){
				if(storage[i].getName().equals(arg1)){
					for(int j = 0; j< 13;j++){
						if(storage[j].getName().equals(arg2)){
							if(storage[i].peek().isFaceUp()){
								CardStack temp2 = new CardStack('f');
								temp2.push(storage[i].pop());
							  if(storage[i].isEmpty()==false&&storage[i].peek().isFaceUp()==true){
								  storage[i].push(temp2.pop());
								for(int iter= 0; iter <iteration; iter++){
									temp.push(storage[i].pop());
									}
							  }
							  else {
								  storage[i].push(temp2.pop());
								  throw new invalidInputException(null);
							  }
							}
							
						
					
					if(!temp.isEmpty()){
						//Handle king
						if(storage[j].isEmpty()&&temp.peek().getType()==13){
							for(int k = 0; k < iteration; k++){
								storage[j].push(temp.pop());
								
							}
							displayBoard(storage);
							inputHandler(storage);
						}
					if(storage[j].peek().getType()==temp.peek().getType()+1){
						if(storage[j].peek().isRed()==true &&temp.peek().isRed()==false){
							
								for(int k = 0; k < iteration; k++){
									temp.peek().setFaceUP(true);
									storage[j].push(temp.pop());
									
								}
								displayBoard(storage);
								inputHandler(storage);
							}
						
						
						if(storage[j].peek().isRed()==false&&temp.peek().isRed()==true){
							if(storage[j].peek().getType()==temp.peek().getType()+1){
								for(int k = 0; k < iteration; k++){
									temp.peek().setFaceUP(true);
									storage[j].push(temp.pop());
									
								}
								displayBoard(storage);
								inputHandler(storage);
							}
						}
					}
					else{
						CardStack temp2 = new CardStack('f');
						for(int k = 0 ; k< iteration; k++){
							temp2.push(temp.pop());
							storage[i].push(temp2.pop());
								
						}
						throw new invalidInputException(null);
						}
					  }
				     }
				}
			}
			}
		}
		else
			throw new invalidInputException("Invalid input");
	}
	
	public static void main(String[]args){
		
		CardStack[] storage = restart();
		
		
	
		 displayBoard(storage);
		
		 
		 inputHandler(storage);
		
			
		
		
		
		
		

	}	
	
	
	public static class invalidInputException extends Exception{
		String message = "Invalid input!";
		/**
		 * If the user enters any wrong input this exception will be called
		 * the user is then redirected back to the inputHandler method in order to 
		 * put in correct inputs
		 * @author Kwaku
		 *
		 */
		public invalidInputException(String message){
			super(message);
		}
		
	}
	
}

