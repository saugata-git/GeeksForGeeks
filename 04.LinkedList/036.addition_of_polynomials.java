// Java implementation of above approach 
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
static Node addition(Node poly1, Node poly2, 
			Node poly3) 
{ 

	// Create two pointer and store the 
	// address of 1st and 2nd polynomials 
	Node ptr1, ptr2; 
	ptr1 = poly1; 
	ptr2 = poly2; 
          

   

 boolean contains=false;
	while (ptr1 != null ) { 
		while (ptr2 != null) { 
			int coeff, power;  
             if(ptr1.power==ptr2.power){
        
	        		coeff = ptr1.coeff + ptr2.coeff; 			
			        poly3 = addnode(poly3, coeff,ptr1.power);          
              }
                          ptr2 = ptr2.next;  		 
		   } 
      if(!contains) {
                      poly3 = addnode(poly3, ptr1.coeff,ptr1.power);

                }
      else{
                contains=false;   
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
	poly3 = addition(poly1, poly2, poly3); 

	// Displaying Resultant Polynomial 
	System.out.print( "Resultant Polynomial:- "); 
	printList(poly3); 

} 


} 
 
