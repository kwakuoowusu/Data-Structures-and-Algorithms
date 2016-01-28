/**
 * Kwaku Owusu
 * 109181846
 * HW 6
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
import java.io.Serializable;
import java.util.Scanner;

import big.data.DataSourceException;




public class DatabaseDriver implements Serializable {
	private static String menu = "(D) Display Books \n"
							+"(G) Get Book \n"
							+"(L) Load File \n"
							+"(R) Record Book \n"
							+"(Q) Quit \n \n" +"Enter Selection:";
	private static String bookIsbn = "Book ISBN";
	private static String bookTitle = "Title";
	private static String bookAuthor = "Author";
	private static String bookPublisher = "Publisher";
	private static String bar  = "-----------------------------------------------"
			+ "-----------------------------------------------------"
			+ "-------------------------------------------------------------------------------------";
	/**
	 * Loads a library if the library.obj file is found, otherwise an exceptions is thrown
	 * @return myLibrary a previously created library
	 * @throws ClassNotFoundException
	 */
	public HashedLibrary loadLibrary() throws ClassNotFoundException{
		HashedLibrary myLibrary;
		try {
		     FileInputStream file = new FileInputStream("Library.obj");
		     ObjectInputStream fin  = new ObjectInputStream(file);
		     myLibrary = (HashedLibrary) fin.readObject(); //readObject() returns Object, so must typecast to HashedLibrary
		     fin.close();
		     return myLibrary;
		} catch(IOException e){
			 myLibrary = new HashedLibrary();
			return myLibrary;
		}
	}
	/**
	 * Saves the content of the library and writes it to disk.
	 * @param myLibrary
	 */
	public void saveLibrary(HashedLibrary myLibrary){
		try {
		      FileOutputStream file = new FileOutputStream("Library.obj");
		      ObjectOutputStream fout = new ObjectOutputStream(file);
		      fout.writeObject(myLibrary); 
		      fout.close();
		} catch (IOException e){
		   System.out.print("An unexpected error occured, closing program");
		   System.exit(0);
		}
	
	}
	/**
	 * Handles all user inputs using a switch statement, after each command the user is routed back to this menu
	 * @param db
	 * @param myLibrary
	 * @param choice
	 */
	public void databaseMenu(DatabaseDriver db, HashedLibrary myLibrary,char choice){
		Scanner input = new Scanner(System.in);
		switch(choice){
			case('D'): // display all books
				if(myLibrary.isEmpty()){
					System.out.println("There are no books in this database!");
					System.out.print(menu);
					choice = input.nextLine().toUpperCase().charAt(0);
					db.databaseMenu(db, myLibrary, choice);
					break;
				}
				else{
					myLibrary.printCatalog();
					System.out.print(menu);
					choice = input.nextLine().toUpperCase().charAt(0);
					db.databaseMenu(db, myLibrary, choice);
					break;
				}
			case('G'): //get a book
				if(myLibrary.isEmpty()){
					System.out.println("There are no books in this database!");
					System.out.println(menu);
					choice = input.nextLine().toUpperCase().charAt(0);
					db.databaseMenu(db, myLibrary, choice);
					break;
				}
				else{
					System.out.print("Enter book ISBN: ");
					String enteredIsbn = input.nextLine();
					if(myLibrary.get(enteredIsbn)!=null){
						Book newBook=  myLibrary.getBookByisbn(enteredIsbn);
						String s = String.format("%-18s %-70s %-60s %s \n",bookIsbn, bookTitle, bookAuthor,bookPublisher);
						System.out.print(s);
						System.out.println(bar);
						System.out.print(newBook.toString());
						System.out.println();
						System.out.print(menu);
						
						choice = input.nextLine().toUpperCase().charAt(0);
						db.databaseMenu(db, myLibrary, choice);
						break;
					}
					else{
						System.out.println("This book does not exist in the database!");
						System.out.print(menu);
						
						choice = input.nextLine().toUpperCase().charAt(0);
						db.databaseMenu(db, myLibrary, choice);
						break;
					}
					
				}
			case('L'): //load a book
					System.out.print("Enter the file to load: ");
					boolean loaded = false;
					while(!loaded){
						
							String fileName = input.nextLine();
							try {
								myLibrary.addAllBookInfo(fileName);
								loaded=true;
								System.out.print(menu);
								choice = input.nextLine().toUpperCase().charAt(0);
								db.databaseMenu(db, myLibrary, choice);
								break;
								
							} catch (IOException e) {
								System.out.println("This file does not exist, enter a proper file name.");
								System.out.print("Would you like to re enter the file name? (Y/N): ");
								char choose = input.nextLine().toUpperCase().charAt(0);
								if(choose=='N'){
									System.out.println("Returning to menu");
									System.out.print(menu);
									choice = input.nextLine().toUpperCase().charAt(0);
									db.databaseMenu(db, myLibrary, choice);
									break;
								}
								else
								db.databaseMenu(db, myLibrary, choice);
								break;
							}catch(DataSourceException e){
								System.out.println("The Specified book inside the file does not exist on this server");
								System.out.println("Returning to menu");
								System.out.print(menu);
								choice = input.nextLine().toUpperCase().charAt(0);
								db.databaseMenu(db, myLibrary, choice);
								break;
							}
							
						
					}
			case('R'): //record a book
				System.out.print("Enter book title:");
				String title = input.nextLine();
				while(title.equals("")){
					System.out.print("Please enter a valid title: ");
					title = input.nextLine();
				}
				
				System.out.print("Enter book author: ");
				String author = input.nextLine();
				
				while(author.equals("")){
					System.out.print("Please enter a valid name for the author: ");
					author = input.nextLine();
				}
				
				System.out.print("Enter book publisher: ");
				String publisher = input.nextLine();
				
				while(publisher.equals("")){
					System.out.print("Please enter a valid name for the publisher: ");
					publisher = input.nextLine();
				}
				
				System.out.print("Enter book isbn: ");
				String isbn = input.nextLine();
				
				while(isbn.equals("")|| isbn.length()!=10&&isbn.length()!=13){
					System.out.print("Please enter a valid isbn, an isbn contains 10 or 13 digits ");
					isbn = input.nextLine();
				}
				myLibrary.addBook(title, author, publisher, isbn);
				System.out.print(menu);
				choice = input.nextLine().toUpperCase().charAt(0);
				db.databaseMenu(db, myLibrary, choice);
				break;
				
			case('Q'):
				System.out.println("HashedLibrary is now saved into the file Library.obj");
				db.saveLibrary(myLibrary);
				System.out.println("Closing program normally.");
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid command." +"\n");
				System.out.print(menu);
				choice = input.nextLine().toUpperCase().charAt(0);
				db.databaseMenu(db, myLibrary, choice);
				break;
				
		
		}
		
	}
	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			DatabaseDriver db = new DatabaseDriver();
			File f = new File("Library.obj");
			HashedLibrary myLibrary;
			if(!f.exists()){
				 myLibrary = new HashedLibrary();  //Goes directly to the input handler if the obj file does not exist
				System.out.println("Library.obj is not found. Creating new hashedLibrary");
				System.out.print(menu);
				char choice = input.nextLine().toUpperCase().charAt(0);
				db.databaseMenu(db, myLibrary, choice);
			
			}
			else{
				try {
					 myLibrary = db.loadLibrary(); // load the contents of library.obj to myLibrary
					 System.out.print(menu); 
					 char choice = input.nextLine().toUpperCase().charAt(0);
					db.databaseMenu(db, myLibrary, choice);
					
				} catch (ClassNotFoundException e) {
					System.out.println("Library.obj seems to be corrupted, creating a new file.");
					myLibrary = new HashedLibrary();
					System.out.print(menu);
					char choice = input.nextLine().toUpperCase().charAt(0);
					db.databaseMenu(db, myLibrary, choice);
				}
			}
	}
}
