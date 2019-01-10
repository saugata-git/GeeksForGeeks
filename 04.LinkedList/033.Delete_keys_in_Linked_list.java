class LinkedList 
{ 
	static Node head; 
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

        
	public void push(int new_data) 
	{ 
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 
        void printList(Node node) 
	{ 
		Node temp = node; 
		while(temp != null) 
		{ 
			System.out.print(temp.data+" "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 

        Node deleteKey(Node node,int key){

        Node curr=node;
        if(node==null){
           return node;
        }
       
        while(node!=null && node.data==key){
          node=node.next; 
        } 
         Node temp=node;
            while(temp.next!=null){
              if(temp.next.data==key){
                     temp.next=temp.next.next;
               }
              else{
              temp=temp.next;
              }
            }
           return node;
            
         }
	public static void main(String [] args) 
	{ 
		LinkedList llist = new LinkedList(); 
		llist.push(20); 
		llist.push(35); 
		llist.push(35); 
		llist.push(35); 
                Node no;
                no=llist.deleteKey(head,35);
                llist.printList(no);
               
		
	} 
}
