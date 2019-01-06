
class LinkedList{
    static Node head;
    static class Node{
        String data;
        Node next;
        Node(String d){
          data=d;
          next=null;
        }
    }
   
    boolean isPalindromeUtil(String str){
     int length=str.length();
       for (int i=0; i<length/2; i++) 
            if (str.charAt(i) != str.charAt(length-i-1)) 
                return false; 
        return true; 
    }

  public static String concat_s(String str, String str_data){

      char[] charArraystr = str.toCharArray();
      char[] charArraystr_data = str_data.toCharArray();
        
      int n=str.length();
      int m=str_data.length();
      int x=m+n;
      char[] char1 = new char[x];

    
    int i, j;   
    for(i = 0; i<n; ++i){
             char1[i]=charArraystr[i];
    }
   
    for(j = 0; j<m; ++j, ++i)
    {
        char1[i] = charArraystr_data[j];
    }   
     
    String outputString = new String(char1);
    return outputString;
   }


   boolean isPalindrome(Node node){
    String str="";
    while(node!=null){
       str=concat_s(str,node.data);
       //str=str.concat(node.data);
       node=node.next;
    }
     return isPalindromeUtil(str);
   }
   public static void main(String[] args) 
    { 
        LinkedList list = new LinkedList(); 
        list.head = new Node("a"); 
        list.head.next = new Node("bc"); 
        list.head.next.next = new Node("d"); 
        list.head.next.next.next = new Node("dcb"); 
        list.head.next.next.next.next = new Node("a"); 
  
        System.out.println(list.isPalindrome(head)); 
  
    } 
} 
