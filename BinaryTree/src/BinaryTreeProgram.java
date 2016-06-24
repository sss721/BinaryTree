import java.util.Scanner;

class Node{
	int data;
	Node left , right ;
	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

class BinaryTreeProgram {
	public static Node root;
	
	public BinaryTreeProgram(){
		this.root = null;
	}
	
	// Insert New values in tree
	public void insert(int id){
		Node newNode = new Node(id);
		if(root == null)
		{
			root = newNode;
			return;
		}
		
		Node current = root;
		Node parent = null;
		
		while(true)
		{	
			parent = current;
			if(id < current.data)
			{	
				current = current.left;
				if(current == null)
				{
				parent.left = newNode;
				return;
				}
			}
			else
			{
				current = current.right;
				if(current == null)
				{
					parent.right = newNode;
					return;
				}
				
			}
		}
		
		
	}
	
	// Search Value in tree
	public boolean search(int id)
	{
		Node current = root;
		while(current!= null)
		{
			if(current.data == id)
			{
				return true;
			}
			else if (current.data < id)
			{
				current = current.right;
			}
			else
			{
				current = current.left;
			}
			
		}
		return false;
	}
	
	//Delete a value 
	public boolean delete(int id)
	{
		Node current = root;
		Node parent = root;
		boolean isLeft = false; 
		
		if(current == null)
		{
			return false;
		}
		else{
		
		while(current.data!= id)
		{   
			parent = current;
		
			if(current.data>id){
				isLeft = true;
				current = current.left;
			}else{
				isLeft = false;
				current = current.right;
			}
			if(current == null){
				return false;
			}
		}
		}
		
		if(current.left == null && current.right == null)
		{
			if(current == root)
			{
				root = null;
			}
			if(isLeft == false)
			{
				parent.right = null;
			}
			if(isLeft == true)
			{
				parent.left = null;
			}
		}
		
		else if(current.left == null)
		{
			if(current == root)
			{
				root = null;
			}
			else if(isLeft)
			{
				parent.left = current.right;
			}
			else
			{
				parent.right = current.right;
			}
		}
		else if (current.right == null)
		{
			if(current == root)
			{
				root = null;
			}
			else if(isLeft)
			{
				parent.left = current.left;
			}
			else
			{
				parent.right = current.left;
			}
		}
		else if(current.right!=null && current.left!= null)
		{
			Node successor = getSuccessor(current);
			if(current == root)
			{
				root = successor;
			}
			else if(isLeft)
			{
				parent.left = successor;
			}
			else
			{
				parent.right = successor;
			}
			successor.left = current.left;
		}
		
		return true;
	}
	

	Node getSuccessor(Node delNode)
	{	Node successor = null;
		Node successorParent = null;
		Node current = delNode.right;
		while(current!=null)
		{	
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		if(successor.right!= null)
		{
			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		
	
		return successor;
	}
	
	public void inOrder(Node root)
	{
		
		if(root!=null)
		{
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
		
	}
	
	public void preOrder(Node root)
	{
		if(root != null) 
		{
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void postOrder(Node root)
	{
		if(root != null)
		{
			
			preOrder(root.left);
			preOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	


public static void main(String[] args){
	BinaryTreeProgram bst = new BinaryTreeProgram();
	Scanner scan = new Scanner(System.in);
	char ch;
	do{  
	System.out.println("\nBinary Search Tree Operations\n");
    System.out.println("1. insert ");
    System.out.println("2. delete");
    System.out.println("3. search");
    System.out.println("4. Inorder");
    System.out.println("5. Preorder");
    System.out.println("6. Postorder");



    int choice = scan.nextInt();            
    switch (choice)
    {
    case 1 : 
        System.out.println("Enter integer element to insert");
        bst.insert( scan.nextInt() );                     
        break;
        
    case 2 :
    	 System.out.println("Enter integer element to delete");
         System.out.println("Item deletion status : " + bst.delete( scan.nextInt()) );                     
         break;
    	
        
    case 3 :
    	System.out.println("Enter integer element to search");
        System.out.println("Is Present : " + bst.search( scan.nextInt() ));                     
        break;
        
    case 4 : 
    	System.out.println("Inorder : ");
    	bst.inOrder(bst.root);
    	System.out.println("\n");
    	break;
    
    case 5 :
    	System.out.println("Preorder : ");
    	bst.preOrder(bst.root);
    	System.out.println("\n");
    	break;
    	
    case 6 : 
    	System.out.println("Postorder : ");
    	bst.postOrder(bst.root);
    	System.out.println("\n");
    	break;
        
    default : 
        System.out.println("Wrong Entry \n ");
        break; 
    }
        
		System.out.println("Do you want to continue ");
		ch = scan.next().charAt(0);
	
	
	}while(ch == 'Y' || ch == 'y');
	}
	
	
}

