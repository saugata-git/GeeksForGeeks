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
       int res=0;
   void longestConsecutiveUtil(Node root,int curLength,int expected){
       

          
           if(root==null)
             return ;

           if(root.data==expected){
              curLength++;
           }
           else
             curLength=1;
          
           res=Math.max(res,curLength);
           

           longestConsecutiveUtil(root.left,curLength,root.data+1);
           longestConsecutiveUtil(root.right,curLength,root.data+1);
         }
     int longestConsecutive(Node root){

         if(root==null)
           return 0;
        
          longestConsecutiveUtil(root,0,root.data);
           return res;
         
       }
       public static void main(String args[]){ 
		BinaryTree tree = new BinaryTree(); 

		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(2); 
		tree.root.left.left = new Node(3); 
		
            System.out.println(tree.longestConsecutive(tree.root));
		 
	} 
} 
