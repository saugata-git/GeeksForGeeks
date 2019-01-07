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

  

  public static void pairWiseSwap(Node head){
   while(head!=null && head.next!=null){
     int k=head.data;
     head.data=head.next.data;
     head.next.data=k;
     head=head.next.next;   
     
   }

  }
  public static void main(String args[]) 
    { 
        LinkedList llist = new LinkedList(); 
  
        /* Created Linked List 1->2->3->4->5 */
        llist.push(5); 
        llist.push(4); 
        llist.push(3); 
        llist.push(2); 
        llist.push(1); 
          
        System.out.println("Linked List before calling pairWiseSwap() "); 
        llist.printList(); 
          
        pairWiseSwap(head); 
          
        System.out.println("Linked List after calling pairWiseSwap() "); 
        llist.printList(); 
    } 


}
