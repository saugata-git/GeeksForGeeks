import java.util.*;
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


	int res = Integer.MIN_VALUE;
    
       void maxDiff(Node root1)
        { 
          maxDiffUtil(root1);
          System.out.println(res);
          
         }
    
       int maxDiffUtil(Node root1) {
                         
               /* Returning Maximum int value if node is not there (one child case)  */
              if(root1 == null)
                 return Integer.MAX_VALUE;

               /* If leaf node then just return node's value  */
              if(root1.left == null && root1.right == null)
                 return root1.data;
            
              /* Recursively calling left and right subtree  for minimum value  */
               int val = Math.min(maxDiffUtil(root1.left), maxDiffUtil(root1.right));
            
              /* Updating res if (node value - minimum valuefrom subtree) is bigger than res  */
              res = Math.max(res, root1.data - val);

              /* Returning minimum value got so far */
             return Math.min(val, root1.data);
      }
      
       public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
                 
		tree.root = new Node(8); 
                tree.root.left = new Node(10); 
                
        tree.root.right = new Node(16); 
      
                tree.maxDiff(tree.root);
	} 
} 
