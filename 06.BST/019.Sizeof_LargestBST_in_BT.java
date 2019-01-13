//Time Complexity : O(n)
import java.util.*;

class Node { 
  
    int data; 
    Node left, right; 
  
    Node(int d) { 
        data = d; 
        left = right = null; 
    } 
} 
class Quad{
     boolean isBst;int min;int max;int size;
     Quad(boolean isBst,int min,int max,int size){
     this.isBst=isBst;
     this.min=min;
     this.max=max;
     this.size=size;
     }
}
class BST{
     static Node root; 
    static int res=0;
    private  Quad largestBST(Node root){
       if(root==null)
         return new Quad(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);

      Quad left=largestBST(root.left);
      Quad right=largestBST(root.right);
      if(left.isBst==false||right.isBst==false|| left.max>root.data||right.min<root.data){
          return new Quad(false,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
      }
      res=Math.max(res,left.size + right.size + 1);
      return new Quad(true,Math.min(root.data,left.min),Math.max(root.data,right.max),left.size+right.size+1);
    }







public static void main(String args[]) { 
        /* Let us construct the following Tree 
                50 
             /      \ 
            10        60 
           /  \       /  \ 
          5   20    55    70 
         /     /  \ 
        45   65    80 
         */
  
        BST tree = new BST(); 
        
        tree.root = new Node(50); 
        tree.root.left = new Node(10); 
        tree.root.right = new Node(60); 
        tree.root.left.left = new Node(5); 
        tree.root.left.right = new Node(20); 
        tree.root.right.left = new Node(55); 
        tree.root.right.left.left = new Node(45); 
        tree.root.right.right = new Node(70); 
        tree.root.right.right.left = new Node(65); 
        tree.root.right.right.right = new Node(80); 
  
        /* The complete tree is not BST as 45 is in right subtree of 50. 
         The following subtree is the largest BST 
             60 
            /  \ 
          55    70 
          /     /  \ 
        45     65   80 
        */
        tree.largestBST(root);
        System.out.println("Size of largest BST is " + res); 
    } 
} 
