public class BinaryTree { 

	public static class Node { 
		int value; 
		Node left; 
		Node right; 

		public Node(int value) { 
			this.value = value; 
		} 
	} 

	public static Node LCA(Node root,int n1,int n2){
            
            if(root==null)
               return root;

            if(root.value == n1  || root.value == n2)
               return root;
 
            Node left =LCA(root.left,n1,n2);
            Node right=LCA(root.right,n1,n2);
          
            if(left!=null && right!=null)
                return root;

            if(left!=null)
                return LCA(root.left,n1,n2);
            else
                return LCA(root.right,n1,n2);          

        }

        

      
	public static void main(String[] args) { 
	        
		Node root = new Node(1);

		
                root.left = new Node(2); 
                root.right = new Node(3); 
                root.left.left = new Node(4); 
                root.left.right = new Node(5); 
                root.right.left = new Node(6); 
                root.right.right = new Node(7); 
  
               
		System.out.println("Dist(4, 5) = "+ LCA(root, 4, 5).value); 
		
	} 
} 
