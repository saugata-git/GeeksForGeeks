//Length of longest palindrome list in a linked list using O(1) extra space
//Time Complexity : O(n^2)
class LinkedList{

    static Node head;
    static class Node{
       int data;
       Node next;
    
       Node(int d){
         data=d;
         next =null;
       }
    }
   public static int max_n(int x,int y){
  
          if(x>y)
            return x;
          else 
            return y;
       }


   public static boolean bool(Node node){
    if(node!=null)
     return true;
    else
      return false;
   }

// function for counting the common elements
   public static int countCommon(Node a,Node b){
     int count =0;
     // loop to count coomon in the list starting  from node a and b 
     for(;bool(a) &&bool(b);a=a.next,b=b.next){
          
      // increment the count for same values
       if(a.data==b.data)
         count++;
       else
          break;

     }
     return count;
   }
     
   //Returns length of the longest palindrome  sublist in given list   
   public static int maxPalindrome(Node node){
      int result=0;
      Node prev=null,curr=node;
        
      // loop till the end of the linked list 
      while(curr!=null){
           
        // The sublist from head to current reversed.      
          Node next=curr.next;
          curr.next=prev;

           
          // check for odd length palindrome  by finding longest common list elements 
          // beginning from prev and from next (We  exclude curr)  
          result=max_n(result,2*countCommon(prev,next)+1);
           
          // check for even length palindrome by finding longest common list elements 
          // beginning from curr and from next 
          result=max_n(result,2*countCommon(curr,next));
 
       // update prev and curr for next iteration 
       prev=curr;
       curr=next;

     }
    return result;
   }

   void printList(Node node){
        while(node!=null){
        System.out.print(node.data+" ");
        node=node.next;
        }
     }
     


   public static void main(String args[]){

    LinkedList list =new LinkedList();
    

        list.head = new Node(85); 
        list.head.next = new Node(15); 
        list.head.next.next = new Node(4); 
        list.head.next.next.next = new Node(20); 
          
        System.out.println("Given Linked list"); 
        list.printList(head); 
        System.out.println("Length of longest plaindrome is : "+  maxPalindrome(head));
   } 

}

/* //program 2:
//Length of longest palindrome list in a linked list using array list in java  storing the data in an array then find the palindrome.  
import java.util.*;
class LinkedList{

     static Node head;
     static class Node{
       int data;
       Node next;
     
       Node(int d){
        data=d;
        next=null;
       }
     }

     void printList(Node node){
        while(node!=null){
        System.out.print(node.data+" ");
        node=node.next;
        }
     }
    void printList_2(Node node,int n ){
        int count=0;
        while(node!=null){
        System.out.print(node.data+" ");
        node=node.next;
        count++;
        if(count==n)
          break;
        }
     }

     void push(int new_data){
    
       Node new_node =new Node(new_data);
       new_node.next=head;
       head=new_node;
     }

   
    public static int maxPalindrome(Node node){

     ArrayList<Integer>a= new ArrayList<>();
       while(node!=null){
       a.add(node.data);
       node=node.next;
       }
       int n=a.size();
       int max=0;
       for(int i=0;i<n;i++){
           ArrayList<Integer>s=new ArrayList<>();
           for(int j=i;j<n;j++){
              s.add(a.get(j));
              
              if(palin(s)&&s.size()>max)
              max=s.size();  
           }  
         System.out.println(s);
       }             
       return max;
    } 
    public static boolean palin(ArrayList<Integer>a)
    {
      int n=a.size();
      for(int i=0;i<n;i++){
         if(a.get(i)!=a.get(n-1-i))
           return false;
      }
      return true;

    }
    public static void main(String args[]) 
    { 
        LinkedList llist1 = new LinkedList(); 
       
       
        llist1.push(5); 
        llist1.push(4);
        llist1.push(4);

        System.out.println("LinkedList List is:"); 
        llist1.printList(head); 
         System.out.println();
       
       int maxx=llist1.maxPalindrome(head);
        System.out.println(maxx);
     
   }
        
   
}*/
