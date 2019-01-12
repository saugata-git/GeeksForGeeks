//Time complexity of the above program is O(h + k) where h is height of BST and k is number of nodes in given range.

class BST { 
  
   
    static class Node { 
        int data; 
        Node left, right; 
  
        public Node(int item) { 
            data = item; 
            left = right = null; 
        } 
    } 
    Node root;
    BST() {  
        root = null;  
    } 
    int getCount(Node node,int low,int high){
    
       if(node==null)
          return 0;
       if(node.data>=low && node.data<=high)
          return 1+ this.getCount(node.left,low,high)+this.getCount(node.right,low,high);
       else if(node.data<low)
          return this.getCount(node.right,low,high);
       else
          return this.getCount(node.left,low,high);

    }      


    public static void main(String args[]) { 
        BST tree = new BST(); 
          
        tree.root = new Node(10); 
        tree.root.left     = new Node(5); 
        tree.root.right     = new Node(50); 
        tree.root.left.left = new Node(1); 
        tree.root.right.left = new Node(40); 
        tree.root.right.right = new Node(100); 
        
        int l=5; 
        int h=45; 
        System.out.println("Count of nodes between [" + l + ", "
                      + h+ "] is " + tree.getCount(tree.root, 
                                                  l, h)); 
    } 
} 
