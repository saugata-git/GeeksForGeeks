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
	
       static int kLeaves(Node ptr,int k)  
       {  
          
          if(ptr == null)  
            return 0;  
          if (ptr.left == null && ptr.right == null)  
            return 1;  
  
    
          int total = kLeaves(ptr.left, k) + kLeaves(ptr.right, k);  
  
      
          if (k == total)  
              System.out.print(ptr.data + " ");  
  
         return total;  
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
		
                kLeaves(tree.root, 2);  
	} 
} 
