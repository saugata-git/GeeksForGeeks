// Java program to convert binary tree into its mirror 
//T(n)=O(n),S(n)=O(1)
class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class BinaryTree 
{ 
	Node root; 

	
	Node mirror(Node node) 
	{ 
		if (node == null) 
			return node; 
		Node left = mirror(node.left); 
		Node right = mirror(node.right); 

		node.left = right; 
		node.right = left; 

		return node; 
	} 

	
	void inOrder(Node node) 
	{ 
		if (node == null) 
			return; 

		inOrder(node.left); 
		System.out.print(node.data + " "); 
		inOrder(node.right); 
	} 

	
	public static void main(String args[]) 
	{ 
		
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		/* print inorder traversal of the input tree */
		System.out.println("Inorder traversal of input tree is :"); 
		tree.inOrder(tree.root); 
		System.out.println(""); 

		/* convert tree to its mirror */
		tree.mirror(tree.root); 

		/* print inorder traversal of the minor tree */
		System.out.println("Inorder traversal of binary tree is : "); 
		tree.inOrder(tree.root); 

	} 
} 
