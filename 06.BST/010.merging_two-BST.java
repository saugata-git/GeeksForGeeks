//The expected time complexity is O(H1+H2)
class Node { 
  
    int data; 
    Node left, right; 
  
    Node(int d) { 
        data = d; 
        left = right = null; 
    } 
} 
  
class BST { 
      
    static Node root1,root2; 
    Node merge(Node root1,Node root2){
    
    if(root1==null && root2==null ){
     return null;
    }
    if(root1==null)
     return root2;
    if(root2==null)
     return root1;
    if(root1.data>root2.data){
      Node right=root2.right;
      root2.right=null;
      root1.left=merge(root1.left,root2);
      merge(root1,right);
    }
    else{
      Node left=root2.left;
      root2.left=null;
      root1.right=merge(root1.right,root2);
      merge(root1,left);
  
    }
   return root1;
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
      
        tree.root1 = new Node(20); 
        tree.root1.left = new Node(8); 
        tree.root1.right = new Node(22); 
        tree.root1.left.left = new Node(4); 
        tree.root1.left.right = new Node(12); 
       
        tree.root2 = new Node(21); 
        tree.root2.left = new Node(7); 
        tree.root2.right = new Node(18); 
        tree.root2.left.left = new Node(5); 
        tree.root2.left.right = new Node(11);
        tree.printInorder(root1);
        System.out.println();
        tree.printInorder(root2);
        System.out.println();
        Node h1=tree.merge(root1,root2);
        tree.printInorder(h1);
    } 
} 
