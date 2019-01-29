import java.io.*;
import java.util.*;

class Node{
     int data;
     Node left,right;
     Node(int key){
       data=key;
       left=right=null;
     }
}

class BinaryTree{
    
      static void diagonalPrint(Node root){

          if(root==null)
            return;
          Queue<Node>q= new LinkedList<Node>();
            q.add(root);
            q.add(null);
         while(q.size()>0){

            Node temp=q.peek();
            q.remove();

            if(temp==null){
                if(q.size()==0)
                 return;
                System.out.println();
                q.add(null);
            }
           else{
              while(temp!=null){
               System.out.print(temp.data+" ");
               if(temp.left!=null)
                 q.add(temp.left);
               temp=temp.right;

               }
           }
         }
      }
        
      public static void main(String args[]) 
      { 
             Node root = new Node(1); 
              
             root.left = new Node(2); 
             root.right = new Node(3); 
           
             diagonalPrint(root);
   
       } 
}
