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
  public void push(int new_data){
    Node new_node=new Node(new_data);
    new_node.next=head;
    head=new_node;
  }
  void printList(){
    Node temp=head;
    while(temp!=null){
      System.out.print(temp.data+" ");
      temp=temp.next;
    }
    System.out.println(); 
  }

  Node reverse(Node head,int k){
     Node current=head;
     Node next=null;
     Node prev=null;
     int count=0;
     while(count<k && current!=null){
      next=current.next;
      current.next=prev;
      prev=current;
      current=next;
      count++;
     }
     if(next!=null)
      head.next=reverse(next,k);
     return prev;

  }

 

  
  public static void main(String args[]) 
    { 
        LinkedList llist = new LinkedList(); 
          /* Constructed Linked List is 1->2->3->4->5->6-> 
           7->8->8->9->null */
        llist.push(9); 
        llist.push(8); 
        llist.push(7); 
        llist.push(6); 
        llist.push(5); 
        llist.push(4); 
        llist.push(3); 
        llist.push(2); 
        llist.push(1); 
          
        System.out.println("Given Linked List"); 
        llist.printList(); 
          
        llist.head = llist.reverse(llist.head, 3); 
  
        System.out.println("Reversed list"); 
        llist.printList(); 
    } 
}
