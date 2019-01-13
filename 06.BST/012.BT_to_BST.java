import java.util.*;

class Node { 
  
    int data; 
    Node left, right; 
  
    Node(int d) { 
        data = d; 
        left = right = null; 
    } 
} 
  
class BST { 
      
    static Node root; 
    int i=0,j=0;
    /*List<Integer> lst = new ArrayList<>();
     void traverse(Node root, boolean f) {
        if(root==null) return;
        traverse(root.left,f);
        if(f) {
            lst.add(root.data);
        } else {
            root.data=lst.remove(0);
        }
        traverse(root.right,f);
    }
   */
   int []arr=new int[5];

    void traverse(Node root,boolean b) {
        if(root==null) return;
       
        traverse(root.left,b);
        if(b){
        arr[i]=root.data;
        i++;
        }
        else{
        root.data=arr[j];
        j++;
        }
        traverse(root.right,b);

    }
   
    Node binaryTreeToBST(Node root)
    {
        traverse( root,true);
        Arrays.sort(arr);
        //for array list sorting
        // Collections.sort(lst);
        traverse(root,false);
        return root;
        
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
        BST tree = new BST(); 
      
        tree.root = new Node(20); 
        tree.root.left = new Node(28); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12);
      
      
      
        tree.binaryTreeToBST(tree.root);
        tree.printInorder(tree.root) ;
    } 
} 
