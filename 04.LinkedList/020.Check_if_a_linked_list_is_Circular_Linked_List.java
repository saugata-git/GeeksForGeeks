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
  
    // Function that detects loop in the list 
    boolean detectLoop(Node node) { 
  
        // If list is empty or has only one node 
        // without loop 
        if (node == null || node.next == null) 
            return false; 
        int flag=0;
        Node slow = node, fast = node; 
  
      
  
       
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next;
             if (slow == fast){
               flag=1;         
               break; }             
        }
       if(flag==1)
          return true;
       else
         return false;    
    } 
  
    // Function to print the linked list 
    void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
  
    // Driver program to test above functions 
    public static void main(String[] args) { 
        LinkedList list = new LinkedList(); 
        list.head = new Node(50); 
        list.head.next = new Node(20); 
        list.head.next.next = new Node(15); 
        list.head.next.next.next = new Node(4); 
        list.head.next.next.next.next = new Node(10); 
  
        // Creating a loop for testing  
       head.next.next.next.next.next = head.next.next; 
        System.out.println(list.detectLoop(head)); 
        
       
    } 
}
/*
class LinkedList 
{ 
	static Node head; // head of the list 

	
	static class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	

        public boolean isCircular(Node node ){
         if(node==null){
           return false;
          }
           
          Node temp=node.next;
          while(temp!=null && temp!=node){
          temp=temp.next;
          }
          return (temp==head);
        }

        
	public void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 

	public static void main(String [] args) 
	{ 
		LinkedList llist = new LinkedList(); 
		llist.push(20); 
		llist.push(4); 
		llist.push(15); 
		llist.push(35); 
                llist.head.next.next.next.next=llist.head;
                System.out.println(llist.isCircular(head));
		
	} 
}

*/
