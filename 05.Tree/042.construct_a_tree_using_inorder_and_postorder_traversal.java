//Java program to construct a tree using inorder and postorder traversal 
//Time Complexity: O(n^2). Worst case occurs when tree is left skewed. 
//Example Preorder and Inorder traversals for worst case are {A, B, C, D} and {D, C, B, A}.

class Node { 
	char data; 
	Node left, right; 

	Node(char item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 
class Index{
   int index;
}

class BinaryTree { 
	Node root; 
        Node buildUtil(char in[], char post[], int inStrt,int inEnd, Index pIndex){ 
       
        if (inStrt > inEnd) 
            return null; 
        Node node = new Node(post[pIndex.index]); 
        (pIndex.index)--; 
  
        if (inStrt == inEnd) 
            return node; 
  
        int iIndex = search(in, inStrt, inEnd, node.data); 

        node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex); 
        node.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex); 
  
        return node; 
    } 
  
   
       Node buildTree(char in[], char post[], int n) 
       { 
          Index pIndex = new Index(); 
          pIndex.index = n - 1; 
          return buildUtil(in, post, 0, n - 1, pIndex); 
        } 

	int search(char arr[], int strt, int end, char value) 
	{ 
		int i; 
		for (i = strt; i <= end; i++) { 
			if (arr[i] == value) 
				return i; 
		} 
		return i; 
	} 

	
	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	} 

	
	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' }; 
		char post[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' }; 
		int len = in.length; 

		Node root = tree.buildTree(in, post ,len); 

		 
		System.out.println("Inorder traversal of constructed tree is : "); 
		tree.printInorder(root); 
	} 
} 
