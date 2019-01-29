import java.io*;
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
    
        public int minLeafSum(Node root){
       
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        int sum=0;
        
        while(!q.isEmpty()){
        
            Node temp=q.remove();
            if(temp==null){
            
                if(!q.isEmpty()){
                q.add(null);
                }
                if(sum!=0){
                    break;
                }
            }
            
            else{
            
              if(temp.left!=null){
                q.add(temp.left);
              }
              if(temp.right!=null){
                q.add(temp.right);
              }          
              if(temp.left==null && temp.right==null){
                sum+=temp.data;
            }
            }
        }
        
        return sum;
    }
    
    
        
      public static void main(String args[]) 
      { 
             Node root = new Node(1); 
              
             root.left = new Node(2); 
             root.right = new Node(3); 
             root.left.left = new Node(4); 
             root.left.right = new Node(5); 
             root.left.left.left = new Node(6); 
   
            System.out.println(minLeafSum(root));
}
