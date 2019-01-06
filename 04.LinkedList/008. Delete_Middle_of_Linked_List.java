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
   Node  deleteMiddle(Node node){

     Node fast=node;
     Node slow=node;
     Node prev=null;
 
     while(fast!=null && fast.next!=null){
       prev=slow;      
       slow=slow.next;
       fast=fast.next.next;
     }
     prev.next=slow.next;
     return node;
  }

  public void printlist(Node node){
     while(node!=null){
     System.out.print(node.data+" ");
     node=node.next;
     }

  }
  public static void main(String args[]){
    LinkedList list =new LinkedList();
    list.head= new Node(1);
    list.head.next= new Node(2);
    list.head.next.next=new Node(3);
    System.out.println("Linked list is :");
    list.printlist(head);
    System.out.println();
    list.deleteMiddle(head);
    System.out.println("Linked list after deletion of middle :");
    list.printlist(head);
  }
}


