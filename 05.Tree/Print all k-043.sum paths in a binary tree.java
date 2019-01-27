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
	
      void printVector( ArrayList<Integer> v, int i) 
       { 
          for (int j=i; j<v.size(); j++){ 
             System.out.print(v.get(j)+" ");
          } 
          System.out.println(); 
        } 


     void printKPathUtil(Node root,ArrayList<Integer> path,int k){
 
       if (root==null) 
          return; 
  
     
       path.add(root.data);  
       printKPathUtil(root.left, path, k); 
       printKPathUtil(root.right, path, k); 

       int f = 0; 
       for (int j=path.size()-1; j>=0; j--) 
       { 
          f=f+ (Integer)(path.get(j)); 
          if (f == k) 
            printVector(path, j); 
       } 
  
       path.remove(path.size()-1); 
      } 
   
       void printKPath(Node root, int k) 
       {  
           ArrayList<Integer> arr = new ArrayList<Integer>();
           printKPathUtil(root, arr, k); 
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
                int k = 11; 
                tree.printKPath(tree.root, k); 
  
		 
	} 
} 
