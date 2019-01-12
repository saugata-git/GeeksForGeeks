
//T(n)=O(n)
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
    int sum=0;
    Node util(Node node){
     
     if(node==null)
       return null;
     util(node.right);
     node.data+=sum;
     sum=node.data;
     util(node.left);

    return node;
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
        Node h =tree.util(root);
        tree.printInorder(h);
    } 
} 
