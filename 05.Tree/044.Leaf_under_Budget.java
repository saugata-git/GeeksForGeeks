// Java program to calculate the maximum number of leaf 
// nodes that can be visited within the given budget 
import java.io.*; 
import java.util.*; 
import java.lang.*; 

class Node { 
	int data; 
	Node left, right; 
	Node(int key) 
	{ 
		data = key; 
		left = right = null; 
	} 
} 

class BinaryTree { 

	static PriorityQueue<Integer>pq;

        static void levelOrder(Node root){

          Queue<Node> q= new LinkedList<>();
          int len,level=0;
          Node temp;

          if(root==null)
           return;

           q.add(root);
          while(true){
               len=q.size();
               if(len==0)
                break;
               level++;
               while(len>0){
                  temp=q.remove();
                  if(temp.left!=null)
                    q.add(temp.left);
                  if(temp.right!=null)
                    q.add(temp.right);
                  if(temp.left==null && temp.right==null)
                    pq.add(level);
                  len--;
               }
          }
        }
        static int countLeafNodes(Node root,int budget){
               pq=new PriorityQueue<>();
               levelOrder(root);
               int val;
              
               int count=0;
               while(pq.size()!=0){
                 val=pq.poll();
                 if(val<=budget){
                  count++;
                  budget-=val;
                 }
                 else
                   break;
               }
             return count;
        }

	
	
	public static void main(String args[]) 
	{ 

		Node root = new Node(10); 
		root.left = new Node(8); 
		root.right = new Node(15); 
		root.left.left = new Node(3); 
		root.left.left.right = new Node(13); 
		root.right.left = new Node(11); 
		root.right.right = new Node(18); 

		int budget = 8; 

		System.out.println(countLeafNodes(root, budget)); 
	} 
} 
