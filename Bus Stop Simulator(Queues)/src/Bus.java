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


public class Bus {
	final static int NUM_BUS_STOPS = 8;
	static int capacity;
	private int type = 1;
	private int route = 0;
	
	private int timeToRest = 0;
	
	private int groupsServed = 0;
	private int curAmount;
	private int groupNumber;
	private int totalWait;
	private int groupServed=0;
	private String inRoute[]  = {"South P", "West", "SAC", "Chapin"};
	private String outRoute[] = {"South P", "PathMart", "Walmart", "Target"};
	private static PassengerQueue[] busStops = new PassengerQueue[NUM_BUS_STOPS];
	private int timeBetween = 30;
	private PassengerQueue storage = new PassengerQueue();
	public Bus(){
		/*
		 0 - In Route South P
	    1 - In Route West
	    2 - In Route SAC
	    3 - In Route Chapin
	    4 - Out Route South P
	    5 - Out Route PathMart
	    6 - Out Route Walmart
	    7 - Out Route Target 
		*/
		for(int i =0; i< NUM_BUS_STOPS; i++){
			busStops[i] = new PassengerQueue();
			if(i<4){
				busStops[i].setName(inRoute[i]);
			}
			else
				busStops[i].setName(outRoute[i-4]);
		}
	
	}
	
	public void setTimeToRest(int timeToRest){
		this.timeToRest=timeToRest;
	}
	public int getTimeToRest(){
		return timeToRest;
	}
	
	/**
	 * Adds passengers to an array of bus stops(passenger queues)
	 * @param busCap 
	 */
	public void addToQueue(Passenger p ,int dest, int busCap){
		
		if(p.getGroupNumber()+busStops[dest].size()<=busCap)
			busStops[dest].enqueue(p);
		
	}
	
	/**
	 * Creates a random amount of passengers in a group of passengers
	 * @return
	 */
	public int generatePassenger(int minGroupSize, int maxGroupSize){
		groupNumber = (int) (Math.random()*(maxGroupSize-minGroupSize)+minGroupSize);
		return groupNumber;
	}
	
	/**
	 * Sets the capacity of a bus
	 * @param capacity
	 */
	public void setCapacity(int capacity){
		Bus.capacity = capacity;
	}
	
	
	/**
	 * Loads the bus if the capacity is not full
	 * @param busStops
	 * @return
	 */
	
	public  PassengerQueue[] loadBus ( PassengerQueue[] busStops){
		PassengerQueue temp = new PassengerQueue();
		PassengerQueue newRoute = new PassengerQueue();
			if(busStops[route].toArray().length!=0){
			for(int i = 0; i<busStops[route].toArray().length;i++){
				temp.add(busStops[route].get(i));
			}
			
			for(int i = 0; i < temp.toArray().length;i++){
				if(busStops[route].toArray().length+curAmount<=capacity){
					storage.add(temp.get(i));
					groupServed+=temp.get(i).getGroupNumber();
					}
			}
			for(int i= 0; i < busStops[route].toArray().length;i++){
				if(busStops[route].get(i).getDestination()!=route){
					newRoute.add(busStops[route].get(i));
				}
			}
				busStops[route] = newRoute;
				for(int i =0; i< NUM_BUS_STOPS; i++){
					busStops[i] = new PassengerQueue();
					if(i<4){
						busStops[i].setName(inRoute[i]);
					}
					else
						busStops[i].setName(outRoute[i-4]);
				}
				
			}
			return busStops;
	}
	/**
	 * If the destination of a passenger matches the destination of the bus then the passenger is removed from the group
	 * @param dest
	 * @return the number of passsengers depleted from a bus
	 */
	public void unload(){
		PassengerQueue temp = new PassengerQueue();
		for(int i = 0; i<storage.toArray().length;i++){
			if(storage.get(i).getDestination()!=route){
				temp.add(storage.get(i));
			}
			else{
				groupsServed+=storage.get(i).getGroupNumber();
			}
		}
		if(temp.toArray().length>0){
			temp = storage;
		}
	}
	
	
	
	
	/**
	 * Sets the destination of the bus
	 * @param route
	 */
	public void setRoute(int route){
		
		this.route= route;
		
	}
	/**
	 * Returns the destination
	 * @return
	 */
	public int getRoute(){
		return route;
	}
	/**
	 * Sets the type of bus if 1 in route if 2 out route
	 * @param type
	 */
	public void setType(int type){
		this.type = type;
	}
	
	/**
	 * Returns the type of bus
	 * @return
	 */
	public int getType(){
		return type;
	}
	/**
	 * Sets the time between stops
	 * @param time
	 */
	public void setTimeBetween(int time){
		this.timeBetween= time;
	}
	/**
	 * Returns time betwen stops
	 * @return
	 */
	public int getTimeBetween(){
		return timeBetween;
	}
	/**
	 * Returns the amount of groups served
	 * @return
	 */
	public int groupServed(){
		return groupServed;
	}
	public static void main(String[] args) {
		Bus test = new Bus();
		test.setCapacity(30);
		Passenger P = new Passenger();
		P.setDestination(2);
		P.setGroupNumber(15);
		test.setRoute(1);
		Passenger z = new Passenger();
		z.setDestination(2);
		z.setGroupNumber(20);
		busStops[1].add(P);
		busStops[1].add(z);
		
	}

}
