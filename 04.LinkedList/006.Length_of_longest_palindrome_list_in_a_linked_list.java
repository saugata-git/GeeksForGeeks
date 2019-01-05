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
        
   
}
