
/*
Time Complexity: The worst case time complexity of delete operation is O(h) where h is height of Binary Search Tree.
In worst case, we may have to travel from root to the deepest leaf node. 
The height of a skewed tree may become n and the time complexity of delete operation may become O(n).
*/
class Node{
    int data;
    Node left,right;

    Node(int d){
        data=d;
        left=right=null;
    } 
}
 
class BST{


       static Node head;

       Node insert(Node node,int data){

         if(node==null){
           return (new Node(data));
         }
         else{
             if(data<=node.data){
               node.left=insert(node.left,data);
             }
             else{
               node.right=insert(node.right,data);
             }
             return node;
         }
       } 
    
       int minValue(Node node){
        
         Node current=node;
         while(current.left!=null){
            current=current.left;
         }
        return (current.data);
        }
       Node deleteRec(Node root,int key){
        
           if(root==null)
           return root;
           if(key<root.data)
            root.left = deleteRec(root.left, key); 
           else if (key > root.data) 
            root.right = deleteRec(root.right, key); 
           else{
              // node with only one child or no child 
              if(root.left==null)
              return root.right;
              else if(root.right==null)
              return root.left;
              // node with two children: Get the inorder successor (smallest 
              // in the right subtree)
              root.data=minValue(root.right);
              // Delete the inorder successor 
              root.right=deleteRec(root.right,root.data);
           }
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
       public static void main(String args[]){

            BST tree = new BST();
            Node root=null;
            root=tree.insert(root,4);
            tree.insert(root,2);
            tree.insert(root, 1); 
            tree.insert(root, 3); 
            tree.insert(root, 6); 
            tree.insert(root, 5); 
            tree.deleteRec(root,3);
            tree.printInorder(root);
       }
}
