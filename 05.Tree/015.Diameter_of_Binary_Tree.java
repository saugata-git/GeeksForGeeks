/*
Diameter of a tree can be calculated by only using the height function, because the diameter of a tree is nothing but
maximum value of (left_height + right_height + 1) for each node. So we need to calculate this value
(left_height + right_height + 1) for each node and update the result. Time complexity – O(n)
*/

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
        static class A 
        { 
	int ans = Integer.MIN_VALUE; 
        } 

       static int diameter(Node root) 
       { 
	if (root == null) 
		return 0; 
	A a = new A(); 
	int height_of_tree = height(root, a); 
	return a.ans; 
        } 
	  
        static int height(Node root, A a) 
        { 
	 if (root == null) 
		return 0; 
	int left_height = height(root.left, a); 
	int right_height = height(root.right, a); 
	a.ans = Math.max(a.ans, 1 + left_height + right_height); 
	return 1 + Math.max(left_height, right_height); 
        } 

	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		Node root = new Node(1); 
	        root.left = new Node(2); 
	        root.right = new Node(3); 
	        root.left.left = new Node(4); 
	        root.left.right = new Node(5); 
	       System.out.println("Diameter is " + diameter(root)); 
	} 
} 
