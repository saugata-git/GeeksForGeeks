import java.util.*;

class Node 
{ 
	String data; 
	Node left, right; 

	Node(String item) 
	{ 
		data = item; 
		left = right; 
	} 
} 

class BinaryTree 
{ 
	Node root;

       
    int toInt(String str){
        int num=0,i=0;
        while( i < str.length()) {
        num *= 10;
        num += str.charAt(i++) - '0'; 
        }
       return num;
      }
        

       public int evalTree(Node root)
       {
          if(root==null)
          return 0;
          if(root.left==null && root.right==null)
          {
            //  return Integer.parseInt(root.data);
            return toInt(root.data);
          }
          int left=evalTree(root.left);
          int right=evalTree(root.right);
          if(root.data.equals("+"))
          {
             return left+right;
          }
          if(root.data.equals("-"))
          {
              return left-right;
          }
          if(root.data.equals("*"))
          {
           return left*right;
          }
          return left/right;
       }


	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		
		 
		tree.root = new Node("+"); 
                tree.root.left = new Node("*"); 
                tree.root.left.left = new Node("5"); 
                tree.root.left.right = new Node("4"); 
                tree.root.right = new Node("-"); 
                tree.root.right.left = new Node("100"); 
                tree.root.right.right = new Node("20"); 
              
                System.out.println(tree.evalTree(tree.root));
		
	} 
} 
