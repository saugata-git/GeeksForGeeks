 
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
 
    void countNodes(Node n){
    int res = 1; 
    Node temp = n; 
   while (temp.next != n) 
   { 
      res++; 
      temp = temp.next; 
   } 
   System.out.println("Length of Loop : "+ res); 
    
    }
 
  
    // Function that detects loop in the list 
    void detectAndRemoveLoop(Node node) { 
  
        // If list is empty or has only one node 
        // without loop 
        if (node == null || node.next == null) 
            return; 
  
        Node slow = node, fast = node; 
  
        // Move slow and fast 1 and 2 steps 
        // ahead respectively. 
        slow = slow.next; 
        fast = fast.next.next; 
  
        // Search for loop using slow and fast pointers 
        while (fast != null && fast.next != null) { 
            if (slow == fast){
                countNodes(slow);
                break; }
              
            slow = slow.next; 
            fast = fast.next.next; 
        } 
  
        /* If loop exists */
        if (slow == fast) { 
            slow = node; 
            while (slow.next != fast.next) { 
                slow = slow.next; 
                fast = fast.next; 
            } 
  
            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
        } 
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
        list.detectAndRemoveLoop(head); 
        System.out.println("Linked List after removing loop : "); 
        list.printList(head); 
    } 
} 
/*int removeTheLoop(Node node) {
        //add code here.
    Node fast = node;
    Node slow = node;
     
     while(fast != null && slow != null && fast.next != null){
         slow = slow.next;
         fast = fast.next.next;
         
         if(slow == fast){
             fast.next = null;
             return 1;
         }


*/
