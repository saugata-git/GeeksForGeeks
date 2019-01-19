      class LLNode 
	{ 
		int data; 
		LLNode prev, next; 
		public LLNode(int d) { data = d; } 
	} 

	
	 class TNode 
	{ 
		int data; 
		TNode left, right; 
		public TNode(int d) { data = d; } 
	} 


public class BinaryTree 
{ 
       TNode root;
	
	
	static void verticalSumDLL(TNode root) 
	{ 
	
		LLNode llnode = new LLNode(0);
		verticalSumDLLUtil(root, llnode); 
		while (llnode.prev != null) 
			llnode = llnode.prev; 
		while (llnode != null) 
		{ 
			System.out.print(llnode.data +" "); 
			llnode = llnode.next; 
		} 
	} 

	
	static void verticalSumDLLUtil(TNode tnode, LLNode llnode) 
	{ 
		
		llnode.data = llnode.data + tnode.data; 
		if (tnode.left != null) 
		{ 
			if (llnode.prev == null) 
			{ 
				llnode.prev = new LLNode(0); 
				llnode.prev.next = llnode; 
			} 
			verticalSumDLLUtil(tnode.left, llnode.prev); 
		} 

		if (tnode.right != null) 
		{ 
			if (llnode.next == null) 
			{ 
				llnode.next = new LLNode(0); 
				llnode.next.prev = llnode; 
			} 
			verticalSumDLLUtil(tnode.right, llnode.next); 
		} 
	} 

	
	public static void main(String[] args) 
	{       
		BinaryTree tree= new BinaryTree();
		tree.root = new TNode(1); 
		tree.root.left = new TNode(2); 
		tree.root.right = new TNode(3); 
		tree.root.left.left = new TNode(4); 
		tree.root.left.right = new TNode(5); 
		tree.root.right.left = new TNode(6); 
		tree.root.right.right = new TNode(7); 

		System.out.println("Vertical Sums are"); 
		tree.verticalSumDLL(tree.root); 
	} 

	
} 
