//Time Complexity: O(n)

class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class BinaryTree 
{ 
	Node root; 
        int i=0;
        Node constructTree(int n, int pre[], char preLN[])
        {
        
        Node root=new Node(pre[i]);
        i++;
        if(i<n&&preLN[i]=='L'){
            i++;
            root.left=new Node(pre[i-1]);
        }
        else if(i<n&&preLN[i]=='N')
        root.left=constructTree(n,pre,preLN);
         if(i<n&&preLN[i]=='L'){
            i++;
            root.right=new Node(pre[i-1]);
        }
        else if(i<n&&preLN[i]=='N')
        root.right=constructTree(n,pre,preLN);
        return root;
	    
       }
	
	
	void inOrder(Node node) 
	{ 
		if (node == null) 
			return; 

		inOrder(node.left); 
		System.out.print(node.data + " "); 
		inOrder(node.right); 
	} 

	public static void main(String args[])  
        { 

        BinaryTree tree = new BinaryTree(); 
        int pre[] = new int[]{10, 30, 20, 5, 15}; 
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'}; 
        int n = pre.length; 
   
        Node mynode = tree.constructTree(n,pre, preLN); 
   
      
        System.out.println("Following is Inorder Traversal of the"  + "Constructed Binary Tree: "); 
        tree.inOrder(mynode); 
      } 
} 
