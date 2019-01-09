class SortList{

    static Node node;
    static class Node{
      int data;
      Node next;
      Node(int d){
       data=d;
       next=null;
     }
    }
    Node sortedList(Node head){
       Node prev=head;
       Node curr=head.next;
       while(curr!=null){
         if(curr.data<prev.data){
            // Detach curr from linked list 
             prev.next=curr.next;

           // Move current node to beginning
             curr.next=head;
             head=curr;
             curr = prev; 
           
         }
         else
           prev=curr;
           curr=curr.next;
      }
      return head;
    }
    public void push(int new_data){
     Node new_node= new Node(new_data);
     new_node.next=head;
     head=new_node;
    }

   void printList(Node head){
     Node temp=head;
     while(temp!=null){
     System.out.print(temp.data+" ");
     temp=temp.next;
     }
     System.out.println();
   }

   public static void main(String args[]){

     SortList list =new SortList();
                llist.push(-5); 
		llist.push(5); 
		llist.push(4); 
		llist.push(3); 
		llist.push(-2); 
		llist.push(1); 
		llist.push(0); 
		
       System.out.println("Original List :"); 
	llist.printList(llist.head); 
		
	llist.head = llist.sortedList(head); 

	System.out.println("Sorted list :"); 
       llist.printList(llist.head); 
   }


}
