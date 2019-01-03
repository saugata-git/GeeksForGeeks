class LinkedList  
{ 
    Node head;   
    Node left; 
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
  
    boolean isPalindromeUtil(Node right)  
    { 
       left=head;
       if(right==null)
         return true;
       boolean isp = isPalindromeUtil(right.next);
       if(isp==false)
         return false;
       boolean isp1=(left.data==right.data);
       left=left.next;
       return isp1;
    } 

    boolean isPalindrome()  
    { 
        boolean result = isPalindromeUtil(head); 
        return result; 
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

    public static void main(String args[]) 
    { 
        LinkedList llist1 = new LinkedList(); 
  
        llist1.push(1); 
        llist1.push(4); 
        llist1.push(4); 
        llist1.push(1); 
  
       
        System.out.println("LinkedList List is:"); 
        llist1.printList(); 
        System.out.println(llist1.isPalindrome());
 
        
    } 
}


  
