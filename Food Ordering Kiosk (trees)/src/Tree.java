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
import java.util.Scanner;


public class Tree {
	private TreeNode root;
	private TreeNode nodePtr;
	public String message="";
	public String price;
	public String location;
	public TreeNode left;
	public TreeNode middle;
	public TreeNode right;
	public Tree(){
		
	}
	/**
	 * Sets the root of the node,
	 * @param root
	 */
	public void setRoot(TreeNode root){
		this.root = root;
		nodePtr = root;
	}
	
	/**
	 * Returns the root of the tree
	 * @return
	 */
	public TreeNode getRoot(){
		return root;
	}
	
	/**
	 * Find a node in a tree 
	 * @param Name
	 * @return
	 */
	public TreeNode findNode(String Name){
		TreeNode newNode = root;
		newNode = search(Name, newNode);
		if(newNode!=null)
			return newNode;
		return null;
	}
	
	/**
	 * Searches for a node in a tree recursively
	 * @param Name
	 * @param newNode
	 * @return
	 */
	public TreeNode search(String name, TreeNode newNode){
		if(newNode!= null){
			if(newNode.getName().equals(name)){
				return newNode;
			}
			else{
				TreeNode found = search(name,newNode.getLeft());
				
				if(found==null){
					found = search(name,newNode.getMiddle());
				}
				if(found==null){
					found = search(name, newNode.getRight());
				}
				return found;
			}
		} 
		else 
			return null;
		
	
	}
	/**
	 * Begins the search for a node with the selection specified
	 * @param selection
	 * @return
	 */
	public TreeNode selectionFind(String selection){
		TreeNode newNode = root;
		newNode = selectionSearch(selection, newNode);
		if(newNode!=null)
			return newNode;
		else
		return null;
	}
	
	/**
	 * Searches for a node with the selection string specified
	 * @param selection
	 * @param newNode
	 * @return
	 */
	public TreeNode selectionSearch(String selection, TreeNode newNode){
		if(newNode!= null){
			if(newNode.getSelection().equals(selection)){
				return newNode;
			}
			else{
				TreeNode found = selectionSearch(selection,newNode.getLeft());
				
				if(found==null){
					found = selectionSearch(selection,newNode.getMiddle());
				}
				if(found==null){
					found = selectionSearch(selection, newNode.getRight());
				}
				return found;
			}
		} 
		else 
			return null;
	}
	
	//selection is first in text file
	//followed by name
	//Parent name is gained from parent in the tree
	//
	/**
	 * Adds a node to the tree automatically, nodes are added automitaclly through text parsing in the kiosk tree
	 * @param name
	 * @param selection
	 * @param message
	 * @param parentName
	 * @return
	 */
	public boolean addNode(String name, String selection, String message, String parentName){
		TreeNode newNode = new TreeNode();
		newNode.setName(name);
		newNode.setSelection(selection);
		newNode.setMessage(message);
		newNode.setParent(parentName);
		
		if(findNode(parentName).getLeft()==null){
			if(selection.substring(selection.length()-1).equals("1")){
				newNode.setParent(findNode(parentName).getName());
				findNode(parentName).setLeft(newNode);
				return true;
			}
		}
		
	
		else if(findNode(parentName).getMiddle()==null){
			if(selection.substring(selection.length()-1).equals("2")){
				newNode.setParent(findNode(parentName).getName());
				findNode(parentName).setMiddle(newNode);
				return true;
			}
		}
		
		else if(findNode(parentName).getRight()==null){
			if(selection.substring(selection.length()-1).equals("3")){
				newNode.setParent(findNode(parentName).getName());
				findNode(parentName).setRight(newNode);
				return true;
			}
		}
		
		
		return false;
	}
	
	
	/**
	 * Creates the top margin of each menu
	 */
	public void printMenuBar(){
		TreeNode newNode = new TreeNode();
		String param = "%-25s %-25s %s \n";
		
		if(root.getRight()!=null&&root.getMiddle()!=null&root.getRight()!=null){
			System.out.printf(param,root.getLeft().getMessage(),root.getMiddle().getMessage(),root.getRight().getMessage());
		}
		
		else if(root.getLeft()!=null&&root.getMiddle()!=null){
				System.out.printf("%-25s %-25s %s \n",root.getLeft().getMessage(),root.getMiddle().getMessage(),"");
			}
		else if(root.getLeft()!=null){
			System.out.printf("%-25s %-50s \n",root.getLeft().getMessage(),"");
		}
		
		 
	}
	/**
	 * Prints the menu bar of a tree
	 * @param newNode
	 */
	public void printMenu(TreeNode newNode){
			
			if(newNode.getLeft()==null||newNode.getMiddle()==null||newNode.getRight()==null){
				if(newNode.getMessage().charAt(0)=='$'){
					System.out.println(newNode.getName()+ " " + newNode.getMessage());
				}
				
			}
		if(newNode.getLeft()!=null){
			if(newNode.getLeft().getLeft()!=null&&newNode.getLeft().getSelection().length()>1){
			System.out.println(newNode.getLeft().getName());
			}
			printMenu(newNode.getLeft());
		}
		if(newNode.getMiddle()!=null){
			if(newNode.getMiddle().getMiddle()!=null&&newNode.getMiddle().getSelection().length()>1){
			System.out.println(newNode.getMiddle().getName());
			}
			printMenu(newNode.getMiddle());
		}
		if(newNode.getRight()!=null){
			if(newNode.getRight().getRight()!=null&&newNode.getRight().getSelection().length()>1){
			System.out.println(newNode.getRight().getName());
			}
			printMenu(newNode.getRight());
			
		}
	}
	/**
	 * Prints the entire left side of the tree, searching recursively
	 * <dt><b>Precondition: There is a tree created </dt></b>
	 * @param newNode
	 * @param leftName The name of the left child of the root
	 */
	public void printLeftChild(TreeNode newNode, String leftName){
		if(newNode.getLeft()!=null){
			if(newNode.getLeft().getLeft()==null){
				if(newNode.getParent().equals(leftName)){
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getLeft().getName(), newNode.getLeft().getMessage());
				}
				else if(newNode.getParent().equals(root.getName())){
					if(newNode.getLeft().getLeft()==null&&newNode.getLeft().getMiddle()==null&&newNode.getLeft().getRight()==null){
						System.out.printf("%-25s %-75s %s \n", newNode.getRight().getName()," ", newNode.getRight().getMessage());

					}
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getLeft().getName(), newNode.getLeft().getMessage());
				}
				else
				System.out.printf("%-25s %-75s %s \n", findNode(newNode.getParent()).getName(),newNode.getLeft().getName(), newNode.getLeft().getMessage());
			}
			else
			printLeftChild(newNode.getLeft(), leftName);
		}
		if(newNode.getMiddle()!=null){
			if(newNode.getMiddle().getMiddle()==null){
				if(newNode.getParent().equals(leftName)){
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getMiddle().getName(), newNode.getMiddle().getMessage());
				}
				else if(newNode.getParent().equals(root.getName())){
					if(newNode.getMiddle().getLeft()==null&&newNode.getMiddle().getMiddle()==null&&newNode.getMiddle().getRight()==null){
						System.out.printf("%-25s %-75s %s \n", newNode.getRight().getName()," ", newNode.getRight().getMessage());

					}
					else
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getMiddle().getName(), newNode.getMiddle().getMessage());
				}
				else
				System.out.printf("%-25s %-75s %s \n", findNode(newNode.getParent()).getName(),newNode.getMiddle().getName(), newNode.getMiddle().getMessage());
			}
			else
			printLeftChild(newNode.getMiddle(),leftName);
		}
		if(newNode.getRight()!=null){
			if(newNode.getRight().getRight()==null){
				if(newNode.getParent().equals(leftName)){
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getRight().getName(), newNode.getRight().getMessage());
				}
				else if(newNode.getParent().equals(root.getName())){
					
						if(newNode.getRight().getLeft()==null&&newNode.getRight().getMiddle()==null&&newNode.getRight().getRight()==null){
							System.out.printf("%-25s %-75s %s \n", newNode.getRight().getName()," ", newNode.getRight().getMessage());

						}
						else
							System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getRight().getName(), newNode.getRight().getMessage());
				}
				else
				System.out.printf("%-25s %-75s %s \n", findNode(newNode.getParent()).getName(),newNode.getRight().getName(), newNode.getRight().getMessage());
			}
			else
			printLeftChild(newNode.getRight(),leftName);
		}
	}
	
	/**
	 * Recursively prints all middle children of the tree
	 * <dt><b> Precondition: There is a tree created with nodes</dt></b>
	 * @param newNode
	 * @param middleName
	 */
	public void printMiddleChild(TreeNode newNode, String middleName){
		if(newNode.getMiddle()!=null){
			if(newNode.getLeft().getLeft()==null){
				if(newNode.getParent().equals(middleName)){
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getLeft().getName(), newNode.getLeft().getMessage());
				}
				else if(newNode.getParent().equals(root.getName())){
					if(newNode.getLeft().getLeft()==null&&newNode.getLeft().getMiddle()==null&&newNode.getLeft().getRight()==null){
						System.out.printf("%-25s %-75s %s \n", newNode.getRight().getName()," ", newNode.getRight().getMessage());

					}
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getLeft().getName(), newNode.getLeft().getMessage());
				}
				else
				System.out.printf("%-25s %-75s %s \n", findNode(newNode.getParent()).getName(),newNode.getLeft().getName(), newNode.getLeft().getMessage());
			}
			else
			printLeftChild(newNode.getLeft(), middleName);
		}
		if(newNode.getMiddle()!=null){
			if(newNode.getMiddle().getMiddle()==null){
				if(newNode.getParent().equals(middleName)){
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getMiddle().getName(), newNode.getMiddle().getMessage());
				}
				else if(newNode.getParent().equals(root.getName())){
					if(newNode.getMiddle().getLeft()==null&&newNode.getMiddle().getMiddle()==null&&newNode.getMiddle().getRight()==null){
						System.out.printf("%-25s %-75s %s \n", newNode.getRight().getName()," ", newNode.getRight().getMessage());

					}
					else
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getMiddle().getName(), newNode.getMiddle().getMessage());
				}
				else
				System.out.printf("%-25s %-75s %s \n", findNode(newNode.getParent()).getName(),newNode.getMiddle().getName(), newNode.getMiddle().getMessage());
			}
			else
			printLeftChild(newNode.getMiddle(),middleName);
		}
		if(newNode.getRight()!=null){
			if(newNode.getRight().getRight()==null){
				if(newNode.getParent().equals(middleName)){
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getRight().getName(), newNode.getRight().getMessage());
				}
				else if(newNode.getParent().equals(root.getName())){
					
					
						if(newNode.getRight().getLeft()==null&&newNode.getRight().getMiddle()==null&&newNode.getRight().getRight()==null){
							System.out.printf("%-25s %-75s %s \n", newNode.getRight().getName()," ", newNode.getRight().getMessage());

						}
						else
							System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getRight().getName(), newNode.getRight().getMessage());
				}
				else
				System.out.printf("%-25s %-75s %s \n", findNode(newNode.getParent()).getName(),newNode.getRight().getName(), newNode.getRight().getMessage());
			}
			else
			printLeftChild(newNode.getRight(),middleName);
		}
	}
	/**
	 * Prints the entire right side of a tree recursively
	 * @param newNode
	 * @param rightName
	 */
	public void printRightChild(TreeNode newNode, String rightName){
		if(newNode!=null){
		if(newNode.getLeft()!=null){
			if(newNode.getLeft().getLeft()==null){
				if(newNode.getParent().equals(rightName)){
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getLeft().getName(), newNode.getLeft().getMessage());
				}
				else if(newNode.getParent().equals(root.getName())){
					if(newNode.getLeft().getLeft()==null&&newNode.getLeft().getMiddle()==null&&newNode.getLeft().getRight()==null){
						TreeNode abc = newNode;
						System.out.printf("%-25s %-75s %s \n", newNode.getLeft().getName()," ", newNode.getLeft().getMessage());

					}
					else
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getLeft().getName(), newNode.getLeft().getMessage());
				}
				else
				System.out.printf("%-25s %-75s %s \n", findNode(newNode.getParent()).getName(),newNode.getLeft().getName(), newNode.getLeft().getMessage());
			}
			else
			printLeftChild(newNode.getLeft(), rightName);
		}
		if(newNode.getMiddle()!=null){
			if(newNode.getMiddle().getMiddle()==null){
				if(newNode.getParent().equals(rightName)){
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getMiddle().getName(), newNode.getMiddle().getMessage());
				}
				else if(newNode.getParent().equals(root.getName())){
					if(newNode.getMiddle().getLeft()==null&&newNode.getMiddle().getMiddle()==null&&newNode.getMiddle().getRight()==null){
						System.out.printf("%-25s %-75s %s \n", newNode.getMiddle().getName()," ", newNode.getMiddle().getMessage());

					}
					else
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getMiddle().getName(), newNode.getMiddle().getMessage());
				}
				else
				System.out.printf("%-25s %-75s %s \n", findNode(newNode.getParent()).getName(),newNode.getMiddle().getName(), newNode.getMiddle().getMessage());
			}
			else
			printLeftChild(newNode.getMiddle(),rightName);
		}
		if(newNode.getRight()!=null){
			if(newNode.getRight().getRight()==null){
				if(newNode.getParent().equals(rightName)){
					System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getRight().getName(), newNode.getRight().getMessage());
				}
				else if(newNode.getParent().equals(root.getName())){
					
					
						if(newNode.getRight().getLeft()==null&&newNode.getRight().getMiddle()==null&&newNode.getRight().getRight()==null){
							System.out.printf("%-25s %-75s %s \n", newNode.getRight().getName()," ", newNode.getRight().getMessage());

						}
						else
							System.out.printf("%-25s %-75s %s \n", newNode.getName(),newNode.getRight().getName(), newNode.getRight().getMessage());
				}
				else
				System.out.printf("%-25s %-75s %s \n", findNode(newNode.getParent()).getName(),newNode.getRight().getName(), newNode.getRight().getMessage());
			}
			else
			printLeftChild(newNode.getRight(),rightName);
		}
	}
	}
	
	/**
	 * Sets the location of an order
	 * @param location
	 */
	public void setLocation(String location){
		this.location = location;
	}
	
	/**
	 * Returns the location of an order
	 * @return
	 */
	public String getLocation(){
		return location;
	}
	
	/**
	 * Sets the message of an order
	 * @param message
	 */
	public void setMessage(String message){
		this.message+=message;
	}
	
	/**
	 * Returns the message of an order
	 * @return
	 */
	public String getMessage(){
		return message;
	}
	
	public void setPrice(String price){
		this.price = price;
	}
	
	public String getPrice(){
		return price;
	}
	public void beginSession(){
		message="";
		price = "";
		location="";
		Scanner input = new Scanner(System.in);
		System.out.println(root.getMessage());
		if(root.getLeft()!=null){
			System.out.println("1)" + root.getLeft().getName());
		}
		if(root.getMiddle()!=null){
			System.out.println("2)" + root.getMiddle().getName());
		}
		if(root.getRight()!=null){
			System.out.println("3)" +root.getRight().getName());
		}
		System.out.println("0)Exit Session");
		System.out.print("Enter command: ");
		
		char choice = input.nextLine().charAt(0);
		switch(choice){
			case('0'):
						System.out.println("Exiting session, returning to menu");
						break;
			case('1'):
					if(root.getLeft()!=null){
						this.setLocation(root.getLeft().getName());
						traverseSession(root.getLeft());
						break;
					}
					else
						System.out.println("There is nothing here! Returning to menu");
						break;
			case('2'):
				if(root.getMiddle()!=null){
					this.setLocation(root.getMiddle().getName());
					traverseSession(root.getMiddle());
					break;
				}
				else
					System.out.println("There is nothing here! Returning to menu");
					break;
			case('3'):
				if(root.getRight()!=null){
					this.setLocation(root.getRight().getName());
					traverseSession(root.getRight());
					break;
				}
				else
					System.out.println("There is nothing here! Returning to menu");
					break;
			
		}
	}
	
	public void traverseSession(TreeNode newNode){
		
		this.left = newNode.getLeft();
		this.right=newNode.getRight();
		this.middle = newNode.getMiddle();
		
		if(left==null&&middle==null&&right==null){
			System.out.println("The order at: " + location + ", " + message + "has been sent to the kitchen. " + " The total is " + newNode.getMessage());
			return;
		}
		else{
		System.out.println(newNode.getMessage());

		if(left!=null){
			System.out.println("1) " + left.getName());
		}
		if(middle!=null){
			System.out.println("2) " + middle.getName());

		}
		if(right!=null){
			System.out.println("3) " + right.getName());

		}
		System.out.println("0) Exit Session");
		System.out.print("Enter command: ");
		
		Scanner input = new Scanner(System.in);
		char choice = input.nextLine().charAt(0);
		
		switch(choice){
			case('0'):
						System.out.println("Exiting session, returning to menu");
						break;
			case('1'):
					if(left!=null){
						if(left.getMessage().charAt(0)=='$'){
							this.setMessage(left.getName() + ", ");
							traverseSession(left);
							break;
						}
						else{
							this.setMessage(left.getName()+",");
							traverseSession(left);
							break;
						}
					}
					else
						System.out.println("There is nothing here!");
						traverseSession(newNode);
						break;
			case('2'):
				if(middle!=null){
					if(middle.getMessage().charAt(0)=='$'){
						this.setMessage(middle.getName() + ", " );
						traverseSession(middle);
						break;
					}
					else{
						this.setMessage(middle.getName()+",");
						traverseSession(middle);
						break;
					}
				}
				else
					System.out.println("There is nothing here!");
					traverseSession(newNode);
					break;
			case('3'):
				if(right!=null){
					String abc = right.getMessage();
					if(right.getMessage().charAt(0)=='$'){
						this.setMessage(right.getName() + ", ");
						traverseSession(right);
						break;
					}
					else{
						this.setMessage(right.getMessage()+",");
						traverseSession(right);
						break;
					}
				}
				else
					System.out.println("There is nothing here!");
					traverseSession(newNode);
					break;
			
		}
	}
	}
	
}
