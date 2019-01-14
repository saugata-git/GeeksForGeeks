//Print Common Nodes in Two Binary Search Trees

import java.util.*;
class Node { 
  
    int key; 
    Node left, right; 
  
    Node(int d) { 
        key = d; 
        left = right = null; 
    } 
} 
  
public class bst { 
      
    static Node root1,root2; 
    
    static void printCommon(Node root1, Node root2) 
    { 
	Stack<Node> stack1 = new Stack<Node> (); 
	Stack<Node> s1 = new Stack<Node> (); 
	Stack<Node> s2 = new Stack<Node> (); 

	while (true) 
	{ 
		// push the Nodes of first tree in stack s1 
		if (root1 != null) 
		{ 
			s1.push(root1); 
			root1 = root1.left; 
		} 

		// push the Nodes of second tree in stack s2 
		else if (root2 != null) 
		{ 
			s2.push(root2); 
			root2 = root2.left; 
		} 

		// Both root1 and root2 are NULL here 
		else if (!s1.isEmpty() && !s2.isEmpty()) 
		{ 
			root1 = s1.peek(); 
			root2 = s2.peek(); 

			// If current keys in two trees are same 
			if (root1.key == root2.key) 
			{ 
				System.out.print(root1.key + " "); 
				s1.pop(); 
				s2.pop(); 

				// move to the inorder successor 
				root1 = root1.right; 
				root2 = root2.right; 
			} 

			else if (root1.key < root2.key) 
			{ 
				// If Node of first tree is smaller, than that of 
				// second tree, then its obvious that the inorder 
				// successors of current Node can have same value 
				// as that of the second tree Node. Thus, we pop 
				// from s2 
				s1.pop(); 
				root1 = root1.right; 

				// root2 is set to NULL, because we need 
				// new Nodes of tree 1 
				root2 = null; 
			} 
			else if (root1.key > root2.key) 
			{ 
				s2.pop(); 
				root2 = root2.right; 
				root1 = null; 
			} 
		} 

		// Both roots and both stacks are empty 
		else break; 
	} 
} 

    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
        printInorder(node.left); 
        System.out.print(node.key + " ");     
        printInorder(node.right); 
    } 
  
    public static void main(String[] args) { 
        bst tree = new bst(); 
      
        tree.root1 = new Node(20); 
        tree.root1.left = new Node(8); 
        tree.root1.right = new Node(22); 
        tree.root1.left.left = new Node(4); 
        tree.root1.left.right = new Node(12); 
       
        tree.root2 = new Node(21); 
        tree.root2.left = new Node(8); 
        tree.root2.right = new Node(18); 
        tree.root2.left.left = new Node(4); 
        tree.root2.left.right = new Node(11);
        tree.printInorder(root1);
        System.out.println();
        tree.printInorder(root2);
        System.out.println();
        
      

	printCommon(root1, root2); 
    } 
} 
