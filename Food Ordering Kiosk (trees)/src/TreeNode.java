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
public class TreeNode {
	private String name;
	private String selection;
	private String message;
	private TreeNode left;
	private TreeNode middle;
	private TreeNode right;
	private String parent;
	
	/**
	 * Sets the name of a node to one found in the text file
	 * @param name
	 */
	public void setName(String name){
		this.name= name;
	}
	/**
	 * Returns the name of the node
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Sets the  slection of a node to one found in the txt file
	 * @param selection
	 */
	public void setSelection(String selection){
		this.selection = selection;
	}
	
	/**
	 * Returns the selection
	 * @return
	 */
	public String getSelection(){
		return selection;
	}
	/**
	 * Sets the message of a string to one found in the txt file
	 * @param message
	 */
	public void setMessage(String message){
		this.message = message;
	}
	
	
	public String getMessage(){
		return message;
	}
	
	
	public void setLeft(TreeNode left){
		this.left = left;
	}
	
	public TreeNode getLeft(){
		return left;
	}
	
	public void  setMiddle(TreeNode middle){
		this.middle = middle;
	}
	
	public TreeNode getMiddle(){
		return middle;
	}
	
	public void setRight(TreeNode right){
		this.right = right;
	}
	
	public TreeNode getRight(){
		return right;
	}
	
	public void setParent(String parent){
		this.parent=parent;
	}
	
	public String getParent(){
		return parent;
	}
	/**
	 * Check to see if the node is a leaf by seeing if the left middle and 
	 * right values are  null
	 * @return true if all are null, false if not null
	 */
	public boolean isLeaf(){
		if(left==null&&right==null&middle==null){
			return  true;
		}
		else 
			return false;
	}
	
	

}
