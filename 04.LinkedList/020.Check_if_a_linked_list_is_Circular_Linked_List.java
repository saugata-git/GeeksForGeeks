
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


