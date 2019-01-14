import java.util.*;
class Node { 
  
    int data; 
    Node left, right; 
  
    Node(int d) { 
        data = d; 
        left = right = null; 
    } 
} 
  
public class bst { 
static Node root;
public static void findInorder(Node x,int target,ArrayList<Integer> list){
        
        if(x!=null){
            findInorder(x.left,target,list);
            list.add(x.data);
            findInorder(x.right,target,list);
        }
        
    }
public static void findPair(Node root, int target)
    {
       
       ArrayList<Integer> list=new ArrayList<>();
       
       findInorder(root,target,list);
              int s=0,e=list.size()-1;

       int flag=0;
       while(s<e){
           
           int sum=list.get(s)+list.get(e);
           if(sum==target){
            flag=1;
            System.out.println("pair found at -> "+list.get(s)+"-"+list.get(e));}
           if(sum>target) e--;
           else s++;
           
       }
       if(flag==0)
       System.out.println("No pair found ");
       
    }
    
    
    void printInorder(Node node) 
    { 
        if (node == null) 
            return; 
        printInorder(node.left); 
        System.out.print(node.data + " ");     
        printInorder(node.right); 
    } 
  
    public static void main(String[] args) { 
        bst tree = new bst(); 
      
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.findPair(root,26);
    }
}
