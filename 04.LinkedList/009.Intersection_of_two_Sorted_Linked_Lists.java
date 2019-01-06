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
  
    void getIntersection(Node head1, Node head2)
    {    
         Node temp1=head1;
         Node temp2=head2;
        //recusrive approach
           if(temp1==null||temp2==null)
             return ;
            if(temp1.data<temp2.data)
             getIntersection(temp1.next,temp2);
            if(temp1.data>temp2.data)
              getIntersection(temp1,temp2.next);

            else{
                 append(temp1.data);
                 getIntersection(temp1.next,temp2.next);
               }
            
        /* iterative 

         while(temp1!=null && temp2!=null)
         {
             if(temp1.data<temp2.data)
             {
                 temp1=temp1.next;
             }
             else if(temp2.data<temp1.data)
             {
                 temp2=temp2.next;
             }
             else if(temp1.data==temp2.data)
             {
                append(temp1.data);
              
                 temp1=temp1.next;
                 temp2=temp2.next;
             }
         }*/
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
   void append(int new_data){
        Node new_node =new Node(new_data);
        if(head==null){
          head=new Node(new_data);
          return;
        }
        new_node.next=null;
        Node last=head;
        while(last.next!=null)
            last=last.next;
        last.next=new_node;
        return;

    }
  
 
    public static void main(String args[]) 
    { 
        LinkedList llist1 = new LinkedList(); 
        LinkedList llist2 = new LinkedList(); 
      
        LinkedList intersecn = new LinkedList(); 
  
       
        llist1.push(6); 
        llist1.push(4); 
        llist1.push(2); 
        llist1.push(1); 
  
        llist2.push(6); 
        llist2.push(5); 
        llist2.push(4); 
        llist2.push(2); 
        llist2.push(1); 
  
        intersecn.getIntersection(llist1.head, llist2.head); 

        System.out.println("First List is"); 
        llist1.printList(); 
  
        System.out.println("Second List is"); 
        llist2.printList(); 

        System.out.println("Intersection List is"); 
        intersecn.printList();
      
        
    } 
} 


