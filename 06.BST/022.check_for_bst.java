//Time Complexity: O(n)
import java.util.*;
class Node { 
  
    int data; 
    Node left, right; 
  
    Node(int d) { 
        data = d; 
        left = right = null; 
    } 
} 
  
public class bst { 
	
	Node root; 
	Node prev; 
        boolean isBST() { 
		prev = null; 
		return isBST(root); 
	}
        boolean isBST(Node node){
        if(node!=null){
              if(!isBST(node.left))
                return false;
               if(prev!=null && node.data<=prev.data)
                 return false;
               prev=node;
              return isBST(node.right);
        }
        return true;

        } 
	
	
	public static void main(String args[]) 
	{ 
		bst tree = new bst(); 
		tree.root = new Node(4); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(5); 
		tree.root.left.left = new Node(1); 
		tree.root.left.right = new Node(3); 

		if (tree.isBST()) 
			System.out.println("IS BST"); 
		else
			System.out.println("Not a BST"); 
	} 
} 

