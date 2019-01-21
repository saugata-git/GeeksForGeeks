/* Java implementation to find minimum depth 
of a given Binary tree */


class Node { 
	int data; 
	Node left, right; 

	public Node(int item) { 
		data = item; 
		left = right = null; 
	} 
} 

public class BinaryTree{ 
	
	Node root; 

	int minimumDepth() { 
		return minimumDepth(root,0); 
	} 

	int minimumDepth(Node node ,int level){

               if(node==null)
                  return level;
               level++;
               return Math.min(minimumDepth(node.left , level),minimumDepth(node.right, level)) ;
        }

	
	public static void main(String args[]) { 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 

		System.out.println("The minimum depth of " + "binary tree is : " + tree.minimumDepth()); 
	} 
} 
