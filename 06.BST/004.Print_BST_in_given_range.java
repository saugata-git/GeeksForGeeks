// Java program to print BST in given range 
  Time Complexity: O(n) where n is the total number of keys in tree.
// A binary tree node 
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

    void Print(Node node ,int k1,int k2){
       if(node==null)
         return;
       if(k1<node.data)
         Print(node.left,k1,k2);
       if(k1<=node.data && k2>=node.data){
        System.out.print(node.data+" ");
       if(k2>node.data)
         Print(node.right,k1,k2);
       }
    }
      
    
  
    public static void main(String[] args) { 
        BST tree = new BST(); 
        int k1 = 10, k2 = 25; 
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
  
        tree.Print(root, k1, k2); 
    } 
} 
