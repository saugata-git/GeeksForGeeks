// Java program to print all the node to leaf path 

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
class Node 
{ 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class BinaryTree 
{ 
	Node root; 
	
	
	void printPaths(Node node) 
	{ 
		int path[] = new int[1000]; 
		printPathsRecur(node, path, 0); 
	} 

	
	void printPathsRecur(Node node, int path[], int pathLen) 
	{ 
		if (node == null) 
			return; 

		path[pathLen] = node.data; 
		pathLen++; 

		
		if (node.left == null && node.right == null) 
			printArray(path, pathLen); 
		else
		{ 
			
			printPathsRecur(node.left, path, pathLen); 
			printPathsRecur(node.right, path, pathLen); 
		} 
	} 

	
	void printArray(int ints[], int len) 
	{ 
		int i; 
		for (i = 0; i < len; i++) 
		{ 
			System.out.print(ints[i] + " "); 
		} 
		System.out.println(""); 
	} 

	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(2); 
		tree.root.left.left = new Node(3); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(2); 
		
		
		tree.printPaths(tree.root); 
	} 
} 


