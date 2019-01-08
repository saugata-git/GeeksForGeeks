/*
1) Initialize result list as empty: res = NULL.
2) Let 'a' and 'b' be heads first and second lists respectively.
3) While (a != NULL and b != NULL)
    a) Find the smaller of two (Current 'a' and 'b')
    b) Insert the smaller value node at the front of result.
    c) Move ahead in the list of smaller node. 
4) If 'b' becomes NULL before 'a', insert all nodes of 'a' 
   into result list at the beginning.
5) If 'a' becomes NULL before 'b', insert all nodes of 'a' 
   into result list at the beginning. 
*/
class LinkedList { 
  
    Node head;  // head of list 
    static Node a, b; 
  
    /* Node Class */
    static class Node { 
  
        int data; 
        Node next; 
  
        // Constructor to create a new node 
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
  
    void printlist(Node node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
   Node sortedmerge(Node node1,Node node2){
     
      if(node1==null && node2==null){
      return null;
      }
      Node res=null;
      while(node1!=null&& node2!=null){
        if(node1.data<=node2.data){
            Node temp=node1.next;
            node1.next=res;
            res=node1;
            node1=temp;
        }
        else{

            Node temp=node2.next;
            node2.next=res;
            res=node2;
            node2=temp;
        }

      }
      while(node1!=null){
       Node temp=node1.next;
       node1.next=res;
       res=node1;
       node1=temp;
      }
     
      while(node2!=null){
        Node temp=node2.next;
        node2.next=res;
        res=node2;
        node2=temp;
      }
     return res;
   }





    public static void main(String[] args) { 
  
        LinkedList list = new LinkedList(); 
        Node result = null; 
  
        /*Let us create two sorted linked lists to test 
         the above functions. Created lists shall be 
         a: 5->10->15 
         b: 2->3->20*/
        list.a = new Node(5); 
        list.a.next = new Node(10); 
        list.a.next.next = new Node(15); 
  
        list.b = new Node(2); 
        list.b.next = new Node(3); 
        list.b.next.next = new Node(20); 
  
        System.out.println("List a before merge :"); 
        list.printlist(a); 
        System.out.println(""); 
        System.out.println("List b before merge :"); 
        list.printlist(b); 
  
        // merge two sorted linkedlist in decreasing order 
        result = list.sortedmerge(a, b); 
        System.out.println(""); 
        System.out.println("Merged linked list : "); 
        list.printlist(result); 
  
    } 
} 
