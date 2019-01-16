class Node  
{ 
    int data; 
    Node left, right; 
   
    Node(int item)  
    { 
        data = item; 
        left = right; 
    } 
} 
   
class BinaryTree  
{ 
   
    Node root; 
   
    int getLevelDiff(Node node)  
    { 
       
        if (node == null) 
            return 0; 
  
        return node.data - (getLevelDiff(node.left)+getLevelDiff(node.right)); 
    } 
   
  
    public static void main(String args[])  
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(5); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(6); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(4); 
        tree.root.left.right.left = new Node(3); 
        tree.root.right.right = new Node(8); 
        tree.root.right.right.right = new Node(9); 
        tree.root.right.right.left = new Node(7); 
        System.out.println(tree.getLevelDiff(tree.root) +   
                                             " is the required difference"); 
   
    } 
} 
