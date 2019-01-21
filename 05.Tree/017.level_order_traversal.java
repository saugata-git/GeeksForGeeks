
// Iterative Queue based Java program to do level order traversal 

import java.util.Queue; 
import java.util.LinkedList; 


class Node { 
	int data; 
	Node left, right; 

	public Node(int item) { 
		data = item; 
		left = null; 
		right = null; 
	} 
} 


class BinaryTree { 

	Node root; 

       void printLevelOrder(){
           Queue<Node>q= new LinkedList<Node>();
           q.add(root);
           while(!q.isEmpty()){
               Node temp=q.poll();
               System.out.print(temp.data+" ");

               if(temp.left!=null){
                q.add(temp.left);
               }
               if(temp.right!=null){
                q.add(temp.right);
               }
           }
       }

	public static void main(String args[]) 
	{ 
		
		BinaryTree tree_level = new BinaryTree(); 
		tree_level.root = new Node(1); 
		tree_level.root.left = new Node(2); 
		tree_level.root.right = new Node(3); 
		tree_level.root.left.left = new Node(4); 
		tree_level.root.left.right = new Node(5); 

		System.out.println("Level order traversal of binary tree is - "); 
		tree_level.printLevelOrder(); 
	} 
} 
