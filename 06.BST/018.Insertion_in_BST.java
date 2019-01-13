class Node { 

	int data; 
	Node left, right; 

	Node(int d) { 
		data = d; 
		left = right = null; 
	} 
} 
class BST{
  
        Node insert(Node node, int data) {
 
		if (node == null) { 
		    return (new Node(data)); 
		} 
               else{ 
		    
	            if (data <= node.data) { 
		     node.left = insert(node.left, data); 		     
		    } 
                    else { 
	       	     node.right  = insert(node.right, data); 
		    } 

	      return node; 
		} 
	    } 
   public void Inorder(Node node){
      if (node == null) 
            return; 
      Inorder(node.left);
      System.out.print(node.data+" ");
      Inorder(node.right);

    }
   

     
public static void main(String[] args) { 
		BST tree = new BST(); 
		Node root = null; 
		root = tree.insert(root, 20); 
		root = tree.insert(root, 8); 
		root = tree.insert(root, 22); 
		root = tree.insert(root, 4); 
		root = tree.insert(root, 12); 
		root = tree.insert(root, 10); 
		root = tree.insert(root, 14); 
		
	        System.out.println("Inorder Traversal: "); 
                tree.Inorder(root);
		} 
	} 

