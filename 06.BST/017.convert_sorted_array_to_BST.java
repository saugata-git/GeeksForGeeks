
//given a sorted array,concert it to bst
//T(n)=log(n)
import java.util.*;
class Node
{
    int val;
    Node left;
    Node right;
    Node(int num)
    {
        val=num;
        left=right=null;
    }
}
 

class BST{
   static Node root;
    static Node toBst(int arr[],int start,int end)
    {
        if(start>end)
        {
            return null;
        }
        int mid=(start+end)/2;
        Node node=new Node(arr[mid]);
        node.left= toBst( arr, start, mid-1);
        node.right= toBst( arr, mid+1, end);
        return node;
    }
   static void preorder(Node node)
    {
        if(node==null)
        return;
        System.out.print(node.val+" ");
        preorder(node.left);
        preorder(node.right);
    }
     
	public static void main (String[] args) {
		 Scanner s=new Scanner(System.in);
		 int t;
		 t=s.nextInt();
		 while(t-- >0)
		 {
		     int size,i;
		     size=s.nextInt();
		     int ar[]=new int[size];
		     for(i=0;i<size;i++)
		     {
		         ar[i]=s.nextInt();
		     }
		     
		     root=toBst(ar,0,ar.length-1);
		     preorder(root);
		     System.out.println();		     
		     
		 }
	}
}
