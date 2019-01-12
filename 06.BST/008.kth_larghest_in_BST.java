T(N)=O(height+k);

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
    
    public void kthlargest(Node root,int k){
     if(root==null)
         return;
     kthlargest(root.right,k);
     c+=1;
     if(c==k){
     System.out.println(root.data);
     return;
     }
     kthlargest(root.left,k);
     
    }
    
    
  
    public static void main(String[] args) { 
        BST tree = new BST(); 
      
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
       
        tree.kthlargest(root,3);
    } 
} 
