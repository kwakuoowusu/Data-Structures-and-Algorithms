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
//

import big.data.*;

import java.io.Serializable;
import java.util.Hashtable;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
public class HashedLibrary extends Hashtable implements Serializable {
	
	/**
	 * Adds a book to the hashedlibrary with parameters either taken from the database, or by user input
	 * <dt><b> Precondition: </dt></b> There is a hashed library created, and a book has not been entered yet
	 * 
	 * @param title
	 * @param author
	 * @param publisher
	 * @param isbn
	 */
	public void addBook(String title, String author, String publisher, String isbn){
		if(isEmpty()){
			Book newBook = new Book();
			newBook.setTitle(title);
			newBook.setAuthor(author);
			newBook.setPublisher(publisher);
			newBook.setIsbn(isbn);
			put(isbn,newBook);
			System.out.println(isbn + ": " + title + " by " + author + " recorded");
			return;
		}
		else if(get(isbn)==null){
			Book newBook = new Book();
			newBook.setTitle(title);
			newBook.setAuthor(author);
			newBook.setPublisher(publisher);
			newBook.setIsbn(isbn);
			put(isbn,newBook);
			System.out.println(isbn + ": " + title + " by " + author + " recorded");
			return;
		}
		else
			System.out.println(isbn +": " + "Book is already recorded");
			return;
	}
	/**
	 * Adds the information of a book by connecting to the database, using information parsed from a text file
	 * @param fileName
	 * @throws IOException If the book doesn't exist 
	 */
	public void addAllBookInfo(String fileName) throws IOException,DataSourceException{
		BufferedReader reader = load(fileName);
		String bookName = reader.readLine();
		while(bookName!=null){
			
			DataSource ds = DataSource.connect("http://www.cs.stonybrook.edu/~cse214/hw/hw6/" + bookName + ".xml").load();
			
			String title = ds.fetchString("title");
			String author = ds.fetchString("author");
			
			String publisher = ds.fetchString("publisher");
			String isbn = ds.fetchString("isbn");
			
			if(title==null|| author ==null|| publisher ==null|| isbn==null){
				System.out.println("Could not add this book! The following Information is missing: ");
				if(title==null){
					System.out.print("Title"+ " ");
				}
				if(author==null){
					System.out.print("Author"+ " ");
				}
				if(publisher==null){
					System.out.print("Publisher" + " ");
				}
				if(isbn==null){
					System.out.print("ISBN");
				}
				bookName = reader.readLine();
			}
			else{
				addBook(title,author,publisher,isbn);
				bookName = reader.readLine();
			}
			
		}
		
		
	}
	
	/**
	 * Searches for a book in the HashedLibrary using the isbn key, if its not found
	 * Null is returned
	 * <dt><b>Precondition:</dt></b> There are books in the library
	 * @param isbn
	 * @return
	 */
	public Book getBookByisbn(String isbn){
		Book newBook = (Book) get(isbn);
		return newBook;
	}
	
	/**
	 * Crates a bufferedReader using a file name inserted by the user
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public BufferedReader load(String fileName) throws FileNotFoundException{
		FileInputStream fis;
		fis = new FileInputStream(fileName);
		InputStreamReader inStream = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(inStream);
		
		return reader;
	}
	
	/**
	 * Prints the entire content of the library only if there are books in it
	 * Creates an enumeration of all keys and searches the database for each key, prints the content
	 */
	public void printCatalog(){
		Enumeration e = this.keys();
		String bookIsbn = "Book ISBN";
		String bookTitle = "Title";
		String bookAuthor = "Author";
		String bookPublisher = "Publisher";
		String bar  = "-----------------------------------------------"
				+ "-----------------------------------------------------"
				+ "------------------------------------------------------------------------------------";
		String s = String.format("%-18s %-70s %-60s %s \n",bookIsbn, bookTitle, bookAuthor,bookPublisher);
		System.out.print(s);
		System.out.println(bar);
		
		while(e.hasMoreElements()){
			System.out.print(get(e.nextElement()).toString());
		}
		System.out.println();
	}
    
  
}
