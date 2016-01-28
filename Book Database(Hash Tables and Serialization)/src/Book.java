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


import java.io.Serializable;

	
public class Book implements Serializable{
  private String title;
  private String author;
  private String publisher;
  private String isbn;
  	
  	/**
  	 * Sets the title to either one parsed from a file, or by user input
  	 * @param title
  	 */
  	public void setTitle(String title){
	  this.title = title;
  	}
  	
  	/**
  	 * Returns the title of the book
  	 * @return
  	 */
  	public String getTitle(){
  		return title;
  	}
  	
  	/**
  	 * Sets the author of a book to either one parsed from a file or set by user
  	 * @param author
  	 */
  	public void setAuthor(String author){
  		this.author = author;
  	}
  	
  	/**
  	 * Returns the author of a book
  	 * @return
  	 */
  	public String getAuthor(){
  		return author;
  	}
  	
  	/**
  	 * Sets the publisher of a book to either one parsed from a file or from user input
  	 * @param publisher
  	 */
  	public void setPublisher(String publisher){
  		this.publisher = publisher;
  	}
  	
  	/**
  	 * Returns the publish of a book
  	 * @return
  	 */
  	public String getPublisher(){
  		return publisher;
  	}
  	
  	/**
  	 * Sets the isbn of a book to one parsed from a file, or one set by a user
  	 * @param isbn
  	 */
  	public void setIsbn(String isbn){
  		this.isbn=isbn;
  	}
  	
  	/**
  	 * Returns the isbn of a book
  	 * @return
  	 */
  	public String getIsbn(){
  		return isbn;
  	}
  	
  	public String toString(){
  		
  		String s  = String.format("%-18s %-70s %-60s %s \n" , isbn, title, author, publisher);
  		return s;
  	}
}

