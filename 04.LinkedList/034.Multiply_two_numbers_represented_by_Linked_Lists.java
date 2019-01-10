import java.util.*;

   
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



class LinkedList 
{ 
     Node head; 
  void printlist() 
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


    static int multiplyTwolists(Node first,Node second){
        int num1=0,num2=0;
        while(first!=null ||second!=null){
           if(first!=null){
             num1=num1*10+first.data;
             first=first.next;
           }
          if(second!=null){
             num2=num2*10+second.data;
             second=second.next;
          }
        }
      return num1*num2;
    }
  



  public static void main(String args[]) 
    { 
        LinkedList llist1 = new LinkedList(); 
        LinkedList llist2 = new LinkedList(); 
        
         
        llist1.push(5); 
        llist1.push(2); 
       
        llist2.push(2); 
       
         
  
       
        System.out.println("LinkedList List is:"); 
        llist1.printlist();
        System.out.println();
        llist2.printlist();
        System.out.println(); 
        
        int m  = multiplyTwolists(llist1.head,llist2.head);
        System.out.println(m);
        
    } 
}
