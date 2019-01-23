//Time complexity of above solution is O(n) where n is total number of nodes in given binary tree

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
	
	void  printExtremeNodes(Node node){
           
         if(node==null)
          return;
          Queue<Node>q= new LinkedList<Node>();
          q.add(node);
          boolean flag=false;
          while(!q.isEmpty()){

               int nodeCount=q.size();
               int n=nodeCount;
               while(n-->0){
                 Node curr =q.peek();
                 
                 if(curr.left!=null)
                   q.add(curr.left);
                 if(curr.right!=null)
                   q.add(curr.right);
                  
                 q.remove();
                
                if(flag && n ==nodeCount-1)
                  System.out.println(curr.data);
                if(!flag && n==0)
                  System.out.println(curr.data);
               }
               flag=!flag;
          }


        }
	
	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(10); 
		tree.root.left = new Node(8); 
		tree.root.right = new Node(2); 
		tree.root.left.left = new Node(3); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(2); 
		
		tree.printExtremeNodes(tree.root);  
	} 
} 


