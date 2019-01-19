import java.util.*;

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

        int max(int a,int b){
         return (a>b)?a:b;
        }

        int maxLevelSum(Node root){
        
          Queue<Node>q=new LinkedList<>(); 
        
           //Base case 
           if(root==null)
              return 0;
           int result=root.data;
           
           // Do Level order traversal keeping track of number 
           // of nodes at every level.
        
	         q.add(root);
           while(!q.isEmpty()){
           
              // Get the size of queue when the level order 
              // traversal for one level finishes 
              int count=q.size();
               
              // Iterate for all the nodes in the queue currently               
              int sum=0;
             while(count-->0){
                  // Dequeue an node from queue
                 Node temp=q.peek();
                 q.remove();
                 
                 // Add this node's value to current sum                 
                 sum = sum + temp.data;

                 // Enqueue left and right children of 
                  // dequeued node 
                   if(temp.left!=null)
                      q.add(temp.left);
                   if(temp.right!=null)
                      q.add(temp.right);
              }
              // Update the maximum node count value              
             result=max(sum,result);
            }
           return result;
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
		tree.root.left.right.left = new Node(7); 
		tree.root.left.right.right = new Node(8); 

		System.out.println("MAX level sum :"+tree.maxLevelSum(tree.root));
	} 
} 
