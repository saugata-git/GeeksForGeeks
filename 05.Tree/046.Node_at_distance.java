// Java program to print all nodes at a distance k from leaf 
// A binary tree node 
//T(n)=O(n);
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

class BinaryTree 
{ 
	Node root; 
        void kDistantFromLeafUtil(Node node, int path[],boolean visited[],int pathLen, int k){ 

        if(node==null)
           return;

        path[pathLen]=node.data;
        visited[pathLen]=false;
        pathLen++;

        if(node.left==null && node.right==null && pathLen-k-1>=0 && visited[pathLen - k - 1] == false) { 
            System.out.print(path[pathLen - k - 1] + " "); 
            visited[pathLen - k - 1] = true; 
            return; 
        } 


          kDistantFromLeafUtil(node.left, path, visited, pathLen, k); 
          kDistantFromLeafUtil(node.right, path, visited, pathLen, k); 
       }
	
	void printKDistantfromLeaf(Node node ,int k){

           int path[] =new int[1000];
           boolean visited[] = new boolean[1000];
           kDistantFromLeafUtil(node,path,visited,0,k);

        }

	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 

	
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 
		tree.root.right.left.right = new Node(8); 

		System.out.println("Nodes at distance 2 are :"); 
		tree.printKDistantfromLeaf(tree.root, 2); 
	} 
} 

