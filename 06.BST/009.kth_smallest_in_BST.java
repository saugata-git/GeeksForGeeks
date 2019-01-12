//T(n)=O(h+k);
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
    int c=0;
    
    public void kthsmallest(Node root,int k){
     if(root==null)
         return;
     kthsmallest(root.left,k);
     c+=1;
     if(c==k){
     System.out.println(root.data);
     return;
     }
     kthsmallest(root.right,k);
     
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
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
       
      
        tree.kthsmallest(root,4);
    } 
} 
