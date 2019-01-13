Time Complexity: O(h) where h is height of tree.

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
		    Node temp = null;
	            if (data <= node.data) { 
		     node.left = insert(node.left, data); 		     
		    } 
                    else { 
	       	     node.right  = insert(node.right, data); 
		    } 

	      return node; 
		} 
	    } 

    Node minValue(Node node) { 
        Node current = node; 
        while (current.left != null) { 
            current = current.left; 
        } 
        return current; 
    } 
  

     Node inOrderSuccessor(Node root, Node n) 
     { 
    
       if( n.right != null ) 
           return minValue(n.right); 
  
       Node succ = null; 
  
     
      while (root != null) 
      { 
        if (n.data < root.data) 
        { 
            succ = root; 
            root = root.left; 
        } 
        else if (n.data > root.data) 
            root = root.right; 
        else
           break; 
    } 
  
    return succ; 
   } 

public static void main(String[] args) { 
		BST tree = new BST(); 
		Node root = null, temp = null, suc = null, min = null; 
		root = tree.insert(root, 20); 
		root = tree.insert(root, 8); 
		root = tree.insert(root, 22); 
		root = tree.insert(root, 4); 
		root = tree.insert(root, 12); 
		root = tree.insert(root, 10); 
		root = tree.insert(root, 14); 
		temp = root.left.right.right; 
		suc = tree.inOrderSuccessor(root, temp); 
		if (suc != null) { 
			System.out.println("Inorder successor of " + temp.data + " is " + suc.data); 
													
		} else { 
			System.out.println("Inorder successor does not exist"); 
		} 
	} 
} 
