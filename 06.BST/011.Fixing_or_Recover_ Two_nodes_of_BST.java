public class BST
{
   static class Node
   {
        Node left;
        Node right;
        int val;
         
        public Node(int x)
        {
            this.val = x;
        }
   }

    Node firstStartPoint, lastEndPoint;
    Node prev;

    public void findSegments(Node root){

      if(root==null)
      return;
    
      findSegments(root.left);

       if(prev!=null){
           if(prev.val>root.val){
               if( firstStartPoint==null){
                firstStartPoint=prev;
               }
               lastEndPoint=root;
           }
       }
       prev=root;

      findSegments(root.right);
    }

    public void recoverTree(Node root){
     findSegments(root);
     int x=firstStartPoint.val;
     firstStartPoint.val=lastEndPoint.val;
     lastEndPoint.val=x;
    }

    public void printInOrder(Node root)
    {
       if (root == null) return;
            
       printInOrder(root.left);
       System.out.println(root.val);
       printInOrder(root.right);
    }

     public static void main(String[] args)
     {
       Node root = new Node(10);
       Node n1   = new Node(15);
       Node n2   = new Node(5);
       Node n3   = new Node(4);
       Node n4   = new Node(7);
       Node n5   = new Node(14);
       Node n6   = new Node(17);
        
       root.left  = n1;
       root.right = n2;
        
       n1.left  = n3;
       n1.right = n4;
        
       n2.left  = n5;
       n2.right = n6;
       
       BST tree = new BST();



        
       System.out.println("In-Order traversal of BST before recovery: ");
       tree.printInOrder(root);
 
       tree.recoverTree(root);
        
       System.out.println("In-Order traversal of BST after recovery: ");
       tree.printInOrder(root);
   }
}

