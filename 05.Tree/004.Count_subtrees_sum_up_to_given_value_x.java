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
        int count = 0;
        int countSubtreesWithSumX(Node root, int x)
        {
	     
	    sumAndCheck(root, x);
	    return count;
        }
    
        int sumAndCheck(Node root, int x) {
           if(root == null) {
              return 0;
            }
        
           int left = sumAndCheck(root.left, x);
           int right = sumAndCheck(root.right, x);
           int subtreeSum = left + right + root.data;
           if(subtreeSum == x) {
              ++count;
            }
          return subtreeSum;
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
		tree.root = new Node(5); 
		tree.root.left = new Node(-10); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(9); 
		tree.root.left.right = new Node(8); 
                tree.root.right.left = new Node(-4); 
		tree.root.right.right = new Node(7); 

		
		System.out.println("Inorder traversal of input tree is :"); 
		tree.inOrder(tree.root);
                System.out.println();
                System.out.println(tree.countSubtreesWithSumX(tree.root,7));
         }
} 
