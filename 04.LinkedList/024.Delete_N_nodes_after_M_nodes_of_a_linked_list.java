class LinkedList { 
  
    static Node head; 
  
    static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 
  
    void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
  
    void skipMdeleteN(Node head,int M,int N){
     Node curr=head,t;
     int count;
     while(curr!=null){
      for(count=1;count<M && curr!=null;count++)
        curr=curr.next;
      if (curr == null) 
            return;
       t=curr.next;
       for(count=1;count<=N && t!=null;count++){
          Node temp=t;
          t=t.next;
       }
       curr.next=t;
       curr=t;
     }
    }
    // Driver program to test above functions 
    public static void main(String[] args) { 
        LinkedList list = new LinkedList(); 
        list.head = new Node(1); 
        list.head.next = new Node(12); 
        list.head.next.next = new Node(1); 
        list.head.next.next.next = new Node(4); 
        list.head.next.next.next.next = new Node(1); 
        list.head.next.next.next.next.next = new Node(1); 
        System.out.println("Before Deleting "); 
        list.printList(head); 
  
        /* I m deleting the head itself. 
         You can check for more cases */
        list.skipMdeleteN(head, 2, 1);  
        System.out.println(""); 
        System.out.println("After deleting "); 
        list.printList(head); 
    } }
    
    //Time Complexity: O(n) where n is number of nodes in linked list.
