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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class SigmaAirDriver {
	private static String menu = "(A) Add City \n"
								+ "(B) Add Connection  \n"
								+ "(C) Load all Cities \n"
								+ "(D) Load all Connections \n"
								+ "(E) Print all Cities \n"
								+ "(F) Print all Connections \n"
								+ "(G) Remove Connection \n"
								+ "(H) Find Shortest Path \n"
								+ "(Q) Quit \n"
								+ "Enter a Selection: ";
	private static String cityMenu = "(EA) Sort Cities by Name \n"
								   + "(EB) Sort Cities by Latitude\n"
								   + "(EC) Sort Cities by Longitude\n"
								   + "(Q)  Quit \n"
								   + "Enter a selection: ";
	/**
	 * Switch statement that handles user inut, default directs them back to menu
	 * @param sad
	 * @param sa
	 * @param choice
	 */
	public void inputHandler(SigmaAirDriver sad, SigmaAir sa, char choice){
		Scanner input = new Scanner(System.in);
		switch(choice){
			case('A'):
				System.out.print("Enter the name of the city: ");
				String city = input.nextLine();
				sa.addCity(city);
				System.out.println();
				System.out.print(menu);
				choice = input.nextLine().toUpperCase().charAt(0);
				sad.inputHandler(sad, sa, choice);
				break;
				
			case('B'):
				System.out.print("Enter the source city: ");
				String cityFrom = input.nextLine();
				System.out.print("Enter the destination city: ");
				String cityTo = input.nextLine();
				sa.addConnection(cityFrom, cityTo);
				System.out.print(menu);
				choice = input.nextLine().toUpperCase().charAt(0);
				sad.inputHandler(sad, sa, choice);
				break;
				
			case('C'):
				System.out.print("Enter the filename: ");
				String filename= input.nextLine();
			try {
				sa.loadAllCities(filename);
				System.out.print(menu);
				choice = input.nextLine().toUpperCase().charAt(0);
				sad.inputHandler(sad, sa, choice);
				break;
				
			} catch (IOException e) {
				System.out.println("The file could not be loaded, returning to menu");
				System.out.print(menu);
				choice = input.nextLine().toUpperCase().charAt(0);
				sad.inputHandler(sad, sa, choice);
				break;
			}
			
			case('D'):
				System.out.print("Enter the filename: ");
				String connectionName = input.nextLine();
			try {
				sa.loadAllconnections(connectionName);
				System.out.print(menu);
				choice = input.nextLine().toUpperCase().charAt(0);
				sad.inputHandler(sad, sa, choice);
				break;
			} catch (IOException e) {
				System.out.println("The file could not be loaded, returning to menu");
				System.out.print(menu);
				choice = input.nextLine().toUpperCase().charAt(0);
				sad.inputHandler(sad, sa, choice);
				break;
			}
			
			case('E'):
					System.out.print(cityMenu);
					String selection = input.nextLine();
					cityPrintManager(selection,sa);
					System.out.print(menu);
					choice = input.nextLine().toUpperCase().charAt(0);
					sad.inputHandler(sad, sa, choice);
					break;
			case('F'):
					sa.printAllConnections();
					System.out.println();
					System.out.print(menu);
					choice = input.nextLine().toUpperCase().charAt(0);
					sad.inputHandler(sad, sa, choice);
					break;
			case('G'):
					System.out.print("Enter source city: ");
					String source = input.nextLine();
					System.out.print("Enter destination city: ");
					String dest = input.nextLine();
					sa.removeConnection(source, dest);
					System.out.println();
					System.out.print(menu);
					choice = input.nextLine().toUpperCase().charAt(0);
					sad.inputHandler(sad, sa, choice);
					break;
			case('H'):
					System.out.print("Enter source city: ");
					source = input.nextLine();
					System.out.print("Enter destination city: ");
					dest = input.nextLine();
					System.out.println(sa.shortestPath(source, dest));
					System.out.println();
					System.out.print(menu);
					choice = input.nextLine().toUpperCase().charAt(0);
					sad.inputHandler(sad, sa, choice);
					break;
			
			case('Q'):
					saveSigma(sa);
					System.out.println("SigmaAir object saved into file sigma_air.obj.");
					System.out.println();
					System.out.println("Program terminating normally");
					System.exit(0);
					break;
				
			default:
					System.out.println("Invalid Command");
					System.out.print(menu);
					choice = input.nextLine().toUpperCase().charAt(0);
					sad.inputHandler(sad, sa, choice);
					break;
		}
	}
	/**
	 * Manages sorting cities by name, latitude or longitude.
	 * @param selection
	 * @param sa
	 */
	public void cityPrintManager(String selection,SigmaAir sa){
		Scanner input = new Scanner(System.in);
		selection = selection.toUpperCase();
		if(selection.equals("EA")){
			NameComparator name = new NameComparator();
			sa.printAllCities(name);
			System.out.println();
		}
		else if(selection.equals("EB")){
			LatComparator lat = new LatComparator();
			sa.printAllCities(lat);
			System.out.println();
		}
		else if(selection.equals("EC")){
			LngComparator lng = new LngComparator();
			sa.printAllCities(lng);
			System.out.println();
		}
		else if(selection.equals("Q")){
			return;
		}
		else
			System.out.println("Invalid command, returning to menu..");
			return;
	}
	
	/**
	 * Writes the sigma air object to disk.
	 * @param sa
	 */
	public void saveSigma(SigmaAir sa){
		try {
		      FileOutputStream file = new FileOutputStream("sigma_air.obj");
		      ObjectOutputStream fout = new ObjectOutputStream(file);
		      fout.writeObject(sa); 
		      fout.close();
		} catch (IOException e){
		   System.out.print("An unexpected error occured, closing program");
		   System.exit(0);
		}
	
	}
	/**
	 * Loads the Sigma Air object from disk
	 * @return
	 * @throws ClassNotFoundException
	 */
	public SigmaAir loadSigma() throws ClassNotFoundException{
		SigmaAir sad;
		try {
		     FileInputStream file = new FileInputStream("sigma_air.obj");
		     ObjectInputStream fin  = new ObjectInputStream(file);
		     sad = (SigmaAir) fin.readObject(); //readObject() returns Object, so must typecast to HashedLibrary
		     fin.close();
		     return sad;
		} catch(IOException e){
			 sad = new SigmaAir();
			return sad;
		}
	}
	

	public static void main(String[]args){
		Scanner input = new Scanner(System.in);
		File f = new File("sigma_air.obj");
		SigmaAirDriver sad = new SigmaAirDriver();
		SigmaAir sa;
	
		if(!f.exists()){
			 sa = new SigmaAir(); //Goes directly to the input handler if the obj file does not exist
			System.out.println("sigma_air.obj is not found. A new SigmaAir object will be created");
			System.out.print(menu);
			char choice = input.nextLine().toUpperCase().charAt(0);
			sad.inputHandler(sad, sa, choice);
		}
		else
			System.out.print(menu);
			try {
				sa = sad.loadSigma();
				char choice = input.nextLine().toUpperCase().charAt(0);
				sad.inputHandler(sad, sa, choice);
			} catch (ClassNotFoundException e) {
				System.out.println("sigma_air.obj seems to be corrupted, creating a new file.");
				sa = new SigmaAir();
				System.out.print(menu);
				char choice = input.nextLine().toUpperCase().charAt(0);
				sad.inputHandler(sad, sa, choice);
			}
			
			
	}
	
}
