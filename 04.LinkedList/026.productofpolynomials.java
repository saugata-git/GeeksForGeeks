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

   Node proOfPolynomials(Node head1, Node head2, int n1, int n2)
    {
	    int size = n1 +n2-1;
	    int[] arr = new int[n1+n2-1];
	    Node temp1 = head1;
	    for(int i=0;i<n1;i++){
	        Node temp2 = head2;
	        for(int j=0;j<n2;j++){
	            int sum = temp1.data * temp2.data;
	            arr[i+j]+=sum;
	            temp2=temp2.next;
	        }
	        temp1 = temp1.next;
	    }
	 //creating dummy node
	    Node newhead = new Node(arr[0]);
	    Node walk = newhead;
	    for(int i=1;i<size;i++){
	        Node temp = new Node(arr[i]);
	        walk.next=temp;
	        walk = walk.next;
	    }
	    return newhead;
	}



  public static void main(String args[]) 
    { 
        LinkedList llist1 = new LinkedList(); 
        LinkedList llist2 = new LinkedList(); 
        LinkedList llist3 = new LinkedList(); 
         
        llist1.push(5); 
        llist1.push(0); 
        llist1.push(10); 
        llist1.push(6); 

        llist2.push(1); 
        llist2.push(4); 
        llist2.push(2); 
        
         
  
       
        System.out.println("LinkedList List is:"); 
        llist1.printlist();
        System.out.println();
        llist2.printlist();
        System.out.println(); 
        Node h1;
        
        llist3.head= llist3.proOfPolynomials( llist1.head, llist2.head,4,3); 
        System.out.println("LinkedList List after modification is:"); 
        llist3.printlist(); 
        
    } 
}
