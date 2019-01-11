
// Multiplication of two polynomials using Linked list


import java.util.*; 
class Solution 
{ 

// Node structure containing powerer 
// and coefficient of variable 
static class Node { 
	int coeff, power; 
	Node next; 
}; 

// Function add a new node at the end of list 
static Node addnode(Node start, int coeff, int power) 
{ 
	// Create a new node 
	Node newnode = new Node(); 
	newnode.coeff = coeff; 
	newnode.power = power; 
	newnode.next = null; 

	// If linked list is empty 
	if (start == null) 
		return newnode; 

	// If linked list has nodes 
	Node ptr = start; 
	while (ptr.next != null) 
		ptr = ptr.next; 
	ptr.next = newnode; 

	return start; 
} 

// Functionn To Display The Linked list 
static void printList( Node ptr) 
{ 
	while (ptr.next != null) { 
		System.out.print( ptr.coeff + "x^" + ptr.power + " + "); 

		ptr = ptr.next; 
	} 
	System.out.print( ptr.coeff +"\n"); 
} 

// Function to add coefficients of 
// two elements having same powerer 
static void removeDuplicates(Node start) 
{ 
	Node ptr1, ptr2, dup; 
	ptr1 = start; 

	/* Pick elements one by one */
	while (ptr1 != null && ptr1.next != null) { 
		ptr2 = ptr1; 

		// Compare the picked element 
		// with rest of the elements 
		while (ptr2.next != null) { 

			// If powerer of two elements are same 
			if (ptr1.power == ptr2.next.power) { 

				// Add their coefficients and put it in 1st element 
				ptr1.coeff = ptr1.coeff + ptr2.next.coeff; 
				dup = ptr2.next; 
				ptr2.next = ptr2.next.next; 

			} 
			else
				ptr2 = ptr2.next; 
		} 
		ptr1 = ptr1.next;       
	} 
} 

// Function two Multiply two polynomial Numbers 
static Node multiply(Node poly1, Node poly2, 
			Node poly3) 
{ 

	// Create two pointer and store the 
	// address of 1st and 2nd polynomials 
	Node ptr1, ptr2; 
	ptr1 = poly1; 
	ptr2 = poly2; 
	while (ptr1 != null) { 
		while (ptr2 != null) { 
			int coeff, power; 

			// Multiply the coefficient of both 
			// polynomials and store it in coeff 
			coeff = ptr1.coeff * ptr2.coeff; 

			// Add the powerer of both polynomials 
			// and store it in power 
			power = ptr1.power + ptr2.power; 

			// Invoke addnode function to create 
			// a newnode by passing three parameters 
			poly3 = addnode(poly3, coeff, power); 

			// move the pointer of 2nd polynomial 
			// two get its next term 
			ptr2 = ptr2.next; 
		} 

		// Move the 2nd pointer to the 
		// starting point of 2nd polynomial 
		ptr2 = poly2; 

		// move the pointer of 1st polynomial 
		ptr1 = ptr1.next; 
	} 

	// this function will be invoke to add 
	// the coefficient of the elements 
	// having same powerer from the resultant linked list 
	removeDuplicates(poly3); 
	return poly3; 
} 

// Driver Code 
public static void main(String args[]) 
{ 

	Node poly1 = null, poly2 = null, poly3 = null; 

	// Creation of 1st Polynomial: 3x^2 + 5x^1 + 6 
	poly1 = addnode(poly1, 3, 2); 
	poly1 = addnode(poly1, 5, 1); 
	poly1 = addnode(poly1, 6, 0); 

	// Creation of 2nd polynomial: 6x^1 + 8 
	poly2 = addnode(poly2, 6, 1); 
	poly2 = addnode(poly2, 8, 0); 

	// Displaying 1st polynomial 
	System.out.print("1st Polynomial:- "); 
	printList(poly1); 

	// Displaying 2nd polynomial 
	System.out.print("2nd Polynomial:- "); 
	printList(poly2); 

	// calling multiply function 
	poly3 = multiply(poly1, poly2, poly3); 

	// Displaying Resultant Polynomial 
	System.out.print( "Resultant Polynomial:- "); 
	printList(poly3); 

} 


} 
 


/*import java.util.*;
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
*/
