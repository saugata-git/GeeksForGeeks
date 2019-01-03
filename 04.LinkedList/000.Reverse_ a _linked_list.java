class LinkedList{

    static Node head;
    static class Node{
        int data;
        Node next;
       
        Node(int d){
        data=d;
        next=null;
        }
    }

    // A simple and tail recursive function to reverse a linked list.  prev is passed as NULL initially.


    Node reverseUtil(Node curr,Node prev){

         /* If last node mark it head*/
          if(curr.next==null){
             head=curr;

             /* Update next to prev node */
             curr.next=prev;
             return head;
          }
          /* Save curr->next node for recursive call */
          Node next1=curr.next;
          /* and update next ..*/
          curr.next=prev;
          reverseUtil(next1,curr);
          return head;
    }

    /* Function to reverse the linked list itaratevily */

     Node reverse(Node node){
         Node prev =null;
         Node current=node;
         Node next =null;
         while(current!=null){
          next=current.next;
          current.next=prev;
          prev=current;
          current=next;
         }
        node=prev;
        return node;
     }

     void printList(Node node){
        while(node!=null){
        System.out.print(node.data+" ");
        node=node.next;
        }
     }
     


    public static void main(String args[]){

        LinkedList list =new LinkedList();
        list.head = new Node(85); 
        list.head.next = new Node(15); 
        list.head.next.next = new Node(4); 
        list.head.next.next.next = new Node(20); 
          
        System.out.println("Given Linked list"); 
        list.printList(head); 
        //head = list.reverse(head);
        Node res = list.reverseUtil(head, null); 
        System.out.println(""); 
        System.out.println("Reversed linked list "); 
        //list.printList(head);
        list.printList(res);
    }




}
