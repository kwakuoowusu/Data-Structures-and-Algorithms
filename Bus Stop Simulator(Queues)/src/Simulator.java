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
import java.util.Scanner;
public class Simulator {
	private  int numInBusses;
	private int numOutBusses;
	private  int minGroupSize;
	private  int maxGroupSize;
	private  double arrivalProb;
	private int arrivalTime;
	private  int duration;
	private int timeElapsed;
	private  int groupsServed=0;
	private int totalTimeWaited=0;
	private int busCap = 1;
	private int location;
	private String inRoute[]  = {"South P", "West", "SAC", "Chapin"};
	private String outRoute[] = {"South P", "PathMart", "Walmart", "Target"};
	
	private static  final int NUM_BUS_STOPS = 8;
	/**
	 * Sets the number of in route busses to one set by the user
	 * @param numInBusses
	 * @throws invalidInputException if the value of in route busses is less than 1
	 */
	public  void setNumInBusses(int numInBusses) {
		Scanner input = new Scanner(System.in);
		if(numInBusses<=0){
			int count =1;
			for(int i = 0; i <count; i++){
				if(numInBusses<1){
					System.out.println("You can not have fewer than one busses");
					System.out.print("Please enter a valid amount of busses: ");
					numInBusses = input.nextInt();
					count++;
				}
				this.numInBusses = numInBusses;
			}
		}
		else
			this.numInBusses = numInBusses;
	}
	
	
	/**
	 * Returns the amount of in route busses
	 * @return
	 */
	public int getNumInBusses(){
		return numInBusses;
	}
	
	/**
	 * 
	 * @param numOutBusses
	 * @throws invalidInputException
	 */
	public void setNumOutBusses(int numOutBusses) {
		Scanner input = new Scanner(System.in);
		if(numOutBusses<=0){
			int count =1;
			for(int i = 0; i <count; i++){
				if(numOutBusses<1){
					System.out.println("You can not have fewer than one busses");
					System.out.print("Please enter a valid amount");
					numOutBusses = input.nextInt();
					count++;
				}
				else
				this.numOutBusses = numOutBusses;
			}
		}
		else
			this.numOutBusses = numOutBusses;
	}
	
	public int getNumOutBusses(){
		return numOutBusses;
	}
	
	/**
	 * Sets the minimum group size to one set by the user
	 * @param minGroupSize
	 */
	public  void setMinGroupSize(int minGroupSize){
		Scanner input = new Scanner(System.in);
		if(minGroupSize<=0){
			int count = 1;
			for(int i=0; i < count; i++){
				if(minGroupSize<=0){
					System.out.println("You can not have fewer than one people in a group");
					System.out.print("Please enter a valid group size: ");
					minGroupSize = input.nextInt();
					count++;
				}
				this.minGroupSize = minGroupSize;
			}
		}
		else
			this.minGroupSize=minGroupSize;
	}
	/**
	 * Returns the minimum group size
	 * @return
	 */
	public int getMinGroupSize(){
		return minGroupSize;
	}
	
	/**
	 * Sets the maximum group size
	 * @param maxGroupSize
	 */
	public  void setMaxGroupSize(int maxGroupSize){
		Scanner input = new Scanner(System.in);
		if(maxGroupSize<minGroupSize){
			int count = 1;
			for(int i=0; i < count; i++){
				if(maxGroupSize<minGroupSize){
					System.out.println("You can not have fewer than the minimum group size");
					System.out.print("Please enter a valid group size: ");
					maxGroupSize = input.nextInt();
					count++;
				}
				this.maxGroupSize = maxGroupSize;
			}
		}
		else
			this.maxGroupSize=maxGroupSize;
	}
	/**
	 * Returns the maximum group size
	 * @return
	 */
	public int getMaxGroupSize(){
		return maxGroupSize;
	}
	
	/**
	 * Sets the arrival probabilty to one by the user
	 * @param arrivalProb
	 */
	public  void setArrivalProb(double arrivalProb){
		Scanner input = new Scanner(System.in);
		if(arrivalProb<=0||arrivalProb>1){
			int count = 1;
				for(int i= 0; i<count; i++){
					if(arrivalProb<=0||arrivalProb>1){
					System.out.println("You can not have a probability less than zero or greater than one");
					System.out.print("Please enter a valid probabilty: ");
					arrivalProb = input.nextDouble();
					count++;
					}
				}
				this.arrivalProb = arrivalProb;
		}
		else
			this.arrivalProb = arrivalProb;
	}
	/**
	 * Returns the arrival probablity 
	 * @return
	 */
	public double getArrivalProb(){
		return arrivalProb;
	}
	
	/**
	 * Sets the duration of a simulation
	 * @param duration
	 */
	public void setDuration(int duration){
		Scanner input = new Scanner(System.in);
		if(duration<=0){
			int count = 1;
				for(int i = 0; i < count; i++){
					System.out.print("You can not have a simulation time less than one minute");
					System.out.println("Please enter a valid simulation time: ");
					duration = input.nextInt();
					count++;
				}
			this.duration = duration;
		}
		else
			this.duration= duration;
	}
	
	/**
	 * Returns the time of a simulation
	 * @return
	 */
	public  int getDuration(){
		return duration;
	}
	
	/**
	 * Sets the amount of groups served
	 * @param incr
	 */
	public void setGroupsServed(int incr){
		groupsServed+= incr;
		
	}
	
	/**
	 * Returns the amount of groups served
	 * @return
	 */
	public int getGroupsServed(){
		return groupsServed;
	}
	
	/**
	 * Sets the total time waited
	 * @param incr
	 */
	public void setTotalTimeWaited(int incr){
		totalTimeWaited+=incr;
	}
	
	/**
	 * Returns the total time waited
	 * @return
	 */
	public int getTotalTimeWaited(){
		return totalTimeWaited;
	}
	/**
	 * Sets the capacity of a bus
	 * @param busCap
	 */
	public void setBusCap(int busCap){
		Scanner input = new Scanner(System.in);
		if(busCap>=minGroupSize ){
			this.busCap=busCap;
		}
		else{
				int count = 1;
					for(int i = 0; i < count; i++){
						if(busCap<minGroupSize){
						System.out.println("You can not have a capacity less than the minimum group size");
						System.out.print("Please enter a valid capacity: ");
						busCap = input.nextInt();
						count++;
						}
					}
				this.busCap = busCap;
			}
	
}
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Simulator sim = new Simulator();

		System.out.print("Enter the amount of In Route buses: ");
		
			sim.setNumInBusses(input.nextInt());
		
		
		System.out.print("Enter the amount of Out Route buses: ");
		
			sim.setNumOutBusses(input.nextInt());
			
		System.out.print("Enter the minimum group size of passengers: " );
			sim.setMinGroupSize(input.nextInt());
		
		System.out.print("Enter the maximum group size of passengers: ");
			sim.setMaxGroupSize(input.nextInt());
		
		System.out.print("Enter the capacity of a bus: ");
			sim.setBusCap(input.nextInt());
			
		System.out.print("Enter the arrival probabilty: ");
			sim.setArrivalProb(input.nextDouble());
		
		
		System.out.print("Enter the duration of the simulation: ");
			sim.setDuration(input.nextInt());		 
		
		sim.simulate(sim.getDuration());
		
	}
	/**
	 * Creates an array of in route busses
	 * @return
	 */
	public Bus[] createInBusses(){
		Bus allIn[]= new Bus[numInBusses];
	
		int time = duration;
		
		for(int i=0; i<numInBusses; i++){
			Bus newBus = new Bus();
			newBus.setType(1);
			newBus.setCapacity(busCap);
			newBus.setRoute(0);
			
			if(i==0){
				newBus.setTimeBetween(0);
				newBus.setTimeToRest(0);
			}
			
			else
				newBus.setTimeToRest(allIn[i-1].getTimeToRest()+30);
			
			allIn[i]= newBus;
		}
		return allIn;
	}
	/**
	 * Creates out route busses
	 * @return array of busses
	 */
	public Bus[] createOutBusses(){
		Bus allOut[]=new Bus[numOutBusses];
		
		for(int i = 0; i<numOutBusses;i++){
			Bus newBus = new Bus();
			newBus.setType(2);
			newBus.setCapacity(busCap);
			newBus.setRoute(0);
			
			if(i==0){
				newBus.setTimeBetween(0);
				newBus.setTimeToRest(0);
			}
			
			else
				newBus.setTimeToRest(allOut[i-1].getTimeToRest()+30);
			
			allOut[i]= newBus;
		}
		return allOut;
	}
	
	/**
	 * Creates a random booleans
	 * @param p
	 * @return
	 */
	public boolean randBool(double p){
		if(p<(arrivalProb/2.0)||p>(1-(arrivalProb/2.0))){
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Runs the bus simulation
	 * @param duration
	 * @return
	 */
	public double[]simulate(int duration){
		//create in and out busses
		PassengerQueue [] busStops = new PassengerQueue[NUM_BUS_STOPS];
		for(int i =0; i< NUM_BUS_STOPS; i++){
			busStops[i] = new PassengerQueue();
			if(i<4){
				busStops[i].setName(inRoute[i]);
			}
			else
				busStops[i].setName(outRoute[i-4]);
		}
		
		
		Bus allIn[]= createInBusses();
		
		Bus allOut[]= createOutBusses();
		
		int groups = 0;
		
		int wait = 0;
		int time = duration;
		
for(int sim= 0; sim<duration; sim++){
	System.out.println("Minute " + (wait+1));
		for(int i =0; i<numInBusses;i++){
			if(allIn[i].getTimeToRest()==0){
				if(randBool(Math.random())){
					Passenger p = new Passenger();
					p.setGroupNumber(randInt(minGroupSize,maxGroupSize));
					p.setLocation(randInt((allIn[i].getRoute()+1),5));
					p.setArrivalTime(arrivalTime);
					
					if(p.getLocation()==4){
						p.setDestination(0);
					}
					else{
						int randint = randInt(p.getLocation()+1,5);
						if(randint==4){
							p.setDestination(0);
						}
						else
						p.setDestination(randInt(randint,4));
					}
					busStops[p.getLocation()].add(p);
					p.setWaitTime(time);
					System.out.println("A group of " + p.getGroupNumber() + " passengers has arrived at " + busStops[p.getLocation()].getName()+ 
							" heading towards " + busStops[p.getDestination()].getName());
					
				}
			 }
		}
		
		//Create out route bus
	for(int i =0; i < numOutBusses;i++){
			if(allOut[i].getTimeToRest()==0&&allOut[i].getTimeBetween()==0){
				if(randBool(Math.random())){
					Passenger p = new Passenger();
					p.setGroupNumber(randInt(minGroupSize,maxGroupSize));
					if(allOut[i].getRoute()==0){
						p.setLocation(randInt(5,8));
					}
					p.setLocation(randInt((allOut[i].getRoute()+4),8));
					p.setArrivalTime(arrivalTime);
					if(p.getLocation()==7){
						p.setDestination(4);
					}
					
					else{
						int randint = randInt(p.getLocation()+1,8);
						p.setDestination(randInt(randint,8));
					}
					
					if(p.getLocation()==8){
						p.setLocation(4);
						p.setDestination(4);
					}
					
					busStops[p.getLocation()].add(p);
					p.setWaitTime(time);
				if(p.getLocation()==8){
					
					System.out.println("A group of " + p.getGroupNumber() + " passengers has arrived at " + busStops[p.getLocation()-1].getName()+ 
							" heading towards " + busStops[p.getDestination()].getName());
					
					}
				else
					System.out.println("A group of " + p.getGroupNumber() + " passengers has arrived at " + busStops[p.getLocation()].getName()+ 
							" heading towards " + busStops[p.getDestination()].getName());
					
					
				}
			}
		}
		//load in bus
		for(int i = 0; i < numInBusses;i++){
			if(allIn[i].getTimeToRest()==0&&allIn[i].getTimeBetween()==0){
				int picked = 0;
				if(busStops[allIn[i].getRoute()].toArray().length!=0){
					for(int k= 0; k<busStops[allIn[i].getRoute()].toArray().length;k++){
						picked+= busStops[allIn[i].getRoute()].get(k).getGroupNumber();
						groupsServed+=picked;
						
					}
				if(allIn[i].getTimeBetween()==0){
					busStops = allIn[i].loadBus(busStops);
					System.out.println("In route bus "+ (i+1) + " arrives at " + busStops[allIn[i].getRoute()].getName() + " and picks up " + picked +" passengers(s)");
					allIn[i].setTimeBetween(30);
				}
				
				}

			}

		}
		
		//load out bus
		for(int i = 0; i < numOutBusses;i++){
			if(allOut[i].getTimeToRest()==0&&allOut[i].getTimeBetween()==0){
				int picked = 0;
			if(busStops[allOut[i].getRoute()].toArray().length!=0){
				int outNumber;
				if(allOut[i].getRoute()==0){
					outNumber = 4;
				}
				else
				 outNumber= allOut[i].getRoute()+3;
				
				for(int k= 0; k< busStops[outNumber].toArray().length;k++){
					picked+= busStops[outNumber].get(k).getGroupNumber();
					groupsServed+=picked;
				}
				
					busStops = allOut[outNumber].loadBus(busStops);
					System.out.println("Out route bus "+ (i+1)+ " arrives at " + busStops[outNumber].getName() + " and picks up " + picked +" passenger(s)");
					allOut[i].setTimeBetween(30);	
			}

			}

		}
		//change route
		for(int i = 0; i< numInBusses; i++){
			if(allIn[i].getRoute()==4&&allIn[i].getTimeToRest()==0){
					allIn[i].setRoute(0);
					if(allIn[i].getTimeBetween()>0){
					allIn[i].setTimeBetween(allIn[i].getTimeBetween()-1);
					}
					
			}
			else{
				if(allIn[i].getTimeToRest()==0&&allIn[i].getTimeBetween()==0){
					allIn[i].setTimeBetween(30);	

				}
				if(allIn[i].getTimeToRest()>0){
					allIn[i].setTimeToRest(allIn[i].getTimeToRest()-1);
				}
				if(allIn[i].getTimeBetween()>0){
					allIn[i].setTimeBetween(allIn[i].getTimeBetween()-1);
					}
				if(allIn[i].getTimeBetween()>0&&allIn[i].getRoute()!=0){
				allIn[i].setRoute(allIn[i].getRoute()+1);
				}
			}
		}
	
		for(int i = 0; i<numOutBusses; i++){
			if(allOut[i].getRoute()==4&&allOut[i].getTimeToRest()==0){
				allOut[i].setRoute(0);
				if(allOut[i].getTimeBetween()>0){
					allOut[i].setTimeBetween(allOut[i].getTimeBetween()-1);
				}
				
			}
			else{
				if(allOut[i].getTimeToRest()==0&&allOut[i].getTimeBetween()==0){
					allOut[i].setTimeBetween(30);	

				}
				if(allOut[i].getTimeToRest()>0){
					allOut[i].setTimeToRest(allOut[i].getTimeToRest()-1);
				}
				if(allOut[i].getTimeBetween()>0){
					allOut[i].setTimeBetween(allOut[i].getTimeBetween()-1);
					}
				if(allOut[i].getTimeBetween()>0&&allOut[i].getRoute()!=0){
				allOut[i].setRoute(allOut[i].getRoute()+1);
				}
			}
		}
		
		for(int i = 0 ; i < numInBusses; i++){
			if(allIn[i].getTimeToRest()==0){
				if(allIn[i].getRoute()==4){
					System.out.println("In route bus "+ (i+1) + " is currently heading towards " + busStops[0].getName() + " arriving in " +allIn[i].getTimeBetween() + " minutes");
				}
				else{
				System.out.println("In route bus "+ (i+1) + " is currently heading towards " + busStops[allIn[i].getRoute()].getName() + " arriving in " +allIn[i].getTimeBetween() + " minutes");
				}
			}
			if(allIn[i].getTimeToRest()>0){
				System.out.println("In route bus " + (i+1) + " is resting at "+ busStops[0].getName()+ " for " + allIn[i].getTimeToRest() + " minutes");
				
			}
		}
		for(int i = 0 ; i < numOutBusses; i++){
			if(allOut[i].getTimeToRest()==0){
				if(allOut[i].getRoute()==0||allOut[i].getRoute()==4){
					System.out.println("Out route bus "+ (i+1) + " is currently heading towards " + busStops[4].getName() + " arriving in " +allOut[i].getTimeBetween() + " minutes");
					
				}
				else{
				System.out.println("Out route bus "+ (i+1) + " is currently heading towards " + busStops[allOut[i].getRoute()].getName() + " arriving in " +allOut[i].getTimeBetween() + " minutes");
				
				}
			}
			if(allOut[i].getTimeToRest()>0){
				System.out.println("Out route bus " + (i+1) + " is resting at "+ busStops[4].getName()+ " for " + allOut[i].getTimeToRest() + " minutes");
				
			}
		
		}
		for(int i = 0; i < numInBusses; i++){
			if(numInBusses>1)
				if(i<numOutBusses-1){
					if(allIn[i].getTimeToRest()==0&&allIn[i].getRoute()==4&&allIn[i].getTimeBetween()==0&&allIn[i+1].getTimeToRest()==0){
						 allIn[i].setTimeToRest(30);
					}
					else
						allIn[0].setTimeToRest(0);
				}
			allIn[0].setTimeToRest(0);
		}
		for(int i = 0; i <numOutBusses; i++){
			if(numOutBusses>1){
				if(i<numOutBusses-1){
					if(allOut[i].getTimeToRest()==0&&allOut[i].getRoute()==4&&allOut[i].getTimeBetween()==0&&allOut[i+1].getTimeToRest()==0){
						allOut[i].setTimeToRest(30);
					}
				}
				else{
					allOut[0].setTimeToRest(0);
				}
			}
			else
				allOut[0].setTimeToRest(0);
		}
		
		
		for(int i = 0; i<NUM_BUS_STOPS;i++){
			if(busStops[i].toArray().length!=0){
				for(int k = 0; k <busStops[i].toArray().length;k++){
					 busStops[i].get(k).setWaitTime( (busStops[i].get(k).getWaitTime()+1));
					 totalTimeWaited+= 	busStops[i].get(k).getWaitTime();

				}
			}
		}
	System.out.println();
	printName(busStops);
	System.out.println();
	wait++;
	}

		System.out.println("Average wait time " +(double)(groupsServed/wait)+ " minutes.");
		System.out.println("Total groups served : " + groupsServed);
		System.out.println("Would you like to run the simulation again?(Y/N): ");
		Scanner input = new Scanner(System.in);
		char chose = input.next().toUpperCase().charAt(0);
		if(chose=='N'){
			System.out.println("Now Quitting");
			System.exit(0);
		}
		else
			reRun();
		return null;
		}
	
	
	/**
	 * Creates a random integer
	 * @param min
	 * @param max
	 * @return
	 */
	private static int randInt(int min, int max){
		if(min==max){
			return max;
		}
		int random = (int) (Math.random()*(max-min)+min);
		return random;
		
	}
	
	/**
	 * Prints the name of each bus stop
	 */
	public void printName(PassengerQueue []busStops){
		for (int i = 0; i < NUM_BUS_STOPS; i++) {
			if(i<inRoute.length){
				System.out.println(" (" + inRoute[i] + " ): ");
				if(busStops[i].toArray().length!=0){
					for(int k = 0; k< busStops[i].toArray().length;k++){
					System.out.println("[ "+ busStops[i].get(k).getGroupNumber() + "," + busStops[i].get(k).getLocation() + "( " 
					+ busStops[busStops[i].get(k).getDestination()].getName() + ") " +","+ busStops[i].get(k).getWaitTime()+ " ]" +"  ");
					}
				}
			else{
				System.out.println(" (" + outRoute[i] + " ): ");
				if(busStops[i].toArray().length!=0){
					for(int k = 0; k< busStops[i].toArray().length;k++){
					System.out.print("[ "+ busStops[i].get(k).getGroupNumber() + "," + busStops[i].get(k).getLocation() + "( " 
					+ busStops[busStops[i].get(k).getDestination()].getName() +")"+","+ busStops[i].get(k).getWaitTime()+ " ]");
					}
				}
			}
			}
		}
	}
	/**
	 * Runs the simulation
	 */
	public void reRun(){
		Scanner input = new Scanner(System.in);
		Simulator sim = new Simulator();

		System.out.print("Enter the amount of In Route buses: ");
		
			sim.setNumInBusses(input.nextInt());
		
		
		System.out.print("Enter the amount of Out Route buses: ");
		
			sim.setNumOutBusses(input.nextInt());
			
		System.out.print("Enter the minimum group size of passengers: " );
			sim.setMinGroupSize(input.nextInt());
		
		System.out.print("Enter the maximum group size of passengers: ");
			sim.setMaxGroupSize(input.nextInt());
		
		System.out.print("Enter the capacity of a bus: ");
			sim.setBusCap(input.nextInt());
			
		System.out.print("Enter the arrival probabilty: ");
			sim.setArrivalProb(input.nextDouble());
		
		
		System.out.print("Enter the duration of the simulation: ");
			sim.setDuration(input.nextInt());		 
		
		sim.simulate(sim.getDuration());
		
	}

}
		
	

