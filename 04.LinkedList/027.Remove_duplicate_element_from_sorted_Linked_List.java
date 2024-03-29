import java.util.*;
class LinkedList 
{ 
    Node head; 
    class Node 
    { 
        int data; 
        Node next; 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
  void printList() 
    { 
        Node temp = head; 
        while(temp != null) 
        { 
            System.out.print(temp.data+" "); 
            temp = temp.next; 
        } 
        System.out.println(); 
    } 
  
  
   
    void push(int new_data) 
    { 
        Node new_node = new Node(new_data); 
        new_node.next = head; 
        head = new_node; 
    } 
    void removeDuplicates(){
      Node current=head;
      Node next_next;
    
      if(head==null)
        return;
      while(current.next!=null){
          if(current.data==current.next.data){
             next_next=current.next.next;
             current.next=null;
             current.next=next_next;
          }
          else
            current=current.next;
      }
    }
   


  public static void main(String args[]) 
    { 
        LinkedList llist = new LinkedList(); 
        llist.push(20); 
        llist.push(13); 
        llist.push(13); 
        llist.push(11); 
        llist.push(11); 
        llist.push(11); 
          
        System.out.println("List before removal of duplicates"); 
        llist.printList(); 
          
        llist.removeDuplicates(); 
          
        System.out.println("List after removal of elements"); 
        llist.printList(); 
    } 
}
