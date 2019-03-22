//Java program to remove duplicates
//Time Complexity: O(n)
import java.util.*;

class RemoveDuplicates{

   public static void removeDuplicates(String str){
    
     LinkedHashSet<Character> lhs= new LinkedHashSet<>();
     for(int i=0;i<str.length();i++)
           lhs.add(str.charAt(i));
     for(Character ch: lhs)
         System.out.print(ch);
   }

   public static void main(String args[]){
     String str="geeksforgeeks";
     removeDuplicates(str);
   }
}
