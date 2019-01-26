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
	
       void printSingles(Node node){
        
        if(node==null)
          return;
        if(node.left!=null && node.right!=null){
            printSingles(node.left);
            printSingles(node.right);
        }
        
        else if(node.right!=null){
              System.out.println(node.right.data + " ");
               printSingles(node.right);
        }
        
         else if(node.left!=null){
              System.out.println(node.left.data + " ");
               printSingles(node.left);
        }

       } 


       public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 

		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.right = new Node(4); 
		tree.root.right.left = new Node(5); 
		tree.root.right.left.right = new Node(6); 
		tree.printSingles(tree.root); 
	} 
} 
