// Java program to print corner node at each level in a binary tree 
//Time Complexity : O(n) where n is number of nodes in Binary Tree.
import java.util.*; 
class Node 
{ 
	int key; 
	Node left, right; 

	public Node(int key) 
	{ 
		this.key = key; 
		left = right = null; 
	} 
} 

class BinaryTree 
{ 
	Node root; 

	
	void printCorner(Node root) 
	{ 
         Queue<Node>q= new LinkedList<Node>();
         q.add(root);		
         q.add(null);
       
         boolean isFirst=false;
         boolean isOne=false;
         int last=0;

         while(!q.isEmpty()){
             Node temp=q.peek();
             q.poll();

             if(isFirst){

                System.out.println(temp.key+ " ");
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);

                isFirst=false;
                isOne=true;

             }
            else if(temp==null){
                if(q.size()>=1)
                     q.add(null);
                 isFirst=true;
                if(!isOne)
                  System.out.print(last+" ");   

            }
           else{
               last=temp.key;
               isOne=false;
               if(temp.left!=null)
                   q.add(temp.left);
               if(temp.right!=null)
                   q.add(temp.right);
           }
          }

	} 

	
	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(15); 
		tree.root.left = new Node(10); 
		tree.root.right = new Node(20); 
		tree.root.left.left = new Node(8); 
		tree.root.left.right = new Node(12); 
		tree.root.right.left = new Node(16); 
		tree.root.right.right = new Node(25); 

		tree.printCorner(tree.root); 
	} 
} 

