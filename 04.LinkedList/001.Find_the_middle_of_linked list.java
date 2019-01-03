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
  int getmiddle(Node node){
     Node fast=node;
     Node slow=node;

     while(fast!=null && fast.next!=null){
       fast=fast.next.next;
       slow=slow.next;
     }
     return slow.data;
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
    list.printlist(head);
   System.out.print("\n" +list.getmiddle(head));

  }
}
