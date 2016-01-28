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
public class Passenger {

	private int groupNumber = 1;
	private int destination = -1;
	private int arrivalTime = 0;
	private int waitTime = 0;
	private int location;
	
	public Passenger(){
		
	}
	
	/**
	 * Sets the amount of passengers in a group of passengers to one set by a user
	 * @param groupNumber an integer value that represents the amount of passengers in a group
	 * 
	 */
	public void setGroupNumber(int groupNumber){
		this.groupNumber = groupNumber;
	}
	/**
	 * Returns the amount of passengers in the group
	 * @return
	 */
	public int getGroupNumber(){
		return groupNumber;
	}
	
	/**
	 * Sets the destination of a group of passengers to one set by the user
	 * @param destination
	 */
	public void setDestination(int destination){
		this.destination= destination;
	}
	
	/**
	 * Returns the destination of a group of passengers
	 * @return
	 */
	public int getDestination(){
		return destination;
	}
	
	/**
	 * Sets the arrival time to one given by the user
	 * @param arrivalTime
	 */
	public void setArrivalTime(int arrivalTime){
		this.arrivalTime = arrivalTime;
	}
	
	/**
	 * Returns the arrival time of a group of passengers
	 * @return
	 */
	public int getArrivalTime(){
		return arrivalTime;
	}
	
	/**
	 * returns the amount of people in a passenger group as a string
	 */
	public String toString(){
		return groupNumber +"";
	}
	
	/**
	 * Sets the wait time to a value given by the prorgrams
	 * @param waitTime
	 */
	public void setWaitTime(int waitTime){
		this.waitTime = waitTime;
	}
	/**
	 * Returns the wait time
	 * @return
	 */
	public int getWaitTime(){
		return waitTime;
	}
	/**
	 * Sets the location from a randomly generate integer
	 * @param location
	 */
	public void setLocation(int location){
		this.location = location;
	}
	/**
	 * Returns the location
	 * @return
	 */
	public int getLocation(){
		return location;
	}
	public static void main(String[] args) {

	}

}
