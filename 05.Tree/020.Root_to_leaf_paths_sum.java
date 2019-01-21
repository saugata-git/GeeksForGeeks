// Java program to find sum of all numbers that are formed from root  to leaf paths  A binary tree node 
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

	
	int treePathsSumUtil(Node node, int val) 
	{ 
		
		if(node==null) 
                  return 0;
                val=val*10+node.data;
                 
                if(node.left==null && node.right==null)
                 return val; 

                return treePathsSumUtil(node.left,val)+treePathsSumUtil(node.right,val);
	} 

	int treePathsSum(Node node) 
	{ 
		
		return treePathsSumUtil(node, 0); 
	} 

	
	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(6); 
		tree.root.left = new Node(3); 
		tree.root.right = new Node(5); 
		tree.root.right.right = new Node(4); 
		tree.root.left.left = new Node(2); 
		tree.root.left.right = new Node(5); 
		tree.root.left.right.right = new Node(4); 
		tree.root.left.right.left = new Node(7); 
		
		System.out.print("Sum of all paths is " + tree.treePathsSum(tree.root)); 
	}	 
} 


