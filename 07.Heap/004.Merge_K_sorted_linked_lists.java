/*Method 3 (Using Divide and Conquer))
In this post, Divide and Conquer approach is discussed.
This approach doesn’t require extra space for heap and works in O(nk Log k)
We already know that merging of two linked lists can be done in O(n) time and O(1) space
(For arrays O(n) space is required). The idea is to pair up K lists and merge each pair in linear time using O(1) space.
After first cycle, K/2 lists are left each of size 2*N. After second cycle, K/4 lists are left each of size 4*N and so on. 
Time Complexity: O(nk Logk)
Auxiliary Space: O(k)We repeat the procedure until we have only one list left.

*/
import java.util.PriorityQueue;
import java.util.Comparator;

class Node{
   int data;
   Node next;
   Node(int data){
    this.data=data;
    next=null;
   }
} 



public class MergeKLists{

     public static Node mergeKSortedLists(Node arr[], int k){

        Node head=null,last=null;
        PriorityQueue<Node> pq=new PriorityQueue<>(new Comparator<Node>(){ 

           public int compare(Node a,Node b){
             return a.data-b.data;
           }

        });

        for(int i=0;i<k;i++)
          pq.add(arr[i]);

        while(!pq.isEmpty()){
    
           Node top=pq.peek();
           pq.remove();

           if(top.next!=null)
             pq.add(top.next);
           }

          if(head==null){
            head=top;
            last=top;

          }
          else{
            last.next=top;
            last=top;
          }
          return head;
        }
     }
     public Node push(int data){ 
       Node newnode=new Node(data);
       newnode.next=null;
      return newnode;
     }

     public static void printList(Node head){

     while(head!=null){
       System.out.println(head.data+" ");
       head=head.next;
     }

     public static void main(String args[]){
        int k=3;// Number of linked lists 
        int n=4; / Number of elements in each list  

        Node arr[]=new Node[k];
       
        arr[0]= new Node(1);
        arr[0].next=new Node(3);
        arr[0].next.next= new Node(5);
        arr[0].next.next.next= new Node(7);

        arr[1]=new Node(2);
        arr[1].next=new Node(4);
        arr[1].next.next=new Node(6);
        arr[1].next.next.next=new Node(8);

        arr[2] = new Node(0);  
        arr[2].next = new Node(9);  
        arr[2].next.next = new Node(10);  
        arr[2].next.next.next = new Node(11);

        Node head=mergeKSortedLists(arr, k);
        printList(head);
     }

}
