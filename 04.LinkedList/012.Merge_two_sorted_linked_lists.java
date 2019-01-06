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
      
class MergeLists  
{ 
   Node head;  
   public void addToTheLast(Node node)   
   { 
     if (head == null) 
      { 
        head = node; 
      } 
    else 
    { 
        Node temp = head; 
        while (temp.next != null) 
            temp = temp.next; 
        temp.next = node; 
    } 
   } 
   Node sortedMerge(Node a,Node b){
       Node result =null;
       
       if(a==null)
        return b;
       if(b==null)
        return a;
       
        if(a.data<=b.data){
         result=a;
         result.next=sortedMerge(a.next,b);
        }
       else{
          result=b;
          result.next=sortedMerge(a,b.next);
        }
       return result;    
    } 

   void printList() 
    { 
      Node temp = head; 
      while (temp != null) 
      { 
        System.out.print(temp.data + " "); 
        temp = temp.next; 
      }  
      System.out.println(); 
   } 
  
  
   public static void main(String args[]){ 
    
    MergeLists llist1 = new MergeLists(); 
    MergeLists llist2 = new MergeLists(); 
      MergeLists llist3 = new MergeLists(); 
      
     
    llist1.addToTheLast(new Node(5)); 
    llist1.addToTheLast(new Node(10)); 
    llist1.addToTheLast(new Node(15)); 
      
    
    llist2.addToTheLast(new Node(2)); 
    llist2.addToTheLast(new Node(3)); 
    llist2.addToTheLast(new Node(20)); 
      
      
    llist3.head =llist3 .sortedMerge(llist1.head,  
                                        llist2.head); 
    llist3.printList();      
      
   } 
} 
  
