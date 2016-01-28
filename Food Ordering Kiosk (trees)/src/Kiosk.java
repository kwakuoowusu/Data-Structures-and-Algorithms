/**
 * Kwaku Owusu
 * 109181846
 * HW 5
 * CSE 214 Recitation 3
 * Recitation TA Sun Lin
 * Grading TA Ke Ma
 * @author Kwaku
 * 
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Kiosk {
	static String intro = "L) Load a menu" +"\n" + "P) Print menu" +"\n"
			+"S) Start Service" + "\n" + "Q) Quit";
	static String prompt = "Enter command: ";
	static String bar = "------------------------------------------------------------------------------------------------------------";
	private boolean loaded;
	private Tree loadedTree = new Tree();
	private String left = "";
	private String middle = "";
	private String right = "";
	
	/**
	 * Once a tree is loaded it is set as true
	 * @param fact
	 */
	public void setLoaded(boolean fact){
		this.loaded =fact;
	}
	
	/**
	 * Returns true if the tree is loaded false otherwise
	 * @return
	 */
	public boolean getLoaded(){
		return loaded;
	}
	
	/**
	 * Creates a reader from the file name
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
	 * Handles all user input 
	 * @param choice
	 * @param demo
	 * @throws IOException if a file doesn't exist
	 */
	public static void kioskManager(char choice, Kiosk demo) throws IOException{
		Scanner input = new Scanner(System.in);
		
		switch(choice){
				
				case('L'):
					if(!demo.getLoaded()){
						System.out.print("Enter file name: ");
						String filename = input.nextLine();
						BufferedReader reader =demo.load(filename);
						demo.loadTree(reader,demo);
						System.out.println(filename + " is loaded");
						
						if(demo.loadedTree.getRoot().getLeft()!=null){
							demo.left = demo.loadedTree.getRoot().getLeft().getName();
						}
						
						if(demo.loadedTree.getRoot().getMiddle()!=null){
							demo.middle = demo.loadedTree.getRoot().getMiddle().getName();
						}
						
						if(demo.loadedTree.getRoot().getRight()!=null){
							demo.right = demo.loadedTree.getRoot().getRight().getName();
						}
						
						System.out.println(intro);
						System.out.print(prompt);
						choice = input.nextLine().toUpperCase().charAt(0);
						kioskManager(choice,demo);
						break;
					}
					else
						System.out.print("Are you sure you want to load a new file?(Y/N)");
						char redo = input.nextLine().toUpperCase().charAt(0);
						if(redo=='N'){
							System.out.println(intro);
							System.out.print(prompt);
							choice = input.nextLine().toUpperCase().charAt(0);
							kioskManager(choice,demo);
							break;
						}
						else if(redo=='Y'){
							System.out.print("Enter file name: ");
							String filename = input.nextLine();
							BufferedReader reader =demo.load(filename);
							demo.loadTree(reader,demo);
							System.out.println(filename + " is loaded");
							System.out.println(intro);
							System.out.print(prompt);
							choice = input.nextLine().toUpperCase().charAt(0);
							kioskManager(choice,demo);
							break;
						}

							
				case('P'):
					if(!demo.getLoaded()){
						System.out.println("No file is loaded!");
						System.out.println();
						System.out.println(intro);
						System.out.print(prompt);
						choice = input.nextLine().toUpperCase().charAt(0);
						kioskManager(choice,demo);
						break;
					}
					else{
						if(!demo.left.equals("")){
						System.out.println("Menu: ");
						System.out.println("\n" + "Location: "+ demo.left+ "\n");
						System.out.printf("%-25s %-75s %s \n","Selection","Modification","Price");
						System.out.println(bar);
						
						demo.loadedTree.printLeftChild(demo.loadedTree.getRoot().getLeft(),demo.loadedTree.getRoot().getLeft().getName());
						
						}
						if(!demo.middle.equals("")){
							System.out.println("\n" + "Location: "+ demo.middle+ "\n");
							System.out.printf("%-25s %-75s %s \n","Selection","Modification","Price");
							System.out.println(bar);
							
							demo.loadedTree.printMiddleChild(demo.loadedTree.getRoot().getMiddle(),demo.loadedTree.getRoot().getMiddle().getName());
						}
						if(!demo.right.equals("")){
							System.out.println("\n" + "Location: "+ demo.right+ "\n");
							System.out.printf("%-25s %-75s %s \n","Selection","Modification","Price");
							System.out.println(bar);
							
							demo.loadedTree.printRightChild(demo.loadedTree.getRoot().getRight(),demo.loadedTree.getRoot().getRight().getName());
						}
					
						System.out.println("\n"+ intro);
						System.out.print(prompt);
						choice = input.nextLine().toUpperCase().charAt(0);
						kioskManager(choice,demo);
						break;
					}
				
				case('S'):
						if(!demo.getLoaded()){
						System.out.println("No file is loaded!");
						System.out.println();
						System.out.println(intro);
						System.out.print(prompt);
						choice = input.nextLine().toUpperCase().charAt(0);
						kioskManager(choice,demo);
						break;
						}
						else{
							demo.loadedTree.beginSession();
							System.out.println();
							System.out.println(intro);
							System.out.print(prompt);
							choice = input.nextLine().toUpperCase().charAt(0);
							kioskManager(choice,demo);
							break;
						}
				
							
				case('Q'):
						System.out.println("Quitting");
						System.exit(0);
						break;
				
				default:
					System.out.println("Invalid Input!");
					System.out.println();
					System.out.println(intro);
					System.out.print(prompt);
					choice = input.nextLine().toUpperCase().charAt(0);
					kioskManager(choice,demo);
			}
	}
	
	/**
	 * Creates a tree from a file, filling from left middle to right
	 * @param reader
	 * @param demo
	 * @throws IOException
	 */
	public void loadTree(BufferedReader reader, Kiosk demo) throws IOException{
		String s = reader.readLine();
		
		  
		
		TreeNode  newNode = new TreeNode();
		if( s==null){
			return;
		}
		
		else{
				if(s.equals("root")){
					
					newNode.setName(s);
					
					s=reader.readLine();
					
					newNode.setSelection(s);
					
					s= reader.readLine();
					
					newNode.setMessage(s);
					
					demo.loadedTree.setRoot(newNode);
					loadTree(reader, demo);
					
				}
				else if(s!=null){
					if(demo.loadedTree.getRoot().getLeft()==null&&demo.loadedTree.getRoot().getMiddle()==null&&demo.loadedTree.getRoot().getRight()==null){
							int i = 0;
							int count=1;
							s=reader.readLine();
							while(i<count){
								if(s.length()>1){
									loadTree(reader,demo);
									i++;
									
									}
								
								else if(s.length()==1){
									TreeNode set = new TreeNode();
									set.setSelection(s);
									s= reader.readLine();
									set.setName(s);
									s=reader.readLine();
									set.setMessage(s);
									s=reader.readLine();
									demo.setLoaded(true);
									
											if(demo.loadedTree.getRoot().getLeft()==null){
												set.setParent(demo.loadedTree.getRoot().getName());
												demo.loadedTree.getRoot().setLeft(set);
											}
											
											else if(loadedTree.getRoot().getMiddle()==null){
												set.setParent(demo.loadedTree.getRoot().getName());
												demo.loadedTree.getRoot().setMiddle(set);
											}
											else if(loadedTree.getRoot().getRight()==null){
												set.setParent(demo.loadedTree.getRoot().getName());
												demo.loadedTree.getRoot().setRight(set);
												
											}
										
								 }
							}
						}	
					}
				String finder = s.substring(0, s.length()-2);
				String selection = s;
				
				TreeNode test = demo.loadedTree.selectionFind(s.substring(0, s.length()-2));
				if(s.contains(" ")){
					s=reader.readLine();
				}
				if(s==null){
					return;
				}
				if(demo.loadedTree.selectionFind(s.substring(0, s.length()-2))!=null){
					
					 if(demo.loadedTree.selectionFind(s.substring(0, s.length()-2)).getLeft()==null
							||demo.loadedTree.selectionFind(s.substring(0, s.length()-2)).getMiddle()==null
							||demo.loadedTree.selectionFind(s.substring(0, s.length()-2)).getRight()==null){
						
						
						int i = 0;
						int count=1;
							while(i<count){
								
								
								 if(s.length()>1){
									
									 TreeNode abc = new TreeNode();
									abc.setSelection(s);
									s= reader.readLine();
									abc.setName(s);
									s=reader.readLine();
									abc.setMessage(s);
											if(demo.loadedTree.selectionFind(finder).getLeft()==null){
												abc.setParent(demo.loadedTree.selectionFind(finder).getName());
												demo.loadedTree.selectionFind(finder).setLeft(abc);
												i++;
												loadTree(reader,demo);
												}
											else if(demo.loadedTree.selectionFind(finder).getMiddle()==null){
												abc.setParent(demo.loadedTree.selectionFind(finder).getName());
												demo.loadedTree.selectionFind(finder).setMiddle(abc);
												loadTree(reader, demo);
												i++;
											}
											else if(demo.loadedTree.selectionFind(finder).getRight()==null){
												abc.setParent(demo.loadedTree.selectionFind(finder).getName());
												demo.loadedTree.selectionFind(finder).setRight(abc);
												loadTree(reader, demo);
												i++;
											}
								 }
							}
					}
				 }
				
		 }
		
			
		
		}
		
	
	public static void main(String[] args) {
		Kiosk demo = new Kiosk();
		System.out.print(intro);
		System.out.println();
		System.out.print("Enter command: ");
		Scanner input = new Scanner(System.in);
		char choice = input.nextLine().toUpperCase().charAt(0);
		boolean test = false;
		while(!test){
			try {
				kioskManager(choice,demo);
				test= true;
			} catch (IOException e) {
				System.out.println("Invalid command: ");
				
			}
			catch(IllegalArgumentException e){
				System.out.println("Invalid input: ");
			}
		}
	}
	
		
		

	}


