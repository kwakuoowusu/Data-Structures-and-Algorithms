
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
public class CollectionManager {
	/**
	 * Handles the user input from the menu, uses appropriate methods to produce results
	 * @param response character entered by the user
	 * @param men the menu
	 * @param a collection a 
	 * @param b collection b
	 * <dt><b>Precondition: Two card collection have been created, 
	 * and a user response has been accepted.
	 */
	public static void menu(char response,String men,CardCollection a,CardCollection b){
		
		Scanner input = new Scanner(System.in);
		switch(response){
		case 'A': System.out.print( "Enter the Collection: ");
					String collectChoice = input.next();
					collectChoice = collectChoice.toUpperCase();
					char choice = collectChoice.charAt(0);
					
						if(choice =='A'){
							BaseballCard newCard = new BaseballCard();
							
							System.out.print("Enter the name:");
							String garbage = input.nextLine();
							String name = input.nextLine();
							newCard.setName(name);
							
							System.out.print("Enter the manufacturer:");
							String manufacturer = input.nextLine();
							newCard.setManufacturer(manufacturer);
							
							System.out.print("Enter the year: ");
							int year = input.nextInt();
							newCard.setYear(year);
							
							System.out.print("Enter the x dimension: ");
							int x = input.nextInt();
							newCard.setSizeX(x);
							
							System.out.print("Enter the y dimension: ");
							int y = input.nextInt();
							newCard.setSizeY(y);
							
							System.out.print("Enter the price: ");
							double price = input.nextDouble();
							newCard.setPrice(price);
							
							System.out.print("Enter the position: ");
							int pos = input.nextInt();
							try{
							a.addCard(newCard,pos);
							}catch(Exception ex){
								pos = input.nextInt();
								a.addCard(newCard,pos);
							}
							
							System.out.println("Added " +newCard.getName()+ " to Collection A");
							System.out.print(men);
							
						}
						if(choice =='B'){
							BaseballCard newCard = new BaseballCard();
							
							System.out.print("Enter the name:");
							String garbage = input.nextLine();
							String name = input.nextLine();
							newCard.setName(name);
							
							System.out.print("Enter the manufacturer:");
							String manufacturer = input.nextLine();
							newCard.setManufacturer(manufacturer);
							
							System.out.print("Enter the year: ");
							int year = input.nextInt();
							newCard.setYear(year);
							
							System.out.print("Enter the x dimension: ");
							int x = input.nextInt();
							newCard.setSizeX(x);
							
							System.out.print("Enter the y dimension: ");
							int y = input.nextInt();
							newCard.setSizeY(y);
							
							System.out.print("Enter the price: ");
							double price = input.nextDouble();
							newCard.setPrice(price);
							
							System.out.print("Enter the position: ");
							int pos = input.nextInt();
							try{
								b.addCard(newCard,pos);
								}catch(Exception ex){
									pos = input.nextInt();
									b.addCard(newCard,pos);
								}
							
							System.out.println("Added " +newCard.getName()+ " to Collection B" +"\n");
							System.out.print(men);
							
						}

					collectChoice = input.next();
					collectChoice = collectChoice.toUpperCase();
					choice = collectChoice.charAt(0);
					if(choice =='Q'){
						System.out.print("Now quitting ");
					break;
					}
					else{
						menu(choice,men,a,b);
						break;
					}
		case 'C': System.out.print("Enter the collection to copy from: ");
				   collectChoice = input.next();
				   collectChoice = collectChoice.toUpperCase();
				   choice = collectChoice.charAt(0);
				   if(choice=='A'){
				   		System.out.print("Enter the position of the card to copy from:");
				   		int pos = input.nextInt();
				   		System.out.print("Enter the collection to copy to:");
				   		   collectChoice = input.next();
						   collectChoice = collectChoice.toUpperCase();
						   choice = collectChoice.charAt(0);
						   if(choice=='A'){
							 BaseballCard clone = new BaseballCard();
							 clone = (BaseballCard) a.collection[pos].clone();
							 a.addCard(clone);
							 System.out.println("Copied " + a.collection[pos].getName() + "from"
							 		+ " Collection A to Collection A, position "+ a.size());
							 	System.out.print(men);
							 	collectChoice = input.next();
								collectChoice = collectChoice.toUpperCase();
								choice = collectChoice.charAt(0);
								if(choice =='Q'){
									System.out.print("Now quitting ");
								break;
								}
								else{
									menu(choice,men,a,b);
									break; 	
								}
						   }
						   if(choice=='B'){
							   BaseballCard clone = new BaseballCard();
								 clone = (BaseballCard) a.collection[pos].clone();
								 b.addCard(clone);
								 System.out.println("Copied " + a.collection[pos].getName() + "from"
								 		+ " Collection A to Collection B, position "+ b.size());
								 	System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
									if(choice =='Q'){
										System.out.print("Now quitting ");
									break;
									}
									else{
										menu(choice,men,a,b);
										break; 	
									}
							   }
				   }
				   
				   if(choice=='B'){
				   		System.out.println("Enter the position of the card to copy from:");
				   		int pos = input.nextInt();
				   		System.out.print("Enter the collection to copy to:");
				   		   collectChoice = input.next();
						   collectChoice = collectChoice.toUpperCase();
						   choice = collectChoice.charAt(0);
						   if(choice=='A'){
							   BaseballCard clone = new BaseballCard();
								 clone = (BaseballCard) b.collection[pos].clone();
								 a.addCard(clone);
								 System.out.println("Copied " + b.collection[pos].getName() + "from"
								 		+ " Collection B to Collection A, position "+ a.size());
								 	System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
									if(choice =='Q'){
										System.out.print("Now quitting ");
									break;
									}
									else{
										menu(choice,men,a,b);
										break; 	
									}
						   }
						   if(choice=='B'){
							   BaseballCard clone = new BaseballCard();
								 clone = (BaseballCard) b.collection[pos].clone();
								 b.addCard(clone);
								 System.out.println("Copied " + b.collection[pos].getName() + "from"
								 		+ " Collection B to Collection B, position "+ b.size());
								 	System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
									if(choice =='Q'){
										System.out.print("Now quitting ");
									break;
									}
									else{
										menu(choice,men,a,b);
										break; 	
									}
							   }
						   
						
				   }
		case 'E': 	System.out.print( "Enter the Collection: ");
					collectChoice = input.next();
					collectChoice = collectChoice.toUpperCase();
					choice = collectChoice.charAt(0);
				if(choice=='A')	{
					System.out.print("Enter the position: ");
					int pos = input.nextInt();
					System.out.print("Enter the new price: ");
					double price = input.nextDouble();
					a.collection[pos].setPrice(price);
					System.out.println("Price updated");
					
					
							System.out.print(men);
						 	collectChoice = input.next();
							collectChoice = collectChoice.toUpperCase();
							choice = collectChoice.charAt(0);
								if(choice =='Q'){
									System.out.print("Now quitting ");
								break;
								}
								else{
									menu(choice,men,a,b);
									break; 	
								}
				}
				
				if(choice=='B')	{
						System.out.print("Enter the position: ");
						int pos = input.nextInt();
						System.out.print("Enter the new price: ");
						double price = input.nextDouble();
						a.collection[pos].setPrice(price);
						System.out.println("Price updated");
							
						
							System.out.print(men);
						 	collectChoice = input.next();
							collectChoice = collectChoice.toUpperCase();
							choice = collectChoice.charAt(0);
								if(choice =='Q'){
									System.out.print("Now quitting ");
								break;
								}
								else{
									menu(choice,men,a,b);
									break; 	
								}
				}
				
		case 'G': System.out.print( "Enter the Collection: ");
					collectChoice = input.next();
					collectChoice = collectChoice.toUpperCase();
					choice = collectChoice.charAt(0);
					
					if(choice== 'A'){
						
						System.out.print("Enter the position: ");
						try{
							int pos = input.nextInt();
							System.out.println("Collection A:");
							System.out.print(a.toString(pos));
							

									System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
											if(choice =='Q'){
												System.out.print("Now quitting ");
											break;
											}
											else{
												menu(choice,men,a,b);
												break; 	
											}
							
						}catch(Exception ex){
							System.out.print("Please input a proper position: ");
							int pos = input.nextInt();
						}
						
					}

					
					if(choice== 'B'){
						
						System.out.print("Enter the position: ");
						try{
							int pos = input.nextInt();
							System.out.println("Collection B:");
							System.out.print(b.toString(pos));
							

									System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
											if(choice =='Q'){
												System.out.print("Now quitting ");
											break;
											}
											else{
												menu(choice,men,a,b);
												break; 	
											}
							
						}catch(Exception ex){
							System.out.print("Please input a proper position: ");
							int pos = input.nextInt();
							System.out.print(b.toString(pos));
							

							System.out.print(men);
						 	collectChoice = input.next();
							collectChoice = collectChoice.toUpperCase();
							choice = collectChoice.charAt(0);
									if(choice =='Q'){
										System.out.print("Now quitting ");
									break;
									}
									else{
										menu(choice,men,a,b);
										break; 	
									}
						}
						
					}
					
		case 'L':	 BaseballCard newCard = new BaseballCard();
					 System.out.print("Enter the name:");
					 
					 String checkName = input.nextLine();
					 newCard.setName(checkName);
		
					 System.out.print("Enter the manufacturer:");
					 String manufacturer = input.nextLine();
					 newCard.setManufacturer(manufacturer);
		
					 System.out.print("Enter the year: ");
					 int year = input.nextInt();
					 newCard.setYear(year);
		
					 System.out.print("Enter the x dimension: ");
					 int x = input.nextInt();
					 newCard.setSizeX(x);
		
					 System.out.print("Enter the y dimension: ");
					 int y = input.nextInt();
					 newCard.setSizeY(y);
		
					 System.out.print("Enter the price: ");
					 double price = input.nextDouble();
					 newCard.setPrice(price);
					 
					 if(a.exists(newCard)){
						 System.out.print("This card exists in Collection A."); 
					 }
					 if(!(a.exists(newCard))){
						 System.out.print("This card does not exist in Collection A.");
					 }
					 if(b.exists(newCard)){
						 System.out.print(" This card exists in Collection B." +"\n");
					 }
					 if(!(b.exists(newCard))){
						 System.out.print(" This card does not exist in Collection B." +"\n");
					 }
					 
					 
					 System.out.print(men);
					 	collectChoice = input.next();
						collectChoice = collectChoice.toUpperCase();
						choice = collectChoice.charAt(0);
								if(choice =='Q'){
									System.out.print("Now quitting ");
								break;
								}
								else{
									menu(choice,men,a,b);
									break; 	
								}
				 
		
		case 'N': System.out.print("Enter the collection:");
					collectChoice = input.next();
					collectChoice = collectChoice.toUpperCase();
					choice = collectChoice.charAt(0);
					
					if(choice== 'A'){
						
						System.out.print("Enter the position: ");
						try{
							int pos = input.nextInt();
								System.out.print("Enter the name to update to:");
								String name = input.next();
								a.collection[pos].setName(name); 
								System.out.println("Changed name to: " + a.collection[pos].getName());
								
									System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
											if(choice =='Q'){
												System.out.print("Now quitting ");
											break;
											}
											else{
												menu(choice,men,a,b);
												break; 	
											}
						}catch(Exception ex){
							System.out.print("Please enter a proper position");
							int pos = input.nextInt();
							System.out.print("Enter the name to update to:");
							String name = input.next();
							a.collection[pos].setName(name); 
							System.out.println("Changed name to: " + a.collection[pos].getName());
							
							
									System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
											if(choice =='Q'){
												System.out.print("Now quitting ");
											break;
											}
											else{
												menu(choice,men,a,b);
												break; 	
											}
						}
					}
					
						if(choice== 'B'){
						
						System.out.print("Enter the position: ");
						try{
							int pos = input.nextInt();
								System.out.print("Enter the name to update to:");
								String name = input.next();
								b.collection[pos].setName(name); 
								System.out.println("Changed name to: " + b.collection[pos].getName());
								
									System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
											if(choice =='Q'){
												System.out.print("Now quitting ");
											break;
											}
											else{
												menu(choice,men,a,b);
												break; 	
											}
						}catch(Exception ex){
							System.out.print("Please enter a proper position");
							int pos = input.nextInt();
							System.out.print("Enter the name to update to:");
							String name = input.next();
							a.collection[pos].setName(name); 
							System.out.println("Changed name to: " + a.collection[pos].getName());
							
							
									System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
											if(choice =='Q'){
												System.out.print("Now quitting ");
											break;
											}
											else{
												menu(choice,men,a,b);
												break; 	
											}
						}
					}
				  	
					
				     
		
		case 'P': System.out.println("Collection A:"+"\n");
				  a.printAllCards();
				  System.out.print("\n");
				  System.out.println("Collection B:" +"\n");
				  b.printAllCards();
				  

					System.out.print(men);
				 	collectChoice = input.next();
					collectChoice = collectChoice.toUpperCase();
					choice = collectChoice.charAt(0);
							if(choice =='Q'){
								System.out.print("Now quitting ");
							break;
							}
							else{
								menu(choice,men,a,b);
								break; 	
							}
		
		case 'R': System.out.print("Enter the collection to remove from:");
					collectChoice = input.next();
					collectChoice = collectChoice.toUpperCase();
					choice = collectChoice.charAt(0);
					if(choice=='A'){
						System.out.print("Enter the position of the card to remove: ");
						
						int pos = input.nextInt();
							try{ a.removeCard(pos);
								System.out.print("Card removed");
								System.out.println(men);
							 	collectChoice = input.next();
								collectChoice = collectChoice.toUpperCase();
								choice = collectChoice.charAt(0);
										if(choice =='Q'){
											System.out.print("Now quitting ");
										break;
										}
										else{
											menu(choice,men,a,b);
											break; 	
										}
							}catch(Exception ex){
								System.out.print("Please enter a valid position:");
								 pos = input.nextInt();
								 a.removeCard(pos);
								 System.out.println("Card removed");


								 System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
											if(choice =='Q'){
												System.out.print("Now quitting ");
											break;
											}
											else{
												menu(choice,men,a,b);
												break; 	
											}
							}
					}
					if(choice=='B'){
						System.out.print("Enter the position of the card to remove");
						
						int pos = input.nextInt();
							try{ b.removeCard(pos);
								System.out.print("Card removed");
								

								 System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
											if(choice =='Q'){
												System.out.print("Now quitting ");
											break;
											}
											else{
												menu(choice,men,a,b);
												break; 	
											}
							
							}catch(Exception ex){
								System.out.print("Please enter a valid position:");
								 pos = input.nextInt();
								 b.removeCard(pos);
								 System.out.println("Card removed");
							}

								 System.out.print(men);
								 	collectChoice = input.next();
									collectChoice = collectChoice.toUpperCase();
									choice = collectChoice.charAt(0);
											if(choice =='Q'){
												System.out.print("Now quitting ");
											break;
											}
											else{
												menu(choice,men,a,b);
												break; 	
											}
							}
					
				  
	
		case 'S': System.out.println("Size of collection A: " +a.size());
				  System.out.println("Size of collection B: " + b.size());
				  break;
				  
				  
		case 'T': System.out.print("Enter the position of the card "
				+ "to trade in position A: ");
						
					int posA = input.nextInt();
					
					 System.out.print("Enter the position of the card "
								+ "to trade in position B: ");
					 int posB = input.nextInt();
					 
					try{
						a.trade(b, posA, posB);
						System.out.print("Traded " + a.collection[posA].getName() +
										 ", Score " + a.collection[posA].getYear() +", " +
										 a.collection[posA].getSizeX() + "x" 
										 +a.collection[posA].getSizeY() +" for"
										 +  b.collection[posB].getName() +
										 ", Score " + b.collection[posB].getYear() +", " +
										 b.collection[posB].getSizeX() + "x" 
										 +b.collection[posB].getSizeY() );
						
							System.out.print(men);
						 	collectChoice = input.next();
							collectChoice = collectChoice.toUpperCase();
							choice = collectChoice.charAt(0);
									if(choice =='Q'){
										System.out.print("Now quitting ");
									break;
									}
									else{
										menu(choice,men,a,b);
										break; 	
									}
					}catch(Exception ex){
						System.out.print("Please Enter Valid Positions:");
						  posA = input.nextInt();
						
						 System.out.print("Enter the position of the card "
									+ "to trade in position B: ");
						  posB = input.nextInt();
						  a.trade(b, posA, posB);
						  System.out.println("Traded " + a.collection[posA].getName() +
									 ", Score " + a.collection[posA].getYear() +", " +
									 a.collection[posA].getSizeX() + "x" 
									 +a.collection[posA].getSizeY() +" for"
									 +  b.collection[posB].getName() +
									 ", Score " + b.collection[posB].getYear() +", " +
									 b.collection[posB].getSizeX() + "x" 
									 +b.collection[posB].getSizeY() );
						  System.out.print(men);
						 	collectChoice = input.next();
							collectChoice = collectChoice.toUpperCase();
							choice = collectChoice.charAt(0);
									if(choice =='Q'){
										System.out.print("Now quitting ");
									break;
									}
									else{
										menu(choice,men,a,b);
										break; 	
									}
					}
				 
			
					
		
		case 'V': System.out.println("The value of collection A is: " + a.value());
				  System.out.println("The value of collection B is: " + b.value());
				  	
				  	System.out.print(men);
				 	collectChoice = input.next();
					collectChoice = collectChoice.toUpperCase();
					choice = collectChoice.charAt(0);
							if(choice =='Q'){
								System.out.print("Now quitting ");
							break;
							}
							else{
								menu(choice,men,a,b);
								break; 	
							}
					
		
		case 'Q': System.out.print("Now quitting");
					break;
		
		}
	
		}
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		CardCollection a = new CardCollection();
		CardCollection b = new CardCollection();
		
		
		String s = "Main Menu: " + "\n" + "\n" 
				+"A) Add Card" +"\n" + "C) Copy" +"\n"
				+"E) Update Price" +"\n"
				+"G) Get Card" +"\n" + "L) Locate Card" + "\n"
				+"N) Update Name" +"\n" +"P) Print All Cards" +"\n"
				+"R) Remove Cards" +"\n" + "S) Size" + "\n"
				+"T) Trade" + "\n" + "V) Value of Collection" +"\n"
				+"Q) Quit" +"\n" +"\n" +"Select an operation: " ;
		System.out.print(s);
		
		String respond = input.next();
		respond = respond.toUpperCase();	
		char response1 = respond.charAt(0);
		menu(response1,s,a,b);
		
			}
	
	
}
