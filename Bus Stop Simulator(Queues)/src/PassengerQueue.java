/**
 * Kwaku Owusu
 * 109181846
 * HW 4
 * CSE 214 Recitation 3
 * Recitation TA Sun Lin
 * Grading TA Ke Ma
 * @author Kwaku
 * 
 */

import java.util.LinkedList;



 


public class PassengerQueue extends LinkedList<Passenger> {
	private int content = 0;
	private int numberOfPeople = 0;
	private String name;
	public PassengerQueue (){
		
	}
	/**
	 * adds a passenger to the passenger queue
	 * @param p
	 */
	public void enqueue(Passenger p){
		numberOfPeople += p.getGroupNumber();
		add(p);
		content++;
	}
	
	/**
	 * Removes the top element of a queue
	 * @return
	 */
	public Passenger dequeue(){
		numberOfPeople-= peek().getGroupNumber();
		content--;
		return remove();
	}
	
	/**
	 * Returns the top element of a queue without removing it
	 */
	public Passenger peek(){
		if(isEmpty()){
			return null;
		}
		else
			return element();
	}
	/**
	 * Checks to see if the current queue is empty
	 */
	public boolean isEmpty(){
		if(content==0){
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Returns the Amount of People in a current queue
	 * @return 
	 */
	public int size(){
		
		if(isEmpty()){
			return 0;
		}
		
		else
			return numberOfPeople;
	}
	
	/**
	 * Sets the name of the passengerQue location e.g. the current bus stop (sac, west, etc)
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * returns the current bus stop name
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Returns the number of people lost
	 * @param num
	 */
	public void deject(int num){
		numberOfPeople = num ;
	}
	public static void main(String[]args){
		PassengerQueue a = new PassengerQueue();
		Passenger  test = new Passenger();
		Passenger  test2 = new Passenger();
		test2.setGroupNumber(3);
		a.enqueue(test);
		a.enqueue(test2);
		a.dequeue();
		System.out.print(a.size());
		/*Passenger q = a.dequeue();
		System.out.println(q.toString());
		System.out.println(a.size());
		System.out.println(a.isEmpty());
		*/
	}
	
}

