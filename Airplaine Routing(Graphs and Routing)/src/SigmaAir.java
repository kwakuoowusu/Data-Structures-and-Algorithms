/**
 * Kwaku Owusu
 * 109181846
 * HW 7
 * CSE 214 Recitation 3
 * Recitation TA Sun Lin
 * Grading TA Ke Ma
 * @author Kwaku
 * 
 */
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.BufferedReader;

import com.google.code.geocoder.model.LatLng;

public class SigmaAir implements Serializable{
	private ArrayList<City> cities;
	public static final int MAX_CITIES = 100;
	private double[][] connections;
	private String connectionInfo = String.format("%-50s %s", "Route", "Distance");
	private String bar = "---------------------------------------------------------"
			+ "-------------------------------------------";
	/**
	 * Initizalizes the sigmaair object, with an adjacency matrix;
	 */
	public SigmaAir(){
		MatrixInitialize();
		cities = new ArrayList<City>(MAX_CITIES);
	}
	/**
	 * Creates the initial adjacency Matrix, making the main diagonal 0; 
	 */
	public void MatrixInitialize(){
		connections = new double[MAX_CITIES][MAX_CITIES];
		for(int i = 0; i <connections.length;i++){
				for(int j = 0; j<connections.length;j++){
					if(j==i){
						connections[i][j]=0;
					}
					else
						connections[i][j]= Double.POSITIVE_INFINITY;
				}
		}
	}
	
	/**
	 * Adds a city to the arraylist of cities oly if the maximum amount has not been reached
	 * @param city
	 */
	public void addCity(String city){
		
		boolean recorded = cityCheck(city);
		if(cities.size()==MAX_CITIES){
			System.out.println("The maximum amount of cities has been reached you can not add more");
			return;
		}
		if(recorded==false){
			City newCity = new City(city);
			city = newCity.getName();
			cities.add(newCity);
			System.out.println(city + " has been added" + "( " + citySearch(city).getLocation().getLat() + ", "
					+ citySearch(city).getLocation().getLng() + ") " );
		}
		else
			System.out.println(city + " has already been recorded");
		
	}
	
	/**
	 * Adds a connection between two cities only if they exist in the databse
	 * @param cityFrom
	 * @param cityTo
	 */
	public void addConnection(String cityFrom, String cityTo){
		
			int indexI;
			int indexJ;
			boolean cityFromCheck = cityCheck(cityFrom);
			boolean cityToCheck = cityCheck(cityTo);
			
			if(cityFromCheck==true&&cityToCheck==true){
				indexI = citySearch(cityFrom).getIndexPos();
				indexJ = citySearch(cityTo).getIndexPos();
			
				if(connections[indexI][indexJ]!=Double.POSITIVE_INFINITY){
					System.out.println("The connection between" + " " + cityFrom + " and " + cityTo + " has already been recorded.");
					return;
				}
				else{
				connections[indexI][indexJ]= latlng.LatLng.calculateDistance(cities.get(indexI).getLocation(), cities.get(indexJ).getLocation());
				System.out.println("The connection between" + " " + cityFrom + " and " + cityTo + " has been recorded.");
				return;
				}
			}
			if(cityFromCheck!=true){
				System.out.print(cityFrom +" is not in the database! ");
			}
			if(cityToCheck!=true){
				System.out.print(cityTo+ " is not in the database!");
			}
			
			System.out.println(" The connection could not be added, returning to menu..");
			return;
	}
	
	/**
	 * Returns a boolean if a city exists in the the ArrayList of cities
	 * @param city 
	 * @return true if inside the database false if otherwise
	 */
	public boolean cityCheck(String city){
		boolean recorded = false;
		City []check = new City[100];
		check =  cities.toArray(new City[cities.size()]);
		for(int i = 0; i < check.length; i++){
			if(check[i]!=null){
				if(check[i].getName().equals(city)){
					recorded=true;
					return recorded;
				}
		  }
		}
		return recorded;
	}
	
	/**
	 * Removes a connection in the adjacency matrix only if it exists in the arraylist
	 * @param cityFrom
	 * @param cityTo
	 */
	public void removeConnection(String cityFrom, String cityTo){
		int indexI;
		int indexJ;
		boolean cityFromCheck = cityCheck(cityFrom);
		boolean cityToCheck = cityCheck(cityTo);
		
		if(cityFrom.equals(cityTo)){
			System.out.println("Both cities match. You can not remove a connection");
			return;
		}
		if(cityFromCheck!=true){
			System.out.println(cityFrom +" is not in the database! Returning to menu...");
		}
		
		if(cityToCheck!=true){
			System.out.println(cityToCheck + " is not in the database");
			return;
		}
		
		else if(cityFromCheck==true&&cityToCheck==true){
			indexI = citySearch(cityFrom).getIndexPos();
			indexJ = citySearch(cityTo).getIndexPos();
			connections[indexI][indexJ]= Double.POSITIVE_INFINITY;
			System.out.println("The connection between" + " " + cityFrom + " and " + cityTo + " has been removed.");
			return;
		}
		
		
		return;
	}
	
	/**
	 * The start of the floyd warshall algroithm, applied from online sources
	 * It only begins if the two cities exist in the arraylist
	 * @param cityFrom
	 * @param cityTo
	 * @return
	 */
	public String shortestPath(String cityFrom, String cityTo){
		if(cityCheck(cityFrom)==false||cityCheck(cityTo)==false){
			System.out.println();
			System.out.print("You can not find the shortest path, because ");
			if(cityCheck(cityFrom)==false){
				System.out.print(cityFrom + " is not in the database ");
			}
			if(cityCheck(cityTo)==false){
				System.out.print(cityTo + " is not in the databse");
			}
			
			return "";
		}
		if(connections[citySearch(cityFrom).getIndexPos()][citySearch(cityTo).getIndexPos()]==Double.POSITIVE_INFINITY){
			System.out.println("No connections exists between " + cityFrom + " and " + cityTo);
		}
		String completePath="";
		int[][]path = predecessors();
		double[][]copy = new double[MAX_CITIES][MAX_CITIES];
		copy = copyMatrix(copy);
		
		for(int k = 0; k < copy.length;k++){
			for(int i = 0; i < copy.length; i++){
				for(int j = 0; j< copy.length; j++){
					if(copy[i][k]!=Double.POSITIVE_INFINITY&&copy[k][j]!=Double.POSITIVE_INFINITY){
						if(copy[i][j]> copy[i][k] + copy[k][j]){
							copy[i][j]= copy[i][k] +copy[k][j];
							path[i][j] = path[k][j];
						}
					}
				}
			}
		}
		
		 findPath(path,citySearch(cityFrom).getIndexPos(),citySearch(cityTo).getIndexPos(), completePath,0);
			return completePath;
	}
	
	/**
	 * Creates an array of predecessors 
	 * @return
	 */
	public int[][] predecessors(){
		int[][] path = new int[connections.length][connections.length];
		for(int i = 0; i< connections.length; i ++){
			for(int j = 0; j<connections.length; j++){
				if(connections[i][j]!=0&&connections[i][j]!=Double.POSITIVE_INFINITY){
					path[i][j]=i;
				}
				else
					path[i][j] = -1;
				
			}
		}
		return path;
	}
	
	/**
	 * After a sorted matrix is created recursion will be applied to find the shortest path
	 * @param path
	 * @param i
	 * @param j
	 * @param p
	 */
	public void findPath(int[][]path,int i, int j,String p,double dist){
		
		
		
		if(i!=j){
			System.out.print(cities.get(j).getName() + "<---");
			if(connections[i][j]!=Double.POSITIVE_INFINITY){
			dist+= connections[i][j];
			}
			findPath(path, i,path[i][j], p,dist);
			
		}
		
		else if (i==j){
			System.out.print(cities.get(j).getName() + " "+  dist);
			return;
		}
		
		else if (path[i][j]==0){
			System.out.print("The path does not exist");
		}
		
		
	}
	
	/**
	 * Returns the a city inside the arrayList
	 * @param city
	 * @return
	 */
	public City citySearch(String city){
		for(int i = 0; i<cities.size();i++){
			if(cities.get(i).getName().equals(city)){
				return cities.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Loads every city from a text file, by reading each line as a string and passes it to the add city method
	 * @param filename
	 * @throws IOException
	 */
	public void loadAllCities(String filename) throws IOException{
		FileInputStream fis;
		fis = new FileInputStream(filename);
		InputStreamReader inStream = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(inStream);
		String s =reader.readLine();
		
		while(s!=null){
			addCity(s);
			s = reader.readLine();
		}
	}
	
	/**
	 * Adds connections to an adjacency matrix by reading line by line from a file provided
	 * @param filename
	 * @throws IOException
	 */
	public void loadAllconnections(String filename) throws IOException{
		
		boolean cityFromCheck;
		boolean cityToCheck;
		FileInputStream fis;
		fis = new FileInputStream(filename);
		InputStreamReader inStream = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(inStream);
		String s =reader.readLine();
		
		
		
		while(s!=null){
			String[]pieces = s.split(",");
			String cityFrom = pieces[0];
			String cityTo = pieces[1];
			cityFromCheck = cityCheck(cityFrom);
			cityToCheck = cityCheck(cityTo);
			if(cityFromCheck==true&&cityToCheck==true){
				addConnection(cityFrom,cityTo);				
			}
			else if(cityFromCheck==false||cityToCheck==false){
				if(cityFromCheck==false){
				System.out.println(cityFrom + " Does not exist in the database, therefore a connection could not be added");
				}
				if(cityToCheck==false){
					System.out.println(cityTo + " Does not exist in the database, therefore a connection could not be added");
				}
				
			}
			
			
			s = reader.readLine();
			
		}
	}
	
	public double[][]copyMatrix(double[][]copy){
		for(int i = 0; i< connections.length;i++){
			for(int j = 0; j< connections.length; j++){
				copy[i][j] = connections[i][j];
			}
		}
		return copy;
	}
	/**
	 * Prints every city in a list depending on the comparator provided, can be printed by name, latitude and longitude
	 * @param Comp
	 */
	public void printAllCities(Comparator Comp){
		ArrayList<City> cityCopy = cities;
		
		Collections.sort(cityCopy,Comp);
		System.out.println("Cities: ");
		String s =String.format("%-50s %-30s %-30s \n", "City Name", "Latitude", "Longitude");
		System.out.print(s);
		System.out.println(bar);
		for(int i=0; i< cityCopy.size(); i++){
			System.out.println(cityCopy.get(i).toString());
		}
		
		
	}
	public void setConnection(double[][]connections){
		this.connections = connections;
	}
	public double[][] getConnection(){
		return connections;
	}
	/**
	 * Prints every connection inside the adjacency matrix
	 */
	public void printAllConnections(){
		System.out.println("Connections: ");
		System.out.println(connectionInfo);
		System.out.println(bar);
		for(int i = 0; i < connections.length; i++){
			for(int j = 0; j< connections.length; j++){
				if(connections[i][j]!=0&&connections[i][j]!=Double.POSITIVE_INFINITY){
					String s = cities.get(i).getName() + " ---> " + cities.get(j).getName();
					s = String.format("%-50s %f \n", s,connections[i][j] );
					System.out.print(s);
				}
			}
		}
	}
	

}
