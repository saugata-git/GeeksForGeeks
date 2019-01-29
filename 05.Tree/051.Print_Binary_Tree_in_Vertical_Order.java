// Java program for printing vertical order of a given binary tree 
//T(n)=O(nlogn)

import java.util.TreeMap; 
import java.util.Vector; 
import java.util.Map.Entry; 

public class BinaryTree
{ 
	
	static class Node 
	{ 
		int key; 
		Node left; 
		Node right; 
		Node(int data) 
		{ 
			key = data; 
			left = null; 
			right = null; 
		} 
	} 

	static void getVerticalOrder(Node root,int hd,TreeMap<Integer,Vector<Integer>>m){

         if(root==null)
          return;
         Vector<Integer> get=m.get(hd); 
         if(get==null){
          get= new Vector<>();
          get.add(root.key);
         }
        else
          get.add(root.key);

        m.put(hd,get);
        getVerticalOrder(root.left,hd-1,m);
        getVerticalOrder(root.right,hd+1,m);
        }

        static void printVerticalOrder(Node root){

         TreeMap<Integer,Vector<Integer>>m= new TreeMap<>();
         int hd=0;
         getVerticalOrder(root,hd,m); 
         for(Entry<Integer,Vector<Integer>> entry:m.entrySet()){
           System.out.println(entry.getValue());
         }

        }
	public static void main(String[] args) { 

		
		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(3); 
		root.left.left = new Node(4); 
		root.left.right = new Node(5); 
		root.right.left = new Node(6); 
		root.right.right = new Node(7); 
		root.right.left.right = new Node(8); 
		root.right.right.right = new Node(9); 
		System.out.println("Vertical Order traversal is"); 
		printVerticalOrder(root); 
	} 
} 
/*
// Java program to print binary tree in reverse order 
//Time Complexity: Time complexity of above algorithm is O(w*n) where w is width of Binary Tree and n is number of nodes in Binary Tree.
// In worst case, the value of w can be O(n) (consider a complete tree for example) and time complexity can become O(n2).
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

class Values 
{ 
	int max, min; 
} 

class BinaryTree 
{ 
	Node root; 
	Values val = new Values(); 
        
        void findMinMax(Node node,Values min,Values max,int hd){
           if(node==null)
             return;
           if(hd<min.min)
             min.min=hd;
           else if(hd>max.max)
             max.max=hd;

            findMinMax(node.left,min,max,hd-1);
            findMinMax(node.right,min,max,hd+1);
        } 
       
        void printVerticalLine(Node node,int line_no,int hd){
              if(node==null)
                  return ;
              if(hd==line_no)
                System.out.print(node.data+" ");
              printVerticalLine(node.left,line_no,hd-1);
              printVerticalLine(node.right,line_no,hd+1);

        } 
        
        void verticalOrder(Node node){
          findMinMax(node,val,val,0);
          for(int line_no=val.min;line_no<=val.max;line_no++){
            printVerticalLine(node,line_no,0);
            System.out.println(" ");

           }
        }

	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 
		tree.root.right.left.right = new Node(8); 
		tree.root.right.right.right = new Node(9); 

		System.out.println("vertical order traversal is :"); 
		tree.verticalOrder(tree.root); 
	} 
} 




*/
