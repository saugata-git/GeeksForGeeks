//Time Complexity: O(n) where n is the number of nodes in binary tree.
class Node { 
	int data; 
	Node left, right; 

	Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class BinaryTree { 
	Node root; 


	void printLeaves(Node node) 
	{ 
		if (node != null) { 
			printLeaves(node.left); 
			if (node.left == null && node.right == null) 
				System.out.print(node.data + " "); 
			printLeaves(node.right); 
		} 
	} 

	void printBoundaryLeft(Node node) 
	{ 
		if (node != null) { 
			if (node.left != null) { 	
				System.out.print(node.data + " "); 
				printBoundaryLeft(node.left); 
			} 
			else if (node.right != null) { 
				System.out.print(node.data + " "); 
				printBoundaryLeft(node.right); 
			} 
		} 
	} 

	
	void printBoundaryRight(Node node) 
	{ 
		if (node != null) { 
			if (node.right != null) { 
				printBoundaryRight(node.right); 
				System.out.print(node.data + " "); 
			} 
			else if (node.left != null) { 
				printBoundaryRight(node.left); 
				System.out.print(node.data + " "); 
			} 
			
		} 
	} 

	
	void printBoundary(Node node) 
	{ 
		if (node != null) { 
			System.out.print(node.data + " "); 

			// Print the left boundary in top-down manner. 
			printBoundaryLeft(node.left); 

			// Print all leaf nodes 
			printLeaves(node.left); 
			printLeaves(node.right); 

			// Print the right boundary in bottom-up manner 
			printBoundaryRight(node.right); 
		} 
	} 

	
	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(20); 
		tree.root.left = new Node(8); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(12); 
		tree.root.left.right.left = new Node(10); 
		tree.root.left.right.right = new Node(14); 
		tree.root.right = new Node(22); 
		tree.root.right.right = new Node(25); 
		tree.printBoundary(tree.root); 
	} 
} 
