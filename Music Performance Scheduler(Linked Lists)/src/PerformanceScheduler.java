/**
 * Kwaku Owusu
 * 109181846
 * HW 2
 * CSE 214 Recitation 3
 * Recitation TA Sun Lin
 * Grading TA Ke Ma
 * @author Kwaku
 * 
 */

import java.util.Scanner;

 public class PerformanceScheduler{
	 static Scanner input = new Scanner(System.in);
	 
	 /**
	  * Handles the input by a user, recursively calls its self after a command is executed
	  * @param upChoice a character enter by the user
	  * @param newList a List of performances already created
	  * <dt><b>Precondition: A PerformanceList has been created and the user has entered a char</dt></b>
	  *  
	  */
	 public static  void menuManager(char upChoice, performanceList newList){
		 String prompt = "Choose an operation: ";
		
		 switch(upChoice){
		 	
		 	//add to end
		 	case ('A'): PerformanceNode newNode = new PerformanceNode();
		 	
		 				System.out.print("Enter the name of the performance: ");
		 				
		 				String performance = input.nextLine();
		 				newNode.setPerformanceName(performance);
		 				
		 				
		 				System.out.print("Enter the name of the lead performer: ");
		 				String lead = input.nextLine();
		 				newNode.setLeadPerformer(lead);
		 				
		 				System.out.print("Enter the total amount of participants: ");
		 				int participants = input.nextInt();
		 				newNode.setParticipants(participants);
		 				
		 				System.out.print("Enter the duration:");
		 				int duration = input.nextInt();
		 				newNode.setDuration(duration);
		 				
		 				newNode.setStartTime(duration);
		 				newList.addToEnd(newNode);
		 				
		 				
		 				System.out.println("Added " + newNode.getPerformanceName() + " to the end of the list." + "\n" );
		 			
		 				System.out.print(prompt);
		 				
		 				String choice = input.next();
		 				
		 				upChoice = choice.toUpperCase().charAt(0);
		 				 String garbage = input.nextLine();
		 				
		 				menuManager(upChoice,newList);
		 				break;
		 //move cursor backward				
		 case ('B'):try{		
			 				if(newList.moveCursorBackward() == true){
			 					System.out.println("Moved cursor backwards to position " + newList.getCursor().getPosition());
			 					
			 					menuManager('X', newList);
			 					break;
			 				}
			 				
		 				}catch(Exception ex){
		 					System.out.println("There is no performance behind this cursor or the list is empty!");
		 					menuManager('X',newList);
		 					break;
		 				}
		 //print cursor
		 case('C'):
			 
			 	String table = String.format("%s %-23s %-13s %15s %10s %10s", "Current no.","Performance Name","Lead Performer Name", "Participants", "Duration", "Start Time");
				//
		 		String base = "------------------------------------------------------------"
		 				+ "------------------------------------------";
				System.out.println(table);
				System.out.println(base);
			try {
				System.out.println(newList.getCursor().displayCurrentPerformance());
				menuManager('X',newList);
				break;
			} catch (Exception ex) {
				System.out.println("There is currently no cursor!");
				menuManager('X',newList);
				break;
			}
			
		 //display all 
		 case ('D'):	
			 table = String.format("%s %-23s %-13s %15s %10s %10s", "Current no.","Performance Name","Lead Performer Name", "Participants", "Duration", "Start Time");
			
		 		 base = "------------------------------------------------------------"
		 				+ "------------------------------------------";
		 		System.out.println(table);
				System.out.println(base);
				
		 		 System.out.print(newList.toString());
		  
		 		 menuManager('X',newList);
		 					
							break;
		 //move forwards
		 case ('F'):try{		
				if(newList.moveCursorForward() == true){
					System.out.println("Moved cursor forward to position " + newList.getCursor().getPosition());
					
					menuManager('X', newList);
					break;
				}
				
			}catch(Exception ex){
				System.out.println("There is no performance ahead of this cursor, or the list is empty!");
				
				menuManager('X',newList);
				break;
			}
			 
		 
		 //add after cursor		
		 case ('I'):try{
			 		
			 		newList.getCursor();
				 	newNode = new PerformanceNode();
				 	
					System.out.print("Enter the name of the performance: ");
					
					performance = input.nextLine();
					newNode.setPerformanceName(performance);
					
					
					System.out.print("Enter the name of the lead performer: ");
					lead = input.nextLine();
					newNode.setLeadPerformer(lead);
					
					System.out.print("Enter the total amount of participants: ");
					participants = input.nextInt();
					newNode.setParticipants(participants);
					
					System.out.print("Enter the duration:");
					duration = input.nextInt();
					newNode.setDuration(duration);
					
					newNode.setStartTime(duration);
					newList.addAfterCurrent(newNode);
					
					
					System.out.println("Added " + newNode.getPerformanceName() + " After cursor." + "\n" );
				
					System.out.print(prompt);
					
					choice = input.next();
					
					upChoice = choice.toUpperCase().charAt(0);
					garbage = input.nextLine();
					
					menuManager(upChoice,newList);
					break;
			 			
		 			}catch(Exception ex){
		 				System.out.println("There is currently no cursor!" + "\n");
		 				menuManager('X',newList);
		 				break;
		 			}
		 
		
				
		 case('J'): System.out.print("Enter the position: ");
		 			
		 			try{
		 				
			 		int pos = input.nextInt();
			 		
			 		if(pos==0){
			 			System.out.println("Enter a valid position");
			 			menuManager('J',newList);
			 			break;
			 		}
			 		
		 			newList.jumptoPosition(pos);
		 			System.out.println("Moved cursor to positon " + pos);
		 			menuManager('X', newList);
		 			break;
		 			}
		 			catch(Exception ex){
		 				menuManager('X', newList);
		 				break;
		 			}
		 			
		
		 
		 case('R'): try {
				newList.removeCurrentNode();
				System.out.println("Removed current node.");
				menuManager('X',newList);
				break;
			} catch (Exception e) {
	 			menuManager('X',newList);
	 			break;
			}
		 		
		 
		 case('X'): 
				
			 
			 		System.out.print(prompt);
					
		 		   choice = input.nextLine();
			
				   upChoice = choice.toUpperCase().charAt(0);
			
				   menuManager(upChoice,newList);
				   
				   break;
		 
		 case('Q'):System.out.println("Now Quiting");
		 		   break;
		 }
	 }
	
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		String menu = "A) Add to end" + "\n" + "B) Move current node backward" +"\n"
					  + "C) Display current node" + "\n"  + "D) Display all nodes" + "\n"
					  + "F) Move current node forward" + "\n" + "I) Insert after current node" + "\n"
					  + "J) Jump to position" + "\n"  + "R) Remove current node" + "\n"
					  +"Q) Exit" +"\n" ;
		String prompt = "Choose an operation: ";
		
		System.out.println(menu);
		System.out.print(prompt);
		
		String choice = input.next();
		
		char upChoice = choice.toUpperCase().charAt(0);
		
		performanceList newList = new performanceList();
		
		menuManager(upChoice,newList);
		
		}
}

 
 
 

 
 
 
 class PerformanceNode {
		private PerformanceNode link;
		private PerformanceNode nextLink;
		private PerformanceNode prevLink;
		private String performanceName = "";
		private String leadPerformer = "";
		private int participants = 0;
		private int duration = 0;
		private int startTime = 0;
		private int position = 1;
		
		/**
		 * Creates a default PerformanceNode object with blank parameters
		 */
		public PerformanceNode(){
			
			performanceName = "";
			leadPerformer = "";
			participants = 0;
			duration = 0;
			startTime = 0;
			
			
		}
		
		/**
		 * Creates a PerformanceNode with parameters set by the user 
		 * @param performanceName Name of the performance
		 * @param leadPerformer Name of the lead performer
		 * @param participants Number of participants
		 * @param duration Length of a performance
		 * @param startTime Time that a performance starts
		 */
		
		public PerformanceNode(String performanceName, String leadPerformer, int participants, int duration, int startTime){
			
			this.performanceName = performanceName;
			this.leadPerformer = leadPerformer;
			this.participants = participants;
			this.duration =duration;
			this.startTime = 0;
			
			
		}
		
		/**
		 * Returns the name of the node selected
		 * @return performanceName
		 */
		public String getPerformanceName(){
			return performanceName;
		}
		
		/**
		 * Changes the name of the performance to one set by the user
		 * @param performanceName
		 */
		public void setPerformanceName(String performanceName){
			this.performanceName = performanceName;
		}
		
		/**
		 * Returns the name of the lead performer
		 * @return leadPerformer 
		 */
		public String getLeadPerformer(){
			return leadPerformer;
		}
		
		/**
		 * Changes the name of the lead performer to one set by the user
		 * @param leadPerformer
		 */
		public void setLeadPerformer(String leadPerformer){
			this.leadPerformer= leadPerformer;
		}
		
		/**
		 * Returns the amount of participants in a performance
		 * @return participants
		 */
		public int getParticipants(){
			return participants;
		}
		
		/**
		 * Changes the amount of participants to a value set by the user
		 * @param participants
		 */
		
		public void setParticipants(int participants){
			this.participants = participants;
		}
		
		
		/**
		 * Returns the duration of a performance
		 * @return duration
		 */
		public int getDuration(){
			return duration;
		}
		
		/**
		 * Changes the duration of a performance to one set by the user
		 * @param duration
		 */
		public void setDuration(int duration){
			this.duration = duration;
		}
		
		/** 
		 * Returns the start time of a performance
		 * @return
		 */
		public int getStartTime(){
			return startTime;
		}
		
		/**
		 * Sets the start time of a performance
		 */
		public void setStartTime(int duration){
			this.startTime = duration;
		}
		
		/**
		 * Sets the reference to the next node of a list
		 * @param node
		 */
		public void setNext(PerformanceNode node){
			this.nextLink= node;
		}
		
		/**
		 * Returns the next node in the List
		 * @return nextLink
		 */
		public PerformanceNode getNext(){
			return nextLink;
			
		}
		
		/**
		 * Sets the reference to the previous node of a list
		 * @param node
		 */
		public void setPrev(PerformanceNode node){
			this.prevLink = node;
		}
		
		/**
		 * Returns the previous node of a node in a list
		 * @return
		 */
		public PerformanceNode getPrev(){
			return prevLink;
		}
		
		
		/** 
		 * Returns the position of a node
		 * @return the position
		 */
		public int getPosition(){
			return position;
		}
		/**
		 * When a node is added to the list the position is set to one greater than the previous node
		 * @return position
		 */
		public void setPosition(int position){
			this.position= position;
		}
		
		/**
		 * Prints the properties of the current cursor
		 * @param node
		 * @return curPos the components of the cursor
		 */
		public String displayCurrentPerformance(){
			String s = "";
			
			String performanceName = getPerformanceName();
			String leadPerformer = getLeadPerformer();
			int participants = getParticipants();
			int    duration  = getDuration();
			int    startTime = getStartTime();
			
			String curPos = getPosition() +"";
			curPos = String.format("%10s", curPos);
			curPos = "*" +curPos+ " ";
			s = String.format("%-25s %s %25d %10d %10d", performanceName, leadPerformer, participants, duration, startTime);			
			curPos +=s;
			return  curPos;
		}
			
	}





	class performanceList{
		private PerformanceNode head;
		private PerformanceNode tail;
		private PerformanceNode cursor;
		private int counter ;
		
		
		/**
		 * Creates a performance list with null values for head tail and cursor
		 */
		public performanceList(){
			head = null;
			tail = null;
			cursor = null;
			counter = 0;
		}
		
		/**
		 * Returns the amount of nodes in a list
		 * @return Counter
		 */
		public int getCounter(){
			return counter;
		}
		
		/**
		 * Checks to see if the list is empty
		 * @return
		 */
		public boolean isEmpty(){
			if (head== null)
				return true;
			else 
				return false;
			
		}
		/**
		 * If the list is empty the passed node becomes a head
		 * Otherwise the node is added to the end of the list
		 * @param newPerformance
		 */
		public void addToEnd(PerformanceNode newPerformance){
			PerformanceNode newNode= new PerformanceNode(newPerformance.getPerformanceName(),
					newPerformance.getLeadPerformer(),newPerformance.getParticipants(),
					newPerformance.getDuration(),newPerformance.getStartTime());
			//adds head
			if(isEmpty()){
				newNode.setStartTime(newNode.getDuration());
				newNode.setNext(head);
				head = tail=newNode;
				counter++;
				cursor = head;
			}
			
			else{
				
				newNode.setStartTime(tail.getStartTime()+newNode.getDuration());
				tail.setNext(newNode);
				
				newNode.setPrev(tail);
				
				
				
				tail = newNode;
				cursor = tail;
				
				cursor.setPosition(cursor.getPrev().getPosition() +1);
				counter++;
				tail = newNode;
				cursor = tail;
			}
			
			
			
		}
		
		/**
		 * Adds a new Performance after the cursor
		 * @param newPerformance
		 * <dt><b> Precondition: There is a list created, and the node has valid parameters</dt></b>
		 */
		public void addAfterCurrent(PerformanceNode newPerformance){
			
			if(cursor == tail){
				addToEnd(newPerformance);
			} 
			
			
			else{
				
				int addition = newPerformance.getStartTime();
				PerformanceNode newNode= new PerformanceNode(newPerformance.getPerformanceName(),
					newPerformance.getLeadPerformer(),newPerformance.getParticipants(),
					newPerformance.getDuration(),newPerformance.getStartTime());
			
			
					newNode.setStartTime(addition + cursor.getStartTime());
					newNode.setPosition(cursor.getPosition() + 1);
					
					newNode.setNext(cursor.getNext());
					cursor.getNext().setPrev(newNode);
					
					newNode.setPrev(cursor);
					cursor.setNext(newNode);
					counter++;
					
						cursor = newNode;
						while(cursor.getNext()!= null){
							cursor.getNext().setPosition(cursor.getPosition()+1);
							cursor.getNext().setStartTime(cursor.getNext().getStartTime()+ addition);
							
							cursor = cursor.getNext();
							
						}
					cursor = newNode;
			
			}
		}
		
		/**
		 * Removes a node at the cursor 
		 * @return true or false depending on if the cursor is in a valid position
		 * @throws nullCursorException 
		 */
		public boolean removeCurrentNode() throws nullCursorException{
			if(isEmpty()){
				throw new nullCursorException("The list is Empty!");
			}
			
			
			int removal = cursor.getStartTime()-cursor.getPrev().getStartTime();
			
			if(cursor == head||head.getNext()!=null){
				cursor = head;
				head = cursor.getNext();
				
				head.setPrev(null);
				cursor.setNext(null);
				counter--;
				head.setPosition(1);
				cursor = head;
				int count = 1;
					while (count<= counter){
						cursor = cursor.getNext();
						cursor.setPosition(cursor.getPrev().getPosition()+1);
						cursor.setStartTime(cursor.getStartTime()-removal);
						count++;
					}
					
					return true;
			}
			else if(cursor.getNext()==null){
				head = null;
				
				return true;
			}
			else if(cursor==tail){
				tail = tail.getPrev();
				tail.setNext(null);
				counter--;
				return true;
			}
			else{
				
				PerformanceNode prevNode = cursor.getPrev();
				cursor.getPrev().setNext(cursor.getNext());
				cursor.getNext().setPrev(cursor.getPrev());
				
				cursor.setNext(null);
				cursor.setPrev(null);
				cursor = prevNode;
				PerformanceNode storage = cursor;
				
				
				if(cursor!= tail){
					while(cursor.getNext()!=null){
						cursor = cursor.getNext();
						cursor.setStartTime(cursor.getStartTime()-removal);
						cursor.setPosition(cursor.getPosition()-1);
						
					}
				cursor = storage;
				
				 counter--;
				}
			}
			
			return true ;
			
			
		
		}
		
			
		/**
		 * Moves the cursor to the next node in a list
		 * @return true if there is another node after the current node
		 * @throws nullCursorException 
		 */
		public boolean moveCursorForward() throws nullCursorException{
			if(cursor == null|| cursor.getNext()==null){
			
				throw new nullCursorException("There is no current cursor");
				
			}
			
			else{
				cursor = cursor.getNext();
				return true;
			}
		
			
		}
		
		/**
		 * Moves the cursor to a previous node in a list
		 * @return true if there is another node behind the current node
		 * @throws nullCursorException 
		 */
		public boolean moveCursorBackward() throws nullCursorException{
			if(cursor == null||cursor.getPrev()==null){
				throw new nullCursorException("There is no current cursor");
			}
			
			
			
			else{
				cursor = cursor.getPrev();
				return true;
			}
		}
		
		/**
		 * Helper method to return the position of a node
		 * @return
		 */
		public String getPos(){
			String blank = "";
			String s  = "*";
			s = String.format("%-10s %-5s %d", blank, s, cursor.getPosition());
			return s;
		}
		
		/**
		 * Jumps the cursor to a position set by the user
		 * @param position
		 * @return true if the position is valid
		 * @throws nullCursorException 
		 */
		public boolean jumptoPosition(int position) throws nullCursorException{
			if(position > counter){
				throw new nullCursorException("Invalid position! ");
			}
			
			else{
				int temp = 1;
				if(position==1){
					cursor = head;
				}
				cursor = head;
				while(temp < position){
					cursor = cursor.getNext();
					temp++;
				}
				return true;
			}
		}
		
		/**
		 * Prints a table of all members of the Performance List
		 * @return The table
		 */
		public String toString(){
			
			PerformanceNode temp = cursor;
			
			int count = 1;
			String s = "";
			String storage ="";
			cursor =head;
			while(count<= counter){
				
				String performanceName = " " + cursor.getPerformanceName();
				String leadPerformer = cursor.getLeadPerformer();
				int participants = cursor.getParticipants();
				int    duration  = cursor.getDuration();
				int    startTime = cursor.getStartTime();
				
				
				String curPos = cursor.getPosition() +"";
				curPos = String.format("%10s", curPos);
				curPos = "*" +curPos+ " ";
				
				s = String.format("%-25s %s %25d %10d %10d", performanceName, leadPerformer, participants, duration, startTime);			
				s+= "\n";
				
				
				curPos += s;
				
				storage+= curPos;
				count++;
				
				
				cursor = cursor.getNext();
				
			}
			cursor = temp;
			return storage;
		}
		
		
		/**
		 * Returns the cursor
		 * @return cursor
		 * @throws nullCursorException 
		 */
		
		public PerformanceNode getCursor() throws nullCursorException{
			if(cursor == null){
				throw new nullCursorException("The list is currently empty!");
			}
			else;
			return cursor;
		}
		
		
		
	public class nullCursorException extends Exception{
			public nullCursorException(String message){
				super(message);
			}
		}	
	
	
	}


	
