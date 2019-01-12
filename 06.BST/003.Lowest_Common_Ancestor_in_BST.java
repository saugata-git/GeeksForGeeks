/*Time complexity of recursive solution is O(h) where h is height of tree. Also, the above solution requires O(h) extra space in 
function call stack for recursive function calls. We can avoid extra space using iterative solution.*/


class Node  
{ 
    int data; 
    Node left, right; 
   
    Node(int item)  
    { 
        data = item; 
        left = right = null; 
    } 
} 
   
class BST  
{ 
    Node root; 
     //Recursive solution
   /*  Node lca(Node node,int n1,int n2){
        if(node==null)
        return null;
        if(node.data>n1 && node.data>n2)
        return lca(node.left,n1,n2);
        if(node.data<n1 && node.data<n2)
        return lca(node.right,n1,n2);
        
        return node;
     }*/
   //Iterative solution
        
   Node lca(Node node,int n1,int n2){
        while(node!=null){
        
        if(node.data>n1 && node.data>n2)
                node= node.left;
        if(node.data<n1 && node.data<n2)
                node= node.right;
        else
            break;
        }
        return node;
     }
  
    public static void main(String args[])  
    { 
        
        BST tree = new BST(); 
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
   
        int n1 = 10, n2 = 14; 
        Node t = tree.lca(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is-> " + t.data); 
   
        n1 = 14; 
        n2 = 8; 
        t = tree.lca(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is->" + t.data); 
   
        n1 = 10; 
        n2 = 22; 
        t = tree.lca(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is-> " + t.data); 
   
    } 
} 
   
