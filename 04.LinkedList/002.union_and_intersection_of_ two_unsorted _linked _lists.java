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
  
    
    void getUnion(Node head1, Node head2) 
    { 
        Node t1 = head1, t2 = head2; 
        while (t1 != null) 
        { 
            push(t1.data); 
            t1 = t1.next; 
        }
        while (t2 != null) 
        { 
            if (!isPresent(head, t2.data)) 
                push(t2.data); 
            t2 = t2.next; 
        } 
    } 
  
    void getIntersection(Node head1, Node head2) 
    {
        Node t1 = head1;   
        while (t1 != null) 
        { 
            if (isPresent(head2, t1.data)) 
                push(t1.data); 
            t1 = t1.next; 
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
  
  
 
    boolean isPresent (Node head, int data) 
    { 
        Node t = head; 
        while (t != null) 
        { 
            if (t.data == data) 
                return true; 
            t = t.next; 
        } 
        return false; 
    } 
  
  
 
    public static void main(String args[]) 
    { 
        LinkedList llist1 = new LinkedList(); 
        LinkedList llist2 = new LinkedList(); 
        LinkedList unin = new LinkedList(); 
        LinkedList intersecn = new LinkedList(); 
  
        /*create a linked lits 10->15->5->20 */
        llist1.push(20); 
        llist1.push(4); 
        llist1.push(15); 
        llist1.push(10); 
  
        /*create a linked lits 8->4->2->10 */
        llist2.push(10); 
        llist2.push(2); 
        llist2.push(4); 
        llist2.push(8); 
  
        intersecn.getIntersection(llist1.head, llist2.head); 
        unin.getUnion(llist1.head, llist2.head); 
  
        System.out.println("First List is"); 
        llist1.printList(); 
  
        System.out.println("Second List is"); 
        llist2.printList(); 
  
        System.out.println("Intersection List is"); 
        intersecn.printList(); 
  
        System.out.println("Union List is"); 
        unin.printList(); 
    } 
} 
