import java.util.*;
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
  Node getmiddle(Node node){
     Node fast=node;
     Node slow=node;

     while(fast!=null && fast.next!=null){
       fast=fast.next.next;
       slow=slow.next;
     }
     return slow;
  }

  public void printlist(Node node){
     while(node!=null){
     System.out.print(node.data+" ");
     node=node.next;
     }

  }

  void push(int new_data) 
    { 
        Node new_node = new Node(new_data); 
        new_node.next = head; 
        head = new_node; 
    } 

   Node modifyTheList(Node head,Node slow) 
   { 
       Stack<Integer> st= new Stack<Integer>();

      Node temp = head ; 
      slow=slow.next;
      while(slow!=null) 
      { 
       st.push( slow.data ) ; 
       slow = slow.next ; 
      } 
  
  
      while( !st.isEmpty() ) 
       { 
         temp.data = temp.data - st.pop() ; 
         temp = temp.next ; 
        // st.pop(); 
        }   
   	return head;
} 



  public static void main(String args[]) 
    { 
        LinkedList llist1 = new LinkedList(); 
        
        llist1.push(1); 
        llist1.push(4); 
        llist1.push(4); 
        llist1.push(1); 
        llist1.push(5); 
  
       
        System.out.println("LinkedList List is:"); 
        llist1.printlist(head); 
        System.out.println(); 
        Node mid,h1;
        mid=llist1.getmiddle(head);
        h1= llist1.modifyTheList( head, mid); 
        System.out.println("LinkedList List after modification is:"); 
        llist1.printlist(h1); 
        
    } 
}
